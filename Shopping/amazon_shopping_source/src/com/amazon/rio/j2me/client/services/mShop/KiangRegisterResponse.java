// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class KiangRegisterResponse
{

    private String applicationInstallId;
    private String secret;

    public KiangRegisterResponse()
    {
    }

    public String getApplicationInstallId()
    {
        return applicationInstallId;
    }

    public String getSecret()
    {
        return secret;
    }

    public void setApplicationInstallId(String s)
    {
        applicationInstallId = s;
    }

    public void setSecret(String s)
    {
        secret = s;
    }
}
