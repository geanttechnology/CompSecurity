// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.text.TextUtils;
import android.text.format.Time;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            AbstractToken

public class AccessToken extends AbstractToken
{

    private static final String LOG_TAG = com/amazon/identity/auth/device/token/AccessToken.getName();
    private Time mExpirationTime;
    private long mExpiresIn;

    public AccessToken(String s, String s1)
    {
        this(s, s1, (byte)0);
    }

    public AccessToken(String s, String s1, byte byte0)
    {
        super(s);
        (new StringBuilder("Creating Token ")).append(getType()).append(" for id=").append(s1);
        if (!TextUtils.isEmpty(s1))
        {
            mTokenData.put("directedid", s1);
        }
        setExpirationTime$1349ef();
        mTokenData.put("expires_in", "0");
    }

    public String getType()
    {
        return "com.amazon.identity.token.accessToken";
    }

    protected void setExpirationTime$1349ef()
    {
        mExpiresIn = 0L;
        if (0L == 0L)
        {
            mExpirationTime = null;
            return;
        }
        if (0L <= -1L)
        {
            mExpiresIn = -1L;
            mExpirationTime = null;
            return;
        } else
        {
            mExpirationTime = new Time();
            long l = getLocalTimestamp().toMillis(false);
            mExpirationTime.set((l + 0L) - 0x493e0L);
            return;
        }
    }

    public String toString()
    {
        return getToken();
    }

}
