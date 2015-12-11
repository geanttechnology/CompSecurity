// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.pointinside.maps.model.CameraPosition;
import com.pointinside.model.Zone;
import com.sun.jna.ptr.IntByReference;

// Referenced classes of package com.pointinside.maps:
//            EventTypeHandler, PIMap

class SetCameraEventTypeHandler extends EventTypeHandler
{

    private final Zone mPreviousZone;
    private final boolean mShowZoneSelector;

    protected SetCameraEventTypeHandler(PIMap pimap, CameraPosition cameraposition, boolean flag)
    {
        super(pimap);
        if (cameraposition == null)
        {
            pimap = null;
        } else
        {
            pimap = cameraposition.zone;
        }
        mPreviousZone = pimap;
        mShowZoneSelector = flag;
    }

    public void execute()
    {
    }

    public void execute(IntByReference intbyreference)
    {
        if (mShowZoneSelector)
        {
            map.showZoneSelectorInternal(mPreviousZone, true, false);
        } else
        {
            map.showZoneOnMap(intbyreference);
        }
        map.sendMapAnalytics();
    }
}
