// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import java.util.Collection;
import java.util.Date;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DistributedDataStorage, RemoteAmazonDataStorage, LocalDataStorage

class val.timestamp
    implements moteDataStorageAction
{

    final DistributedDataStorage this$0;
    final Collection val$allCurrentDirtyData;
    final Date val$timestamp;

    public String getName()
    {
        return "SetBulkData";
    }

    public boolean performAction(RemoteAmazonDataStorage remoteamazondatastorage)
    {
        return remoteamazondatastorage.setBulkData(val$allCurrentDirtyData);
    }

    public void setActionPerformed()
    {
        DistributedDataStorage.access$000(DistributedDataStorage.this).setAllBeforeTimeNotDirty(val$timestamp);
    }

    moteDataStorageAction()
    {
        this$0 = final_distributeddatastorage;
        val$allCurrentDirtyData = collection;
        val$timestamp = Date.this;
        super();
    }
}
