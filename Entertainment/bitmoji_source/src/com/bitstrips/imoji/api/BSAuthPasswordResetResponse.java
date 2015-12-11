// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.api;


public class BSAuthPasswordResetResponse
{

    String token;

    BSAuthPasswordResetResponse(String s)
    {
        token = s;
    }

    public String getPasswordResetToken()
    {
        return token;
    }
}
