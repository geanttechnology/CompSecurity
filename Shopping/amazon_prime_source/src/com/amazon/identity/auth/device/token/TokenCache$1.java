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
            val$listener._mth5dc9c75(bundle);
            return;
        }
        synchronized (TokenCache.access$000(TokenCache.this))
        {
            TokenCache.access$100(TokenCache.this, s, bundle.getString("authtoken"));
        }
        accountmanagerfuture = TokenCache.this;
        TokenCache.access$200(TokenCache.this);
        if (!TokenCache.access$300$3313e598(accountmanagerfuture, val$tokenTypeStack, this))
        {
            val$listener.success();
            return;
        }
        break MISSING_BLOCK_LABEL_210;
        exception;
        accountmanagerfuture;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            val$listener._mth2498c652(4, accountmanagerfuture.getMessage());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            val$listener._mth2498c652(5, accountmanagerfuture.getMessage());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            accountmanagerfuture = accountmanagerfuture.getMessage();
            KeyFactoryUtils.recordDMSCredentialErrorAndCallDeregisterIfNecessary(TokenCache.access$400(TokenCache.this), accountmanagerfuture);
            val$listener._mth2498c652(3, accountmanagerfuture);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            val$listener._mth2498c652(7, accountmanagerfuture.getMessage());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AccountManagerFuture accountmanagerfuture)
        {
            MAPLog.e(TokenCache.TAG, "Generic error while fetching Tokens", accountmanagerfuture);
        }
        val$listener._mth2498c652(1, accountmanagerfuture.getMessage());
    }

    stener()
    {
        this$0 = final_tokencache;
        val$tokenTypeStack = stack;
        val$listener = stener.this;
        super();
    }
}
