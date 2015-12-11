// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.internal;

import android.graphics.Point;
import com.amazon.geo.mapsv2.model.internal.ICameraPositionPrimitive;
import com.amazon.geo.mapsv2.model.internal.ILatLngBoundsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;

// Referenced classes of package com.amazon.geo.mapsv2.internal:
//            ICameraUpdateDelegate

public interface ICameraUpdateFactoryDelegate
{

    public abstract ICameraUpdateDelegate newCameraPosition(ICameraPositionPrimitive icamerapositionprimitive);

    public abstract ICameraUpdateDelegate newLatLng(ILatLngPrimitive ilatlngprimitive);

    public abstract ICameraUpdateDelegate newLatLngBounds(ILatLngBoundsPrimitive ilatlngboundsprimitive, int i);

    public abstract ICameraUpdateDelegate newLatLngBounds(ILatLngBoundsPrimitive ilatlngboundsprimitive, int i, int j, int k);

    public abstract ICameraUpdateDelegate newLatLngZoom(ILatLngPrimitive ilatlngprimitive, float f);

    public abstract ICameraUpdateDelegate scrollBy(float f, float f1);

    public abstract ICameraUpdateDelegate zoomBy(float f);

    public abstract ICameraUpdateDelegate zoomBy(float f, Point point);

    public abstract ICameraUpdateDelegate zoomIn();

    public abstract ICameraUpdateDelegate zoomOut();

    public abstract ICameraUpdateDelegate zoomTo(float f);
}
