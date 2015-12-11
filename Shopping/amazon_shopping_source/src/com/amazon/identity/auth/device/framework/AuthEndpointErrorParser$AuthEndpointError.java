// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;


// Referenced classes of package com.amazon.identity.auth.device.framework:
//            AuthEndpointErrorParser

public static class mRequestId
{

    private final etry mAuthErrorType;
    private final String mDetail;
    private final String mMessage;
    private final String mRequestId;

    public mRequestId getAuthTypeError()
    {
        return mAuthErrorType;
    }

    public String getDetail()
    {
        return mDetail;
    }

    public String getMessage()
    {
        return mMessage;
    }

    public com.amazon.identity.auth.device.api.Error getRegistrationError()
    {
        return mAuthErrorType.egistrationError();
    }

    public String getRequestId()
    {
        return mRequestId;
    }

    public boolean shouldRetry()
    {
        return mAuthErrorType.etry();
    }

    public Y(Y y, String s, String s1, String s2)
    {
        mAuthErrorType = y;
        mMessage = s;
        mDetail = s1;
        mRequestId = s2;
    }
}
