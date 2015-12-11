// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.control;

import org.cybergarage.upnp.ControlPoint;
import org.cybergarage.util.ThreadCore;

public class RenewSubscriber extends ThreadCore
{

    public static final long INTERVAL = 120L;
    private ControlPoint ctrlPoint;

    public RenewSubscriber(ControlPoint controlpoint)
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
        do
        {
            if (!isRunnable())
            {
                return;
            }
            try
            {
                Thread.sleep(0x1d4c0L);
            }
            catch (InterruptedException interruptedexception) { }
            controlpoint.renewSubscriberService();
        } while (true);
    }

    public void setControlPoint(ControlPoint controlpoint)
    {
        ctrlPoint = controlpoint;
    }
}
