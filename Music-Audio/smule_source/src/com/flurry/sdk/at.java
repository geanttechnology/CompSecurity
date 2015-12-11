// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            fd, as

public class at
{

    private static int a = 1;
    private int b;
    private long c;
    private String d;
    private List e;

    private at()
    {
    }


    public at(String s)
    {
        int i = a;
        a = i + 1;
        b = i;
        c = fd.a().c();
        d = s;
        e = new ArrayList();
    }

    static int a(at at1)
    {
        return at1.b;
    }

    static int a(at at1, int i)
    {
        at1.b = i;
        return i;
    }

    static long a(at at1, long l)
    {
        at1.c = l;
        return l;
    }

    static String a(at at1, String s)
    {
        at1.d = s;
        return s;
    }

    static List a(at at1, List list)
    {
        at1.e = list;
        return list;
    }

    static long b(at at1)
    {
        return at1.c;
    }

    static String c(at at1)
    {
        return at1.d;
    }

    static List d(at at1)
    {
        return at1.e;
    }

    public int a()
    {
        return b;
    }

    public void a(as as)
    {
        e.add(as);
    }

    public String b()
    {
        return d;
    }

    public long c()
    {
        return c;
    }

    public List d()
    {
        return e;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof at))
            {
                return false;
            }
            obj = (at)obj;
            if (b != ((at) (obj)).b || c != ((at) (obj)).c || !TextUtils.equals(d, ((at) (obj)).d) || e != ((at) (obj)).e && (e == null || !e.equals(((at) (obj)).e)))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = (int)((long)(0x11 ^ b) ^ c);
        int i = j;
        if (d != null)
        {
            i = j ^ d.hashCode();
        }
        j = i;
        if (e != null)
        {
            j = i ^ e.hashCode();
        }
        return j;
    }

}
