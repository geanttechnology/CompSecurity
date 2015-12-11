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

    public Time getLocalTimestamp()
    {
        return mLocalCreationTimestamp;
    }

    protected final String getToken()
    {
        return mToken;
    }

}
