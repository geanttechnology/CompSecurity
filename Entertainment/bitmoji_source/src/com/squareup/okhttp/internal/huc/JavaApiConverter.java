// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SecureCacheResponse;
import java.net.URI;
import java.net.URLConnection;
import java.security.Principal;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okio.BufferedSource;
import okio.Okio;

// Referenced classes of package com.squareup.okhttp.internal.huc:
//            DelegatingHttpsURLConnection

public final class JavaApiConverter
{
    private static final class CacheHttpURLConnection extends HttpURLConnection
    {

        private final Request request;
        private final Response response;

        public void addRequestProperty(String s, String s1)
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void connect()
            throws IOException
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void disconnect()
        {
            throw JavaApiConverter.throwRequestModificationException();
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
            throw JavaApiConverter.throwResponseBodyAccessException();
        }

        public Object getContent(Class aclass[])
            throws IOException
        {
            throw JavaApiConverter.throwResponseBodyAccessException();
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
                return StatusLine.get(response).toString();
            } else
            {
                return response.headers().value(i - 1);
            }
        }

        public String getHeaderField(String s)
        {
            if (s == null)
            {
                return StatusLine.get(response).toString();
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
            return OkHeaders.toMultimap(response.headers(), StatusLine.get(response).toString());
        }

        public long getIfModifiedSince()
        {
            return 0L;
        }

        public InputStream getInputStream()
            throws IOException
        {
            throw JavaApiConverter.throwResponseBodyAccessException();
        }

        public boolean getInstanceFollowRedirects()
        {
            return super.getInstanceFollowRedirects();
        }

        public OutputStream getOutputStream()
            throws IOException
        {
            throw JavaApiConverter.throwRequestModificationException();
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
            throw JavaApiConverter.throwRequestHeaderAccessException();
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
            return response.message();
        }

        public boolean getUseCaches()
        {
            return super.getUseCaches();
        }

        public void setAllowUserInteraction(boolean flag)
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void setChunkedStreamingMode(int i)
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void setConnectTimeout(int i)
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void setDefaultUseCaches(boolean flag)
        {
            super.setDefaultUseCaches(flag);
        }

        public void setDoInput(boolean flag)
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void setDoOutput(boolean flag)
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void setFixedLengthStreamingMode(int i)
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void setFixedLengthStreamingMode(long l)
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void setIfModifiedSince(long l)
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void setInstanceFollowRedirects(boolean flag)
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void setReadTimeout(int i)
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void setRequestMethod(String s)
            throws ProtocolException
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void setRequestProperty(String s, String s1)
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void setUseCaches(boolean flag)
        {
            throw JavaApiConverter.throwRequestModificationException();
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

        public long getContentLengthLong()
        {
            return _flddelegate.getContentLengthLong();
        }

        public long getHeaderFieldLong(String s, long l)
        {
            return _flddelegate.getHeaderFieldLong(s, l);
        }

        public HostnameVerifier getHostnameVerifier()
        {
            throw JavaApiConverter.throwRequestSslAccessException();
        }

        public SSLSocketFactory getSSLSocketFactory()
        {
            throw JavaApiConverter.throwRequestSslAccessException();
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
            throw JavaApiConverter.throwRequestModificationException();
        }

        public void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
        {
            throw JavaApiConverter.throwRequestModificationException();
        }

        public CacheHttpsURLConnection(CacheHttpURLConnection cachehttpurlconnection)
        {
            super(cachehttpurlconnection);
            _flddelegate = cachehttpurlconnection;
        }
    }


    private JavaApiConverter()
    {
    }

    public static CacheResponse createJavaCacheResponse(Response response)
    {
        Headers headers = response.headers();
        ResponseBody responsebody = response.body();
        if (response.request().isHttps())
        {
            return new SecureCacheResponse(response.handshake(), headers, response, responsebody) {

                final ResponseBody val$body;
                final Handshake val$handshake;
                final Headers val$headers;
                final Response val$response;

                public InputStream getBody()
                    throws IOException
                {
                    if (body == null)
                    {
                        return null;
                    } else
                    {
                        return body.byteStream();
                    }
                }

                public String getCipherSuite()
                {
                    if (handshake != null)
                    {
                        return handshake.cipherSuite();
                    } else
                    {
                        return null;
                    }
                }

                public Map getHeaders()
                    throws IOException
                {
                    return OkHeaders.toMultimap(headers, StatusLine.get(response).toString());
                }

                public List getLocalCertificateChain()
                {
                    if (handshake == null)
                    {
                        return null;
                    }
                    List list = handshake.localCertificates();
                    if (list.size() <= 0)
                    {
                        list = null;
                    }
                    return list;
                }

                public Principal getLocalPrincipal()
                {
                    if (handshake == null)
                    {
                        return null;
                    } else
                    {
                        return handshake.localPrincipal();
                    }
                }

                public Principal getPeerPrincipal()
                    throws SSLPeerUnverifiedException
                {
                    if (handshake == null)
                    {
                        return null;
                    } else
                    {
                        return handshake.peerPrincipal();
                    }
                }

                public List getServerCertificateChain()
                    throws SSLPeerUnverifiedException
                {
                    if (handshake == null)
                    {
                        return null;
                    }
                    List list = handshake.peerCertificates();
                    if (list.size() <= 0)
                    {
                        list = null;
                    }
                    return list;
                }

            
            {
                handshake = handshake1;
                headers = headers1;
                response = response1;
                body = responsebody;
                super();
            }
            };
        } else
        {
            return new CacheResponse(headers, response, responsebody) {

                final ResponseBody val$body;
                final Headers val$headers;
                final Response val$response;

                public InputStream getBody()
                    throws IOException
                {
                    if (body == null)
                    {
                        return null;
                    } else
                    {
                        return body.byteStream();
                    }
                }

                public Map getHeaders()
                    throws IOException
                {
                    return OkHeaders.toMultimap(headers, StatusLine.get(response).toString());
                }

            
            {
                headers = headers1;
                response = response1;
                body = responsebody;
                super();
            }
            };
        }
    }

    static HttpURLConnection createJavaUrlConnection(Response response)
    {
        if (response.request().isHttps())
        {
            return new CacheHttpsURLConnection(new CacheHttpURLConnection(response));
        } else
        {
            return new CacheHttpURLConnection(response);
        }
    }

    private static ResponseBody createOkBody(Headers headers, InputStream inputstream)
    {
        return new ResponseBody(headers, Okio.buffer(Okio.source(inputstream))) {

            final Headers val$okHeaders;
            final BufferedSource val$source;

            public long contentLength()
            {
                return OkHeaders.contentLength(okHeaders);
            }

            public MediaType contentType()
            {
                String s = okHeaders.get("Content-Type");
                if (s == null)
                {
                    return null;
                } else
                {
                    return MediaType.parse(s);
                }
            }

            public BufferedSource source()
            {
                return source;
            }

            
            {
                okHeaders = headers;
                source = bufferedsource;
                super();
            }
        };
    }

    public static Request createOkRequest(URI uri, String s, Map map)
    {
        uri = (new com.squareup.okhttp.Request.Builder()).url(uri.toString()).method(s, null);
        if (map != null)
        {
            uri.headers(extractOkHeaders(map));
        }
        return uri.build();
    }

    static Response createOkResponse(Request request, CacheResponse cacheresponse)
        throws IOException
    {
        com.squareup.okhttp.Response.Builder builder = new com.squareup.okhttp.Response.Builder();
        builder.request(request);
        request = StatusLine.parse(extractStatusLine(cacheresponse));
        builder.protocol(((StatusLine) (request)).protocol);
        builder.code(((StatusLine) (request)).code);
        builder.message(((StatusLine) (request)).message);
        request = extractOkHeaders(cacheresponse);
        builder.headers(request);
        builder.body(createOkBody(request, cacheresponse.getBody()));
        if (cacheresponse instanceof SecureCacheResponse)
        {
            SecureCacheResponse securecacheresponse = (SecureCacheResponse)cacheresponse;
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
            cacheresponse = list;
            if (list == null)
            {
                cacheresponse = Collections.emptyList();
            }
            builder.handshake(Handshake.get(securecacheresponse.getCipherSuite(), request, cacheresponse));
        }
        return builder.build();
    }

    public static Response createOkResponse(URI uri, URLConnection urlconnection)
        throws IOException
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)urlconnection;
        com.squareup.okhttp.Response.Builder builder = new com.squareup.okhttp.Response.Builder();
        builder.request(createOkRequest(uri, httpurlconnection.getRequestMethod(), null));
        uri = StatusLine.parse(extractStatusLine(httpurlconnection));
        builder.protocol(((StatusLine) (uri)).protocol);
        builder.code(((StatusLine) (uri)).code);
        builder.message(((StatusLine) (uri)).message);
        uri = extractOkResponseHeaders(httpurlconnection);
        builder.headers(uri);
        builder.body(createOkBody(uri, urlconnection.getInputStream()));
        if (httpurlconnection instanceof HttpsURLConnection)
        {
            urlconnection = (HttpsURLConnection)httpurlconnection;
            java.security.cert.Certificate acertificate[];
            try
            {
                uri = urlconnection.getServerCertificates();
            }
            // Misplaced declaration of an exception variable
            catch (URI uri)
            {
                uri = null;
            }
            acertificate = urlconnection.getLocalCertificates();
            builder.handshake(Handshake.get(urlconnection.getCipherSuite(), nullSafeImmutableList(uri), nullSafeImmutableList(acertificate)));
        }
        return builder.build();
    }

    static Map extractJavaHeaders(Request request)
    {
        return OkHeaders.toMultimap(request.headers(), null);
    }

    private static Headers extractOkHeaders(CacheResponse cacheresponse)
        throws IOException
    {
        return extractOkHeaders(cacheresponse.getHeaders());
    }

    static Headers extractOkHeaders(Map map)
    {
        com.squareup.okhttp.Headers.Builder builder = new com.squareup.okhttp.Headers.Builder();
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)map.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            if (s != null)
            {
                obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    builder.add(s, (String)((Iterator) (obj)).next());
                }
            }
        } while (true);
        return builder.build();
    }

    private static Headers extractOkResponseHeaders(HttpURLConnection httpurlconnection)
    {
        return extractOkHeaders(httpurlconnection.getHeaderFields());
    }

    private static String extractStatusLine(CacheResponse cacheresponse)
        throws IOException
    {
        return extractStatusLine(cacheresponse.getHeaders());
    }

    private static String extractStatusLine(HttpURLConnection httpurlconnection)
    {
        return httpurlconnection.getHeaderField(null);
    }

    static String extractStatusLine(Map map)
    {
        map = (List)map.get(null);
        if (map == null || map.size() == 0)
        {
            return null;
        } else
        {
            return (String)map.get(0);
        }
    }

    private static List nullSafeImmutableList(Object aobj[])
    {
        if (aobj == null)
        {
            return Collections.emptyList();
        } else
        {
            return Util.immutableList(aobj);
        }
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




}
