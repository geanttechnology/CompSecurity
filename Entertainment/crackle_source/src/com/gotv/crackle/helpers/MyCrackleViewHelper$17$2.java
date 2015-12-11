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

    // Unreferenced inner class com/gotv/crackle/helpers/MyCrackleViewHelper$17

/* anonymous class */
    class MyCrackleViewHelper._cls17
        implements Runnable
    {

        final MyCrackleViewHelper this$0;
        final BaseActivity val$context;

        public void run()
        {
            Application.isNielsenOptOutShowing = true;
            Application.getInstance().getOmnitureTracker().myCracklePage("about Nielsen");
            Object obj = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f03003b, null);
            final AlertDialog alertDialog = new android.app.AlertDialog.Builder(context);
            alertDialog.setView(((View) (obj)));
            alertDialog = alertDialog.create();
            alertDialog.setCanceledOnTouchOutside(true);
            alertDialog.show();
            alertDialog.setOnCancelListener(new MyCrackleViewHelper._cls17._cls1());
            Object obj1 = new android.widget.RelativeLayout.LayoutParams(Application.getScreenWidth(), Application.getScreenHeight());
            obj = (WebView)((View) (obj)).findViewById(0x7f0a00bf);
            ((WebView) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            if (android.os.Build.VERSION.SDK_INT > 13)
            {
                ((WebView) (obj)).getSettings().setTextZoom(130);
            }
            ((WebView) (obj)).setWebViewClient(new MyCrackleViewHelper._cls17._cls2());
            obj1 = BaseActivity.getNielsenOptOutUrl();
            if (obj1 != null)
            {
                ((WebView) (obj)).getSettings().setJavaScriptEnabled(true);
                ((WebView) (obj)).getSettings().setBuiltInZoomControls(true);
                ((WebView) (obj)).getSettings().setDisplayZoomControls(false);
                ((WebView) (obj)).getSettings().setLoadWithOverviewMode(true);
                ((WebView) (obj)).getSettings().setUseWideViewPort(true);
                ((WebView) (obj)).getSettings().setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                ((WebView) (obj)).loadUrl(((String) (obj1)));
                ((WebView) (obj)).setWebViewClient(new MyCrackleViewHelper._cls17._cls3());
            }
        }

            
            {
                this$0 = final_mycrackleviewhelper;
                context = BaseActivity.this;
                super();
            }

        // Unreferenced inner class com/gotv/crackle/helpers/MyCrackleViewHelper$17$1

/* anonymous class */
        class MyCrackleViewHelper._cls17._cls1
            implements android.content.DialogInterface.OnCancelListener
        {

            final MyCrackleViewHelper._cls17 this$1;

            public void onCancel(DialogInterface dialoginterface)
            {
                Application.isNielsenOptOutShowing = false;
            }

                    
                    {
                        this$1 = MyCrackleViewHelper._cls17.this;
                        super();
                    }
        }


        // Unreferenced inner class com/gotv/crackle/helpers/MyCrackleViewHelper$17$3

/* anonymous class */
        class MyCrackleViewHelper._cls17._cls3 extends WebViewClient
        {

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
        }

    }

}
