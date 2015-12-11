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
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.maps.model:
//            f, LatLng

public final class CameraPosition
    implements SafeParcelable
{
    public static final class a
    {

        LatLng a;
        float b;
        float c;
        float d;

        public a()
        {
        }
    }


    public static final f CREATOR = new f();
    final int a;
    public final LatLng b;
    public final float c;
    public final float d;
    public final float e;

    CameraPosition(int i, LatLng latlng, float f1, float f2, float f3)
    {
        w.a(latlng, "null camera target");
        boolean flag;
        if (0.0F <= f2 && f2 <= 90F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag, "Tilt needs to be between 0 and 90 inclusive: %s", new Object[] {
            Float.valueOf(f2)
        });
        a = i;
        b = latlng;
        c = f1;
        d = f2 + 0.0F;
        f1 = f3;
        if ((double)f3 <= 0.0D)
        {
            f1 = f3 % 360F + 360F;
        }
        e = f1 % 360F;
    }

    private CameraPosition(LatLng latlng, float f1, float f2, float f3)
    {
        this(1, latlng, f1, f2, f3);
    }

    public static CameraPosition a(Context context, AttributeSet attributeset)
    {
        if (attributeset == null)
        {
            return null;
        }
        context = context.getResources().obtainAttributes(attributeset, com.google.android.gms.a.c.MapAttrs);
        float f1;
        float f2;
        a a1;
        if (context.hasValue(com.google.android.gms.a.c.MapAttrs_cameraTargetLat))
        {
            f1 = context.getFloat(com.google.android.gms.a.c.MapAttrs_cameraTargetLat, 0.0F);
        } else
        {
            f1 = 0.0F;
        }
        if (context.hasValue(com.google.android.gms.a.c.MapAttrs_cameraTargetLng))
        {
            f2 = context.getFloat(com.google.android.gms.a.c.MapAttrs_cameraTargetLng, 0.0F);
        } else
        {
            f2 = 0.0F;
        }
        attributeset = new LatLng(f1, f2);
        a1 = new a();
        a1.a = attributeset;
        if (context.hasValue(com.google.android.gms.a.c.MapAttrs_cameraZoom))
        {
            a1.b = context.getFloat(com.google.android.gms.a.c.MapAttrs_cameraZoom, 0.0F);
        }
        if (context.hasValue(com.google.android.gms.a.c.MapAttrs_cameraBearing))
        {
            a1.d = context.getFloat(com.google.android.gms.a.c.MapAttrs_cameraBearing, 0.0F);
        }
        if (context.hasValue(com.google.android.gms.a.c.MapAttrs_cameraTilt))
        {
            a1.c = context.getFloat(com.google.android.gms.a.c.MapAttrs_cameraTilt, 0.0F);
        }
        return new CameraPosition(a1.a, a1.b, a1.c, a1.d);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof CameraPosition))
            {
                return false;
            }
            obj = (CameraPosition)obj;
            if (!b.equals(((CameraPosition) (obj)).b) || Float.floatToIntBits(c) != Float.floatToIntBits(((CameraPosition) (obj)).c) || Float.floatToIntBits(d) != Float.floatToIntBits(((CameraPosition) (obj)).d) || Float.floatToIntBits(e) != Float.floatToIntBits(((CameraPosition) (obj)).e))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            b, Float.valueOf(c), Float.valueOf(d), Float.valueOf(e)
        });
    }

    public final String toString()
    {
        return v.a(this).a("target", b).a("zoom", Float.valueOf(c)).a("tilt", Float.valueOf(d)).a("bearing", Float.valueOf(e)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        f.a(this, parcel, i);
    }

}
