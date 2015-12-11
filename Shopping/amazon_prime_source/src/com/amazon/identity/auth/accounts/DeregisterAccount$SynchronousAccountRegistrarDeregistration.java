// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.callback.AsyncToSyncAdapter;
import com.amazon.identity.auth.device.credentials.AccountCredentials;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.metrics.SSOMetrics;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            DeregisterAccount, AccountRegistrar, AccountRegistrarAuthenticator

private static class mTracer extends AsyncToSyncAdapter
    implements mTracer
{

    private final AccountCredentials mAccountCredentials;
    private final Context mContext;
    private final boolean mDeregisterAllAccounts;
    private final String mDirectedId;
    private final AccountRegistrar mRegistrar;
    private final AccountRegistrarAuthenticator mRegistrarAuthenticator;
    private AtomicBoolean mSuccess;
    private final Tracer mTracer;

    public void accountAlreadyExists(String s)
    {
        failure(com.amazon.identity.auth.device.api.ilure, null);
    }

    public void failure(com.amazon.identity.auth.device.api.ilure ilure, Bundle bundle)
    {
        DeregisterAccount.access$000();
        SSOMetrics.deregistrationRequestFailure(ilure);
        setSuccess(false);
        asyncOperationComplete();
    }

    public boolean getSuccess()
    {
        return mSuccess.get();
    }

    public void setSuccess(boolean flag)
    {
        mSuccess.set(flag);
    }

    protected void startAsyncOperation()
    {
        mRegistrar.deregister(this, mContext.getPackageName(), mDirectedId, mAccountCredentials, mDeregisterAllAccounts, mRegistrarAuthenticator, mTracer);
    }

    public void success(String s, String s1, Bundle bundle)
    {
        DeregisterAccount.access$000();
        setSuccess(true);
        asyncOperationComplete();
    }

    public (Context context, String s, boolean flag, AccountRegistrar accountregistrar, AccountRegistrarAuthenticator accountregistrarauthenticator, AccountCredentials accountcredentials, Tracer tracer)
    {
        mSuccess = new AtomicBoolean(false);
        mContext = context;
        mDirectedId = s;
        mDeregisterAllAccounts = flag;
        mRegistrar = accountregistrar;
        mRegistrarAuthenticator = accountregistrarauthenticator;
        mAccountCredentials = accountcredentials;
        mTracer = tracer;
    }
}
