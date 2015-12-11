// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.navigation.AppNavigator;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemSBD, GNODrawer

class this._cls0
    implements android.view.r
{

    final GNODrawerItemSBD this$0;

    public void onClick(View view)
    {
        AppNavigator.navigate(AmazonActivity.getTopMostBaseActivity(), com.amazon.mShop.navigation..shop_by_department, null);
        AmazonActivity.getTopMostBaseActivity().getGNODrawer().close();
    }

    ()
    {
        this$0 = GNODrawerItemSBD.this;
        super();
    }
}
