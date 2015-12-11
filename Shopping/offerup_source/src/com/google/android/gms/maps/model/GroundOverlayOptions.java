// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzc, BitmapDescriptor, LatLng, LatLngBounds

public final class GroundOverlayOptions
    implements SafeParcelable
{

    public static final zzc CREATOR = new zzc();
    public static final float NO_DIMENSION = -1F;
    private final int mVersionCode;
    private float zzaJL;
    private float zzaJS;
    private boolean zzaJT;
    private BitmapDescriptor zzaJV;
    private LatLng zzaJW;
    private float zzaJX;
    private float zzaJY;
    private LatLngBounds zzaJZ;
    private float zzaKa;
    private float zzaKb;
    private float zzaKc;

    public GroundOverlayOptions()
    {
        zzaJT = true;
        zzaKa = 0.0F;
        zzaKb = 0.5F;
        zzaKc = 0.5F;
        mVersionCode = 1;
    }

    GroundOverlayOptions(int i, IBinder ibinder, LatLng latlng, float f, float f1, LatLngBounds latlngbounds, float f2, 
            float f3, boolean flag, float f4, float f5, float f6)
    {
        zzaJT = true;
        zzaKa = 0.0F;
        zzaKb = 0.5F;
        zzaKc = 0.5F;
        mVersionCode = i;
        zzaJV = new BitmapDescriptor(com.google.android.gms.dynamic.zzd.zza.zzbk(ibinder));
        zzaJW = latlng;
        zzaJX = f;
        zzaJY = f1;
        zzaJZ = latlngbounds;
        zzaJL = f2;
        zzaJS = f3;
        zzaJT = flag;
        zzaKa = f4;
        zzaKb = f5;
        zzaKc = f6;
    }

    private GroundOverlayOptions zza(LatLng latlng, float f, float f1)
    {
        zzaJW = latlng;
        zzaJX = f;
        zzaJY = f1;
        return this;
    }

    public final GroundOverlayOptions anchor(float f, float f1)
    {
        zzaKb = f;
        zzaKc = f1;
        return this;
    }

    public final GroundOverlayOptions bearing(float f)
    {
        zzaJL = (f % 360F + 360F) % 360F;
        return this;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final float getAnchorU()
    {
        return zzaKb;
    }

    public final float getAnchorV()
    {
        return zzaKc;
    }

    public final float getBearing()
    {
        return zzaJL;
    }

    public final LatLngBounds getBounds()
    {
        return zzaJZ;
    }

    public final float getHeight()
    {
        return zzaJY;
    }

    public final BitmapDescriptor getImage()
    {
        return zzaJV;
    }

    public final LatLng getLocation()
    {
        return zzaJW;
    }

    public final float getTransparency()
    {
        return zzaKa;
    }

    final int getVersionCode()
    {
        return mVersionCode;
    }

    public final float getWidth()
    {
        return zzaJX;
    }

    public final float getZIndex()
    {
        return zzaJS;
    }

    public final GroundOverlayOptions image(BitmapDescriptor bitmapdescriptor)
    {
        zzaJV = bitmapdescriptor;
        return this;
    }

    public final boolean isVisible()
    {
        return zzaJT;
    }

    public final GroundOverlayOptions position(LatLng latlng, float f)
    {
        boolean flag1 = true;
        boolean flag;
        if (zzaJZ == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Position has already been set using positionFromBounds");
        if (latlng != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Location must be specified");
        if (f >= 0.0F)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Width must be non-negative");
        return zza(latlng, f, -1F);
    }

    public final GroundOverlayOptions position(LatLng latlng, float f, float f1)
    {
        boolean flag1 = true;
        boolean flag;
        if (zzaJZ == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Position has already been set using positionFromBounds");
        if (latlng != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Location must be specified");
        if (f >= 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Width must be non-negative");
        if (f1 >= 0.0F)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Height must be non-negative");
        return zza(latlng, f, f1);
    }

    public final GroundOverlayOptions positionFromBounds(LatLngBounds latlngbounds)
    {
        boolean flag;
        if (zzaJW == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, (new StringBuilder("Position has already been set using position: ")).append(zzaJW).toString());
        zzaJZ = latlngbounds;
        return this;
    }

    public final GroundOverlayOptions transparency(float f)
    {
        boolean flag;
        if (f >= 0.0F && f <= 1.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Transparency must be in the range [0..1]");
        zzaKa = f;
        return this;
    }

    public final GroundOverlayOptions visible(boolean flag)
    {
        zzaJT = flag;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

    public final GroundOverlayOptions zIndex(float f)
    {
        zzaJS = f;
        return this;
    }

    final IBinder zzxY()
    {
        return zzaJV.zzxw().asBinder();
    }

}
