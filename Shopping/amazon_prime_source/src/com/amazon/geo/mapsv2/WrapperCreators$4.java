// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;
import com.amazon.geo.mapsv2.model.Marker;
import com.amazon.geo.mapsv2.model.internal.IMarkerDelegate;

// Referenced classes of package com.amazon.geo.mapsv2:
//            WrapperCreators

static final class legate
    implements com.amazon.geo.mapsv2.pvt.eator
{

    public Marker newWrapper(IMarkerDelegate imarkerdelegate)
    {
        return new Marker(imarkerdelegate);
    }

    public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
    {
        return newWrapper((IMarkerDelegate)iobjectdelegate);
    }

    legate()
    {
    }
}
