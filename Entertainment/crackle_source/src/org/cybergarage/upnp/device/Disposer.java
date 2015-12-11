// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.device;

import org.cybergarage.upnp.ControlPoint;
import org.cybergarage.util.ThreadCore;

public class Disposer extends ThreadCore
{

    private ControlPoint ctrlPoint;

    public Disposer(ControlPoint controlpoint)
    {
        setControlPoint(controlpoint);
    }

    public ControlPoint getControlPoint()
    {
        return ctrlPoint;
    }

    public void run()
    {
        ControlPoint controlpoint = getControlPoint();
        long l = controlpoint.getExpiredDeviceMonitoringInterval();
        do
        {
            if (!isRunnable())
            {
                return;
            }
            try
            {
                Thread.sleep(l * 1000L);
            }
            catch (InterruptedException interruptedexception) { }
            controlpoint.removeExpiredDevices();
        } while (true);
    }

    public void setControlPoint(ControlPoint controlpoint)
    {
        ctrlPoint = controlpoint;
    }
}
