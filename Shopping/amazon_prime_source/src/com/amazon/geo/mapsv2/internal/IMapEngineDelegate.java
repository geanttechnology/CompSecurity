// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.internal;

import android.content.Context;
import android.os.Bundle;
import com.amazon.geo.mapsv2.model.internal.IBitmapDescriptorFactoryDelegate;
import com.amazon.geo.mapsv2.model.internal.IPrimitivesFactory;

// Referenced classes of package com.amazon.geo.mapsv2.internal:
//            IMapOptionsPrimitive, IMapViewDelegate, IMapsApiStrictModePolicy, ICameraUpdateFactoryDelegate

public interface IMapEngineDelegate
{

    public static final String COMPONENT_NAME = "amazon.geo.client.MapEngine";

    public abstract IMapViewDelegate createMapControlView(Context context, IMapOptionsPrimitive imapoptionsprimitive);

    public abstract IMapsApiStrictModePolicy getApiStrictModePolicy();

    public abstract IBitmapDescriptorFactoryDelegate getBitmapDescriptorFactory();

    public abstract ICameraUpdateFactoryDelegate getCameraUpdateFactory();

    public abstract IPrimitivesFactory getPrimitivesFactory();

    public abstract void setApiStrictModePolicy(IMapsApiStrictModePolicy imapsapistrictmodepolicy);

    public abstract void setEngineOptions(Bundle bundle);

    public abstract void setPrimitivesFactory(IPrimitivesFactory iprimitivesfactory);
}
