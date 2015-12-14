// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            RegisterDeviceErrorType

public class RegisterDeviceError
{

    private final RegisterDeviceErrorType mErrorType;

    public RegisterDeviceError(RegisterDeviceErrorType registerdeviceerrortype)
    {
        mErrorType = registerdeviceerrortype;
    }

    public RegisterDeviceErrorType getType()
    {
        return mErrorType;
    }
}
