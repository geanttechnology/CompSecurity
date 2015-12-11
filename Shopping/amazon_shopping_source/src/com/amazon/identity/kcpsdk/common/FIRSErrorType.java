// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;


public final class FIRSErrorType extends Enum
{

    private static final FIRSErrorType $VALUES[];
    public static final FIRSErrorType FIRSErrorTypeCustomerNotFound;
    public static final FIRSErrorType FIRSErrorTypeDeviceAlreadyRegistered;
    public static final FIRSErrorType FIRSErrorTypeDuplicateAccountName;
    public static final FIRSErrorType FIRSErrorTypeInternalError;
    public static final FIRSErrorType FIRSErrorTypeInvalidAccountFound;
    public static final FIRSErrorType FIRSErrorTypeUnrecognized;
    private final String mErrorCode;

    private FIRSErrorType(String s, int i, String s1)
    {
        super(s, i);
        mErrorCode = s1;
    }

    public static FIRSErrorType valueOf(String s)
    {
        return (FIRSErrorType)Enum.valueOf(com/amazon/identity/kcpsdk/common/FIRSErrorType, s);
    }

    public static FIRSErrorType[] values()
    {
        return (FIRSErrorType[])$VALUES.clone();
    }

    public String getErrorCode()
    {
        return mErrorCode;
    }

    static 
    {
        FIRSErrorTypeCustomerNotFound = new FIRSErrorType("FIRSErrorTypeCustomerNotFound", 0, "customer_not_found");
        FIRSErrorTypeDeviceAlreadyRegistered = new FIRSErrorType("FIRSErrorTypeDeviceAlreadyRegistered", 1, "device_already_registered");
        FIRSErrorTypeDuplicateAccountName = new FIRSErrorType("FIRSErrorTypeDuplicateAccountName", 2, "duplicate_account_name");
        FIRSErrorTypeInternalError = new FIRSErrorType("FIRSErrorTypeInternalError", 3, "message");
        FIRSErrorTypeUnrecognized = new FIRSErrorType("FIRSErrorTypeUnrecognized", 4, "unrecognized");
        FIRSErrorTypeInvalidAccountFound = new FIRSErrorType("FIRSErrorTypeInvalidAccountFound", 5, "invalid_account_found");
        $VALUES = (new FIRSErrorType[] {
            FIRSErrorTypeCustomerNotFound, FIRSErrorTypeDeviceAlreadyRegistered, FIRSErrorTypeDuplicateAccountName, FIRSErrorTypeInternalError, FIRSErrorTypeUnrecognized, FIRSErrorTypeInvalidAccountFound
        });
    }
}
