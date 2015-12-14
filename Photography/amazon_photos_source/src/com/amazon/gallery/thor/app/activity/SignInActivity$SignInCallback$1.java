// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.res.Resources;
import android.os.Bundle;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

class val.result
    implements Runnable
{

    final is._cls0 this$1;
    final Bundle val$result;

    public void run()
    {
        int i = val$result.getInt("com.amazon.dcp.sso.ErrorCode");
        int j = val$result.getInt("errorCode");
        String s = val$result.getString("com.amazon.dcp.sso.ErrorMessage");
        String s1 = val$result.getString("auth_data_additional_info");
        com.amazon.identity.auth.device.api.ror ror = com.amazon.identity.auth.device.api.ror.fromValue(i);
        if (ror == com.amazon.identity.auth.device.api.ror.ACCOUNT_ALREADY_EXISTS)
        {
            GLogger.w(SignInActivity.access$1100(), "ACCOUNT_ALREADY_EXISTS; passing through as signed-in", new Object[0]);
            Success(val$result);
            return;
        }
        SignInActivity.access$600(_fld0, false);
        SignInActivity.access$2000(_fld0);
        if (j == 4)
        {
            GLogger.d(SignInActivity.access$1100(), "User cancelled MFA", new Object[0]);
            SignInActivity.access$2500(_fld0);
            return;
        }
        SignInActivity.access$1000(_fld0, s);
        switch (.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError[ror.ordinal()])
        {
        default:
            SignInActivity.access$1000(_fld0, getString(0x7f0e01ee));
            return;

        case 1: // '\001'
        case 2: // '\002'
            if ("CountryCodeRequired".equals(s1))
            {
                SignInActivity.access$1000(_fld0, getResources().getString(0x7f0e01ed));
                return;
            } else
            {
                SignInActivity.access$1000(_fld0, getResources().getString(0x7f0e01ec));
                return;
            }

        case 3: // '\003'
            SignInActivity.access$1000(_fld0, getString(0x7f0e0054));
            return;
        }
    }

    or()
    {
        this$1 = final_or;
        val$result = Bundle.this;
        super();
    }
}
