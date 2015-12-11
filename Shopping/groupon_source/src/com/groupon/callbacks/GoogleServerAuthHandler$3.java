// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import android.content.Context;
import com.google.inject.Provider;
import com.groupon.models.signup.SignupResponse;
import com.groupon.service.LoginService;
import com.groupon.service.SignUpService;
import com.groupon.service.core.UserManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.GoogleSignInCallbacks;
import java.lang.ref.WeakReference;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.callbacks:
//            GoogleServerAuthHandler

class val.googleIdToken extends SignUpService
{

    final GoogleServerAuthHandler this$0;
    final String val$accessToken;
    final String val$consumerId;
    final String val$googleIdToken;

    public void onException(Exception exception)
    {
        Ln.d("Google sign in: exception making /users/%s call", new Object[] {
            val$consumerId
        });
        if (googleSignInCallbacks != null)
        {
            googleSignInCallbacks.onGoogleSignInException(exception);
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
        Ln.d("Google Sign in: onSuccess /users/%s", new Object[] {
            val$consumerId
        });
        GoogleServerAuthHandler.access$200(GoogleServerAuthHandler.this).updateUserDetails((Context)GoogleServerAuthHandler.access$000(GoogleServerAuthHandler.this).get(), signupresponse.user);
        signupresponse = GoogleServerAuthHandler.access$300(GoogleServerAuthHandler.this).edit();
        LoginService.setAccessToken(signupresponse, val$accessToken);
        GoogleServerAuthHandler.setGoogleIdToken(signupresponse, val$googleIdToken).pply();
        ((Logger)GoogleServerAuthHandler.access$400(GoogleServerAuthHandler.this).get()).forceLogRotate();
        if (googleSignInCallbacks != null)
        {
            googleSignInCallbacks.onGoogleSignInSuccess();
        }
    }

    transient (String s1, String s2, String s3)
    {
        this$0 = final_googleserverauthhandler;
        val$consumerId = s1;
        val$accessToken = s2;
        val$googleIdToken = s3;
        super(final_context, final_s, _5B_Ljava.lang.Object_3B_.this);
    }
}
