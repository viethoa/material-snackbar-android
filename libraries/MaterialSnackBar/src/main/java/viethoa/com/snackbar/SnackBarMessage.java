package viethoa.com.snackbar;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import viethoa.com.snackbar.animations.BaseEffects;
import viethoa.com.snackbar.animations.SlideBottom;
import viethoa.com.snackbar.animations.SlideTop;

/**
 * Created by VietHoa on 21/05/16.
 */
public class SnackBarMessage<T extends SnackBar> implements BaseEffects.AnimationListener, SnackBar.SnackBarListener {
    private final String TAG = SnackBarMessage.class.getSimpleName();

    private Activity context;
    private Subscription timeInterval;
    private LinkedList<T> snackBarMessages;
    private ViewGroup.LayoutParams snackBarParams;
    private SnackBar currentShowingSnackBar;

    public SnackBarMessage(Activity activity) {
        context = activity;
        snackBarMessages = new LinkedList<>();
        snackBarParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
    }

    protected synchronized void showNotification(T snackBar) {
        snackBar.setListener(this);
        snackBarMessages.add(snackBar);
        if (currentShowingSnackBar != null && currentShowingSnackBar.isCloseable())
            return;

        startTimeInterval();
    }

    //----------------------------------------------------------------------------------------------
    // Time interval
    //----------------------------------------------------------------------------------------------

    private void startTimeInterval() {
        // Should run interval stage.
        if (timeInterval != null && !timeInterval.isUnsubscribed())
            return;

        //Log.d(TAG, "run interval");
        timeInterval = Observable.interval(100, TimeUnit.MILLISECONDS, Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long tick) {
                        performShowNotification(tick);
                    }
                });
    }

    private void performShowNotification(long tick) {
        //Log.d(TAG, "tick: " + tick);
        if (tick % (SnackBarConfig.TIME_INTERVAL / 100) != 0) {
            return;
        }
        if (snackBarMessages == null || snackBarMessages.size() <= 0) {
            stopNotificationInterval();
            return;
        }

        currentShowingSnackBar = snackBarMessages.poll();
        if (currentShowingSnackBar.isCloseable()) {
            stopNotificationInterval();
        }

        //Log.d(TAG, "show snack bar");
        showSnackBarMessage(currentShowingSnackBar);
    }

    private void stopNotificationInterval() {
        if (timeInterval == null || timeInterval.isUnsubscribed())
            return;

        //Log.d(TAG, "stop interval");
        timeInterval.unsubscribe();
        timeInterval = null;
    }

    //----------------------------------------------------------------------------------------------
    // Shower
    //----------------------------------------------------------------------------------------------

    public void showSnackBarMessage(SnackBar snackBar) {
        if (snackBar == null || context == null || context.isFinishing())
            return;

        // This Message is showing, should remove first.
        if (snackBar.getParent() != null)
            return;

        // Append snack bar view to window.
        context.addContentView(snackBar.getView(), snackBarParams);

        if (snackBar.isAnimationFromTop()) {        // Top snack bar animation
            SlideTop slideTop = new SlideTop();
            slideTop.setDuration(SnackBarConfig.ANIMATION);
            slideTop.setListener(this);
            slideTop.start(snackBar.getView());
        } else {                                    // Bottom snack bar animation
            SlideBottom slideBottom = new SlideBottom();
            slideBottom.setDuration(SnackBarConfig.ANIMATION);
            slideBottom.setListener(this);
            slideBottom.start(snackBar.getView());
        }
    }

    private void dismissSnackBarMessage(View viewGroup) {
        if (viewGroup == null)
            return;

        ViewGroup parent = (ViewGroup) viewGroup.getParent();
        if (parent == null)
            return;

        //Log.d(TAG, "remove snack from window");
        parent.removeView(viewGroup);
    }

    @Override
    public void onAnimationEnd(final View view) {
        if (view == null)
            return;
        if (currentShowingSnackBar != null && currentShowingSnackBar.isCloseable())
            return;

        // The delay time give user read notification message.
        // Subtract 100ms: for multiple messages => should close first before show new one.
        int delayTimeInterval = SnackBarConfig.TIME_INTERVAL - SnackBarConfig.ANIMATION - 100;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismissSnackBarMessage(view);
            }
        }, delayTimeInterval);
    }

    @Override
    public void OnBtnCloseClicked(View snackBar) {
        dismissSnackBarMessage(snackBar);
        currentShowingSnackBar = null;

        // should show next?
        if (snackBarMessages == null || snackBarMessages.size() <= 0)
            return;

        startTimeInterval();
    }
}
