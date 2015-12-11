// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;

import com.amazon.mShop.control.account.OneClickListener;
import com.amazon.mShop.wearable.model.MobileState;

// Referenced classes of package com.amazon.mShop.wearable.wear:
//            MShopWearListenerService

static final class 
    implements OneClickListener
{

    public void oneClickStatusChanged(boolean flag)
    {
        MShopWearListenerService.access$700().oneClickEnabled = flag;
        MShopWearListenerService.access$600();
    }

    ()
    {
    }
}
