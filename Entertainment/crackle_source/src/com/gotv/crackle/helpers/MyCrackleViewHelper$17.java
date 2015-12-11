// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
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
        Application.isNielsenOptOutShowing = true;
        Application.getInstance().getOmnitureTracker().myCracklePage("about Nielsen");
        Object obj = ((LayoutInflater)val$context.getSystemService("layout_inflater")).inflate(0x7f03003b, null);
        final AlertDialog alertDialog = new android.app.it>(val$context);
        alertDialog.View(((View) (obj)));
        alertDialog = alertDialog.ate();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();
        alertDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final MyCrackleViewHelper._cls17 this$1;

            public void onCancel(DialogInterface dialoginterface)
            {
                Application.isNielsenOptOutShowing = false;
            }

            
            {
                this$1 = MyCrackleViewHelper._cls17.this;
                super();
            }
        });
        Object obj1 = new android.widget.rams(Application.getScreenWidth(), Application.getScreenHeight());
        obj = (WebView)((View) (obj)).findViewById(0x7f0a00bf);
        ((WebView) (obj)).setLayoutParams(((android.view.ms) (obj1)));
        if (android.os.s > 13)
        {
            ((WebView) (obj)).getSettings().setTextZoom(130);
        }
        ((WebView) (obj)).setWebViewClient(new WebViewClient() {

            final MyCrackleViewHelper._cls17 this$1;

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
                this$1 = MyCrackleViewHelper._cls17.this;
                super();
            }
        });
        obj1 = BaseActivity.getNielsenOptOutUrl();
        if (obj1 != null)
        {
            ((WebView) (obj)).getSettings().setJavaScriptEnabled(true);
            ((WebView) (obj)).getSettings().setBuiltInZoomControls(true);
            ((WebView) (obj)).getSettings().setDisplayZoomControls(false);
            ((WebView) (obj)).getSettings().setLoadWithOverviewMode(true);
            ((WebView) (obj)).getSettings().setUseWideViewPort(true);
            ((WebView) (obj)).getSettings().setLayoutAlgorithm(android.webkit.ithm.SINGLE_COLUMN);
            ((WebView) (obj)).loadUrl(((String) (obj1)));
            ((WebView) (obj)).setWebViewClient(new WebViewClient() {

                final MyCrackleViewHelper._cls17 this$1;
                final AlertDialog val$alertDialog;

                public boolean shouldOverrideUrlLoading(WebView webview, String s)
                {
                    Log.d("OptOutActivity", (new StringBuilder()).append("shouldOverrideUrlLoading: ").append(s).toString());
                    if (s.indexOf("nielsen") == 0)
                    {
                        BaseActivity.setNielsenUserOptOut(s);
                        alertDialog.dismiss();
                        Application.isNielsenOptOutShowing = false;
                        return false;
                    } else
                    {
                        Application.isNielsenOptOutShowing = false;
                        return true;
                    }
                }

            
            {
                this$1 = MyCrackleViewHelper._cls17.this;
                alertDialog = alertdialog;
                super();
            }
            });
        }
    }

    _cls3.val.alertDialog()
    {
        this$0 = final_mycrackleviewhelper;
        val$context = BaseActivity.this;
        super();
    }
}
