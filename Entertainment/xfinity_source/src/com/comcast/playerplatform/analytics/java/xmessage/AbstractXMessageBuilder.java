// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage;


// Referenced classes of package com.comcast.playerplatform.analytics.java.xmessage:
//            XMessage

public abstract class AbstractXMessageBuilder
{

    private XMessage message;

    public AbstractXMessageBuilder()
    {
    }

    public void buildNewMessage()
    {
        message = new XMessage();
    }

    public void buildXuaAsset()
    {
    }

    public void buildXuaEvent()
    {
    }

    public void buildXuaValue()
    {
    }

    public XMessage getMessage()
    {
        return message;
    }
}
