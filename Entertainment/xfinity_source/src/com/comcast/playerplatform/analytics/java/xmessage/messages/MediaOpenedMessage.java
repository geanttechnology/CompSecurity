// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaMediaOpenedValue;

public class MediaOpenedMessage extends AbstractXMessageBuilder
{

    private Long channelOpenningLatency;
    private long currentPosition;
    private long evtTimestamp;
    private String manifestUrl;
    private AbstractXuaAsset xuaAsset;

    public MediaOpenedMessage(long l, Long long1, long l1, String s, AbstractXuaAsset abstractxuaasset)
    {
        evtTimestamp = l;
        channelOpenningLatency = long1;
        currentPosition = l1;
        manifestUrl = s;
        xuaAsset = abstractxuaasset;
    }

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaMediaOpened.name(), getMessage().getValue());
        xuaevent.setAsset(xuaAsset);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaMediaOpenedValue xuamediaopenedvalue = new XuaMediaOpenedValue(currentPosition, channelOpenningLatency, manifestUrl);
        getMessage().setValue(xuamediaopenedvalue);
    }
}
