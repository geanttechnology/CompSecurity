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

class this._cls0
    implements android.view.ner
{

    final SignInActivity this$0;

    public void onClick(View view)
    {
        view = new android.support.v7.app.er(SignInActivity.this);
        view.setCancelable(true);
        final ProgressBar spinner = new ProgressBar(SignInActivity.this, null, 0x1010077);
        Object obj = new WebView(SignInActivity.this);
        ((WebView) (obj)).setLayoutParams(new android.view.arams(-1, -1));
        ((WebView) (obj)).setWebViewClient(new WebViewClient() {

            final SignInActivity._cls6 this$1;
            final ProgressBar val$spinner;

            public void onPageFinished(WebView webview, String s)
            {
                spinner.setVisibility(8);
            }

            
            {
                this$1 = SignInActivity._cls6.this;
                spinner = progressbar;
                super();
            }
        });
        ((WebView) (obj)).loadUrl("https://www.amazon.com/cd/tou/flagpage");
        RelativeLayout relativelayout = new RelativeLayout(SignInActivity.this);
        relativelayout.setLayoutParams(new android.view.arams(-1, -1));
        relativelayout.addView(((View) (obj)));
        relativelayout.addView(spinner);
        obj = (android.widget.youtParams)spinner.getLayoutParams();
        ((android.widget.youtParams) (obj)).addRule(13, -1);
        spinner.setLayoutParams(((android.view.arams) (obj)));
        view.setView(relativelayout);
        view.setPositiveButton("Close", new android.content.DialogInterface.OnClickListener() {

            final SignInActivity._cls6 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = SignInActivity._cls6.this;
                super();
            }
        });
        view.show();
    }

    _cls2.this._cls1()
    {
        this$0 = SignInActivity.this;
        super();
    }
}
