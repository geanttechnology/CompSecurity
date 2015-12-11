// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.sessionm.ui:
//            SessionMViewContainer

private class <init> extends WebChromeClient
{

    final SessionMViewContainer this$0;

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        if (Log.isLoggable("SessionM.WebView", 3))
        {
            Log.d("SessionM.WebView", String.format("Line : %s  message %s", new Object[] {
                Integer.valueOf(consolemessage.lineNumber()), consolemessage.message()
            }));
        }
        return true;
    }

    public void onGeolocationPermissionsShowPrompt(String s, android.webkit. )
    {
        .(s, true, false);
    }

    public void onHideCustomView()
    {
        executeJavascript("GreyhoundEventDispatcher.dispatch('notify-view-hidden','view was hidden');");
    }

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        SessionMViewContainer.access$502(SessionMViewContainer.this, jsresult);
        webview = new android.app.ent.this._cls0(SessionMViewContainer.access$400(SessionMViewContainer.this));
        webview._mth0(s1);
        webview._mth0("Alert");
        webview._mth0("OK", new android.content.DialogInterface.OnClickListener() {

            final SessionMViewContainer.MyWebChromeClient this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (SessionMViewContainer.access$500(this$0) != null)
                {
                    SessionMViewContainer.access$500(this$0).confirm();
                    SessionMViewContainer.access$502(this$0, null);
                }
            }

            
            {
                this$1 = SessionMViewContainer.MyWebChromeClient.this;
                super();
            }
        });
        webview.ent();
        return true;
    }

    public void onProgressChanged(WebView webview, int i)
    {
        SessionMViewContainer.access$400(SessionMViewContainer.this).getWindow().setFeatureInt(2, i * 100);
    }

    public void onShowCustomView(View view, android.webkit. )
    {
        executeJavascript("GreyhoundEventDispatcher.dispatch('notify-view-shown','view was overlayed');");
    }

    public void openFileChooser(ValueCallback valuecallback)
    {
        if (SessionMViewContainer.access$300(SessionMViewContainer.this) != null)
        {
            SessionMViewContainer.access$300(SessionMViewContainer.this).onValueCallback(SessionMViewContainer.this, valuecallback);
        }
        valuecallback = new Intent("android.intent.action.GET_CONTENT");
        valuecallback.addCategory("android.intent.category.OPENABLE");
        valuecallback.setType("image/*");
        valuecallback = Intent.createChooser(valuecallback, "File Chooser");
        SessionMViewContainer.access$400(SessionMViewContainer.this).startActivityForResult(valuecallback, 1);
    }

    public void openFileChooser(ValueCallback valuecallback, String s)
    {
        openFileChooser(valuecallback);
    }

    public void openFileChooser(ValueCallback valuecallback, String s, String s1)
    {
        openFileChooser(valuecallback);
    }

    private _cls1.this._cls1()
    {
        this$0 = SessionMViewContainer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
