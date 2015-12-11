// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;


// Referenced classes of package com.urbanairship.push.iam:
//            Timer

class this._cls0
    implements Runnable
{

    final Timer this$0;

    public void run()
    {
        if (Timer.access$000(Timer.this))
        {
            stop();
            onFinish();
        }
    }

    ()
    {
        this$0 = Timer.this;
        super();
    }
}
