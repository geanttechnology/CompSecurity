// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps.model:
//            PolygonOptionsCreator, g

public final class PolygonOptions
    implements SafeParcelable
{

    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
    private final List aaX;
    private final List aaY;
    private boolean aaZ;
    private float aau;
    private int aav;
    private int aaw;
    private float aax;
    private boolean aay;
    private final int xM;

    public PolygonOptions()
    {
        aau = 10F;
        aav = 0xff000000;
        aaw = 0;
        aax = 0.0F;
        aay = true;
        aaZ = false;
        xM = 1;
        aaX = new ArrayList();
        aaY = new ArrayList();
    }

    PolygonOptions(int i, List list, List list1, float f, int j, int k, float f1, 
            boolean flag, boolean flag1)
    {
        aau = 10F;
        aav = 0xff000000;
        aaw = 0;
        aax = 0.0F;
        aay = true;
        aaZ = false;
        xM = i;
        aaX = list;
        aaY = list1;
        aau = f;
        aav = j;
        aaw = k;
        aax = f1;
        aay = flag;
        aaZ = flag1;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getFillColor()
    {
        return aaw;
    }

    public List getPoints()
    {
        return aaX;
    }

    public int getStrokeColor()
    {
        return aav;
    }

    public float getStrokeWidth()
    {
        return aau;
    }

    int getVersionCode()
    {
        return xM;
    }

    public float getZIndex()
    {
        return aax;
    }

    public boolean isGeodesic()
    {
        return aaZ;
    }

    public boolean isVisible()
    {
        return aay;
    }

    List jP()
    {
        return aaY;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (v.jL())
        {
            g.a(this, parcel, i);
            return;
        } else
        {
            PolygonOptionsCreator.a(this, parcel, i);
            return;
        }
    }

}
