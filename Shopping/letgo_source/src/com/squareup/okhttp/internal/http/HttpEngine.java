// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import android.support.v7.apv;
import android.support.v7.apw;
import android.support.v7.apx;
import android.support.v7.aqc;
import android.support.v7.aqe;
import android.support.v7.aqj;
import android.support.v7.aqk;
import android.support.v7.aql;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            CacheRequest, RealResponseBody, OkHeaders, RouteSelector, 
//            CacheStrategy, HttpMethod, Transport, RetryableSink

public final class HttpEngine
{
    class NetworkInterceptorChain
        implements com.squareup.okhttp.Interceptor.Chain
    {

        private int calls;
        private final int index;
        private final Request request;
        final HttpEngine this$0;

        public Connection connection()
        {
            return HttpEngine.this.connection;
        }

        public Response proceed(Request request1)
            throws IOException
        {
            calls = calls + 1;
            if (index > 0)
            {
                Interceptor interceptor = (Interceptor)client.networkInterceptors().get(index - 1);
                Address address1 = connection().getRoute().getAddress();
                if (!request1.url().getHost().equals(address1.getUriHost()) || Util.getEffectivePort(request1.url()) != address1.getUriPort())
                {
                    throw new IllegalStateException((new StringBuilder()).append("network interceptor ").append(interceptor).append(" must retain the same host and port").toString());
                }
                if (calls > 1)
                {
                    throw new IllegalStateException((new StringBuilder()).append("network interceptor ").append(interceptor).append(" must call proceed() exactly once").toString());
                }
            }
            if (index < client.networkInterceptors().size())
            {
                request1 = new NetworkInterceptorChain(index + 1, request1);
                Interceptor interceptor1 = (Interceptor)client.networkInterceptors().get(index);
                Response response = interceptor1.intercept(request1);
                if (((NetworkInterceptorChain) (request1)).calls != 1)
                {
                    throw new IllegalStateException((new StringBuilder()).append("network interceptor ").append(interceptor1).append(" must call proceed() exactly once").toString());
                } else
                {
                    return response;
                }
            }
            transport.writeRequestHeaders(request1);
            if (permitsRequestBody() && request1.body() != null)
            {
                apw apw1 = aqe.a(transport.createRequestBody(request1, request1.body().contentLength()));
                request1.body().writeTo(apw1);
                apw1.close();
            }
            return readNetworkResponse();
        }

        public Request request()
        {
            return request;
        }

        NetworkInterceptorChain(int i, Request request1)
        {
            this$0 = HttpEngine.this;
            super();
            index = i;
            request = request1;
        }
    }


    private static final ResponseBody EMPTY_BODY = new ResponseBody() {

        public long contentLength()
        {
            return 0L;
        }

        public MediaType contentType()
        {
            return null;
        }

        public apx source()
        {
            return new apv();
        }

    };
    public static final int MAX_FOLLOW_UPS = 20;
    private Address address;
    public final boolean bufferRequestBody;
    private apw bufferedRequestBody;
    private Response cacheResponse;
    private CacheStrategy cacheStrategy;
    private final boolean callerWritesRequestBody;
    final OkHttpClient client;
    private Connection connection;
    private final boolean forWebSocket;
    private Request networkRequest;
    private final Response priorResponse;
    private aqj requestBodyOut;
    private Route route;
    private RouteSelector routeSelector;
    long sentRequestMillis;
    private CacheRequest storeRequest;
    private boolean transparentGzip;
    private Transport transport;
    private final Request userRequest;
    private Response userResponse;

