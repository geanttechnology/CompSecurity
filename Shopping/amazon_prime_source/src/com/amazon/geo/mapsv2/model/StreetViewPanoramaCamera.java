// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;
import com.amazon.geo.mapsv2.pvt.AmazonMapsStrictModeHelper;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            StreetViewPanoramaCameraCreator, StreetViewPanoramaOrientation

public class StreetViewPanoramaCamera
    implements SafeParcelable
{
    public static final class Builder
    {

        public float bearing;
        public float tilt;
        public float zoom;

        public Builder bearing(float f)
        {
            AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
            bearing = f;
            return this;
        }

        public StreetViewPanoramaCamera build()
        {
            AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
            return new StreetViewPanoramaCamera(zoom, tilt, bearing);
        }

        public Builder orientation(StreetViewPanoramaOrientation streetviewpanoramaorientation)
        {
            AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
            bearing = streetviewpanoramaorientation.bearing;
            tilt = streetviewpanoramaorientation.tilt;
            return this;
        }

        public Builder tilt(float f)
        {
            AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
            tilt = f;
            return this;
        }

        public Builder zoom(float f)
        {
            AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
            zoom = f;
            return this;
        }

        public Builder()
        {
            AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        }

        public Builder(StreetViewPanoramaCamera streetviewpanoramacamera)
        {
            AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
            bearing = streetviewpanoramacamera.bearing;
            tilt = streetviewpanoramacamera.tilt;
            zoom = streetviewpanoramacamera.zoom;
        }
    }


    public static final StreetViewPanoramaCameraCreator CREATOR = new StreetViewPanoramaCameraCreator();
    public final float bearing;
    public final float tilt;
    public final float zoom;

    public StreetViewPanoramaCamera(float f, float f1, float f2)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        zoom = f;
        tilt = f1;
        bearing = f2;
    }

    StreetViewPanoramaCamera(Parcel parcel)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        bearing = parcel.readFloat();
        tilt = parcel.readFloat();
        zoom = parcel.readFloat();
    }

    public static Builder builder()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return new Builder();
    }

    public static Builder builder(StreetViewPanoramaCamera streetviewpanoramacamera)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return new Builder(streetviewpanoramacamera);
    }

    public int describeContents()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return 0;
    }

    public boolean equals(Object obj)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        if (this != obj)
        {
            if (!(obj instanceof StreetViewPanoramaCamera))
            {
                return false;
            }
            obj = (StreetViewPanoramaCamera)obj;
            if (bearing != ((StreetViewPanoramaCamera) (obj)).bearing || tilt != ((StreetViewPanoramaCamera) (obj)).tilt || zoom != ((StreetViewPanoramaCamera) (obj)).zoom)
            {
                return false;
            }
        }
        return true;
    }

    public StreetViewPanoramaOrientation getOrientation()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return new StreetViewPanoramaOrientation(tilt, bearing);
    }

    public int hashCode()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return ((Float.floatToIntBits(bearing) + 527) * 31 + Float.floatToIntBits(tilt)) * 31 + Float.floatToIntBits(zoom);
    }

    public String toString()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return (new StringBuilder()).append(getClass().getSimpleName()).append("{zoom=").append(zoom).append(", tilt=").append(tilt).append(", bearing=").append(bearing).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        parcel.writeFloat(bearing);
        parcel.writeFloat(tilt);
        parcel.writeFloat(zoom);
    }

}
