// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.google.inject.Provider;
import com.groupon.models.signup.SignupResponse;
import com.groupon.network.HttpResponseException;
import com.groupon.service.core.UserManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.CheckedFunction0;
import com.groupon.util.Function1;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            SignUpService, LoginService

class val.onException extends SignUpService
{

    final val.onSuccess this$0;
    final Function1 val$onException;
    final CheckedFunction0 val$onSuccess;

    public void onException(Exception exception)
    {
        if (val$onException != null && (exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 401)
        {
            val$onException.execute(exception);
            return;
        } else
        {
            super.onException(exception);
            return;
        }
    }

    protected void onSuccess(SignupResponse signupresponse)
        throws Exception
    {
        Ln.d("FACEBOOK: onSuccess /oauth/facebook_authenticate", new Object[0]);
        cess._mth1100(this._cls0.this).updateUserDetails(signupresponse.user);
        LoginService.setAccessToken(cess._mth1200(this._cls0.this).edit(), signupresponse.accessToken).e();
        ((Logger)cess._mth1300(this._cls0.this).get()).forceLogRotate();
        if (val$onSuccess != null)
        {
            val$onSuccess.execute();
        }
    }

    transient (Object aobj[], CheckedFunction0 checkedfunction0, Function1 function1)
    {
        this$0 = final_;
        val$onSuccess = checkedfunction0;
        val$onException = function1;
        super(final_context, String.this, aobj);
    }
}
