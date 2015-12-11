// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            Q

class it>
    implements Runnable
{

    final Q this$0;
    final String val$finishedError;
    final Runnable val$tmp;

    public void run()
    {
        if (Q.access$400(Q.this))
        {
            throw new InternalError(val$finishedError);
        } else
        {
            val$tmp.run();
            return;
        }
    }

    ror()
    {
        this$0 = final_q;
        val$finishedError = s;
        val$tmp = Runnable.this;
        super();
    }
}
