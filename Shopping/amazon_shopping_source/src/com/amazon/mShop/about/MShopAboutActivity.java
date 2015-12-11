// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.about;

import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.about:
//            MShopAboutView

public class MShopAboutActivity extends AmazonActivity
{

    public MShopAboutActivity()
    {
    }

    protected void onStart()
    {
        super.onStart();
        setStopBehavior(1);
        setRootView(new MShopAboutView(this));
    }
}
