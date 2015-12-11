// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class aon
{

    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public final int f;
    public final int g;
    public final int h;
    public int i;
    public int j;
    public final List k;
    public MediaFormat l;
    private int m;

    public aon(String s, int i1, int j1, int k1, float f1, int l1, int i2, 
            int j2, List list)
    {
        a = s;
        b = i1;
        c = j1;
        d = k1;
        e = f1;
        f = l1;
        g = i2;
        h = j2;
        s = list;
        if (list == null)
        {
            s = Collections.emptyList();
        }
        k = s;
        i = -1;
        j = -1;
    }

    public static aon a(String s, int i1, int j1, int k1, float f1, List list)
    {
        return new aon(s, i1, j1, k1, f1, -1, -1, -1, list);
    }

    public static aon a(String s, int i1, int j1, int k1, List list)
    {
        return new aon(s, i1, -1, -1, -1F, j1, k1, -1, list);
    }

    static final void a(MediaFormat mediaformat, String s, int i1)
    {
        if (i1 != -1)
        {
            mediaformat.setInteger(s, i1);
        }
    }

    public final void a(MediaFormat mediaformat)
    {
        a(mediaformat, "max-width", i);
        a(mediaformat, "max-height", j);
    }

    public boolean a(aon aon1, boolean flag)
    {
        if (b == aon1.b && c == aon1.c && d == aon1.d && e == aon1.e && (flag || i == aon1.i && j == aon1.j) && f == aon1.f && g == aon1.g && atp.a(a, aon1.a) && h == aon1.h && k.size() == aon1.k.size()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= k.size())
                {
                    break label1;
                }
                if (!Arrays.equals((byte[])k.get(i1), (byte[])aon1.k.get(i1)))
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (getClass() == obj.getClass())
                {
                    return a((aon)obj, false);
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        int j1 = 0;
        if (m == 0)
        {
            int i1;
            int k1;
            if (a == null)
            {
                i1 = 0;
            } else
            {
                i1 = a.hashCode();
            }
            k1 = (((((((((i1 + 527) * 31 + b) * 31 + c) * 31 + d) * 31 + Float.floatToRawIntBits(e)) * 31 + i) * 31 + j) * 31 + f) * 31 + g) * 31 + h;
            i1 = j1;
            j1 = k1;
            for (; i1 < k.size(); i1++)
            {
                j1 = Arrays.hashCode((byte[])k.get(i1)) + j1 * 31;
            }

            m = j1;
        }
        return m;
    }

    public final String toString()
    {
        String s = a;
        int i1 = b;
        int j1 = c;
        int k1 = d;
        float f1 = e;
        int l1 = f;
        int i2 = g;
        int j2 = h;
        int k2 = i;
        int l2 = j;
        return (new StringBuilder(String.valueOf(s).length() + 134)).append("MediaFormat(").append(s).append(", ").append(i1).append(", ").append(j1).append(", ").append(k1).append(", ").append(f1).append(", ").append(l1).append(", ").append(i2).append(", ").append(j2).append(", ").append(k2).append(", ").append(l2).append(")").toString();
    }
}
