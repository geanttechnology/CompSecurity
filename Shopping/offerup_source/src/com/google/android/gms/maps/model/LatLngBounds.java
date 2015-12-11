// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzd, LatLng

public final class LatLngBounds
    implements SafeParcelable
{

    public static final zzd CREATOR = new zzd();
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    LatLngBounds(int i, LatLng latlng, LatLng latlng1)
    {
        zzx.zzb(latlng, "null southwest");
        zzx.zzb(latlng1, "null northeast");
        boolean flag;
        if (latlng1.latitude >= latlng.latitude)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "southern latitude exceeds northern latitude (%s > %s)", new Object[] {
            Double.valueOf(latlng.latitude), Double.valueOf(latlng1.latitude)
        });
        mVersionCode = i;
        southwest = latlng;
        northeast = latlng1;
    }

    public LatLngBounds(LatLng latlng, LatLng latlng1)
    {
        this(1, latlng, latlng1);
    }

    public static Builder builder()
    {
        return new Builder();
    }

    private static double zzb(double d, double d1)
    {
        return ((d - d1) + 360D) % 360D;
    }

    private static double zzc(double d, double d1)
    {
        return ((d1 - d) + 360D) % 360D;
    }

    static double zzd(double d, double d1)
    {
        return zzb(d, d1);
    }

    static double zze(double d, double d1)
    {
        return zzc(d, d1);
    }

    private boolean zzh(double d)
    {
        return southwest.latitude <= d && d <= northeast.latitude;
    }

    private boolean zzi(double d)
    {
        if (southwest.longitude > northeast.longitude) goto _L2; else goto _L1
_L1:
        if (southwest.longitude > d || d > northeast.longitude) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (southwest.longitude > d && d > northeast.longitude)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public final boolean contains(LatLng latlng)
    {
        return zzh(latlng.latitude) && zzi(latlng.longitude);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof LatLngBounds))
            {
                return false;
            }
            obj = (LatLngBounds)obj;
            if (!southwest.equals(((LatLngBounds) (obj)).southwest) || !northeast.equals(((LatLngBounds) (obj)).northeast))
            {
                return false;
            }
        }
        return true;
    }

    public final LatLng getCenter()
    {
        double d1 = (southwest.latitude + northeast.latitude) / 2D;
        double d = northeast.longitude;
        double d2 = southwest.longitude;
        if (d2 <= d)
        {
            d = (d + d2) / 2D;
        } else
        {
            d = (d + 360D + d2) / 2D;
        }
        return new LatLng(d1, d);
    }

    final int getVersionCode()
    {
        return mVersionCode;
    }

    public final int hashCode()
    {
        return zzw.hashCode(new Object[] {
            southwest, northeast
        });
    }

    public final LatLngBounds including(LatLng latlng)
    {
        double d3 = Math.min(southwest.latitude, latlng.latitude);
        double d4 = Math.max(northeast.latitude, latlng.latitude);
        double d1 = northeast.longitude;
        double d2 = southwest.longitude;
        double d = latlng.longitude;
        if (!zzi(d))
        {
            if (zzb(d2, d) >= zzc(d1, d))
            {
                d1 = d;
                d = d2;
            }
        } else
        {
            d = d2;
        }
        return new LatLngBounds(new LatLng(d3, d), new LatLng(d4, d1));
    }

    public final String toString()
    {
        return zzw.zzv(this).zzg("southwest", southwest).zzg("northeast", northeast).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.maps.model.zzd.zza(this, parcel, i);
    }


    private class Builder
    {

        private double zzaKf;
        private double zzaKg;
        private double zzaKh;
        private double zzaKi;

        private boolean zzi(double d)
        {
            if (zzaKh > zzaKi) goto _L2; else goto _L1
_L1:
            if (zzaKh > d || d > zzaKi) goto _L4; else goto _L3
_L3:
            return true;
_L4:
            return false;
_L2:
            if (zzaKh > d && d > zzaKi)
            {
                return false;
            }
            if (true) goto _L3; else goto _L5
_L5:
        }

        public final LatLngBounds build()
        {
            boolean flag;
            if (!Double.isNaN(zzaKh))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "no included points");
            return new LatLngBounds(new LatLng(zzaKf, zzaKh), new LatLng(zzaKg, zzaKi));
        }

        public final Builder include(LatLng latlng)
        {
            double d;
            zzaKf = Math.min(zzaKf, latlng.latitude);
            zzaKg = Math.max(zzaKg, latlng.latitude);
            d = latlng.longitude;
            if (!Double.isNaN(zzaKh)) goto _L2; else goto _L1
_L1:
            zzaKh = d;
_L6:
            zzaKi = d;
_L4:
            return this;
_L2:
            if (zzi(d)) goto _L4; else goto _L3
_L3:
            if (LatLngBounds.zzd(zzaKh, d) < LatLngBounds.zze(zzaKi, d))
            {
                zzaKh = d;
                return this;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        public Builder()
        {
            zzaKf = (1.0D / 0.0D);
            zzaKg = (-1.0D / 0.0D);
            zzaKh = (0.0D / 0.0D);
            zzaKi = (0.0D / 0.0D);
        }
    }

}
