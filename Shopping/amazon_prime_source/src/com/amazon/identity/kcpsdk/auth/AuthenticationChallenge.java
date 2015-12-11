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

    private static final String TAG = com/amazon/identity/kcpsdk/auth/AuthenticationChallenge.getName();
    private String mAuthDataAdditionalInfo;
    private String mContext;
    private String mOAuthURI;
    private String mReason;
    private String mRequiredAuthenticationMethod;

    public AuthenticationChallenge(String s, String s1, String s2, String s3, String s4)
    {
        mReason = s;
        mContext = s2;
        mOAuthURI = sanitizeOAuthURI(s1);
        mRequiredAuthenticationMethod = s3;
        mAuthDataAdditionalInfo = s4;
    }

    public static AuthenticationChallenge fromPandaChallengeBody(JSONObject jsonobject)
        throws JSONException
    {
        return new AuthenticationChallenge(jsonobject.getString("challenge_reason"), jsonobject.optString("uri", null), jsonobject.optString("challenge_context", null), jsonobject.optString("required_authentication_method", null), jsonobject.optString("auth_data_additional_info", null));
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

    public void addAdditionalInfoToBundle(Bundle bundle)
    {
        if (mAuthDataAdditionalInfo != null)
        {
            bundle.putString("auth_data_additional_info", mAuthDataAdditionalInfo);
        }
    }

    public String getAuthDataAdditionalInfo()
    {
        return mAuthDataAdditionalInfo;
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
        bundle.putString("auth_data_additional_info", mAuthDataAdditionalInfo);
        return bundle;
    }

}
