// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.accounts.Account;

// Referenced classes of package com.amazon.mixtape.service:
//            MixtapeSyncService, AccountSync, StartIds

private class mStartId
    implements com.amazon.mixtape.concurrent.artId
{

    private final Account mAccount;
    private final String mAuthority;
    private final int mStartId;
    final MixtapeSyncService this$0;

    public Account getKey()
    {
        return mAccount;
    }

    public volatile Object getKey()
    {
        return getKey();
    }

    public void run()
    {
        MixtapeSyncService.access$000().onPerformSync(mAccount, mAuthority);
        MixtapeSyncService.access$100(MixtapeSyncService.this).remove(mStartId);
        return;
        Exception exception;
        exception;
        MixtapeSyncService.access$100(MixtapeSyncService.this).remove(mStartId);
        throw exception;
    }

    public (Account account, String s, int i)
    {
        this$0 = MixtapeSyncService.this;
        super();
        mAccount = account;
        mAuthority = s;
        mStartId = i;
    }
}
