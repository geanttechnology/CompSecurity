// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;


// Referenced classes of package com.amazon.gallery.thor.app.authentication:
//            BlockingTokenAccessor

static class rorType
{

    static final int $SwitchMap$com$amazon$gallery$thor$app$authentication$BlockingTokenAccessor$ErrorType[];
    static final int $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[];

    static 
    {
        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError = new int[com.amazon.identity.auth.device.api.rationError.values().length];
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.rationError.NETWORK_FAILURE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        $SwitchMap$com$amazon$gallery$thor$app$authentication$BlockingTokenAccessor$ErrorType = new int[rorType.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$thor$app$authentication$BlockingTokenAccessor$ErrorType[rorType.AUTH_ERROR.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
