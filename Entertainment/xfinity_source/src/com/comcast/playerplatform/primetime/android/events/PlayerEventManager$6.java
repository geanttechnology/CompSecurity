// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.events;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.comcast.playerplatform.primetime.android.events:
//            PlayerEventManager, AbstractPlayerPlatformVideoEventListener

class val.description
    implements Runnable
{

    final PlayerEventManager this$0;
    final String val$description;
    final String val$errorCode;

    public void run()
    {
        List list = listeners;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).emergencyAlertFailed(val$errorCode, val$description)) { }
        break MISSING_BLOCK_LABEL_60;
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
        val$errorCode = s;
        val$description = String.this;
        super();
    }
}
