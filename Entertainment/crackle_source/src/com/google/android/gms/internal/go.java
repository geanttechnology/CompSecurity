// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.internal:
//            gp

public class go
    implements SafeParcelable, Geofence
{

    public static final gp CREATOR = new gp();
    private final int kg;
    private final int xA;
    private final String xs;
    private final int xt;
    private final short xv;
    private final double xw;
    private final double xx;
    private final float xy;
    private final int xz;
    private final long ye;

    public go(int i, String s, int j, short word0, double d, double d1, float f1, long l, int k, int i1)
    {
        ap(s);
        b(f1);
        a(d, d1);
        j = aV(j);
        kg = i;
        xv = word0;
        xs = s;
        xw = d;
        xx = d1;
        xy = f1;
        ye = l;
        xt = j;
        xz = k;
        xA = i1;
    }

    public go(String s, int i, short word0, double d, double d1, 
            float f1, long l, int j, int k)
    {
        this(1, s, i, word0, d, d1, f1, l, j, k);
    }

    private static void a(double d, double d1)
    {
        if (d > 90D || d < -90D)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid latitude: ").append(d).toString());
        }
        if (d1 > 180D || d1 < -180D)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid longitude: ").append(d1).toString());
        } else
        {
            return;
        }
    }

    private static int aV(int i)
    {
        int j = i & 7;
        if (j == 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("No supported transition specified: ").append(i).toString());
        } else
        {
            return j;
        }
    }

    private static String aW(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return "CIRCLE";
        }
    }

    private static void ap(String s)
    {
        if (s == null || s.length() > 100)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("requestId is null or too long: ").append(s).toString());
        } else
        {
            return;
        }
    }

    private static void b(float f1)
    {
        if (f1 <= 0.0F)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid radius: ").append(f1).toString());
        } else
        {
            return;
        }
    }

    public static go f(byte abyte0[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        abyte0 = CREATOR.ai(parcel);
        parcel.recycle();
        return abyte0;
    }

    public short dK()
    {
        return xv;
    }

    public float dL()
    {
        return xy;
    }

    public int dM()
    {
        return xt;
    }

    public int dN()
    {
        return xA;
    }

    public int describeContents()
    {
        gp gp1 = CREATOR;
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
            if (xy != ((go) (obj)).xy)
            {
                return false;
            }
            if (xw != ((go) (obj)).xw)
            {
                return false;
            }
            if (xx != ((go) (obj)).xx)
            {
                return false;
            }
            if (xv != ((go) (obj)).xv)
            {
                return false;
            }
        }
        return true;
    }

    public long getExpirationTime()
    {
        return ye;
    }

    public double getLatitude()
    {
        return xw;
    }

    public double getLongitude()
    {
        return xx;
    }

    public int getNotificationResponsiveness()
    {
        return xz;
    }

    public String getRequestId()
    {
        return xs;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public int hashCode()
    {
        long l = Double.doubleToLongBits(xw);
        int i = (int)(l ^ l >>> 32);
        l = Double.doubleToLongBits(xx);
        return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(xy)) * 31 + xv) * 31 + xt;
    }

    public String toString()
    {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] {
            aW(xv), xs, Integer.valueOf(xt), Double.valueOf(xw), Double.valueOf(xx), Float.valueOf(xy), Integer.valueOf(xz / 1000), Integer.valueOf(xA), Long.valueOf(ye)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        gp gp1 = CREATOR;
        gp.a(this, parcel, i);
    }

}
