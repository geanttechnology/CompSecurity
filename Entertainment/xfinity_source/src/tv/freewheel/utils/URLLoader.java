// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.RequestAddCookies;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import tv.freewheel.utils.cookie.AndroidCookieStore;
import tv.freewheel.utils.cookie.DummyAndroidCookieStore;
import tv.freewheel.utils.cookie.IAndroidCookieStore;
import tv.freewheel.utils.events.Event;
import tv.freewheel.utils.events.EventDispatcher;
import tv.freewheel.utils.http.ISimpleHttpClient;
import tv.freewheel.utils.http.SimpleHttpClient;

// Referenced classes of package tv.freewheel.utils:
//            Logger, URLRequest, URIUtil

public class URLLoader extends EventDispatcher
{
    public static final class URLLoaderErrorException extends Exception
    {

        public URLLoaderErrorException(String s)
        {
            super(s);
        }

        public URLLoaderErrorException(String s, Throwable throwable)
        {
            super(s, throwable);
        }
    }


    public static int LOADER_BUFFER_SIZE = 1024;
    protected static IAndroidCookieStore androidCookieStore;
    private static CookieStore cookieStore = new BasicCookieStore();
    private ISimpleHttpClient client;
    private AtomicBoolean clientAlive;
    private Logger logger;

    public URLLoader()
    {
        clientAlive = new AtomicBoolean(false);
        client = null;
        logger = Logger.getLogger(this);
    }

    private static String inputStreamToString(InputStream inputstream)
        throws IOException
    {
        Object obj;
        inputstream = new InputStreamReader(inputstream, "UTF-8");
        obj = new StringWriter();
        char ac[] = new char[LOADER_BUFFER_SIZE];
_L1:
        int i = inputstream.read(ac);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        ((StringWriter) (obj)).write(ac, 0, i);
          goto _L1
        obj;
        inputstream.close();
        throw obj;
        inputstream.close();
        return ((StringWriter) (obj)).toString();
    }

    public void close()
    {
        if (clientAlive.getAndSet(false))
        {
            client.close();
            client = null;
        }
    }

    protected ISimpleHttpClient initHttpClient(URLRequest urlrequest, int i)
    {
        urlrequest = SimpleHttpClient.newInstance(urlrequest.userAgent);
        urlrequest.getParams().setParameter("http.connection.timeout", Integer.valueOf(i));
        urlrequest.getParams().setParameter("http.socket.timeout", Integer.valueOf(i));
        return urlrequest;
    }

    protected void initRequestHeader(URLRequest urlrequest, ISimpleHttpClient isimplehttpclient, HttpUriRequest httpurirequest)
        throws UnsupportedEncodingException
    {
        String s = androidCookieStore.getCookie(urlrequest.url);
        if (s != null)
        {
            logger.debug((new StringBuilder()).append("sending cookie: ").append(s).toString());
            isimplehttpclient.removeRequestInterceptorByClass(org/apache/http/client/protocol/RequestAddCookies);
            httpurirequest.setHeader("Cookie", s);
        }
        if (urlrequest.data != null && (httpurirequest instanceof HttpPost))
        {
            ((HttpPost)httpurirequest).setEntity(new StringEntity(urlrequest.data, "UTF-8"));
        }
        httpurirequest.setHeader("Content-Type", (new StringBuilder()).append(urlrequest.contentType).append("; charset=").append("UTF-8").toString());
    }

