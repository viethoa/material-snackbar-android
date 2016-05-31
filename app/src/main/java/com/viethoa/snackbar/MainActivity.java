package com.viethoa.snackbar;

import android.os.Bundle;

import java.util.Random;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_top_snack_bar)
    protected void TopSnackBar() {
        int number = new Random().nextInt();
        if (number % 5 == 0) {
            showTopErrorMessage("error message " + number);
        } else if (number % 3 == 0) {
            showTopWarningMessage("warning message " + number);
        } else {
            showTopSuccessMessage("success message " + number);
        }
    }

    @OnClick(R.id.btn_bottom_snack_bar)
    protected void BottomSnackBar() {
        int number = new Random().nextInt();
        if (number % 5 == 0) {
            showBottomErrorMessage("error message " + number);
        } else if (number % 3 == 0) {
            showBottomWarningMessage("warning message " + number);
        } else {
            showBottomSuccessMessage("success message " + number);
        }
    }

    @OnClick(R.id.btn_top_snack_bar_closeable)
    protected void TopSnackBarCloseable() {
        int number = new Random().nextInt();
        if (number % 5 == 0) {
            showTopErrorMessageCloseable("error message " + number);
        } else if (number % 3 == 0) {
            showTopWarningMessageCloseable("warning message " + number);
        } else {
            showTopSuccessMessageCloseable("success message " + number);
        }
    }

    @OnClick(R.id.btn_bottom_snack_bar_closeable)
    protected void BottomSnackBarCloseable() {
        int number = new Random().nextInt();
        if (number % 5 == 0) {
            showBottomErrorMessageCloseable("error message " + number);
        } else if (number % 3 == 0) {
            showBottomWarningMessageCloseable("warning message " + number);
        } else {
            showBottomSuccessMessageCloseable("success message " + number);
        }
    }
}
