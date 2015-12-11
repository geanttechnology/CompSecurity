// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;

import android.os.Build;

class d
{

    static final d d = new d();
    static final d e = new d("unknown", "generic", "generic");
    static final d f = new d("unknown", "generic_x86", "Android");
    public final String a;
    public final String b;
    public final String c;

    d()
    {
        a = Build.BOARD;
        b = Build.DEVICE;
        c = Build.BRAND;
    }

    d(String s, String s1, String s2)
    {
        a = s;
        b = s1;
        c = s2;
    }

    private static boolean a(String s, String s1)
    {
        if (s != null)
        {
            return s.equals(s1);
        }
        return s == s1;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof d)
        {
            if (a(a, ((d) (obj = (d)obj)).a) && a(b, ((d) (obj)).b) && a(c, ((d) (obj)).c))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        int j = 0;
        if (a != null)
        {
            j = 0 + a.hashCode();
        }
        int i = j;
        if (b != null)
        {
            i = j + b.hashCode();
        }
        j = i;
        if (c != null)
        {
            j = i + c.hashCode();
        }
        return j;
    }

}
