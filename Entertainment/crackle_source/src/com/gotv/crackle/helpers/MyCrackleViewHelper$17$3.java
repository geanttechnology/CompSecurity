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

class val.alertDialog extends WebViewClient
{

    final g this$1;
    final AlertDialog val$alertDialog;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Log.d("OptOutActivity", (new StringBuilder()).append("shouldOverrideUrlLoading: ").append(s).toString());
        if (s.indexOf("nielsen") == 0)
        {
            BaseActivity.setNielsenUserOptOut(s);
            val$alertDialog.dismiss();
            Application.isNielsenOptOutShowing = false;
            return false;
        } else
        {
            Application.isNielsenOptOutShowing = false;
            return true;
        }
    }

    l.context()
    {
        this$1 = final_context;
        val$alertDialog = AlertDialog.this;
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
            Object obj1 = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f03003b, null);
            Object obj = new android.app.AlertDialog.Builder(context);
            ((android.app.AlertDialog.Builder) (obj)).setView(((View) (obj1)));
            obj = ((android.app.AlertDialog.Builder) (obj)).create();
            ((AlertDialog) (obj)).setCanceledOnTouchOutside(true);
            ((AlertDialog) (obj)).show();
            ((AlertDialog) (obj)).setOnCancelListener(new MyCrackleViewHelper._cls17._cls1());
            Object obj2 = new android.widget.RelativeLayout.LayoutParams(Application.getScreenWidth(), Application.getScreenHeight());
            obj1 = (WebView)((View) (obj1)).findViewById(0x7f0a00bf);
            ((WebView) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            if (android.os.Build.VERSION.SDK_INT > 13)
            {
                ((WebView) (obj1)).getSettings().setTextZoom(130);
            }
            ((WebView) (obj1)).setWebViewClient(new MyCrackleViewHelper._cls17._cls2());
            obj2 = BaseActivity.getNielsenOptOutUrl();
            if (obj2 != null)
            {
                ((WebView) (obj1)).getSettings().setJavaScriptEnabled(true);
                ((WebView) (obj1)).getSettings().setBuiltInZoomControls(true);
                ((WebView) (obj1)).getSettings().setDisplayZoomControls(false);
                ((WebView) (obj1)).getSettings().setLoadWithOverviewMode(true);
                ((WebView) (obj1)).getSettings().setUseWideViewPort(true);
                ((WebView) (obj1)).getSettings().setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                ((WebView) (obj1)).loadUrl(((String) (obj2)));
                ((WebView) (obj1)).setWebViewClient(((MyCrackleViewHelper._cls17._cls3) (obj)). new MyCrackleViewHelper._cls17._cls3());
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


        // Unreferenced inner class com/gotv/crackle/helpers/MyCrackleViewHelper$17$2

/* anonymous class */
        class MyCrackleViewHelper._cls17._cls2 extends WebViewClient
        {

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
        }

    }

}
