// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;


// Referenced classes of package com.amazon.identity.auth.accounts:
//            DeregisterAccount, AccountRegistrar, SubAuthenticatorDescription, SubAuthenticatorConnection

class this._cls0
    implements nnectionFactory
{

    final DeregisterAccount this$0;

    public AccountRegistrar createAccountRegistrar()
    {
        return DeregisterAccount.this.createAccountRegistrar();
    }

    public SubAuthenticatorConnection createSubAuthConnection(SubAuthenticatorDescription subauthenticatordescription)
    {
        return DeregisterAccount.this.createSubAuthConnection(subauthenticatordescription);
    }

    ection()
    {
        this$0 = DeregisterAccount.this;
        super();
    }
}
