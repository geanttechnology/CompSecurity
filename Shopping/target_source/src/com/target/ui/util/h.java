// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.model.shop.CompositeDeal;
import com.target.ui.model.shop.TGTCompositeDeal;
import java.util.Iterator;
import java.util.List;

public class h
{

    public static final int COUPON_INTERVAL = 5;
    private static final int LAST_PRODUCT_INDEX_BEFORE_COUPON = 4;

    public static void a(List list, List list1, List list2)
    {
        int j1;
        int k1;
        int l1;
        if (list.size() > 0)
        {
            Iterator iterator = list.iterator();
            int i1 = 0;
            int k = 0;
            int i = 0;
            do
            {
                k1 = i1;
                l1 = k;
                j1 = i;
                if (!iterator.hasNext())
                {
                    break;
                }
                if (((CompositeDeal)iterator.next()).a() == 1)
                {
                    j1 = 0;
                    i1 = i + 1;
                    i = j1;
                } else
                {
                    j1 = i1 + 1;
                    k++;
                    i1 = i;
                    i = j1;
                }
                j1 = i1;
                i1 = i;
                i = j1;
            } while (true);
        } else
        {
            k1 = 0;
            l1 = 0;
            j1 = 0;
        }
        if (l1 < list2.size() - 1)
        {
            list2 = list2.subList(l1, list2.size() - 1);
        } else
        {
            list.clear();
            k1 = 0;
            j1 = 0;
        }
        for (list2 = list2.iterator(); list2.hasNext();)
        {
            ProductDetails productdetails = (ProductDetails)list2.next();
            int l = k1;
            int j = j1;
            if (k1 == 4)
            {
                l = k1;
                j = j1;
                if (j1 < list1.size())
                {
                    list.add(new TGTCompositeDeal((AvailableCouponOffer)list1.get(j1)));
                    j = j1 + 1;
                    l = 0;
                }
            }
            list.add(new TGTCompositeDeal(productdetails));
            k1 = l + 1;
            j1 = j;
        }

    }
}
