// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.text.style.URLSpan;
import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonBrandedWebView;

// Referenced classes of package com.amazon.mShop.util:
//            UIUtils

private static class title extends URLSpan
{

    private final AmazonActivity amazonActivity;
    private final String title;

    public void onClick(View view)
    {
        amazonActivity.pushView(new AmazonBrandedWebView(amazonActivity, getURL(), title));
    }

    public (AmazonActivity amazonactivity, String s, String s1)
    {
        super(s);
        amazonActivity = amazonactivity;
        title = s1;
    }
}
