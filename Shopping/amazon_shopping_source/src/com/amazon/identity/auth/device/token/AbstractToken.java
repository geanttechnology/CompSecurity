// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.text.TextUtils;
import android.text.format.Time;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            Token

public abstract class AbstractToken
    implements Token
{

    private static final String LOG_TAG = com/amazon/identity/auth/device/token/AbstractToken.getName();
    protected final Time mLocalCreationTimestamp;
    private final String mToken;
    protected Map mTokenData;

    private AbstractToken()
    {
        mLocalCreationTimestamp = new Time();
        mToken = null;
    }

    public AbstractToken(AbstractToken abstracttoken)
    {
        mLocalCreationTimestamp = new Time();
        if (abstracttoken == null || TextUtils.isEmpty(abstracttoken.getToken()))
        {
            throw new IllegalArgumentException("Token string may not be null for an AbstractToken");
        } else
        {
            mToken = abstracttoken.getToken();
            mLocalCreationTimestamp.set(abstracttoken.mLocalCreationTimestamp);
            mTokenData = new HashMap(abstracttoken.mTokenData);
            return;
        }
    }

    public AbstractToken(String s)
    {
        mLocalCreationTimestamp = new Time();
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Token string may not be null for an AbstractToken");
        } else
        {
            mToken = s;
            mLocalCreationTimestamp.setToNow();
            mTokenData = new HashMap();
            mTokenData.put("token", mToken);
            mTokenData.put("creation_time", String.valueOf(mLocalCreationTimestamp.toMillis(false)));
            return;
        }
    }

    public AbstractToken(Map map)
    {
        mLocalCreationTimestamp = new Time();
        mToken = (String)map.get("token");
        if (TextUtils.isEmpty(mToken))
        {
            throw new IllegalArgumentException("Token string may not be null for an AbstractToken");
        }
        mTokenData = map;
        String s = (String)map.get("creation_time");
        if (s == null)
        {
            s = LOG_TAG;
            mLocalCreationTimestamp.setToNow();
            map.put("creation_time", String.valueOf(mLocalCreationTimestamp.toMillis(false)));
            return;
        }
        try
        {
            mLocalCreationTimestamp.set(Long.parseLong(s));
            return;
        }
        catch (NumberFormatException numberformatexception)
        {
            numberformatexception = LOG_TAG;
        }
        mLocalCreationTimestamp.setToNow();
        map.put("creation_time", String.valueOf(mLocalCreationTimestamp.toMillis(false)));
    }

    public static com.amazon.identity.auth.device.AccountManagerConstants.REGION_HINT convertStringToRegionHint(String s)
    {
        if (com.amazon.identity.auth.device.AccountManagerConstants.REGION_HINT.EU.toString().equalsIgnoreCase(s))
        {
            return com.amazon.identity.auth.device.AccountManagerConstants.REGION_HINT.EU;
        }
        if (com.amazon.identity.auth.device.AccountManagerConstants.REGION_HINT.FE.toString().equalsIgnoreCase(s))
        {
            return com.amazon.identity.auth.device.AccountManagerConstants.REGION_HINT.FE;
        }
        if (com.amazon.identity.auth.device.AccountManagerConstants.REGION_HINT.CN.toString().equalsIgnoreCase(s))
        {
            return com.amazon.identity.auth.device.AccountManagerConstants.REGION_HINT.CN;
        } else
        {
            return com.amazon.identity.auth.device.AccountManagerConstants.REGION_HINT.NA;
        }
    }

    protected static long millisToSecs(long l)
    {
        return l / 1000L;
    }

    protected static long secsToMillis(long l)
    {
        return 1000L * l;
    }

    public final Map getData()
    {
        return mTokenData;
    }

    public String getDirectedId()
    {
        return (String)mTokenData.get("directedid");
    }

    public Time getLocalTimestamp()
    {
        return mLocalCreationTimestamp;
    }

    protected final String getToken()
    {
        return mToken;
    }

}
