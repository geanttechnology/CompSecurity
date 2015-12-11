// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            RenameDeviceErrorType

public class RenameDeviceError
{

    private final String mErrorText;
    private final RenameDeviceErrorType mErrorType;

    public RenameDeviceError(RenameDeviceErrorType renamedeviceerrortype, String s)
    {
        mErrorType = renamedeviceerrortype;
        mErrorText = s;
    }

    public String getErrorText()
    {
        return mErrorText;
    }

    public RenameDeviceErrorType getType()
    {
        return mErrorType;
    }
}
