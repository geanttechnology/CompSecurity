// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaScrubValue;

public class ScrubMessageStarted extends AbstractXMessageBuilder
{

    private long currentPosition;
    private long evtTimestamp;
    private AbstractXuaAsset xuaAsset;

    public ScrubMessageStarted(long l, long l1, AbstractXuaAsset abstractxuaasset)
    {
        evtTimestamp = l;
        currentPosition = l1;
        xuaAsset = abstractxuaasset;
    }

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaScrubStarted.name(), getMessage().getValue());
        xuaevent.setAsset(xuaAsset);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaScrubValue xuascrubvalue = new XuaScrubValue();
        xuascrubvalue.setPosition(currentPosition);
        getMessage().setValue(xuascrubvalue);
    }
}
