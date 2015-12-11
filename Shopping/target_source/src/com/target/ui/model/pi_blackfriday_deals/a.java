// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.pi_blackfriday_deals;

import com.pointinside.maps.Location;
import com.pointinside.products.BaseProduct;
import com.pointinside.products.Deal;
import com.pointinside.products.ImageInfo;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.model.product.interfaces.BlackFridayPrice;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.model.pi_blackfriday_deals:
//            TGTPiBaseProduct, TGTPiBlackFridayDeal

public class a
{

    private final int DEFAULT_POSITION = 0;
    private final String mDealType;

    public a(String s)
    {
        mDealType = s;
    }

    private TGTPiBaseProduct a(BaseProduct baseproduct, Map map)
    {
        TGTPiBaseProduct tgtpibaseproduct = new TGTPiBaseProduct();
        tgtpibaseproduct.a(baseproduct.title);
        tgtpibaseproduct.b(baseproduct.description);
        Object obj = baseproduct.images;
        if (obj != null && !((List) (obj)).isEmpty())
        {
            tgtpibaseproduct.c(((ImageInfo)baseproduct.images.get(0)).url);
        }
        obj = baseproduct.productId;
        tgtpibaseproduct.a(new Dpci(((String) (obj))));
        if (map.containsKey(obj))
        {
            tgtpibaseproduct.a((BigDecimal)map.get(obj));
        }
        if (baseproduct.locations != null && !baseproduct.locations.isEmpty())
        {
            tgtpibaseproduct.a((Location)baseproduct.locations.get(0));
        }
        return tgtpibaseproduct;
    }

    private TGTPiBlackFridayDeal a(Deal deal, BaseProduct baseproduct)
    {
        TGTPiBlackFridayDeal tgtpiblackfridaydeal = new TGTPiBlackFridayDeal();
        tgtpiblackfridaydeal.a(deal.eventLocation);
        tgtpiblackfridaydeal.b(deal.title);
        tgtpiblackfridaydeal.c(deal.description);
        tgtpiblackfridaydeal.a(deal.startDate);
        tgtpiblackfridaydeal.b(deal.endDate);
        if (baseproduct.locations != null && !baseproduct.locations.isEmpty())
        {
            tgtpiblackfridaydeal.a((Location)baseproduct.locations.get(0));
        }
        if (deal.images != null && !deal.images.isEmpty())
        {
            tgtpiblackfridaydeal.d(((ImageInfo)deal.images.get(0)).url);
        }
        tgtpiblackfridaydeal.a(new ArrayList());
        return tgtpiblackfridaydeal;
    }

    private List a(List list, Map map)
    {
        if (list == null || list.isEmpty())
        {
            return Collections.emptyList();
        }
        HashMap hashmap = new HashMap();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            BaseProduct baseproduct = (BaseProduct)iterator.next();
            if (baseproduct.deals != null && !baseproduct.deals.isEmpty())
            {
                Iterator iterator1 = baseproduct.deals.iterator();
                while (iterator1.hasNext()) 
                {
                    list = (Deal)iterator1.next();
                    if (((Deal) (list)).dealType != null && !((Deal) (list)).dealType.isEmpty() && mDealType.equalsIgnoreCase((String)((Deal) (list)).dealType.get(0)))
                    {
                        String s = ((Deal) (list)).eventLocation;
                        if (hashmap.containsKey(s))
                        {
                            list = (TGTPiBlackFridayDeal)hashmap.get(s);
                        } else
                        {
                            list = a(((Deal) (list)), baseproduct);
                        }
                        list.f().add(a(baseproduct, map));
                        hashmap.put(s, list);
                    }
                }
            }
        }

        list = new ArrayList();
        for (map = hashmap.values().iterator(); map.hasNext(); list.add((TGTPiBlackFridayDeal)map.next())) { }
        Collections.sort(list);
        return list;
    }

    public List a(List list)
    {
        return a(list, ((Map) (new android.support.v4.f.a())));
    }

    public List a(List list, List list1)
    {
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        BlackFridayPrice blackfridayprice;
        for (list1 = list1.iterator(); list1.hasNext(); a1.put(blackfridayprice.a().b(), blackfridayprice.b()))
        {
            blackfridayprice = (BlackFridayPrice)list1.next();
        }

        return a(list, ((Map) (a1)));
    }
}
