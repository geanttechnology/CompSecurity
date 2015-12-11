// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics:
//            ITrackable

public class AppTrackable
    implements ITrackable
{

    private Hashtable contextData;
    private ArrayList evars;
    private ArrayList events;
    private String name;
    private ArrayList props;

    public AppTrackable()
    {
        name = "TRACKER";
    }

    public void addContext(String s, Object obj)
    {
        if (contextData == null)
        {
            contextData = new Hashtable();
        }
        contextData.put(s, obj);
    }

    public void addEvar(int i, String s)
    {
        if (evars == null)
        {
            evars = new ArrayList();
        }
        evars.add(new BasicNameValuePair((new StringBuilder()).append(i).append("").toString(), s));
    }

    public void addEvent(String s)
    {
        if (events == null)
        {
            events = new ArrayList();
        }
        events.add(s);
    }

    public void addProp(int i, String s)
    {
        if (props == null)
        {
            props = new ArrayList();
        }
        props.add(new BasicNameValuePair((new StringBuilder()).append(i).append("").toString(), s));
    }

    public Hashtable getContextData()
    {
        return contextData;
    }

    public volatile Map getContextData()
    {
        return getContextData();
    }

    public ArrayList getEvars()
    {
        return evars;
    }

    public volatile List getEvars()
    {
        return getEvars();
    }

    public ArrayList getEvents()
    {
        return events;
    }

    public volatile List getEvents()
    {
        return getEvents();
    }

    public String getName()
    {
        return name;
    }

    public ArrayList getProps()
    {
        return props;
    }

    public volatile List getProps()
    {
        return getProps();
    }

    public void setName(String s)
    {
        name = s;
    }
}
