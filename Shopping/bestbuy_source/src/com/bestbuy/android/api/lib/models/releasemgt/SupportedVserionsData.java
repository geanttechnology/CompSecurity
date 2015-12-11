// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.releasemgt;

import gu;
import java.io.Serializable;

public class SupportedVserionsData
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String currentVersion;
    private String currentVersionMessage;
    private String minimumSupportedVersion;

    public SupportedVserionsData()
    {
    }

    public String getCurrentVersion()
    {
        return currentVersion;
    }

    public String getCurrentVersionMessage()
    {
        return currentVersionMessage;
    }

    public String getMinimumSupportedVersion()
    {
        return minimumSupportedVersion;
    }

    public void setCurrentVersion(String s)
    {
        currentVersion = s;
    }

    public void setCurrentVersionMessage(String s)
    {
        currentVersionMessage = s;
    }

    public void setMinimumSupportedVersion(String s)
    {
        minimumSupportedVersion = s;
    }
}
