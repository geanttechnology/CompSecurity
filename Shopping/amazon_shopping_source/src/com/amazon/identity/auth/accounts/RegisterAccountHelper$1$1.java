// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import com.amazon.identity.auth.device.callback.AsyncToSyncAdapter;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            RegisterAccountHelper

class this._cls1
    implements hCredentialsCallback
{

    final yncOperationComplete this$1;

    public void failure()
    {
        callback.failure();
        yncOperationComplete();
    }

    public void success()
    {
        callback.success();
        yncOperationComplete();
    }

    <init>()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/identity/auth/accounts/RegisterAccountHelper$1

/* anonymous class */
    class RegisterAccountHelper._cls1 extends AsyncToSyncAdapter
    {

        final RegisterAccountHelper this$0;
        final RegisterAccountHelper.FetchCredentialsCallback val$callback;
        final Context val$context;

        protected void startAsyncOperation()
        {
            RegisterAccountHelper._cls1._cls1 _lcls1 = new RegisterAccountHelper._cls1._cls1();
            ensureCredentialsPopulated(context, _lcls1);
        }



            
            {
                this$0 = final_registeraccounthelper;
                callback = fetchcredentialscallback;
                context = Context.this;
                super();
            }
    }

}
