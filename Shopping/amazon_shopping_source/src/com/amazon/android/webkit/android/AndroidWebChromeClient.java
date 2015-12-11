// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.amazon.android.webkit.AmazonConsoleMessage;
import com.amazon.android.webkit.AmazonJsPromptResult;
import com.amazon.android.webkit.AmazonJsResult;
import com.amazon.android.webkit.AmazonValueCallback;
import com.amazon.android.webkit.AmazonWebChromeClient;
import com.amazon.android.webkit.AmazonWebView;

public class AndroidWebChromeClient extends WebChromeClient
{

    private final AmazonWebChromeClient client;
    private final AmazonWebView webview;

    public AndroidWebChromeClient(AmazonWebView amazonwebview, AmazonWebChromeClient amazonwebchromeclient)
    {
        webview = amazonwebview;
        client = amazonwebchromeclient;
    }

    private AmazonConsoleMessage convertConsoleMessage(ConsoleMessage consolemessage)
    {
        return new AmazonConsoleMessage(consolemessage.message(), consolemessage.sourceId(), consolemessage.lineNumber(), convertMessageLevel(consolemessage.messageLevel()));
    }

    private AmazonJsPromptResult convertJsPromptResult(final JsPromptResult jsPromptResult)
    {
        return new AmazonJsPromptResult() {

            final AndroidWebChromeClient this$0;
            final JsPromptResult val$jsPromptResult;

            
            {
                this$0 = AndroidWebChromeClient.this;
                jsPromptResult = jspromptresult;
                super();
            }
        };
    }

    private AmazonJsResult convertJsResult(final JsResult jsResult)
    {
        return new AmazonJsResult() {

            final AndroidWebChromeClient this$0;
            final JsResult val$jsResult;

            
            {
                this$0 = AndroidWebChromeClient.this;
                jsResult = jsresult;
                super();
            }
        };
    }

