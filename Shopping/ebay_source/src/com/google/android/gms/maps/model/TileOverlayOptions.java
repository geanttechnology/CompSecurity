// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzl;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzn, TileProvider

public final class TileOverlayOptions
    implements SafeParcelable
{

    public static final zzn CREATOR = new zzn();
    private final int zzCY;
    private zzl zzaDG;
    private TileProvider zzaDH;
    private boolean zzaDI;
    private float zzaDa;
    private boolean zzaDb;

    public TileOverlayOptions()
    {
        zzaDb = true;
        zzaDI = true;
        zzCY = 1;
    }

    TileOverlayOptions(int i, IBinder ibinder, boolean flag, float f, boolean flag1)
    {
        zzaDb = true;
        zzaDI = true;
        zzCY = i;
        zzaDG = com.google.android.gms.maps.model.internal.zzl.zza.zzcT(ibinder);
        if (zzaDG == null)
        {
            ibinder = null;
        } else
        {
            ibinder = new TileProvider() {

                private final zzl zzaDJ;
                final TileOverlayOptions zzaDK;

            
            {
                zzaDK = TileOverlayOptions.this;
                super();
                zzaDJ = TileOverlayOptions.zza(zzaDK);
            }
            };
        }
        zzaDH = ibinder;
        zzaDb = flag;
        zzaDa = f;
        zzaDI = flag1;
    }

    static zzl zza(TileOverlayOptions tileoverlayoptions)
    {
        return tileoverlayoptions.zzaDG;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean getFadeIn()
    {
        return zzaDI;
    }

    int getVersionCode()
    {
        return zzCY;
    }

    public float getZIndex()
    {
        return zzaDa;
    }

    public boolean isVisible()
    {
        return zzaDb;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzn.zza(this, parcel, i);
    }

    IBinder zzvL()
    {
        return zzaDG.asBinder();
    }

}
