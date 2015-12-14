// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.security.cert.CertificateException;
import java.util.Date;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.d;
import okio.e;
import okio.f;
import okio.j;
import okio.l;
import okio.q;
import okio.r;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            OkHeaders, RouteSelector, CacheStrategy, HttpMethod, 
//            Transport, RetryableSink, CacheRequest

public final class HttpEngine
{

    private static final ResponseBody EMPTY_BODY = new ResponseBody() {

        public long contentLength()
        {
            return 0L;
        }

        public MediaType contentType()
        {
            return null;
        }

        public f source()
        {
            return new d();
        }

    };
    public static final int MAX_REDIRECTS = 20;
    public final boolean bufferRequestBody;
    private e bufferedRequestBody;
    private Response cacheResponse;
    private CacheStrategy cacheStrategy;
    final OkHttpClient client;
    private Connection connection;
    private Request networkRequest;
    private Response networkResponse;
    private final Response priorResponse;
    private q requestBodyOut;
    private f responseBody;
    private InputStream responseBodyBytes;
    private r responseTransferSource;
    private Route route;
    private RouteSelector routeSelector;
    long sentRequestMillis;
    private CacheRequest storeRequest;
    private boolean transparentGzip;
    private Transport transport;
    private final Request userRequest;
    private Response userResponse;

    public HttpEngine(OkHttpClient okhttpclient, Request request, boolean flag, Connection connection1, RouteSelector routeselector, RetryableSink retryablesink, Response response)
    {
        sentRequestMillis = -1L;
        client = okhttpclient;
        userRequest = request;
        bufferRequestBody = flag;
        connection = connection1;
        routeSelector = routeselector;
        requestBodyOut = retryablesink;
        priorResponse = response;
        if (connection1 != null)
        {
            Internal.instance.setOwner(connection1, this);
            route = connection1.getRoute();
            return;
        } else
        {
            route = null;
            return;
        }
    }

    private static Headers combine(Headers headers, Headers headers1)
    {
        boolean flag = false;
        com.squareup.okhttp.Headers.Builder builder = new com.squareup.okhttp.Headers.Builder();
        int i = 0;
        int k;
        do
        {
            k = ((flag) ? 1 : 0);
            if (i >= headers.size())
            {
                break;
            }
            String s = headers.name(i);
            String s1 = headers.value(i);
            if ((!"Warning".equalsIgnoreCase(s) || !s1.startsWith("1")) && (!OkHeaders.isEndToEnd(s) || headers1.get(s) == null))
            {
                builder.add(s, s1);
            }
            i++;
        } while (true);
        do
        {
            if (k >= headers1.size())
            {
                break;
            }
            headers = headers1.name(k);
            if (!"Content-Length".equalsIgnoreCase(headers) && OkHeaders.isEndToEnd(headers))
            {
                builder.add(headers, headers1.value(k));
            }
            k++;
        } while (true);
        return builder.build();
    }

    private void connect(Request request)
    {
        if (connection != null)
        {
            throw new IllegalStateException();
        }
        if (routeSelector == null)
        {
            routeSelector = RouteSelector.get(request, client);
        }
        connection = routeSelector.next(this);
        route = connection.getRoute();
    }

    public static String hostHeader(URL url)
    {
        if (Util.getEffectivePort(url) != Util.getDefaultPort(url.getProtocol()))
        {
            return (new StringBuilder()).append(url.getHost()).append(":").append(url.getPort()).toString();
        } else
        {
            return url.getHost();
        }
    }

    private void initContentStream(r r)
    {
        responseTransferSource = r;
        if (transparentGzip && "gzip".equalsIgnoreCase(userResponse.header("Content-Encoding")))
        {
            userResponse = userResponse.newBuilder().removeHeader("Content-Encoding").removeHeader("Content-Length").build();
            responseBody = l.a(new j(r));
            return;
        } else
        {
            responseBody = l.a(r);
            return;
        }
    }

    private boolean isRecoverable(IOException ioexception)
    {
        boolean flag;
        boolean flag1;
        if ((ioexception instanceof SSLPeerUnverifiedException) || (ioexception instanceof SSLHandshakeException) && (ioexception.getCause() instanceof CertificateException))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = ioexception instanceof ProtocolException;
        return !flag && !flag1;
    }

