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
import com.amazon.mixtape.utils.LazyWithParam;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.mixtape.account:
//            MetadataStore, CloudMetadataStore

public final class AccountContextFactory
{
    public static interface AccountContext
    {

        public abstract MetadataStore createMetadataStore(String s);

        public abstract String getAccountId();

        public abstract Account getSyncAccount(String s);

        public abstract SQLiteDatabase getWritableDatabase();

        public abstract void runInMetadataContext(MetadataTask metadatatask)
            throws CloudDriveException, MetadataSyncException, InterruptedException;
    }

    private static class AccountContextImpl
        implements AccountContext
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

        public void runInMetadataContext(MetadataTask metadatatask)
            throws CloudDriveException, MetadataSyncException, InterruptedException
        {
            ensureAccountIdRemembered();
            synchronized (mMetadataWriteLock)
            {
                metadatatask.run(getWritableDatabase());
            }
            return;
            metadatatask;
            obj;
            JVM INSTR monitorexit ;
            throw metadatatask;
        }

        public AccountContextImpl(Context context, String s)
        {
            mContext = context.getApplicationContext();
            mAccountId = s;
            mMixtapeDatabaseHelper = new MixtapeDatabaseHelper(mContext, mAccountId);
        }
    }

    public static class LazyAccountsDatabaseHelper extends LazyWithParam
    {

        protected AccountsDatabaseHelper instantiateItem(Context context)
        {
            return new AccountsDatabaseHelper(context.getApplicationContext());
        }

        protected volatile Object instantiateItem(Object obj)
        {
            return instantiateItem((Context)obj);
        }

        public LazyAccountsDatabaseHelper()
        {
        }
    }

    public static interface MetadataTask
    {

        public abstract void run(SQLiteDatabase sqlitedatabase)
            throws CloudDriveException, MetadataSyncException, InterruptedException;
    }


    public static final LazyAccountsDatabaseHelper ACCOUNTS_DATABASE_HELPER = new LazyAccountsDatabaseHelper();
    private static final Map ACCOUNT_CONTEXTS = new HashMap();

    public static AccountContext getContextForAccount(Context context, Account account)
    {
        Cursor cursor;
        Object obj = null;
        cursor = ((AccountsDatabaseHelper)ACCOUNTS_DATABASE_HELPER.get(context)).getWritableDatabase().query("accounts", null, "name = ? AND type = ?", new String[] {
            account.name, account.type
        }, null, null, null);
        account = obj;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_87;
        }
        account = getContextForAccountId(context, cursor.getString(cursor.getColumnIndexOrThrow("directed_id")));
        cursor.close();
        return account;
        cursor.close();
        return null;
        context;
        cursor.close();
        throw context;
    }

    public static AccountContext getContextForAccountId(Context context, String s)
    {
label0:
        {
            synchronized (ACCOUNT_CONTEXTS)
            {
                if (ACCOUNT_CONTEXTS.containsKey(s))
                {
                    break label0;
                }
                context = new AccountContextImpl(context, s);
                ACCOUNT_CONTEXTS.put(s, context);
            }
            return context;
        }
        context = (AccountContext)ACCOUNT_CONTEXTS.get(s);
        map;
        JVM INSTR monitorexit ;
        return context;
        context;
        map;
        JVM INSTR monitorexit ;
        throw context;
    }

}
