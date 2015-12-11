// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzi, LatLng

public final class PolylineOptions
    implements SafeParcelable
{

    public static final zzi CREATOR = new zzi();
    private int mColor;
    private final int mVersionCode;
    private float zzaJS;
    private boolean zzaJT;
    private float zzaJX;
    private final List zzaKu;
    private boolean zzaKw;

    public PolylineOptions()
    {
        zzaJX = 10F;
        mColor = 0xff000000;
        zzaJS = 0.0F;
        zzaJT = true;
        zzaKw = false;
        mVersionCode = 1;
        zzaKu = new ArrayList();
    }

    PolylineOptions(int i, List list, float f, int j, float f1, boolean flag, boolean flag1)
    {
        zzaJX = 10F;
        mColor = 0xff000000;
        zzaJS = 0.0F;
        zzaJT = true;
        zzaKw = false;
        mVersionCode = i;
        zzaKu = list;
        zzaJX = f;
        mColor = j;
        zzaJS = f1;
        zzaJT = flag;
        zzaKw = flag1;
    }

    public final PolylineOptions add(LatLng latlng)
    {
        zzaKu.add(latlng);
        return this;
    }

    public final transient PolylineOptions add(LatLng alatlng[])
    {
        zzaKu.addAll(Arrays.asList(alatlng));
        return this;
    }

    public final PolylineOptions addAll(Iterable iterable)
    {
        LatLng latlng;
        for (iterable = iterable.iterator(); iterable.hasNext(); zzaKu.add(latlng))
        {
            latlng = (LatLng)iterable.next();
        }

        return this;
    }

    public final PolylineOptions color(int i)
    {
        mColor = i;
        return this;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final PolylineOptions geodesic(boolean flag)
    {
        zzaKw = flag;
        return this;
    }

    public final int getColor()
    {
        return mColor;
    }

    public final List getPoints()
    {
        return zzaKu;
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

    public final boolean isGeodesic()
    {
        return zzaKw;
    }

    public final boolean isVisible()
    {
        return zzaJT;
    }

    public final PolylineOptions visible(boolean flag)
    {
        zzaJT = flag;
        return this;
    }

    public final PolylineOptions width(float f)
    {
        zzaJX = f;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzi.zza(this, parcel, i);
    }

    public final PolylineOptions zIndex(float f)
    {
        zzaJS = f;
        return this;
    }

}
