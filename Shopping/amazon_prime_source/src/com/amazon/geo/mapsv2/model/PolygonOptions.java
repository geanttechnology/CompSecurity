// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            PolygonOptionsCreator, LatLng

public final class PolygonOptions
    implements SafeParcelable
{

    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
    private int mFillColor;
    private boolean mGeodesic;
    private final List mHoles;
    private final List mPoints;
    private int mStrokeColor;
    private float mStrokeWidth;
    private boolean mVisible;
    private float mZIndex;

    public PolygonOptions()
    {
        mHoles = new ArrayList();
        mPoints = new ArrayList();
        mFillColor = 0;
        mStrokeColor = 0xff000000;
        mStrokeWidth = 10F;
        mZIndex = 0.0F;
        mGeodesic = false;
        mVisible = true;
    }

    PolygonOptions(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        mHoles = new ArrayList();
        mPoints = new ArrayList();
        mFillColor = 0;
        mStrokeColor = 0xff000000;
        mStrokeWidth = 10F;
        mZIndex = 0.0F;
        mGeodesic = false;
        mVisible = true;
        mFillColor = parcel.readInt();
        parcel.readList(mHoles, com/amazon/geo/mapsv2/model/LatLng.getClassLoader());
        parcel.readList(mPoints, com/amazon/geo/mapsv2/model/LatLng.getClassLoader());
        mStrokeColor = parcel.readInt();
        mStrokeWidth = parcel.readFloat();
        mZIndex = parcel.readFloat();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mGeodesic = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mVisible = flag;
    }

    public PolygonOptions add(LatLng latlng)
    {
        mPoints.add(latlng);
        return this;
    }

    public transient PolygonOptions add(LatLng alatlng[])
    {
        addAll(Arrays.asList(alatlng));
        return this;
    }

    public PolygonOptions addAll(Iterable iterable)
    {
        LatLng latlng;
        for (iterable = iterable.iterator(); iterable.hasNext(); mPoints.add(latlng))
        {
            latlng = (LatLng)iterable.next();
        }

        return this;
    }

    public PolygonOptions addHole(Iterable iterable)
    {
        ArrayList arraylist = new ArrayList();
        for (iterable = iterable.iterator(); iterable.hasNext(); arraylist.add((LatLng)iterable.next())) { }
        mHoles.add(arraylist);
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof PolygonOptions))
            {
                return false;
            }
            obj = (PolygonOptions)obj;
            if (mFillColor != ((PolygonOptions) (obj)).mFillColor || mStrokeColor != ((PolygonOptions) (obj)).mStrokeColor || mStrokeWidth != ((PolygonOptions) (obj)).mStrokeWidth || mZIndex != ((PolygonOptions) (obj)).mZIndex || mGeodesic != ((PolygonOptions) (obj)).mGeodesic || mVisible != ((PolygonOptions) (obj)).mVisible || !mHoles.equals(((PolygonOptions) (obj)).mHoles) || !mPoints.equals(((PolygonOptions) (obj)).mPoints))
            {
                return false;
            }
        }
        return true;
    }

    public PolygonOptions fillColor(int i)
    {
        mFillColor = i;
        return this;
    }

    public PolygonOptions geodesic(boolean flag)
    {
        mGeodesic = flag;
        return this;
    }

    public int getFillColor()
    {
        return mFillColor;
    }

    public List getHoles()
    {
        return new ArrayList(mHoles);
    }

    public List getPoints()
    {
        return mPoints;
    }

    public int getStrokeColor()
    {
        return mStrokeColor;
    }

    public float getStrokeWidth()
    {
        return mStrokeWidth;
    }

    public float getZIndex()
    {
        return mZIndex;
    }

    public int hashCode()
    {
        int j = 1;
        int k = mFillColor;
        int l = mStrokeColor;
        int i1 = Float.floatToIntBits(mStrokeWidth);
        int j1 = Float.floatToIntBits(mZIndex);
        int i;
        if (mGeodesic)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (!mVisible)
        {
            j = 0;
        }
        return (((((((k + 527) * 31 + l) * 31 + i1) * 31 + j1) * 31 + i) * 31 + j) * 31 + mHoles.hashCode()) * 31 + mPoints.hashCode();
    }

    public boolean isGeodesic()
    {
        return mGeodesic;
    }

    public boolean isVisible()
    {
        return mVisible;
    }

    public PolygonOptions strokeColor(int i)
    {
        mStrokeColor = i;
        return this;
    }

    public PolygonOptions strokeWidth(float f)
    {
        mStrokeWidth = f;
        return this;
    }

    public PolygonOptions visible(boolean flag)
    {
        mVisible = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeInt(mFillColor);
        parcel.writeList(mHoles);
        parcel.writeList(mPoints);
        parcel.writeInt(mStrokeColor);
        parcel.writeFloat(mStrokeWidth);
        parcel.writeFloat(mZIndex);
        if (mGeodesic)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mVisible)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

    public PolygonOptions zIndex(float f)
    {
        mZIndex = f;
        return this;
    }

}
