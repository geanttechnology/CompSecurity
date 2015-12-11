// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;


// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DistributedDataStorage

class onCallback
    implements Runnable
{

    final DistributedDataStorage this$0;
    final moteDataStorageAction val$action;
    final onCallback val$callback;

    public void run()
    {
        DistributedDataStorage.access$100(DistributedDataStorage.this, val$action);
        if (val$callback != null)
        {
            val$callback.onSuccess();
        }
    }

    onCallback()
    {
        this$0 = final_distributeddatastorage;
        val$action = motedatastorageaction;
        val$callback = onCallback.this;
        super();
    }
}
