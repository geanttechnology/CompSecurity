// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzo

public class ParcelableGeofence
    implements SafeParcelable, Geofence
{

    public static final zzo CREATOR = new zzo();
    private final int mVersionCode;
    private final String zzBY;
    private final int zzaEi;
    private final short zzaEk;
    private final double zzaEl;
    private final double zzaEm;
    private final float zzaEn;
    private final int zzaEo;
    private final int zzaEp;
    private final long zzaFO;

    public ParcelableGeofence(int i, String s, int j, short word0, double d, double d1, float f, long l, int k, int i1)
    {
        zzdx(s);
        zze(f);
        zza(d, d1);
        j = zzhc(j);
        mVersionCode = i;
        zzaEk = word0;
        zzBY = s;
        zzaEl = d;
        zzaEm = d1;
        zzaEn = f;
        zzaFO = l;
        zzaEi = j;
        zzaEo = k;
        zzaEp = i1;
    }

    public ParcelableGeofence(String s, int i, short word0, double d, double d1, 
            float f, long l, int j, int k)
    {
        this(1, s, i, word0, d, d1, f, l, j, k);
    }

    private static void zza(double d, double d1)
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

    private static void zzdx(String s)
    {
        if (s == null || s.length() > 100)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("requestId is null or too long: ").append(s).toString());
        } else
        {
            return;
        }
    }

    private static void zze(float f)
    {
        if (f <= 0.0F)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid radius: ").append(f).toString());
        } else
        {
            return;
        }
    }

    private static int zzhc(int i)
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

    private static String zzhd(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return "CIRCLE";
        }
    }

    public static ParcelableGeofence zzn(byte abyte0[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        abyte0 = CREATOR.zzeJ(parcel);
        parcel.recycle();
        return abyte0;
    }

    public int describeContents()
    {
        zzo zzo1 = CREATOR;
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
            if (!(obj instanceof ParcelableGeofence))
            {
                return false;
            }
            obj = (ParcelableGeofence)obj;
            if (zzaEn != ((ParcelableGeofence) (obj)).zzaEn)
            {
                return false;
            }
            if (zzaEl != ((ParcelableGeofence) (obj)).zzaEl)
            {
                return false;
            }
            if (zzaEm != ((ParcelableGeofence) (obj)).zzaEm)
            {
                return false;
            }
            if (zzaEk != ((ParcelableGeofence) (obj)).zzaEk)
            {
                return false;
            }
        }
        return true;
    }

    public long getExpirationTime()
    {
        return zzaFO;
    }

    public double getLatitude()
    {
        return zzaEl;
    }

    public double getLongitude()
    {
        return zzaEm;
    }

    public int getNotificationResponsiveness()
    {
        return zzaEo;
    }

    public String getRequestId()
    {
        return zzBY;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        long l = Double.doubleToLongBits(zzaEl);
        int i = (int)(l ^ l >>> 32);
        l = Double.doubleToLongBits(zzaEm);
        return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(zzaEn)) * 31 + zzaEk) * 31 + zzaEi;
    }

    public String toString()
    {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] {
            zzhd(zzaEk), zzBY, Integer.valueOf(zzaEi), Double.valueOf(zzaEl), Double.valueOf(zzaEm), Float.valueOf(zzaEn), Integer.valueOf(zzaEo / 1000), Integer.valueOf(zzaEp), Long.valueOf(zzaFO)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzo zzo1 = CREATOR;
        zzo.zza(this, parcel, i);
    }

    public short zzwI()
    {
        return zzaEk;
    }

    public float zzwJ()
    {
        return zzaEn;
    }

    public int zzwK()
    {
        return zzaEi;
    }

    public int zzwL()
    {
        return zzaEp;
    }

}
