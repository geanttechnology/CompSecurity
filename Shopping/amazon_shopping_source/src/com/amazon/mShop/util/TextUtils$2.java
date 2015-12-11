// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.text.style.ClickableSpan;
import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonBrandedWebView;

// Referenced classes of package com.amazon.mShop.util:
//            TextUtils

static final class init> extends ClickableSpan
{

    final String val$title;
    final String val$url;

    public void onClick(View view)
    {
        view = view.getContext();
        if (view instanceof AmazonActivity)
        {
            view = (AmazonActivity)view;
            view.pushView(new AmazonBrandedWebView(view, val$url, val$title, true));
        }
    }

    iew(String s, String s1)
    {
        val$url = s;
        val$title = s1;
        super();
    }
}
