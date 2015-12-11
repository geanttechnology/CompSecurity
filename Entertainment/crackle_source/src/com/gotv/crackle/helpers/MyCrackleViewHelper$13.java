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
import com.gotv.crackle.Application;
import com.gotv.crackle.base.BaseActivity;

// Referenced classes of package com.gotv.crackle.helpers:
//            MyCrackleViewHelper

class val.context
    implements Runnable
{

    final MyCrackleViewHelper this$0;
    final BaseActivity val$context;

    public void run()
    {
        View view = ((LayoutInflater)val$context.getSystemService("layout_inflater")).inflate(0x7f03003b, null);
        Object obj = new android.app.it>(val$context);
        ((android.app.iewHelper._cls13.val.context) (obj)).View(view);
        obj = ((android.app.View) (obj)).ate();
        ((AlertDialog) (obj)).setCanceledOnTouchOutside(true);
        WebView webview = (WebView)view.findViewById(0x7f0a00bf);
        view.setLayoutParams(new android.widget.s(-2, Application.getScreenHeight() / 2));
        if (android.os.reenHeight > 13)
        {
            webview.getSettings().setTextZoom(130);
        }
        webview.loadUrl(val$context.getResources().getString(0x7f0b0089));
        ((AlertDialog) (obj)).show();
    }

    ()
    {
        this$0 = final_mycrackleviewhelper;
        val$context = BaseActivity.this;
        super();
    }
}