    private com.amazon.android.webkit.AmazonConsoleMessage.MessageLevel convertMessageLevel(android.webkit.ConsoleMessage.MessageLevel messagelevel)
    {
        static class _cls10
        {

            static final int $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[];

            static 
            {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel = new int[android.webkit.ConsoleMessage.MessageLevel.values().length];
                try
                {
                    $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[android.webkit.ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[android.webkit.ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[android.webkit.ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[android.webkit.ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[android.webkit.ConsoleMessage.MessageLevel.WARNING.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls10..SwitchMap.android.webkit.ConsoleMessage.MessageLevel[messagelevel.ordinal()])
        {
        default:
            throw new RuntimeException((new StringBuilder()).append("Unexpected level: ").append(messagelevel).toString());

        case 1: // '\001'
            return com.amazon.android.webkit.AmazonConsoleMessage.MessageLevel.ERROR;

        case 2: // '\002'
            return com.amazon.android.webkit.AmazonConsoleMessage.MessageLevel.DEBUG;

        case 3: // '\003'
            return com.amazon.android.webkit.AmazonConsoleMessage.MessageLevel.LOG;

        case 4: // '\004'
            return com.amazon.android.webkit.AmazonConsoleMessage.MessageLevel.TIP;

        case 5: // '\005'
            return com.amazon.android.webkit.AmazonConsoleMessage.MessageLevel.WARNING;
        }
    }

    public Bitmap getDefaultVideoPoster()
    {
        return client.getDefaultVideoPoster();
    }

    public View getVideoLoadingProgressView()
    {
        return client.getVideoLoadingProgressView();
    }

    public void getVisitedHistory(final ValueCallback callback)
    {
        callback = new AmazonValueCallback() {

            final AndroidWebChromeClient this$0;
            final ValueCallback val$callback;

            public volatile void onReceiveValue(Object obj)
            {
                onReceiveValue((String[])obj);
            }

            public void onReceiveValue(String as[])
            {
                callback.onReceiveValue(as);
            }

            
            {
                this$0 = AndroidWebChromeClient.this;
                callback = valuecallback;
                super();
            }
        };
        client.getVisitedHistory(callback);
    }

    public void onCloseWindow(WebView webview1)
    {
        client.onCloseWindow(webview);
    }

    public void onConsoleMessage(String s, int i, String s1)
    {
        client.onConsoleMessage(s, i, s1);
    }

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        client.onConsoleMessage(convertConsoleMessage(consolemessage));
        return false;
    }

    public boolean onCreateWindow(WebView webview1, boolean flag, boolean flag1, final Message resultMsg)
    {
        webview1 = new com.amazon.android.webkit.AmazonWebChromeClient.OnCreateWindowCallback() {

            final AndroidWebChromeClient this$0;
            final Message val$resultMsg;

            
            {
                this$0 = AndroidWebChromeClient.this;
                resultMsg = message;
                super();
            }
        };
        return client.onCreateWindow(webview, flag, flag1, new Bundle(), webview1);
    }

    public void onExceededDatabaseQuota(String s, String s1, long l, long l1, long l2, final android.webkit.WebStorage.QuotaUpdater quotaUpdater)
    {
        quotaUpdater = new com.amazon.android.webkit.AmazonWebStorage.QuotaUpdater() {

            final AndroidWebChromeClient this$0;
            final android.webkit.WebStorage.QuotaUpdater val$quotaUpdater;

            
            {
                this$0 = AndroidWebChromeClient.this;
                quotaUpdater = quotaupdater;
                super();
            }
        };
        client.onExceededDatabaseQuota(s, s1, l, l1, l2, quotaUpdater);
    }

    public void onGeolocationPermissionsHidePrompt()
    {
        client.onGeolocationPermissionsHidePrompt();
    }

    public void onGeolocationPermissionsShowPrompt(String s, final android.webkit.GeolocationPermissions.Callback callback)
    {
        callback = new com.amazon.android.webkit.AmazonGeolocationPermissions.Callback() {

            final AndroidWebChromeClient this$0;
            final android.webkit.GeolocationPermissions.Callback val$callback;

            
            {
                this$0 = AndroidWebChromeClient.this;
                callback = callback1;
                super();
            }
        };
        client.onGeolocationPermissionsShowPrompt(s, callback);
    }

    public void onHideCustomView()
    {
        client.onHideCustomView();
    }

    public boolean onJsAlert(WebView webview1, String s, String s1, JsResult jsresult)
    {
        return client.onJsAlert(webview, s, s1, convertJsResult(jsresult));
    }

    public boolean onJsBeforeUnload(WebView webview1, String s, String s1, JsResult jsresult)
    {
        return client.onJsBeforeUnload(webview, s, s1, convertJsResult(jsresult));
    }

    public boolean onJsConfirm(WebView webview1, String s, String s1, JsResult jsresult)
    {
        return client.onJsConfirm(webview, s, s1, convertJsResult(jsresult));
    }

    public boolean onJsPrompt(WebView webview1, String s, String s1, String s2, JsPromptResult jspromptresult)
    {
        return client.onJsPrompt(webview, s, s1, s2, convertJsPromptResult(jspromptresult));
    }

    public boolean onJsTimeout()
    {
        return client.onJsTimeout();
    }

    public void onProgressChanged(WebView webview1, int i)
    {
        client.onProgressChanged(webview, i);
    }

    public void onReachedMaxAppCacheSize(long l, long l1, final android.webkit.WebStorage.QuotaUpdater quotaUpdater)
    {
        quotaUpdater = new com.amazon.android.webkit.AmazonWebStorage.QuotaUpdater() {

            final AndroidWebChromeClient this$0;
            final android.webkit.WebStorage.QuotaUpdater val$quotaUpdater;

            
            {
                this$0 = AndroidWebChromeClient.this;
                quotaUpdater = quotaupdater;
                super();
            }
        };
        client.onReachedMaxAppCacheSize(l, l1, quotaUpdater);
    }

    public void onReceivedIcon(WebView webview1, Bitmap bitmap)
    {
        client.onReceivedIcon(webview, bitmap);
    }

    public void onReceivedTitle(WebView webview1, String s)
    {
        client.onReceivedTitle(webview, s);
    }

    public void onReceivedTouchIconUrl(WebView webview1, String s, boolean flag)
    {
        client.onReceivedTouchIconUrl(webview, s, flag);
    }

    public void onRequestFocus(WebView webview1)
    {
        client.onRequestFocus(webview);
    }

    public void onShowCustomView(View view, final android.webkit.WebChromeClient.CustomViewCallback callback)
    {
        callback = new com.amazon.android.webkit.AmazonWebChromeClient.CustomViewCallback() {

            final AndroidWebChromeClient this$0;
            final android.webkit.WebChromeClient.CustomViewCallback val$callback;

            
            {
                this$0 = AndroidWebChromeClient.this;
                callback = customviewcallback;
                super();
            }
        };
        client.onShowCustomView(view, callback);
    }
}
