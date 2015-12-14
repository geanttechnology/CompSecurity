// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            DeregisterAccount, AccountRegistrar, SubAuthenticatorConnection, SubAuthenticatorDescription

public static class mContext
    implements mContext
{

    private final Context mContext;

    public AccountRegistrar createAccountRegistrar()
    {
        return new AccountRegistrar(mContext);
    }

    public SubAuthenticatorConnection createSubAuthConnection(SubAuthenticatorDescription subauthenticatordescription)
    {
        return new SubAuthenticatorConnection(subauthenticatordescription, mContext);
    }

    public (Context context)
    {
        mContext = context;
    }
}