    private void maybeCache()
    {
        Object obj = Internal.instance.internalCache(client);
        if (obj != null)
        {
            if (!CacheStrategy.isCacheable(userResponse, networkRequest))
            {
                if (HttpMethod.invalidatesCache(networkRequest.method()))
                {
                    try
                    {
                        ((InternalCache) (obj)).remove(networkRequest);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        return;
                    }
                }
            } else
            {
                storeRequest = ((InternalCache) (obj)).put(stripBody(userResponse));
                return;
            }
        }
    }

    private Request networkRequest(Request request)
    {
        com.squareup.okhttp.Request.Builder builder = request.newBuilder();
        if (request.header("Host") == null)
        {
            builder.header("Host", hostHeader(request.url()));
        }
        if ((connection == null || connection.getProtocol() != Protocol.HTTP_1_0) && request.header("Connection") == null)
        {
            builder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null)
        {
            transparentGzip = true;
            builder.header("Accept-Encoding", "gzip");
        }
        CookieHandler cookiehandler = client.getCookieHandler();
        if (cookiehandler != null)
        {
            java.util.Map map = OkHeaders.toMultimap(builder.build().headers(), null);
            OkHeaders.addCookies(builder, cookiehandler.get(request.uri(), map));
        }
        if (request.header("User-Agent") == null)
        {
            builder.header("User-Agent", Version.userAgent());
        }
        return builder.build();
    }

    private static Response stripBody(Response response)
    {
        Response response1 = response;
        if (response != null)
        {
            response1 = response;
            if (response.body() != null)
            {
                response1 = response.newBuilder().body(null).build();
            }
        }
        return response1;
    }

    private static boolean validate(Response response, Response response1)
    {
        if (response1.code() != 304) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        response = response.headers().getDate("Last-Modified");
        if (response == null)
        {
            break; /* Loop/switch isn't completed */
        }
        response1 = response1.headers().getDate("Last-Modified");
        if (response1 != null && response1.getTime() < response.getTime()) goto _L1; else goto _L3
_L3:
        return false;
    }

