// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            CommonInfoGetter

class this._cls0
    implements Runnable
{

    final CommonInfoGetter this$0;

    public void run()
    {
        CommonInfoGetter.access$000(CommonInfoGetter.this);
        CommonInfoGetter.access$100(CommonInfoGetter.this).countDown();
        return;
        Exception exception;
        exception;
        CommonInfoGetter.access$100(CommonInfoGetter.this).countDown();
        throw exception;
    }

    ()
    {
        this$0 = CommonInfoGetter.this;
        super();
    }
}
