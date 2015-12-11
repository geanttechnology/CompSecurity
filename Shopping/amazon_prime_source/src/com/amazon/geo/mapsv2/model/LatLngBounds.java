// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            LatLngBoundsCreator, LatLng

public final class LatLngBounds
    implements SafeParcelable
{
    public static final class Builder
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

        public Builder include(LatLng latlng)
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

        public Builder()
        {
            mHasPoints = false;
        }

        private Builder(LatLngBounds latlngbounds)
        {
            mNorth = latlngbounds.northeast.latitude;
            mEast = latlngbounds.northeast.longitude;
            mSouth = latlngbounds.southwest.latitude;
            mWest = latlngbounds.southwest.longitude;
            mHasPoints = true;
        }

    }


    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    public final LatLng northeast;
    public final LatLng southwest;

    public LatLngBounds(LatLng latlng, LatLng latlng1)
    {
        if (latlng == null)
        {
            throw new NullPointerException("null southwest");
        }
        if (latlng1 == null)
        {
            throw new NullPointerException("null northeast");
        }
        if (latlng.latitude > latlng1.latitude)
        {
            StringBuffer stringbuffer = new StringBuffer("southern latitude exceeds northern latitude (");
            stringbuffer.append(latlng.latitude);
            stringbuffer.append(" > ");
            stringbuffer.append(latlng1.latitude);
            stringbuffer.append(")");
            throw new IllegalArgumentException(stringbuffer.toString());
        } else
        {
            southwest = latlng;
            northeast = latlng1;
            return;
        }
    }

    public static Builder builder()
    {
        return new Builder();
    }

    private static boolean includes(LatLngBounds latlngbounds, LatLng latlng)
    {
        if (latlngbounds.northeast.latitude >= latlng.latitude && latlngbounds.southwest.latitude <= latlng.latitude) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        double d;
        double d1;
        d = latlngbounds.southwest.longitude;
        d1 = latlngbounds.northeast.longitude;
        if (d > d1) goto _L4; else goto _L3
_L3:
        if (latlng.longitude < d || d1 < latlng.longitude) goto _L1; else goto _L5
_L5:
        return true;
_L4:
        if (latlng.longitude < d && d1 < latlng.longitude)
        {
            return false;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public boolean contains(LatLng latlng)
    {
        return includes(this, latlng);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof LatLngBounds))
        {
            return false;
        }
        obj = (LatLngBounds)obj;
        if (northeast == null)
        {
            if (((LatLngBounds) (obj)).northeast != null)
            {
                return false;
            }
        } else
        if (!northeast.equals(((LatLngBounds) (obj)).northeast))
        {
            return false;
        }
        if (southwest != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((LatLngBounds) (obj)).southwest == null) goto _L1; else goto _L3
_L3:
        return false;
        if (southwest.equals(((LatLngBounds) (obj)).southwest)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public LatLng getCenter()
    {
        double d1 = (northeast.latitude + southwest.latitude) / 2D;
        double d = southwest.longitude;
        double d2 = northeast.longitude;
        if (d <= d2)
        {
            d = (d + d2) / 2D;
        } else
        {
            d = d2 - ((d2 - d) + 360D) / 2D;
        }
        return new LatLng(d1, d);
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (northeast == null)
        {
            i = 0;
        } else
        {
            i = northeast.hashCode();
        }
        if (southwest != null)
        {
            j = southwest.hashCode();
        }
        return (i + 31) * 31 + j;
    }

    public LatLngBounds including(LatLng latlng)
    {
        return (new Builder(this)).include(latlng).build();
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer("LatLngBounds{southwest=");
        stringbuffer.append(southwest);
        stringbuffer.append(", northeast=");
        stringbuffer.append(northeast);
        stringbuffer.append("}");
        return stringbuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        LatLngBoundsCreator.write(this, parcel, i);
    }

}
