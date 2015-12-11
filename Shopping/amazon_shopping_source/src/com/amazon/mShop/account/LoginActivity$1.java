// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.account;

import com.amazon.rio.j2me.client.services.mShop.Notification;

// Referenced classes of package com.amazon.mShop.account:
//            LoginActivity

class .Notification
    implements com.amazon.mShop.primeupsell.r.PrimeUpsellSubscriber
{

    final LoginActivity this$0;
    final Notification val$notification;
    final boolean val$successful;

    public void onComplete(boolean flag)
    {
        LoginActivity.access$100(LoginActivity.this, val$successful, null);
    }

    public void onPageLoadFinished()
    {
        LoginActivity.access$200(LoginActivity.this, val$successful);
    }

    public void onUserCancel()
    {
        LoginActivity.access$100(LoginActivity.this, val$successful, val$notification);
    }

    .Notification()
    {
        this$0 = final_loginactivity;
        val$successful = flag;
        val$notification = Notification.this;
        super();
    }
}
