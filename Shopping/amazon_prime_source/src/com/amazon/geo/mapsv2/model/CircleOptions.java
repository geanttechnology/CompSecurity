// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            CircleOptionsCreator, LatLng

public final class CircleOptions
    implements SafeParcelable
{

    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
    private LatLng mCenter;
    private int mFillColor;
    private double mRadius;
    private int mStrokeColor;
    private float mStrokeWidth;
    private boolean mVisible;
    private float mZIndex;

    public CircleOptions()
    {
        mCenter = null;
        mFillColor = 0;
        mRadius = 0.0D;
        mStrokeColor = 0xff000000;
        mStrokeWidth = 10F;
        mZIndex = 0.0F;
        mVisible = true;
    }

    CircleOptions(Parcel parcel)
    {
        mCenter = null;
        mFillColor = 0;
        mRadius = 0.0D;
        mStrokeColor = 0xff000000;
        mStrokeWidth = 10F;
        mZIndex = 0.0F;
        mVisible = true;
        mCenter = (LatLng)parcel.readParcelable(com/amazon/geo/mapsv2/model/LatLng.getClassLoader());
        mFillColor = parcel.readInt();
        mRadius = parcel.readDouble();
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
        mVisible = flag;
    }

    public CircleOptions center(LatLng latlng)
    {
        mCenter = latlng;
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag2;
        boolean flag3;
        flag2 = true;
        flag3 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag3;
        if (!(obj instanceof CircleOptions)) goto _L4; else goto _L3
_L3:
        obj = (CircleOptions)obj;
        if (mCenter != null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        flag = flag3;
        if (((CircleOptions) (obj)).mCenter != null) goto _L4; else goto _L5
_L5:
        boolean flag1;
        if (mFillColor == ((CircleOptions) (obj)).mFillColor && mRadius == ((CircleOptions) (obj)).mRadius && mStrokeColor == ((CircleOptions) (obj)).mStrokeColor && mStrokeWidth == ((CircleOptions) (obj)).mStrokeWidth && mZIndex == ((CircleOptions) (obj)).mZIndex && mVisible == ((CircleOptions) (obj)).mVisible)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        return flag1;
        if (!mCenter.equals(((CircleOptions) (obj)).mCenter))
        {
            return false;
        }
          goto _L5
    }

    public CircleOptions fillColor(int i)
    {
        mFillColor = i;
        return this;
    }

    public LatLng getCenter()
    {
        return mCenter;
    }

    public int getFillColor()
    {
        return mFillColor;
    }

    public double getRadius()
    {
        return mRadius;
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
        int j = 0;
        int k = mFillColor;
        long l1 = Double.doubleToLongBits(mRadius);
        int l = (int)(l1 >>> 32 ^ l1);
        int i1 = mStrokeColor;
        int j1 = Float.floatToIntBits(mStrokeWidth);
        int k1 = Float.floatToIntBits(mZIndex);
        int i;
        if (mVisible)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (mCenter != null)
        {
            j = mCenter.hashCode();
        }
        return ((((((k + 527) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + i) * 31 + j;
    }

    public boolean isVisible()
    {
        return mVisible;
    }

    public CircleOptions radius(double d)
    {
        mRadius = d;
        return this;
    }

    public CircleOptions strokeColor(int i)
    {
        mStrokeColor = i;
        return this;
    }

    public CircleOptions strokeWidth(float f)
    {
        mStrokeWidth = f;
        return this;
    }

    public CircleOptions visible(boolean flag)
    {
        mVisible = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mCenter, i);
        parcel.writeInt(mFillColor);
        parcel.writeDouble(mRadius);
        parcel.writeInt(mStrokeColor);
        parcel.writeFloat(mStrokeWidth);
        parcel.writeFloat(mZIndex);
        if (mVisible)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

    public CircleOptions zIndex(float f)
    {
        mZIndex = f;
        return this;
    }

}
