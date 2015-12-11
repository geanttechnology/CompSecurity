// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.cache.InputLimit;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.message.BasicHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            CombinedEntity, ResponseProxyHandler

class SizeLimitedResponseReader
{

    private boolean consumed;
    private InputStream instream;
    private InputLimit limit;
    private final long maxResponseSizeBytes;
    private final HttpRequest request;
    private Resource resource;
    private final ResourceFactory resourceFactory;
    private final CloseableHttpResponse response;

    public SizeLimitedResponseReader(ResourceFactory resourcefactory, long l, HttpRequest httprequest, CloseableHttpResponse closeablehttpresponse)
    {
        resourceFactory = resourcefactory;
        maxResponseSizeBytes = l;
        request = httprequest;
        response = closeablehttpresponse;
    }

    private void doConsume()
        throws IOException
    {
        HttpEntity httpentity;
        ensureNotConsumed();
        consumed = true;
        limit = new InputLimit(maxResponseSizeBytes);
        httpentity = response.getEntity();
        if (httpentity != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        s = request.getRequestLine().getUri();
        instream = httpentity.getContent();
        resource = resourceFactory.generate(s, instream, limit);
        if (limit.isReached()) goto _L1; else goto _L3
_L3:
        instream.close();
        return;
        Exception exception;
        exception;
        if (!limit.isReached())
        {
            instream.close();
        }
        throw exception;
    }

    private void ensureConsumed()
    {
        if (!consumed)
        {
            throw new IllegalStateException("Response has not been consumed");
        } else
        {
            return;
        }
    }

    private void ensureNotConsumed()
    {
        if (consumed)
        {
            throw new IllegalStateException("Response has already been consumed");
        } else
        {
            return;
        }
    }

    CloseableHttpResponse getReconstructedResponse()
        throws IOException
    {
        ensureConsumed();
        Object obj = new BasicHttpResponse(response.getStatusLine());
        ((HttpResponse) (obj)).setHeaders(response.getAllHeaders());
        Object obj1 = new CombinedEntity(resource, instream);
        HttpEntity httpentity = response.getEntity();
        if (httpentity != null)
        {
            ((CombinedEntity) (obj1)).setContentType(httpentity.getContentType());
            ((CombinedEntity) (obj1)).setContentEncoding(httpentity.getContentEncoding());
            ((CombinedEntity) (obj1)).setChunked(httpentity.isChunked());
        }
        ((HttpResponse) (obj)).setEntity(((HttpEntity) (obj1)));
        obj1 = cz/msebera/android/httpclient/impl/client/cache/ResponseProxyHandler.getClassLoader();
        obj = new ResponseProxyHandler(((HttpResponse) (obj))) {

            final SizeLimitedResponseReader this$0;

            public void close()
                throws IOException
            {
                response.close();
            }

            
            {
                this$0 = SizeLimitedResponseReader.this;
                super(httpresponse);
            }
        };
        return (CloseableHttpResponse)Proxy.newProxyInstance(((ClassLoader) (obj1)), new Class[] {
            cz/msebera/android/httpclient/client/methods/CloseableHttpResponse
        }, ((java.lang.reflect.InvocationHandler) (obj)));
    }

    Resource getResource()
    {
        ensureConsumed();
        return resource;
    }

    boolean isLimitReached()
    {
        ensureConsumed();
        return limit.isReached();
    }

    protected void readResponse()
        throws IOException
    {
        if (!consumed)
        {
            doConsume();
        }
    }

}
