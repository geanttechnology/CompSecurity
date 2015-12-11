// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk;

import android.os.Bundle;

public class CallResponse
{

    private String mErrorCode;
    private String mResponseMessage;
    private Constants.CallResponseType mResponseType;

    CallResponse(Constants.CallResponseType callresponsetype, String s, String s1)
    {
        mResponseType = callresponsetype;
        mResponseMessage = s;
        mErrorCode = s1;
    }

    public static CallResponse fromBundle(Bundle bundle)
    {
        return new CallResponse(Constants.CallResponseType.fromResponseCode(bundle.getInt("callResponseType")), bundle.getString("callResponseMessage"), bundle.getString("callErrorCode"));
    }

    public String toString()
    {
        return String.format("Type: %s Message: %s ErrorCode: %s", new Object[] {
            mResponseType, mResponseMessage, mErrorCode
        });
    }
}
