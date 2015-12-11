// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.List;

public class bgc
    implements cpu
{

    public String a;
    public bfp b;
    public boolean c;
    public boolean d;
    public boolean e;
    public String f;
    public List g;
    public List h;
    public List i;
    public List j;
    public List k;
    bfu l;
    boolean m;
    String n;
    private byte o[];

    public bgc()
    {
        b = new bfp(bft.c, 0L);
        c = false;
        d = false;
        e = false;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = false;
        o = bqd.a;
    }

    static List a(bgc bgc1, List list)
    {
        bgc1.h = list;
        return list;
    }

    static List b(bgc bgc1, List list)
    {
        bgc1.i = list;
        return list;
    }

    static List c(bgc bgc1, List list)
    {
        bgc1.j = list;
        return list;
    }

    public final bfz a()
    {
        String s;
        String s1;
        bfp bfp1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (!TextUtils.isEmpty(a))
        {
            s = a;
        } else
        {
            s = String.valueOf(String.valueOf(SystemClock.currentThreadTimeMillis()));
            if (s.length() != 0)
            {
                s = "_INTERNAL_".concat(s);
            } else
            {
                s = new String("_INTERNAL_");
            }
        }
        bfp1 = b;
        flag = c;
        flag1 = d;
        flag2 = e;
        if (f == null)
        {
            s1 = "";
        } else
        {
            s1 = f;
        }
        return new bfz(bfp1, flag, flag1, flag2, s, s1, o, g, h, i, j, k, l, m, n);
    }

    public final bgc a(byte abyte0[])
    {
        o = (byte[])b.a(abyte0);
        return this;
    }

    public final Object b()
    {
        return a();
    }
}
