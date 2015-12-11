// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.events;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.comcast.playerplatform.primetime.android.events:
//            PlayerEventManager, AbstractPlayerPlatformVideoEventListener

class val.videoWidth
    implements Runnable
{

    final PlayerEventManager this$0;
    final long val$bitrate;
    final String val$changeReason;
    final long val$videoHeight;
    final long val$videoWidth;

    public void run()
    {
        List list = listeners;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).bitrateChanged(val$bitrate, val$changeReason, val$videoHeight, val$videoWidth)) { }
        break MISSING_BLOCK_LABEL_68;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    mVideoEventListener()
    {
        this$0 = final_playereventmanager;
        val$bitrate = l;
        val$changeReason = s;
        val$videoHeight = l1;
        val$videoWidth = J.this;
        super();
    }
}
