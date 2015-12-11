// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import com.amazon.mShop.aiv.AmazonInstantVideoProxy;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;

// Referenced classes of package com.amazon.mShop:
//            AmazonApplication

private static class <init>
    implements UserListener
{

    private void forceRefreshAccount()
    {
        AmazonInstantVideoProxy.getInstance().forceRefreshAccount();
    }

    public void userSignedIn(User user)
    {
        forceRefreshAccount();
    }

    public void userSignedOut()
    {
        forceRefreshAccount();
    }

    public void userUpdated(User user)
    {
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
