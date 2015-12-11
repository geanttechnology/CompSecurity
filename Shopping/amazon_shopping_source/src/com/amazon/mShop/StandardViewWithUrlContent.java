// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import android.content.res.Resources;

// Referenced classes of package com.amazon.mShop:
//            StandardView, AmazonBrandedWebView

public class StandardViewWithUrlContent extends StandardView
{

    private final String mTitle;

    public StandardViewWithUrlContent(Context context, Integer integer, int i)
    {
        super(context, integer);
        mTitle = context.getResources().getString(integer.intValue());
        setContentView(new AmazonBrandedWebView(context, context.getResources().getString(i), mTitle));
    }

    public StandardViewWithUrlContent(Context context, String s, String s1)
    {
        super(context, Integer.valueOf(0));
        mTitle = s;
        setContentView(new AmazonBrandedWebView(context, s1, mTitle));
    }

    public CharSequence getTitle()
    {
        return mTitle;
    }
}
