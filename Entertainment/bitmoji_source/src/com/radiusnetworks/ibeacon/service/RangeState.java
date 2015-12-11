// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.util.Log;
import com.radiusnetworks.ibeacon.IBeacon;
import com.radiusnetworks.ibeacon.IBeaconManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.radiusnetworks.ibeacon.service:
//            RangedIBeacon, Callback

public class RangeState
{

    private static final String TAG = "RangeState";
    private Callback callback;
    private Map rangedIBeacons;

    public RangeState(Callback callback1)
    {
        rangedIBeacons = new HashMap();
        callback = callback1;
    }

    public void addIBeacon(IBeacon ibeacon)
    {
        if (rangedIBeacons.containsKey(ibeacon))
        {
            RangedIBeacon rangedibeacon = (RangedIBeacon)rangedIBeacons.get(ibeacon);
            if (IBeaconManager.debug)
            {
                Log.d("RangeState", (new StringBuilder()).append("adding ").append(ibeacon.getProximityUuid()).append(" to existing range for: ").append(rangedibeacon.getProximityUuid()).toString());
            }
            rangedibeacon.addRangeMeasurement(Integer.valueOf(ibeacon.getRssi()));
            return;
        }
        if (IBeaconManager.debug)
        {
            Log.d("RangeState", (new StringBuilder()).append("adding ").append(ibeacon.getProximityUuid()).append(" to new rangedIBeacon").toString());
        }
        rangedIBeacons.put(ibeacon, new RangedIBeacon(ibeacon));
    }

    public Collection finalizeIBeacons()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1;
        HashMap hashmap;
        obj1 = new ArrayList();
        hashmap = new HashMap();
        Object obj = rangedIBeacons;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = rangedIBeacons.keySet().iterator();
_L3:
        IBeacon ibeacon;
        RangedIBeacon rangedibeacon;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_169;
        }
        ibeacon = (IBeacon)iterator.next();
        rangedibeacon = (RangedIBeacon)rangedIBeacons.get(ibeacon);
        if (rangedibeacon.isTracked())
        {
            rangedibeacon.commitMeasurements();
            ((ArrayList) (obj1)).add(rangedibeacon);
        }
        boolean flag;
        if (!rangedibeacon.noMeasurementsAvailable())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        rangedibeacon.setTracked(false);
        hashmap.put(ibeacon, rangedibeacon);
          goto _L3
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L2:
        if (!IBeaconManager.debug) goto _L3; else goto _L4
_L4:
        Log.d("RangeState", "Dumping iBeacon from RangeState because it has no recent measurements.");
          goto _L3
        rangedIBeacons = hashmap;
        obj;
        JVM INSTR monitorexit ;
        this;
        JVM INSTR monitorexit ;
        return ((Collection) (obj1));
    }

    public Callback getCallback()
    {
        return callback;
    }
}
