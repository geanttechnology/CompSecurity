// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.DialogInterface;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

class val.spinner extends WebViewClient
{

    final val.spinner this$1;
    final ProgressBar val$spinner;

    public void onPageFinished(WebView webview, String s)
    {
        val$spinner.setVisibility(8);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$spinner = ProgressBar.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/app/activity/SignInActivity$6

/* anonymous class */
    class SignInActivity._cls6
        implements android.view.View.OnClickListener
    {

        final SignInActivity this$0;

        public void onClick(View view)
        {
            view = new android.support.v7.app.AlertDialog.Builder(SignInActivity.this);
            view.setCancelable(true);
            ProgressBar progressbar = new ProgressBar(SignInActivity.this, null, 0x1010077);
            Object obj = new WebView(SignInActivity.this);
            ((WebView) (obj)).setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
            ((WebView) (obj)).setWebViewClient(progressbar. new SignInActivity._cls6._cls1());
            ((WebView) (obj)).loadUrl("https://www.amazon.com/cd/tou/flagpage");
            RelativeLayout relativelayout = new RelativeLayout(SignInActivity.this);
            relativelayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
            relativelayout.addView(((View) (obj)));
            relativelayout.addView(progressbar);
            obj = (android.widget.RelativeLayout.LayoutParams)progressbar.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13, -1);
            progressbar.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            view.setView(relativelayout);
            view.setPositiveButton("Close", new SignInActivity._cls6._cls2());
            view.show();
        }

            
            {
                this$0 = SignInActivity.this;
                super();
            }

        // Unreferenced inner class com/amazon/gallery/thor/app/activity/SignInActivity$6$2

/* anonymous class */
        class SignInActivity._cls6._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final SignInActivity._cls6 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = SignInActivity._cls6.this;
                        super();
                    }
        }

    }

}
