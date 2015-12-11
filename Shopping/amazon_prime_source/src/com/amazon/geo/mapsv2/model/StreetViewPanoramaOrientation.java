// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;
import com.amazon.geo.mapsv2.pvt.AmazonMapsStrictModeHelper;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            StreetViewPanoramaOrientationCreator

public class StreetViewPanoramaOrientation
    implements SafeParcelable
{
    public static final class Builder
    {

        public float bearing;
        public float tilt;

        public Builder bearing(float f)
        {
            AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
            bearing = f;
            return this;
        }

        public StreetViewPanoramaOrientation build()
        {
            AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
            return new StreetViewPanoramaOrientation(tilt, bearing);
        }

        public Builder tilt(float f)
        {
            AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
            tilt = f;
            return this;
        }

        public Builder()
        {
            AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        }

        public Builder(StreetViewPanoramaOrientation streetviewpanoramaorientation)
        {
            AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
            bearing = streetviewpanoramaorientation.bearing;
            tilt = streetviewpanoramaorientation.tilt;
        }
    }


    public static final StreetViewPanoramaOrientationCreator CREATOR = new StreetViewPanoramaOrientationCreator();
    public final float bearing;
    public final float tilt;

    public StreetViewPanoramaOrientation(float f, float f1)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        tilt = f;
        bearing = f1;
    }

    StreetViewPanoramaOrientation(Parcel parcel)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        bearing = parcel.readFloat();
        tilt = parcel.readFloat();
    }

    public static Builder builder()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return new Builder();
    }

    public static Builder builder(StreetViewPanoramaOrientation streetviewpanoramaorientation)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return new Builder(streetviewpanoramaorientation);
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
            if (!(obj instanceof StreetViewPanoramaOrientation))
            {
                return false;
            }
            obj = (StreetViewPanoramaOrientation)obj;
            if (bearing != ((StreetViewPanoramaOrientation) (obj)).bearing || tilt != ((StreetViewPanoramaOrientation) (obj)).tilt)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return (Float.floatToIntBits(bearing) + 527) * 31 + Float.floatToIntBits(tilt);
    }

    public String toString()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return (new StringBuilder()).append(getClass().getSimpleName()).append("{tilt=").append(tilt).append(", bearing=").append(bearing).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        parcel.writeFloat(bearing);
        parcel.writeFloat(tilt);
    }

}
