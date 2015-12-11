// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaKeyEventValue;

public class KeyMessage extends AbstractXMessageBuilder
{

    private long evtTimestamp;
    private String keyValue;

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaKeyEvent.name(), getMessage().getValue());
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaKeyEventValue xuakeyeventvalue = new XuaKeyEventValue();
        xuakeyeventvalue.setValue(keyValue);
        getMessage().setValue(xuakeyeventvalue);
    }
}
