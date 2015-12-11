// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.util.events;

import java.util.HashMap;
import tv.freewheel.ad.interfaces.IEvent;

public class Event
    implements IEvent
{

    public int code;
    public HashMap data;
    public String type;

    public Event(String s)
    {
        type = s;
        data = new HashMap();
    }

    public Event(String s, int i)
    {
        this(s);
        code = i;
    }

    public Event(String s, int i, String s1)
    {
        this(s);
        code = i;
        data.put("message", s1);
    }

    public Event(String s, String s1)
    {
        this(s);
        data.put("message", s1);
    }

    public Event(String s, HashMap hashmap)
    {
        this(s);
        data = hashmap;
    }

    public HashMap getData()
    {
        return data;
    }

    public String getType()
    {
        return type;
    }
}
