// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.support.v4.app.h;
import android.webkit.WebView;

// Referenced classes of package com.target.ui.fragment.checkout:
//            PayPalWebFragment

private class <init> extends com.target.ui.fragment.webview.gment.c
{

    final PayPalWebFragment this$0;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (PayPalWebFragment.a(s))
        {
            webview = PayPalWebFragment.a(PayPalWebFragment.this);
            getFragmentManager().c();
            PayPalWebFragment.b(PayPalWebFragment.this).b(webview);
            return true;
        }
        if (PayPalWebFragment.b(s))
        {
            getFragmentManager().c();
            return true;
        } else
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
    }

    private ment()
    {
        this$0 = PayPalWebFragment.this;
        super(PayPalWebFragment.this);
    }

    ment(ment ment)
    {
        this();
    }
}
