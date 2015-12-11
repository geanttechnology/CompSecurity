// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaFPSChangedValue;

public class FPSChangedMessage extends AbstractXMessageBuilder
{

    private long evtTimestamp;
    private float fps;
    private AbstractXuaAsset xuaAsset;

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaFPSChanged.name(), getMessage().getValue());
        xuaevent.setAsset(xuaAsset);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaFPSChangedValue xuafpschangedvalue = new XuaFPSChangedValue();
        xuafpschangedvalue.setValue(fps);
        getMessage().setValue(xuafpschangedvalue);
    }
}
