// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;

import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;

// Referenced classes of package com.amazon.mShop.wearable.wear:
//            MShopWearListenerService

static final class 
    implements UserListener
{

    public void userSignedIn(User user)
    {
        MShopWearListenerService.access$600();
    }

    public void userSignedOut()
    {
        MShopWearListenerService.access$600();
    }

    public void userUpdated(User user)
    {
    }

    ()
    {
    }
}