    public HttpEngine(OkHttpClient okhttpclient, Request request, boolean flag, boolean flag1, boolean flag2, Connection connection1, RouteSelector routeselector, 
            RetryableSink retryablesink, Response response)
    {
        sentRequestMillis = -1L;
        client = okhttpclient;
        userRequest = request;
        bufferRequestBody = flag;
        callerWritesRequestBody = flag1;
        forWebSocket = flag2;
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

    private Response cacheWritingResponse(CacheRequest cacherequest, Response response)
        throws IOException
    {
        aqj aqj1;
        if (cacherequest != null)
        {
            if ((aqj1 = cacherequest.body()) != null)
            {
                cacherequest = new aqk() {

                    boolean cacheRequestClosed;
                    final HttpEngine this$0;
                    final apw val$cacheBody;
                    final CacheRequest val$cacheRequest;
                    final apx val$source;

                    public void close()
                        throws IOException
                    {
                        if (!cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS))
                        {
                            cacheRequestClosed = true;
                            cacheRequest.abort();
                        }
                        source.close();
                    }

                    public long read(apv apv1, long l)
                        throws IOException
                    {
                        try
                        {
                            l = source.read(apv1, l);
                        }
                        // Misplaced declaration of an exception variable
                        catch (apv apv1)
                        {
                            if (!cacheRequestClosed)
                            {
                                cacheRequestClosed = true;
                                cacheRequest.abort();
                            }
                            throw apv1;
                        }
                        if (l == -1L)
                        {
                            if (!cacheRequestClosed)
                            {
                                cacheRequestClosed = true;
                                cacheBody.close();
                            }
                            return -1L;
                        } else
                        {
                            apv1.a(cacheBody.b(), apv1.a() - l, l);
                            cacheBody.v();
                            return l;
                        }
                    }

                    public aql timeout()
                    {
                        return source.timeout();
                    }

            
            {
                this$0 = HttpEngine.this;
                source = apx1;
                cacheRequest = cacherequest;
                cacheBody = apw1;
                super();
            }
                };
                return response.newBuilder().body(new RealResponseBody(response.headers(), aqe.a(cacherequest))).build();
            }
        }
        return response;
    }

