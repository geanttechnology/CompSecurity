// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils, AndroidTargetUtils

class val.params
    implements Runnable
{

    final val.params this$0;
    final Object val$params[];
    final ask val$task;

    public void run()
    {
        AndroidTargetUtils.executeAsyncTask(val$task, val$params);
    }

    ask()
    {
        this$0 = final_ask;
        val$task = ask1;
        val$params = _5B_Ljava.lang.Object_3B_.this;
        super();
    }
}
