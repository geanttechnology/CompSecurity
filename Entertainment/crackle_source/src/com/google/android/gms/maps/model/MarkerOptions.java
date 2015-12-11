// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.internal.r;

// Referenced classes of package com.google.android.gms.maps.model:
//            MarkerOptionsCreator, BitmapDescriptor, f, LatLng

public final class MarkerOptions
    implements SafeParcelable
{

    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();
    private float CF;
    private float CG;
    private LatLng CM;
    private String CN;
    private BitmapDescriptor CO;
    private boolean CP;
    private boolean CQ;
    private float CR;
    private float CS;
    private float CT;
    private boolean Cx;
    private final int kg;
    private float mAlpha;
    private String qL;

    public MarkerOptions()
    {
        CF = 0.5F;
        CG = 1.0F;
        Cx = true;
        CQ = false;
        CR = 0.0F;
        CS = 0.5F;
        CT = 0.0F;
        mAlpha = 1.0F;
        kg = 1;
    }

    MarkerOptions(int i, LatLng latlng, String s, String s1, IBinder ibinder, float f1, float f2, 
            boolean flag, boolean flag1, boolean flag2, float f3, float f4, float f5, float f6)
    {
        CF = 0.5F;
        CG = 1.0F;
        Cx = true;
        CQ = false;
        CR = 0.0F;
        CS = 0.5F;
        CT = 0.0F;
        mAlpha = 1.0F;
        kg = i;
        CM = latlng;
        qL = s;
        CN = s1;
        if (ibinder == null)
        {
            latlng = null;
        } else
        {
            latlng = new BitmapDescriptor(com.google.android.gms.dynamic.b.a.E(ibinder));
        }
        CO = latlng;
        CF = f1;
        CG = f2;
        CP = flag;
        Cx = flag1;
        CQ = flag2;
        CR = f3;
        CS = f4;
        CT = f5;
        mAlpha = f6;
    }

    public MarkerOptions alpha(float f1)
    {
        mAlpha = f1;
        return this;
    }

    public MarkerOptions anchor(float f1, float f2)
    {
        CF = f1;
        CG = f2;
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public MarkerOptions draggable(boolean flag)
    {
        CP = flag;
        return this;
    }

    IBinder eG()
    {
        if (CO == null)
        {
            return null;
        } else
        {
            return CO.el().asBinder();
        }
    }

    public MarkerOptions flat(boolean flag)
    {
        CQ = flag;
        return this;
    }

    public float getAlpha()
    {
        return mAlpha;
    }

    public float getAnchorU()
    {
        return CF;
    }

    public float getAnchorV()
    {
        return CG;
    }

    public BitmapDescriptor getIcon()
    {
        return CO;
    }

    public float getInfoWindowAnchorU()
    {
        return CS;
    }

    public float getInfoWindowAnchorV()
    {
        return CT;
    }

    public LatLng getPosition()
    {
        return CM;
    }

    public float getRotation()
    {
        return CR;
    }

    public String getSnippet()
    {
        return CN;
    }

    public String getTitle()
    {
        return qL;
    }

    int getVersionCode()
    {
        return kg;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapdescriptor)
    {
        CO = bitmapdescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f1, float f2)
    {
        CS = f1;
        CT = f2;
        return this;
    }

    public boolean isDraggable()
    {
        return CP;
    }

    public boolean isFlat()
    {
        return CQ;
    }

    public boolean isVisible()
    {
        return Cx;
    }

    public MarkerOptions position(LatLng latlng)
    {
        CM = latlng;
        return this;
    }

    public MarkerOptions rotation(float f1)
    {
        CR = f1;
        return this;
    }

    public MarkerOptions snippet(String s)
    {
        CN = s;
        return this;
    }

    public MarkerOptions title(String s)
    {
        qL = s;
        return this;
    }

    public MarkerOptions visible(boolean flag)
    {
        Cx = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (r.eD())
        {
            f.a(this, parcel, i);
            return;
        } else
        {
            MarkerOptionsCreator.a(this, parcel, i);
            return;
        }
    }

}
