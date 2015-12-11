// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller;

import android.view.View;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.service.ShoppingCartService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BuyUtils;

// Referenced classes of package com.groupon.mvc.controller:
//            BottomBarController

class val.option
    implements android.view.rController._cls3
{

    final BottomBarController this$0;
    final Deal val$deal;
    final boolean val$multiDeal;
    final String val$nstClickType;
    final String val$nstPageId;
    final Option val$option;
    final ShoppingCartService val$shoppingCartService;

    public void onClick(View view)
    {
        if (val$multiDeal)
        {
            BottomBarController.access$400(BottomBarController.this).logClick("", val$nstClickType, val$nstPageId, BottomBarController.access$500(BottomBarController.this).nstClickMetadata(BottomBarController.access$400(BottomBarController.this), val$shoppingCartService, val$deal, null));
        } else
        {
            BottomBarController.access$400(BottomBarController.this).logClick("", val$nstClickType, val$nstPageId, BottomBarController.access$500(BottomBarController.this).nstClickMetadata(BottomBarController.access$400(BottomBarController.this), val$shoppingCartService, val$deal, val$option));
        }
        BottomBarController.access$600(BottomBarController.this);
    }

    ()
    {
        this$0 = final_bottombarcontroller;
        val$multiDeal = flag;
        val$nstClickType = s;
        val$nstPageId = s1;
        val$shoppingCartService = shoppingcartservice;
        val$deal = deal1;
        val$option = Option.this;
        super();
    }
}
