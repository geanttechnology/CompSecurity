// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j.internal.http;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import twitter4j.TwitterException;
import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

// Referenced classes of package twitter4j.internal.http:
//            HttpClientBase, HttpResponseCode, HttpClient, HttpRequest, 
//            RequestMethod, HttpClientConfiguration, HttpParameter, HttpResponseImpl, 
//            HttpResponse

public class HttpClientImpl extends HttpClientBase
    implements HttpResponseCode, Serializable
{

    private static final Map instanceMap = new HashMap(1);
    private static final long serialVersionUID = 0x859c02532b19cd01L;

    public HttpClientImpl()
    {
        super(ConfigurationContext.getInstance());
    }

    public HttpClientImpl(HttpClientConfiguration httpclientconfiguration)
    {
        super(httpclientconfiguration);
    }

    public static HttpClient getInstance(HttpClientConfiguration httpclientconfiguration)
    {
        HttpClient httpclient = (HttpClient)instanceMap.get(httpclientconfiguration);
        Object obj = httpclient;
        if (httpclient == null)
        {
            obj = new HttpClientImpl(httpclientconfiguration);
            instanceMap.put(httpclientconfiguration, obj);
        }
        return ((HttpClient) (obj));
    }

    private void setHeaders(HttpRequest httprequest, HttpURLConnection httpurlconnection)
    {
        if (httprequest.getAuthorization() != null)
        {
            String s = httprequest.getAuthorization().getAuthorizationHeader(httprequest);
            if (s != null)
            {
                httpurlconnection.addRequestProperty("Authorization", s);
            }
        }
        if (httprequest.getRequestHeaders() != null)
        {
            String s1;
            for (Iterator iterator = httprequest.getRequestHeaders().keySet().iterator(); iterator.hasNext(); httpurlconnection.addRequestProperty(s1, (String)httprequest.getRequestHeaders().get(s1)))
            {
                s1 = (String)iterator.next();
            }

        }
    }

    public HttpResponse get(String s)
        throws TwitterException
    {
        return request(new HttpRequest(RequestMethod.GET, s, null, null, null));
    }

    protected HttpURLConnection getConnection(String s)
        throws IOException
    {
        if (isProxyConfigured())
        {
            if (CONF.getHttpProxyUser() != null && !CONF.getHttpProxyUser().equals(""))
            {
                Authenticator.setDefault(new Authenticator() {

                    final HttpClientImpl this$0;

                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        if (getRequestorType().equals(java.net.Authenticator.RequestorType.PROXY))
                        {
                            return new PasswordAuthentication(CONF.getHttpProxyUser(), CONF.getHttpProxyPassword().toCharArray());
                        } else
                        {
                            return null;
                        }
                    }

            
            {
                this$0 = HttpClientImpl.this;
                super();
            }
                });
            }
            Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP, InetSocketAddress.createUnresolved(CONF.getHttpProxyHost(), CONF.getHttpProxyPort()));
            s = (HttpURLConnection)(new URL(s)).openConnection(proxy);
        } else
        {
            s = (HttpURLConnection)(new URL(s)).openConnection();
        }
        if (CONF.getHttpConnectionTimeout() > 0)
        {
            s.setConnectTimeout(CONF.getHttpConnectionTimeout());
        }
        if (CONF.getHttpReadTimeout() > 0)
        {
            s.setReadTimeout(CONF.getHttpReadTimeout());
        }
        s.setInstanceFollowRedirects(false);
        return s;
    }

    public HttpResponse post(String s, HttpParameter ahttpparameter[])
        throws TwitterException
    {
        return request(new HttpRequest(RequestMethod.POST, s, ahttpparameter, null, null));
    }

    public HttpResponse request(HttpRequest httprequest)
        throws TwitterException
    {
        Object obj2;
        int j;
        int l;
        l = CONF.getHttpRetryCount();
        j = 0;
        obj2 = null;
_L24:
        if (j >= l + 1) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        Object obj3;
        int i;
        i = -1;
        obj1 = null;
        obj3 = null;
        obj = obj3;
        HttpURLConnection httpurlconnection = getConnection(httprequest.getURL());
        obj = obj3;
        httpurlconnection.setDoInput(true);
        obj = obj3;
        setHeaders(httprequest, httpurlconnection);
        obj = obj3;
        httpurlconnection.setRequestMethod(httprequest.getMethod().name());
        obj = obj3;
        if (httprequest.getMethod() != RequestMethod.POST) goto _L4; else goto _L3
_L3:
        obj = obj3;
        if (!HttpParameter.containsFile(httprequest.getParameters())) goto _L6; else goto _L5
_L5:
        obj = obj3;
        obj1 = (new StringBuilder()).append("----Twitter4J-upload").append(System.currentTimeMillis()).toString();
        obj = obj3;
        httpurlconnection.setRequestProperty("Content-Type", (new StringBuilder()).append("multipart/form-data; boundary=").append(((String) (obj1))).toString());
        obj = obj3;
        String s = (new StringBuilder()).append("--").append(((String) (obj1))).toString();
        obj = obj3;
        httpurlconnection.setDoOutput(true);
        obj = obj3;
        obj1 = httpurlconnection.getOutputStream();
        obj = obj1;
        DataOutputStream dataoutputstream = new DataOutputStream(((OutputStream) (obj1)));
        obj = obj1;
        HttpParameter ahttpparameter[] = httprequest.getParameters();
        obj = obj1;
        int i1 = ahttpparameter.length;
        int k = 0;
_L26:
        if (k >= i1) goto _L8; else goto _L7
_L7:
        obj3 = ahttpparameter[k];
        obj = obj1;
        if (!((HttpParameter) (obj3)).isFile()) goto _L10; else goto _L9
_L9:
        obj = obj1;
        write(dataoutputstream, (new StringBuilder()).append(s).append("\r\n").toString());
        obj = obj1;
        write(dataoutputstream, (new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(((HttpParameter) (obj3)).getName()).append("\"; filename=\"").append(((HttpParameter) (obj3)).getFile().getName()).append("\"\r\n").toString());
        obj = obj1;
        write(dataoutputstream, (new StringBuilder()).append("Content-Type: ").append(((HttpParameter) (obj3)).getContentType()).append("\r\n\r\n").toString());
        obj = obj1;
        if (!((HttpParameter) (obj3)).hasFileBody()) goto _L12; else goto _L11
_L11:
        obj = obj1;
        obj3 = ((HttpParameter) (obj3)).getFileBody();
_L16:
        obj = obj1;
        obj3 = new BufferedInputStream(((java.io.InputStream) (obj3)));
        obj = obj1;
        byte abyte1[] = new byte[1024];
_L14:
        obj = obj1;
        int j1 = ((BufferedInputStream) (obj3)).read(abyte1);
        if (j1 == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        dataoutputstream.write(abyte1, 0, j1);
        if (true) goto _L14; else goto _L13
        obj1;
        obj3 = obj2;
        obj2 = obj;
_L22:
        obj = obj3;
        k = i;
        ((OutputStream) (obj2)).close();
_L25:
        obj = obj3;
        k = i;
        try
        {
            throw obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        if (j == CONF.getHttpRetryCount())
        {
            throw new TwitterException(((IOException) (obj1)).getMessage(), ((Exception) (obj1)), k);
        }
          goto _L15
_L12:
        obj = obj1;
        obj3 = new FileInputStream(((HttpParameter) (obj3)).getFile());
          goto _L16
_L13:
        obj = obj1;
        write(dataoutputstream, "\r\n");
        obj = obj1;
        ((BufferedInputStream) (obj3)).close();
        break MISSING_BLOCK_LABEL_984;
_L10:
        obj = obj1;
        write(dataoutputstream, (new StringBuilder()).append(s).append("\r\n").toString());
        obj = obj1;
        write(dataoutputstream, (new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(((HttpParameter) (obj3)).getName()).append("\"\r\n").toString());
        obj = obj1;
        write(dataoutputstream, "Content-Type: text/plain; charset=UTF-8\r\n\r\n");
        obj = obj1;
        dataoutputstream.write(((HttpParameter) (obj3)).getValue().getBytes("UTF-8"));
        obj = obj1;
        write(dataoutputstream, "\r\n");
        break MISSING_BLOCK_LABEL_984;
_L8:
        obj = obj1;
        write(dataoutputstream, (new StringBuilder()).append(s).append("--\r\n").toString());
        obj = obj1;
        write(dataoutputstream, "\r\n");
_L23:
        obj = obj1;
        ((OutputStream) (obj1)).flush();
        obj = obj1;
        ((OutputStream) (obj1)).close();
_L4:
        obj = obj1;
        obj3 = new HttpResponseImpl(httpurlconnection, CONF);
        k = httpurlconnection.getResponseCode();
        if (k >= 200 && (k == 302 || 300 > k)) goto _L18; else goto _L17
_L17:
        if (k == 420 || k == 400 || k < 500) goto _L20; else goto _L19
_L19:
        i = k;
        if (j != CONF.getHttpRetryCount()) goto _L21; else goto _L20
_L20:
        i = k;
        throw new TwitterException(((HttpResponse) (obj3)).asString(), ((HttpResponse) (obj3)));
        obj;
        obj2 = obj1;
        obj1 = obj;
          goto _L22
_L6:
        obj = obj3;
        httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        obj = obj3;
        byte abyte0[] = HttpParameter.encodeParameters(httprequest.getParameters()).getBytes("UTF-8");
        obj = obj3;
        httpurlconnection.setRequestProperty("Content-Length", Integer.toString(abyte0.length));
        obj = obj3;
        httpurlconnection.setDoOutput(true);
        obj = obj3;
        obj1 = httpurlconnection.getOutputStream();
        obj = obj1;
        ((OutputStream) (obj1)).write(abyte0);
          goto _L23
_L18:
        obj = obj3;
        ((OutputStream) (obj1)).close();
        return ((HttpResponse) (obj3));
_L21:
        obj = obj3;
        ((OutputStream) (obj1)).close();
        obj = obj3;
_L15:
        Exception exception;
        try
        {
            Thread.sleep(CONF.getHttpRetryIntervalSeconds() * 1000);
        }
        catch (InterruptedException interruptedexception) { }
        j++;
        obj2 = obj;
          goto _L24
        httprequest;
        return ((HttpResponse) (obj3));
        exception;
        exception = ((Exception) (obj3));
          goto _L15
        exception;
          goto _L25
_L2:
        return ((HttpResponse) (obj2));
        k++;
          goto _L26
    }

    static 
    {
        if (ConfigurationContext.getInstance().isDalvik())
        {
            System.setProperty("http.keepAlive", "false");
        }
    }
}
