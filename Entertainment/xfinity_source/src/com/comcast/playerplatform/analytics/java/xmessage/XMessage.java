// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;
import com.comcast.playerplatform.analytics.java.xua.XuaApplicationInfo;
import com.comcast.playerplatform.analytics.java.xua.XuaBaseEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaDeviceInfo;
import com.comcast.playerplatform.analytics.java.xua.XuaMessage;
import com.comcast.playerplatform.analytics.java.xua.XuaSessionInfo;

public class XMessage
{

    private XuaApplicationInfo applicationInfo;
    private AbstractXuaAsset asset;
    private XuaDeviceInfo deviceInfo;
    private XuaBaseEvent event;
    private String protocol;
    private XuaSessionInfo sessionInfo;
    private AbstractXuaValue value;

    public XMessage()
    {
    }

    public XuaApplicationInfo getApplicationInfo()
    {
        return applicationInfo;
    }

    public AbstractXuaAsset getAsset()
    {
        return asset;
    }

    public XuaDeviceInfo getDeviceInfo()
    {
        return deviceInfo;
    }

    public XuaBaseEvent getEvent()
    {
        return event;
    }

    public XuaMessage getFormattedMessage()
    {
        return new XuaMessage(protocol, applicationInfo, deviceInfo, sessionInfo, event);
    }

    public XuaSessionInfo getSessionInfo()
    {
        return sessionInfo;
    }

    public AbstractXuaValue getValue()
    {
        return value;
    }

    public void setApplicationInfo(XuaApplicationInfo xuaapplicationinfo)
    {
        applicationInfo = xuaapplicationinfo;
    }

    public void setAsset(AbstractXuaAsset abstractxuaasset)
    {
        asset = abstractxuaasset;
    }

    public void setDeviceInfo(XuaDeviceInfo xuadeviceinfo)
    {
        deviceInfo = xuadeviceinfo;
    }

    public void setEvent(XuaBaseEvent xuabaseevent)
    {
        event = xuabaseevent;
    }

    public void setProtocol(String s)
    {
        protocol = s;
    }

    public void setSessionInfo(XuaSessionInfo xuasessioninfo)
    {
        sessionInfo = xuasessioninfo;
    }

    public void setValue(AbstractXuaValue abstractxuavalue)
    {
        value = abstractxuavalue;
    }
}
