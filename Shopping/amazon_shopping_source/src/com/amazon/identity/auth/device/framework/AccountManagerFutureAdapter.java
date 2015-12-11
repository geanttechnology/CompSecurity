// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class AccountManagerFutureAdapter
    implements MAPFuture
{

    private static final String TAG = com/amazon/identity/auth/device/framework/AccountManagerFutureAdapter.getName();
    private final AccountManagerFuture mAccountManFuture;

    public AccountManagerFutureAdapter(AccountManagerFuture accountmanagerfuture)
    {
        mAccountManFuture = accountmanagerfuture;
    }

    public Bundle get()
        throws MAPCallbackErrorException, InterruptedException, ExecutionException
    {
        Bundle bundle;
        try
        {
            bundle = getResultBundle(mAccountManFuture.getResult());
        }
        catch (OperationCanceledException operationcanceledexception)
        {
            MAPLog.w(TAG, (new StringBuilder("AccountManager request failed because of OperationCanceledException: ")).append(operationcanceledexception.getMessage()).toString());
            throw new ExecutionException(operationcanceledexception);
        }
        catch (AuthenticatorException authenticatorexception)
        {
            MAPLog.w(TAG, (new StringBuilder("AccountManager request failed because of AuthenticatorException: ")).append(authenticatorexception.getMessage()).toString());
            throw new ExecutionException(authenticatorexception);
        }
        catch (IOException ioexception)
        {
            MAPLog.w(TAG, (new StringBuilder("AccountManager request failed because of IOException: ")).append(ioexception.getMessage()).toString());
            throw new ExecutionException(ioexception);
        }
        return bundle;
    }

    public Bundle get(long l, TimeUnit timeunit)
        throws MAPCallbackErrorException, InterruptedException, ExecutionException, TimeoutException
    {
        try
        {
            timeunit = getResultBundle(mAccountManFuture.getResult(l, timeunit));
        }
        // Misplaced declaration of an exception variable
        catch (TimeUnit timeunit)
        {
            MAPLog.w(TAG, (new StringBuilder("AccountManager request failed because of OperationCanceledException: ")).append(timeunit.getMessage()).toString());
            throw new ExecutionException(timeunit);
        }
        // Misplaced declaration of an exception variable
        catch (TimeUnit timeunit)
        {
            MAPLog.w(TAG, (new StringBuilder("AccountManager request failed because of AuthenticatorException: ")).append(timeunit.getMessage()).toString());
            throw new ExecutionException(timeunit);
        }
        // Misplaced declaration of an exception variable
        catch (TimeUnit timeunit)
        {
            MAPLog.w(TAG, (new StringBuilder("AccountManager request failed because of IOException: ")).append(timeunit.getMessage()).toString());
            throw new ExecutionException(timeunit);
        }
        return timeunit;
    }

    public volatile Object get()
        throws MAPCallbackErrorException, InterruptedException, ExecutionException
    {
        return get();
    }

    public volatile Object get(long l, TimeUnit timeunit)
        throws MAPCallbackErrorException, InterruptedException, ExecutionException, TimeoutException
    {
        return get(l, timeunit);
    }

    protected abstract Bundle getResultBundle(Object obj)
        throws MAPCallbackErrorException;

}
