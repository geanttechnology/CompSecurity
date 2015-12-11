// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.g;

import com.gimbal.internal.proximity.core.f.e;

public final class b
{

    private static b b;
    public e a;

    private b()
    {
        a = new com.gimbal.internal.proximity.core.f.b(java/lang/String, "proximity.payloads");
    }

    public static b a()
    {
        if (b == null)
        {
            b = new b();
        }
        return b;
    }

    public static String a(String s)
    {
        String s1 = null;
        if (s != null)
        {
            s1 = s.toUpperCase();
        }
        return s1;
    }
}
