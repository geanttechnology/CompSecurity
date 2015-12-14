// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            TokenCache

class val.future
    implements Runnable
{

    final val.future this$1;
    final AccountManagerFuture val$future;

    public void run()
    {
        callback.run(val$future);
    }

    l.callback()
    {
        this$1 = final_callback;
        val$future = AccountManagerFuture.this;
        super();
    }

    // Unreferenced inner class com/amazon/identity/auth/device/token/TokenCache$2

/* anonymous class */
    class TokenCache._cls2
        implements AccountManagerCallback
    {

        final TokenCache this$0;
        final AccountManagerCallback val$callback;

        public void run(AccountManagerFuture accountmanagerfuture)
        {
            TokenCache.access$500().execute(accountmanagerfuture. new TokenCache._cls2._cls1());
        }

            
            {
                this$0 = final_tokencache;
                callback = AccountManagerCallback.this;
                super();
            }
    }

}
