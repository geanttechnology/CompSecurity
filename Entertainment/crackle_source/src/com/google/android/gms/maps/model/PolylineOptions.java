// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps.model:
//            PolylineOptionsCreator, LatLng, h

public final class PolylineOptions
    implements SafeParcelable
{

    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
    private float CB;
    private final List CV;
    private boolean CX;
    private float Cw;
    private boolean Cx;
    private final int kg;
    private int mP;

    public PolylineOptions()
    {
        CB = 10F;
        mP = 0xff000000;
        Cw = 0.0F;
        Cx = true;
        CX = false;
        kg = 1;
        CV = new ArrayList();
    }

    PolylineOptions(int i, List list, float f, int j, float f1, boolean flag, boolean flag1)
    {
        CB = 10F;
        mP = 0xff000000;
        Cw = 0.0F;
        Cx = true;
        CX = false;
        kg = i;
        CV = list;
        CB = f;
        mP = j;
        Cw = f1;
        Cx = flag;
        CX = flag1;
    }

    public PolylineOptions add(LatLng latlng)
    {
        CV.add(latlng);
        return this;
    }

    public transient PolylineOptions add(LatLng alatlng[])
    {
        CV.addAll(Arrays.asList(alatlng));
        return this;
    }

    public PolylineOptions addAll(Iterable iterable)
    {
        LatLng latlng;
        for (iterable = iterable.iterator(); iterable.hasNext(); CV.add(latlng))
        {
            latlng = (LatLng)iterable.next();
        }

        return this;
    }

    public PolylineOptions color(int i)
    {
        mP = i;
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public PolylineOptions geodesic(boolean flag)
    {
        CX = flag;
        return this;
    }

    public int getColor()
    {
        return mP;
    }

    public List getPoints()
    {
        return CV;
    }

    int getVersionCode()
    {
        return kg;
    }

    public float getWidth()
    {
        return CB;
    }

    public float getZIndex()
    {
        return Cw;
    }

    public boolean isGeodesic()
    {
        return CX;
    }

    public boolean isVisible()
    {
        return Cx;
    }

    public PolylineOptions visible(boolean flag)
    {
        Cx = flag;
        return this;
    }

    public PolylineOptions width(float f)
    {
        CB = f;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (r.eD())
        {
            h.a(this, parcel, i);
            return;
        } else
        {
            PolylineOptionsCreator.a(this, parcel, i);
            return;
        }
    }

    public PolylineOptions zIndex(float f)
    {
        Cw = f;
        return this;
    }

}
