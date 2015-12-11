// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.view.View;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.Action;
import com.amazon.rio.j2me.client.services.mShop.HomeItem;
import com.amazon.rio.j2me.client.services.mShop.PromoSlot;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.home:
//            PromoSlotView, HomeView

class this._cls0
    implements android.view.ener
{

    final PromoSlotView this$0;

    public void onClick(View view)
    {
        view = new Action();
        int i = ((Integer)HomeView.ACTION_TYPE_DICTIONARY.get(PromoSlotView.access$500(PromoSlotView.this))).intValue();
        view.setType(i);
        view.setParams(PromoSlotView.access$600(PromoSlotView.this));
        PromoSlot promoslot = new PromoSlot();
        promoslot.setAction(view);
        if (i == 4)
        {
            HomeItem homeitem = new HomeItem();
            homeitem.setAsin(view.getParams());
            promoslot.setProduct(homeitem);
        }
        PromoSlotView.access$700(PromoSlotView.this, promoslot, view.getType());
        PromoSlotView.access$300(PromoSlotView.this, promoslot);
        if (!Util.isEmpty(PromoSlotView.access$400(PromoSlotView.this)))
        {
            RefMarkerObserver.logRefMarker(PromoSlotView.access$400(PromoSlotView.this));
        }
    }

    ()
    {
        this$0 = PromoSlotView.this;
        super();
    }
}
