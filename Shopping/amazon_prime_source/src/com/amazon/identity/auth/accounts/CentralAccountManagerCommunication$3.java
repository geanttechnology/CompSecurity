// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.AccountManagerFuture;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.framework.AccountManagerFutureAdapter;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            CentralAccountManagerCommunication

class init> extends AccountManagerFutureAdapter
{

    final CentralAccountManagerCommunication this$0;

    protected Bundle getResultBundle(Boolean boolean1)
        throws MAPCallbackErrorException
    {
        if (boolean1 == null || !boolean1.booleanValue())
        {
            throw new MAPCallbackErrorException(CentralAccountManagerCommunication.access$100$74f9fc51());
        } else
        {
            return CentralAccountManagerCommunication.access$200$74f9fc51();
        }
    }

    protected volatile Bundle getResultBundle(Object obj)
        throws MAPCallbackErrorException
    {
        return getResultBundle((Boolean)obj);
    }

    (AccountManagerFuture accountmanagerfuture)
    {
        this$0 = CentralAccountManagerCommunication.this;
        super(accountmanagerfuture);
    }
}
