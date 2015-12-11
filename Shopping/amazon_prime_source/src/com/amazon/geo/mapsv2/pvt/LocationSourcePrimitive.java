// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import android.location.Location;
import com.amazon.geo.mapsv2.LocationSource;
import com.amazon.geo.mapsv2.internal.ILocationSourcePrimitive;

// Referenced classes of package com.amazon.geo.mapsv2.pvt:
//            PrimitiveBase

public class LocationSourcePrimitive extends PrimitiveBase
    implements ILocationSourcePrimitive
{
    public static class OnLocationChangedListenerImpl extends PrimitiveBase
        implements com.amazon.geo.mapsv2.LocationSource.OnLocationChangedListener
    {

        public static com.amazon.geo.mapsv2.LocationSource.OnLocationChangedListener create(com.amazon.geo.mapsv2.internal.ILocationSourcePrimitive.OnLocationChangedListener onlocationchangedlistener)
        {
            if (onlocationchangedlistener == null)
            {
                return null;
            } else
            {
                return new OnLocationChangedListenerImpl(onlocationchangedlistener);
            }
        }

        public void onLocationChanged(Location location)
        {
            ((com.amazon.geo.mapsv2.internal.ILocationSourcePrimitive.OnLocationChangedListener)get()).onLocationChanged(location);
        }

        public OnLocationChangedListenerImpl(com.amazon.geo.mapsv2.internal.ILocationSourcePrimitive.OnLocationChangedListener onlocationchangedlistener)
        {
            super(onlocationchangedlistener);
        }
    }


    public LocationSourcePrimitive(LocationSource locationsource)
    {
        super(locationsource);
    }

    public void activate(com.amazon.geo.mapsv2.internal.ILocationSourcePrimitive.OnLocationChangedListener onlocationchangedlistener)
    {
        ((LocationSource)get()).activate(OnLocationChangedListenerImpl.create(onlocationchangedlistener));
    }

    public void deactivate()
    {
        ((LocationSource)get()).deactivate();
    }
}
