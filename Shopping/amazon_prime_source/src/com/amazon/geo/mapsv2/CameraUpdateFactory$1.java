// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.internal.ICameraUpdateDelegate;
import com.amazon.geo.mapsv2.internal.IObjectDelegate;

// Referenced classes of package com.amazon.geo.mapsv2:
//            CameraUpdateFactory, CameraUpdate

static final class te
    implements com.amazon.geo.mapsv2.pvt.r
{

    public CameraUpdate newWrapper(ICameraUpdateDelegate icameraupdatedelegate)
    {
        return new CameraUpdate(icameraupdatedelegate);
    }

    public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
    {
        return newWrapper((ICameraUpdateDelegate)iobjectdelegate);
    }

    te()
    {
    }
}
