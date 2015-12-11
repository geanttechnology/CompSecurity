// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import afi;
import ahs;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class nn
    implements ahs, SafeParcelable
{

    public static final afi CREATOR = new afi();
    private final int a;
    private final String b;
    private final long c;
    private final short d;
    private final double e;
    private final double f;
    private final float g;
    private final int h;
    private final int i;
    private final int j;

    public nn(int k, String s, int l, short word0, double d1, double d2, float f1, long l1, int i1, int j1)
    {
        a(s);
        a(f1);
        a(d1, d2);
        l = a(l);
        a = k;
        d = word0;
        b = s;
        e = d1;
        f = d2;
        g = f1;
        c = l1;
        h = l;
        i = i1;
        j = j1;
    }

    public nn(String s, int k, short word0, double d1, double d2, 
            float f1, long l, int i1, int j1)
    {
        this(1, s, k, word0, d1, d2, f1, l, i1, j1);
    }

    private static int a(int k)
    {
        int l = k & 7;
        if (l == 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("No supported transition specified: ").append(k).toString());
        } else
        {
            return l;
        }
    }

    public static nn a(byte abyte0[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        abyte0 = CREATOR.a(parcel);
        parcel.recycle();
        return abyte0;
    }

    private static void a(double d1, double d2)
    {
        if (d1 > 90D || d1 < -90D)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid latitude: ").append(d1).toString());
        }
        if (d2 > 180D || d2 < -180D)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid longitude: ").append(d2).toString());
        } else
        {
            return;
        }
    }

    private static void a(float f1)
    {
        if (f1 <= 0.0F)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid radius: ").append(f1).toString());
        } else
        {
            return;
        }
    }

    private static void a(String s)
    {
        if (s == null || s.length() > 100)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("requestId is null or too long: ").append(s).toString());
        } else
        {
            return;
        }
    }

    private static String b(int k)
    {
        switch (k)
        {
        default:
            return null;

        case 1: // '\001'
            return "CIRCLE";
        }
    }

    public int a()
    {
        return a;
    }

    public short b()
    {
        return d;
    }

    public double c()
    {
        return e;
    }

    public double d()
    {
        return f;
    }

    public int describeContents()
    {
        afi afi1 = CREATOR;
        return 0;
    }

    public float e()
    {
        return g;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (!(obj instanceof nn))
            {
                return false;
            }
            obj = (nn)obj;
            if (g != ((nn) (obj)).g)
            {
                return false;
            }
            if (e != ((nn) (obj)).e)
            {
                return false;
            }
            if (f != ((nn) (obj)).f)
            {
                return false;
            }
            if (d != ((nn) (obj)).d)
            {
                return false;
            }
        }
        return true;
    }

    public String f()
    {
        return b;
    }

    public long g()
    {
        return c;
    }

    public int h()
    {
        return h;
    }

    public int hashCode()
    {
        long l = Double.doubleToLongBits(e);
        int k = (int)(l ^ l >>> 32);
        l = Double.doubleToLongBits(f);
        return ((((k + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(g)) * 31 + d) * 31 + h;
    }

    public int i()
    {
        return i;
    }

    public int j()
    {
        return j;
    }

    public String toString()
    {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] {
            b(d), b, Integer.valueOf(h), Double.valueOf(e), Double.valueOf(f), Float.valueOf(g), Integer.valueOf(i / 1000), Integer.valueOf(j), Long.valueOf(c)
        });
    }

    public void writeToParcel(Parcel parcel, int k)
    {
        afi afi1 = CREATOR;
        afi.a(this, parcel, k);
    }

}
