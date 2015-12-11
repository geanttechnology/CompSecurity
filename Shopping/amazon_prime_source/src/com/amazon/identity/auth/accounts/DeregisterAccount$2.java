// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            DeregisterAccount

class eregisterAccount
    implements sponseListener
{

    final DeregisterAccount this$0;
    final eregisterAccount val$response;

    public void onRequestComplete(boolean flag)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("booleanResult", flag);
        val$response.onResult(bundle);
    }

    eregisterAccount()
    {
        this$0 = final_deregisteraccount;
        val$response = eregisterAccount.this;
        super();
    }
}
