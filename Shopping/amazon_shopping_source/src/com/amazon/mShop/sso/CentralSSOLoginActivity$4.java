// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import com.amazon.mShop.model.auth.User;

// Referenced classes of package com.amazon.mShop.sso:
//            CentralSSOLoginActivity

class val.user
    implements Runnable
{

    final CentralSSOLoginActivity this$0;
    final User val$user;

    public void run()
    {
        User.userSignedIn(val$user);
    }

    ()
    {
        this$0 = final_centralssologinactivity;
        val$user = User.this;
        super();
    }
}
