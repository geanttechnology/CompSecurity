// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hal.model;

import com.damnhandy.uri.template.UriTemplate;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.comcast.cim.cmasl.hal.model:
//            MicrodataUriTemplate

public static class <init>
{

    private final String baseUrl;
    private final String href;
    private Map valueMap;

    public String resolve()
    {
        if (baseUrl == null)
        {
            return null;
        }
        if (href == null)
        {
            return baseUrl;
        } else
        {
            return URI.create(baseUrl).resolve(UriTemplate.fromTemplate(href).expand(valueMap)).toString();
        }
    }

    public valueMap set(String s, Object obj)
    {
        valueMap.put(s, obj);
        return this;
    }

    private (String s, String s1)
    {
        valueMap = new HashMap();
        baseUrl = s;
        href = s1;
    }

    href(String s, String s1, href href1)
    {
        this(s, s1);
    }
}
