// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;


// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPAccountManager

public static final class mName extends Enum
{

    private static final AUTHENTICATION_CHALLENGED $VALUES[];
    public static final AUTHENTICATION_CHALLENGED ACCOUNT_ALREADY_EXISTS;
    public static final AUTHENTICATION_CHALLENGED ALREADY_DEREGISTERED;
    public static final AUTHENTICATION_CHALLENGED AUTHENTICATION_CHALLENGED;
    public static final AUTHENTICATION_CHALLENGED AUTHENTICATION_FAILED;
    public static final AUTHENTICATION_CHALLENGED BAD_REQUEST;
    public static final AUTHENTICATION_CHALLENGED BAD_SECRET;
    public static final AUTHENTICATION_CHALLENGED CUSTOMER_NOT_FOUND;
    public static final AUTHENTICATION_CHALLENGED DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED;
    public static final AUTHENTICATION_CHALLENGED DEREGISTER_FAILED;
    public static final AUTHENTICATION_CHALLENGED DEVICE_ALREADY_REGISTERED;
    public static final AUTHENTICATION_CHALLENGED DUPLICATE_DEVICE_NAME;
    public static final AUTHENTICATION_CHALLENGED NETWORK_FAILURE;
    public static final AUTHENTICATION_CHALLENGED NO_ACCOUNT;
    public static final AUTHENTICATION_CHALLENGED PARSE_ERROR;
    public static final AUTHENTICATION_CHALLENGED REGISTER_FAILED;
    public static final AUTHENTICATION_CHALLENGED UI_NOT_FOUND;
    public static final AUTHENTICATION_CHALLENGED UNRECOGNIZED;
    private final String mName;
    private final int mValue;

    public static mName fromValue(int i)
    {
        mName mname = fromValueHelper(i);
        if (mname != null)
        {
            return mname;
        } else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public static fromValueHelper fromValue(int i, fromValueHelper fromvaluehelper)
    {
        fromValueHelper fromvaluehelper1 = fromValueHelper(i);
        if (fromvaluehelper1 != null)
        {
            return fromvaluehelper1;
        } else
        {
            return fromvaluehelper;
        }
    }

    private static fromValueHelper fromValueHelper(int i)
    {
        fromValueHelper afromvaluehelper[] = values();
        int k = afromvaluehelper.length;
        for (int j = 0; j < k; j++)
        {
            fromValueHelper fromvaluehelper = afromvaluehelper[j];
            if (fromvaluehelper.value() == i)
            {
                return fromvaluehelper;
            }
        }

        return null;
    }

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    public int value()
    {
        return mValue;
    }

    static 
    {
        ACCOUNT_ALREADY_EXISTS = new <init>("ACCOUNT_ALREADY_EXISTS", 0, 0, "AccountAlreadyExists");
        NETWORK_FAILURE = new <init>("NETWORK_FAILURE", 1, 1, "NetworkFailure");
        AUTHENTICATION_FAILED = new <init>("AUTHENTICATION_FAILED", 2, 2, "AuthenticationFailed");
        PARSE_ERROR = new <init>("PARSE_ERROR", 3, 3, "ParseError");
        CUSTOMER_NOT_FOUND = new <init>("CUSTOMER_NOT_FOUND", 4, 4, "CustomerNotFound");
        DEVICE_ALREADY_REGISTERED = new <init>("DEVICE_ALREADY_REGISTERED", 5, 5, "DeviceAlreadyRegistered");
        DUPLICATE_DEVICE_NAME = new <init>("DUPLICATE_DEVICE_NAME", 6, 6, "DuplicateDeviceName");
        DEREGISTER_FAILED = new <init>("DEREGISTER_FAILED", 7, 7, "DeregisterFailed");
        UNRECOGNIZED = new <init>("UNRECOGNIZED", 8, 8, "Unrecognized");
        REGISTER_FAILED = new <init>("REGISTER_FAILED", 9, 9, "RegisterFailed");
        BAD_REQUEST = new <init>("BAD_REQUEST", 10, 10, "BadRequest");
        ALREADY_DEREGISTERED = new <init>("ALREADY_DEREGISTERED", 11, 11, "AlreadyDeregistered");
        BAD_SECRET = new <init>("BAD_SECRET", 12, 12, "BadSecret");
        NO_ACCOUNT = new <init>("NO_ACCOUNT", 13, 13, "NoAccount");
        UI_NOT_FOUND = new <init>("UI_NOT_FOUND", 14, 14, "UINotFound");
        DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED = new <init>("DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED", 15, 15, "DelegateeAccountAlreadyDeregistered");
        AUTHENTICATION_CHALLENGED = new <init>("AUTHENTICATION_CHALLENGED", 16, 16, "AuthenticationChallenged");
        $VALUES = (new .VALUES[] {
            ACCOUNT_ALREADY_EXISTS, NETWORK_FAILURE, AUTHENTICATION_FAILED, PARSE_ERROR, CUSTOMER_NOT_FOUND, DEVICE_ALREADY_REGISTERED, DUPLICATE_DEVICE_NAME, DEREGISTER_FAILED, UNRECOGNIZED, REGISTER_FAILED, 
            BAD_REQUEST, ALREADY_DEREGISTERED, BAD_SECRET, NO_ACCOUNT, UI_NOT_FOUND, DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED, AUTHENTICATION_CHALLENGED
        });
    }

    private (String s, int i, int j, String s1)
    {
        super(s, i);
        mValue = j;
        mName = s1;
    }
}
