// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzi;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzo, TileProvider

public final class TileOverlayOptions
    implements SafeParcelable
{

    public static final zzo CREATOR = new zzo();
    private final int mVersionCode;
    private float zzaJS;
    private boolean zzaJT;
    private zzi zzaKA;
    private TileProvider zzaKB;
    private boolean zzaKC;

    public TileOverlayOptions()
    {
        zzaJT = true;
        zzaKC = true;
        mVersionCode = 1;
    }

    TileOverlayOptions(int i, IBinder ibinder, boolean flag, float f, boolean flag1)
    {
        zzaJT = true;
        zzaKC = true;
        mVersionCode = i;
        zzaKA = com.google.android.gms.maps.model.internal.zzi.zza.zzcY(ibinder);
        if (zzaKA == null)
        {
            ibinder = null;
        } else
        {
            ibinder = new _cls1();
        }
        zzaKB = ibinder;
        zzaJT = flag;
        zzaJS = f;
        zzaKC = flag1;
    }

    static zzi zza(TileOverlayOptions tileoverlayoptions)
    {
        return tileoverlayoptions.zzaKA;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final TileOverlayOptions fadeIn(boolean flag)
    {
        zzaKC = flag;
        return this;
    }

    public final boolean getFadeIn()
    {
        return zzaKC;
    }

    public final TileProvider getTileProvider()
    {
        return zzaKB;
    }

    final int getVersionCode()
    {
        return mVersionCode;
    }

    public final float getZIndex()
    {
        return zzaJS;
    }

    public final boolean isVisible()
    {
        return zzaJT;
    }

    public final TileOverlayOptions tileProvider(TileProvider tileprovider)
    {
        zzaKB = tileprovider;
        if (zzaKB == null)
        {
            tileprovider = null;
        } else
        {
            tileprovider = new _cls2(tileprovider);
        }
        zzaKA = tileprovider;
        return this;
    }

    public final TileOverlayOptions visible(boolean flag)
    {
        zzaJT = flag;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzo.zza(this, parcel, i);
    }

    public final TileOverlayOptions zIndex(float f)
    {
        zzaJS = f;
        return this;
    }

    final IBinder zzyb()
    {
        return zzaKA.asBinder();
    }


    private class _cls1
        implements TileProvider
    {

        private final zzi zzaKD;
        final TileOverlayOptions zzaKE;

        public Tile getTile(int i, int j, int k)
        {
            Tile tile;
            try
            {
                tile = zzaKD.getTile(i, j, k);
            }
            catch (RemoteException remoteexception)
            {
                return null;
            }
            return tile;
        }

        _cls1()
        {
            zzaKE = TileOverlayOptions.this;
            super();
            zzaKD = TileOverlayOptions.zza(zzaKE);
        }
    }


    private class _cls2 extends com.google.android.gms.maps.model.internal.zzi.zza
    {

        final TileOverlayOptions zzaKE;
        final TileProvider zzaKF;

        public Tile getTile(int i, int j, int k)
        {
            return zzaKF.getTile(i, j, k);
        }

        _cls2(TileProvider tileprovider)
        {
            zzaKE = TileOverlayOptions.this;
            zzaKF = tileprovider;
            super();
        }
    }

}
