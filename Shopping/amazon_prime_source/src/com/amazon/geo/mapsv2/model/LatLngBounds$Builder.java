// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;


// Referenced classes of package com.amazon.geo.mapsv2.model:
//            LatLngBounds, LatLng

public static final class <init>
{

    private double mEast;
    private boolean mHasPoints;
    private double mNorth;
    private double mSouth;
    private double mWest;

    public LatLngBounds build()
    {
        if (!mHasPoints)
        {
            throw new IllegalStateException("no included points");
        } else
        {
            return new LatLngBounds(new LatLng(mSouth, mWest), new LatLng(mNorth, mEast));
        }
    }

    public mEast include(LatLng latlng)
    {
        if (mHasPoints) goto _L2; else goto _L1
_L1:
        double d = latlng.latitude;
        mSouth = d;
        mNorth = d;
        d = latlng.longitude;
        mWest = d;
        mEast = d;
        mHasPoints = true;
_L4:
        return this;
_L2:
        if (mNorth < latlng.latitude)
        {
            mNorth = latlng.latitude;
        } else
        if (latlng.latitude < mSouth)
        {
            mSouth = latlng.latitude;
        }
        if (mWest <= mEast)
        {
            if (latlng.longitude < mWest)
            {
                if (mWest - latlng.longitude < (latlng.longitude + 360D) - mEast)
                {
                    mWest = latlng.longitude;
                    return this;
                } else
                {
                    mEast = latlng.longitude;
                    return this;
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        continue; /* Loop/switch isn't completed */
        if (mEast >= latlng.longitude) goto _L4; else goto _L3
_L3:
        double d1 = latlng.longitude;
        double d2 = mEast;
        if (mWest - (latlng.longitude - 360D) < d1 - d2)
        {
            mWest = latlng.longitude;
            return this;
        } else
        {
            mEast = latlng.longitude;
            return this;
        }
        if (latlng.longitude >= mWest || latlng.longitude <= mEast) goto _L4; else goto _L5
_L5:
        if (mWest - latlng.longitude < latlng.longitude - mEast)
        {
            mWest = latlng.longitude;
            return this;
        } else
        {
            mEast = latlng.longitude;
            return this;
        }
    }

    public ()
    {
        mHasPoints = false;
    }

    private mHasPoints(LatLngBounds latlngbounds)
    {
        mNorth = latlngbounds.northeast.latitude;
        mEast = latlngbounds.northeast.longitude;
        mSouth = latlngbounds.southwest.latitude;
        mWest = latlngbounds.southwest.longitude;
        mHasPoints = true;
    }

    mHasPoints(LatLngBounds latlngbounds, mHasPoints mhaspoints)
    {
        this(latlngbounds);
    }
}
