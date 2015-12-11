// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;


// Referenced classes of package com.xfinity.playerlib.authorization:
//            VideoSession

public class VideoContinue
    implements VideoSession
{

    private final String errorMessage;
    private final String statusCode;

    public VideoContinue(String s, String s1)
    {
        errorMessage = s;
        statusCode = s1;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public String getStatusCode()
    {
        return statusCode;
    }
}
