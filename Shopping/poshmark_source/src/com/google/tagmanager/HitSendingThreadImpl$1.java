// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            HitSendingThreadImpl, ServiceManagerImpl, HitStore, HitSendingThread

class val.url
    implements Runnable
{

    final HitSendingThreadImpl this$0;
    final long val$hitTime;
    final HitSendingThread val$thread;
    final String val$url;

    public void run()
    {
        if (HitSendingThreadImpl.access$000(HitSendingThreadImpl.this) == null)
        {
            ServiceManagerImpl servicemanagerimpl = ServiceManagerImpl.getInstance();
            servicemanagerimpl.initialize(HitSendingThreadImpl.access$100(HitSendingThreadImpl.this), val$thread);
            HitSendingThreadImpl.access$002(HitSendingThreadImpl.this, servicemanagerimpl.getStore());
        }
        HitSendingThreadImpl.access$000(HitSendingThreadImpl.this).putHit(val$hitTime, val$url);
    }

    ()
    {
        this$0 = final_hitsendingthreadimpl;
        val$thread = hitsendingthread;
        val$hitTime = l;
        val$url = String.this;
        super();
    }
}
