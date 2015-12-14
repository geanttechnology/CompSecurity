// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            TokenCache

class val.callback
    implements AccountManagerCallback
{

    final TokenCache this$0;
    final AccountManagerCallback val$callback;

    public void run(final AccountManagerFuture future)
    {
        TokenCache.access$500().execute(new Runnable() {

            final TokenCache._cls2 this$1;
            final AccountManagerFuture val$future;

            public void run()
            {
                callback.run(future);
            }

            
            {
                this$1 = TokenCache._cls2.this;
                future = accountmanagerfuture;
                super();
            }
        });
    }

    _cls1.val.future()
    {
        this$0 = final_tokencache;
        val$callback = AccountManagerCallback.this;
        super();
    }
}
