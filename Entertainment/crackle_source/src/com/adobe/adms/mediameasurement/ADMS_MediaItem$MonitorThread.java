// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.mediameasurement;

import android.util.Log;

// Referenced classes of package com.adobe.adms.mediameasurement:
//            ADMS_MediaItem, ADMS_MediaMeasurement

private static class <init> extends Thread
{

    public boolean canceled;
    long delay;
    public ADMS_MediaItem monitorMediaItem;

    public void run()
    {
        try
        {
            while (!canceled) 
            {
                if (monitorMediaItem.lastEventType == 1)
                {
                    monitorMediaItem.m.playerEvent(monitorMediaItem.name, 3, -1D, 0, null, -1D, null);
                }
                Thread.sleep(delay);
            }
        }
        catch (InterruptedException interruptedexception)
        {
            Log.d("ADMS_MediaMeasurement", (new StringBuilder()).append("AppMeasurement Error : Background Thread Interrupted : ").append(interruptedexception.getMessage()).toString());
        }
    }

    private ()
    {
        delay = 1000L;
        canceled = false;
    }

    canceled(canceled canceled1)
    {
        this();
    }
}
