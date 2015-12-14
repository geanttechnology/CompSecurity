// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.inmobi.commons.core.utilities.Logger;

// Referenced classes of package com.inmobi.rendering:
//            RenderView

class it> extends WebChromeClient
{

    final RenderView a;

    private void a()
    {
        if (RenderView.j(a) != null)
        {
            if (RenderView.k(a) != null)
            {
                RenderView.k(a).onCustomViewHidden();
                RenderView.a(a, null);
            }
            if (RenderView.j(a) != null && RenderView.j(a).getParent() != null)
            {
                ((ViewGroup)RenderView.j(a).getParent()).removeView(RenderView.j(a));
                RenderView.a(a, null);
                return;
            }
        }
    }

    private void a(View view, android.view.tener tener)
    {
        view.setOnKeyListener(tener);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }

    static void a(uchMode uchmode)
    {
        uchmode.a();
    }

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        consolemessage = (new StringBuilder()).append(consolemessage.message()).append(" -- From line ").append(consolemessage.lineNumber()).append(" of ").append(consolemessage.sourceId()).toString();
        Logger.a(com.inmobi.commons.core.utilities.alLogLevel.INTERNAL, RenderView.q(), (new StringBuilder()).append("Console message:").append(consolemessage).toString());
        return true;
    }

    public void onGeolocationPermissionsShowPrompt(String s, android.webkit.rmissions.Callback callback)
    {
        (new android.app.uilder(a.getRenderViewContext())).setTitle("Location Permission").setMessage("Allow location access").setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener(callback, s) {

            final android.webkit.GeolocationPermissions.Callback a;
            final String b;
            final RenderView._cls6 c;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                a.invoke(b, true, false);
            }

            
            {
                c = RenderView._cls6.this;
                a = callback;
                b = s;
                super();
            }
        }).setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener(callback, s) {

            final android.webkit.GeolocationPermissions.Callback a;
            final String b;
            final RenderView._cls6 c;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                a.invoke(b, false, false);
            }

            
            {
                c = RenderView._cls6.this;
                a = callback;
                b = s;
                super();
            }
        }).create().show();
        super.onGeolocationPermissionsShowPrompt(s, callback);
    }

    public void onHideCustomView()
    {
        a();
        super.onHideCustomView();
    }

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        Logger.a(com.inmobi.commons.core.utilities.alLogLevel.INTERNAL, RenderView.q(), (new StringBuilder()).append("jsAlert called with: ").append(s1).append(s).toString());
        (new android.app.uilder(a.getRenderViewContext())).setMessage(s1).setTitle(s).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener(jsresult) {

            final JsResult a;
            final RenderView._cls6 b;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                a.confirm();
            }

            
            {
                b = RenderView._cls6.this;
                a = jsresult;
                super();
            }
        }).setCancelable(false).create().show();
        return true;
    }

    public boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
    {
        (new android.app.uilder(a.getRenderViewContext())).setMessage(s1).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener(jsresult) {

            final JsResult a;
            final RenderView._cls6 b;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                a.confirm();
            }

            
            {
                b = RenderView._cls6.this;
                a = jsresult;
                super();
            }
        }).setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener(jsresult) {

            final JsResult a;
            final RenderView._cls6 b;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                a.cancel();
            }

            
            {
                b = RenderView._cls6.this;
                a = jsresult;
                super();
            }
        }).create().show();
        return true;
    }

    public void onShowCustomView(View view, android.webkit.nt.CustomViewCallback customviewcallback)
    {
        RenderView.a(a, view);
        RenderView.a(a, customviewcallback);
        RenderView.j(a).setOnTouchListener(new android.view.View.OnTouchListener() {

            final RenderView._cls6 a;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = RenderView._cls6.this;
                super();
            }
        });
        view = (FrameLayout)((Activity)a.getRenderViewContext()).findViewById(0x1020002);
        RenderView.j(a).setBackgroundColor(0xff000000);
        view.addView(RenderView.j(a), new android.widget.t.LayoutParams(-1, -1, 0, 0));
        RenderView.j(a).requestFocus();
        a(RenderView.j(a), new android.view.View.OnKeyListener() {

            final RenderView._cls6 a;

            public boolean onKey(View view1, int i, KeyEvent keyevent)
            {
                if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, RenderView.q(), "Back pressed when HTML5 video is playing.");
                    RenderView._cls6.a(a);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = RenderView._cls6.this;
                super();
            }
        });
    }

    _cls7.b(RenderView renderview)
    {
        a = renderview;
        super();
    }
}
