// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.navigation.AppNavigator;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemProviderDefault, GNODrawer

class val.params
    implements lickListener
{

    final GNOMenuItemProviderDefault this$0;
    final Map val$params;
    final com.amazon.mShop.navigation.ams val$target;

    public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
    {
        AppNavigator.navigate(amazonactivity, val$target, val$params);
    }

    lickListener()
    {
        this$0 = final_gnomenuitemproviderdefault;
        val$target = tener;
        val$params = Map.this;
        super();
    }
}
