// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.models;


// Referenced classes of package com.immersion.hapticmediasdk.models:
//            HapticFileInformation

public static final class h
{

    public static int g = 66;
    public static int h = 1;
    public static int i = 2;
    public static int j;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e[];
    public int f;
    private String k;
    private int l;
    private int m;
    private int n;
    private int o;

    public static String a(h h1)
    {
        h1 = h1.k;
        if (((g + h) * g) % i != j)
        {
            g = 61;
            j = 58;
        }
        return h1;
    }

    public static int b(j j1)
    {
        if (((g + h) * g) % i != 0)
        {
            g = 41;
            j = 36;
        }
        int i1;
        try
        {
            i1 = j1.l;
        }
        // Misplaced declaration of an exception variable
        catch (j j1)
        {
            throw j1;
        }
        return i1;
    }

    public static int c(l l1)
    {
        if (((h + 61) * 61) % i != j)
        {
            g = 61;
            j = 61;
        }
        return l1.a;
    }

    public static int d(a a1)
    {
        if (((g + h) * g) % i != j)
        {
            g = 61;
            j = 61;
        }
        return a1.b;
    }

    public static int e(b b1)
    {
        int i1 = b1.c;
        int j1 = g;
        switch ((j1 * (j1 + 1)) % i)
        {
        default:
            g = 76;
            j = 93;
            // fall through

        case 0: // '\0'
            return i1;
        }
    }

    public final j a(int i1)
    {
        if (((g + h) * g) % i != j)
        {
            g = 61;
            j = 61;
        }
        try
        {
            l = i1;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return this;
    }

    public final l a(String s)
    {
        try
        {
            k = s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        return this;
    }

    public final k b(int i1)
    {
        int j1 = g;
        switch ((j1 * (j1 + 1)) % 2)
        {
        default:
            g = 71;
            j = 41;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            m = i1;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return this;
    }

    public final m c(int i1)
    {
        if (((g + h) * g) % i != 0)
        {
            g = 14;
            j = 61;
        }
        try
        {
            n = i1;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return this;
    }

    public final n d(int i1)
    {
        if (((g + h) * g) % i != j)
        {
            g = 61;
            j = 61;
        }
        try
        {
            o = i1;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return this;
    }

    public A()
    {
        int i1 = g;
        switch ((i1 * (h + i1)) % i)
        {
        default:
            g = 47;
            h = 60;
            // fall through

        case 0: // '\0'
            super();
            break;
        }
    }
}
