// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class UpgradeInfo
{

    private Boolean critical;
    private String message;
    private String newVersion;
    private String uniqueId;

    public UpgradeInfo()
    {
    }

    public String getUniqueId()
    {
        return uniqueId;
    }

    public void setCritical(Boolean boolean1)
    {
        critical = boolean1;
    }

    public void setMessage(String s)
    {
        message = s;
    }

    public void setNewVersion(String s)
    {
        newVersion = s;
    }

    public void setUniqueId(String s)
    {
        uniqueId = s;
    }
}
