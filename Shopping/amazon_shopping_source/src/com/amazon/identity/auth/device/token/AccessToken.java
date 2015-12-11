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

    public static final long ALWAYS_EXPIRE = -1L;
    private static final String LOG_TAG = com/amazon/identity/auth/device/token/AccessToken.getName();
    public static final long NEVER_EXPIRE = 0L;
    protected static final long PRE_EXPIRATION_PERIOD = 300L;
    private Time mExpirationTime;
    private long mExpiresIn;

    public AccessToken(String s, String s1)
    {
        this(s, s1, 0L);
    }

    public AccessToken(String s, String s1, long l)
    {
        super(s);
        s = LOG_TAG;
        (new StringBuilder("Creating Token ")).append(getType()).append(" for id=").append(s1).toString();
        if (!TextUtils.isEmpty(s1))
        {
            mTokenData.put("directedid", s1);
        }
        setExpirationTime(l);
        mTokenData.put("expires_in", String.valueOf(l));
    }

    protected Time getCurrentTime()
    {
        Time time = new Time();
        time.setToNow();
        return time;
    }

    public long getExpiresIn()
    {
        return mExpiresIn;
    }

    protected long getPreExpirationPeriod()
    {
        return 300L;
    }

    public String getType()
    {
        return "com.amazon.identity.token.accessToken";
    }

    public boolean hasExpired()
    {
        if (0L != getExpiresIn())
        {
            if (-1L == getExpiresIn())
            {
                return true;
            }
            if (Time.compare(getCurrentTime(), mExpirationTime) >= 0)
            {
                return true;
            }
        }
        return false;
    }

    protected void setExpirationTime(long l)
    {
        mExpiresIn = l;
        if (l == 0L)
        {
            mExpirationTime = null;
            return;
        }
        if (l <= -1L)
        {
            mExpiresIn = -1L;
            mExpirationTime = null;
            return;
        } else
        {
            mExpirationTime = new Time();
            long l1 = getLocalTimestamp().toMillis(false);
            l = secsToMillis(l);
            long l2 = secsToMillis(getPreExpirationPeriod());
            mExpirationTime.set((l1 + l) - l2);
            return;
        }
    }

    public String toString()
    {
        return getToken();
    }

}
