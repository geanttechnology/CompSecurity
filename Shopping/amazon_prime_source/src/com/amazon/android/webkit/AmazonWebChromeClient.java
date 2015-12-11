// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

// Referenced classes of package com.amazon.android.webkit:
//            AmazonSavePasswordCallback, AmazonValueCallback, AmazonWebView, AmazonConsoleMessage, 
//            AmazonDocumentLoadTimes, AmazonJsResult, AmazonJsPromptResult, AmazonAutofillSuggestion, 
//            AmazonWebTimings, AmazonWebViewMetrics

public class AmazonWebChromeClient
{
    public static interface CustomViewCallback
    {

        public abstract void onCustomViewHidden();
    }

    public static interface OnCreateWindowCallback
    {

        public abstract void allow(AmazonWebView amazonwebview);

        public abstract void disallow();
    }


    public AmazonWebChromeClient()
    {
    }

    public Bitmap getDefaultVideoPoster()
    {
        return null;
    }

    public View getVideoLoadingProgressView()
    {
        return null;
    }

    public void getVisitedHistory(AmazonValueCallback amazonvaluecallback)
    {
    }

    public void onCloseWindow(AmazonWebView amazonwebview)
    {
    }

    public void onConsoleMessage(String s, int i, String s1)
    {
    }

    public boolean onConsoleMessage(AmazonConsoleMessage amazonconsolemessage)
    {
        return false;
    }

    public void onContentsReplaced(AmazonWebView amazonwebview)
    {
    }

    public boolean onCreateWindow(AmazonWebView amazonwebview, boolean flag, boolean flag1, Bundle bundle, OnCreateWindowCallback oncreatewindowcallback)
    {
        return false;
    }

    public void onDocumentLoadTimes(AmazonWebView amazonwebview, AmazonDocumentLoadTimes amazondocumentloadtimes)
    {
    }

    public void onExceededDatabaseQuota(String s, String s1, long l, long l1, long l2, AmazonWebStorage.QuotaUpdater quotaupdater)
    {
    }

    public void onGeolocationPermissionsHidePrompt()
    {
    }

    public void onGeolocationPermissionsShowPrompt(String s, AmazonGeolocationPermissions.Callback callback)
    {
    }

    public void onHideAutofillPopup(AmazonWebView amazonwebview)
    {
    }

    public void onHideCustomView()
    {
    }

    public void onInsecureContent(AmazonWebView amazonwebview, String s, boolean flag)
    {
    }

    public boolean onJsAlert(AmazonWebView amazonwebview, String s, String s1, AmazonJsResult amazonjsresult)
    {
        return false;
    }

    public boolean onJsBeforeUnload(AmazonWebView amazonwebview, String s, String s1, AmazonJsResult amazonjsresult)
    {
        return false;
    }

    public boolean onJsConfirm(AmazonWebView amazonwebview, String s, String s1, AmazonJsResult amazonjsresult)
    {
        return false;
    }

    public boolean onJsPrompt(AmazonWebView amazonwebview, String s, String s1, String s2, AmazonJsPromptResult amazonjspromptresult)
    {
        return false;
    }

    public boolean onJsTimeout()
    {
        return false;
    }

    public void onMediaDevicePermissionsShowPrompt(String s, AmazonMediaDeviceSettings.Callback callback)
    {
    }

    public void onProgressChanged(AmazonWebView amazonwebview, int i)
    {
    }

    public void onReachedMaxAppCacheSize(long l, long l1, AmazonWebStorage.QuotaUpdater quotaupdater)
    {
    }

    public void onReceivedIcon(AmazonWebView amazonwebview, Bitmap bitmap)
    {
    }

    public void onReceivedTitle(AmazonWebView amazonwebview, String s)
    {
    }

    public void onReceivedTouchIconUrl(AmazonWebView amazonwebview, String s, boolean flag)
    {
    }

    public void onRequestFocus(AmazonWebView amazonwebview)
    {
    }

    public void onSavePassword(AmazonWebView amazonwebview, AmazonSavePasswordCallback amazonsavepasswordcallback)
    {
        amazonsavepasswordcallback.notNow();
    }

    public void onSelectionDone(AmazonWebView amazonwebview)
    {
    }

    public void onSelectionStart(AmazonWebView amazonwebview)
    {
    }

    public void onShowAutofillPopup(AmazonWebView amazonwebview, Rect rect, AmazonAutofillSuggestion aamazonautofillsuggestion[])
    {
    }

    public void onShowCustomView(View view, CustomViewCallback customviewcallback)
    {
    }

    public void onWebTimings(AmazonWebView amazonwebview, AmazonWebTimings amazonwebtimings)
    {
    }

    public void onWebViewMetrics(AmazonWebView amazonwebview, AmazonWebViewMetrics amazonwebviewmetrics)
    {
    }

    public void onWebViewResponsive(AmazonWebView amazonwebview)
    {
    }

    public void onWebViewTerminated(AmazonWebView amazonwebview, int i)
    {
    }

    public void onWebViewUnresponsive(AmazonWebView amazonwebview)
    {
    }

    public void openFileChooser(AmazonValueCallback amazonvaluecallback, String s)
    {
        amazonvaluecallback.onReceiveValue(null);
    }

    public void toggleFullscreenModeForTab(boolean flag)
    {
    }
}
