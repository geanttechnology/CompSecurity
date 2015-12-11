// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;


// Referenced classes of package com.amazon.identity.auth.device.token:
//            OAuthTokenManager

public static final class mErrorMsg extends Exception
{

    private com.amazon.identity.auth.device.framework.orMsg mAuthEndpointError;
    private final int mErrorCode;
    private final String mErrorMsg;

    public com.amazon.identity.auth.device.framework.orMsg getAuthEndpointError()
    {
        return mAuthEndpointError;
    }

    public int getErrorCode()
    {
        return mErrorCode;
    }

    public String getErrorMsg()
    {
        return mErrorMsg;
    }

    public (int i, String s)
    {
        super(s);
        mErrorCode = i;
        mErrorMsg = s;
    }

    public (int i, String s, com.amazon.identity.auth.device.framework.orMsg ormsg)
    {
        super(s);
        mErrorCode = i;
        mErrorMsg = s;
        mAuthEndpointError = ormsg;
    }

    public mAuthEndpointError(int i, String s, Throwable throwable)
    {
        super(s, throwable);
        mErrorCode = i;
        mErrorMsg = s;
    }
}
