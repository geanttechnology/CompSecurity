// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import com.amazon.identity.auth.device.callback.AsyncToSyncAdapter;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            RegisterAccountHelper

class r extends AsyncToSyncAdapter
{

    final RegisterAccountHelper this$0;
    final tchCredentialsCallback val$callback;
    final Context val$context;

    protected void startAsyncOperation()
    {
        tchCredentialsCallback tchcredentialscallback = new RegisterAccountHelper.FetchCredentialsCallback() {

            final RegisterAccountHelper._cls1 this$1;

            public void failure()
            {
                callback.failure();
                asyncOperationComplete();
            }

            public void success()
            {
                callback.success();
                asyncOperationComplete();
            }

            
            {
                this$1 = RegisterAccountHelper._cls1.this;
                super();
            }
        };
        ensureCredentialsPopulated(val$context, tchcredentialscallback);
    }



    tchCredentialsCallback()
    {
        this$0 = final_registeraccounthelper;
        val$callback = tchcredentialscallback;
        val$context = Context.this;
        super();
    }
}
