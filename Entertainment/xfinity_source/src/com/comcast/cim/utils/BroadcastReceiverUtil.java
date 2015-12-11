// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.utils;

import android.content.BroadcastReceiver;
import android.content.ContextWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BroadcastReceiverUtil
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/utils/BroadcastReceiverUtil);

    public BroadcastReceiverUtil()
    {
    }

    public static transient void unregisterBroadcastReceiversQuietly(ContextWrapper contextwrapper, BroadcastReceiver abroadcastreceiver[])
    {
        int j = abroadcastreceiver.length;
        int i = 0;
        while (i < j) 
        {
            BroadcastReceiver broadcastreceiver = abroadcastreceiver[i];
            if (broadcastreceiver != null)
            {
                try
                {
                    contextwrapper.unregisterReceiver(broadcastreceiver);
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    LOG.warn("Exception thrown while unregistering receiver, either it was not registered or registered with a different context");
                }
            }
            i++;
        }
    }

}
