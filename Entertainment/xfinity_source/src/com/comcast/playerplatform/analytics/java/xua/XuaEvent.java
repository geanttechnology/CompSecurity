// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua;


// Referenced classes of package com.comcast.playerplatform.analytics.java.xua:
//            XuaBaseEvent, AbstractXuaValue

public class XuaEvent extends XuaBaseEvent
{

    private AbstractXuaValue value;

    public XuaEvent()
    {
    }

    public XuaEvent(long l, String s, AbstractXuaValue abstractxuavalue)
    {
        timeStamp = l;
        eventName = s;
        value = abstractxuavalue;
    }

    public AbstractXuaValue getValue()
    {
        return value;
    }

    public void setValue(AbstractXuaValue abstractxuavalue)
    {
        value = abstractxuavalue;
    }
}
