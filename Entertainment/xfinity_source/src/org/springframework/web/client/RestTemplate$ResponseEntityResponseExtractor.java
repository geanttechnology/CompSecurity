// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.client;

import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;

// Referenced classes of package org.springframework.web.client:
//            ResponseExtractor, RestTemplate, HttpMessageConverterExtractor

private class delegate
    implements ResponseExtractor
{

    private final HttpMessageConverterExtractor _flddelegate;
    final RestTemplate this$0;

    public volatile Object extractData(ClientHttpResponse clienthttpresponse)
        throws IOException
    {
        return extractData(clienthttpresponse);
    }

    public ResponseEntity extractData(ClientHttpResponse clienthttpresponse)
        throws IOException
    {
        if (_flddelegate != null)
        {
            return new ResponseEntity(_flddelegate.extractData(clienthttpresponse), clienthttpresponse.getHeaders(), clienthttpresponse.getStatusCode());
        } else
        {
            return new ResponseEntity(clienthttpresponse.getHeaders(), clienthttpresponse.getStatusCode());
        }
    }

    public Q(Class class1)
    {
        this$0 = RestTemplate.this;
        super();
        if (class1 != null && !java/lang/Void.equals(class1))
        {
            _flddelegate = new HttpMessageConverterExtractor(class1, getMessageConverters());
            return;
        } else
        {
            _flddelegate = null;
            return;
        }
    }
}
