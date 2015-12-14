// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MultipleAccountManager;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

private class <init>
    implements Callback
{

    final SignInActivity this$0;

    public void onError(final Bundle result)
    {
        SignInActivity.access$1200(SignInActivity.this).post(new Runnable() {

            final SignInActivity.SignInCallback this$1;
            final Bundle val$result;

            public void run()
            {
                int i = result.getInt("com.amazon.dcp.sso.ErrorCode");
                int j = result.getInt("errorCode");
                String s = result.getString("com.amazon.dcp.sso.ErrorMessage");
                String s1 = result.getString("auth_data_additional_info");
                com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror = com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.fromValue(i);
                if (registrationerror == com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ACCOUNT_ALREADY_EXISTS)
                {
                    GLogger.w(SignInActivity.access$1100(), "ACCOUNT_ALREADY_EXISTS; passing through as signed-in", new Object[0]);
                    onSuccess(result);
                    return;
                }
                SignInActivity.access$600(this$0, false);
                SignInActivity.access$2000(this$0);
                if (j == 4)
                {
                    GLogger.d(SignInActivity.access$1100(), "User cancelled MFA", new Object[0]);
                    SignInActivity.access$2500(this$0);
                    return;
                }
                SignInActivity.access$1000(this$0, s);
                switch (SignInActivity._cls17.$SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[registrationerror.ordinal()])
                {
                default:
                    SignInActivity.access$1000(this$0, getString(0x7f0e01ee));
                    return;

                case 1: // '\001'
                case 2: // '\002'
                    if ("CountryCodeRequired".equals(s1))
                    {
                        SignInActivity.access$1000(this$0, getResources().getString(0x7f0e01ed));
                        return;
                    } else
                    {
                        SignInActivity.access$1000(this$0, getResources().getString(0x7f0e01ec));
                        return;
                    }

                case 3: // '\003'
                    SignInActivity.access$1000(this$0, getString(0x7f0e0054));
                    return;
                }
            }

            
            {
                this$1 = SignInActivity.SignInCallback.this;
                result = bundle;
                super();
            }
        });
    }

    public void onSuccess(Bundle bundle)
    {
        SignInActivity.access$2302(SignInActivity.this, true);
        bundle = bundle.getString("com.amazon.dcp.sso.property.account.acctId");
        if (!SignInActivity.access$2400(SignInActivity.this).doesAccountHaveMapping(bundle, com.amazon.identity.auth.device.api.MappingType.createCurrentPackageMapping(getApplicationContext())))
        {
            SignInActivity.access$2400(SignInActivity.this).setAccountMappings(bundle, new com.amazon.identity.auth.device.api.MappingType[] {
                com.amazon.identity.auth.device.api.MappingType.createCurrentPackageMapping(getApplicationContext())
            });
        }
        SignInActivity.access$1900(SignInActivity.this);
    }

    private _cls1.val.result()
    {
        this$0 = SignInActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
