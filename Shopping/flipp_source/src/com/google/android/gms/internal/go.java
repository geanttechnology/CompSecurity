// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.internal:
//            iw

public class go
    implements SafeParcelable
{

    public static final iw CREATOR = new iw();
    final int a;
    final String b;
    final long c;
    final short d;
    final double e;
    final double f;
    final float g;
    final int h;
    final int i;
    final int j;

    public go(int k, String s, int l, short word0, double d1, double d2, float f1, long l1, int i1, int j1)
    {
        if (s == null || s.length() > 100)
        {
            throw new IllegalArgumentException((new StringBuilder("requestId is null or too long: ")).append(s).toString());
        }
        if (f1 <= 0.0F)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid radius: ")).append(f1).toString());
        }
        if (d1 > 90D || d1 < -90D)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid latitude: ")).append(d1).toString());
        }
        if (d2 > 180D || d2 < -180D)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid longitude: ")).append(d2).toString());
        }
        int k1 = l & 7;
        if (k1 == 0)
        {
            throw new IllegalArgumentException((new StringBuilder("No supported transition specified: ")).append(l).toString());
        } else
        {
            a = k;
            d = word0;
            b = s;
            e = d1;
            f = d2;
            g = f1;
            c = l1;
            h = k1;
            i = i1;
            j = j1;
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (!(obj instanceof go))
            {
                return false;
            }
            obj = (go)obj;
            if (g != ((go) (obj)).g)
            {
                return false;
            }
            if (e != ((go) (obj)).e)
            {
                return false;
            }
            if (f != ((go) (obj)).f)
            {
                return false;
            }
            if (d != ((go) (obj)).d)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        long l = Double.doubleToLongBits(e);
        int k = (int)(l ^ l >>> 32);
        l = Double.doubleToLongBits(f);
        return ((((k + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(g)) * 31 + d) * 31 + h;
    }

    public String toString()
    {
        Locale locale = Locale.US;
        d;
        JVM INSTR tableswitch 1 1: default 28
    //                   1 130;
           goto _L1 _L2
_L1:
        Object obj = null;
_L4:
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] {
            obj, b, Integer.valueOf(h), Double.valueOf(e), Double.valueOf(f), Float.valueOf(g), Integer.valueOf(i / 1000), Integer.valueOf(j), Long.valueOf(c)
        });
_L2:
        obj = "CIRCLE";
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void writeToParcel(Parcel parcel, int k)
    {
        iw.a(this, parcel);
    }

}