    public Connection close()
    {
        if (bufferedRequestBody == null) goto _L2; else goto _L1
_L1:
        Util.closeQuietly(bufferedRequestBody);
_L4:
        if (responseBody == null)
        {
            if (connection != null)
            {
                Util.closeQuietly(connection.getSocket());
            }
            connection = null;
            return null;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (requestBodyOut != null)
        {
            Util.closeQuietly(requestBodyOut);
        }
        if (true) goto _L4; else goto _L3
_L3:
        Util.closeQuietly(responseBody);
        Util.closeQuietly(responseBodyBytes);
        if (transport != null && connection != null && !transport.canReuseConnection())
        {
            Util.closeQuietly(connection.getSocket());
            connection = null;
            return null;
        }
        if (connection != null && !Internal.instance.clearOwner(connection))
        {
            connection = null;
        }
        Connection connection1 = connection;
        connection = null;
        return connection1;
    }

    public void disconnect()
    {
        if (transport == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        transport.disconnect(this);
        return;
        IOException ioexception;
        ioexception;
    }

    public Request followUpRequest()
    {
        if (userResponse == null)
        {
            throw new IllegalStateException();
        }
        Object obj;
        if (getRoute() != null)
        {
            obj = getRoute().getProxy();
        } else
        {
            obj = client.getProxy();
        }
        switch (userResponse.code())
        {
        default:
            return null;

        case 407: 
            if (((Proxy) (obj)).type() != java.net.Proxy.Type.HTTP)
            {
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            // fall through

        case 401: 
            return OkHeaders.processAuthHeader(client.getAuthenticator(), userResponse, ((Proxy) (obj)));

        case 307: 
        case 308: 
            if (!userRequest.method().equals("GET") && !userRequest.method().equals("HEAD"))
            {
                return null;
            }
            break;

        case 300: 
        case 301: 
        case 302: 
        case 303: 
            break;
        }
        if (!client.getFollowRedirects())
        {
            return null;
        }
        obj = userResponse.header("Location");
        if (obj == null)
        {
            return null;
        }
        obj = new URL(userRequest.url(), ((String) (obj)));
        if (!((URL) (obj)).getProtocol().equals("https") && !((URL) (obj)).getProtocol().equals("http"))
        {
            return null;
        }
        if (!((URL) (obj)).getProtocol().equals(userRequest.url().getProtocol()) && !client.getFollowSslRedirects())
        {
            return null;
        }
        com.squareup.okhttp.Request.Builder builder = userRequest.newBuilder();
        if (HttpMethod.permitsRequestBody(userRequest.method()))
        {
            builder.method("GET", null);
            builder.removeHeader("Transfer-Encoding");
            builder.removeHeader("Content-Length");
            builder.removeHeader("Content-Type");
        }
        if (!sameConnection(((URL) (obj))))
        {
            builder.removeHeader("Authorization");
        }
        return builder.url(((URL) (obj))).build();
    }

    public e getBufferedRequestBody()
    {
        Object obj = bufferedRequestBody;
        if (obj != null)
        {
            return ((e) (obj));
        }
        obj = getRequestBody();
        if (obj != null)
        {
            obj = l.a(((q) (obj)));
            bufferedRequestBody = ((e) (obj));
            return ((e) (obj));
        } else
        {
            return null;
        }
    }

    public Connection getConnection()
    {
        return connection;
    }

    public Request getRequest()
    {
        return userRequest;
    }

    public q getRequestBody()
    {
        if (cacheStrategy == null)
        {
            throw new IllegalStateException();
        } else
        {
            return requestBodyOut;
        }
    }

    public Response getResponse()
    {
        if (userResponse == null)
        {
            throw new IllegalStateException();
        } else
        {
            return userResponse;
        }
    }

    public f getResponseBody()
    {
        if (userResponse == null)
        {
            throw new IllegalStateException();
        } else
        {
            return responseBody;
        }
    }

    public InputStream getResponseBodyBytes()
    {
        InputStream inputstream = responseBodyBytes;
        if (inputstream != null)
        {
            return inputstream;
        } else
        {
            InputStream inputstream1 = l.a(getResponseBody()).f();
            responseBodyBytes = inputstream1;
            return inputstream1;
        }
    }

    public Route getRoute()
    {
        return route;
    }

    public boolean hasResponse()
    {
        return userResponse != null;
    }

    public boolean hasResponseBody()
    {
        if (!userRequest.method().equals("HEAD"))
        {
            int i = userResponse.code();
            if ((i < 100 || i >= 200) && i != 204 && i != 304)
            {
                return true;
            }
            if (OkHeaders.contentLength(networkResponse) != -1L || "chunked".equalsIgnoreCase(networkResponse.header("Transfer-Encoding")))
            {
                return true;
            }
        }
        return false;
    }

    boolean permitsRequestBody()
    {
        return HttpMethod.permitsRequestBody(userRequest.method());
    }

    public void readResponse()
    {
        if (userResponse == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (networkRequest == null && cacheResponse == null)
        {
            throw new IllegalStateException("call sendRequest() first!");
        }
        if (networkRequest == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (bufferedRequestBody != null && bufferedRequestBody.b().a() > 0L)
        {
            bufferedRequestBody.flush();
        }
        if (sentRequestMillis == -1L)
        {
            if (OkHeaders.contentLength(networkRequest) == -1L && (requestBodyOut instanceof RetryableSink))
            {
                long l1 = ((RetryableSink)requestBodyOut).contentLength();
                networkRequest = networkRequest.newBuilder().header("Content-Length", Long.toString(l1)).build();
            }
            transport.writeRequestHeaders(networkRequest);
        }
        if (requestBodyOut != null)
        {
            InternalCache internalcache;
            if (bufferedRequestBody != null)
            {
                bufferedRequestBody.close();
            } else
            {
                requestBodyOut.close();
            }
            if (requestBodyOut instanceof RetryableSink)
            {
                transport.writeRequestBody((RetryableSink)requestBodyOut);
            }
        }
        transport.flushRequest();
        networkResponse = transport.readResponseHeaders().request(networkRequest).handshake(connection.getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
        Internal.instance.setProtocol(connection, networkResponse.protocol());
        receiveHeaders(networkResponse.headers());
        if (cacheResponse == null)
        {
            break MISSING_BLOCK_LABEL_485;
        }
        if (!validate(cacheResponse, networkResponse))
        {
            break; /* Loop/switch isn't completed */
        }
        userResponse = cacheResponse.newBuilder().request(userRequest).priorResponse(stripBody(priorResponse)).headers(combine(cacheResponse.headers(), networkResponse.headers())).cacheResponse(stripBody(cacheResponse)).networkResponse(stripBody(networkResponse)).build();
        transport.emptyTransferStream();
        releaseConnection();
        internalcache = Internal.instance.internalCache(client);
        internalcache.trackConditionalCacheHit();
        internalcache.update(cacheResponse, stripBody(userResponse));
        if (cacheResponse.body() != null)
        {
            initContentStream(cacheResponse.body().source());
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        Util.closeQuietly(cacheResponse.body());
        userResponse = networkResponse.newBuilder().request(userRequest).priorResponse(stripBody(priorResponse)).cacheResponse(stripBody(cacheResponse)).networkResponse(stripBody(networkResponse)).build();
        if (!hasResponseBody())
        {
            responseTransferSource = transport.getTransferStream(storeRequest);
            responseBody = l.a(responseTransferSource);
            return;
        } else
        {
            maybeCache();
            initContentStream(transport.getTransferStream(storeRequest));
            return;
        }
    }

    public void receiveHeaders(Headers headers)
    {
        CookieHandler cookiehandler = client.getCookieHandler();
        if (cookiehandler != null)
        {
            cookiehandler.put(userRequest.uri(), OkHeaders.toMultimap(headers, null));
        }
    }

    public HttpEngine recover(IOException ioexception)
    {
        return recover(ioexception, requestBodyOut);
    }

    public HttpEngine recover(IOException ioexception, q q1)
    {
        if (routeSelector != null && connection != null)
        {
            routeSelector.connectFailed(connection, ioexception);
        }
        boolean flag;
        if (q1 == null || (q1 instanceof RetryableSink))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (routeSelector == null && connection == null || routeSelector != null && !routeSelector.hasNext() || !isRecoverable(ioexception) || !flag)
        {
            return null;
        } else
        {
            ioexception = close();
            return new HttpEngine(client, userRequest, bufferRequestBody, ioexception, routeSelector, (RetryableSink)q1, priorResponse);
        }
    }

    public void releaseConnection()
    {
        if (transport != null && connection != null)
        {
            transport.releaseConnectionOnIdle();
        }
        connection = null;
    }

    public boolean sameConnection(URL url)
    {
        URL url1 = userRequest.url();
        return url1.getHost().equals(url.getHost()) && Util.getEffectivePort(url1) == Util.getEffectivePort(url) && url1.getProtocol().equals(url.getProtocol());
    }

    public void sendRequest()
    {
        if (cacheStrategy == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (transport != null)
        {
            throw new IllegalStateException();
        }
        Request request = networkRequest(userRequest);
        InternalCache internalcache = Internal.instance.internalCache(client);
        Response response;
        if (internalcache != null)
        {
            response = internalcache.get(request);
        } else
        {
            response = null;
        }
        cacheStrategy = (new CacheStrategy.Factory(System.currentTimeMillis(), request, response)).get();
        networkRequest = cacheStrategy.networkRequest;
        cacheResponse = cacheStrategy.cacheResponse;
        if (internalcache != null)
        {
            internalcache.trackResponse(cacheStrategy);
        }
        if (response != null && cacheResponse == null)
        {
            Util.closeQuietly(response.body());
        }
        if (networkRequest == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (connection == null)
        {
            connect(networkRequest);
        }
        transport = Internal.instance.newTransport(connection, this);
        if (permitsRequestBody() && requestBodyOut == null)
        {
            long l1 = OkHeaders.contentLength(request);
            if (bufferRequestBody)
            {
                if (l1 > 0x7fffffffL)
                {
                    throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                }
                if (l1 != -1L)
                {
                    transport.writeRequestHeaders(request);
                    requestBodyOut = new RetryableSink((int)l1);
                    return;
                } else
                {
                    requestBodyOut = new RetryableSink();
                    return;
                }
            } else
            {
                transport.writeRequestHeaders(request);
                requestBodyOut = transport.createRequestBody(request, l1);
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (connection != null)
        {
            Internal.instance.recycle(client.getConnectionPool(), connection);
            connection = null;
        }
        if (cacheResponse != null)
        {
            userResponse = cacheResponse.newBuilder().request(userRequest).priorResponse(stripBody(priorResponse)).cacheResponse(stripBody(cacheResponse)).build();
        } else
        {
            userResponse = (new com.squareup.okhttp.Response.Builder()).request(userRequest).priorResponse(stripBody(priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build();
        }
        if (userResponse.body() != null)
        {
            initContentStream(userResponse.body().source());
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void writingRequestHeaders()
    {
        if (sentRequestMillis != -1L)
        {
            throw new IllegalStateException();
        } else
        {
            sentRequestMillis = System.currentTimeMillis();
            return;
        }
    }

}
