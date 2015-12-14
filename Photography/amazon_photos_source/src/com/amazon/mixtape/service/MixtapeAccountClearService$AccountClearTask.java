// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.accounts.Account;
import android.content.ContentResolver;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.mixtape.account.AccountContextFactory;
import com.amazon.mixtape.account.MetadataStore;
import java.io.IOException;

// Referenced classes of package com.amazon.mixtape.service:
//            MixtapeAccountClearService, MetadataSyncException, StartIds

private class mStartId
    implements com.amazon.mixtape.account.mStartId, com.amazon.mixtape.concurrent.artId
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
        com.amazon.mixtape.account.mAccount maccount;
        ContentResolver.cancelSync(mAccount, mAuthority);
        maccount = AccountContextFactory.getContextForAccount(getApplicationContext(), mAccount);
        if (maccount == null) goto _L2; else goto _L1
_L1:
        mMetadataStore = maccount.etadataStore(mAuthority);
        maccount.tadataContext(this);
_L4:
        MixtapeAccountClearService.access$100(MixtapeAccountClearService.this).remove(mStartId);
        return;
_L2:
        Log.i(MixtapeAccountClearService.access$000(), "Attempting to clear metadata for an account that has not mapped yet.");
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        Log.e(MixtapeAccountClearService.access$000(), "Failed to clear metadata for account.", ((Throwable) (obj)));
        MixtapeAccountClearService.access$100(MixtapeAccountClearService.this).remove(mStartId);
        return;
        obj;
        Log.e(MixtapeAccountClearService.access$000(), "Failed with a client exception. Not expected to be possible while clearing.", ((Throwable) (obj)));
        MixtapeAccountClearService.access$100(MixtapeAccountClearService.this).remove(mStartId);
        return;
        obj;
        Thread.currentThread().interrupt();
        MixtapeAccountClearService.access$100(MixtapeAccountClearService.this).remove(mStartId);
        return;
        obj;
        MixtapeAccountClearService.access$100(MixtapeAccountClearService.this).remove(mStartId);
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

    public (Account account, String s, int i)
    {
        this$0 = MixtapeAccountClearService.this;
        super();
        mAccount = account;
        mAuthority = s;
        mStartId = i;
    }
}
