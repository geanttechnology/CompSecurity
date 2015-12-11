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
//            GNOMenuItemController, GNOMenuItemProvider, GNOItemAdapter

class val.responseItems
    implements Runnable
{

    final ss._cls300 this$1;
    final Collection val$responseItems;

    public void run()
    {
        if (!Util.isEmpty(val$responseItems))
        {
            Collection collection;
            if (DebugSettings.isDebugEnabled())
            {
                collection = CollectionsUtil.sum(val$responseItems, GNOMenuItemController.access$700(_fld0, GNOMenuItemController.access$600()).getItems());
            } else
            {
                collection = val$responseItems;
            }
            itemAdapter.setItems(collection);
            Log.i(GNOMenuItemController.access$300(), "updated menu");
        }
    }

    l.itemAdapter()
    {
        this$1 = final_itemadapter;
        val$responseItems = Collection.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/gno/GNOMenuItemController$2

/* anonymous class */
    class GNOMenuItemController._cls2
        implements NavigationMenuResponseListener
    {

        final GNOMenuItemController this$0;
        final GNOItemAdapter val$itemAdapter;

        public void cancelled(ServiceCall servicecall)
        {
            GNOMenuItemController.access$102(GNOMenuItemController.this, false);
            Log.e(GNOMenuItemController.access$300(), "Failed to get menu items : call cancelled");
        }

        public void completed(NavigationMenuResponse navigationmenuresponse, ServiceCall servicecall)
        {
            GNOMenuItemController.access$402(GNOMenuItemController.this, SystemClock.elapsedRealtime());
            GNOMenuItemController.access$102(GNOMenuItemController.this, false);
            navigationmenuresponse = GNOMenuItemController.access$500(GNOMenuItemController.this, navigationmenuresponse);
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(navigationmenuresponse. new GNOMenuItemController._cls2._cls1());
        }

        public void error(Exception exception, ServiceCall servicecall)
        {
            GNOMenuItemController.access$102(GNOMenuItemController.this, false);
            Log.e(GNOMenuItemController.access$300(), "Failed to get menu items", exception);
        }

            
            {
                this$0 = final_gnomenuitemcontroller;
                itemAdapter = GNOItemAdapter.this;
                super();
            }
    }

}
