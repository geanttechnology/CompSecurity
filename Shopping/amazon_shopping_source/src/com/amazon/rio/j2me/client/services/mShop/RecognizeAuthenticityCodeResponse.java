// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class RecognizeAuthenticityCodeResponse
{

    private String codeType;
    private String landingUrl;

    public RecognizeAuthenticityCodeResponse()
    {
    }

    public String getCodeType()
    {
        return codeType;
    }

    public String getLandingUrl()
    {
        return landingUrl;
    }

    public void setCodeType(String s)
    {
        codeType = s;
    }

    public void setLandingUrl(String s)
    {
        landingUrl = s;
    }
}
