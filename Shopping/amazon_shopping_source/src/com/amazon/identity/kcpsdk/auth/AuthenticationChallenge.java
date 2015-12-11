// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.os.Bundle;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public final class AuthenticationChallenge
{

    public static final String KEY_AUTHENTICATION_CHALLENGE = "com.amazon.identity.auth.ChallengeException";
    public static final String KEY_AUTHENTICATION_CHALLENGE_CONTEXT = "com.amazon.identity.auth.ChallengeException.Context";
    public static final String KEY_AUTHENTICATION_CHALLENGE_OAUTH_URI = "com.amazon.identity.auth.ChallengeException.oAuthURI";
    public static final String KEY_AUTHENTICATION_CHALLENGE_REASON = "com.amazon.identity.auth.ChallengeException.Reason";
    public static final String KEY_AUTHENTICATION_CHALLENGE_REQUIRED_AUTHENTICATION_METHOD = "com.amazon.identity.auth.ChallengeException.requiredAuthenticationMethod";
    public static final String PANDA_CHALLENGE_CONTEXT_KEY = "challenge_context";
    public static final String PANDA_CHALLENGE_OAUTH_URI_KEY = "uri";
    public static final String PANDA_CHALLENGE_REASON_KEY = "challenge_reason";
    public static final String PANDA_CHALLENGE_REQUIRED_AUTHENTICATION_METHOD = "required_authentication_method";
    private static final String TAG = com/amazon/identity/kcpsdk/auth/AuthenticationChallenge.getName();
    private String mContext;
    private String mOAuthURI;
    private String mReason;
    private String mRequiredAuthenticationMethod;

    public AuthenticationChallenge(String s, String s1, String s2, String s3)
    {
        mReason = s;
        mContext = s2;
        mOAuthURI = sanitizeOAuthURI(s1);
        mRequiredAuthenticationMethod = s3;
    }

    public static AuthenticationChallenge fromPandaChallengeBody(JSONObject jsonobject)
        throws JSONException
    {
        return new AuthenticationChallenge(jsonobject.getString("challenge_reason"), jsonobject.optString("uri", null), jsonobject.optString("challenge_context", null), jsonobject.optString("required_authentication_method", null));
    }

    private String sanitizeOAuthURI(String s)
    {
        URL url;
        try
        {
            url = new URL(s);
        }
        catch (MalformedURLException malformedurlexception)
        {
            MAPLog.w(TAG, (new StringBuilder(" Malformed URL received: ")).append(s).toString());
            return null;
        }
        return url.toString();
    }

    public String getContext()
    {
        return mContext;
    }

    public String getOAuthURI()
    {
        return mOAuthURI;
    }

    public String getReason()
    {
        return mReason;
    }

    public Bundle toBundle()
    {
        Bundle bundle = new Bundle();
        bundle.putString("com.amazon.identity.auth.ChallengeException.Reason", mReason);
        bundle.putString("com.amazon.identity.auth.ChallengeException.oAuthURI", mOAuthURI);
        bundle.putString("com.amazon.identity.auth.ChallengeException.Context", mContext);
        bundle.putString("com.amazon.identity.auth.ChallengeException.requiredAuthenticationMethod", mRequiredAuthenticationMethod);
        return bundle;
    }

}
