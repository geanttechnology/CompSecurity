// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.util.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import tv.freewheel.renderers.vast.util.Logger;
import tv.freewheel.renderers.vast.util.URIUtil;

// Referenced classes of package tv.freewheel.renderers.vast.util.http:
//            ISimpleHttpClient

public class SimpleHttpClient
    implements ISimpleHttpClient
{

    private static final ThreadLocal sThreadBlocked = new ThreadLocal();
    private static final HttpRequestInterceptor sThreadCheckInterceptor = new HttpRequestInterceptor() {

        public void process(HttpRequest httprequest, HttpContext httpcontext)
        {
            if (SimpleHttpClient.sThreadBlocked.get() != null && ((Boolean)SimpleHttpClient.sThreadBlocked.get()).booleanValue())
            {
                throw new RuntimeException("This thread forbids HTTP requests");
            } else
            {
                return;
            }
        }

    };
    private final HttpClient _flddelegate;
    private Logger logger;
    private RuntimeException mLeakedException;
    private AtomicBoolean started;

    public SimpleHttpClient(ClientConnectionManager clientconnectionmanager, HttpParams httpparams)
    {
        mLeakedException = new IllegalStateException("SimpleHttpClient created and never closed");
        started = new AtomicBoolean(false);
        logger = Logger.getLogger(this);
        clientconnectionmanager = new DefaultHttpClient(clientconnectionmanager, httpparams) {

            final SimpleHttpClient this$0;

            protected HttpContext createHttpContext()
            {
                BasicHttpContext basichttpcontext = new BasicHttpContext();
                basichttpcontext.setAttribute("http.authscheme-registry", getAuthSchemes());
                basichttpcontext.setAttribute("http.cookiespec-registry", getCookieSpecs());
                basichttpcontext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
                return basichttpcontext;
            }

            protected BasicHttpProcessor createHttpProcessor()
            {
                BasicHttpProcessor basichttpprocessor = super.createHttpProcessor();
                basichttpprocessor.addRequestInterceptor(SimpleHttpClient.sThreadCheckInterceptor);
                return basichttpprocessor;
            }

            
            {
                this$0 = SimpleHttpClient.this;
                super(clientconnectionmanager, httpparams);
            }
        };
        clientconnectionmanager.setRedirectHandler(new DefaultRedirectHandler() {

            final SimpleHttpClient this$0;

            public URI getLocationURI(HttpResponse httpresponse, HttpContext httpcontext)
                throws ProtocolException
            {
                URI uri;
                try
                {
                    uri = super.getLocationURI(httpresponse, httpcontext);
                }
                catch (ProtocolException protocolexception)
                {
                    Object obj = protocolexception.getCause();
                    if (!(obj instanceof URISyntaxException))
                    {
                        throw protocolexception;
                    }
                    obj = URIUtil.getFixedString(((URISyntaxException)obj).getInput());
                    if (obj == null)
                    {
                        throw protocolexception;
                    } else
                    {
                        logger.debug((new StringBuilder()).append("Try fixed redirect location ").append(((String) (obj))).toString());
                        httpresponse.setHeader("location", ((String) (obj)));
                        return super.getLocationURI(httpresponse, httpcontext);
                    }
                }
                return uri;
            }

            
            {
                this$0 = SimpleHttpClient.this;
                super();
            }
        });
        _flddelegate = clientconnectionmanager;
    }

    public static ISimpleHttpClient newInstance(String s)
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        basichttpparams.setParameter("http.protocol.content-charset", "UTF-8");
        HttpConnectionParams.setStaleCheckingEnabled(basichttpparams, false);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 20000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 20000);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        basichttpparams.setParameter("http.protocol.cookie-policy", "compatibility");
        HttpClientParams.setRedirecting(basichttpparams, true);
        HttpProtocolParams.setUserAgent(basichttpparams, s);
        s = new SchemeRegistry();
        s.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        s.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        return new SimpleHttpClient(new ThreadSafeClientConnManager(basichttpparams, s), basichttpparams);
    }

    public void addRequestInterceptor(HttpRequestInterceptor httprequestinterceptor)
    {
        ((DefaultHttpClient)_flddelegate).addRequestInterceptor(httprequestinterceptor);
    }

    public void close()
    {
        if (started.get())
        {
            getConnectionManager().shutdown();
            mLeakedException = null;
        }
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler)
        throws IOException
    {
        started.set(true);
        return _flddelegate.execute(httphost, httprequest, responsehandler);
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException
    {
        started.set(true);
        return _flddelegate.execute(httphost, httprequest, responsehandler, httpcontext);
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler)
        throws IOException
    {
        started.set(true);
        return _flddelegate.execute(httpurirequest, responsehandler);
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException
    {
        started.set(true);
        return _flddelegate.execute(httpurirequest, responsehandler, httpcontext);
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest)
        throws IOException
    {
        started.set(true);
        return _flddelegate.execute(httphost, httprequest);
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException
    {
        started.set(true);
        return _flddelegate.execute(httphost, httprequest, httpcontext);
    }

    public HttpResponse execute(HttpUriRequest httpurirequest)
        throws IOException
    {
        started.set(true);
        return _flddelegate.execute(httpurirequest);
    }

    public HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
        throws IOException
    {
        started.set(true);
        return _flddelegate.execute(httpurirequest, httpcontext);
    }

    protected void finalize()
        throws Throwable
    {
        super.finalize();
        if (mLeakedException != null)
        {
            logger.error((new StringBuilder()).append("Leak found: ").append(mLeakedException.toString()).toString());
            mLeakedException = null;
        }
    }

    public ClientConnectionManager getConnectionManager()
    {
        return _flddelegate.getConnectionManager();
    }

    public HttpParams getParams()
    {
        return _flddelegate.getParams();
    }

    public void removeRequestInterceptorByClass(Class class1)
    {
        ((DefaultHttpClient)_flddelegate).removeRequestInterceptorByClass(class1);
    }




}
