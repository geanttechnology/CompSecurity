// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.client;

import com.comcast.cim.microdata.deserialization.HalToMicrodataConverter;
import com.comcast.cim.microdata.deserialization.MicrodataDeserializer;
import com.comcast.cim.microdata.deserialization.MicrodataModelFactory;
import com.comcast.cim.microdata.deserialization.ResourceMicrodataModelFactory;
import com.comcast.cim.microdata.exception.MicrodataConversionException;
import com.comcast.cim.microdata.http.HttpRequester;
import com.comcast.cim.microdata.model.MicrodataItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;

// Referenced classes of package com.comcast.cim.microdata.client:
//            HypermediaClient

public class HypermediaClientImpl
    implements HypermediaClient
{

    private boolean automaticNetworkLoadingEnabled;
    private String defaultAcceptContentType;
    private HttpRequester httpRequester;
    private ObjectMapper objectMapper;

    public HypermediaClientImpl()
    {
        automaticNetworkLoadingEnabled = true;
        defaultAcceptContentType = "application/hal+json";
        objectMapper = new ObjectMapper();
    }

    private MicrodataDeserializer buildDeserializer(String s, MicrodataModelFactory microdatamodelfactory)
    {
        return new HalToMicrodataConverter(objectMapper, microdatamodelfactory);
    }

    private MicrodataModelFactory buildModelFactory(String s)
    {
        return new ResourceMicrodataModelFactory(this, s);
    }

    public String getDefaultAcceptContentType()
    {
        return defaultAcceptContentType;
    }

    public HttpRequester getHttpRequester()
    {
        return httpRequester;
    }

    public boolean isAutomaticNetworkLoadingEnabled()
    {
        return automaticNetworkLoadingEnabled;
    }

    public MicrodataItem parseResource(String s, InputStream inputstream, String s1)
        throws MicrodataConversionException
    {
        return buildDeserializer(s1, buildModelFactory(s)).convert(inputstream);
    }

    public void setAutomaticNetworkLoadingEnabled(boolean flag)
    {
        automaticNetworkLoadingEnabled = flag;
    }

    public void setDefaultAcceptContentType(String s)
    {
        defaultAcceptContentType = s;
    }

    public void setHttpRequester(HttpRequester httprequester)
    {
        httpRequester = httprequester;
    }
}
