// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hal.model;

import com.comcast.cim.microdata.model.MicrodataLinkValue;
import com.damnhandy.uri.template.UriTemplate;
import java.io.Serializable;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class MicrodataUriTemplate
    implements Serializable
{
    public static class Resolver
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

        public Resolver set(String s, Object obj)
        {
            valueMap.put(s, obj);
            return this;
        }

        private Resolver(String s, String s1)
        {
            valueMap = new HashMap();
            baseUrl = s;
            href = s1;
        }

    }


    private final String baseUrl;
    private final String href;

    public MicrodataUriTemplate(MicrodataLinkValue microdatalinkvalue)
    {
        baseUrl = microdatalinkvalue.getBaseUrl();
        href = microdatalinkvalue.getHref();
    }

    public Resolver createResolver()
    {
        return new Resolver(baseUrl, href);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (MicrodataUriTemplate)obj;
            if (baseUrl == null ? ((MicrodataUriTemplate) (obj)).baseUrl != null : !baseUrl.equals(((MicrodataUriTemplate) (obj)).baseUrl))
            {
                return false;
            }
            if (href == null ? ((MicrodataUriTemplate) (obj)).href != null : !href.equals(((MicrodataUriTemplate) (obj)).href))
            {
                return false;
            }
        }
        return true;
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public String getHref()
    {
        return href;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (baseUrl != null)
        {
            i = baseUrl.hashCode();
        } else
        {
            i = 0;
        }
        if (href != null)
        {
            j = href.hashCode();
        }
        return i * 31 + j;
    }
}
