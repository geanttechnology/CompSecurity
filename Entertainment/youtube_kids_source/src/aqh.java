// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class aqh
    implements apw
{

    final aqg a;
    final byte b[];
    aoq c;
    int d;
    long e;
    long f;
    long g;
    long h;
    int i;
    int j;
    int k;
    int l;
    byte m[];
    String n;
    long o;
    long p;
    boolean q;
    long r;
    long s;
    long t;
    aon u;
    apx v;
    ath w;
    ath x;

    public aqh()
    {
        this(((aqg) (new aqd())));
    }

    private aqh(aqg aqg1)
    {
        b = new byte[3];
        e = -1L;
        f = -1L;
        g = 0xf4240L;
        h = -1L;
        i = -1;
        j = -1;
        k = -1;
        l = -1;
        r = -1L;
        s = -1L;
        t = -1L;
        a = aqg1;
        a.a(new aqi(this));
    }

    public final int a(asn asn, aoq aoq)
    {
        c = aoq;
        d = 0;
        do
        {
            if ((d & 0x27) != 0)
            {
                break;
            }
            int i1 = a.a(asn);
            if (i1 == 1)
            {
                d = d | 1;
            } else
            if (i1 == 2)
            {
                d = d | 2;
            }
        } while (true);
        c = null;
        return d;
    }

    long a(long l1)
    {
        return TimeUnit.NANOSECONDS.toMicros(g * l1);
    }

    public final apx a()
    {
        return v;
    }

    public final boolean a(long l1, boolean flag)
    {
        if (flag && v != null && s != -1L && t != -1L && l1 >= t)
        {
            int i1 = Arrays.binarySearch(v.f, s);
            if (i1 >= 0)
            {
                long l2 = s;
                if (l1 < v.e[i1] + l2)
                {
                    return false;
                }
            }
        }
        s = -1L;
        t = -1L;
        a.b();
        return true;
    }

    public final boolean b()
    {
        return false;
    }

    public final aon c()
    {
        return u;
    }

    public final Map d()
    {
        return null;
    }

    ArrayList e()
    {
        int i1;
        int j1;
        int k1;
        k1 = 0;
        try
        {
            if (m[0] != 2)
            {
                throw new aop("Error parsing vorbis codec private");
            }
        }
        catch (ArrayIndexOutOfBoundsException arrayindexoutofboundsexception)
        {
            throw new aop("Error parsing vorbis codec private");
        }
        i1 = 0;
        j1 = 1;
        while (m[j1] == -1) 
        {
            j1++;
            i1 += 255;
        }
        byte abyte0[] = m;
        int i2;
        int l1 = j1 + 1;
        i2 = i1 + abyte0[j1];
        j1 = l1;
        i1 = k1;
        for (; m[j1] == -1; j1++)
        {
            i1 += 255;
        }

        abyte0 = m;
        k1 = j1 + 1;
        j1 = abyte0[j1];
        if (m[k1] != 1)
        {
            throw new aop("Error parsing vorbis codec private");
        }
        abyte0 = new byte[i2];
        System.arraycopy(m, k1, abyte0, 0, i2);
        k1 = i2 + k1;
        if (m[k1] != 3)
        {
            throw new aop("Error parsing vorbis codec private");
        }
        i1 = i1 + j1 + k1;
        ArrayList arraylist;
        if (m[i1] != 5)
        {
            throw new aop("Error parsing vorbis codec private");
        }
        byte abyte1[] = new byte[m.length - i1];
        System.arraycopy(m, i1, abyte1, 0, m.length - i1);
        arraylist = new ArrayList(2);
        arraylist.add(abyte0);
        arraylist.add(abyte1);
        return arraylist;
    }
}
