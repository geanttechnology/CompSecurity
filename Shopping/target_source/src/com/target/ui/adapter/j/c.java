// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.j;

import android.content.Context;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingCollectionItem;
import com.target.ui.i.d.a;
import com.target.ui.view.weekly_ad.WeeklyAdListItemView;
import java.util.List;

// Referenced classes of package com.target.ui.adapter.j:
//            a

public class c extends com.target.ui.adapter.j.a
{

    public c(Context context, List list)
    {
        super(context, list);
    }

    protected void a(WeeklyAdListItemView weeklyadlistitemview, WeeklyAdListingCollectionItem weeklyadlistingcollectionitem, int i)
    {
        com.target.ui.common.ProductFulfillmentOptions productfulfillmentoptions = com.target.ui.i.d.a.a(weeklyadlistitemview.getContext(), weeklyadlistingcollectionitem, b());
        weeklyadlistitemview.setDisplayPrice(weeklyadlistingcollectionitem.b());
        weeklyadlistitemview.setFulfillmentViewOptions(productfulfillmentoptions);
        weeklyadlistitemview.setImageUrl(weeklyadlistingcollectionitem.a(a()));
        weeklyadlistitemview.setTitle(weeklyadlistingcollectionitem.a());
        weeklyadlistitemview.setEyebrowText(weeklyadlistingcollectionitem.f());
    }

    protected volatile void a(WeeklyAdListItemView weeklyadlistitemview, Object obj, int i)
    {
        a(weeklyadlistitemview, (WeeklyAdListingCollectionItem)obj, i);
    }
}
