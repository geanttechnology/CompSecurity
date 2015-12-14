// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;

// Referenced classes of package com.amazon.mixtape.service:
//            AccountSync

public class MixtapeSyncAdapter extends AbstractThreadedSyncAdapter
{

    private final AccountSync mAccountSync;

    private MixtapeSyncAdapter(Context context, AccountSync accountsync)
    {
        super(context, true);
        mAccountSync = accountsync;
    }

    private MixtapeSyncAdapter(Context context, AccountSync accountsync, boolean flag)
    {
        super(context, true, flag);
        mAccountSync = accountsync;
    }

    public static MixtapeSyncAdapter createInstance(Context context, AccountSync accountsync)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return new MixtapeSyncAdapter(context, accountsync, true);
        } else
        {
            return new MixtapeSyncAdapter(context, accountsync);
        }
    }

    public void onPerformSync(Account account, Bundle bundle, String s, ContentProviderClient contentproviderclient, SyncResult syncresult)
    {
        mAccountSync.onPerformSync(account, s);
    }
}
