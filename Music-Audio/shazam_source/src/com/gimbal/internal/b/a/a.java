// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.b.a;

import com.gimbal.internal.c.c;
import com.gimbal.internal.persistance.b;
import com.gimbal.internal.persistance.e;

public final class a
    implements e
{

    public static final com.gimbal.a.b a = com.gimbal.internal.c.c.f("SIGHTINGS");
    public boolean b;
    public boolean c;

    public a(com.gimbal.internal.c.a a1, b b1)
    {
        b = a1.a;
        c = b1.a();
        b1.a(this, new String[] {
            "Sightings_Logs"
        });
    }

    public final void a(String s, Object obj)
    {
        if ("Sightings_Logs".equals(s) && obj != null)
        {
            c = ((Boolean)obj).booleanValue();
        }
    }

}
