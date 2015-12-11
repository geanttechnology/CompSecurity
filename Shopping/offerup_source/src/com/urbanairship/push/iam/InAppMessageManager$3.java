// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessageManager, InAppMessage

class val.message
    implements Runnable
{

    final InAppMessageManager this$0;
    final InAppMessage val$message;

    public void run()
    {
        List list = InAppMessageManager.access$200(InAppMessageManager.this);
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = InAppMessageManager.access$200(InAppMessageManager.this).iterator(); iterator.hasNext(); ((stener)iterator.next()).onPendingMessageAvailable(val$message)) { }
        break MISSING_BLOCK_LABEL_58;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    stener()
    {
        this$0 = final_inappmessagemanager;
        val$message = InAppMessage.this;
        super();
    }
}
