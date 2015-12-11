// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.al;

import java.io.Serializable;

public final class c
    implements Serializable
{
    public static final class a
    {

        public boolean a;
        public String b;
        public String c;

        public final c a()
        {
            return new c(this, (byte)0);
        }

        public a()
        {
        }
    }


    public final boolean a;
    public final String b;
    public final String c;

    private c(a a1)
    {
        a = a1.a;
        b = a1.b;
        c = a1.c;
    }

    c(a a1, byte byte0)
    {
        this(a1);
    }
}
