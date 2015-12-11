// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;
import com.amazon.geo.mapsv2.model.Circle;
import com.amazon.geo.mapsv2.model.internal.ICircleDelegate;

// Referenced classes of package com.amazon.geo.mapsv2:
//            WrapperCreators

static final class legate
    implements com.amazon.geo.mapsv2.pvt.eator
{

    public Circle newWrapper(ICircleDelegate icircledelegate)
    {
        return new Circle(icircledelegate);
    }

    public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
    {
        return newWrapper((ICircleDelegate)iobjectdelegate);
    }

    legate()
    {
    }
}
