// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.google.a.a.e;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.util.o;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            e, y, i, s

public class al extends com.target.ui.analytics.a.e
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a AddToList;
        public static final a PickUp;
        public static final a ShipIt;

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/target/ui/analytics/a/al$a, s1);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            ShipIt = new a("ShipIt", 0);
            PickUp = new a("PickUp", 1);
            AddToList = new a("AddToList", 2);
            $VALUES = (new a[] {
                ShipIt, PickUp, AddToList
            });
        }

        private a(String s1, int j)
        {
            super(s1, j);
        }
    }


    private static final String TAG = com/target/ui/analytics/a/al.getSimpleName();
    private final a mFulfillment;
    private final PageItemHierarchy mPageItemHierarchy;
    private final ProductDetails mProductDetails;

    private al(ProductDetails productdetails, a a1, PageItemHierarchy pageitemhierarchy)
    {
        mProductDetails = productdetails;
        mFulfillment = a1;
        mPageItemHierarchy = pageitemhierarchy;
    }

    public static al a(ProductDetails productdetails, a a1, PageItemHierarchy pageitemhierarchy)
    {
        return new al(productdetails, a1, pageitemhierarchy);
    }

    private String a(ProductDetails productdetails, a a1)
    {
        if (productdetails == null)
        {
            a1 = "";
        } else
        {
            if (a1 == null)
            {
                return "";
            }
            if (a1 != a.AddToList)
            {
                return "";
            }
            String s1 = productdetails.k_().b();
            a1 = s1;
            if (!o.f(s1))
            {
                productdetails = (Dpci)productdetails.e().d();
                if (productdetails != null)
                {
                    return productdetails.b();
                } else
                {
                    return "";
                }
            }
        }
        return a1;
    }

    private String a(a a1)
    {
        if (a1 == null)
        {
            return "";
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$analytics$brighttag$TapPDPFulfillmentEvent$Fulfillment[];

            static 
            {
                $SwitchMap$com$target$ui$analytics$brighttag$TapPDPFulfillmentEvent$Fulfillment = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapPDPFulfillmentEvent$Fulfillment[a.ShipIt.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapPDPFulfillmentEvent$Fulfillment[a.PickUp.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapPDPFulfillmentEvent$Fulfillment[a.AddToList.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.TapPDPFulfillmentEvent.Fulfillment[a1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "r0c0";

        case 2: // '\002'
            return "r1c0";

        case 3: // '\003'
            return "r2c0";
        }
    }

    private y b(a a1)
    {
        if (a1 == null)
        {
            return y.Unknown;
        }
        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.TapPDPFulfillmentEvent.Fulfillment[a1.ordinal()])
        {
        default:
            return y.Unknown;

        case 1: // '\001'
            return y.ShipToMe;

        case 2: // '\002'
            return y.PickUpInStore;

        case 3: // '\003'
            return y.AddToList;
        }
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "linkPosition", a(mFulfillment));
        com.target.ui.analytics.a.i.a(map, "products", com.target.ui.analytics.a.i.a(mProductDetails));
        com.target.ui.analytics.a.i.a(map, "tapActionName", a(mProductDetails, mFulfillment));
        return map;
    }

    protected s c()
    {
        return com.target.ui.analytics.a.s.ProductDetails;
    }

    protected List d()
    {
        return com.target.ui.analytics.a.i.a(mPageItemHierarchy);
    }

    protected y i()
    {
        return b(mFulfillment);
    }

}
