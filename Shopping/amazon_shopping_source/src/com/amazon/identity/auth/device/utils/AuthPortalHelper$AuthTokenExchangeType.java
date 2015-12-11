// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;


// Referenced classes of package com.amazon.identity.auth.device.utils:
//            AuthPortalHelper

public static final class  extends Enum
{

    private static final OauthRefreshToDelegationAccessExchange $VALUES[];
    public static final OauthRefreshToDelegationAccessExchange DMSTokenToOauthTokenExchange;
    public static final OauthRefreshToDelegationAccessExchange OauthRefreshToAccessExchange;
    public static final OauthRefreshToDelegationAccessExchange OauthRefreshToCookieExchange;
    public static final OauthRefreshToDelegationAccessExchange OauthRefreshToDelegationAccessExchange;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DMSTokenToOauthTokenExchange = new <init>("DMSTokenToOauthTokenExchange", 0);
        OauthRefreshToAccessExchange = new <init>("OauthRefreshToAccessExchange", 1);
        OauthRefreshToCookieExchange = new <init>("OauthRefreshToCookieExchange", 2);
        OauthRefreshToDelegationAccessExchange = new <init>("OauthRefreshToDelegationAccessExchange", 3);
        $VALUES = (new .VALUES[] {
            DMSTokenToOauthTokenExchange, OauthRefreshToAccessExchange, OauthRefreshToCookieExchange, OauthRefreshToDelegationAccessExchange
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
