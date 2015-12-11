// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.AccountManagerFuture;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.framework.AccountManagerFutureAdapter;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountsCallbackHelpers

public class StandardAccountManagerFutureAdapter extends AccountManagerFutureAdapter
{

    public StandardAccountManagerFutureAdapter(AccountManagerFuture accountmanagerfuture)
    {
        super(accountmanagerfuture);
    }

    protected Bundle getResultBundle(Bundle bundle)
        throws MAPCallbackErrorException
    {
        if (AccountsCallbackHelpers.hasError(bundle))
        {
            throw new MAPCallbackErrorException(bundle);
        } else
        {
            return bundle;
        }
    }

    protected volatile Bundle getResultBundle(Object obj)
        throws MAPCallbackErrorException
    {
        return getResultBundle((Bundle)obj);
    }
}
