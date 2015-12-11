// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.view.View;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.HomeItem;

// Referenced classes of package com.amazon.mShop.home:
//            HomeShovelerItemsAdapter, ShovelerItemView, HomeView

class val.position
    implements android.view.dapter._cls1
{

    final HomeShovelerItemsAdapter this$0;
    final int val$position;
    final ShovelerItemView val$shovelerItemView;

    public void onClick(View view)
    {
        Object obj = view.getTag();
        if (!(obj instanceof HomeItem)) goto _L2; else goto _L1
_L1:
        view = null;
        if (Util.isEmpty(((HomeItem)obj).getClickStreamOrigin())) goto _L4; else goto _L3
_L3:
        view = ((HomeItem)obj).getClickStreamOrigin();
_L6:
        view = new ClickStreamTag(view);
        HomeView.forwardProductDetailsView(HomeShovelerItemsAdapter.access$100(HomeShovelerItemsAdapter.this), (HomeItem)obj, view, val$shovelerItemView.getEncodedImage());
        if (!Util.isEmpty(HomeShovelerItemsAdapter.access$200(HomeShovelerItemsAdapter.this)))
        {
            HomeView.postClickedSlotToken(HomeShovelerItemsAdapter.access$200(HomeShovelerItemsAdapter.this));
        }
        if (!Util.isEmpty(HomeShovelerItemsAdapter.access$300(HomeShovelerItemsAdapter.this)))
        {
            RefMarkerObserver.logRefMarker(String.format(HomeShovelerItemsAdapter.access$300(HomeShovelerItemsAdapter.this), new Object[] {
                Integer.valueOf(val$position + 1)
            }));
        }
_L2:
        return;
_L4:
        if (!Util.isEmpty(HomeShovelerItemsAdapter.access$000(HomeShovelerItemsAdapter.this)))
        {
            view = HomeShovelerItemsAdapter.access$000(HomeShovelerItemsAdapter.this);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    m()
    {
        this$0 = final_homeshoveleritemsadapter;
        val$shovelerItemView = shoveleritemview;
        val$position = I.this;
        super();
    }
}
