// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.location.Location;
import com.google.android.gms.ads.c.k;
import com.google.android.gms.ads.internal.client.z;

public final class c
{
    public static final class a
    {

        public final com.google.android.gms.ads.internal.client.z.a a = new com.google.android.gms.ads.internal.client.z.a();

        public final a a(int i)
        {
            a.i = i;
            return this;
        }

        public final a a(Location location)
        {
            a.j = location;
            return this;
        }

        public final a a(k k)
        {
            a.a(k);
            return this;
        }

        public final c a()
        {
            return new c(this, (byte)0);
        }

        public a()
        {
            a.a(c.a);
        }
    }


    public static final String a;
    public final z b;

    private c(a a1)
    {
        b = new z(a1.a);
    }

    c(a a1, byte byte0)
    {
        this(a1);
    }

    static 
    {
        a = z.a;
    }
}
