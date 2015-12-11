// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.client;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.converter.HttpMessageConverter;

// Referenced classes of package org.springframework.web.client:
//            RequestCallback, RestTemplate

private class <init>
    implements RequestCallback
{

    private final Class responseType;
    final RestTemplate this$0;

    public void doWithRequest(ClientHttpRequest clienthttprequest)
        throws IOException
    {
        if (responseType != null)
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator = getMessageConverters().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                HttpMessageConverter httpmessageconverter = (HttpMessageConverter)iterator.next();
                if (httpmessageconverter.canRead(responseType, null))
                {
                    Iterator iterator1 = httpmessageconverter.getSupportedMediaTypes().iterator();
                    while (iterator1.hasNext()) 
                    {
                        MediaType mediatype1 = (MediaType)iterator1.next();
                        MediaType mediatype = mediatype1;
                        if (mediatype1.getCharSet() != null)
                        {
                            mediatype = new MediaType(mediatype1.getType(), mediatype1.getSubtype());
                        }
                        arraylist.add(mediatype);
                    }
                }
            } while (true);
            if (!arraylist.isEmpty())
            {
                MediaType.sortBySpecificity(arraylist);
                if (Log.isLoggable("RestTemplate", 3))
                {
                    Log.d("RestTemplate", (new StringBuilder()).append("Setting request Accept header to ").append(arraylist).toString());
                }
                clienthttprequest.getHeaders().setAccept(arraylist);
            }
        }
    }

    private (Class class1)
    {
        this$0 = RestTemplate.this;
        super();
        responseType = class1;
    }

    responseType(Class class1, responseType responsetype)
    {
        this(class1);
    }
}
