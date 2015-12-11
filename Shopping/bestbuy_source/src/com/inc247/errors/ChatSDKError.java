// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247.errors;


// Referenced classes of package com.inc247.errors:
//            ChatSDKErrorCodes

public class ChatSDKError
{

    private int errorCode;
    private String errorMsg;

    public ChatSDKError(ChatSDKErrorCodes chatsdkerrorcodes)
    {
        errorMsg = chatsdkerrorcodes.getMsg();
        errorCode = chatsdkerrorcodes.getId();
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }
}
