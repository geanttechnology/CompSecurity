// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import android.content.Context;
import com.groupon.models.signup.SignupResponse;
import com.groupon.models.signup.User;
import com.groupon.service.SignUpService;
import com.groupon.util.GoogleSignInCallbacks;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.callbacks:
//            GoogleServerAuthHandler

class val.idToken extends SignUpService
{

    final GoogleServerAuthHandler this$0;
    final String val$idToken;

    public void onException(Exception exception)
    {
        Ln.d("Google sign in: onException", new Object[0]);
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
        Ln.d("Google sign in: onSuccess /oauth/google_authenticate", new Object[0]);
        GoogleServerAuthHandler.access$100(GoogleServerAuthHandler.this, signupresponse.accessToken, val$idToken, signupresponse.user.consumerId);
    }

    transient (String s, Object aobj[], String s1)
    {
        this$0 = final_googleserverauthhandler;
        val$idToken = s1;
        super(Context.this, s, aobj);
    }
}
