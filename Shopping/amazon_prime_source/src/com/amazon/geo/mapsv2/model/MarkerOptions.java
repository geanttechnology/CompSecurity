// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            MarkerOptionsCreator, BitmapDescriptor, LatLng

public final class MarkerOptions
    implements SafeParcelable
{

    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();
    private float mAlpha;
    private float mAnchorU;
    private float mAnchorV;
    private boolean mDraggable;
    private boolean mFlat;
    private BitmapDescriptor mIcon;
    private float mInfoWindowAnchorU;
    private float mInfoWindowAnchorV;
    private LatLng mPosition;
    private float mRotation;
    private String mSnippet;
    private String mTitle;
    private boolean mVisible;

    public MarkerOptions()
    {
        mAlpha = 1.0F;
        mAnchorU = 0.5F;
        mAnchorV = 1.0F;
        mDraggable = false;
        mFlat = false;
        mIcon = null;
        mInfoWindowAnchorU = 0.5F;
        mInfoWindowAnchorV = 0.0F;
        mPosition = null;
        mRotation = 0.0F;
        mSnippet = null;
        mTitle = null;
        mVisible = true;
    }

    MarkerOptions(float f, float f1, float f2, boolean flag, boolean flag1, BitmapDescriptor bitmapdescriptor, float f3, 
            float f4, LatLng latlng, float f5, String s, String s1, boolean flag2)
    {
        mAlpha = 1.0F;
        mAnchorU = 0.5F;
        mAnchorV = 1.0F;
        mDraggable = false;
        mFlat = false;
        mIcon = null;
        mInfoWindowAnchorU = 0.5F;
        mInfoWindowAnchorV = 0.0F;
        mPosition = null;
        mRotation = 0.0F;
        mSnippet = null;
        mTitle = null;
        mVisible = true;
        mAlpha = f;
        mAnchorU = f1;
        mAnchorV = f2;
        mDraggable = flag;
        mFlat = flag1;
        mIcon = bitmapdescriptor;
        mInfoWindowAnchorU = f3;
        mInfoWindowAnchorV = f4;
        mPosition = latlng;
        mRotation = f5;
        mSnippet = s;
        mTitle = s1;
        mVisible = flag2;
    }

    public MarkerOptions alpha(float f)
    {
        mAlpha = f;
        return this;
    }

    public MarkerOptions anchor(float f, float f1)
    {
        mAnchorU = f;
        mAnchorV = f1;
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public MarkerOptions draggable(boolean flag)
    {
        mDraggable = flag;
        return this;
    }

    public MarkerOptions flat(boolean flag)
    {
        mFlat = flag;
        return this;
    }

    public float getAlpha()
    {
        return mAlpha;
    }

    public float getAnchorU()
    {
        return mAnchorU;
    }

    public float getAnchorV()
    {
        return mAnchorV;
    }

    public BitmapDescriptor getIcon()
    {
        return mIcon;
    }

    public float getInfoWindowAnchorU()
    {
        return mInfoWindowAnchorU;
    }

    public float getInfoWindowAnchorV()
    {
        return mInfoWindowAnchorV;
    }

    public LatLng getPosition()
    {
        return mPosition;
    }

    public float getRotation()
    {
        return mRotation;
    }

    public String getSnippet()
    {
        return mSnippet;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapdescriptor)
    {
        mIcon = bitmapdescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f, float f1)
    {
        mInfoWindowAnchorU = f;
        mInfoWindowAnchorV = f1;
        return this;
    }

    public boolean isDraggable()
    {
        return mDraggable;
    }

    public boolean isFlat()
    {
        return mFlat;
    }

    public boolean isVisible()
    {
        return mVisible;
    }

    public MarkerOptions position(LatLng latlng)
    {
        mPosition = latlng;
        return this;
    }

    public MarkerOptions rotation(float f)
    {
        mRotation = f;
        return this;
    }

    public MarkerOptions snippet(String s)
    {
        mSnippet = s;
        return this;
    }

    public MarkerOptions title(String s)
    {
        mTitle = s;
        return this;
    }

    public MarkerOptions visible(boolean flag)
    {
        mVisible = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        MarkerOptionsCreator.write(this, parcel, i);
    }

}
