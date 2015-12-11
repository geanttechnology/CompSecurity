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
//            zzh, LatLng

public final class PolygonOptions
    implements SafeParcelable
{

    public static final zzh CREATOR = new zzh();
    private final int mVersionCode;
    private float zzaJP;
    private int zzaJQ;
    private int zzaJR;
    private float zzaJS;
    private boolean zzaJT;
    private final List zzaKu;
    private final List zzaKv;
    private boolean zzaKw;

    public PolygonOptions()
    {
        zzaJP = 10F;
        zzaJQ = 0xff000000;
        zzaJR = 0;
        zzaJS = 0.0F;
        zzaJT = true;
        zzaKw = false;
        mVersionCode = 1;
        zzaKu = new ArrayList();
        zzaKv = new ArrayList();
    }

    PolygonOptions(int i, List list, List list1, float f, int j, int k, float f1, 
            boolean flag, boolean flag1)
    {
        zzaJP = 10F;
        zzaJQ = 0xff000000;
        zzaJR = 0;
        zzaJS = 0.0F;
        zzaJT = true;
        zzaKw = false;
        mVersionCode = i;
        zzaKu = list;
        zzaKv = list1;
        zzaJP = f;
        zzaJQ = j;
        zzaJR = k;
        zzaJS = f1;
        zzaJT = flag;
        zzaKw = flag1;
    }

    public final PolygonOptions add(LatLng latlng)
    {
        zzaKu.add(latlng);
        return this;
    }

    public final transient PolygonOptions add(LatLng alatlng[])
    {
        zzaKu.addAll(Arrays.asList(alatlng));
        return this;
    }

    public final PolygonOptions addAll(Iterable iterable)
    {
        LatLng latlng;
        for (iterable = iterable.iterator(); iterable.hasNext(); zzaKu.add(latlng))
        {
            latlng = (LatLng)iterable.next();
        }

        return this;
    }

    public final PolygonOptions addHole(Iterable iterable)
    {
        ArrayList arraylist = new ArrayList();
        for (iterable = iterable.iterator(); iterable.hasNext(); arraylist.add((LatLng)iterable.next())) { }
        zzaKv.add(arraylist);
        return this;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final PolygonOptions fillColor(int i)
    {
        zzaJR = i;
        return this;
    }

    public final PolygonOptions geodesic(boolean flag)
    {
        zzaKw = flag;
        return this;
    }

    public final int getFillColor()
    {
        return zzaJR;
    }

    public final List getHoles()
    {
        return zzaKv;
    }

    public final List getPoints()
    {
        return zzaKu;
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

    public final boolean isGeodesic()
    {
        return zzaKw;
    }

    public final boolean isVisible()
    {
        return zzaJT;
    }

    public final PolygonOptions strokeColor(int i)
    {
        zzaJQ = i;
        return this;
    }

    public final PolygonOptions strokeWidth(float f)
    {
        zzaJP = f;
        return this;
    }

    public final PolygonOptions visible(boolean flag)
    {
        zzaJT = flag;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

    public final PolygonOptions zIndex(float f)
    {
        zzaJS = f;
        return this;
    }

    final List zzya()
    {
        return zzaKv;
    }

}
