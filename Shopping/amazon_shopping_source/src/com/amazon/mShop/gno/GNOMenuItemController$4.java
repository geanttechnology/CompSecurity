// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.navigation.AppNavigator;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemController

class stomRunnable extends stomRunnable
{

    final GNOMenuItemController this$0;
    final com.amazon.mShop.navigation.get val$target;

    public void run(AmazonActivity amazonactivity)
    {
        AppNavigator.navigate(amazonactivity, val$target);
    }

    et()
    {
        this$0 = final_gnomenuitemcontroller;
        val$target = com.amazon.mShop.navigation.get.this;
        super(final_gnomenuitemcontroller, null);
    }
}
