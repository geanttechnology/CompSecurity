// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.r;

// Referenced classes of package com.google.android.gms.maps.model:
//            CircleOptionsCreator, b, LatLng

public final class CircleOptions
    implements SafeParcelable
{

    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
    private LatLng Cr;
    private double Cs;
    private float Ct;
    private int Cu;
    private int Cv;
    private float Cw;
    private boolean Cx;
    private final int kg;

    public CircleOptions()
    {
        Cr = null;
        Cs = 0.0D;
        Ct = 10F;
        Cu = 0xff000000;
        Cv = 0;
        Cw = 0.0F;
        Cx = true;
        kg = 1;
    }

    CircleOptions(int i, LatLng latlng, double d, float f, int j, int k, 
            float f1, boolean flag)
    {
        Cr = null;
        Cs = 0.0D;
        Ct = 10F;
        Cu = 0xff000000;
        Cv = 0;
        Cw = 0.0F;
        Cx = true;
        kg = i;
        Cr = latlng;
        Cs = d;
        Ct = f;
        Cu = j;
        Cv = k;
        Cw = f1;
        Cx = flag;
    }

    public CircleOptions center(LatLng latlng)
    {
        Cr = latlng;
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public CircleOptions fillColor(int i)
    {
        Cv = i;
        return this;
    }

    public LatLng getCenter()
    {
        return Cr;
    }

    public int getFillColor()
    {
        return Cv;
    }

    public double getRadius()
    {
        return Cs;
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

    public boolean isVisible()
    {
        return Cx;
    }

    public CircleOptions radius(double d)
    {
        Cs = d;
        return this;
    }

    public CircleOptions strokeColor(int i)
    {
        Cu = i;
        return this;
    }

    public CircleOptions strokeWidth(float f)
    {
        Ct = f;
        return this;
    }

    public CircleOptions visible(boolean flag)
    {
        Cx = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (r.eD())
        {
            b.a(this, parcel, i);
            return;
        } else
        {
            CircleOptionsCreator.a(this, parcel, i);
            return;
        }
    }

    public CircleOptions zIndex(float f)
    {
        Cw = f;
        return this;
    }

}
