// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            GroundOverlayOptionsCreator, LatLngBounds, BitmapDescriptor, LatLng

public final class GroundOverlayOptions
    implements SafeParcelable
{

    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    public static final float NO_DIMENSION = -1F;
    private float mAnchorU;
    private float mAnchorV;
    private float mBearing;
    private LatLngBounds mBounds;
    private float mHeight;
    private BitmapDescriptor mImage;
    private LatLng mLocation;
    private float mTransparency;
    private boolean mVisible;
    private float mWidth;
    private float mZIndex;

    public GroundOverlayOptions()
    {
        mAnchorU = 0.0F;
        mAnchorV = 0.0F;
        mBearing = 0.0F;
        mBounds = null;
        mHeight = -1F;
        mLocation = null;
        mTransparency = 0.0F;
        mWidth = 10F;
        mZIndex = 0.0F;
        mVisible = true;
        mImage = null;
    }

    GroundOverlayOptions(float f, float f1, float f2, LatLngBounds latlngbounds, float f3, LatLng latlng, float f4, 
            float f5, float f6, boolean flag, BitmapDescriptor bitmapdescriptor)
    {
        mAnchorU = 0.0F;
        mAnchorV = 0.0F;
        mBearing = 0.0F;
        mBounds = null;
        mHeight = -1F;
        mLocation = null;
        mTransparency = 0.0F;
        mWidth = 10F;
        mZIndex = 0.0F;
        mVisible = true;
        mImage = null;
        mAnchorU = f;
        mAnchorV = f1;
        mBearing = f2;
        mBounds = latlngbounds;
        mHeight = f3;
        mLocation = latlng;
        mTransparency = f4;
        mWidth = f5;
        mZIndex = f6;
        mVisible = flag;
        mImage = bitmapdescriptor;
    }

    public GroundOverlayOptions anchor(float f, float f1)
    {
        mAnchorU = f;
        mAnchorV = f1;
        return this;
    }

    public GroundOverlayOptions bearing(float f)
    {
        mBearing = f % 360F;
        if (mBearing == 0.0F)
        {
            mBearing = 0.0F;
        } else
        if (mBearing < 0.0F)
        {
            mBearing = mBearing + 360F;
            return this;
        }
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public float getAnchorU()
    {
        return mAnchorU;
    }

    public float getAnchorV()
    {
        return mAnchorV;
    }

    public float getBearing()
    {
        return mBearing;
    }

    public LatLngBounds getBounds()
    {
        return mBounds;
    }

    public float getHeight()
    {
        return mHeight;
    }

    public BitmapDescriptor getImage()
    {
        return mImage;
    }

    public LatLng getLocation()
    {
        return mLocation;
    }

    public float getTransparency()
    {
        return mTransparency;
    }

    public float getWidth()
    {
        return mWidth;
    }

    public float getZIndex()
    {
        return mZIndex;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapdescriptor)
    {
        mImage = bitmapdescriptor;
        return this;
    }

    public boolean isVisible()
    {
        return mVisible;
    }

    public GroundOverlayOptions position(LatLng latlng, float f)
    {
        if (mBounds != null)
        {
            throw new IllegalStateException("Position has already been set using positionFromBounds");
        }
        if (latlng == null)
        {
            throw new IllegalArgumentException("Location must be specified");
        }
        if (f < 0.0F)
        {
            throw new IllegalArgumentException("Width must be non-negative");
        } else
        {
            mLocation = latlng;
            mWidth = f;
            mHeight = -1F;
            return this;
        }
    }

    public GroundOverlayOptions position(LatLng latlng, float f, float f1)
    {
        if (mBounds != null)
        {
            throw new IllegalStateException("Position has already been set using positionFromBounds");
        }
        if (latlng == null)
        {
            throw new IllegalArgumentException("Location must be specified");
        }
        if (f < 0.0F)
        {
            throw new IllegalArgumentException("Width must be non-negative");
        }
        if (f1 < 0.0F)
        {
            throw new IllegalArgumentException("Height must be non-negative");
        } else
        {
            mLocation = latlng;
            mWidth = f;
            mHeight = f1;
            return this;
        }
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latlngbounds)
    {
        if (mLocation != null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Position has already been set using position: ").append(mLocation).toString());
        } else
        {
            mBounds = latlngbounds;
            return this;
        }
    }

    public GroundOverlayOptions transparency(float f)
    {
        if (f < 0.0F || f > 1.0F)
        {
            throw new IllegalArgumentException("Transparency must be in the range [0..1]");
        } else
        {
            mTransparency = f;
            return this;
        }
    }

    public GroundOverlayOptions visible(boolean flag)
    {
        mVisible = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        GroundOverlayOptionsCreator.write(this, parcel, i);
    }

    public GroundOverlayOptions zIndex(float f)
    {
        mZIndex = f;
        return this;
    }

}
