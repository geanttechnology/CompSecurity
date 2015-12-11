// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.a;

import com.mopub.mobileads.k;
import java.lang.reflect.Constructor;

public final class c
{

    private static c a = new c();

    public c()
    {
    }

    public static k a(String s)
    {
        s = Class.forName(s).asSubclass(com/mopub/mobileads/k).getDeclaredConstructor(null);
        s.setAccessible(true);
        return (k)s.newInstance(new Object[0]);
    }

}
