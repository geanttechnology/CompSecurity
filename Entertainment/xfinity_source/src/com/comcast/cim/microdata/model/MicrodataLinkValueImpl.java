// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import com.comcast.cim.microdata.util.SimpleToStringBuilder;
import com.damnhandy.uri.template.UriTemplate;
import java.net.URI;
import java.util.Map;

// Referenced classes of package com.comcast.cim.microdata.model:
//            MicrodataLinkValue, MicrodataContext

public class MicrodataLinkValueImpl
    implements MicrodataLinkValue
{

    private String contentType;
    private MicrodataContext context;
    private String href;
    private String name;
    private boolean templated;
    private String title;

    public MicrodataLinkValueImpl(String s, String s1, String s2, boolean flag, String s3)
    {
        href = s;
        name = s1;
        title = s2;
        templated = flag;
        contentType = s3;
    }

    public String getBaseUrl()
    {
        if (context == null || context.getBaseUrl() == null)
        {
            throw new IllegalStateException("Attempted to get BaseUrl with no root context/baseUrl");
        } else
        {
            return context.getBaseUrl();
        }
    }

    public String getContentType()
    {
        return contentType;
    }

    public String getHref()
    {
        return href;
    }

    public String getName()
    {
        return name;
    }

    public String getTitle()
    {
        return title;
    }

    public boolean isTemplated()
    {
        return templated;
    }

    public URI resolve()
    {
        if (context == null || context.getBaseUrl() == null)
        {
            throw new IllegalStateException("Attempted to resolve link with no root context/baseUrl");
        } else
        {
            return URI.create(context.getBaseUrl()).resolve(href);
        }
    }

    public URI resolve(Map map)
    {
        if (context == null || context.getBaseUrl() == null)
        {
            throw new IllegalStateException("Attempted to resolve link with no root context/baseUrl");
        } else
        {
            return URI.create(context.getBaseUrl()).resolve(UriTemplate.fromTemplate(href).expand(map));
        }
    }

    public void setContext(MicrodataContext microdatacontext)
    {
        context = microdatacontext;
    }

    public String toString()
    {
        SimpleToStringBuilder simpletostringbuilder = new SimpleToStringBuilder(this);
        simpletostringbuilder.append("name", name);
        simpletostringbuilder.append("title", title);
        simpletostringbuilder.append("href", href);
        simpletostringbuilder.append("templated", templated);
        return simpletostringbuilder.toString();
    }
}
