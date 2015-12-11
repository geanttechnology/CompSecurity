// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.client;

import android.util.Log;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.Assert;

// Referenced classes of package org.springframework.web.client:
//            ResponseExtractor, RestClientException

public class HttpMessageConverterExtractor
    implements ResponseExtractor
{

    private final List messageConverters;
    private final Class responseType;

    public HttpMessageConverterExtractor(Class class1, List list)
    {
        Assert.notNull(class1, "'responseType' must not be null");
        Assert.notEmpty(list, "'messageConverters' must not be empty");
        responseType = class1;
        messageConverters = list;
    }

    public Object extractData(ClientHttpResponse clienthttpresponse)
        throws IOException
    {
        if (!hasMessageBody(clienthttpresponse))
        {
            return null;
        }
        MediaType mediatype1 = clienthttpresponse.getHeaders().getContentType();
        MediaType mediatype = mediatype1;
        if (mediatype1 == null)
        {
            if (Log.isLoggable("RestTemplate", 3))
            {
                Log.d("RestTemplate", "No Content-Type header found, defaulting to application/octet-stream");
            }
            mediatype = MediaType.APPLICATION_OCTET_STREAM;
        }
        for (Iterator iterator = messageConverters.iterator(); iterator.hasNext();)
        {
            HttpMessageConverter httpmessageconverter = (HttpMessageConverter)iterator.next();
            if (httpmessageconverter.canRead(responseType, mediatype))
            {
                if (Log.isLoggable("RestTemplate", 3))
                {
                    Log.d("RestTemplate", (new StringBuilder()).append("Reading [").append(responseType.getName()).append("] as \"").append(mediatype).append("\" using [").append(httpmessageconverter).append("]").toString());
                }
                return httpmessageconverter.read(responseType, clienthttpresponse);
            }
        }

        throw new RestClientException((new StringBuilder()).append("Could not extract response: no suitable HttpMessageConverter found for response type [").append(responseType.getName()).append("] and content type [").append(mediatype).append("]").toString());
    }

    protected boolean hasMessageBody(ClientHttpResponse clienthttpresponse)
        throws IOException
    {
        for (HttpStatus httpstatus = clienthttpresponse.getStatusCode(); httpstatus == HttpStatus.NO_CONTENT || httpstatus == HttpStatus.NOT_MODIFIED || clienthttpresponse.getHeaders().getContentLength() == 0L;)
        {
            return false;
        }

        return true;
    }
}
