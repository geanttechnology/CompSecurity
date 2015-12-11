// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.SSLException;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            RequestWrapper

public class DefaultHttpRequestRetryHandler
    implements HttpRequestRetryHandler
{

    public static final DefaultHttpRequestRetryHandler INSTANCE = new DefaultHttpRequestRetryHandler();
    private final Set nonRetriableClasses;
    private final boolean requestSentRetryEnabled;
    private final int retryCount;

    public DefaultHttpRequestRetryHandler()
    {
        this(3, false);
    }

    public DefaultHttpRequestRetryHandler(int i, boolean flag)
    {
        this(i, flag, ((Collection) (Arrays.asList(new Class[] {
            java/io/InterruptedIOException, java/net/UnknownHostException, java/net/ConnectException, javax/net/ssl/SSLException
        }))));
    }

    protected DefaultHttpRequestRetryHandler(int i, boolean flag, Collection collection)
    {
        retryCount = i;
        requestSentRetryEnabled = flag;
        nonRetriableClasses = new HashSet();
        Class class1;
        for (collection = collection.iterator(); collection.hasNext(); nonRetriableClasses.add(class1))
        {
            class1 = (Class)collection.next();
        }

    }

    public int getRetryCount()
    {
        return retryCount;
    }

    protected boolean handleAsIdempotent(HttpRequest httprequest)
    {
        return !(httprequest instanceof HttpEntityEnclosingRequest);
    }

    public boolean isRequestSentRetryEnabled()
    {
        return requestSentRetryEnabled;
    }

    protected boolean requestIsAborted(HttpRequest httprequest)
    {
        HttpRequest httprequest1 = httprequest;
        if (httprequest instanceof RequestWrapper)
        {
            httprequest1 = ((RequestWrapper)httprequest).getOriginal();
        }
        return (httprequest1 instanceof HttpUriRequest) && ((HttpUriRequest)httprequest1).isAborted();
    }

    public boolean retryRequest(IOException ioexception, int i, HttpContext httpcontext)
    {
        Args.notNull(ioexception, "Exception parameter");
        Args.notNull(httpcontext, "HTTP context");
        break MISSING_BLOCK_LABEL_14;
        if (i <= retryCount && !nonRetriableClasses.contains(ioexception.getClass()))
        {
            for (Iterator iterator = nonRetriableClasses.iterator(); iterator.hasNext();)
            {
                if (((Class)iterator.next()).isInstance(ioexception))
                {
                    return false;
                }
            }

            ioexception = HttpClientContext.adapt(httpcontext);
            httpcontext = ioexception.getRequest();
            if (!requestIsAborted(httpcontext))
            {
                if (handleAsIdempotent(httpcontext))
                {
                    return true;
                }
                if (!ioexception.isRequestSent() || requestSentRetryEnabled)
                {
                    return true;
                }
            }
        }
        return false;
    }

}
