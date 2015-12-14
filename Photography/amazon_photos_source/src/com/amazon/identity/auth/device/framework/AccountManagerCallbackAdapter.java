// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import com.amazon.identity.auth.accounts.AccountsCallbackHelpers;
import com.amazon.identity.auth.device.api.Callback;
import java.io.IOException;

public abstract class AccountManagerCallbackAdapter
    implements AccountManagerCallback
{

    private final Callback mCallback;

    public AccountManagerCallbackAdapter(Callback callback)
    {
        mCallback = callback;
    }

    protected abstract void onResult(Callback callback, Object obj);

    public void run(AccountManagerFuture accountmanagerfuture)
    {
        byte byte0;
        try
        {
            accountmanagerfuture = ((AccountManagerFuture) (accountmanagerfuture.getResult()));
            onResult(mCallback, accountmanagerfuture);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            accountmanagerfuture = accountmanagerfuture.getMessage();
            byte0 = 5;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            accountmanagerfuture = accountmanagerfuture.getMessage();
            byte0 = 4;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            accountmanagerfuture = accountmanagerfuture.getMessage();
            byte0 = 5;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            accountmanagerfuture = accountmanagerfuture.getMessage();
            byte0 = 3;
        }
        AccountsCallbackHelpers.onAccountManagerError(mCallback, byte0, accountmanagerfuture);
    }
}
