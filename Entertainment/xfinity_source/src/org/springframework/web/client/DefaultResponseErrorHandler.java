// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.client;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.FileCopyUtils;

// Referenced classes of package org.springframework.web.client:
//            ResponseErrorHandler, RestClientException, HttpClientErrorException, HttpServerErrorException

public class DefaultResponseErrorHandler
    implements ResponseErrorHandler
{

    public DefaultResponseErrorHandler()
    {
    }

    private byte[] getResponseBody(ClientHttpResponse clienthttpresponse)
    {
        clienthttpresponse = clienthttpresponse.getBody();
        if (clienthttpresponse == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        clienthttpresponse = FileCopyUtils.copyToByteArray(clienthttpresponse);
        return clienthttpresponse;
        clienthttpresponse;
        return new byte[0];
    }

    public void handleError(ClientHttpResponse clienthttpresponse)
        throws IOException
    {
        HttpStatus httpstatus = clienthttpresponse.getStatusCode();
        Object obj = clienthttpresponse.getHeaders().getContentType();
        static class _cls1
        {

            static final int $SwitchMap$org$springframework$http$HttpStatus$Series[];

            static 
            {
                $SwitchMap$org$springframework$http$HttpStatus$Series = new int[org.springframework.http.HttpStatus.Series.values().length];
                try
                {
                    $SwitchMap$org$springframework$http$HttpStatus$Series[org.springframework.http.HttpStatus.Series.CLIENT_ERROR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$springframework$http$HttpStatus$Series[org.springframework.http.HttpStatus.Series.SERVER_ERROR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        byte abyte0[];
        if (obj != null)
        {
            obj = ((MediaType) (obj)).getCharSet();
        } else
        {
            obj = null;
        }
        abyte0 = getResponseBody(clienthttpresponse);
        switch (_cls1..SwitchMap.org.springframework.http.HttpStatus.Series[httpstatus.series().ordinal()])
        {
        default:
            throw new RestClientException((new StringBuilder()).append("Unknown status code [").append(httpstatus).append("]").toString());

        case 1: // '\001'
            throw new HttpClientErrorException(httpstatus, clienthttpresponse.getStatusText(), abyte0, ((java.nio.charset.Charset) (obj)));

        case 2: // '\002'
            throw new HttpServerErrorException(httpstatus, clienthttpresponse.getStatusText(), abyte0, ((java.nio.charset.Charset) (obj)));
        }
    }

    protected boolean hasError(HttpStatus httpstatus)
    {
        return httpstatus.series() == org.springframework.http.HttpStatus.Series.CLIENT_ERROR || httpstatus.series() == org.springframework.http.HttpStatus.Series.SERVER_ERROR;
    }

    public boolean hasError(ClientHttpResponse clienthttpresponse)
        throws IOException
    {
        return hasError(clienthttpresponse.getStatusCode());
    }
}
