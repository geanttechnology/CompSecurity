// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.os.SystemClock;
import android.util.Log;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.CollectionsUtil;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.NavigationMenuResponse;
import com.amazon.rio.j2me.client.services.mShop.NavigationMenuResponseListener;
import java.util.Collection;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemController, GNOItemAdapter, GNOMenuItemProvider

class val.itemAdapter
    implements NavigationMenuResponseListener
{

    final GNOMenuItemController this$0;
    final GNOItemAdapter val$itemAdapter;

    public void cancelled(ServiceCall servicecall)
    {
        GNOMenuItemController.access$102(GNOMenuItemController.this, false);
        Log.e(GNOMenuItemController.access$300(), "Failed to get menu items : call cancelled");
    }

    public void completed(final NavigationMenuResponse responseItems, ServiceCall servicecall)
    {
        GNOMenuItemController.access$402(GNOMenuItemController.this, SystemClock.elapsedRealtime());
        GNOMenuItemController.access$102(GNOMenuItemController.this, false);
        responseItems = GNOMenuItemController.access$500(GNOMenuItemController.this, responseItems);
        com.amazon.mShop.platform.ance().invokeLater(new Runnable() {

            final GNOMenuItemController._cls2 this$1;
            final Collection val$responseItems;

            public void run()
            {
                if (!Util.isEmpty(responseItems))
                {
                    Collection collection;
                    if (DebugSettings.isDebugEnabled())
                    {
                        collection = CollectionsUtil.sum(responseItems, GNOMenuItemController.access$700(this$0, GNOMenuItemController.access$600()).getItems());
                    } else
                    {
                        collection = responseItems;
                    }
                    itemAdapter.setItems(collection);
                    Log.i(GNOMenuItemController.access$300(), "updated menu");
                }
            }

            
            {
                this$1 = GNOMenuItemController._cls2.this;
                responseItems = collection;
                super();
            }
        });
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        GNOMenuItemController.access$102(GNOMenuItemController.this, false);
        Log.e(GNOMenuItemController.access$300(), "Failed to get menu items", exception);
    }

    _cls1.val.responseItems()
    {
        this$0 = final_gnomenuitemcontroller;
        val$itemAdapter = GNOItemAdapter.this;
        super();
    }
}
