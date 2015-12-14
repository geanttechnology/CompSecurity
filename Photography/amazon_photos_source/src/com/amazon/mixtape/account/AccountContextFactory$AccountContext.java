// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.account;

import android.accounts.Account;
import android.database.sqlite.SQLiteDatabase;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.mixtape.service.MetadataSyncException;

// Referenced classes of package com.amazon.mixtape.account:
//            AccountContextFactory, MetadataStore

public static interface 
{

    public abstract MetadataStore createMetadataStore(String s);

    public abstract String getAccountId();

    public abstract Account getSyncAccount(String s);

    public abstract SQLiteDatabase getWritableDatabase();

    public abstract void runInMetadataContext( )
        throws CloudDriveException, MetadataSyncException, InterruptedException;
}
