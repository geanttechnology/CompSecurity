// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;


// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

static class egistrationError
{

    static final int $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[];

    static 
    {
        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError = new int[com.amazon.identity.auth.device.api.RegistrationError.values().length];
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.RegistrationError.AUTHENTICATION_FAILED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.RegistrationError.CUSTOMER_NOT_FOUND.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.RegistrationError.NETWORK_FAILURE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.RegistrationError.ALREADY_DEREGISTERED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.RegistrationError.BAD_REQUEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.RegistrationError.BAD_SECRET.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.RegistrationError.DEREGISTER_FAILED.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.RegistrationError.DEVICE_ALREADY_REGISTERED.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.RegistrationError.DUPLICATE_DEVICE_NAME.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.RegistrationError.NO_ACCOUNT.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.RegistrationError.PARSE_ERROR.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.RegistrationError.REGISTER_FAILED.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.RegistrationError.UNRECOGNIZED.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
