// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;


// Referenced classes of package com.amazon.identity.auth.device.token:
//            OAuthTokenManager

public static final class mFailureMetric extends Enum
{

    private static final OauthRefreshToDelegationAccessExchange $VALUES[];
    public static final OauthRefreshToDelegationAccessExchange DMSTokenToOauthTokenExchange;
    public static final OauthRefreshToDelegationAccessExchange OauthRefreshToAccessExchange;
    public static final OauthRefreshToDelegationAccessExchange OauthRefreshToCookieExchange;
    public static final OauthRefreshToDelegationAccessExchange OauthRefreshToDelegationAccessExchange;
    final String mFailureMetric;

    public static mFailureMetric valueOf(String s)
    {
        return (mFailureMetric)Enum.valueOf(com/amazon/identity/auth/device/token/OAuthTokenManager$AuthTokenExchangeType, s);
    }

    public static mFailureMetric[] values()
    {
        return (mFailureMetric[])$VALUES.clone();
    }

    static 
    {
        DMSTokenToOauthTokenExchange = new <init>("DMSTokenToOauthTokenExchange", 0, "exchangeDMSCredentialsForOAuthTokenFailure");
        OauthRefreshToAccessExchange = new <init>("OauthRefreshToAccessExchange", 1, "refreshNormalOAuthTokenFailure");
        OauthRefreshToCookieExchange = new <init>("OauthRefreshToCookieExchange", 2, "fetchCookiesFromServerFailure");
        OauthRefreshToDelegationAccessExchange = new <init>("OauthRefreshToDelegationAccessExchange", 3, "refreshDelegatedOAuthTokenFailure");
        $VALUES = (new .VALUES[] {
            DMSTokenToOauthTokenExchange, OauthRefreshToAccessExchange, OauthRefreshToCookieExchange, OauthRefreshToDelegationAccessExchange
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mFailureMetric = s1;
    }
}
