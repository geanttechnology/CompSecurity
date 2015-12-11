// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.inject.Provider;
import com.groupon.models.signup.SignupResponse;
import com.groupon.network.HttpResponseException;
import com.groupon.service.core.UserManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.CheckedFunction0;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            LoginService, SignUpService

public static class _cls2.val.onException
{

    private Context context;
    private Handler handler;
    private Provider logger;
    private ArraySharedPreferences loginPrefs;
    private UserManager userManager;

    private void exchangeFacebookToken(AccessToken accesstoken, CheckedFunction0 checkedfunction0, Function0 function0, Function1 function1)
    {
        accesstoken = new SignUpService(new Object[] {
            "facebook_access_token", accesstoken.getToken()
        }, checkedfunction0, function1) {

            final LoginService.FacebookLoginSubservice this$0;
            final Function1 val$onException;
            final CheckedFunction0 val$onSuccess;

            public void onException(Exception exception)
            {
                if (onException != null && (exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 401)
                {
                    onException.execute(exception);
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
                userManager.updateUserDetails(signupresponse.user);
                LoginService.setAccessToken(loginPrefs.edit(), signupresponse.accessToken).apply();
                ((Logger)logger.get()).forceLogRotate();
                if (onSuccess != null)
                {
                    onSuccess.execute();
                }
            }

            transient 
            {
                this$0 = LoginService.FacebookLoginSubservice.this;
                onSuccess = checkedfunction0;
                onException = function1;
                super(final_context1, final_s, aobj);
            }
        };
        accesstoken.method("POST");
        accesstoken.handler(handler);
        accesstoken.execute();
    }

    private void executeLoginRequest(CallbackManager callbackmanager, final Function0 onSuccess, final Function0 onCancel, final Function1 onException)
    {
        LoginManager.getInstance().registerCallback(callbackmanager, new FacebookCallback() {

            final LoginService.FacebookLoginSubservice this$0;
            final Function0 val$onCancel;
            final Function1 val$onException;
            final Function0 val$onSuccess;

            public void onCancel()
            {
                Ln.d("FACEBOOK: login CANCEL", new Object[0]);
                onCancel.execute();
            }

            public void onError(FacebookException facebookexception)
            {
                Ln.d("FACEBOOK: login ERROR", new Object[0]);
                onException.execute(facebookexception);
            }

            public void onSuccess(LoginResult loginresult)
            {
                Ln.d("FACEBOOK: login SUCCESS", new Object[0]);
                loginresult = loginresult.getAccessToken();
                exchangeFacebookToken(loginresult, onSuccess, onCancel, onException);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((LoginResult)obj);
            }

            
            {
                this$0 = LoginService.FacebookLoginSubservice.this;
                onSuccess = function0;
                onCancel = function0_1;
                onException = function1;
                super();
            }
        });
        callbackmanager = new ArrayList(Arrays.asList(context.getResources().getStringArray(0x7f0f0009)));
        LoginManager.getInstance().logInWithReadPermissions((Activity)context, callbackmanager);
    }

    public void login(CallbackManager callbackmanager, Function0 function0, Function0 function0_1, Function1 function1)
    {
        AccessToken accesstoken = AccessToken.getCurrentAccessToken();
        if (accesstoken == null)
        {
            executeLoginRequest(callbackmanager, function0, function0_1, function1);
            return;
        } else
        {
            exchangeFacebookToken(accesstoken, function0, function0_1, function1);
            return;
        }
    }

    public void requestNewReadPermissions(CallbackManager callbackmanager, Function0 function0, Function0 function0_1, Function1 function1)
    {
        if (AccessToken.getCurrentAccessToken() != null)
        {
            executeLoginRequest(callbackmanager, function0, function0_1, function1);
        }
    }

    public boolean shouldRequestNewReadPermissionsForCredentials()
    {
        AccessToken accesstoken = AccessToken.getCurrentAccessToken();
        if (accesstoken != null)
        {
            return accesstoken.getDeclinedPermissions().contains("email");
        } else
        {
            return false;
        }
    }





    public _cls2.val.onException()
    {
    }
}
