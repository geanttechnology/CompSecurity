// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.client;

import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.StatusLine;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest;
import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionManager;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import com.comcast.cim.httpcomponentsandroid.util.EntityUtils;
import java.io.IOException;
import org.slf4j.Logger;

public class RetryingHttpClient
    implements HttpClient
{
    private static interface ResponseProvider
    {

        public abstract HttpResponse executeRequest()
            throws IOException;
    }


    private final Logger LOG;
    private final HttpClient _flddelegate;
    private final int maxRetries;
    private final int pauseBetweenRetriesInMillis;

    private void consumeQuietly(HttpResponse httpresponse)
    {
        if (httpresponse == null)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        EntityUtils.consume(httpresponse.getEntity());
        return;
        httpresponse;
    }

    private HttpResponse executeWithRetry(ResponseProvider responseprovider)
        throws IOException
    {
        HttpResponse httpresponse = null;
        int i = 0;
        do
        {
label0:
            {
                if (i <= maxRetries)
                {
                    httpresponse = responseprovider.executeRequest();
                    if (httpresponse.getStatusLine().getStatusCode() == 202)
                    {
                        break label0;
                    }
                }
                return httpresponse;
            }
            consumeQuietly(httpresponse);
            try
            {
                LOG.debug("Received 202 (ACCEPTED) response from delegate client, pausing for {} millis", Integer.valueOf(pauseBetweenRetriesInMillis));
                Thread.sleep(pauseBetweenRetriesInMillis);
            }
            catch (InterruptedException interruptedexception) { }
            i++;
            LOG.debug("Retrying request (numAttempts so far: {})", Integer.valueOf(i));
        } while (true);
    }

    public HttpResponse execute(final HttpHost target, final HttpRequest request, final HttpContext context)
        throws IOException
    {
        return executeWithRetry(new ResponseProvider() {

            final RetryingHttpClient this$0;
            final HttpContext val$context;
            final HttpRequest val$request;
            final HttpHost val$target;

            public HttpResponse executeRequest()
                throws IOException
            {
                return _flddelegate.execute(target, request, context);
            }

            
            {
                this$0 = RetryingHttpClient.this;
                target = httphost;
                request = httprequest;
                context = httpcontext;
                super();
            }
        });
    }

    public HttpResponse execute(final HttpUriRequest request)
        throws IOException
    {
        return executeWithRetry(new ResponseProvider() {

            final RetryingHttpClient this$0;
            final HttpUriRequest val$request;

            public HttpResponse executeRequest()
                throws IOException
            {
                return _flddelegate.execute(request);
            }

            
            {
                this$0 = RetryingHttpClient.this;
                request = httpurirequest;
                super();
            }
        });
    }

    public HttpResponse execute(final HttpUriRequest request, final HttpContext context)
        throws IOException
    {
        return executeWithRetry(new ResponseProvider() {

            final RetryingHttpClient this$0;
            final HttpContext val$context;
            final HttpUriRequest val$request;

            public HttpResponse executeRequest()
                throws IOException
            {
                return _flddelegate.execute(request, context);
            }

            
            {
                this$0 = RetryingHttpClient.this;
                request = httpurirequest;
                context = httpcontext;
                super();
            }
        });
    }

    public ClientConnectionManager getConnectionManager()
    {
        return _flddelegate.getConnectionManager();
    }

    public HttpParams getParams()
    {
        return _flddelegate.getParams();
    }

}
