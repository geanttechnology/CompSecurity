// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import java.util.Date;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DistributedDataStorage, RemoteAmazonDataStorage, LocalDataStorage

class val.timestamp
    implements moteDataStorageAction
{

    final DistributedDataStorage this$0;
    final String val$key;
    final String val$namespace;
    final Date val$timestamp;
    final String val$value;

    public String getName()
    {
        return "SetDeviceData";
    }

    public boolean performAction(RemoteAmazonDataStorage remoteamazondatastorage)
    {
        return remoteamazondatastorage.setDeviceData(val$namespace, val$key, val$value, val$timestamp);
    }

    public void setActionPerformed()
    {
        DistributedDataStorage.access$000(DistributedDataStorage.this).setNotDirtySetDeviceData(val$namespace, val$key, val$timestamp);
    }

    moteDataStorageAction()
    {
        this$0 = final_distributeddatastorage;
        val$namespace = s;
        val$key = s1;
        val$value = s2;
        val$timestamp = Date.this;
        super();
    }
}
