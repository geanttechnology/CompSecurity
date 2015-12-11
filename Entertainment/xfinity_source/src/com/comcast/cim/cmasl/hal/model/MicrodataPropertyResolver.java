// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hal.model;

import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.microdata.model.MicrodataItem;
import com.comcast.cim.microdata.model.MicrodataLinkValue;
import com.comcast.cim.microdata.model.MicrodataProperty;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.comcast.cim.cmasl.hal.model:
//            MicrodataUriTemplate

public class MicrodataPropertyResolver
{

    private MicrodataItem halResource;

    public MicrodataPropertyResolver(MicrodataItem microdataitem)
    {
        halResource = microdataitem;
    }

    public MicrodataPropertyResolver copy(MicrodataItem microdataitem)
    {
        return new MicrodataPropertyResolver(microdataitem);
    }

    public boolean fetchBoolean(String s)
    {
        return getProperty(s).asBoolean().booleanValue();
    }

    public int fetchInt(String s)
    {
        return getProperty(s).asInt().intValue();
    }

    public MicrodataItem fetchItem(String s)
    {
        return getProperty(s).asItem();
    }

    public String fetchLinkAsString(String s)
    {
        return getProperty(s).asLink().resolve().toString();
    }

    public MicrodataUriTemplate fetchLinkAsUriTemplate(String s)
    {
        return new MicrodataUriTemplate(getProperty(s).asLink());
    }

    public List fetchList(String s)
    {
        return (List)CommonUtils.uncheckedCast(getProperty(s).asList());
    }

    public boolean fetchOptionalBoolean(String s, boolean flag)
    {
        return getProperty(s).asBoolean(Boolean.valueOf(flag)).booleanValue();
    }

    public int fetchOptionalInt(String s, int i)
    {
        return getProperty(s).asInt(Integer.valueOf(i)).intValue();
    }

    public MicrodataItem fetchOptionalItem(String s)
    {
        s = getProperty(s);
        if (s.isMissing())
        {
            return null;
        } else
        {
            return s.asItem();
        }
    }

    public List fetchOptionalItemList(String s)
    {
        s = getProperty(s);
        if (s.isMissing())
        {
            return new ArrayList();
        } else
        {
            return s.asItems();
        }
    }

    public String fetchOptionalLinkAsString(String s)
    {
        s = getProperty(s);
        if (s.isMissing())
        {
            return null;
        } else
        {
            return s.asLink().resolve().toString();
        }
    }

    public List fetchOptionalList(String s)
    {
        return (List)CommonUtils.uncheckedCast(getProperty(s).asList(null));
    }

    public String fetchOptionalString(String s)
    {
        return getProperty(s).asString(null);
    }

    public String fetchString(String s)
    {
        return getProperty(s).asString();
    }

    public MicrodataProperty getProperty(String s)
    {
        return halResource.get(s, false);
    }
}
