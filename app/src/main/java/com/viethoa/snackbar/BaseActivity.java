package com.viethoa.snackbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import viethoa.com.snackbar.BottomSnackBarMessage;
import viethoa.com.snackbar.TopSnackBarMessage;

/**
 * Created by VietHoa on 01/06/16.
 */
public class BaseActivity extends AppCompatActivity {
    private TopSnackBarMessage topSnackBarMessage;
    private BottomSnackBarMessage bottomSnackBarMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        topSnackBarMessage = new TopSnackBarMessage(this);
        bottomSnackBarMessage = new BottomSnackBarMessage(this);
    }

    //----------------------------------------------------------------------------------------------
    // Top SnackBar Notification Messages
    //----------------------------------------------------------------------------------------------

    protected void showTopErrorMessage(int messageRes) {
        topSnackBarMessage.showErrorMessage(messageRes);
    }

    protected void showTopWarningMessage(int messageRes) {
        topSnackBarMessage.showWarningMessage(messageRes);
    }

    protected void showTopSuccessMessage(int messageRes) {
        topSnackBarMessage.showSuccessMessage(messageRes);
    }

    protected void showTopErrorMessage(String messageRes) {
        topSnackBarMessage.showErrorMessage(messageRes);
    }

    protected void showTopWarningMessage(String messageRes) {
        topSnackBarMessage.showWarningMessage(messageRes);
    }

    protected void showTopSuccessMessage(String messageRes) {
        topSnackBarMessage.showSuccessMessage(messageRes);
    }

    protected void showTopErrorMessageCloseable(int messageRes) {
        topSnackBarMessage.showErrorMessageCloseable(messageRes);
    }

    protected void showTopWarningMessageCloseable(int messageRes) {
        topSnackBarMessage.showWarningMessageCloseable(messageRes);
    }

    protected void showTopSuccessMessageCloseable(int messageRes) {
        topSnackBarMessage.showSuccessMessageCloseable(messageRes);
    }

    protected void showTopErrorMessageCloseable(String messageRes) {
        topSnackBarMessage.showErrorMessageCloseable(messageRes);
    }

    protected void showTopWarningMessageCloseable(String messageRes) {
        topSnackBarMessage.showWarningMessageCloseable(messageRes);
    }

    protected void showTopSuccessMessageCloseable(String messageRes) {
        topSnackBarMessage.showSuccessMessageCloseable(messageRes);
    }

    //----------------------------------------------------------------------------------------------
    // Bottom SnackBar Notification Messages
    //----------------------------------------------------------------------------------------------

    protected void showBottomErrorMessage(int messageRes) {
        bottomSnackBarMessage.showErrorMessage(messageRes);
    }

    protected void showBottomWarningMessage(int messageRes) {
        bottomSnackBarMessage.showWarningMessage(messageRes);
    }

    protected void showBottomSuccessMessage(int messageRes) {
        bottomSnackBarMessage.showSuccessMessage(messageRes);
    }

    protected void showBottomErrorMessage(String messageRes) {
        bottomSnackBarMessage.showErrorMessage(messageRes);
    }

    protected void showBottomWarningMessage(String messageRes) {
        bottomSnackBarMessage.showWarningMessage(messageRes);
    }

    protected void showBottomSuccessMessage(String messageRes) {
        bottomSnackBarMessage.showSuccessMessage(messageRes);
    }

    protected void showBottomErrorMessageCloseable(int messageRes) {
        bottomSnackBarMessage.showErrorMessage(messageRes);
    }

    protected void showBottomWarningMessageCloseable(int messageRes) {
        bottomSnackBarMessage.showWarningMessage(messageRes);
    }

    protected void showBottomSuccessMessageCloseable(int messageRes) {
        bottomSnackBarMessage.showSuccessMessageCloseable(messageRes);
    }

    protected void showBottomErrorMessageCloseable(String messageRes) {
        bottomSnackBarMessage.showErrorMessageCloseable(messageRes);
    }

    protected void showBottomWarningMessageCloseable(String messageRes) {
        bottomSnackBarMessage.showWarningMessageCloseable(messageRes);
    }

    protected void showBottomSuccessMessageCloseable(String messageRes) {
        bottomSnackBarMessage.showSuccessMessageCloseable(messageRes);
    }

}
