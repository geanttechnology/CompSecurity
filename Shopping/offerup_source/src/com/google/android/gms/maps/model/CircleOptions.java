// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzb, LatLng

public final class CircleOptions
    implements SafeParcelable
{

    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private LatLng zzaJN;
    private double zzaJO;
    private float zzaJP;
    private int zzaJQ;
    private int zzaJR;
    private float zzaJS;
    private boolean zzaJT;

    public CircleOptions()
    {
        zzaJN = null;
        zzaJO = 0.0D;
        zzaJP = 10F;
        zzaJQ = 0xff000000;
        zzaJR = 0;
        zzaJS = 0.0F;
        zzaJT = true;
        mVersionCode = 1;
    }

    CircleOptions(int i, LatLng latlng, double d, float f, int j, int k, 
            float f1, boolean flag)
    {
        zzaJN = null;
        zzaJO = 0.0D;
        zzaJP = 10F;
        zzaJQ = 0xff000000;
        zzaJR = 0;
        zzaJS = 0.0F;
        zzaJT = true;
        mVersionCode = i;
        zzaJN = latlng;
        zzaJO = d;
        zzaJP = f;
        zzaJQ = j;
        zzaJR = k;
        zzaJS = f1;
        zzaJT = flag;
    }

    public final CircleOptions center(LatLng latlng)
    {
        zzaJN = latlng;
        return this;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final CircleOptions fillColor(int i)
    {
        zzaJR = i;
        return this;
    }

    public final LatLng getCenter()
    {
        return zzaJN;
    }

    public final int getFillColor()
    {
        return zzaJR;
    }

    public final double getRadius()
    {
        return zzaJO;
    }

    public final int getStrokeColor()
    {
        return zzaJQ;
    }

    public final float getStrokeWidth()
    {
        return zzaJP;
    }

    final int getVersionCode()
    {
        return mVersionCode;
    }

    public final float getZIndex()
    {
        return zzaJS;
    }

    public final boolean isVisible()
    {
        return zzaJT;
    }

    public final CircleOptions radius(double d)
    {
        zzaJO = d;
        return this;
    }

    public final CircleOptions strokeColor(int i)
    {
        zzaJQ = i;
        return this;
    }

    public final CircleOptions strokeWidth(float f)
    {
        zzaJP = f;
        return this;
    }

    public final CircleOptions visible(boolean flag)
    {
        zzaJT = flag;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

    public final CircleOptions zIndex(float f)
    {
        zzaJS = f;
        return this;
    }

}
