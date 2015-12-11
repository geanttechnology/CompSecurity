// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.events;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.comcast.playerplatform.primetime.android.events:
//            PlayerEventManager, AbstractPlayerPlatformVideoEventListener

class val.updateInterval
    implements Runnable
{

    final PlayerEventManager this$0;
    final long val$endPosition;
    final double val$playbackSpeed;
    final long val$position;
    final long val$startPosition;
    final int val$updateInterval;

    public void run()
    {
        List list = listeners;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).mediaProgress(val$position, val$playbackSpeed, val$startPosition, val$endPosition, val$updateInterval)) { }
        break MISSING_BLOCK_LABEL_72;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    VideoEventListener()
    {
        this$0 = final_playereventmanager;
        val$position = l;
        val$playbackSpeed = d;
        val$startPosition = l1;
        val$endPosition = l2;
        val$updateInterval = I.this;
        super();
    }
}
