// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.sso;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.groupon.sso:
//            SSOHelper

static final class orException
    implements AccountManagerCallback
{

    public void run(AccountManagerFuture accountmanagerfuture)
    {
        try
        {
            Log.i(SSOHelper.access$000(), (new StringBuilder()).append("account remove result: ").append(accountmanagerfuture.getResult(5L, TimeUnit.SECONDS)).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            Log.e(SSOHelper.access$000(), "removeAccount", accountmanagerfuture);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            Log.e(SSOHelper.access$000(), "removeAccount", accountmanagerfuture);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            Log.e(SSOHelper.access$000(), "removeAccount", accountmanagerfuture);
        }
    }

    orException()
    {
    }
}
