// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;
import com.amazon.geo.mapsv2.model.internal.IIndoorLevelDelegate;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            IndoorBuilding, IndoorLevel

static final class e
    implements com.amazon.geo.mapsv2.pvt.reator
{

    public IndoorLevel newWrapper(IIndoorLevelDelegate iindoorleveldelegate)
    {
        return new IndoorLevel(iindoorleveldelegate);
    }

    public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
    {
        return newWrapper((IIndoorLevelDelegate)iobjectdelegate);
    }

    e()
    {
    }
}
