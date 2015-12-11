// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzf, BitmapDescriptor, LatLng

public final class MarkerOptions
    implements SafeParcelable
{

    public static final zzf CREATOR = new zzf();
    private float mAlpha;
    private final int mVersionCode;
    private boolean zzaJT;
    private LatLng zzaJq;
    private float zzaKb;
    private float zzaKc;
    private String zzaKk;
    private BitmapDescriptor zzaKl;
    private boolean zzaKm;
    private boolean zzaKn;
    private float zzaKo;
    private float zzaKp;
    private float zzaKq;
    private String zzajf;

    public MarkerOptions()
    {
        zzaKb = 0.5F;
        zzaKc = 1.0F;
        zzaJT = true;
        zzaKn = false;
        zzaKo = 0.0F;
        zzaKp = 0.5F;
        zzaKq = 0.0F;
        mAlpha = 1.0F;
        mVersionCode = 1;
    }

    MarkerOptions(int i, LatLng latlng, String s, String s1, IBinder ibinder, float f, float f1, 
            boolean flag, boolean flag1, boolean flag2, float f2, float f3, float f4, float f5)
    {
        zzaKb = 0.5F;
        zzaKc = 1.0F;
        zzaJT = true;
        zzaKn = false;
        zzaKo = 0.0F;
        zzaKp = 0.5F;
        zzaKq = 0.0F;
        mAlpha = 1.0F;
        mVersionCode = i;
        zzaJq = latlng;
        zzajf = s;
        zzaKk = s1;
        if (ibinder == null)
        {
            latlng = null;
        } else
        {
            latlng = new BitmapDescriptor(com.google.android.gms.dynamic.zzd.zza.zzbk(ibinder));
        }
        zzaKl = latlng;
        zzaKb = f;
        zzaKc = f1;
        zzaKm = flag;
        zzaJT = flag1;
        zzaKn = flag2;
        zzaKo = f2;
        zzaKp = f3;
        zzaKq = f4;
        mAlpha = f5;
    }

    public final MarkerOptions alpha(float f)
    {
        mAlpha = f;
        return this;
    }

    public final MarkerOptions anchor(float f, float f1)
    {
        zzaKb = f;
        zzaKc = f1;
        return this;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final MarkerOptions draggable(boolean flag)
    {
        zzaKm = flag;
        return this;
    }

    public final MarkerOptions flat(boolean flag)
    {
        zzaKn = flag;
        return this;
    }

    public final float getAlpha()
    {
        return mAlpha;
    }

    public final float getAnchorU()
    {
        return zzaKb;
    }

    public final float getAnchorV()
    {
        return zzaKc;
    }

    public final BitmapDescriptor getIcon()
    {
        return zzaKl;
    }

    public final float getInfoWindowAnchorU()
    {
        return zzaKp;
    }

    public final float getInfoWindowAnchorV()
    {
        return zzaKq;
    }

    public final LatLng getPosition()
    {
        return zzaJq;
    }

    public final float getRotation()
    {
        return zzaKo;
    }

    public final String getSnippet()
    {
        return zzaKk;
    }

    public final String getTitle()
    {
        return zzajf;
    }

    final int getVersionCode()
    {
        return mVersionCode;
    }

    public final MarkerOptions icon(BitmapDescriptor bitmapdescriptor)
    {
        zzaKl = bitmapdescriptor;
        return this;
    }

    public final MarkerOptions infoWindowAnchor(float f, float f1)
    {
        zzaKp = f;
        zzaKq = f1;
        return this;
    }

    public final boolean isDraggable()
    {
        return zzaKm;
    }

    public final boolean isFlat()
    {
        return zzaKn;
    }

    public final boolean isVisible()
    {
        return zzaJT;
    }

    public final MarkerOptions position(LatLng latlng)
    {
        zzaJq = latlng;
        return this;
    }

    public final MarkerOptions rotation(float f)
    {
        zzaKo = f;
        return this;
    }

    public final MarkerOptions snippet(String s)
    {
        zzaKk = s;
        return this;
    }

    public final MarkerOptions title(String s)
    {
        zzajf = s;
        return this;
    }

    public final MarkerOptions visible(boolean flag)
    {
        zzaJT = flag;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }

    final IBinder zzxZ()
    {
        if (zzaKl == null)
        {
            return null;
        } else
        {
            return zzaKl.zzxw().asBinder();
        }
    }

}
