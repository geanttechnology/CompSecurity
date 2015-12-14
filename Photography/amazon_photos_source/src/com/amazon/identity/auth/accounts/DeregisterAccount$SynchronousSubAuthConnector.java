// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.callback.AsyncToSyncAdapter;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            DeregisterAccount, SubAuthenticatorConnection

private static class mConnection extends AsyncToSyncAdapter
    implements nnectionCallback
{

    private AtomicBoolean mConnected;
    private final SubAuthenticatorConnection mConnection;

    private void setConnected(boolean flag)
    {
        mConnected.set(flag);
    }

    public boolean getConnected()
    {
        return mConnected.get();
    }

    public SubAuthenticatorConnection getConnection()
    {
        return mConnection;
    }

    public void onConnected$33345943()
    {
        setConnected(true);
        asyncOperationComplete();
    }

    public void onConnectionTimeout(SubAuthenticatorConnection subauthenticatorconnection)
    {
        MAPLog.e(DeregisterAccount.access$000(), (new StringBuilder("SubAuth Connection timeout: ")).append(subauthenticatorconnection.getPackageName()).toString());
        setConnected(false);
        asyncOperationComplete();
    }

    public void onDisconnected(SubAuthenticatorConnection subauthenticatorconnection)
    {
        MAPLog.i(DeregisterAccount.access$000(), (new StringBuilder("SubAuth Disconnected: ")).append(subauthenticatorconnection.getPackageName()).toString());
        setConnected(false);
    }

    protected void startAsyncOperation()
    {
        if (!mConnection.openConnection(this))
        {
            MAPLog.e(DeregisterAccount.access$000(), (new StringBuilder("Error binding to service: ")).append(mConnection.getPackageName()).toString());
            setConnected(false);
            asyncOperationComplete();
        }
    }

    public nnectionCallback(SubAuthenticatorConnection subauthenticatorconnection)
    {
        mConnected = new AtomicBoolean(false);
        mConnection = subauthenticatorconnection;
    }
}
