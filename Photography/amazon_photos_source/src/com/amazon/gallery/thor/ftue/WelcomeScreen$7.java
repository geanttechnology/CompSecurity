// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            WelcomeScreen

class this._cls0
    implements Runnable
{

    final WelcomeScreen this$0;

    public void run()
    {
        Object obj = new android.support.v7.app.der(WelcomeScreen.access$1700(WelcomeScreen.this));
        Object obj1 = new WebView(WelcomeScreen.access$1800(WelcomeScreen.this));
        obj = ((android.support.v7.app.der) (obj)).create();
        ((AlertDialog) (obj)).setView(((android.view.View) (obj1)));
        ((WebView) (obj1)).setWebViewClient(new WebViewClient() {

            final WelcomeScreen._cls7 this$1;

            public void onPageFinished(WebView webview, String s)
            {
                WelcomeScreen.access$2000(this$0).hide();
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                WelcomeScreen.access$1900(this$0).show();
            }

            
            {
                this$1 = WelcomeScreen._cls7.this;
                super();
            }
        });
        ((WebView) (obj1)).loadUrl(WelcomeScreen.access$1300(WelcomeScreen.this));
        ((AlertDialog) (obj)).show();
        obj1 = new android.view.youtParams();
        ((android.view.youtParams) (obj1)).copyFrom(((AlertDialog) (obj)).getWindow().getAttributes());
        Display display = WelcomeScreen.access$2100(WelcomeScreen.this).getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        obj1.width = point.x - (int)WelcomeScreen.access$2200(WelcomeScreen.this).getResources().getDimension(0x7f0a0164);
        ((AlertDialog) (obj)).getWindow().setAttributes(((android.view.youtParams) (obj1)));
    }

    _cls1.this._cls1()
    {
        this$0 = WelcomeScreen.this;
        super();
    }
}
