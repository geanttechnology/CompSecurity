// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;


public final class KindleWebserviceErrorType extends Enum
{

    private static final KindleWebserviceErrorType $VALUES[];
    public static final KindleWebserviceErrorType KindleWebserviceErrorTypeCredentialsRequired;
    public static final KindleWebserviceErrorType KindleWebserviceErrorTypeDeviceAlreadyRegistered;
    public static final KindleWebserviceErrorType KindleWebserviceErrorTypeDuplicateDeviceName;
    public static final KindleWebserviceErrorType KindleWebserviceErrorTypeFileNotFound;
    public static final KindleWebserviceErrorType KindleWebserviceErrorTypeInsufficientFunds;
    public static final KindleWebserviceErrorType KindleWebserviceErrorTypeInternalError;
    public static final KindleWebserviceErrorType KindleWebserviceErrorTypeInvalidAsin;
    public static final KindleWebserviceErrorType KindleWebserviceErrorTypeInvalidOrder;
    public static final KindleWebserviceErrorType KindleWebserviceErrorTypeUnbuyError;
    public static final KindleWebserviceErrorType KindleWebserviceErrorTypeUnknownError;
    public static final KindleWebserviceErrorType KindleWebserviceErrorTypeUnrecognized;

    private KindleWebserviceErrorType(String s, int i)
    {
        super(s, i);
    }

    public static KindleWebserviceErrorType valueOf(String s)
    {
        return (KindleWebserviceErrorType)Enum.valueOf(com/amazon/identity/kcpsdk/common/KindleWebserviceErrorType, s);
    }

    public static KindleWebserviceErrorType[] values()
    {
        return (KindleWebserviceErrorType[])$VALUES.clone();
    }

    static 
    {
        KindleWebserviceErrorTypeFileNotFound = new KindleWebserviceErrorType("KindleWebserviceErrorTypeFileNotFound", 0);
        KindleWebserviceErrorTypeDeviceAlreadyRegistered = new KindleWebserviceErrorType("KindleWebserviceErrorTypeDeviceAlreadyRegistered", 1);
        KindleWebserviceErrorTypeCredentialsRequired = new KindleWebserviceErrorType("KindleWebserviceErrorTypeCredentialsRequired", 2);
        KindleWebserviceErrorTypeInvalidAsin = new KindleWebserviceErrorType("KindleWebserviceErrorTypeInvalidAsin", 3);
        KindleWebserviceErrorTypeInvalidOrder = new KindleWebserviceErrorType("KindleWebserviceErrorTypeInvalidOrder", 4);
        KindleWebserviceErrorTypeInsufficientFunds = new KindleWebserviceErrorType("KindleWebserviceErrorTypeInsufficientFunds", 5);
        KindleWebserviceErrorTypeUnknownError = new KindleWebserviceErrorType("KindleWebserviceErrorTypeUnknownError", 6);
        KindleWebserviceErrorTypeUnbuyError = new KindleWebserviceErrorType("KindleWebserviceErrorTypeUnbuyError", 7);
        KindleWebserviceErrorTypeDuplicateDeviceName = new KindleWebserviceErrorType("KindleWebserviceErrorTypeDuplicateDeviceName", 8);
        KindleWebserviceErrorTypeInternalError = new KindleWebserviceErrorType("KindleWebserviceErrorTypeInternalError", 9);
        KindleWebserviceErrorTypeUnrecognized = new KindleWebserviceErrorType("KindleWebserviceErrorTypeUnrecognized", 10);
        $VALUES = (new KindleWebserviceErrorType[] {
            KindleWebserviceErrorTypeFileNotFound, KindleWebserviceErrorTypeDeviceAlreadyRegistered, KindleWebserviceErrorTypeCredentialsRequired, KindleWebserviceErrorTypeInvalidAsin, KindleWebserviceErrorTypeInvalidOrder, KindleWebserviceErrorTypeInsufficientFunds, KindleWebserviceErrorTypeUnknownError, KindleWebserviceErrorTypeUnbuyError, KindleWebserviceErrorTypeDuplicateDeviceName, KindleWebserviceErrorTypeInternalError, 
            KindleWebserviceErrorTypeUnrecognized
        });
    }
}
