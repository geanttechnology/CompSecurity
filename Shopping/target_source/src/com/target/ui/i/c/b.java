// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.i.c;

import com.google.a.a.e;
import com.target.mothership.common.product.c;
import com.target.mothership.common.product.d;
import com.target.mothership.common.product.h;
import com.target.mothership.common.product.i;
import com.target.mothership.common.product.m;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductOnlineInfo;
import com.target.mothership.model.product.interfaces.ProductStoreInfo;
import com.target.ui.common.ProductFulfillmentOptions;
import java.util.Iterator;
import java.util.List;

public class b
{

    public static ProductFulfillmentOptions a(ProductDetails productdetails, boolean flag)
    {
        ProductFulfillmentOptions productfulfillmentoptions = new ProductFulfillmentOptions();
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$product$Channel[];
            static final int $SwitchMap$com$target$mothership$common$product$InventoryStatus[];

            static 
            {
                $SwitchMap$com$target$mothership$common$product$InventoryStatus = new int[i.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.OutOfStock.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.UnAvailable.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.NotAvailable.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.UNKNOWN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.OnBackorder.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.NotSoldInThisStore.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.CurrentlyNotOnSale.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.PreOrder.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.PreOrderNonSellable.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.LimitedStock.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.InStock.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$target$mothership$common$product$Channel = new int[com.target.mothership.common.product.c.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Channel[c.STORE_ONLY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Channel[c.ONLINE_ONLY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Channel[c.ONLINE_STORES.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Channel[c.UNKNOWN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.target.mothership.common.product.Channel[productdetails.i().ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 88
    //                   2 102
    //                   3 115;
           goto _L1 _L2 _L3 _L4
_L1:
        if (flag)
        {
            productfulfillmentoptions.d(false);
        }
        if (productdetails.I())
        {
            productfulfillmentoptions.e(false);
            productfulfillmentoptions.d(false);
        }
        productfulfillmentoptions.c(false);
        productfulfillmentoptions.h(false);
        return productfulfillmentoptions;
_L2:
        c(productfulfillmentoptions, productdetails, flag);
        e(productfulfillmentoptions, productdetails);
        continue; /* Loop/switch isn't completed */
_L3:
        b(productfulfillmentoptions, productdetails);
        f(productfulfillmentoptions, productdetails);
        continue; /* Loop/switch isn't completed */
_L4:
        d(productfulfillmentoptions, productdetails, flag);
        g(productfulfillmentoptions, productdetails);
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static ProductFulfillmentOptions a(List list)
    {
        ProductFulfillmentOptions productfulfillmentoptions = new ProductFulfillmentOptions();
        productfulfillmentoptions.m(false);
        productfulfillmentoptions.i(false);
        productfulfillmentoptions.j(false);
        for (list = list.iterator(); list.hasNext();)
        {
            ProductDetails productdetails = (ProductDetails)list.next();
            Iterator iterator = productdetails.A().iterator();
            while (iterator.hasNext()) 
            {
                h h1 = (h)iterator.next();
                if (h1.equals(h.MAIL))
                {
                    productfulfillmentoptions.f(true);
                    productfulfillmentoptions.m(true);
                    if (productdetails.c().h())
                    {
                        productfulfillmentoptions.b(0x7f0904fc);
                    } else
                    {
                        productfulfillmentoptions.b(0x7f0904fd);
                    }
                } else
                if (h1.equals(h.EMAIL))
                {
                    productfulfillmentoptions.a(true);
                    productfulfillmentoptions.i(true);
                    productfulfillmentoptions.f(0x7f0902f2);
                } else
                if (h1.equals(h.MOBILE))
                {
                    productfulfillmentoptions.b(true);
                    productfulfillmentoptions.j(true);
                    productfulfillmentoptions.g(0x7f090502);
                }
            }
        }

        productfulfillmentoptions.h(true);
        productfulfillmentoptions.e(0x7f0900d4);
        productfulfillmentoptions.o(true);
        return productfulfillmentoptions;
    }

    private static void a(ProductFulfillmentOptions productfulfillmentoptions, ProductDetails productdetails)
    {
        b(productfulfillmentoptions, productdetails);
        d(productfulfillmentoptions, productdetails);
    }

    private static void a(ProductFulfillmentOptions productfulfillmentoptions, ProductDetails productdetails, boolean flag)
    {
        c(productfulfillmentoptions, productdetails, flag);
        c(productfulfillmentoptions, productdetails);
    }

    private static boolean a(i j)
    {
        switch (_cls1..SwitchMap.com.target.mothership.common.product.InventoryStatus[j.ordinal()])
        {
        default:
            return true;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            return false;
        }
    }

    private static boolean a(ProductDetails productdetails)
    {
        m m1;
        if (productdetails.c().a())
        {
            if ((m1 = productdetails.c().e()).equals(m.PickUpInStore) || a(productdetails.c().c()) && m1.equals(m.ShipToStore))
            {
                return true;
            }
        }
        return false;
    }

    private static ProductFulfillmentOptions b(ProductDetails productdetails)
    {
        ProductFulfillmentOptions productfulfillmentoptions = new ProductFulfillmentOptions();
        Iterator iterator = productdetails.A().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            h h1 = (h)iterator.next();
            if (h1.equals(h.MAIL))
            {
                productfulfillmentoptions.f(true);
                if (productdetails.c().h())
                {
                    productfulfillmentoptions.b(0x7f0904fc);
                } else
                {
                    productfulfillmentoptions.b(0x7f0904fd);
                }
                productfulfillmentoptions.m(true);
            } else
            if (h1.equals(h.EMAIL))
            {
                productfulfillmentoptions.a(true);
                productfulfillmentoptions.i(true);
                productfulfillmentoptions.f(0x7f0902f2);
            } else
            if (h1.equals(h.MOBILE))
            {
                productfulfillmentoptions.b(true);
                productfulfillmentoptions.j(true);
                productfulfillmentoptions.g(0x7f090502);
            }
        } while (true);
        return productfulfillmentoptions;
    }

    public static ProductFulfillmentOptions b(ProductDetails productdetails, boolean flag)
    {
        if (productdetails.B())
        {
            productdetails = b(productdetails);
        } else
        if (productdetails.I())
        {
            productdetails = new ProductFulfillmentOptions();
        } else
        {
            productdetails = c(productdetails, flag);
        }
        productdetails.h(true);
        productdetails.e(0x7f0900d4);
        productdetails.o(true);
        return productdetails;
    }

    private static void b(ProductFulfillmentOptions productfulfillmentoptions, ProductDetails productdetails)
    {
        if (productdetails.I())
        {
            productfulfillmentoptions.e(false);
            return;
        } else
        {
            productfulfillmentoptions.e(true);
            return;
        }
    }

    private static void b(ProductFulfillmentOptions productfulfillmentoptions, ProductDetails productdetails, boolean flag)
    {
        a(productfulfillmentoptions, productdetails);
        a(productfulfillmentoptions, productdetails, flag);
    }

    private static ProductFulfillmentOptions c(ProductDetails productdetails, boolean flag)
    {
        ProductFulfillmentOptions productfulfillmentoptions = new ProductFulfillmentOptions();
        if (a(productdetails))
        {
            b(productfulfillmentoptions, productdetails, flag);
            return productfulfillmentoptions;
        }
        switch (_cls1..SwitchMap.com.target.mothership.common.product.Channel[productdetails.i().ordinal()])
        {
        default:
            return productfulfillmentoptions;

        case 1: // '\001'
            a(productfulfillmentoptions, productdetails, flag);
            productfulfillmentoptions.l(false);
            productfulfillmentoptions.e(true);
            productfulfillmentoptions.a(0x7f0903e6);
            return productfulfillmentoptions;

        case 2: // '\002'
            a(productfulfillmentoptions, productdetails);
            productfulfillmentoptions.c(true);
            productfulfillmentoptions.n(false);
            productfulfillmentoptions.k(false);
            productfulfillmentoptions.d(false);
            productfulfillmentoptions.d(0x7f0903e7);
            return productfulfillmentoptions;

        case 3: // '\003'
            b(productfulfillmentoptions, productdetails, flag);
            return productfulfillmentoptions;

        case 4: // '\004'
            productfulfillmentoptions.c(true);
            break;
        }
        productfulfillmentoptions.n(false);
        productfulfillmentoptions.e(true);
        productfulfillmentoptions.l(false);
        return productfulfillmentoptions;
    }

    private static void c(ProductFulfillmentOptions productfulfillmentoptions, ProductDetails productdetails)
    {
        int k;
        boolean flag;
        int l;
        boolean flag1;
        boolean flag2;
        flag2 = true;
        boolean flag3 = a(productdetails);
        l = 0x7f0902fe;
        i j;
        if (!productdetails.G())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = i.UNKNOWN;
        if (productdetails.u().a())
        {
            j = productdetails.u().c();
        }
        _cls1..SwitchMap.com.target.mothership.common.product.InventoryStatus[j.ordinal()];
        JVM INSTR tableswitch 2 9: default 108
    //                   2 151
    //                   3 151
    //                   4 108
    //                   5 142
    //                   6 160
    //                   7 160
    //                   8 160
    //                   9 160;
           goto _L1 _L2 _L2 _L1 _L3 _L4 _L4 _L4 _L4
_L1:
        if (flag3)
        {
            k = 0x7f090405;
        } else
        {
            k = 0x7f0902fe;
        }
        flag1 = true;
_L6:
        if (flag3)
        {
            productfulfillmentoptions.c(0x7f090405);
            productfulfillmentoptions.k(true);
            return;
        }
        break; /* Loop/switch isn't completed */
_L3:
        k = 0x7f0900dc;
        flag1 = true;
        continue; /* Loop/switch isn't completed */
_L2:
        flag1 = false;
        k = 0x7f0903e3;
        continue; /* Loop/switch isn't completed */
_L4:
        flag1 = false;
        k = 0x7f0903e8;
        if (true) goto _L6; else goto _L5
_L5:
        if (flag)
        {
            flag2 = flag1;
        }
        if (flag2)
        {
            k = l;
        }
        productfulfillmentoptions.d(k);
        productfulfillmentoptions.n(flag2);
        return;
    }

    private static void c(ProductFulfillmentOptions productfulfillmentoptions, ProductDetails productdetails, boolean flag)
    {
        if (productdetails.I())
        {
            productfulfillmentoptions.g(false);
            productfulfillmentoptions.d(false);
            return;
        }
        com.target.ui.common.c c1 = new com.target.ui.common.c(productdetails);
        if (c1.c() && flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        productfulfillmentoptions.g(flag);
        productfulfillmentoptions.a((String)c1.a().d());
        productfulfillmentoptions.a((d)c1.b().d());
        if (a(productdetails))
        {
            productfulfillmentoptions.d(true);
            productfulfillmentoptions.c(false);
            return;
        } else
        {
            productfulfillmentoptions.d(false);
            productfulfillmentoptions.c(true);
            return;
        }
    }

    private static void d(ProductFulfillmentOptions productfulfillmentoptions, ProductDetails productdetails)
    {
        if (!productdetails.c().a())
        {
            return;
        }
        productfulfillmentoptions.e(true);
        switch (_cls1..SwitchMap.com.target.mothership.common.product.InventoryStatus[productdetails.c().c().ordinal()])
        {
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        default:
            productfulfillmentoptions.l(false);
            productfulfillmentoptions.a(0x7f0903e6);
            return;

        case 10: // '\n'
        case 11: // '\013'
            productfulfillmentoptions.l(true);
            if (productdetails.c().h())
            {
                productfulfillmentoptions.a(0x7f0904fc);
                return;
            } else
            {
                productfulfillmentoptions.a(0x7f0904fd);
                return;
            }

        case 1: // '\001'
            productfulfillmentoptions.l(false);
            productfulfillmentoptions.a(0x7f0903f1);
            return;

        case 8: // '\b'
            productfulfillmentoptions.l(true);
            productfulfillmentoptions.a(0x7f090407);
            return;

        case 9: // '\t'
            productfulfillmentoptions.l(false);
            productfulfillmentoptions.a(0x7f0903e8);
            return;

        case 5: // '\005'
            productfulfillmentoptions.l(true);
            productfulfillmentoptions.a(0x7f0900dc);
            return;

        case 2: // '\002'
        case 3: // '\003'
            productfulfillmentoptions.l(false);
            productfulfillmentoptions.a(0x7f0903e3);
            return;
        }
    }

    private static void d(ProductFulfillmentOptions productfulfillmentoptions, ProductDetails productdetails, boolean flag)
    {
        c(productfulfillmentoptions, productdetails, flag);
        b(productfulfillmentoptions, productdetails);
    }

    private static void e(ProductFulfillmentOptions productfulfillmentoptions, ProductDetails productdetails)
    {
        i j;
        j = i.UNKNOWN;
        if (productdetails.u().a())
        {
            j = productdetails.u().c();
        }
        _cls1..SwitchMap.com.target.mothership.common.product.InventoryStatus[j.ordinal()];
        JVM INSTR tableswitch 5 11: default 80
    //                   5 88
    //                   6 80
    //                   7 80
    //                   8 88
    //                   9 80
    //                   10 88
    //                   11 88;
           goto _L1 _L2 _L1 _L1 _L2 _L1 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        productfulfillmentoptions.d(flag);
        return;
_L2:
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static void f(ProductFulfillmentOptions productfulfillmentoptions, ProductDetails productdetails)
    {
        i j;
        j = i.UNKNOWN;
        if (productdetails.c().a())
        {
            productfulfillmentoptions.e(false);
            j = productdetails.c().c();
        }
        _cls1..SwitchMap.com.target.mothership.common.product.InventoryStatus[j.ordinal()];
        JVM INSTR tableswitch 5 11: default 84
    //                   5 92
    //                   6 84
    //                   7 84
    //                   8 92
    //                   9 84
    //                   10 92
    //                   11 92;
           goto _L1 _L2 _L1 _L1 _L2 _L1 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        productfulfillmentoptions.e(flag);
        return;
_L2:
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static void g(ProductFulfillmentOptions productfulfillmentoptions, ProductDetails productdetails)
    {
        e(productfulfillmentoptions, productdetails);
        f(productfulfillmentoptions, productdetails);
    }
}
