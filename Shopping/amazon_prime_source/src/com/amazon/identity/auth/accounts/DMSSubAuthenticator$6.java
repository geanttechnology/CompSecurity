// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.kcpsdk.auth.RegisterDeviceErrorType;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            DMSSubAuthenticator

static class 
{

    static final int $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[];

    static 
    {
        $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType = new int[RegisterDeviceErrorType.values().length];
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeCustomerNotFound.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeDeviceAlreadyRegistered.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeDuplicateDeviceName.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeUnrecognized.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeUnrecognizedFirs.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeUnrecognizedKindle.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeUnrecognizedPanda.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
