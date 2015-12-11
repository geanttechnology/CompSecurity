// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.a;

import com.mopub.mobileads.m;
import java.lang.reflect.Constructor;

public final class e
{

    private static e a = new e();

    public e()
    {
    }

    public static m a(String s)
    {
        s = Class.forName(s).asSubclass(com/mopub/mobileads/m).getDeclaredConstructor(null);
        s.setAccessible(true);
        return (m)s.newInstance(new Object[0]);
    }

}
