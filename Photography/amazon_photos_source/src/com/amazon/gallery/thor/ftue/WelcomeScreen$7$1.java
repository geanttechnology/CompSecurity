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

class this._cls1 extends WebViewClient
{

    final sDialog.show this$1;

    public void onPageFinished(WebView webview, String s)
    {
        WelcomeScreen.access$2000(_fld0).hide();
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        WelcomeScreen.access$1900(_fld0).show();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/ftue/WelcomeScreen$7

/* anonymous class */
    class WelcomeScreen._cls7
        implements Runnable
    {

        final WelcomeScreen this$0;

        public void run()
        {
            Object obj = new android.support.v7.app.AlertDialog.Builder(WelcomeScreen.access$1700(WelcomeScreen.this));
            Object obj1 = new WebView(WelcomeScreen.access$1800(WelcomeScreen.this));
            obj = ((android.support.v7.app.AlertDialog.Builder) (obj)).create();
            ((AlertDialog) (obj)).setView(((android.view.View) (obj1)));
            ((WebView) (obj1)).setWebViewClient(new WelcomeScreen._cls7._cls1());
            ((WebView) (obj1)).loadUrl(WelcomeScreen.access$1300(WelcomeScreen.this));
            ((AlertDialog) (obj)).show();
            obj1 = new android.view.WindowManager.LayoutParams();
            ((android.view.WindowManager.LayoutParams) (obj1)).copyFrom(((AlertDialog) (obj)).getWindow().getAttributes());
            Display display = WelcomeScreen.access$2100(WelcomeScreen.this).getWindowManager().getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            obj1.width = point.x - (int)WelcomeScreen.access$2200(WelcomeScreen.this).getResources().getDimension(0x7f0a0164);
            ((AlertDialog) (obj)).getWindow().setAttributes(((android.view.WindowManager.LayoutParams) (obj1)));
        }

            
            {
                this$0 = WelcomeScreen.this;
                super();
            }
    }

}
