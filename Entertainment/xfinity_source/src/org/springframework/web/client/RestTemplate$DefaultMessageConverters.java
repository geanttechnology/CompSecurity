// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.client;

import java.util.List;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.feed.SyndFeedHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.http.converter.xml.XmlAwareFormHttpMessageConverter;
import org.springframework.util.ClassUtils;

// Referenced classes of package org.springframework.web.client:
//            RestTemplate

private static class erter
{

    private static final boolean jacksonPresent;
    private static final boolean javaxXmlTransformPresent = ClassUtils.isPresent("javax.xml.transform.Source", org/springframework/web/client/RestTemplate.getClassLoader());
    private static final boolean romePresent = ClassUtils.isPresent("com.google.code.rome.android.repackaged.com.sun.syndication.feed.synd.SyndFeed", org/springframework/web/client/RestTemplate.getClassLoader());
    private static final boolean simpleXmlPresent = ClassUtils.isPresent("org.simpleframework.xml.Serializer", org/springframework/web/client/RestTemplate.getClassLoader());

    public static void init(List list)
    {
        list.add(new ByteArrayHttpMessageConverter());
        list.add(new StringHttpMessageConverter());
        list.add(new ResourceHttpMessageConverter());
        if (javaxXmlTransformPresent)
        {
            list.add(new SourceHttpMessageConverter());
            list.add(new XmlAwareFormHttpMessageConverter());
        } else
        {
            list.add(new FormHttpMessageConverter());
        }
        if (simpleXmlPresent)
        {
            list.add(new SimpleXmlHttpMessageConverter());
        }
        if (jacksonPresent)
        {
            list.add(new MappingJacksonHttpMessageConverter());
        }
        if (romePresent)
        {
            list.add(new SyndFeedHttpMessageConverter());
        }
    }

    static 
    {
        boolean flag;
        if (ClassUtils.isPresent("org.codehaus.jackson.map.ObjectMapper", org/springframework/web/client/RestTemplate.getClassLoader()) && ClassUtils.isPresent("org.codehaus.jackson.JsonGenerator", org/springframework/web/client/RestTemplate.getClassLoader()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        jacksonPresent = flag;
    }
}
