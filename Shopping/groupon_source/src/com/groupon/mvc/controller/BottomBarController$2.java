// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller;

import android.content.Context;
import android.view.View;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.service.ShoppingCartService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BuyUtils;

// Referenced classes of package com.groupon.mvc.controller:
//            BottomBarController

class val.option
    implements android.view.rController._cls2
{

    final BottomBarController this$0;
    final Deal val$deal;
    final Option val$option;

    public void onClick(View view)
    {
        BottomBarController.access$400(BottomBarController.this).logClick("", "view_cart_click", "", BottomBarController.access$500(BottomBarController.this).nstClickMetadata(BottomBarController.access$400(BottomBarController.this), BottomBarController.access$700(BottomBarController.this), val$deal, val$option));
        BottomBarController.access$800(BottomBarController.this).startActivity(BottomBarController.access$700(BottomBarController.this).getOpenCartIntent());
    }

    ()
    {
        this$0 = final_bottombarcontroller;
        val$deal = deal1;
        val$option = Option.this;
        super();
    }
}
