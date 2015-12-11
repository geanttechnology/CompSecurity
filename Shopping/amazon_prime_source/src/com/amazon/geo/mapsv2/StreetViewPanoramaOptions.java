// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.os.Parcel;
import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.geo.mapsv2.model.StreetViewPanoramaCamera;
import com.amazon.geo.mapsv2.pvt.AmazonMapsStrictModeHelper;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;

// Referenced classes of package com.amazon.geo.mapsv2:
//            StreetViewPanoramaOptionsCreator

public final class StreetViewPanoramaOptions
    implements SafeParcelable
{

    public static final StreetViewPanoramaOptionsCreator CREATOR = new StreetViewPanoramaOptionsCreator();
    private Boolean mPanningGesturesEnabled;
    private String mPanoramaId;
    private LatLng mPosition;
    private Integer mRadius;
    private Boolean mStreetNamesEnabled;
    private StreetViewPanoramaCamera mStreetViewPanoramaCamera;
    private Boolean mUseViewLifecycleInFragment;
    private Boolean mUserNavigationEnabled;
    private Boolean mZoomGesturesEnabled;

    public StreetViewPanoramaOptions()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
    }

    StreetViewPanoramaOptions(Parcel parcel)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        mPanningGesturesEnabled = (Boolean)parcel.readValue(java/lang/Boolean.getClassLoader());
        mPanoramaId = parcel.readString();
        mPosition = (LatLng)parcel.readParcelable(com/amazon/geo/mapsv2/model/LatLng.getClassLoader());
        mRadius = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        mStreetNamesEnabled = (Boolean)parcel.readValue(java/lang/Boolean.getClassLoader());
        mStreetViewPanoramaCamera = (StreetViewPanoramaCamera)parcel.readParcelable(com/amazon/geo/mapsv2/model/StreetViewPanoramaCamera.getClassLoader());
        mUseViewLifecycleInFragment = (Boolean)parcel.readValue(java/lang/Boolean.getClassLoader());
        mUserNavigationEnabled = (Boolean)parcel.readValue(java/lang/Boolean.getClassLoader());
        mZoomGesturesEnabled = (Boolean)parcel.readValue(java/lang/Boolean.getClassLoader());
    }

    public int describeContents()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return 0;
    }

    public Boolean getPanningGesturesEnabled()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return mPanningGesturesEnabled;
    }

    public String getPanoramaId()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return mPanoramaId;
    }

    public LatLng getPosition()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return mPosition;
    }

    public Integer getRadius()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return mRadius;
    }

    public Boolean getStreetNamesEnabled()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return mStreetNamesEnabled;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return mStreetViewPanoramaCamera;
    }

    public Boolean getUseViewLifecycleInFragment()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return mUseViewLifecycleInFragment;
    }

    public Boolean getUserNavigationEnabled()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return mUserNavigationEnabled;
    }

    public Boolean getZoomGesturesEnabled()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return mZoomGesturesEnabled;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean flag)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        mPanningGesturesEnabled = Boolean.valueOf(flag);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetviewpanoramacamera)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        mStreetViewPanoramaCamera = streetviewpanoramacamera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String s)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        mPanoramaId = s;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latlng)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        mPosition = latlng;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latlng, Integer integer)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        mPosition = latlng;
        mRadius = integer;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean flag)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        mStreetNamesEnabled = Boolean.valueOf(flag);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean flag)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        mUseViewLifecycleInFragment = Boolean.valueOf(flag);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean flag)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        mUserNavigationEnabled = Boolean.valueOf(flag);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        parcel.writeValue(mPanningGesturesEnabled);
        parcel.writeString(mPanoramaId);
        parcel.writeParcelable(mPosition, i);
        parcel.writeValue(mRadius);
        parcel.writeValue(mStreetNamesEnabled);
        parcel.writeParcelable(mStreetViewPanoramaCamera, i);
        parcel.writeValue(mUseViewLifecycleInFragment);
        parcel.writeValue(mUserNavigationEnabled);
        parcel.writeValue(mZoomGesturesEnabled);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean flag)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        mZoomGesturesEnabled = Boolean.valueOf(flag);
        return this;
    }

}
