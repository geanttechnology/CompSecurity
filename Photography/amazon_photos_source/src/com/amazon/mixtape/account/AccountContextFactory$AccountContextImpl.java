// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.account;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.mixtape.database.AccountsDatabaseHelper;
import com.amazon.mixtape.database.MixtapeDatabaseHelper;
import com.amazon.mixtape.service.MetadataSyncException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.mixtape.account:
//            AccountContextFactory, CloudMetadataStore, MetadataStore

private static class mAccountId
    implements mAccountId
{

    private final String mAccountId;
    private final AtomicBoolean mAccountRemembered = new AtomicBoolean(false);
    private final Context mContext;
    private final Object mMetadataWriteLock = new Object();
    private final MixtapeDatabaseHelper mMixtapeDatabaseHelper;
    private final Object mSyncAccountCreateLock = new Object();

    private Account createSyncAccount(String s)
    {
        s = new Account(UUID.randomUUID().toString(), s);
        associateWithSyncAccount(s);
        return s;
    }

    private void ensureAccountIdRemembered()
    {
        if (mAccountRemembered.compareAndSet(false, true))
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("directed_id", mAccountId);
            ((AccountsDatabaseHelper)AccountContextFactory.ACCOUNTS_DATABASE_HELPER.get(mContext)).getWritableDatabase().insertWithOnConflict("accounts", null, contentvalues, 4);
        }
    }

    private Account queryForSyncAccount()
    {
        Account account;
        Cursor cursor;
        account = null;
        cursor = ((AccountsDatabaseHelper)AccountContextFactory.ACCOUNTS_DATABASE_HELPER.get(mContext)).getWritableDatabase().query("accounts", null, "directed_id = ?", new String[] {
            mAccountId
        }, null, null, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_110;
        }
        int i = cursor.getColumnIndexOrThrow("name");
        if (cursor.isNull(i))
        {
            break MISSING_BLOCK_LABEL_110;
        }
        account = new Account(cursor.getString(i), cursor.getString(cursor.getColumnIndexOrThrow("type")));
        cursor.close();
        return account;
        cursor.close();
        return null;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    public void associateWithSyncAccount(Account account)
    {
        synchronized (mSyncAccountCreateLock)
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("name", account.name);
            contentvalues.put("type", account.type);
            contentvalues.put("directed_id", mAccountId);
            ((AccountsDatabaseHelper)AccountContextFactory.ACCOUNTS_DATABASE_HELPER.get(mContext)).getWritableDatabase().replace("accounts", null, contentvalues);
        }
        return;
        account;
        obj;
        JVM INSTR monitorexit ;
        throw account;
    }

    public MetadataStore createMetadataStore(String s)
    {
        return new CloudMetadataStore(mContext, s, mAccountId, getWritableDatabase());
    }

    public String getAccountId()
    {
        return mAccountId;
    }

    public Account getSyncAccount(String s)
    {
        Object obj = mSyncAccountCreateLock;
        obj;
        JVM INSTR monitorenter ;
        Account account = queryForSyncAccount();
        if (account == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        obj;
        JVM INSTR monitorexit ;
        return account;
        s = createSyncAccount(s);
        obj;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public SQLiteDatabase getWritableDatabase()
    {
        ensureAccountIdRemembered();
        return mMixtapeDatabaseHelper.getWritableDatabase();
    }

    public void runInMetadataContext(e e)
        throws CloudDriveException, MetadataSyncException, InterruptedException
    {
        ensureAccountIdRemembered();
        synchronized (mMetadataWriteLock)
        {
            e.mMetadataWriteLock(getWritableDatabase());
        }
        return;
        e;
        obj;
        JVM INSTR monitorexit ;
        throw e;
    }

    public eHelper(Context context, String s)
    {
        mContext = context.getApplicationContext();
        mAccountId = s;
        mMixtapeDatabaseHelper = new MixtapeDatabaseHelper(mContext, mAccountId);
    }
}
