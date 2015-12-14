// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads.factories;

import com.mopub.common.Preconditions;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.MoPubCustomEventNative;
import java.lang.reflect.Constructor;

public class CustomEventNativeFactory
{

    protected static CustomEventNativeFactory instance = new CustomEventNativeFactory();

    public CustomEventNativeFactory()
    {
    }

    public static CustomEventNative create(String s)
    {
        if (s != null)
        {
            s = Class.forName(s).asSubclass(com/mopub/nativeads/CustomEventNative);
            return instance.internalCreate(s);
        } else
        {
            return new MoPubCustomEventNative();
        }
    }

    public static void setInstance(CustomEventNativeFactory customeventnativefactory)
    {
        Preconditions.checkNotNull(customeventnativefactory);
        instance = customeventnativefactory;
    }

    protected CustomEventNative internalCreate(Class class1)
    {
        Preconditions.checkNotNull(class1);
        class1 = class1.getDeclaredConstructor(null);
        class1.setAccessible(true);
        return (CustomEventNative)class1.newInstance(new Object[0]);
    }

}
