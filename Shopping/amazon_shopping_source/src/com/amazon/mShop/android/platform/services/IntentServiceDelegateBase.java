// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import com.amazon.mShop.android.platform.services.api.IAndroidIntentServiceProxy;

// Referenced classes of package com.amazon.mShop.android.platform.services:
//            ServiceDelegateBase

public class IntentServiceDelegateBase extends ServiceDelegateBase
{

    public IntentServiceDelegateBase(IntentService intentservice)
    {
        super(intentservice);
    }

    public IBinder onBind_impl(Intent intent)
    {
        return ((IAndroidIntentServiceProxy)(IntentService)mServiceProxy).superOnBind(intent);
    }

    public void onHandleIntent_impl(Intent intent)
    {
    }

    public void setIntentRedelivery_impl(boolean flag)
    {
        ((IAndroidIntentServiceProxy)(IntentService)mServiceProxy).superSetIntentRedelivery(flag);
    }
}
