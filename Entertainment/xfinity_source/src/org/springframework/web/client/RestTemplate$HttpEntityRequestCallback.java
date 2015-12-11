// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.client;

import android.util.Log;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.converter.HttpMessageConverter;

// Referenced classes of package org.springframework.web.client:
//            RestTemplate, RestClientException

private class <init> extends k
{

    private final HttpEntity requestEntity;
    final RestTemplate this$0;

    public void doWithRequest(ClientHttpRequest clienthttprequest)
        throws IOException
    {
        super.doWithRequest(clienthttprequest);
        if (!requestEntity.hasBody())
        {
            clienthttprequest = clienthttprequest.getHeaders();
            HttpHeaders httpheaders = requestEntity.getHeaders();
            if (!httpheaders.isEmpty())
            {
                clienthttprequest.putAll(httpheaders);
            }
            if (clienthttprequest.getContentLength() == -1L)
            {
                clienthttprequest.setContentLength(0L);
            }
            return;
        }
        Object obj = requestEntity.getBody();
        Class class1 = obj.getClass();
        HttpHeaders httpheaders1 = requestEntity.getHeaders();
        org.springframework.http.MediaType mediatype = httpheaders1.getContentType();
        for (Iterator iterator = getMessageConverters().iterator(); iterator.hasNext();)
        {
            HttpMessageConverter httpmessageconverter = (HttpMessageConverter)iterator.next();
            if (httpmessageconverter.canWrite(class1, mediatype))
            {
                if (!httpheaders1.isEmpty())
                {
                    clienthttprequest.getHeaders().putAll(httpheaders1);
                }
                if (Log.isLoggable("RestTemplate", 3))
                {
                    if (mediatype != null)
                    {
                        Log.d("RestTemplate", (new StringBuilder()).append("Writing [").append(obj).append("] as \"").append(mediatype).append("\" using [").append(httpmessageconverter).append("]").toString());
                    } else
                    {
                        Log.d("RestTemplate", (new StringBuilder()).append("Writing [").append(obj).append("] using [").append(httpmessageconverter).append("]").toString());
                    }
                }
                httpmessageconverter.write(obj, mediatype, clienthttprequest);
                return;
            }
        }

        obj = (new StringBuilder()).append("Could not write request: no suitable HttpMessageConverter found for request type [").append(class1.getName()).append("]").toString();
        clienthttprequest = ((ClientHttpRequest) (obj));
        if (mediatype != null)
        {
            clienthttprequest = (new StringBuilder()).append(((String) (obj))).append(" and content type [").append(mediatype).append("]").toString();
        }
        throw new RestClientException(clienthttprequest);
    }

    private k(Object obj, Class class1)
    {
        this$0 = RestTemplate.this;
        super(RestTemplate.this, class1, null);
        if (obj instanceof HttpEntity)
        {
            requestEntity = (HttpEntity)obj;
            return;
        }
        if (obj != null)
        {
            requestEntity = new HttpEntity(obj);
            return;
        } else
        {
            requestEntity = HttpEntity.EMPTY;
            return;
        }
    }

    requestEntity(Object obj, Class class1, requestEntity requestentity)
    {
        this(obj, class1);
    }
}
