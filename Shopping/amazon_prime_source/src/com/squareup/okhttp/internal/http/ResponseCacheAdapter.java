// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.OkResponseCache;
import com.squareup.okhttp.ResponseSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.ResponseCache;
import java.net.SecureCacheResponse;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Response, Request, OkHeaders, Headers, 
//            DelegatingHttpsURLConnection

public class ResponseCacheAdapter
    implements OkResponseCache
{
    private static final class CacheHttpURLConnection extends HttpURLConnection
    {

        private final Request request;
        private final Response response;

        public void addRequestProperty(String s, String s1)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void connect()
            throws IOException
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void disconnect()
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public boolean getAllowUserInteraction()
        {
            return false;
        }

        public int getConnectTimeout()
        {
            return 0;
        }

        public Object getContent()
            throws IOException
        {
            throw ResponseCacheAdapter.throwResponseBodyAccessException();
        }

        public Object getContent(Class aclass[])
            throws IOException
        {
            throw ResponseCacheAdapter.throwResponseBodyAccessException();
        }

        public boolean getDefaultUseCaches()
        {
            return super.getDefaultUseCaches();
        }

        public boolean getDoInput()
        {
            return true;
        }

        public boolean getDoOutput()
        {
            return request.body() != null;
        }

        public InputStream getErrorStream()
        {
            return null;
        }

        public String getHeaderField(int i)
        {
            if (i < 0)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid header index: ").append(i).toString());
            }
            if (i == 0)
            {
                return response.statusLine();
            } else
            {
                return response.headers().value(i - 1);
            }
        }

        public String getHeaderField(String s)
        {
            if (s == null)
            {
                return response.statusLine();
            } else
            {
                return response.headers().get(s);
            }
        }

        public String getHeaderFieldKey(int i)
        {
            if (i < 0)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid header index: ").append(i).toString());
            }
            if (i == 0)
            {
                return null;
            } else
            {
                return response.headers().name(i - 1);
            }
        }

        public Map getHeaderFields()
        {
            return OkHeaders.toMultimap(response.headers(), response.statusLine());
        }

        public long getIfModifiedSince()
        {
            return 0L;
        }

        public InputStream getInputStream()
            throws IOException
        {
            throw ResponseCacheAdapter.throwResponseBodyAccessException();
        }

        public boolean getInstanceFollowRedirects()
        {
            return super.getInstanceFollowRedirects();
        }

        public OutputStream getOutputStream()
            throws IOException
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public int getReadTimeout()
        {
            return 0;
        }

        public String getRequestMethod()
        {
            return request.method();
        }

        public Map getRequestProperties()
        {
            throw ResponseCacheAdapter.throwRequestHeaderAccessException();
        }

        public String getRequestProperty(String s)
        {
            return request.header(s);
        }

        public int getResponseCode()
            throws IOException
        {
            return response.code();
        }

        public String getResponseMessage()
            throws IOException
        {
            return response.statusMessage();
        }

        public boolean getUseCaches()
        {
            return super.getUseCaches();
        }

        public void setAllowUserInteraction(boolean flag)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void setChunkedStreamingMode(int i)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void setConnectTimeout(int i)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void setDefaultUseCaches(boolean flag)
        {
            super.setDefaultUseCaches(flag);
        }

        public void setDoInput(boolean flag)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void setDoOutput(boolean flag)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void setFixedLengthStreamingMode(int i)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void setFixedLengthStreamingMode(long l)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void setIfModifiedSince(long l)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void setInstanceFollowRedirects(boolean flag)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void setReadTimeout(int i)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void setRequestMethod(String s)
            throws ProtocolException
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void setRequestProperty(String s, String s1)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void setUseCaches(boolean flag)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public boolean usingProxy()
        {
            return false;
        }


        public CacheHttpURLConnection(Response response1)
        {
            boolean flag = true;
            super(response1.request().url());
            request = response1.request();
            response = response1;
            connected = true;
            if (response1.body() != null)
            {
                flag = false;
            }
            doOutput = flag;
            method = request.method();
        }
    }

    private static final class CacheHttpsURLConnection extends DelegatingHttpsURLConnection
    {

        private final CacheHttpURLConnection _flddelegate;

        public HostnameVerifier getHostnameVerifier()
        {
            throw ResponseCacheAdapter.throwRequestSslAccessException();
        }

        public SSLSocketFactory getSSLSocketFactory()
        {
            throw ResponseCacheAdapter.throwRequestSslAccessException();
        }

        protected Handshake handshake()
        {
            return _flddelegate.response.handshake();
        }

        public void setFixedLengthStreamingMode(long l)
        {
            _flddelegate.setFixedLengthStreamingMode(l);
        }

        public void setHostnameVerifier(HostnameVerifier hostnameverifier)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
        {
            throw ResponseCacheAdapter.throwRequestModificationException();
        }

        public CacheHttpsURLConnection(CacheHttpURLConnection cachehttpurlconnection)
        {
            super(cachehttpurlconnection);
            _flddelegate = cachehttpurlconnection;
        }
    }


    private final ResponseCache _flddelegate;

    public ResponseCacheAdapter(ResponseCache responsecache)
    {
        _flddelegate = responsecache;
    }

    private static HttpURLConnection createJavaUrlConnection(Response response)
    {
        if (response.request().isHttps())
        {
            return new CacheHttpsURLConnection(new CacheHttpURLConnection(response));
        } else
        {
            return new CacheHttpURLConnection(response);
        }
    }

    private static Response.Body createOkBody(Headers headers, InputStream inputstream)
    {
        return new Response.Body(headers, inputstream) {

            final InputStream val$body;
            final Headers val$okHeaders;

            public InputStream byteStream()
            {
                return body;
            }

            
            {
                okHeaders = headers;
                body = inputstream;
                super();
            }
        };
    }

    private static Map extractJavaHeaders(Request request)
    {
        return OkHeaders.toMultimap(request.headers(), null);
    }

    private static Headers extractOkHeaders(CacheResponse cacheresponse)
        throws IOException
    {
        Object obj = cacheresponse.getHeaders();
        cacheresponse = new Headers.Builder();
        obj = ((Map) (obj)).entrySet().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
            String s = (String)((java.util.Map.Entry) (obj1)).getKey();
            if (s != null)
            {
                obj1 = ((List)((java.util.Map.Entry) (obj1)).getValue()).iterator();
                while (((Iterator) (obj1)).hasNext()) 
                {
                    cacheresponse.add(s, (String)((Iterator) (obj1)).next());
                }
            }
        } while (true);
        return cacheresponse.build();
    }

    private static String extractStatusLine(CacheResponse cacheresponse)
        throws IOException
    {
        cacheresponse = (List)cacheresponse.getHeaders().get(null);
        if (cacheresponse == null || cacheresponse.size() == 0)
        {
            return null;
        } else
        {
            return (String)cacheresponse.get(0);
        }
    }

    private CacheResponse getJavaCachedResponse(Request request)
        throws IOException
    {
        Map map = extractJavaHeaders(request);
        return _flddelegate.get(request.uri(), request.method(), map);
    }

    private static RuntimeException throwRequestHeaderAccessException()
    {
        throw new UnsupportedOperationException("ResponseCache cannot access request headers");
    }

    private static RuntimeException throwRequestModificationException()
    {
        throw new UnsupportedOperationException("ResponseCache cannot modify the request.");
    }

    private static RuntimeException throwRequestSslAccessException()
    {
        throw new UnsupportedOperationException("ResponseCache cannot access SSL internals");
    }

    private static RuntimeException throwResponseBodyAccessException()
    {
        throw new UnsupportedOperationException("ResponseCache cannot access the response body.");
    }

    public Response get(Request request)
        throws IOException
    {
        Object obj = getJavaCachedResponse(request);
        if (obj == null)
        {
            return null;
        }
        Response.Builder builder = new Response.Builder();
        builder.request(request);
        builder.statusLine(extractStatusLine(((CacheResponse) (obj))));
        request = extractOkHeaders(((CacheResponse) (obj)));
        builder.headers(request);
        builder.setResponseSource(ResponseSource.CACHE);
        builder.body(createOkBody(request, ((CacheResponse) (obj)).getBody()));
        if (obj instanceof SecureCacheResponse)
        {
            SecureCacheResponse securecacheresponse = (SecureCacheResponse)obj;
            List list;
            try
            {
                request = securecacheresponse.getServerCertificateChain();
            }
            // Misplaced declaration of an exception variable
            catch (Request request)
            {
                request = Collections.emptyList();
            }
            list = securecacheresponse.getLocalCertificateChain();
            obj = list;
            if (list == null)
            {
                obj = Collections.emptyList();
            }
            builder.handshake(Handshake.get(securecacheresponse.getCipherSuite(), request, ((List) (obj))));
        }
        return builder.build();
    }

    public boolean maybeRemove(Request request)
        throws IOException
    {
        return false;
    }

    public CacheRequest put(Response response)
        throws IOException
    {
        java.net.URI uri = response.request().uri();
        response = createJavaUrlConnection(response);
        return _flddelegate.put(uri, response);
    }

    public void trackConditionalCacheHit()
    {
    }

    public void trackResponse(ResponseSource responsesource)
    {
    }

    public void update(Response response, Response response1)
        throws IOException
    {
    }




}
