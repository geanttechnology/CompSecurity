// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.poshmark.notifications:
//            SynchronousBroadcastListener

public class SynchronousBroadcastManager
{

    static Map listeners = new HashMap();
    static SynchronousBroadcastManager syncBroadcastManager = null;

    public SynchronousBroadcastManager()
    {
    }

    public static SynchronousBroadcastManager getSyncronousBroadcastManager()
    {
        if (syncBroadcastManager == null)
        {
            syncBroadcastManager = new SynchronousBroadcastManager();
        }
        return syncBroadcastManager;
    }

    public void registerSynchronousBroadcastListener(String s, SynchronousBroadcastListener synchronousbroadcastlistener)
    {
        if (listeners.containsKey(s))
        {
            s = (ArrayList)listeners.get(s);
            if (s != null && !s.contains(synchronousbroadcastlistener))
            {
                s.add(synchronousbroadcastlistener);
            }
            return;
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(synchronousbroadcastlistener);
            listeners.put(s, arraylist);
            return;
        }
    }

    public void sendSynchronousBroadcast(String s, Object obj)
    {
        if (listeners.containsKey(s))
        {
            ArrayList arraylist = (ArrayList)listeners.get(s);
            int j = arraylist.size();
            for (int i = 0; i < j; i++)
            {
                SynchronousBroadcastListener synchronousbroadcastlistener = (SynchronousBroadcastListener)arraylist.get(i);
                if (synchronousbroadcastlistener != null)
                {
                    synchronousbroadcastlistener.handleSynchronousBroadcastMsg(s, obj);
                }
            }

        }
    }

    public void unregisterSynchronousBroadcastListener(String s, SynchronousBroadcastListener synchronousbroadcastlistener)
    {
        if (listeners.containsKey(s))
        {
            s = (ArrayList)listeners.get(s);
            if (s != null && !s.contains(synchronousbroadcastlistener))
            {
                s.remove(synchronousbroadcastlistener);
            }
        }
    }

}
