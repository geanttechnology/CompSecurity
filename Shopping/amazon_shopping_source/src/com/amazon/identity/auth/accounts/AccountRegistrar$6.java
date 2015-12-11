// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.kcpsdk.auth.DeregisterDeviceErrorType;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceErrorType;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountRegistrar

static class pe
{

    static final int $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[];
    static final int $SwitchMap$com$amazon$identity$kcpsdk$auth$DeregisterDeviceErrorType[];
    static final int $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[];

    static 
    {
        $SwitchMap$com$amazon$identity$kcpsdk$auth$DeregisterDeviceErrorType = new int[DeregisterDeviceErrorType.values().length];
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$DeregisterDeviceErrorType[DeregisterDeviceErrorType.DeregisterDeviceErrorTypeFailed.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror25) { }
        $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType = new int[RegistrationType.values().length];
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.WITH_LOGIN_CREDENTIALS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror24) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.WITH_DEVICE_SECRET.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror23) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.FROM_ATMAIN.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror22) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.FROM_AUTH_TOKEN.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror21) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.FROM_ACCESS_TOKEN.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror20) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.WITH_EXPLICIT_URL.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror19) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.REGISTER_DELEGATED_ACCOUNT.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.WITH_DIRECTEDID_CREDENTIALS.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType = new int[RegisterDeviceErrorType.values().length];
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeCustomerNotFound.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeDeviceAlreadyRegistered.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeDuplicateDeviceName.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeChallengeResponse.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeMissingValue.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeInvalidValue.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeProtocolError.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeMethodNotAllowed.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeServerError.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeNotImplemented.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeInvalidDirectedId.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeInvalidDevice.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeServerUnavailable.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeUnauthorizedPanda.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeInvalidTokenPanda.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeDeviceNotRegisteredPanda.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary.ordinal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
