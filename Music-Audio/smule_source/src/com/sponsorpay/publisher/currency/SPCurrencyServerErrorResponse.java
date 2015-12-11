// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.currency;


// Referenced classes of package com.sponsorpay.publisher.currency:
//            SPCurrencyServerRequestErrorType

public class SPCurrencyServerErrorResponse
    implements SPCurrencyServerRequester.SPCurrencyServerReponse
{

    private final String mErrorCode;
    private final String mErrorMessage;
    private final SPCurrencyServerRequestErrorType mErrorType;

    public SPCurrencyServerErrorResponse(SPCurrencyServerRequestErrorType spcurrencyserverrequesterrortype, String s, String s1)
    {
        mErrorType = spcurrencyserverrequesterrortype;
        mErrorCode = s;
        mErrorMessage = s1;
    }

    public String getErrorCode()
    {
        return mErrorCode;
    }

    public String getErrorMessage()
    {
        if (mErrorMessage != null)
        {
            return mErrorMessage;
        } else
        {
            return "";
        }
    }

    public SPCurrencyServerRequestErrorType getErrorType()
    {
        return mErrorType;
    }
}
