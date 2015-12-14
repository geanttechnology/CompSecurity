// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.oauth;


public class OAuth1FlowException extends Exception
{

    private static final long serialVersionUID = 0x3b4b8b79b1ad87c7L;
    private final String description;
    private final int errorCode;
    private final String failingUrl;

    public OAuth1FlowException(int i, String s, String s1)
    {
        super(String.format("OAuth Flow Error %d: Url: %s Description: %s", new Object[] {
            Integer.valueOf(i), s1, s
        }));
        errorCode = i;
        description = s;
        failingUrl = s1;
    }

    public String getDescription()
    {
        return description;
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    public String getFailingUrl()
    {
        return failingUrl;
    }
}
