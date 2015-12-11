// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaMediaInfoValue;

public class MediaInfoMessage extends AbstractXMessageBuilder
{

    private String description;
    private long evtTimestamp;
    private int position;
    private AbstractXuaAsset xuaAsset;

    public MediaInfoMessage(long l, int i, String s, AbstractXuaAsset abstractxuaasset)
    {
        evtTimestamp = l;
        position = i;
        description = s;
        xuaAsset = abstractxuaasset;
    }

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaMediaInfo.name(), getMessage().getValue());
        xuaevent.setAsset(xuaAsset);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaMediaInfoValue xuamediainfovalue = new XuaMediaInfoValue(position, description);
        getMessage().setValue(xuamediainfovalue);
    }
}
