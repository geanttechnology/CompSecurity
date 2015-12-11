// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eg;
import com.google.android.gms.maps.internal.r;

// Referenced classes of package com.google.android.gms.maps.model:
//            CameraPositionCreator, LatLng, a

public final class CameraPosition
    implements SafeParcelable
{
    public static final class Builder
    {

        private LatLng Cm;
        private float Cn;
        private float Co;
        private float Cp;

        public Builder bearing(float f)
        {
            Cp = f;
            return this;
        }

        public CameraPosition build()
        {
            return new CameraPosition(Cm, Cn, Co, Cp);
        }

        public Builder target(LatLng latlng)
        {
            Cm = latlng;
            return this;
        }

        public Builder tilt(float f)
        {
            Co = f;
            return this;
        }

        public Builder zoom(float f)
        {
            Cn = f;
            return this;
        }

        public Builder()
        {
        }

        public Builder(CameraPosition cameraposition)
        {
            Cm = cameraposition.target;
            Cn = cameraposition.zoom;
            Co = cameraposition.tilt;
            Cp = cameraposition.bearing;
        }
    }


    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
    public final float bearing;
    private final int kg;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    CameraPosition(int i, LatLng latlng, float f, float f1, float f2)
    {
        eg.b(latlng, "null camera target");
        boolean flag;
        if (0.0F <= f1 && f1 <= 90F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.b(flag, "Tilt needs to be between 0 and 90 inclusive");
        kg = i;
        target = latlng;
        zoom = f;
        tilt = f1 + 0.0F;
        f = f2;
        if ((double)f2 <= 0.0D)
        {
            f = f2 % 360F + 360F;
        }
        bearing = f % 360F;
    }

    public CameraPosition(LatLng latlng, float f, float f1, float f2)
    {
        this(1, latlng, f, f1, f2);
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
        if (attributeset == null)
        {
            return null;
        }
        context = context.getResources().obtainAttributes(attributeset, com.google.android.gms.R.styleable.MapAttrs);
        float f;
        float f1;
        Builder builder1;
        if (context.hasValue(2))
        {
            f = context.getFloat(2, 0.0F);
        } else
        {
            f = 0.0F;
        }
        if (context.hasValue(3))
        {
            f1 = context.getFloat(3, 0.0F);
        } else
        {
            f1 = 0.0F;
        }
        attributeset = new LatLng(f, f1);
        builder1 = builder();
        builder1.target(attributeset);
        if (context.hasValue(5))
        {
            builder1.zoom(context.getFloat(5, 0.0F));
        }
        if (context.hasValue(1))
        {
            builder1.bearing(context.getFloat(1, 0.0F));
        }
        if (context.hasValue(4))
        {
            builder1.tilt(context.getFloat(4, 0.0F));
        }
        return builder1.build();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latlng, float f)
    {
        return new CameraPosition(latlng, f, 0.0F, 0.0F);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof CameraPosition))
            {
                return false;
            }
            obj = (CameraPosition)obj;
            if (!target.equals(((CameraPosition) (obj)).target) || Float.floatToIntBits(zoom) != Float.floatToIntBits(((CameraPosition) (obj)).zoom) || Float.floatToIntBits(tilt) != Float.floatToIntBits(((CameraPosition) (obj)).tilt) || Float.floatToIntBits(bearing) != Float.floatToIntBits(((CameraPosition) (obj)).bearing))
            {
                return false;
            }
        }
        return true;
    }

    int getVersionCode()
    {
        return kg;
    }

    public int hashCode()
    {
        return ee.hashCode(new Object[] {
            target, Float.valueOf(zoom), Float.valueOf(tilt), Float.valueOf(bearing)
        });
    }

    public String toString()
    {
        return ee.e(this).a("target", target).a("zoom", Float.valueOf(zoom)).a("tilt", Float.valueOf(tilt)).a("bearing", Float.valueOf(bearing)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (r.eD())
        {
            a.a(this, parcel, i);
            return;
        } else
        {
            CameraPositionCreator.a(this, parcel, i);
            return;
        }
    }

}
