// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.Shipment;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            f, i, s

public class at extends f
{

    private final List mCartProducts;
    private final Long mLoadTimeMS;
    private final OrderReview mOrderReview;

    private at(OrderReview orderreview, long l)
    {
        mLoadTimeMS = Long.valueOf(l);
        mOrderReview = orderreview;
        mCartProducts = b(orderreview);
    }

    public static at a(OrderReview orderreview, long l)
    {
        return new at(orderreview, l);
    }

    private static String a(OrderReview orderreview)
    {
        if (orderreview == null)
        {
            return "";
        }
        if (orderreview.i() == null)
        {
            return "";
        } else
        {
            return orderreview.i().toPlainString();
        }
    }

    private List b(OrderReview orderreview)
    {
        ArrayList arraylist = new ArrayList();
        if (orderreview == null)
        {
            return arraylist;
        }
        if (orderreview.n() == null || orderreview.n().isEmpty())
        {
            return arraylist;
        }
        orderreview = orderreview.n().iterator();
        do
        {
            if (!orderreview.hasNext())
            {
                break;
            }
            Shipment shipment = (Shipment)orderreview.next();
            if (shipment.a() != null && !shipment.a().isEmpty())
            {
                arraylist.addAll(shipment.a());
            }
        } while (true);
        return arraylist;
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "events", "checkout");
        com.target.ui.analytics.a.i.a(map, "products", com.target.ui.analytics.a.i.a(mCartProducts));
        com.target.ui.analytics.a.i.a(map, "cartSubtotal", a(mOrderReview));
        return map;
    }

    protected s c()
    {
        return s.Checkout;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected Long i()
    {
        return mLoadTimeMS;
    }
}
