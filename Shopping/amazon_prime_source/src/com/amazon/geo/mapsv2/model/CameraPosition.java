// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.content.Context;
import android.os.Parcel;
import android.util.AttributeSet;
import com.amazon.geo.mapsv2.AmazonMapOptions;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            CameraPositionCreator, LatLng

public final class CameraPosition
    implements SafeParcelable
{
    public static final class Builder
    {

        private float bearing;
        private LatLng target;
        private float tilt;
        private float zoom;

        public Builder bearing(float f)
        {
            bearing = f;
            return this;
        }

        public CameraPosition build()
        {
            return new CameraPosition(this);
        }

        public Builder target(LatLng latlng)
        {
            target = latlng;
            return this;
        }

        public Builder tilt(float f)
        {
            tilt = f;
            return this;
        }

        public Builder zoom(float f)
        {
            zoom = f;
            return this;
        }





        public Builder()
        {
            bearing = 0.0F;
            tilt = 0.0F;
            zoom = 0.0F;
            target = null;
        }

        public Builder(CameraPosition cameraposition)
        {
            bearing = cameraposition.bearing;
            target = cameraposition.target;
            tilt = cameraposition.tilt;
            zoom = cameraposition.zoom;
        }
    }


    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
    public final float bearing;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    private CameraPosition(Builder builder1)
    {
        this(builder1.target, builder1.zoom, builder1.tilt, builder1.bearing);
    }


    public CameraPosition(LatLng latlng, float f, float f1, float f2)
    {
        if (latlng == null)
        {
            throw new NullPointerException("null camera target");
        } else
        {
            target = latlng;
            zoom = f;
            tilt = f1;
            bearing = f2;
            return;
        }
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraposition)
    {
        return new Builder(cameraposition);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attributeset)
    {
        context = AmazonMapOptions.createFromAttributes(context, attributeset);
        if (context == null)
        {
            return null;
        } else
        {
            return context.getCamera();
        }
    }

    public static final CameraPosition fromLatLngZoom(LatLng latlng, float f)
    {
        return builder().target(latlng).zoom(f).build();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (!(obj instanceof CameraPosition))
            {
                return false;
            }
            obj = (CameraPosition)obj;
            if (Float.floatToIntBits(bearing) != Float.floatToIntBits(((CameraPosition) (obj)).bearing))
            {
                return false;
            }
            if (target == null)
            {
                if (((CameraPosition) (obj)).target != null)
                {
                    return false;
                }
            } else
            if (!target.equals(((CameraPosition) (obj)).target))
            {
                return false;
            }
            if (Float.floatToIntBits(tilt) != Float.floatToIntBits(((CameraPosition) (obj)).tilt))
            {
                return false;
            }
            if (Float.floatToIntBits(zoom) != Float.floatToIntBits(((CameraPosition) (obj)).zoom))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = Float.floatToIntBits(bearing);
        int i;
        if (target == null)
        {
            i = 0;
        } else
        {
            i = target.hashCode();
        }
        return (((j + 31) * 31 + i) * 31 + Float.floatToIntBits(tilt)) * 31 + Float.floatToIntBits(zoom);
    }

    public String toString()
    {
        return (new StringBuilder("CameraPosition{target=")).append(target).append(", zoom=").append(zoom).append(", tilt=").append(tilt).append(", bearing=").append(bearing).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        CameraPositionCreator.write(this, parcel, i);
    }

}
