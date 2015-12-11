// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.text.style.ClickableSpan;
import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonBrandedWebView;

// Referenced classes of package com.amazon.mShop.util:
//            UIUtils

static final class <init> extends ClickableSpan
{

    final AmazonActivity val$amazonActivity;
    final String val$linkText;
    final String val$linkUrl;

    public void onClick(View view)
    {
        val$amazonActivity.pushView(new AmazonBrandedWebView(val$amazonActivity, val$linkUrl, val$linkText));
    }

    View(AmazonActivity amazonactivity, String s, String s1)
    {
        val$amazonActivity = amazonactivity;
        val$linkUrl = s;
        val$linkText = s1;
        super();
    }
}
