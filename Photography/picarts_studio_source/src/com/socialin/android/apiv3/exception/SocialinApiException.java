// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.exception;


public class SocialinApiException extends RuntimeException
{

    private static final long serialVersionUID = 1L;
    private String reason;
    private String status;

    public SocialinApiException(String s, String s1, String s2)
    {
        super(s1);
        status = "";
        reason = "";
        status = s;
        reason = s2;
    }

    public String getReason()
    {
        return reason;
    }

    public String getStatus()
    {
        return status;
    }
}
