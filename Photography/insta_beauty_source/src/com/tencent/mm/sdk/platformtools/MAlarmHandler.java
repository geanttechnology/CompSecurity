// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Util, Log

public class MAlarmHandler
{

    public static final long NEXT_FIRE_INTERVAL = 0x7fffffffffffffffL;
    private static Map aA = new HashMap();
    private static IBumper aC;
    private static boolean aD = false;
    private static int av;
    private final CallBack aB;
    private final int aw;
    private final boolean ax;
    private long ay;
    private long az;

    public MAlarmHandler(CallBack callback, boolean flag)
    {
        ay = 0L;
        az = 0L;
        Assert.assertTrue("bumper not initialized", aD);
        aB = callback;
        ax = flag;
        if (av >= 8192)
        {
            av = 0;
        }
        int i = av + 1;
        av = i;
        aw = i;
    }

    public static long fire()
    {
        LinkedList linkedlist = new LinkedList();
        Object obj = new HashSet();
        ((Set) (obj)).addAll(aA.keySet());
        obj = ((Set) (obj)).iterator();
        long l = 0x7fffffffffffffffL;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Integer integer = (Integer)((Iterator) (obj)).next();
            MAlarmHandler malarmhandler = (MAlarmHandler)aA.get(integer);
            if (malarmhandler != null)
            {
                long l2 = Util.ticksToNow(malarmhandler.ay);
                long l1 = l2;
                if (l2 < 0L)
                {
                    l1 = 0L;
                }
                if (l1 > malarmhandler.az)
                {
                    if (!malarmhandler.aB.onTimerExpired() || !malarmhandler.ax)
                    {
                        linkedlist.add(integer);
                    } else
                    {
                        l = malarmhandler.az;
                    }
                    malarmhandler.ay = Util.currentTicks();
                } else
                if (malarmhandler.az - l1 < l)
                {
                    l = malarmhandler.az - l1;
                }
            }
        } while (true);
        for (int i = 0; i < linkedlist.size(); i++)
        {
            aA.remove(linkedlist.get(i));
        }

        if (l == 0x7fffffffffffffffL && aC != null)
        {
            aC.cancel();
            Log.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
        }
        return l;
    }

    public static void initAlarmBumper(IBumper ibumper)
    {
        aD = true;
        aC = ibumper;
    }

    protected void finalize()
    {
        stopTimer();
        super.finalize();
    }

    public void startTimer(long l)
    {
        az = l;
        ay = Util.currentTicks();
        long l3 = az;
        Log.d("MicroMsg.MAlarmHandler", (new StringBuilder("check need prepare: check=")).append(l3).toString());
        Iterator iterator = aA.entrySet().iterator();
        l = 0x7fffffffffffffffL;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            MAlarmHandler malarmhandler = (MAlarmHandler)((java.util.Map.Entry)iterator.next()).getValue();
            if (malarmhandler != null)
            {
                long l2 = Util.ticksToNow(malarmhandler.ay);
                long l1 = l2;
                if (l2 < 0L)
                {
                    l1 = 0L;
                }
                if (l1 > malarmhandler.az)
                {
                    l = malarmhandler.az;
                } else
                if (malarmhandler.az - l1 < l)
                {
                    l = malarmhandler.az - l1;
                }
            }
        } while (true);
        boolean flag;
        if (l > l3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        stopTimer();
        aA.put(Integer.valueOf(aw), this);
        if (aC != null && flag)
        {
            Log.v("MicroMsg.MAlarmHandler", "prepare bumper");
            aC.prepare();
        }
    }

    public void stopTimer()
    {
        aA.remove(Integer.valueOf(aw));
    }

    public boolean stopped()
    {
        return !aA.containsKey(Integer.valueOf(aw));
    }


    private class CallBack
    {

        public abstract boolean onTimerExpired();
    }


    private class IBumper
    {

        public abstract void cancel();

        public abstract void prepare();
    }

}
