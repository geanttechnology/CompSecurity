// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import java.util.HashMap;
import java.util.Map;

public final class y
{
    public static final class a
    {

        public Map a;

        public final a a(String s, String s1)
        {
            a.put(s, s1);
            return this;
        }

        public final y a()
        {
            return new y(this, (byte)0);
        }

        public a()
        {
            a = new HashMap();
        }
    }


    public static final y a = (new a()).a();
    Map b;

    private y()
    {
    }

    private y(a a1)
    {
        b = a1.a;
    }

    y(a a1, byte byte0)
    {
        this(a1);
    }

}
