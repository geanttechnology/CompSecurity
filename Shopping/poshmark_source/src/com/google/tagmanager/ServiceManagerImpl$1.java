// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            HitStoreStateListener, ServiceManagerImpl

class this._cls0
    implements HitStoreStateListener
{

    final ServiceManagerImpl this$0;

    public void reportStoreIsEmpty(boolean flag)
    {
        updatePowerSaveMode(flag, ServiceManagerImpl.access$000(ServiceManagerImpl.this));
    }

    ()
    {
        this$0 = ServiceManagerImpl.this;
        super();
    }
}
