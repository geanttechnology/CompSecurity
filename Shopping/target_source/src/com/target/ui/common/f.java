// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.common;

import com.google.a.a.e;
import com.target.mothership.common.product.c;
import com.target.mothership.common.product.i;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductGuestReview;
import com.target.mothership.model.product.interfaces.ProductStoreInfo;

public class f
{

    private ProductGuestReview mProductGuestReview;
    private boolean mShowFindInNearByStores;

    public f(ProductDetails productdetails)
    {
        mShowFindInNearByStores = false;
        a(productdetails);
        mProductGuestReview = (ProductGuestReview)productdetails.j().d();
    }

    private void a(ProductDetails productdetails)
    {
        if (productdetails.i().equals(c.ONLINE_ONLY))
        {
            mShowFindInNearByStores = false;
            return;
        }
        i j = i.UNKNOWN;
        if (productdetails.u().a())
        {
            j = productdetails.u().c();
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$product$InventoryStatus[];

            static 
            {
                $SwitchMap$com$target$mothership$common$product$InventoryStatus = new int[i.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.NotAvailable.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.NotSoldInThisStore.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.CurrentlyNotOnSale.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.PreOrder.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.PreOrderNonSellable.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.product.InventoryStatus[j.ordinal()])
        {
        default:
            mShowFindInNearByStores = true;
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            mShowFindInNearByStores = false;
            break;
        }
    }

    public boolean a()
    {
        return mShowFindInNearByStores;
    }

    public e b()
    {
        return e.c(mProductGuestReview);
    }
}
