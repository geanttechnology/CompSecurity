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
    final String val$directedId;
    final String val$key;
    final Date val$timestamp;
    final String val$token;

    public String getName()
    {
        return "SetToken";
    }

    public boolean performAction(RemoteAmazonDataStorage remoteamazondatastorage)
    {
        return remoteamazondatastorage.setToken(val$directedId, val$key, val$token, val$timestamp);
    }

    public void setActionPerformed()
    {
        DistributedDataStorage.access$000(DistributedDataStorage.this).setNotDirtySetToken(val$directedId, val$key, val$timestamp);
    }

    moteDataStorageAction()
    {
        this$0 = final_distributeddatastorage;
        val$directedId = s;
        val$key = s1;
        val$token = s2;
        val$timestamp = Date.this;
        super();
    }
}
