// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service.resttemplate;

import java.util.List;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.service.resttemplate:
//            AsyncRestTemplate

public class RestTemplateFactory
{

    public static AsyncRestTemplate createAsyncRestTemplate(ClientHttpRequestFactory clienthttprequestfactory, HttpMessageConverter httpmessageconverter)
    {
        clienthttprequestfactory = new RestTemplate(clienthttprequestfactory);
        clienthttprequestfactory.getMessageConverters().add(httpmessageconverter);
        return new AsyncRestTemplate(clienthttprequestfactory);
    }
}
