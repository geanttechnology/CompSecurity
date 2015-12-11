// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;


public abstract class j extends Enum
{

    public static final j a;
    public static final j b;
    public static final j c;
    public static final j d;
    public static final j e;
    private static final j f[];

    private j(String s, int i)
    {
        super(s, i);
    }

    j(String s, int i, byte byte0)
    {
        this(s, i);
    }

    public static j valueOf(String s)
    {
        return (j)Enum.valueOf(com/google/a/b/j, s);
    }

    public static j[] values()
    {
        return (j[])f.clone();
    }

    abstract boolean a();

    static 
    {
        a = new j("EXPLICIT") {

            final boolean a()
            {
                return false;
            }

        };
        b = new j("REPLACED") {

            final boolean a()
            {
                return false;
            }

        };
        c = new j("COLLECTED") {

            final boolean a()
            {
                return true;
            }

        };
        d = new j("EXPIRED") {

            final boolean a()
            {
                return true;
            }

        };
        e = new j("SIZE") {

            final boolean a()
            {
                return true;
            }

        };
        f = (new j[] {
            a, b, c, d, e
        });
    }
}
