// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.RemoteException;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            SubAuthChildApplicationRegistrar, ChildApplicationRegistrarCallback

class val.callback extends com.amazon.dcp.sso.ionRegistrar._cls1
{

    final SubAuthChildApplicationRegistrar this$0;
    final ChildApplicationRegistrarCallback val$callback;

    public void onAuthenticationFailed()
        throws RemoteException
    {
        val$callback.onAuthenticationFailed();
    }

    public void onBadResponse()
        throws RemoteException
    {
        val$callback.onBadResponse();
    }

    public void onInvalidRequest()
        throws RemoteException
    {
        val$callback.onInvalidRequest();
    }

    public void onNetworkError()
        throws RemoteException
    {
        val$callback.onNetworkError();
    }

    public void onResponseReceived(long l, Map map, byte abyte0[])
        throws RemoteException
    {
        map = SubAuthChildApplicationRegistrar.access$000$43fbbf88(l, map, abyte0);
        val$callback.onRegisterChildApplicationComplete(map);
    }

    ()
    {
        this$0 = final_subauthchildapplicationregistrar;
        val$callback = ChildApplicationRegistrarCallback.this;
        super();
    }
}
