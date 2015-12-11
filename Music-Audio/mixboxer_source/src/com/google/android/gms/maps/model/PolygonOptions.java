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
//            PolygonOptionsCreator, LatLng, g

public final class PolygonOptions
    implements SafeParcelable
{

    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
    private final List CV;
    private final List CW;
    private boolean CX;
    private float Ct;
    private int Cu;
    private int Cv;
    private float Cw;
    private boolean Cx;
    private final int kg;

    public PolygonOptions()
    {
        Ct = 10F;
        Cu = 0xff000000;
        Cv = 0;
        Cw = 0.0F;
        Cx = true;
        CX = false;
        kg = 1;
        CV = new ArrayList();
        CW = new ArrayList();
    }

    PolygonOptions(int i, List list, List list1, float f, int j, int k, float f1, 
            boolean flag, boolean flag1)
    {
        Ct = 10F;
        Cu = 0xff000000;
        Cv = 0;
        Cw = 0.0F;
        Cx = true;
        CX = false;
        kg = i;
        CV = list;
        CW = list1;
        Ct = f;
        Cu = j;
        Cv = k;
        Cw = f1;
        Cx = flag;
        CX = flag1;
    }

    public PolygonOptions add(LatLng latlng)
    {
        CV.add(latlng);
        return this;
    }

    public transient PolygonOptions add(LatLng alatlng[])
    {
        CV.addAll(Arrays.asList(alatlng));
        return this;
    }

    public PolygonOptions addAll(Iterable iterable)
    {
        LatLng latlng;
        for (iterable = iterable.iterator(); iterable.hasNext(); CV.add(latlng))
        {
            latlng = (LatLng)iterable.next();
        }

        return this;
    }

    public PolygonOptions addHole(Iterable iterable)
    {
        ArrayList arraylist = new ArrayList();
        for (iterable = iterable.iterator(); iterable.hasNext(); arraylist.add((LatLng)iterable.next())) { }
        CW.add(arraylist);
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    List eH()
    {
        return CW;
    }

    public PolygonOptions fillColor(int i)
    {
        Cv = i;
        return this;
    }

    public PolygonOptions geodesic(boolean flag)
    {
        CX = flag;
        return this;
    }

    public int getFillColor()
    {
        return Cv;
    }

    public List getHoles()
    {
        return CW;
    }

    public List getPoints()
    {
        return CV;
    }

    public int getStrokeColor()
    {
        return Cu;
    }

    public float getStrokeWidth()
    {
        return Ct;
    }

    int getVersionCode()
    {
        return kg;
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

    public PolygonOptions strokeColor(int i)
    {
        Cu = i;
        return this;
    }

    public PolygonOptions strokeWidth(float f)
    {
        Ct = f;
        return this;
    }

    public PolygonOptions visible(boolean flag)
    {
        Cx = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (r.eD())
        {
            g.a(this, parcel, i);
            return;
        } else
        {
            PolygonOptionsCreator.a(this, parcel, i);
            return;
        }
    }

    public PolygonOptions zIndex(float f)
    {
        Cw = f;
        return this;
    }

}
