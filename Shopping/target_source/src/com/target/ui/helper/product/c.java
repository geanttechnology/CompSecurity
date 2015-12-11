// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.product;

import com.target.mothership.common.product.i;
import com.target.mothership.model.product.interfaces.ProductAgeRestriction;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductOnlineInfo;
import com.target.mothership.model.product.interfaces.ProductStoreInfo;

// Referenced classes of package com.target.ui.helper.product:
//            b

public class c
{
    public static interface a
    {

        public abstract void a(ProductDetails productdetails, b b1);

        public abstract void a(ProductDetails productdetails, b b1, String s);

        public abstract void b(ProductDetails productdetails, b b1);

        public abstract void c(ProductDetails productdetails, b b1);

        public abstract void d(ProductDetails productdetails, b b1);
    }


    private static final String TAG = com/target/ui/helper/product/c.getSimpleName();

    public c()
    {
    }

    public static boolean a(ProductDetails productdetails)
    {
_L2:
        return false;
        if (productdetails == null || !productdetails.c().a()) goto _L2; else goto _L1
_L1:
        productdetails = productdetails.c().c();
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$product$InventoryStatus[];
            static final int $SwitchMap$com$target$ui$helper$product$AddToCartItemType[];

            static 
            {
                $SwitchMap$com$target$ui$helper$product$AddToCartItemType = new int[com.target.ui.helper.product.b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.PICK_UP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                $SwitchMap$com$target$mothership$common$product$InventoryStatus = new int[i.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.OutOfStock.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.UNKNOWN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.LimitedStock.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.NotSoldInThisStore.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.UnAvailable.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.CurrentlyNotOnSale.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.NotAvailable.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.product.InventoryStatus[productdetails.ordinal()])
        {
        default:
            return true;

        case 1: // '\001'
        case 2: // '\002'
            break;
        }
        if (true) goto _L2; else goto _L3
_L3:
    }

    public static boolean b(ProductDetails productdetails)
    {
_L2:
        return false;
        if (productdetails == null || !productdetails.l() || !productdetails.u().a()) goto _L2; else goto _L1
_L1:
        productdetails = productdetails.u().c();
        switch (_cls1..SwitchMap.com.target.mothership.common.product.InventoryStatus[productdetails.ordinal()])
        {
        default:
            return true;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            break;
        }
        if (true) goto _L2; else goto _L3
_L3:
    }

    public void a(ProductDetails productdetails, b b1, boolean flag, a a1)
    {
        if (productdetails == null)
        {
            return;
        }
        if (productdetails.H())
        {
            a1.a(productdetails, b1);
            return;
        }
        if (flag && productdetails.t().a())
        {
            a1.a(productdetails, b1, productdetails.t().b());
            return;
        }
        switch (_cls1..SwitchMap.com.target.ui.helper.product.AddToCartItemType[b1.ordinal()])
        {
        default:
            if (a(productdetails))
            {
                a1.d(productdetails, b1);
                return;
            } else
            {
                a1.c(productdetails, b1);
                return;
            }

        case 1: // '\001'
            break;
        }
        if (b(productdetails))
        {
            a1.d(productdetails, b1);
            return;
        } else
        {
            a1.b(productdetails, b1);
            return;
        }
    }

}
