// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages.dvr;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.values.XuaDvrManagementValue;

public class DvrManagementMessage extends AbstractXMessageBuilder
{

    private String count;
    private String eventName;
    private long evtTimestamp;
    private String type;
    private AbstractXuaAsset xuaAsset;

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, eventName, getMessage().getValue());
        xuaevent.setAsset(xuaAsset);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaDvrManagementValue xuadvrmanagementvalue = new XuaDvrManagementValue(count, type);
        getMessage().setValue(xuadvrmanagementvalue);
    }
}
