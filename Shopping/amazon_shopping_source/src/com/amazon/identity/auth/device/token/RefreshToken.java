// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.text.TextUtils;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            AbstractToken

public class RefreshToken extends AbstractToken
{

    public static final com.amazon.identity.auth.device.AccountManagerConstants.REGION_HINT DEFAULT_REGION_HINT;
    private static final String LOG_TAG = com/amazon/identity/auth/device/token/RefreshToken.getName();
    private final com.amazon.identity.auth.device.AccountManagerConstants.REGION_HINT mRegionHint;

    public RefreshToken(String s, com.amazon.identity.auth.device.AccountManagerConstants.REGION_HINT region_hint, String s1)
    {
        super(s);
        if (!TextUtils.isEmpty(s1))
        {
            mTokenData.put("directedid", s1);
        }
        mRegionHint = region_hint;
        mTokenData.put("region_hint", mRegionHint.toString());
        s = LOG_TAG;
        (new StringBuilder("Creating Token ")).append(getType()).append(" for id=").append(getDirectedId()).toString();
    }

    public RefreshToken(String s, String s1)
    {
        this(s, DEFAULT_REGION_HINT, s1);
    }

    public String getDMSDirectedId()
    {
        return (String)mTokenData.get("dms.directed.id");
    }

    public String getDirectedId()
    {
        return (String)mTokenData.get("directedid");
    }

    public com.amazon.identity.auth.device.AccountManagerConstants.REGION_HINT getRegionHint()
    {
        return mRegionHint;
    }

    public String getType()
    {
        return "com.amazon.identity.token.refreshToken";
    }

    public String setDMSDirectedId(String s)
    {
        return (String)mTokenData.put("dms.directed.id", s);
    }

    public String toString()
    {
        return getToken();
    }

    static 
    {
        DEFAULT_REGION_HINT = com.amazon.identity.auth.device.AccountManagerConstants.REGION_HINT.NA;
    }
}
