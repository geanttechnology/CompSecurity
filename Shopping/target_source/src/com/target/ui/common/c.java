// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.common;

import com.google.a.a.e;
import com.target.mothership.common.product.d;
import com.target.mothership.common.product.i;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductStoreInfo;
import com.target.ui.util.f.a;

public class c
{

    private String mAisleText;
    private boolean mCanShowAisle;
    private d mDepartment;

    public c(ProductDetails productdetails)
    {
        mCanShowAisle = false;
        a(productdetails);
    }

    private void a(ProductDetails productdetails)
    {
        if (productdetails.i().equals(com.target.mothership.common.product.c.ONLINE_ONLY))
        {
            mCanShowAisle = false;
            return;
        }
        if (!productdetails.u().a())
        {
            mCanShowAisle = false;
            return;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$product$InventoryStatus[];

            static 
            {
                $SwitchMap$com$target$mothership$common$product$InventoryStatus = new int[i.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.PreOrder.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.UnAvailable.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.NotAvailable.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.PreOrderNonSellable.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.product.InventoryStatus[productdetails.u().c().ordinal()])
        {
        default:
            mCanShowAisle = true;
            break;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            break MISSING_BLOCK_LABEL_117;
        }
_L1:
        productdetails = com.target.ui.util.f.a.a(productdetails);
        if (com.target.ui.util.f.a.a.a.FOUND_NONE.equals(((com.target.ui.util.f.a.a) (productdetails)).mLocationLookupStatus))
        {
            mCanShowAisle = false;
            return;
        } else
        {
            mAisleText = ((com.target.ui.util.f.a.a) (productdetails)).mAisle;
            mDepartment = ((com.target.ui.util.f.a.a) (productdetails)).mDepartment;
            return;
        }
        mCanShowAisle = false;
          goto _L1
    }

    public e a()
    {
        return e.c(mAisleText);
    }

    public e b()
    {
        return e.c(mDepartment);
    }

    public boolean c()
    {
        return mCanShowAisle;
    }
}