    protected HttpUriRequest initRequestMethod(URLRequest urlrequest)
        throws URLLoaderErrorException
    {
        Object obj;
        boolean flag;
        obj = null;
        flag = false;
        if (urlrequest.method != 1) goto _L2; else goto _L1
_L1:
        obj = new HttpGet(urlrequest.url);
_L3:
        if (flag)
        {
            throw new URLLoaderErrorException((new StringBuilder()).append("method not supported: ").append(urlrequest.method).toString());
        } else
        {
            return ((HttpUriRequest) (obj));
        }
_L2:
        try
        {
label0:
            {
                if (urlrequest.method != 0)
                {
                    break label0;
                }
                obj = new HttpPost(urlrequest.url);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new URLLoaderErrorException((new StringBuilder()).append(urlrequest.url).append(" causes IllegalArgumentException.").toString(), ((Throwable) (obj)));
        }
          goto _L3
        flag = true;
          goto _L3
    }

    protected void issueHttpRequest(ISimpleHttpClient isimplehttpclient, URLRequest urlrequest)
    {
        Object obj2 = null;
        Object obj = initRequestMethod(urlrequest);
_L9:
        int j;
        initRequestHeader(urlrequest, isimplehttpclient, ((HttpUriRequest) (obj)));
        obj2 = new BasicHttpContext();
        ((HttpContext) (obj2)).setAttribute("http.cookie-store", cookieStore);
        obj = isimplehttpclient.execute(((HttpUriRequest) (obj)), ((HttpContext) (obj2)));
        obj2 = ((HttpResponse) (obj)).getHeaders("Set-Cookie");
        j = obj2.length;
        int i = 0;
_L2:
        Header header;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        header = obj2[i];
        androidCookieStore.setCookie(urlrequest.url, header.getValue());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        URLLoaderErrorException urlloadererrorexception;
        break; /* Loop/switch isn't completed */
        urlloadererrorexception;
        j = 1;
        i = j;
        obj = obj2;
        if (!(urlloadererrorexception.getCause() instanceof IllegalArgumentException)) goto _L4; else goto _L3
_L3:
        obj = URIUtil.getFixedString(urlrequest.url);
        if (obj != null) goto _L6; else goto _L5
_L5:
        logger.debug((new StringBuilder()).append("Failed to fix URL:").append(urlrequest.url).toString());
        obj = obj2;
        i = j;
_L4:
        if (!i)
        {
            break; /* Loop/switch isn't completed */
        }
        dispatchEvent(new Event("URLLoader.Load.Error", urlloadererrorexception.toString()));
        logger.verbose((new StringBuilder()).append("httpclient[").append(isimplehttpclient.hashCode()).append("] for URL: ").append(urlrequest.url).append(" is reclaimed").toString());
        isimplehttpclient.close();
        return;
_L6:
        logger.debug((new StringBuilder()).append("Replace URL:").append(urlrequest.url).append(" with fixed one:").append(((String) (obj))).toString());
        urlrequest.url = ((String) (obj));
        obj = initRequestMethod(urlrequest);
        i = 0;
        continue; /* Loop/switch isn't completed */
        obj;
        logger.debug((new StringBuilder()).append("Failed to use fixed URL:").append(urlrequest.url).toString());
        i = j;
        obj = obj2;
        if (true) goto _L4; else goto _L7
_L7:
        if (true) goto _L9; else goto _L8
        obj;
        dispatchEvent(new Event("URLLoader.Load.Error", ((ClientProtocolException) (obj)).toString()));
        logger.verbose((new StringBuilder()).append("httpclient[").append(isimplehttpclient.hashCode()).append("] for URL: ").append(urlrequest.url).append(" is reclaimed").toString());
        isimplehttpclient.close();
        return;
_L8:
        i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        if (i == 200) goto _L11; else goto _L10
_L10:
        dispatchEvent(new Event("URLLoader.Load.Error", (new StringBuilder()).append("bad status code: ").append(i).toString()));
_L13:
        logger.verbose((new StringBuilder()).append("httpclient[").append(isimplehttpclient.hashCode()).append("] for URL: ").append(urlrequest.url).append(" is reclaimed").toString());
        isimplehttpclient.close();
        return;
_L11:
        parseResponseBody(urlrequest, ((HttpResponse) (obj)).getEntity(), i);
        continue; /* Loop/switch isn't completed */
        Object obj1;
        obj1;
        dispatchEvent(new Event("URLLoader.Load.Error", ((IOException) (obj1)).toString()));
        logger.verbose((new StringBuilder()).append("httpclient[").append(isimplehttpclient.hashCode()).append("] for URL: ").append(urlrequest.url).append(" is reclaimed").toString());
        isimplehttpclient.close();
        return;
        obj1;
        dispatchEvent(new Event("URLLoader.Load.Error", ((Exception) (obj1)).toString()));
        logger.verbose((new StringBuilder()).append("httpclient[").append(isimplehttpclient.hashCode()).append("] for URL: ").append(urlrequest.url).append(" is reclaimed").toString());
        isimplehttpclient.close();
        return;
        obj1;
        logger.verbose((new StringBuilder()).append("httpclient[").append(isimplehttpclient.hashCode()).append("] for URL: ").append(urlrequest.url).append(" is reclaimed").toString());
        isimplehttpclient.close();
        throw obj1;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public void load(URLRequest urlrequest)
    {
        load(urlrequest, 20D);
    }

    public void load(final URLRequest request, final double timeOutSeconds)
    {
        (new Thread() {

            final URLLoader this$0;
            final URLRequest val$request;
            final double val$timeOutSeconds;

            public void run()
            {
                try
                {
                    if (request.delayMs > 0L)
                    {
                        Thread.sleep(request.delayMs);
                    }
                    int i = (int)(timeOutSeconds * 1000D);
                    client = initHttpClient(request, i);
                    clientAlive.set(true);
                    issueHttpRequest(client, request);
                    return;
                }
                catch (Throwable throwable)
                {
                    dispatchEvent(new Event("URLLoader.Load.Error", (new StringBuilder()).append("RuntimeError: ").append(throwable.toString()).toString()));
                    logger.warn((new StringBuilder()).append("load failed on url: ").append(request.url).toString());
                    throwable.printStackTrace();
                    return;
                }
            }

            
            {
                this$0 = URLLoader.this;
                request = urlrequest;
                timeOutSeconds = d;
                super();
            }
        }).start();
    }

    protected void parseResponseBody(URLRequest urlrequest, HttpEntity httpentity, int i)
        throws IOException
    {
        if (urlrequest.method == 1)
        {
            if (httpentity != null)
            {
                dispatchEvent(new Event("URLLoader.Load.Complete", inputStreamToString(httpentity.getContent())));
                return;
            } else
            {
                dispatchEvent(new Event("URLLoader.Load.Complete", i));
                return;
            }
        }
        if (httpentity != null)
        {
            dispatchEvent(new Event("URLLoader.Load.Complete", inputStreamToString(httpentity.getContent())));
            return;
        } else
        {
            logger.error("response entity is null");
            dispatchEvent(new Event("URLLoader.Load.Error", "entity is null"));
            return;
        }
    }

    static 
    {
        try
        {
            androidCookieStore = new AndroidCookieStore();
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            androidCookieStore = new DummyAndroidCookieStore();
        }
        androidCookieStore.removeExpiredCookie();
    }



/*
    static ISimpleHttpClient access$002(URLLoader urlloader, ISimpleHttpClient isimplehttpclient)
    {
        urlloader.client = isimplehttpclient;
        return isimplehttpclient;
    }

*/


}
