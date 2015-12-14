// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            PandaRegisterDeviceResponseJsonParser, PandaError

static class 
{

    static final int $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError[];

    static 
    {
        $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError = new int[PandaError.values().length];
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError[PandaError.PandaErrorMissingValue.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError[PandaError.PandaErrorCredentialError.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError[PandaError.PandaErrorInvalidValue.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError[PandaError.PandaErrorServerError.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError[PandaError.PandaErrorServiceUnavailable.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError[PandaError.PandaErrorUnknown.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
