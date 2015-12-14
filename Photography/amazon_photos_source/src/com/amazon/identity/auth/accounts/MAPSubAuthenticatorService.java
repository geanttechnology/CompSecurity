// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.amazon.dcp.sso.IAmazonAccountAuthenticator;
import com.amazon.dcp.sso.ISubAuthenticatorResponse;
import com.amazon.identity.auth.device.api.MAPInit;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AbstractSubAuthenticator, DMSSubAuthenticator

public class MAPSubAuthenticatorService extends Service
{

    private AbstractSubAuthenticator mSubAuthenticator;

    public MAPSubAuthenticatorService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return mSubAuthenticator.getIBinder();
    }

    public void onCreate()
    {
        super.onCreate();
        MAPInit.getInstance(this).initialize();
        mSubAuthenticator = new AbstractSubAuthenticator(this) {

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

            
            {
                this$0 = MAPSubAuthenticatorService.this;
                super(context);
            }
        };
    }
}
