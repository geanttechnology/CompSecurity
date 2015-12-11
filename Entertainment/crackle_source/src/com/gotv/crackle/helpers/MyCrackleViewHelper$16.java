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

class val.context
    implements Runnable
{

    final MyCrackleViewHelper this$0;
    final BaseActivity val$context;

    public void run()
    {
        Application.getInstance().getOmnitureTracker().myCracklePage("privacy policy");
        Object obj = ((LayoutInflater)val$context.getSystemService("layout_inflater")).inflate(0x7f03003b, null);
        Object obj1 = new android.app.it>(val$context);
        ((android.app.iewHelper._cls16.val.context) (obj1)).View(((View) (obj)));
        obj1 = ((android.app.View) (obj1)).ate();
        ((AlertDialog) (obj1)).setCanceledOnTouchOutside(true);
        ((AlertDialog) (obj1)).show();
        obj1 = new android.widget.rams(-2, Application.getScreenHeight() / 2);
        obj = (WebView)((View) (obj)).findViewById(0x7f0a00bf);
        ((WebView) (obj)).setLayoutParams(((android.view.ms) (obj1)));
        if (android.os.s > 13)
        {
            ((WebView) (obj)).getSettings().setTextZoom(130);
        }
        ((WebView) (obj)).setWebViewClient(new WebViewClient() {

            final MyCrackleViewHelper._cls16 this$1;

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                if (Application.isFanhattan() && s.startsWith("mailto:"))
                {
                    webview = s.substring(s.indexOf(":") + 1);
                    s = (new android.app.AlertDialog.Builder(context)).create();
                    s.setTitle("Contact Us");
                    s.setMessage(webview);
                    s.show();
                    return true;
                } else
                {
                    return super.shouldOverrideUrlLoading(webview, s);
                }
            }

            
            {
                this$1 = MyCrackleViewHelper._cls16.this;
                super();
            }
        });
        ((WebView) (obj)).getSettings().setLoadWithOverviewMode(true);
        ((WebView) (obj)).getSettings().setUseWideViewPort(true);
        ((WebView) (obj)).loadUrl(val$context.getResources().getString(0x7f0b008c));
    }

    _cls1.this._cls1()
    {
        this$0 = final_mycrackleviewhelper;
        val$context = BaseActivity.this;
        super();
    }
}
