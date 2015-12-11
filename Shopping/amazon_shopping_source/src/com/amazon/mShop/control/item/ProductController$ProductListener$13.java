// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.rio.j2me.client.services.mShop.ExtraOfferListing;

// Referenced classes of package com.amazon.mShop.control.item:
//            ProductController

class val.value
    implements Runnable
{

    final s._cls0 this$1;
    final ExtraOfferListing val$value;

    public void run()
    {
        if (!ess._mth1300(this._cls1.this))
        {
            setExtraOfferListing(val$value);
            ProductController.access$700(_fld0);
        }
    }

    ()
    {
        this$1 = final_;
        val$value = ExtraOfferListing.this;
        super();
    }
}
