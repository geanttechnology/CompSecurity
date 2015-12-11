// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import java.util.concurrent.Executor;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            FeedsServerCom

private class <init>
    implements Executor
{

    final FeedsServerCom this$0;

    public void execute(Runnable runnable)
    {
        (new Thread(runnable)).start();
    }

    private ()
    {
        this$0 = FeedsServerCom.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
