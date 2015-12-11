// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            CachingExec, AsynchronousValidator

class AsynchronousValidationRequest
    implements Runnable
{

    private final HttpCacheEntry cacheEntry;
    private final CachingExec cachingExec;
    private final int consecutiveFailedAttempts;
    private final HttpClientContext context;
    private final HttpExecutionAware execAware;
    private final String identifier;
    public HttpClientAndroidLog log;
    private final AsynchronousValidator parent;
    private final HttpRequestWrapper request;
    private final HttpRoute route;

    AsynchronousValidationRequest(AsynchronousValidator asynchronousvalidator, CachingExec cachingexec, HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware, HttpCacheEntry httpcacheentry, 
            String s, int i)
    {
        log = new HttpClientAndroidLog(getClass());
        parent = asynchronousvalidator;
        cachingExec = cachingexec;
        route = httproute;
        request = httprequestwrapper;
        context = httpclientcontext;
        execAware = httpexecutionaware;
        cacheEntry = httpcacheentry;
        identifier = s;
        consecutiveFailedAttempts = i;
    }

    private boolean isNotServerError(int i)
    {
        return i < 500;
    }

    private boolean isNotStale(HttpResponse httpresponse)
    {
        httpresponse = httpresponse.getHeaders("Warning");
        if (httpresponse != null)
        {
            int j = httpresponse.length;
            for (int i = 0; i < j; i++)
            {
                String s = httpresponse[i].getValue();
                if (s.startsWith("110") || s.startsWith("111"))
                {
                    return false;
                }
            }

        }
        return true;
    }

    public int getConsecutiveFailedAttempts()
    {
        return consecutiveFailedAttempts;
    }

    String getIdentifier()
    {
        return identifier;
    }

    protected boolean revalidateCacheEntry()
    {
        CloseableHttpResponse closeablehttpresponse = cachingExec.revalidateCacheEntry(route, request, context, execAware, cacheEntry);
        if (!isNotServerError(closeablehttpresponse.getStatusLine().getStatusCode())) goto _L2; else goto _L1
_L1:
        boolean flag = isNotStale(closeablehttpresponse);
        if (!flag) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        closeablehttpresponse.close();
        return flag;
        Exception exception;
        exception;
        try
        {
            closeablehttpresponse.close();
            throw exception;
        }
        catch (IOException ioexception)
        {
            log.debug("Asynchronous revalidation failed due to I/O error", ioexception);
            return false;
        }
        catch (HttpException httpexception)
        {
            log.error("HTTP protocol exception during asynchronous revalidation", httpexception);
            return false;
        }
        catch (RuntimeException runtimeexception)
        {
            log.error((new StringBuilder()).append("RuntimeException thrown during asynchronous revalidation: ").append(runtimeexception).toString());
        }
        return false;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void run()
    {
        if (!revalidateCacheEntry()) goto _L2; else goto _L1
_L1:
        parent.jobSuccessful(identifier);
_L4:
        parent.markComplete(identifier);
        return;
_L2:
        parent.jobFailed(identifier);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parent.markComplete(identifier);
        throw exception;
    }
}
