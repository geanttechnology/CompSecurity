// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.g;

// Referenced classes of package com.google.android.gms.maps.model:
//            TileProvider, TileOverlayOptions, Tile

class De
    implements TileProvider
{

    private final g Dd;
    final TileOverlayOptions De;

    public Tile getTile(int i, int j, int k)
    {
        Tile tile;
        try
        {
            tile = Dd.getTile(i, j, k);
        }
        catch (RemoteException remoteexception)
        {
            return null;
        }
        return tile;
    }

    (TileOverlayOptions tileoverlayoptions)
    {
        De = tileoverlayoptions;
        super();
        Dd = TileOverlayOptions.a(De);
    }
}
