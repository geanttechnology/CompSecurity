// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;


public abstract class n
{

    private static final n a = new n() {

        public final long a()
        {
            return System.nanoTime();
        }

    };

    public n()
    {
    }

    public static n b()
    {
        return a;
    }

    public abstract long a();

}
