// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable;

import android.util.Log;
import com.amazon.device.crashmanager.CrashDetailsCollectable;
import com.google.android.gms.wearable.DataMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WearableCrashDetails
    implements CrashDetailsCollectable
{
    private static class SingletonHolder
    {

        private static final WearableCrashDetails INSTANCE = new WearableCrashDetails();



        private SingletonHolder()
        {
        }
    }


    private static final String TAG = com/amazon/mShop/wearable/WearableCrashDetails.getSimpleName();
    private Map mCrashDetails;

    public WearableCrashDetails()
    {
        mCrashDetails = new HashMap();
    }

    private Map getCrashDetails()
    {
        this;
        JVM INSTR monitorenter ;
        Map map = mCrashDetails;
        this;
        JVM INSTR monitorexit ;
        return map;
        Exception exception;
        exception;
        throw exception;
    }

    public static WearableCrashDetails getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    private void setCrashDetails(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_11;
        }
        mCrashDetails = map;
        this;
        JVM INSTR monitorexit ;
        return;
        map;
        throw map;
    }

    public Map collect(Throwable throwable)
    {
        try
        {
            throwable = getCrashDetails();
            setCrashDetails(new HashMap());
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            Log.e(TAG, "Error", throwable);
            return new HashMap();
        }
        return throwable;
    }

    public void setCrashDetails(DataMap datamap)
    {
        HashMap hashmap;
        String s;
        String s1;
        Iterator iterator;
        String s2;
        try
        {
            hashmap = new HashMap();
        }
        // Misplaced declaration of an exception variable
        catch (DataMap datamap)
        {
            Log.e(TAG, "Error", datamap);
            return;
        }
        if (datamap == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        iterator = datamap.keySet().iterator();
_L1:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        s2 = (String)iterator.next();
        s1 = datamap.getString(s2);
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        hashmap.put(s2, s);
          goto _L1
        setCrashDetails(((Map) (hashmap)));
        return;
    }

}
