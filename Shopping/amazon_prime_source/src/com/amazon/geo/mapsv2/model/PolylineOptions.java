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
//            PolylineOptionsCreator, LatLng

public final class PolylineOptions
    implements SafeParcelable
{

    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
    private int mColor;
    private boolean mGeodesic;
    private final List mPoints;
    private boolean mVisible;
    private float mWidth;
    private float mZIndex;

    public PolylineOptions()
    {
        mPoints = new ArrayList();
        mColor = 0xff000000;
        mWidth = 10F;
        mZIndex = 0.0F;
        mGeodesic = false;
        mVisible = true;
    }

    PolylineOptions(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        mPoints = new ArrayList();
        mColor = 0xff000000;
        mWidth = 10F;
        mZIndex = 0.0F;
        mGeodesic = false;
        mVisible = true;
        mColor = parcel.readInt();
        parcel.readList(mPoints, com/amazon/geo/mapsv2/model/LatLng.getClassLoader());
        mWidth = parcel.readFloat();
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

    public PolylineOptions add(LatLng latlng)
    {
        mPoints.add(latlng);
        return this;
    }

    public transient PolylineOptions add(LatLng alatlng[])
    {
        addAll(Arrays.asList(alatlng));
        return this;
    }

    public PolylineOptions addAll(Iterable iterable)
    {
        LatLng latlng;
        for (iterable = iterable.iterator(); iterable.hasNext(); mPoints.add(latlng))
        {
            latlng = (LatLng)iterable.next();
        }

        return this;
    }

    public PolylineOptions color(int i)
    {
        mColor = i;
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
            if (!(obj instanceof PolylineOptions))
            {
                return false;
            }
            obj = (PolylineOptions)obj;
            if (mColor != ((PolylineOptions) (obj)).mColor || mWidth != ((PolylineOptions) (obj)).mWidth || mZIndex != ((PolylineOptions) (obj)).mZIndex || mGeodesic != ((PolylineOptions) (obj)).mGeodesic || mVisible != ((PolylineOptions) (obj)).mVisible || !mPoints.equals(((PolylineOptions) (obj)).mPoints))
            {
                return false;
            }
        }
        return true;
    }

    public PolylineOptions geodesic(boolean flag)
    {
        mGeodesic = flag;
        return this;
    }

    public int getColor()
    {
        return mColor;
    }

    public List getPoints()
    {
        return mPoints;
    }

    public float getWidth()
    {
        return mWidth;
    }

    public float getZIndex()
    {
        return mZIndex;
    }

    public int hashCode()
    {
        int j = 1;
        int k = mColor;
        int l = Float.floatToIntBits(mWidth);
        int i1 = Float.floatToIntBits(mZIndex);
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
        return (((((k + 527) * 31 + l) * 31 + i1) * 31 + i) * 31 + j) * 31 + mPoints.hashCode();
    }

    public boolean isGeodesic()
    {
        return mGeodesic;
    }

    public boolean isVisible()
    {
        return mVisible;
    }

    public PolylineOptions visible(boolean flag)
    {
        mVisible = flag;
        return this;
    }

    public PolylineOptions width(float f)
    {
        mWidth = f;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeInt(mColor);
        parcel.writeList(mPoints);
        parcel.writeFloat(mWidth);
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

    public PolylineOptions zIndex(float f)
    {
        mZIndex = f;
        return this;
    }

}
