// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.app.AlertDialog;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.gotv.crackle.Application;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.util.OmnitureWrapper;

// Referenced classes of package com.gotv.crackle.helpers:
//            MyCrackleViewHelper

class this._cls1 extends WebViewClient
{

    final ing this$1;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (Application.isFanhattan() && s.startsWith("mailto:"))
        {
            webview = s.substring(s.indexOf(":") + 1);
            s = (new android.app.>(context)).e();
            s.setTitle("Contact Us");
            s.setMessage(webview);
            s.show();
            return true;
        } else
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
    }

    l.context()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/helpers/MyCrackleViewHelper$16

/* anonymous class */
    class MyCrackleViewHelper._cls16
        implements Runnable
    {

        final MyCrackleViewHelper this$0;
        final BaseActivity val$context;

        public void run()
        {
            Application.getInstance().getOmnitureTracker().myCracklePage("privacy policy");
            Object obj = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f03003b, null);
            Object obj1 = new android.app.AlertDialog.Builder(context);
            ((android.app.AlertDialog.Builder) (obj1)).setView(((View) (obj)));
            obj1 = ((android.app.AlertDialog.Builder) (obj1)).create();
            ((AlertDialog) (obj1)).setCanceledOnTouchOutside(true);
            ((AlertDialog) (obj1)).show();
            obj1 = new android.widget.RelativeLayout.LayoutParams(-2, Application.getScreenHeight() / 2);
            obj = (WebView)((View) (obj)).findViewById(0x7f0a00bf);
            ((WebView) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            if (android.os.Build.VERSION.SDK_INT > 13)
            {
                ((WebView) (obj)).getSettings().setTextZoom(130);
            }
            ((WebView) (obj)).setWebViewClient(new MyCrackleViewHelper._cls16._cls1());
            ((WebView) (obj)).getSettings().setLoadWithOverviewMode(true);
            ((WebView) (obj)).getSettings().setUseWideViewPort(true);
            ((WebView) (obj)).loadUrl(context.getResources().getString(0x7f0b008c));
        }

            
            {
                this$0 = final_mycrackleviewhelper;
                context = BaseActivity.this;
                super();
            }
    }

}
