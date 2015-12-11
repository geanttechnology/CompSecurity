// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


public final class RegisterDeviceErrorType extends Enum
{

    private static final RegisterDeviceErrorType $VALUES[];
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeChallengeResponse;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeCustomerNotFound;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeDeviceAlreadyRegistered;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeDeviceNotRegisteredPanda;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeDuplicateDeviceName;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeInternal;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeInvalidDevice;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeInvalidDirectedId;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeInvalidTokenPanda;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeInvalidValue;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeMethodNotAllowed;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeMissingValue;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeNotImplemented;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeProtocolError;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeServerError;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeServerUnavailable;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeUnauthorizedPanda;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeUnrecognized;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeUnrecognizedFirs;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeUnrecognizedKindle;
    public static final RegisterDeviceErrorType RegisterDeviceErrorTypeUnrecognizedPanda;
    private String mErrorString;

    private RegisterDeviceErrorType(String s, int i, String s1)
    {
        super(s, i);
        mErrorString = s1;
    }

    public static RegisterDeviceErrorType valueOf(String s)
    {
        return (RegisterDeviceErrorType)Enum.valueOf(com/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType, s);
    }

    public static RegisterDeviceErrorType[] values()
    {
        return (RegisterDeviceErrorType[])$VALUES.clone();
    }

    public String getErrorString()
    {
        return mErrorString;
    }

    static 
    {
        RegisterDeviceErrorTypeCustomerNotFound = new RegisterDeviceErrorType("RegisterDeviceErrorTypeCustomerNotFound", 0, "Customer Not Found. Invalid credentials. The email or phone number and password did not match our records.");
        RegisterDeviceErrorTypeDeviceAlreadyRegistered = new RegisterDeviceErrorType("RegisterDeviceErrorTypeDeviceAlreadyRegistered", 1, "Device Already Registered");
        RegisterDeviceErrorTypeDeviceNotRegisteredPanda = new RegisterDeviceErrorType("RegisterDeviceErrorTypeDeviceNotRegisteredPanda", 2, "Primary account not registered to device");
        RegisterDeviceErrorTypeDuplicateDeviceName = new RegisterDeviceErrorType("RegisterDeviceErrorTypeDuplicateDeviceName", 3, "The device name is duplicate to an existing one");
        RegisterDeviceErrorTypeUnrecognized = new RegisterDeviceErrorType("RegisterDeviceErrorTypeUnrecognized", 4, "Unrecognized");
        RegisterDeviceErrorTypeChallengeResponse = new RegisterDeviceErrorType("RegisterDeviceErrorTypeChallengeResponse", 5, "Challenge Response Received");
        RegisterDeviceErrorTypeMissingValue = new RegisterDeviceErrorType("RegisterDeviceErrorTypeMissingValue", 6, "One or more required values are missing");
        RegisterDeviceErrorTypeInvalidValue = new RegisterDeviceErrorType("RegisterDeviceErrorTypeInvalidValue", 7, "One or more required values are invalid");
        RegisterDeviceErrorTypeInvalidTokenPanda = new RegisterDeviceErrorType("RegisterDeviceErrorTypeInvalidTokenPanda", 8, "The token used for registration in Panda is invalid");
        RegisterDeviceErrorTypeProtocolError = new RegisterDeviceErrorType("RegisterDeviceErrorTypeProtocolError", 9, "The Protocol is not supported. SSL required");
        RegisterDeviceErrorTypeMethodNotAllowed = new RegisterDeviceErrorType("RegisterDeviceErrorTypeMethodNotAllowed", 10, "The HTTP method is not valid. For example, using POST instead of GET");
        RegisterDeviceErrorTypeServerError = new RegisterDeviceErrorType("RegisterDeviceErrorTypeServerError", 11, "The server has encountered a runtime error, try again later");
        RegisterDeviceErrorTypeNotImplemented = new RegisterDeviceErrorType("RegisterDeviceErrorTypeNotImplemented", 12, "The feature is not implemented");
        RegisterDeviceErrorTypeInvalidDirectedId = new RegisterDeviceErrorType("RegisterDeviceErrorTypeInvalidDirectedId", 13, "The directedId is invalid. e.g. The customer directedId is invalid. The device directedId is invalid");
        RegisterDeviceErrorTypeInvalidDevice = new RegisterDeviceErrorType("RegisterDeviceErrorTypeInvalidDevice", 14, "The device information is invalid. The device serial number is too long");
        RegisterDeviceErrorTypeUnauthorizedPanda = new RegisterDeviceErrorType("RegisterDeviceErrorTypeUnauthorizedPanda", 15, "Unauthorized error from Panda");
        RegisterDeviceErrorTypeUnrecognizedFirs = new RegisterDeviceErrorType("RegisterDeviceErrorTypeUnrecognizedFirs", 16, "Unrecognized Firs");
        RegisterDeviceErrorTypeUnrecognizedKindle = new RegisterDeviceErrorType("RegisterDeviceErrorTypeUnrecognizedKindle", 17, "Unrecognized Kindle");
        RegisterDeviceErrorTypeUnrecognizedPanda = new RegisterDeviceErrorType("RegisterDeviceErrorTypeUnrecognizedPanda", 18, "Unrecognized Panda");
        RegisterDeviceErrorTypeServerUnavailable = new RegisterDeviceErrorType("RegisterDeviceErrorTypeServerUnavailable", 19, "The service temporarily overloaded or unavailable, try again later");
        RegisterDeviceErrorTypeInternal = new RegisterDeviceErrorType("RegisterDeviceErrorTypeInternal", 20, "Internal Server error, try again later");
        RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary = new RegisterDeviceErrorType("RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary", 21, "Failed to register a secondary account because the primary account associated with it was deregistered or not valid any more on server side. The device is deregistered.");
        $VALUES = (new RegisterDeviceErrorType[] {
            RegisterDeviceErrorTypeCustomerNotFound, RegisterDeviceErrorTypeDeviceAlreadyRegistered, RegisterDeviceErrorTypeDeviceNotRegisteredPanda, RegisterDeviceErrorTypeDuplicateDeviceName, RegisterDeviceErrorTypeUnrecognized, RegisterDeviceErrorTypeChallengeResponse, RegisterDeviceErrorTypeMissingValue, RegisterDeviceErrorTypeInvalidValue, RegisterDeviceErrorTypeInvalidTokenPanda, RegisterDeviceErrorTypeProtocolError, 
            RegisterDeviceErrorTypeMethodNotAllowed, RegisterDeviceErrorTypeServerError, RegisterDeviceErrorTypeNotImplemented, RegisterDeviceErrorTypeInvalidDirectedId, RegisterDeviceErrorTypeInvalidDevice, RegisterDeviceErrorTypeUnauthorizedPanda, RegisterDeviceErrorTypeUnrecognizedFirs, RegisterDeviceErrorTypeUnrecognizedKindle, RegisterDeviceErrorTypeUnrecognizedPanda, RegisterDeviceErrorTypeServerUnavailable, 
            RegisterDeviceErrorTypeInternal, RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary
        });
    }
}
