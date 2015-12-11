// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaPlayStateChangedValue;

public class PlayStateChangedMessage extends AbstractXMessageBuilder
{

    private long evtTimestamp;
    private String playerState;
    private AbstractXuaAsset xuaAsset;

    public PlayStateChangedMessage(long l, String s, AbstractXuaAsset abstractxuaasset)
    {
        evtTimestamp = l;
        playerState = s;
        xuaAsset = abstractxuaasset;
    }

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaPlayStateChanged.name(), getMessage().getValue());
        xuaevent.setAsset(xuaAsset);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaPlayStateChangedValue xuaplaystatechangedvalue = new XuaPlayStateChangedValue();
        xuaplaystatechangedvalue.setValue(playerState);
        getMessage().setValue(xuaplaystatechangedvalue);
    }
}
