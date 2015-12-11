// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua;

import java.util.Map;

// Referenced classes of package com.comcast.playerplatform.analytics.java.xua:
//            XuaBaseEvent

public class XuaGenericEvent extends XuaBaseEvent
{

    private Map genericValues;

    public XuaGenericEvent()
    {
    }

    public XuaGenericEvent(long l, String s, Map map)
    {
        timeStamp = l;
        eventName = s;
        genericValues = map;
    }

    public Map getGenericValues()
    {
        return genericValues;
    }

    public void setGenericValues(Map map)
    {
        genericValues = map;
    }
}
