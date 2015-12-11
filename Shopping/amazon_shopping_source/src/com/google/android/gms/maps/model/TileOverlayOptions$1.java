// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import com.google.android.gms.maps.model.internal.i;

// Referenced classes of package com.google.android.gms.maps.model:
//            TileProvider, TileOverlayOptions

class abh
    implements TileProvider
{

    private final i abg;
    final TileOverlayOptions abh;

    (TileOverlayOptions tileoverlayoptions)
    {
        abh = tileoverlayoptions;
        super();
        abg = TileOverlayOptions.a(abh);
    }
}
