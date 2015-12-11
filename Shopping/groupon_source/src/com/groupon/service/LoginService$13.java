// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
import com.groupon.dogfood.DogfoodHelper;
import com.groupon.models.country.Country;
import com.groupon.models.signup.SignupResponse;
import com.groupon.network.HttpResponseException;
import com.groupon.service.core.UserManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.sso.SSOHelper;
import com.groupon.sso.UserCredential;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.CheckedFunction0;
import com.groupon.util.CountryUtil;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import java.util.concurrent.atomic.AtomicInteger;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.service:
//            SignUpService, LoginService

class nit> extends SignUpService
{

    final LoginService this$0;
    final Function1 val$onException;
    final Function0 val$onFinally;
    final CheckedFunction0 val$onSuccess;
    final String val$password;
    final String val$username;

    protected void onException(Exception exception)
    {
        if (val$onException != null)
        {
            val$onException.execute(exception);
            return;
        }
        if ((exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 401)
        {
            Toast.makeText(LoginService.access$100(LoginService.this), String.format(LoginService.access$100(LoginService.this).getString(0x7f08017d), new Object[] {
                countryUtil.getDisplayNameByIsoName(LoginService.access$000(LoginService.this).getCurrentCountry())
            }), 0).show();
            return;
        } else
        {
            super.onException(exception);
            return;
        }
    }

    protected void onFinally()
    {
        if (val$onFinally == null)
        {
            super.onFinally();
            return;
        } else
        {
            val$onFinally.execute();
            return;
        }
    }

    protected void onSuccess(SignupResponse signupresponse)
        throws Exception
    {
        UserCredential usercredential = new UserCredential(val$username, val$password, LoginService.access$000(LoginService.this).getCurrentCountry().isoName, val$username);
        SSOHelper.addOrUpdateAccountForApp(LoginService.access$100(LoginService.this), usercredential);
        ((UserManager)LoginService.access$200(LoginService.this).get()).updateUserDetails(signupresponse.user);
        LoginService.access$300(LoginService.this).logEmailAddress();
        LoginService.setAccessToken(LoginService.access$400(LoginService.this).edit(), signupresponse.accessToken).apply();
        prefs.edit().putBoolean("hasLoggedInAtleastOnce", true).apply();
        ((Logger)LoginService.access$500(LoginService.this).get()).forceLogRotate();
        LoginService.access$600().set(0);
        LoginService.access$400(LoginService.this).edit().putBoolean("should_refresh_deals_after_login", true).apply();
        if (val$onSuccess != null)
        {
            val$onSuccess.execute();
            return;
        } else
        {
            super.onSuccess(signupresponse);
            return;
        }
    }

    transient onse(CheckedFunction0 checkedfunction0, 
            Function1 function1, Function0 function0)
    {
        this$0 = final_loginservice;
        val$username = s1;
        val$password = String.this;
        val$onSuccess = checkedfunction0;
        val$onException = function1;
        val$onFinally = function0;
        super(final_context, final_s, final_aobj);
    }
}
