// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.navigation.AppNavigator;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemCharity, GNODrawer

class this._cls0
    implements ItemOnClickListener
{

    final GNODrawerItemCharity this$0;

    public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
    {
        AppNavigator.navigate(amazonactivity, com.amazon.mShop.navigation.rity, null);
    }

    get()
    {
        this$0 = GNODrawerItemCharity.this;
        super();
    }
}
