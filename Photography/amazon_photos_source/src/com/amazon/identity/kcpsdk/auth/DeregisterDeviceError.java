// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            DeregisterDeviceErrorType

public class DeregisterDeviceError
{

    private final DeregisterDeviceErrorType mErrorType;

    public DeregisterDeviceError(DeregisterDeviceErrorType deregisterdeviceerrortype)
    {
        mErrorType = deregisterdeviceerrortype;
    }

    public DeregisterDeviceErrorType getType()
    {
        return mErrorType;
    }
}
