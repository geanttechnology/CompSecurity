// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaTrickPlayValue;

public class TrickPlayMessage extends AbstractXMessageBuilder
{

    private long currentPosition;
    private long evtTimestamp;
    private String trickPlayType;
    private AbstractXuaAsset xuaAsset;

    public TrickPlayMessage(long l, long l1, String s, AbstractXuaAsset abstractxuaasset)
    {
        evtTimestamp = l;
        currentPosition = l1;
        trickPlayType = s;
        xuaAsset = abstractxuaasset;
    }

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaTrickPlay.name(), getMessage().getValue());
        xuaevent.setTimeStamp(evtTimestamp);
        xuaevent.setEventName(XuaEventType.xuaTrickPlay.name());
        xuaevent.setValue(getMessage().getValue());
        xuaevent.setAsset(xuaAsset);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaTrickPlayValue xuatrickplayvalue = new XuaTrickPlayValue();
        xuatrickplayvalue.setPosition(currentPosition);
        xuatrickplayvalue.setType(trickPlayType);
        getMessage().setValue(xuatrickplayvalue);
    }
}
