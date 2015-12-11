// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;
import com.amazon.geo.mapsv2.model.TileOverlay;
import com.amazon.geo.mapsv2.model.internal.ITileOverlayDelegate;

// Referenced classes of package com.amazon.geo.mapsv2:
//            WrapperCreators

static final class legate
    implements com.amazon.geo.mapsv2.pvt.eator
{

    public TileOverlay newWrapper(ITileOverlayDelegate itileoverlaydelegate)
    {
        return new TileOverlay(itileoverlaydelegate);
    }

    public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
    {
        return newWrapper((ITileOverlayDelegate)iobjectdelegate);
    }

    legate()
    {
    }
}
