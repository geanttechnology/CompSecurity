// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import java.util.Date;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DistributedDataStorage, RemoteAmazonDataStorage, LocalDataStorage, AccountTransaction

class val.timestamp
    implements moteDataStorageAction
{

    final DistributedDataStorage this$0;
    final AccountTransaction val$accountData;
    final String val$displayName;
    final Date val$timestamp;

    public String getName()
    {
        return "AddAccount";
    }

    public boolean performAction(RemoteAmazonDataStorage remoteamazondatastorage)
    {
        return remoteamazondatastorage.addAccount(val$displayName, val$accountData, val$timestamp);
    }

    public void setActionPerformed()
    {
        DistributedDataStorage.access$000(DistributedDataStorage.this).setNotDirtyAddAccount(val$accountData, val$timestamp);
    }

    moteDataStorageAction()
    {
        this$0 = final_distributeddatastorage;
        val$displayName = s;
        val$accountData = accounttransaction;
        val$timestamp = Date.this;
        super();
    }
}
