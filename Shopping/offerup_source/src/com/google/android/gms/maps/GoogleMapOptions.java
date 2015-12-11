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
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;

// Referenced classes of package com.google.android.gms.maps:
//            zza

public final class GoogleMapOptions
    implements SafeParcelable
{

    public static final com.google.android.gms.maps.zza CREATOR = new com.google.android.gms.maps.zza();
    private final int mVersionCode;
    private Boolean zzaIA;
    private Boolean zzaIB;
    private int zzaIC;
    private CameraPosition zzaID;
    private Boolean zzaIE;
    private Boolean zzaIF;
    private Boolean zzaIG;
    private Boolean zzaIH;
    private Boolean zzaII;
    private Boolean zzaIJ;
    private Boolean zzaIK;
    private Boolean zzaIL;
    private Boolean zzaIM;

    public GoogleMapOptions()
    {
        zzaIC = -1;
        mVersionCode = 1;
    }

    GoogleMapOptions(int i, byte byte0, byte byte1, int j, CameraPosition cameraposition, byte byte2, byte byte3, 
            byte byte4, byte byte5, byte byte6, byte byte7, byte byte8, byte byte9, byte byte10)
    {
        zzaIC = -1;
        mVersionCode = i;
        zzaIA = zza.zza(byte0);
        zzaIB = zza.zza(byte1);
        zzaIC = j;
        zzaID = cameraposition;
        zzaIE = zza.zza(byte2);
        zzaIF = zza.zza(byte3);
        zzaIG = zza.zza(byte4);
        zzaIH = zza.zza(byte5);
        zzaII = zza.zza(byte6);
        zzaIJ = zza.zza(byte7);
        zzaIK = zza.zza(byte8);
        zzaIL = zza.zza(byte9);
        zzaIM = zza.zza(byte10);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeset)
    {
        if (attributeset == null)
        {
            return null;
        }
        TypedArray typedarray = context.getResources().obtainAttributes(attributeset, com.google.android.gms.R.styleable.MapAttrs);
        GoogleMapOptions googlemapoptions = new GoogleMapOptions();
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_mapType))
        {
            googlemapoptions.mapType(typedarray.getInt(com.google.android.gms.R.styleable.MapAttrs_mapType, -1));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_zOrderOnTop))
        {
            googlemapoptions.zOrderOnTop(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_useViewLifecycle))
        {
            googlemapoptions.useViewLifecycleInFragment(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiCompass))
        {
            googlemapoptions.compassEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiCompass, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiRotateGestures))
        {
            googlemapoptions.rotateGesturesEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiScrollGestures))
        {
            googlemapoptions.scrollGesturesEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiTiltGestures))
        {
            googlemapoptions.tiltGesturesEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiZoomGestures))
        {
            googlemapoptions.zoomGesturesEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiZoomControls))
        {
            googlemapoptions.zoomControlsEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_liteMode))
        {
            googlemapoptions.liteMode(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_liteMode, false));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiMapToolbar))
        {
            googlemapoptions.mapToolbarEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_ambientEnabled))
        {
            googlemapoptions.ambientEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_ambientEnabled, false));
        }
        googlemapoptions.camera(CameraPosition.createFromAttributes(context, attributeset));
        typedarray.recycle();
        return googlemapoptions;
    }

    public final GoogleMapOptions ambientEnabled(boolean flag)
    {
        zzaIM = Boolean.valueOf(flag);
        return this;
    }

    public final GoogleMapOptions camera(CameraPosition cameraposition)
    {
        zzaID = cameraposition;
        return this;
    }

    public final GoogleMapOptions compassEnabled(boolean flag)
    {
        zzaIF = Boolean.valueOf(flag);
        return this;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final Boolean getAmbientEnabled()
    {
        return zzaIM;
    }

    public final CameraPosition getCamera()
    {
        return zzaID;
    }

    public final Boolean getCompassEnabled()
    {
        return zzaIF;
    }

    public final Boolean getLiteMode()
    {
        return zzaIK;
    }

    public final Boolean getMapToolbarEnabled()
    {
        return zzaIL;
    }

    public final int getMapType()
    {
        return zzaIC;
    }

    public final Boolean getRotateGesturesEnabled()
    {
        return zzaIJ;
    }

    public final Boolean getScrollGesturesEnabled()
    {
        return zzaIG;
    }

    public final Boolean getTiltGesturesEnabled()
    {
        return zzaII;
    }

    public final Boolean getUseViewLifecycleInFragment()
    {
        return zzaIB;
    }

    final int getVersionCode()
    {
        return mVersionCode;
    }

    public final Boolean getZOrderOnTop()
    {
        return zzaIA;
    }

    public final Boolean getZoomControlsEnabled()
    {
        return zzaIE;
    }

    public final Boolean getZoomGesturesEnabled()
    {
        return zzaIH;
    }

    public final GoogleMapOptions liteMode(boolean flag)
    {
        zzaIK = Boolean.valueOf(flag);
        return this;
    }

    public final GoogleMapOptions mapToolbarEnabled(boolean flag)
    {
        zzaIL = Boolean.valueOf(flag);
        return this;
    }

    public final GoogleMapOptions mapType(int i)
    {
        zzaIC = i;
        return this;
    }

    public final GoogleMapOptions rotateGesturesEnabled(boolean flag)
    {
        zzaIJ = Boolean.valueOf(flag);
        return this;
    }

    public final GoogleMapOptions scrollGesturesEnabled(boolean flag)
    {
        zzaIG = Boolean.valueOf(flag);
        return this;
    }

    public final GoogleMapOptions tiltGesturesEnabled(boolean flag)
    {
        zzaII = Boolean.valueOf(flag);
        return this;
    }

    public final GoogleMapOptions useViewLifecycleInFragment(boolean flag)
    {
        zzaIB = Boolean.valueOf(flag);
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.maps.zza.zza(this, parcel, i);
    }

    public final GoogleMapOptions zOrderOnTop(boolean flag)
    {
        zzaIA = Boolean.valueOf(flag);
        return this;
    }

    public final GoogleMapOptions zoomControlsEnabled(boolean flag)
    {
        zzaIE = Boolean.valueOf(flag);
        return this;
    }

    public final GoogleMapOptions zoomGesturesEnabled(boolean flag)
    {
        zzaIH = Boolean.valueOf(flag);
        return this;
    }

    final byte zzxA()
    {
        return zza.zze(zzaIB);
    }

    final byte zzxB()
    {
        return zza.zze(zzaIE);
    }

    final byte zzxC()
    {
        return zza.zze(zzaIF);
    }

    final byte zzxD()
    {
        return zza.zze(zzaIG);
    }

    final byte zzxE()
    {
        return zza.zze(zzaIH);
    }

    final byte zzxF()
    {
        return zza.zze(zzaII);
    }

    final byte zzxG()
    {
        return zza.zze(zzaIJ);
    }

    final byte zzxH()
    {
        return zza.zze(zzaIK);
    }

    final byte zzxI()
    {
        return zza.zze(zzaIL);
    }

    final byte zzxJ()
    {
        return zza.zze(zzaIM);
    }

    final byte zzxz()
    {
        return zza.zze(zzaIA);
    }

}
