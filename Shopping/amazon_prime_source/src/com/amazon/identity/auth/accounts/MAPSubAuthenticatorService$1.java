// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import com.amazon.dcp.sso.IAmazonAccountAuthenticator;
import com.amazon.dcp.sso.ISubAuthenticatorResponse;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AbstractSubAuthenticator, MAPSubAuthenticatorService, DMSSubAuthenticator

class t> extends AbstractSubAuthenticator
{

    private DMSSubAuthenticator mDmsSubAuth;
    final MAPSubAuthenticatorService this$0;

    private DMSSubAuthenticator getDMSSubAuthenticator()
    {
        this;
        JVM INSTR monitorenter ;
        DMSSubAuthenticator dmssubauthenticator;
        if (mDmsSubAuth == null)
        {
            mDmsSubAuth = DMSSubAuthenticator.constructDMSSubAuthForThisPackage(MAPSubAuthenticatorService.this);
        }
        dmssubauthenticator = mDmsSubAuth;
        this;
        JVM INSTR monitorexit ;
        return dmssubauthenticator;
        Exception exception;
        exception;
        throw exception;
    }

    public void getAccountRemovalAllowed(ISubAuthenticatorResponse isubauthenticatorresponse, Account account)
    {
        getDMSSubAuthenticator().getAccountRemovalAllowed(isubauthenticatorresponse, account.type, account.name);
    }

    public void getAuthToken(ISubAuthenticatorResponse isubauthenticatorresponse, Account account, String s, Bundle bundle, IAmazonAccountAuthenticator iamazonaccountauthenticator)
    {
        getDMSSubAuthenticator().getAuthToken(isubauthenticatorresponse, account.type, account.name, s, bundle, iamazonaccountauthenticator);
    }

    public void updateAuthToken(ISubAuthenticatorResponse isubauthenticatorresponse, Account account, String s, Bundle bundle, IAmazonAccountAuthenticator iamazonaccountauthenticator)
    {
        getDMSSubAuthenticator().updateAuthToken(isubauthenticatorresponse, account.type, account.name, s, bundle, iamazonaccountauthenticator);
    }

    (Context context)
    {
        this$0 = MAPSubAuthenticatorService.this;
        super(context);
    }
}
