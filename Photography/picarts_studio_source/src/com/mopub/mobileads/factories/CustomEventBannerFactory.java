// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventBanner;
import java.lang.reflect.Constructor;

public class CustomEventBannerFactory
{

    private static CustomEventBannerFactory instance = new CustomEventBannerFactory();

    public CustomEventBannerFactory()
    {
    }

    public static CustomEventBanner create(String s)
    {
        return instance.internalCreate(s);
    }

    public static void setInstance(CustomEventBannerFactory customeventbannerfactory)
    {
        instance = customeventbannerfactory;
    }

    protected CustomEventBanner internalCreate(String s)
    {
        s = Class.forName(s).asSubclass(com/mopub/mobileads/CustomEventBanner).getDeclaredConstructor(null);
        s.setAccessible(true);
        return (CustomEventBanner)s.newInstance(new Object[0]);
    }

}
