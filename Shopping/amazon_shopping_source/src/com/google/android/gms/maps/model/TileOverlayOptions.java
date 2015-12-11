// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import com.google.android.gms.maps.model.internal.i;

// Referenced classes of package com.google.android.gms.maps.model:
//            TileOverlayOptionsCreator, j, TileProvider

public final class TileOverlayOptions
    implements SafeParcelable
{

    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private float aax;
    private boolean aay;
    private i abd;
    private TileProvider abe;
    private boolean abf;
    private final int xM;

    public TileOverlayOptions()
    {
        aay = true;
        abf = true;
        xM = 1;
    }

    TileOverlayOptions(int k, IBinder ibinder, boolean flag, float f, boolean flag1)
    {
        aay = true;
        abf = true;
        xM = k;
        abd = com.google.android.gms.maps.model.internal.i.a.bg(ibinder);
        if (abd == null)
        {
            ibinder = null;
        } else
        {
            ibinder = new TileProvider() {

                private final i abg;
                final TileOverlayOptions abh;

            
            {
                abh = TileOverlayOptions.this;
                super();
                abg = TileOverlayOptions.a(abh);
            }
            };
        }
        abe = ibinder;
        aay = flag;
        aax = f;
        abf = flag1;
    }

    static i a(TileOverlayOptions tileoverlayoptions)
    {
        return tileoverlayoptions.abd;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean getFadeIn()
    {
        return abf;
    }

    int getVersionCode()
    {
        return xM;
    }

    public float getZIndex()
    {
        return aax;
    }

    public boolean isVisible()
    {
        return aay;
    }

    IBinder jQ()
    {
        return abd.asBinder();
    }

    public void writeToParcel(Parcel parcel, int k)
    {
        if (v.jL())
        {
            j.a(this, parcel, k);
            return;
        } else
        {
            TileOverlayOptionsCreator.a(this, parcel, k);
            return;
        }
    }

}
