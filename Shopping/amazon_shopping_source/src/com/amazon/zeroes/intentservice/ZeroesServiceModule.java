// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice;

import android.content.SharedPreferences;
import com.amazon.zeroes.intentservice.persistence.SharedPreferencesCache;
import com.amazon.zeroes.intentservice.persistence.ZeroesCache;

// Referenced classes of package com.amazon.zeroes.intentservice:
//            DefaultZeroesPurchaseRequestDecorator, ZeroesPurchaseRequestDecorator

public class ZeroesServiceModule
{

    public ZeroesServiceModule()
    {
    }

    public ZeroesCache provideCache(SharedPreferences sharedpreferences)
    {
        return new SharedPreferencesCache(sharedpreferences);
    }

    public ZeroesPurchaseRequestDecorator providePurchaseRequestDecorator(DefaultZeroesPurchaseRequestDecorator defaultzeroespurchaserequestdecorator)
    {
        return defaultzeroespurchaserequestdecorator;
    }
}
