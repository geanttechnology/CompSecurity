// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.sdk.android.authentication;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.spotify.sdk.android.authentication:
//            AuthenticationRequest

public static class mRedirectUri
{

    private final String mClientId;
    private Map mCustomParams;
    private final String mRedirectUri;
    private final mState mResponseType;
    private String mScopes[];
    private boolean mShowDialog;
    private String mState;

    public AuthenticationRequest build()
    {
        return new AuthenticationRequest(mClientId, mResponseType, mRedirectUri, mState, mScopes, mShowDialog, mCustomParams, null);
    }

    public mCustomParams setCustomParam(String s, String s1)
    {
        if (s == null || s.isEmpty())
        {
            throw new IllegalArgumentException("Custom parameter key can't be null or empty");
        }
        if (s1 == null || s1.isEmpty())
        {
            throw new IllegalArgumentException("Custom parameter value can't be null or empty");
        } else
        {
            mCustomParams.put(s, s1);
            return this;
        }
    }

    public mCustomParams setScopes(String as[])
    {
        mScopes = as;
        return this;
    }

    public mScopes setShowDialog(boolean flag)
    {
        mShowDialog = flag;
        return this;
    }

    public mShowDialog setState(String s)
    {
        mState = s;
        return this;
    }

    public (String s,  , String s1)
    {
        mCustomParams = new HashMap();
        if (s == null)
        {
            throw new IllegalArgumentException("Client ID can't be null");
        }
        if ( == null)
        {
            throw new IllegalArgumentException("Response type can't be null");
        }
        if (s1 == null || s1.length() == 0)
        {
            throw new IllegalArgumentException("Redirect URI can't be null or empty");
        } else
        {
            mClientId = s;
            mResponseType = ;
            mRedirectUri = s1;
            return;
        }
    }
}
