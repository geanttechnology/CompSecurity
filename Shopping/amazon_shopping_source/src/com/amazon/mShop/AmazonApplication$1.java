// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;

// Referenced classes of package com.amazon.mShop:
//            AmazonApplication

static final class ner
    implements UserListener
{

    public void userSignedIn(User user)
    {
        AmazonApplication.access$300(true);
    }

    public void userSignedOut()
    {
        AmazonApplication.access$300(false);
    }

    public void userUpdated(User user)
    {
    }

    ner()
    {
    }
}
