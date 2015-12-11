// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.logging.LogManager;

// Referenced classes of package org.altbeacon.beacon.service:
//            RangedBeacon, Callback

public class RangeState
{

    private static final String TAG = "RangeState";
    private Callback mCallback;
    private Map mRangedBeacons;

    public RangeState(Callback callback)
    {
        mRangedBeacons = new HashMap();
        mCallback = callback;
    }

    public void addBeacon(Beacon beacon)
    {
        if (mRangedBeacons.containsKey(beacon))
        {
            RangedBeacon rangedbeacon = (RangedBeacon)mRangedBeacons.get(beacon);
            LogManager.d("RangeState", "adding %s to existing range for: %s", new Object[] {
                beacon, rangedbeacon
            });
            rangedbeacon.updateBeacon(beacon);
            return;
        } else
        {
            LogManager.d("RangeState", "adding %s to new rangedBeacon", new Object[] {
                beacon
            });
            mRangedBeacons.put(beacon, new RangedBeacon(beacon));
            return;
        }
    }

    public Collection finalizeBeacons()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1;
        ArrayList arraylist;
        obj1 = new HashMap();
        arraylist = new ArrayList();
        Object obj = mRangedBeacons;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = mRangedBeacons.keySet().iterator();
_L1:
        Beacon beacon;
        RangedBeacon rangedbeacon;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_177;
        }
        beacon = (Beacon)iterator.next();
        rangedbeacon = (RangedBeacon)mRangedBeacons.get(beacon);
        if (rangedbeacon.isTracked())
        {
            rangedbeacon.commitMeasurements();
            if (!rangedbeacon.noMeasurementsAvailable())
            {
                arraylist.add(rangedbeacon.getBeacon());
            }
        }
        boolean flag;
        if (!rangedbeacon.noMeasurementsAvailable())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        rangedbeacon.setTracked(false);
        ((Map) (obj1)).put(beacon, rangedbeacon);
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        LogManager.d("RangeState", "Dumping beacon from RangeState because it has no recent measurements.", new Object[0]);
          goto _L1
        mRangedBeacons = ((Map) (obj1));
        obj;
        JVM INSTR monitorexit ;
        this;
        JVM INSTR monitorexit ;
        return arraylist;
    }

    public Callback getCallback()
    {
        return mCallback;
    }
}
