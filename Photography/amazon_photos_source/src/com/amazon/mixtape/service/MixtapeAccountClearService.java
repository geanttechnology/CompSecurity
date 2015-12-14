// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.accounts.Account;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.util.Log;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.mixtape.account.AccountContextFactory;
import com.amazon.mixtape.account.MetadataStore;
import com.amazon.mixtape.concurrent.KeyedThreads;
import java.io.IOException;

// Referenced classes of package com.amazon.mixtape.service:
//            StartIds, MetadataSyncException

public class MixtapeAccountClearService extends Service
{
    private class AccountClearTask
        implements com.amazon.mixtape.account.AccountContextFactory.MetadataTask, com.amazon.mixtape.concurrent.KeyedThreads.KeyedTask
    {

        private final Account mAccount;
        private final String mAuthority;
        private MetadataStore mMetadataStore;
        private final int mStartId;
        final MixtapeAccountClearService this$0;

        public volatile Object getKey()
        {
            return getKey();
        }

        public String getKey()
        {
            return mAccount.name;
        }

        public void run()
        {
            com.amazon.mixtape.account.AccountContextFactory.AccountContext accountcontext;
            ContentResolver.cancelSync(mAccount, mAuthority);
            accountcontext = AccountContextFactory.getContextForAccount(getApplicationContext(), mAccount);
            if (accountcontext == null) goto _L2; else goto _L1
_L1:
            mMetadataStore = accountcontext.createMetadataStore(mAuthority);
            accountcontext.runInMetadataContext(this);
_L4:
            mStartIds.remove(mStartId);
            return;
_L2:
            Log.i(MixtapeAccountClearService.TAG, "Attempting to clear metadata for an account that has not mapped yet.");
            if (true) goto _L4; else goto _L3
_L3:
            Object obj;
            obj;
            Log.e(MixtapeAccountClearService.TAG, "Failed to clear metadata for account.", ((Throwable) (obj)));
            mStartIds.remove(mStartId);
            return;
            obj;
            Log.e(MixtapeAccountClearService.TAG, "Failed with a client exception. Not expected to be possible while clearing.", ((Throwable) (obj)));
            mStartIds.remove(mStartId);
            return;
            obj;
            Thread.currentThread().interrupt();
            mStartIds.remove(mStartId);
            return;
            obj;
            mStartIds.remove(mStartId);
            throw obj;
        }

        public void run(SQLiteDatabase sqlitedatabase)
            throws CloudDriveException, MetadataSyncException, InterruptedException
        {
            mMetadataStore.clearStore();
            try
            {
                mMetadataStore.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                return;
            }
            sqlitedatabase;
            try
            {
                mMetadataStore.close();
            }
            catch (IOException ioexception) { }
            throw sqlitedatabase;
        }

        public AccountClearTask(Account account, String s, int i)
        {
            this$0 = MixtapeAccountClearService.this;
            super();
            mAccount = account;
            mAuthority = s;
            mStartId = i;
        }
    }


    private static final KeyedThreads ACCOUNT_CLEAR_THREADS = new KeyedThreads("AccountClearWorker");
    private static final String TAG = com/amazon/mixtape/service/MixtapeAccountClearService.getSimpleName();
    private StartIds mStartIds;

    public MixtapeAccountClearService()
    {
    }

    private boolean handleClearAccountAction(Intent intent, int i)
    {
        String s = intent.getStringExtra("account_name");
        String s1 = intent.getStringExtra("account_type");
        intent = intent.getStringExtra("authority");
        intent = new AccountClearTask(new Account(s, s1), intent, i);
        return ACCOUNT_CLEAR_THREADS.startThread(intent);
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        mStartIds = new StartIds(this);
    }

    public void onDestroy()
    {
        super.onDestroy();
        ACCOUNT_CLEAR_THREADS.cancelAllThreads();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        mStartIds.add(j);
        boolean flag1 = false;
        boolean flag = flag1;
        if (intent != null)
        {
            flag = flag1;
            if ("com.amazon.mixtape.account.clear".equals(intent.getAction()))
            {
                flag = handleClearAccountAction(intent, j);
            }
        }
        if (!flag)
        {
            mStartIds.remove(j);
        }
        return 1;
    }



}
