// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.eg;
import com.google.android.gms.maps.internal.r;

// Referenced classes of package com.google.android.gms.maps.model:
//            GroundOverlayOptionsCreator, BitmapDescriptor, c, LatLng, 
//            LatLngBounds

public final class GroundOverlayOptions
    implements SafeParcelable
{

    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    public static final float NO_DIMENSION = -1F;
    private LatLng CA;
    private float CB;
    private float CC;
    private LatLngBounds CD;
    private float CE;
    private float CF;
    private float CG;
    private float Cp;
    private float Cw;
    private boolean Cx;
    private BitmapDescriptor Cz;
    private final int kg;

    public GroundOverlayOptions()
    {
        Cx = true;
        CE = 0.0F;
        CF = 0.5F;
        CG = 0.5F;
        kg = 1;
    }

    GroundOverlayOptions(int i, IBinder ibinder, LatLng latlng, float f, float f1, LatLngBounds latlngbounds, float f2, 
            float f3, boolean flag, float f4, float f5, float f6)
    {
        Cx = true;
        CE = 0.0F;
        CF = 0.5F;
        CG = 0.5F;
        kg = i;
        Cz = new BitmapDescriptor(com.google.android.gms.dynamic.b.a.E(ibinder));
        CA = latlng;
        CB = f;
        CC = f1;
        CD = latlngbounds;
        Cp = f2;
        Cw = f3;
        Cx = flag;
        CE = f4;
        CF = f5;
        CG = f6;
    }

    private GroundOverlayOptions a(LatLng latlng, float f, float f1)
    {
        CA = latlng;
        CB = f;
        CC = f1;
        return this;
    }

    public GroundOverlayOptions anchor(float f, float f1)
    {
        CF = f;
        CG = f1;
        return this;
    }

    public GroundOverlayOptions bearing(float f)
    {
        Cp = (f % 360F + 360F) % 360F;
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    IBinder eF()
    {
        return Cz.el().asBinder();
    }

    public float getAnchorU()
    {
        return CF;
    }

    public float getAnchorV()
    {
        return CG;
    }

    public float getBearing()
    {
        return Cp;
    }

    public LatLngBounds getBounds()
    {
        return CD;
    }

    public float getHeight()
    {
        return CC;
    }

    public BitmapDescriptor getImage()
    {
        return Cz;
    }

    public LatLng getLocation()
    {
        return CA;
    }

    public float getTransparency()
    {
        return CE;
    }

    int getVersionCode()
    {
        return kg;
    }

    public float getWidth()
    {
        return CB;
    }

    public float getZIndex()
    {
        return Cw;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapdescriptor)
    {
        Cz = bitmapdescriptor;
        return this;
    }

    public boolean isVisible()
    {
        return Cx;
    }

    public GroundOverlayOptions position(LatLng latlng, float f)
    {
        boolean flag1 = true;
        boolean flag;
        if (CD == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.a(flag, "Position has already been set using positionFromBounds");
        if (latlng != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.b(flag, "Location must be specified");
        if (f >= 0.0F)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        eg.b(flag, "Width must be non-negative");
        return a(latlng, f, -1F);
    }

    public GroundOverlayOptions position(LatLng latlng, float f, float f1)
    {
        boolean flag1 = true;
        boolean flag;
        if (CD == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.a(flag, "Position has already been set using positionFromBounds");
        if (latlng != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.b(flag, "Location must be specified");
        if (f >= 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.b(flag, "Width must be non-negative");
        if (f1 >= 0.0F)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        eg.b(flag, "Height must be non-negative");
        return a(latlng, f, f1);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latlngbounds)
    {
        boolean flag;
        if (CA == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.a(flag, (new StringBuilder()).append("Position has already been set using position: ").append(CA).toString());
        CD = latlngbounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f)
    {
        boolean flag;
        if (f >= 0.0F && f <= 1.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.b(flag, "Transparency must be in the range [0..1]");
        CE = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean flag)
    {
        Cx = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (r.eD())
        {
            c.a(this, parcel, i);
            return;
        } else
        {
            GroundOverlayOptionsCreator.a(this, parcel, i);
            return;
        }
    }

    public GroundOverlayOptions zIndex(float f)
    {
        Cw = f;
        return this;
    }

}
