// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;
import com.amazon.identity.auth.device.utils.KeyFactoryUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.IOException;
import java.util.Stack;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            TokenCache

class stener
    implements AccountManagerCallback
{

    final TokenCache this$0;
    final stener val$listener;
    final Stack val$tokenTypeStack;

    public void run(AccountManagerFuture accountmanagerfuture)
    {
        String s = (String)val$tokenTypeStack.peek();
        Bundle bundle;
        bundle = (Bundle)accountmanagerfuture.getResult();
        if (!bundle.containsKey("authtoken"))
        {
            val$listener.failure(s, bundle);
            return;
        }
        synchronized (TokenCache.access$000(TokenCache.this))
        {
            TokenCache.access$100(TokenCache.this, s, bundle.getString("authtoken"));
        }
        try
        {
            if (!TokenCache.access$300(TokenCache.this, TokenCache.access$200(TokenCache.this), val$tokenTypeStack, this))
            {
                val$listener.success();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            val$listener.failure(s, 4, accountmanagerfuture.getMessage());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            val$listener.failure(s, 5, accountmanagerfuture.getMessage());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            accountmanagerfuture = accountmanagerfuture.getMessage();
            KeyFactoryUtils.recordDMSCredentialErrorAndCallDeregisterIfNecessary(TokenCache.access$400(TokenCache.this), accountmanagerfuture);
            val$listener.failure(s, 3, accountmanagerfuture);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            val$listener.failure(s, 7, accountmanagerfuture.getMessage());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            MAPLog.e(TokenCache.TAG, "Generic error while fetching Tokens", accountmanagerfuture);
            val$listener.failure(s, 1, accountmanagerfuture.getMessage());
        }
        break MISSING_BLOCK_LABEL_213;
        exception;
        accountmanagerfuture;
        JVM INSTR monitorexit ;
        throw exception;
    }

    stener()
    {
        this$0 = final_tokencache;
        val$tokenTypeStack = stack;
        val$listener = stener.this;
        super();
    }
}
