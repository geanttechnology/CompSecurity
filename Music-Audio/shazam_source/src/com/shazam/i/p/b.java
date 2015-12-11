// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.p;

import com.shazam.i.b.at.a;
import com.shazam.model.Factory;
import com.shazam.n.l;

public final class b
{
    private static final class a
        implements Factory
    {

        public final Object create(Object obj)
        {
            return com.shazam.i.p.b.a();
        }

        private a()
        {
        }

        a(byte byte0)
        {
            this();
        }
    }


    public static l a()
    {
        return new l(com.shazam.i.b.at.a.a());
    }

    public static Factory b()
    {
        return new a((byte)0);
    }
}
