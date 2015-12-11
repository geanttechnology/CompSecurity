// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.api;


// Referenced classes of package com.fanhattan.services.api:
//            BaseServiceBinder

class this._cls1
    implements Runnable
{

    private boolean finish;
    final this._cls1 this$1;

    public void finish()
    {
        finish = true;
    }

    public void run()
    {
        int i;
        boolean flag;
        i = 0;
        flag = false;
_L2:
        int j;
        boolean flag1;
        if (finish || flag || i >= 10)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i + 1;
        flag1 = finish(this._cls1.this);
        i = j;
        flag = flag1;
        if (flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        Thread.sleep(1000L);
        i = j;
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        InterruptedException interruptedexception;
        interruptedexception;
        i = j;
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
