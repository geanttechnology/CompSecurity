// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.api;


public class BSAuthResponse
{

    String access_token;

    public BSAuthResponse()
    {
    }

    public BSAuthResponse(String s)
    {
        access_token = s;
    }

    public String getAccessToken()
    {
        return access_token;
    }
}
