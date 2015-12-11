// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaPluginInitializedValue;

public class PluginInitializedMessage extends AbstractXMessageBuilder
{

    private final long evtTimestamp;
    private final AbstractXuaValue xuaValue;

    public PluginInitializedMessage(long l, XuaPluginInitializedValue xuaplugininitializedvalue)
    {
        evtTimestamp = l;
        xuaValue = xuaplugininitializedvalue;
    }

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaPluginInitialized.name(), xuaValue);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        getMessage().setValue(xuaValue);
    }
}
