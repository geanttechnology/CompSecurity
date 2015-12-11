// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;

// Referenced classes of package com.amazon.geo.mapsv2.model.internal:
//            ILatLngPrimitive

public interface ICameraPositionPrimitive
    extends IObjectDelegate
{

    public abstract float getBearing();

    public abstract ILatLngPrimitive getTarget();

    public abstract float getTilt();

    public abstract float getZoom();
}
