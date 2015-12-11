// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaBitrateChangedValue;

public class BitrateChangedMessage extends AbstractXMessageBuilder
{

    private long bitrate;
    private long evtTimestamp;
    private AbstractXuaAsset xuaAsset;

    public BitrateChangedMessage(long l, long l1, AbstractXuaAsset abstractxuaasset)
    {
        evtTimestamp = l;
        bitrate = l1;
        xuaAsset = abstractxuaasset;
    }

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaBitrateChanged.name(), getMessage().getValue());
        xuaevent.setAsset(xuaAsset);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaBitrateChangedValue xuabitratechangedvalue = new XuaBitrateChangedValue();
        xuabitratechangedvalue.setValue(bitrate);
        getMessage().setValue(xuabitratechangedvalue);
    }
}
