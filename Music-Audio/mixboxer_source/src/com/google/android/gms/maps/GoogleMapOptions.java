// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.a;
import com.google.android.gms.maps.internal.r;
import com.google.android.gms.maps.model.CameraPosition;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMapOptionsCreator, a

public final class GoogleMapOptions
    implements SafeParcelable
{

    public static final GoogleMapOptionsCreator CREATOR = new GoogleMapOptionsCreator();
    private Boolean BJ;
    private Boolean BK;
    private int BL;
    private CameraPosition BM;
    private Boolean BN;
    private Boolean BO;
    private Boolean BP;
    private Boolean BQ;
    private Boolean BR;
    private Boolean BS;
    private final int kg;

    public GoogleMapOptions()
    {
        BL = -1;
        kg = 1;
    }

    GoogleMapOptions(int i, byte byte0, byte byte1, int j, CameraPosition cameraposition, byte byte2, byte byte3, 
            byte byte4, byte byte5, byte byte6, byte byte7)
    {
        BL = -1;
        kg = i;
        BJ = a.a(byte0);
        BK = a.a(byte1);
        BL = j;
        BM = cameraposition;
        BN = a.a(byte2);
        BO = a.a(byte3);
        BP = a.a(byte4);
        BQ = a.a(byte5);
        BR = a.a(byte6);
        BS = a.a(byte7);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeset)
    {
        if (attributeset == null)
        {
            return null;
        }
        TypedArray typedarray = context.getResources().obtainAttributes(attributeset, com.google.android.gms.R.styleable.MapAttrs);
        GoogleMapOptions googlemapoptions = new GoogleMapOptions();
        if (typedarray.hasValue(0))
        {
            googlemapoptions.mapType(typedarray.getInt(0, -1));
        }
        if (typedarray.hasValue(13))
        {
            googlemapoptions.zOrderOnTop(typedarray.getBoolean(13, false));
        }
        if (typedarray.hasValue(12))
        {
            googlemapoptions.useViewLifecycleInFragment(typedarray.getBoolean(12, false));
        }
        if (typedarray.hasValue(6))
        {
            googlemapoptions.compassEnabled(typedarray.getBoolean(6, true));
        }
        if (typedarray.hasValue(7))
        {
            googlemapoptions.rotateGesturesEnabled(typedarray.getBoolean(7, true));
        }
        if (typedarray.hasValue(8))
        {
            googlemapoptions.scrollGesturesEnabled(typedarray.getBoolean(8, true));
        }
        if (typedarray.hasValue(9))
        {
            googlemapoptions.tiltGesturesEnabled(typedarray.getBoolean(9, true));
        }
        if (typedarray.hasValue(11))
        {
            googlemapoptions.zoomGesturesEnabled(typedarray.getBoolean(11, true));
        }
        if (typedarray.hasValue(10))
        {
            googlemapoptions.zoomControlsEnabled(typedarray.getBoolean(10, true));
        }
        googlemapoptions.camera(CameraPosition.createFromAttributes(context, attributeset));
        typedarray.recycle();
        return googlemapoptions;
    }

    public GoogleMapOptions camera(CameraPosition cameraposition)
    {
        BM = cameraposition;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean flag)
    {
        BO = Boolean.valueOf(flag);
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    byte eo()
    {
        return a.c(BJ);
    }

    byte ep()
    {
        return a.c(BK);
    }

    byte eq()
    {
        return a.c(BN);
    }

    byte er()
    {
        return a.c(BO);
    }

    byte es()
    {
        return a.c(BP);
    }

    byte et()
    {
        return a.c(BQ);
    }

    byte eu()
    {
        return a.c(BR);
    }

    byte ev()
    {
        return a.c(BS);
    }

    public CameraPosition getCamera()
    {
        return BM;
    }

    public Boolean getCompassEnabled()
    {
        return BO;
    }

    public int getMapType()
    {
        return BL;
    }

    public Boolean getRotateGesturesEnabled()
    {
        return BS;
    }

    public Boolean getScrollGesturesEnabled()
    {
        return BP;
    }

    public Boolean getTiltGesturesEnabled()
    {
        return BR;
    }

    public Boolean getUseViewLifecycleInFragment()
    {
        return BK;
    }

    int getVersionCode()
    {
        return kg;
    }

    public Boolean getZOrderOnTop()
    {
        return BJ;
    }

    public Boolean getZoomControlsEnabled()
    {
        return BN;
    }

    public Boolean getZoomGesturesEnabled()
    {
        return BQ;
    }

    public GoogleMapOptions mapType(int i)
    {
        BL = i;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean flag)
    {
        BS = Boolean.valueOf(flag);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean flag)
    {
        BP = Boolean.valueOf(flag);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean flag)
    {
        BR = Boolean.valueOf(flag);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean flag)
    {
        BK = Boolean.valueOf(flag);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (r.eD())
        {
            com.google.android.gms.maps.a.a(this, parcel, i);
            return;
        } else
        {
            com.google.android.gms.maps.GoogleMapOptionsCreator.a(this, parcel, i);
            return;
        }
    }

    public GoogleMapOptions zOrderOnTop(boolean flag)
    {
        BJ = Boolean.valueOf(flag);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean flag)
    {
        BN = Boolean.valueOf(flag);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean flag)
    {
        BQ = Boolean.valueOf(flag);
        return this;
    }

}
