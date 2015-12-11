// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;

public class XuaPluginInitializedValue extends AbstractXuaValue
{

    private String cpuCore;
    private String cpuFamily;
    private String cpuSpeed;
    private String frameworkId;
    private String frameworkVersion;
    private Boolean isNative;
    private String memAmount;
    private String memType;
    private String network;
    private String organization;
    private String osArchitecture;
    private String osId;
    private String osVersion;
    private String playerId;
    private String playerVersion;
    private String screenHeight;
    private String screenWidth;
    private Boolean supportCdvr;
    private Boolean supportLinear;
    private Boolean supportVod;

    public XuaPluginInitializedValue()
    {
    }

    public String getCpuCore()
    {
        return cpuCore;
    }

    public String getCpuFamily()
    {
        return cpuFamily;
    }

    public String getCpuSpeed()
    {
        return cpuSpeed;
    }

    public String getFrameworkId()
    {
        return frameworkId;
    }

    public String getFrameworkVersion()
    {
        return frameworkVersion;
    }

    public String getMemAmount()
    {
        return memAmount;
    }

    public String getMemType()
    {
        return memType;
    }

    public String getNetwork()
    {
        return network;
    }

    public String getOrganization()
    {
        return organization;
    }

    public String getOsArchitecture()
    {
        return osArchitecture;
    }

    public String getOsId()
    {
        return osId;
    }

    public String getOsVersion()
    {
        return osVersion;
    }

    public String getPlayerId()
    {
        return playerId;
    }

    public String getPlayerVersion()
    {
        return playerVersion;
    }

    public String getScreenHeight()
    {
        return screenHeight;
    }

    public String getScreenWidth()
    {
        return screenWidth;
    }

    public void setCpuCore(String s)
    {
        cpuCore = s;
    }

    public void setCpuFamily(String s)
    {
        cpuFamily = s;
    }

    public void setCpuSpeed(String s)
    {
        cpuSpeed = s;
    }

    public void setFrameworkId(String s)
    {
        frameworkId = s;
    }

    public void setFrameworkVersion(String s)
    {
        frameworkVersion = s;
    }

    public void setMemAmount(String s)
    {
        memAmount = s;
    }

    public void setMemType(String s)
    {
        memType = s;
    }

    public void setNative(Boolean boolean1)
    {
        isNative = boolean1;
    }

    public void setNetwork(String s)
    {
        network = s;
    }

    public void setOrganization(String s)
    {
        organization = s;
    }

    public void setOsArchitecture(String s)
    {
        osArchitecture = s;
    }

    public void setOsId(String s)
    {
        osId = s;
    }

    public void setOsVersion(String s)
    {
        osVersion = s;
    }

    public void setPlayerId(String s)
    {
        playerId = s;
    }

    public void setPlayerVersion(String s)
    {
        playerVersion = s;
    }

    public void setScreenHeight(String s)
    {
        screenHeight = s;
    }

    public void setScreenWidth(String s)
    {
        screenWidth = s;
    }

    public void setSupportCdvr(Boolean boolean1)
    {
        supportCdvr = boolean1;
    }

    public void setSupportLinear(Boolean boolean1)
    {
        supportLinear = boolean1;
    }

    public void setSupportVod(Boolean boolean1)
    {
        supportVod = boolean1;
    }
}
