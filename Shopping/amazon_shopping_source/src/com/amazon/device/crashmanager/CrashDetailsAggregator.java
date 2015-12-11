// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.device.crashmanager:
//            CrashDetailsCollectable

public class CrashDetailsAggregator
    implements CrashDetailsCollectable
{

    private static final String TAG = com/amazon/device/crashmanager/CrashDetailsAggregator.getName();
    private List collectors;

    public CrashDetailsAggregator()
    {
        collectors = new ArrayList();
    }

    public void appendCollector(CrashDetailsCollectable crashdetailscollectable)
    {
        collectors.add(crashdetailscollectable);
    }

    public Map collect(Throwable throwable)
    {
        HashMap hashmap = new HashMap();
        for (Iterator iterator = collectors.iterator(); iterator.hasNext();)
        {
            CrashDetailsCollectable crashdetailscollectable = (CrashDetailsCollectable)iterator.next();
            try
            {
                hashmap.putAll(crashdetailscollectable.collect(throwable));
            }
            catch (Exception exception)
            {
                Log.e(TAG, (new StringBuilder()).append("crash data collector: '").append(crashdetailscollectable.toString()).append("' threw exception: ").toString(), exception);
            }
        }

        return hashmap;
    }

}
