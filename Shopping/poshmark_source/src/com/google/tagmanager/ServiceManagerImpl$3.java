// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            ServiceManagerImpl, HitStore

class this._cls0
    implements Runnable
{

    final ServiceManagerImpl this$0;

    public void run()
    {
        ServiceManagerImpl.access$500(ServiceManagerImpl.this).dispatch();
    }

    ()
    {
        this$0 = ServiceManagerImpl.this;
        super();
    }
}
