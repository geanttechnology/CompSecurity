// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;


// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DistributedDataStorage

class nCallback
    implements Runnable
{

    final DistributedDataStorage this$0;
    final oteDataStorageAction val$action;
    final nCallback val$callback;

    public void run()
    {
        DistributedDataStorage.access$100(DistributedDataStorage.this, val$action);
        if (val$callback != null)
        {
            val$callback.onSuccess();
        }
    }

    nCallback()
    {
        this$0 = final_distributeddatastorage;
        val$action = otedatastorageaction;
        val$callback = nCallback.this;
        super();
    }
}
