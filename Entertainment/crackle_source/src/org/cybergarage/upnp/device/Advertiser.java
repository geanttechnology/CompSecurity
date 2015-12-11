// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.device;

import org.cybergarage.upnp.Device;
import org.cybergarage.util.ThreadCore;

public class Advertiser extends ThreadCore
{

    private Device device;

    public Advertiser(Device device1)
    {
        setDevice(device1);
    }

    public Device getDevice()
    {
        return device;
    }

    public void run()
    {
        Device device1 = getDevice();
        long l = device1.getLeaseTime();
        do
        {
            if (!isRunnable())
            {
                return;
            }
            long l1 = l / 4L;
            long l2 = (long)((double)(float)l * (Math.random() * 0.25D));
            try
            {
                Thread.sleep((l1 + l2) * 1000L);
            }
            catch (InterruptedException interruptedexception) { }
            device1.announce();
        } while (true);
    }

    public void setDevice(Device device1)
    {
        device = device1;
    }
}
