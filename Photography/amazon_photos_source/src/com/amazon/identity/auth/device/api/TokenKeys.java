// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.device.storage.StorageKeyUtils;

public final class TokenKeys
{
    public static final class Options
    {

        public static final String KEY_FORCE_REFRESH_DMS_TO_OAUTH = "com.amazon.identity.auth.device.api.TokenKeys.Options.ForceRefreshDMSTokenForOAuthToken";
        public static final String KEY_FORCE_REFRESH_OAUTH = "com.amazon.identity.auth.device.api.TokenKeys.Options.ForceRefreshOAuthToken";
        public static final String KEY_OAUTH_TTL_MS_LONG = "com.amazon.identity.auth.device.api.TokenKeys.Options.OAuthAccessTokenTTLInMilliSec";
        public static final String PREFIX = "com.amazon.identity.auth.device.api.TokenKeys.Options.";

        private Options()
        {
        }
    }


    public static final String KEY_ACCESS_TOKEN = "com.amazon.dcp.sso.token.oauth.amazon.access_token";
    public static final String KEY_XFSN = "com.amazon.identity.cookies.xfsn";

    private TokenKeys()
    {
    }

    public static String getAccessTokenKeyForPackage(String s)
    {
        return StorageKeyUtils.getKeyWithPackageNamespace(s, "com.amazon.dcp.sso.token.oauth.amazon.access_token");
    }

    public static String getAdpTokenKeyForPackage(String s)
    {
        return StorageKeyUtils.getKeyWithPackageNamespace(s, "com.amazon.dcp.sso.token.device.adptoken");
    }

    public static String getPrivateKeyKeyForPackage(String s)
    {
        return StorageKeyUtils.getKeyWithPackageNamespace(s, "com.amazon.dcp.sso.token.device.privatekey");
    }
}
