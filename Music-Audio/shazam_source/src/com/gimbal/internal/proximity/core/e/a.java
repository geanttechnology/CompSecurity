// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.e;

import com.gimbal.internal.proximity.core.c.c;
import com.gimbal.internal.proximity.core.c.e;
import com.gimbal.internal.proximity.core.c.g;
import com.gimbal.internal.proximity.core.sighting.i;

public final class a
{

    private static a d;
    public c a;
    public final i b = new i();
    private e c;

    private a()
    {
        java.util.UUID auuid[] = g.a();
        c = new e();
        a = new c(auuid);
    }

    public static a a()
    {
        if (d == null)
        {
            d = new a();
        }
        return d;
    }
}
