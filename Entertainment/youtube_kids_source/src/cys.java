// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import java.util.UUID;

public class cys
    implements Comparable
{

    public final cyt b;
    public final cyt c;
    public final String d;
    public final int e;

    public cys(long l, long l1, int i, String s)
    {
        String s1;
        boolean flag;
        if (l <= l1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        b = new cyt(this, cyu.a, l);
        c = new cyt(this, cyu.b, l1);
        e = i;
        s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = UUID.randomUUID().toString();
        }
        d = s1;
    }

    public static cyt b(long l)
    {
        return (new cys(l, l, 0x80000000, "\0")).b;
    }

    public final long a()
    {
        return b.b;
    }

    public final boolean a(long l)
    {
        return l >= a() && (l < b() || l == b() && a() == b());
    }

    public final long b()
    {
        return c.b;
    }

    public int compareTo(Object obj)
    {
        obj = (cys)obj;
        return b.a(((cys) (obj)).b);
    }

    public String toString()
    {
        String s1 = String.valueOf(Long.toString(a()));
        String s2 = String.valueOf(Long.toString(b()));
        String s;
        if (a() == b())
        {
            s = "]";
        } else
        {
            s = ")";
        }
        return (new StringBuilder(String.valueOf(s1).length() + 11 + String.valueOf(s2).length() + String.valueOf(s).length())).append("Interval[").append(s1).append(", ").append(s2).append(s).toString();
    }
}
