// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.sdk.android.authentication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.spotify.sdk.android.authentication:
//            LoginDialog, LoginActivity, AuthenticationResponse, AuthenticationRequest

public class AuthenticationClient
{

    static final String EXTRA_AUTH_REQUEST = "EXTRA_AUTH_REQUEST";
    static final String EXTRA_AUTH_RESPONSE = "EXTRA_AUTH_RESPONSE";
    private AuthenticationCompleteListener mAuthenticationCompleteListener;
    private final Activity mLoginActivity;
    private LoginDialog mLoginDialog;

    public AuthenticationClient(Activity activity)
    {
        mLoginActivity = activity;
    }

    private void closeLoginDialog()
    {
        if (mLoginDialog != null)
        {
            mLoginDialog.setOnCompleteListener(null);
            mLoginDialog.close();
            mLoginDialog = null;
        }
    }

    public static Intent createLoginActivityIntent(Activity activity, AuthenticationRequest authenticationrequest)
    {
        if (activity == null || authenticationrequest == null)
        {
            throw new IllegalArgumentException("Context activity and request can't be null");
        } else
        {
            activity = new Intent(activity, com/spotify/sdk/android/authentication/LoginActivity);
            activity.putExtra("EXTRA_AUTH_REQUEST", authenticationrequest);
            return activity;
        }
    }

    public static AuthenticationResponse getResponse(int i, Intent intent)
    {
        if (i == -1 && intent != null && intent.getParcelableExtra("EXTRA_AUTH_RESPONSE") != null)
        {
            return (AuthenticationResponse)intent.getParcelableExtra("EXTRA_AUTH_RESPONSE");
        } else
        {
            return (new AuthenticationResponse.Builder()).setType(AuthenticationResponse.Type.EMPTY).build();
        }
    }

    public static void logout(Context context)
    {
        LoginDialog.clearCookies(context);
    }

    public static void openLoginActivity(Activity activity, int i, AuthenticationRequest authenticationrequest)
    {
        activity.startActivityForResult(createLoginActivityIntent(activity, authenticationrequest), i);
    }

    public static void openLoginInBrowser(Activity activity, AuthenticationRequest authenticationrequest)
    {
        activity.startActivity(new Intent("android.intent.action.VIEW", authenticationrequest.toUri()));
    }

    private void showLoginDialog(AuthenticationRequest authenticationrequest)
    {
        mLoginDialog = new LoginDialog(mLoginActivity, authenticationrequest);
        mLoginDialog.setOnCompleteListener(new _cls1());
        mLoginDialog.show();
    }

    public static void stopLoginActivity(Activity activity, int i)
    {
        activity.finishActivity(i);
    }

    void authenticate(AuthenticationRequest authenticationrequest)
    {
        showLoginDialog(authenticationrequest);
    }

    void cancel()
    {
        closeLoginDialog();
        if (mAuthenticationCompleteListener != null)
        {
    /* block-local class not found */
    class AuthenticationCompleteListener {}

            mAuthenticationCompleteListener.onAuthenticationClientCancelled();
            mAuthenticationCompleteListener = null;
        }
    }

    void sendComplete(Uri uri)
    {
        closeLoginDialog();
        uri = AuthenticationResponse.fromUri(uri);
        if (mAuthenticationCompleteListener != null)
        {
            mAuthenticationCompleteListener.onAuthenticationClientComplete(uri);
            mAuthenticationCompleteListener = null;
        }
    }

    void sendError(Throwable throwable)
    {
        closeLoginDialog();
        throwable = (new AuthenticationResponse.Builder()).setType(AuthenticationResponse.Type.ERROR).setError(throwable.getMessage()).build();
        if (mAuthenticationCompleteListener != null)
        {
            mAuthenticationCompleteListener.onAuthenticationClientComplete(throwable);
            mAuthenticationCompleteListener = null;
        }
    }

    void setOnCompleteListener(AuthenticationCompleteListener authenticationcompletelistener)
    {
        mAuthenticationCompleteListener = authenticationcompletelistener;
    }

    /* member class not found */
    class _cls1 {}

}
