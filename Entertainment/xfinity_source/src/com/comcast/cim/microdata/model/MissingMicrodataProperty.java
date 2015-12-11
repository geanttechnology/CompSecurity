// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import com.comcast.cim.microdata.exception.PropertyNotFoundException;
import java.util.List;

// Referenced classes of package com.comcast.cim.microdata.model:
//            MicrodataProperty, MicrodataItem, MicrodataLinkValue

public class MissingMicrodataProperty
    implements MicrodataProperty
{

    private String name;

    public MissingMicrodataProperty(String s)
    {
        name = s;
    }

    public Boolean asBoolean()
    {
        throw new PropertyNotFoundException((new StringBuilder()).append("Could not find property ").append(name).toString());
    }

    public Boolean asBoolean(Boolean boolean1)
    {
        return boolean1;
    }

    public Integer asInt()
    {
        throw new PropertyNotFoundException((new StringBuilder()).append("Could not find property ").append(name).toString());
    }

    public Integer asInt(Integer integer)
    {
        return integer;
    }

    public MicrodataItem asItem()
    {
        throw new PropertyNotFoundException((new StringBuilder()).append("Could not find property ").append(name).toString());
    }

    public List asItems()
    {
        throw new PropertyNotFoundException((new StringBuilder()).append("Could not find property ").append(name).toString());
    }

    public MicrodataLinkValue asLink()
    {
        throw new PropertyNotFoundException((new StringBuilder()).append("Could not find property ").append(name).toString());
    }

    public List asList()
    {
        throw new PropertyNotFoundException((new StringBuilder()).append("Could not find property ").append(name).toString());
    }

    public List asList(List list)
    {
        return list;
    }

    public String asString()
    {
        throw new PropertyNotFoundException((new StringBuilder()).append("Could not find property ").append(name).toString());
    }

    public String asString(String s)
    {
        return s;
    }

    public String getName()
    {
        return name;
    }

    public Object getValue()
    {
        return null;
    }

    public List getValues()
    {
        return null;
    }

    public boolean isCollection()
    {
        return false;
    }

    public boolean isEmbedded()
    {
        return false;
    }

    public boolean isMissing()
    {
        return true;
    }
}
