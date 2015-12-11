// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import com.amazon.identity.auth.device.credentials.AccountCredentials;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountRegistrar

class edentials extends AccountCredentials
{

    final AccountRegistrar this$0;
    final String val$adpToken;
    final String val$key;

    public String getPrivateKey()
    {
        return val$key;
    }

    public String getToken()
    {
        return val$adpToken;
    }

    public boolean isStale(Context context)
    {
        return false;
    }

    edentials()
    {
        this$0 = final_accountregistrar;
        val$adpToken = s;
        val$key = String.this;
        super();
    }
}
