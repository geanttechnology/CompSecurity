// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;


// Referenced classes of package com.urbanairship.actions:
//            ActionCompletionCallback, ActionResult

class val.result
    implements Runnable
{

    final val.result this$1;
    final ActionResult val$result;

    public void run()
    {
        callback.onFinish(arguments, val$result);
    }

    ack()
    {
        this$1 = final_ack;
        val$result = ActionResult.this;
        super();
    }
}
