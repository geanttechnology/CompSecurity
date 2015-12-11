// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.currency;


public final class SPCurrencyServerRequestErrorType extends Enum
{

    private static final SPCurrencyServerRequestErrorType ENUM$VALUES[];
    public static final SPCurrencyServerRequestErrorType ERROR_INVALID_RESPONSE;
    public static final SPCurrencyServerRequestErrorType ERROR_INVALID_RESPONSE_SIGNATURE;
    public static final SPCurrencyServerRequestErrorType ERROR_NO_INTERNET_CONNECTION;
    public static final SPCurrencyServerRequestErrorType ERROR_OTHER;
    public static final SPCurrencyServerRequestErrorType SERVER_RETURNED_ERROR;

    private SPCurrencyServerRequestErrorType(String s, int i)
    {
        super(s, i);
    }

    public static SPCurrencyServerRequestErrorType valueOf(String s)
    {
        return (SPCurrencyServerRequestErrorType)Enum.valueOf(com/sponsorpay/publisher/currency/SPCurrencyServerRequestErrorType, s);
    }

    public static SPCurrencyServerRequestErrorType[] values()
    {
        SPCurrencyServerRequestErrorType aspcurrencyserverrequesterrortype[] = ENUM$VALUES;
        int i = aspcurrencyserverrequesterrortype.length;
        SPCurrencyServerRequestErrorType aspcurrencyserverrequesterrortype1[] = new SPCurrencyServerRequestErrorType[i];
        System.arraycopy(aspcurrencyserverrequesterrortype, 0, aspcurrencyserverrequesterrortype1, 0, i);
        return aspcurrencyserverrequesterrortype1;
    }

    static 
    {
        ERROR_NO_INTERNET_CONNECTION = new SPCurrencyServerRequestErrorType("ERROR_NO_INTERNET_CONNECTION", 0);
        ERROR_INVALID_RESPONSE = new SPCurrencyServerRequestErrorType("ERROR_INVALID_RESPONSE", 1);
        ERROR_INVALID_RESPONSE_SIGNATURE = new SPCurrencyServerRequestErrorType("ERROR_INVALID_RESPONSE_SIGNATURE", 2);
        SERVER_RETURNED_ERROR = new SPCurrencyServerRequestErrorType("SERVER_RETURNED_ERROR", 3);
        ERROR_OTHER = new SPCurrencyServerRequestErrorType("ERROR_OTHER", 4);
        ENUM$VALUES = (new SPCurrencyServerRequestErrorType[] {
            ERROR_NO_INTERNET_CONNECTION, ERROR_INVALID_RESPONSE, ERROR_INVALID_RESPONSE_SIGNATURE, SERVER_RETURNED_ERROR, ERROR_OTHER
        });
    }
}
