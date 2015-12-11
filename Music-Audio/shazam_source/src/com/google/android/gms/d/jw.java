// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;


public final class jw
{
    public static final class a
    {

        final String a;
        boolean b;
        boolean c;
        public String d;

        public final jw a()
        {
            return new jw(this, (byte)0);
        }

        public a(String s)
        {
            b = true;
            c = false;
            a = s;
        }
    }


    final boolean a;
    final boolean b;
    final String c;
    public final String d;

    private jw(a a1)
    {
        d = a1.a;
        a = a1.b;
        b = a1.c;
        c = a1.d;
    }

    jw(a a1, byte byte0)
    {
        this(a1);
    }
}
