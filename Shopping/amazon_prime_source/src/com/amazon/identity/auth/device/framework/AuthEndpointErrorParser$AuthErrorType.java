// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;


// Referenced classes of package com.amazon.identity.auth.device.framework:
//            AuthEndpointErrorParser

public static final class mError extends Enum
{

    private static final NetworkFailure $VALUES[];
    public static final NetworkFailure AuthenticationChallenged;
    public static final NetworkFailure BuildRequestFailure;
    public static final NetworkFailure CredentialError;
    public static final NetworkFailure DeviceAlreadyRegistered;
    public static final NetworkFailure DuplicateDeviceName;
    public static final NetworkFailure Forbidden;
    public static final NetworkFailure GenericError;
    public static final NetworkFailure InvalidDirectedId;
    public static final NetworkFailure InvalidToken;
    public static final NetworkFailure InvalidValue;
    public static final NetworkFailure MethodNotAllowed;
    public static final NetworkFailure MissingValue;
    public static final NetworkFailure NetworkFailure;
    public static final NetworkFailure NotImplemented;
    public static final NetworkFailure ParseError;
    public static final NetworkFailure ProtocolError;
    public static final NetworkFailure ServerError;
    public static final NetworkFailure ServiceUnavailable;
    private final String mCode;
    private final com.amazon.identity.auth.device.api.rType mError;
    private final boolean mRetry;

    public static mError getAuthErrorTypeFromCode(String s)
    {
        mError amerror[] = values();
        int j = amerror.length;
        for (int i = 0; i < j; i++)
        {
            mError merror = amerror[i];
            if (merror.getCode().equals(s))
            {
                return merror;
            }
        }

        return GenericError;
    }

    public static GenericError valueOf(String s)
    {
        return (GenericError)Enum.valueOf(com/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType, s);
    }

    public static GenericError[] values()
    {
        return (GenericError[])$VALUES.clone();
    }

    public String getCode()
    {
        return mCode;
    }

    public com.amazon.identity.auth.device.api.rType getRegistrationError()
    {
        return mError;
    }

    public boolean getRetry()
    {
        return mRetry;
    }

    static 
    {
        MissingValue = new <init>("MissingValue", 0, "MissingValue", false, com.amazon.identity.auth.device.api.D_REQUEST);
        InvalidValue = new <init>("InvalidValue", 1, "InvalidValue", false, com.amazon.identity.auth.device.api.D_REQUEST);
        InvalidToken = new <init>("InvalidToken", 2, "InvalidToken", false, com.amazon.identity.auth.device.api.D_REQUEST);
        ProtocolError = new <init>("ProtocolError", 3, "ProtocolError", false, com.amazon.identity.auth.device.api.D_REQUEST);
        CredentialError = new <init>("CredentialError", 4, "CredentialError", false, com.amazon.identity.auth.device.api.STOMER_NOT_FOUND);
        Forbidden = new <init>("Forbidden", 5, "Forbidden", false, com.amazon.identity.auth.device.api.D_REQUEST);
        MethodNotAllowed = new <init>("MethodNotAllowed", 6, "MethodNotAllowed", false, com.amazon.identity.auth.device.api.D_REQUEST);
        ServerError = new <init>("ServerError", 7, "ServerError", true, com.amazon.identity.auth.device.api.RECOGNIZED);
        ServiceUnavailable = new <init>("ServiceUnavailable", 8, "ServiceUnavailable", true, com.amazon.identity.auth.device.api.RECOGNIZED);
        NotImplemented = new <init>("NotImplemented", 9, "NotImplemented", false, com.amazon.identity.auth.device.api.D_REQUEST);
        InvalidDirectedId = new <init>("InvalidDirectedId", 10, "InvalidDirectedId", false, com.amazon.identity.auth.device.api.D_REQUEST);
        DeviceAlreadyRegistered = new <init>("DeviceAlreadyRegistered", 11, "DeviceAlreadyRegistered", false, com.amazon.identity.auth.device.api.VICE_ALREADY_REGISTERED);
        DuplicateDeviceName = new <init>("DuplicateDeviceName", 12, "DuplicateDeviceName", false, com.amazon.identity.auth.device.api.PLICATE_DEVICE_NAME);
        GenericError = new <init>("GenericError", 13);
        AuthenticationChallenged = new <init>("AuthenticationChallenged", 14, "AuthenticationChallenged", false, com.amazon.identity.auth.device.api.THENTICATION_CHALLENGED);
        ParseError = new <init>("ParseError", 15, "ParseError", true, com.amazon.identity.auth.device.api.RSE_ERROR);
        BuildRequestFailure = new <init>("BuildRequestFailure", 16, "BuildRequestFailure", false, com.amazon.identity.auth.device.api.D_REQUEST);
        NetworkFailure = new <init>("NetworkFailure", 17, "NetworkFailure", true, com.amazon.identity.auth.device.api.TWORK_FAILURE);
        $VALUES = (new .VALUES[] {
            MissingValue, InvalidValue, InvalidToken, ProtocolError, CredentialError, Forbidden, MethodNotAllowed, ServerError, ServiceUnavailable, NotImplemented, 
            InvalidDirectedId, DeviceAlreadyRegistered, DuplicateDeviceName, GenericError, AuthenticationChallenged, ParseError, BuildRequestFailure, NetworkFailure
        });
    }

    private (String s, int i)
    {
        this(s, i, "GenericError", false, com.amazon.identity.auth.device.api.RECOGNIZED);
    }

    private IZED(String s, int i, String s1, boolean flag, com.amazon.identity.auth.device.api.rType rtype)
    {
        super(s, i);
        mCode = s1;
        mRetry = flag;
        mError = rtype;
    }
}
