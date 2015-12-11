// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;
import com.amazon.geo.mapsv2.model.GroundOverlay;
import com.amazon.geo.mapsv2.model.internal.IGroundOverlayDelegate;

// Referenced classes of package com.amazon.geo.mapsv2:
//            WrapperCreators

static final class legate
    implements com.amazon.geo.mapsv2.pvt.eator
{

    public GroundOverlay newWrapper(IGroundOverlayDelegate igroundoverlaydelegate)
    {
        return new GroundOverlay(igroundoverlaydelegate);
    }

    public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
    {
        return newWrapper((IGroundOverlayDelegate)iobjectdelegate);
    }

    legate()
    {
    }
}