    private static Headers combine(Headers headers, Headers headers1)
        throws IOException
    {
        boolean flag = false;
        com.squareup.okhttp.Headers.Builder builder = new com.squareup.okhttp.Headers.Builder();
        int j = headers.size();
        int i = 0;
        do
        {
            if (i >= j)
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
        j = headers1.size();
        i = ((flag) ? 1 : 0);
        do
        {
            if (i >= j)
            {
                break;
            }
            headers = headers1.name(i);
            if (!"Content-Length".equalsIgnoreCase(headers) && OkHeaders.isEndToEnd(headers))
            {
                builder.add(headers, headers1.value(i));
            }
            i++;
        } while (true);
        return builder.build();
    }

    private void connect()
        throws IOException
    {
        if (connection != null)
        {
            throw new IllegalStateException();
        }
        if (routeSelector == null)
        {
            address = createAddress(client, networkRequest);
            routeSelector = RouteSelector.get(address, networkRequest, client);
        }
        connection = nextConnection();
        route = connection.getRoute();
    }

    private void connectFailed(RouteSelector routeselector, IOException ioexception)
    {
        if (Internal.instance.recycleCount(connection) > 0)
        {
            return;
        } else
        {
            routeselector.connectFailed(connection.getRoute(), ioexception);
            return;
        }
    }

    private static Address createAddress(OkHttpClient okhttpclient, Request request)
        throws UnknownHostException
    {
        com.squareup.okhttp.CertificatePinner certificatepinner = null;
        String s = request.url().getHost();
        if (s == null || s.length() == 0)
        {
            throw new UnknownHostException(request.url().toString());
        }
        javax.net.ssl.SSLSocketFactory sslsocketfactory;
        javax.net.ssl.HostnameVerifier hostnameverifier;
        if (request.isHttps())
        {
            sslsocketfactory = okhttpclient.getSslSocketFactory();
            hostnameverifier = okhttpclient.getHostnameVerifier();
            certificatepinner = okhttpclient.getCertificatePinner();
        } else
        {
            hostnameverifier = null;
            sslsocketfactory = null;
        }
        return new Address(s, Util.getEffectivePort(request.url()), okhttpclient.getSocketFactory(), sslsocketfactory, hostnameverifier, certificatepinner, okhttpclient.getAuthenticator(), okhttpclient.getProxy(), okhttpclient.getProtocols(), okhttpclient.getConnectionSpecs(), okhttpclient.getProxySelector());
    }

    private Connection createNextConnection()
        throws IOException
    {
        ConnectionPool connectionpool = client.getConnectionPool();
        do
        {
            Connection connection1 = connectionpool.get(address);
            if (connection1 != null)
            {
                if (networkRequest.method().equals("GET") || Internal.instance.isReadable(connection1))
                {
                    return connection1;
                }
                connection1.getSocket().close();
            } else
            {
                return new Connection(connectionpool, routeSelector.next());
            }
        } while (true);
    }

    public static boolean hasBody(Response response)
    {
        if (!response.request().method().equals("HEAD"))
        {
            int i = response.code();
            if ((i < 100 || i >= 200) && i != 204 && i != 304)
            {
                return true;
            }
            if (OkHeaders.contentLength(response) != -1L || "chunked".equalsIgnoreCase(response.header("Transfer-Encoding")))
            {
                return true;
            }
        }
        return false;
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

    private boolean isRecoverable(IOException ioexception)
    {
        while (!client.getRetryOnConnectionFailure() || (ioexception instanceof SSLPeerUnverifiedException) || (ioexception instanceof SSLHandshakeException) && (ioexception.getCause() instanceof CertificateException) || (ioexception instanceof ProtocolException) || (ioexception instanceof InterruptedIOException)) 
        {
            return false;
        }
        return true;
    }

    private void maybeCache()
        throws IOException
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
        throws IOException
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

    private Connection nextConnection()
        throws IOException
    {
        Connection connection1 = createNextConnection();
        Internal.instance.connectAndSetOwner(client, connection1, this, networkRequest);
        return connection1;
    }

    private Response readNetworkResponse()
        throws IOException
    {
        transport.finishRequest();
        Response response1 = transport.readResponseHeaders().request(networkRequest).handshake(connection.getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
        Response response = response1;
        if (!forWebSocket)
        {
            response = response1.newBuilder().body(transport.openResponseBody(response1)).build();
        }
        Internal.instance.setProtocol(connection, response.protocol());
        return response;
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

    private Response unzip(Response response)
        throws IOException
    {
        while (!transparentGzip || !"gzip".equalsIgnoreCase(userResponse.header("Content-Encoding")) || response.body() == null) 
        {
            return response;
        }
        aqc aqc1 = new aqc(response.body().source());
        Headers headers = response.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
        return response.newBuilder().headers(headers).body(new RealResponseBody(headers, aqe.a(aqc1))).build();
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
        if (userResponse == null)
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
        Util.closeQuietly(userResponse.body());
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
        throws IOException
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

    public apw getBufferedRequestBody()
    {
        Object obj = bufferedRequestBody;
        if (obj != null)
        {
            return ((apw) (obj));
        }
        obj = getRequestBody();
        if (obj != null)
        {
            obj = aqe.a(((aqj) (obj)));
            bufferedRequestBody = ((apw) (obj));
            return ((apw) (obj));
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

    public aqj getRequestBody()
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

    public Route getRoute()
    {
        return route;
    }

    public boolean hasResponse()
    {
        return userResponse != null;
    }

    boolean permitsRequestBody()
    {
        return HttpMethod.permitsRequestBody(userRequest.method());
    }

    public void readResponse()
        throws IOException
    {
        if (userResponse == null)
        {
            if (networkRequest == null && cacheResponse == null)
            {
                throw new IllegalStateException("call sendRequest() first!");
            }
            if (networkRequest != null)
            {
                Object obj;
                if (forWebSocket)
                {
                    transport.writeRequestHeaders(networkRequest);
                    obj = readNetworkResponse();
                } else
                if (!callerWritesRequestBody)
                {
                    obj = (new NetworkInterceptorChain(0, networkRequest)).proceed(networkRequest);
                } else
                {
                    if (bufferedRequestBody != null && bufferedRequestBody.b().a() > 0L)
                    {
                        bufferedRequestBody.e();
                    }
                    if (sentRequestMillis == -1L)
                    {
                        if (OkHeaders.contentLength(networkRequest) == -1L && (requestBodyOut instanceof RetryableSink))
                        {
                            long l = ((RetryableSink)requestBodyOut).contentLength();
                            networkRequest = networkRequest.newBuilder().header("Content-Length", Long.toString(l)).build();
                        }
                        transport.writeRequestHeaders(networkRequest);
                    }
                    if (requestBodyOut != null)
                    {
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
                    obj = readNetworkResponse();
                }
                receiveHeaders(((Response) (obj)).headers());
                if (cacheResponse != null)
                {
                    if (validate(cacheResponse, ((Response) (obj))))
                    {
                        userResponse = cacheResponse.newBuilder().request(userRequest).priorResponse(stripBody(priorResponse)).headers(combine(cacheResponse.headers(), ((Response) (obj)).headers())).cacheResponse(stripBody(cacheResponse)).networkResponse(stripBody(((Response) (obj)))).build();
                        ((Response) (obj)).body().close();
                        releaseConnection();
                        obj = Internal.instance.internalCache(client);
                        ((InternalCache) (obj)).trackConditionalCacheHit();
                        ((InternalCache) (obj)).update(cacheResponse, stripBody(userResponse));
                        userResponse = unzip(userResponse);
                        return;
                    }
                    Util.closeQuietly(cacheResponse.body());
                }
                userResponse = ((Response) (obj)).newBuilder().request(userRequest).priorResponse(stripBody(priorResponse)).cacheResponse(stripBody(cacheResponse)).networkResponse(stripBody(((Response) (obj)))).build();
                if (hasBody(userResponse))
                {
                    maybeCache();
                    userResponse = unzip(cacheWritingResponse(storeRequest, userResponse));
                    return;
                }
            }
        }
    }

    public void receiveHeaders(Headers headers)
        throws IOException
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

    public HttpEngine recover(IOException ioexception, aqj aqj1)
    {
        if (routeSelector != null && connection != null)
        {
            connectFailed(routeSelector, ioexception);
        }
        boolean flag;
        if (aqj1 == null || (aqj1 instanceof RetryableSink))
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
            return new HttpEngine(client, userRequest, bufferRequestBody, callerWritesRequestBody, forWebSocket, ioexception, routeSelector, (RetryableSink)aqj1, priorResponse);
        }
    }

    public void releaseConnection()
        throws IOException
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
        throws IOException
    {
        if (cacheStrategy == null)
        {
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
            if (networkRequest != null)
            {
                if (connection == null)
                {
                    connect();
                }
                transport = Internal.instance.newTransport(connection, this);
                if (callerWritesRequestBody && permitsRequestBody() && requestBodyOut == null)
                {
                    long l = OkHeaders.contentLength(request);
                    if (bufferRequestBody)
                    {
                        if (l > 0x7fffffffL)
                        {
                            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                        }
                        if (l != -1L)
                        {
                            transport.writeRequestHeaders(networkRequest);
                            requestBodyOut = new RetryableSink((int)l);
                            return;
                        } else
                        {
                            requestBodyOut = new RetryableSink();
                            return;
                        }
                    } else
                    {
                        transport.writeRequestHeaders(networkRequest);
                        requestBodyOut = transport.createRequestBody(networkRequest, l);
                        return;
                    }
                }
            } else
            {
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
                userResponse = unzip(userResponse);
                return;
            }
        }
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
