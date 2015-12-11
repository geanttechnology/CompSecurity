// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;


// Referenced classes of package com.google.android.gms.maps.model:
//            TileProvider, TileOverlayOptions, Tile

class t> extends com.google.android.gms.maps.model.internal.
{

    final TileOverlayOptions zzaKE;
    final TileProvider zzaKF;

    public Tile getTile(int i, int j, int k)
    {
        return zzaKF.getTile(i, j, k);
    }

    (TileOverlayOptions tileoverlayoptions, TileProvider tileprovider)
    {
        zzaKE = tileoverlayoptions;
        zzaKF = tileprovider;
        super();
    }
}
