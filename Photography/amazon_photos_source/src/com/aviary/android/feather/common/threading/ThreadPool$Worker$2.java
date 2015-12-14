// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.threading;


// Referenced classes of package com.aviary.android.feather.common.threading:
//            ThreadPool, FutureListener, Future

class val.sender
    implements Runnable
{

    final val.sender this$1;
    final Future val$sender;

    public void run()
    {
        istener.onFutureDone(val$sender);
    }

    ()
    {
        this$1 = final_;
        val$sender = Future.this;
        super();
    }
}
