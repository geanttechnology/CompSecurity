// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.error;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.error:
//            ErrorCode

public class AndroidSDKException extends Exception
{

    private ErrorCode errorCode;

    public AndroidSDKException(ErrorCode errorcode)
    {
        super(errorcode.getReason());
        errorCode = errorcode;
    }

    public AndroidSDKException(ErrorCode errorcode, String s)
    {
        super(s);
        errorCode = errorcode;
    }

    public AndroidSDKException(ErrorCode errorcode, Throwable throwable)
    {
        super(errorcode.getReason(), throwable);
        errorCode = errorcode;
    }

    public ErrorCode getErrorCode()
    {
        return errorCode;
    }
}
