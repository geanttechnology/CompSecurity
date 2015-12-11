// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import com.google.android.gms.maps.model.internal.zzl;

// Referenced classes of package com.google.android.gms.maps.model:
//            TileProvider, TileOverlayOptions

class zzaDK
    implements TileProvider
{

    private final zzl zzaDJ;
    final TileOverlayOptions zzaDK;

    (TileOverlayOptions tileoverlayoptions)
    {
        zzaDK = tileoverlayoptions;
        super();
        zzaDJ = TileOverlayOptions.zza(zzaDK);
    }
}
