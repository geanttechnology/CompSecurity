// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;


// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticationMethodFactory, AuthenticationType

static class 
{

    static final int $SwitchMap$com$amazon$identity$auth$device$api$AuthenticationType[];

    static 
    {
        $SwitchMap$com$amazon$identity$auth$device$api$AuthenticationType = new int[AuthenticationType.values().length];
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$AuthenticationType[AuthenticationType.ADPAuthenticator.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$AuthenticationType[AuthenticationType.DeviceAuthenticator.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$AuthenticationType[AuthenticationType.OAuth.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$AuthenticationType[AuthenticationType.None.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
