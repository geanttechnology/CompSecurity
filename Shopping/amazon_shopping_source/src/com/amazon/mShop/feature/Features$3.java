// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.feature;

import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;

// Referenced classes of package com.amazon.mShop.feature:
//            Features

class this._cls0
    implements UserListener
{

    final Features this$0;

    public void userSignedIn(User user)
    {
        Features.access$400(Features.this);
    }

    public void userSignedOut()
    {
        Features.access$400(Features.this);
    }

    public void userUpdated(User user)
    {
    }

    ener()
    {
        this$0 = Features.this;
        super();
    }
}
