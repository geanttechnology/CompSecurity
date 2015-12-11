// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaFragmentWarningValue;

public class FragmentWarningMessage extends AbstractXMessageBuilder
{

    private int downloadDuration;
    private int downloadLatency;
    private long evtTimestamp;
    private int fragmentDuration;
    private int fragmentSize;
    private String fragmentUrl;
    private AbstractXuaAsset xuaAsset;

    public FragmentWarningMessage(long l, AbstractXuaAsset abstractxuaasset, String s, int i, int j, int k, 
            int i1)
    {
        evtTimestamp = l;
        xuaAsset = abstractxuaasset;
        fragmentUrl = s;
        fragmentSize = i;
        downloadLatency = j;
        downloadDuration = k;
        fragmentDuration = i1;
    }

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaFragmentWarning.name(), getMessage().getValue());
        xuaevent.setAsset(xuaAsset);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaFragmentWarningValue xuafragmentwarningvalue = new XuaFragmentWarningValue(fragmentUrl, fragmentSize, downloadLatency, downloadDuration, fragmentDuration);
        getMessage().setValue(xuafragmentwarningvalue);
    }
}
