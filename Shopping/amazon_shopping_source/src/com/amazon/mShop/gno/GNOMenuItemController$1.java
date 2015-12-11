// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import com.amazon.mShop.control.locale.LocaleSwitchSubscriber;
import com.amazon.mShop.util.UIUtils;
import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemController, GNOItemAdapter

class val.itemAdapter
    implements LocaleSwitchSubscriber
{

    final GNOMenuItemController this$0;
    final GNOItemAdapter val$itemAdapter;
    final String val$menuId;

    public void onError(Exception exception, ServiceCall servicecall)
    {
        UIUtils.info(GNOMenuItemController.access$000(GNOMenuItemController.this), com.amazon.mShop.android.lib.witching_language);
        GNOMenuItemController.access$102(GNOMenuItemController.this, false);
        GNOMenuItemController.access$200(GNOMenuItemController.this, val$menuId, val$itemAdapter);
    }

    public void onLocaleSwitchCompleted(String s)
    {
        GNOMenuItemController.access$102(GNOMenuItemController.this, false);
        GNOMenuItemController.access$200(GNOMenuItemController.this, val$menuId, val$itemAdapter);
    }

    ll()
    {
        this$0 = final_gnomenuitemcontroller;
        val$menuId = s;
        val$itemAdapter = GNOItemAdapter.this;
        super();
    }
}
