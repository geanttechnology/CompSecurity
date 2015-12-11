// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.r;
import com.google.android.gms.maps.model.internal.g;

// Referenced classes of package com.google.android.gms.maps.model:
//            TileOverlayOptionsCreator, j, TileProvider, Tile

public final class TileOverlayOptions
    implements SafeParcelable
{

    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private float Cw;
    private boolean Cx;
    private g Da;
    private TileProvider Db;
    private boolean Dc;
    private final int kg;

    public TileOverlayOptions()
    {
        Cx = true;
        Dc = true;
        kg = 1;
    }

    TileOverlayOptions(int i, IBinder ibinder, boolean flag, float f, boolean flag1)
    {
        Cx = true;
        Dc = true;
        kg = i;
        Da = com.google.android.gms.maps.model.internal.g.a.aq(ibinder);
        if (Da == null)
        {
            ibinder = null;
        } else
        {
            ibinder = new TileProvider() {

                private final g Dd;
                final TileOverlayOptions De;

                public Tile getTile(int k, int l, int i1)
                {
                    Tile tile;
                    try
                    {
                        tile = Dd.getTile(k, l, i1);
                    }
                    catch (RemoteException remoteexception)
                    {
                        return null;
                    }
                    return tile;
                }

            
            {
                De = TileOverlayOptions.this;
                super();
                Dd = TileOverlayOptions.a(De);
            }
            };
        }
        Db = ibinder;
        Cx = flag;
        Cw = f;
        Dc = flag1;
    }

    static g a(TileOverlayOptions tileoverlayoptions)
    {
        return tileoverlayoptions.Da;
    }

    public int describeContents()
    {
        return 0;
    }

    IBinder eI()
    {
        return Da.asBinder();
    }

    public TileOverlayOptions fadeIn(boolean flag)
    {
        Dc = flag;
        return this;
    }

    public boolean getFadeIn()
    {
        return Dc;
    }

    public TileProvider getTileProvider()
    {
        return Db;
    }

    int getVersionCode()
    {
        return kg;
    }

    public float getZIndex()
    {
        return Cw;
    }

    public boolean isVisible()
    {
        return Cx;
    }

    public TileOverlayOptions tileProvider(TileProvider tileprovider)
    {
        Db = tileprovider;
        if (Db == null)
        {
            tileprovider = null;
        } else
        {
            tileprovider = new com.google.android.gms.maps.model.internal.g.a(tileprovider) {

                final TileOverlayOptions De;
                final TileProvider Df;

                public Tile getTile(int i, int k, int l)
                {
                    return Df.getTile(i, k, l);
                }

            
            {
                De = TileOverlayOptions.this;
                Df = tileprovider;
                super();
            }
            };
        }
        Da = tileprovider;
        return this;
    }

    public TileOverlayOptions visible(boolean flag)
    {
        Cx = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (r.eD())
        {
            j.a(this, parcel, i);
            return;
        } else
        {
            TileOverlayOptionsCreator.a(this, parcel, i);
            return;
        }
    }

    public TileOverlayOptions zIndex(float f)
    {
        Cw = f;
        return this;
    }

}
