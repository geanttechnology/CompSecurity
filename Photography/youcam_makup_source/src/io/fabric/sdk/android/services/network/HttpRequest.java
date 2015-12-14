// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.CharsetEncoder;
import java.security.AccessController;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;

public class HttpRequest
{

    private static final String BOUNDARY = "00content0boundary00";
    public static final String CHARSET_UTF8 = "UTF-8";
    private static ConnectionFactory CONNECTION_FACTORY;
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    public static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CONTENT_TYPE_MULTIPART = "multipart/form-data; boundary=00content0boundary00";
    private static final String CRLF = "\r\n";
    private static final String EMPTY_STRINGS[] = new String[0];
    public static final String ENCODING_GZIP = "gzip";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_CHARSET = "Accept-Charset";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_CONTENT_LENGTH = "Content-Length";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_DATE = "Date";
    public static final String HEADER_ETAG = "ETag";
    public static final String HEADER_EXPIRES = "Expires";
    public static final String HEADER_IF_NONE_MATCH = "If-None-Match";
    public static final String HEADER_LAST_MODIFIED = "Last-Modified";
    public static final String HEADER_LOCATION = "Location";
    public static final String HEADER_PROXY_AUTHORIZATION = "Proxy-Authorization";
    public static final String HEADER_REFERER = "Referer";
    public static final String HEADER_SERVER = "Server";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_OPTIONS = "OPTIONS";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_TRACE = "TRACE";
    public static final String PARAM_CHARSET = "charset";
    private int bufferSize;
    private HttpURLConnection connection;
    private boolean form;
    private String httpProxyHost;
    private int httpProxyPort;
    private boolean ignoreCloseExceptions;
    private boolean multipart;
    private RequestOutputStream output;
    private final String requestMethod;
    private boolean uncompress;
    public final URL url;

    public HttpRequest(CharSequence charsequence, String s)
    {
        connection = null;
        ignoreCloseExceptions = true;
        uncompress = false;
        bufferSize = 8192;
        try
        {
            url = new URL(charsequence.toString());
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            throw new HttpRequestException(charsequence);
        }
        requestMethod = s;
    }

    public HttpRequest(URL url1, String s)
    {
        connection = null;
        ignoreCloseExceptions = true;
        uncompress = false;
        bufferSize = 8192;
        url = url1;
        requestMethod = s;
    }

    private static StringBuilder addParamPrefix(String s, StringBuilder stringbuilder)
    {
        int i = s.indexOf('?');
        int j = stringbuilder.length() - 1;
        if (i == -1)
        {
            stringbuilder.append('?');
        } else
        if (i < j && s.charAt(j) != '&')
        {
            stringbuilder.append('&');
            return stringbuilder;
        }
        return stringbuilder;
    }

    private static StringBuilder addPathSeparator(String s, StringBuilder stringbuilder)
    {
        if (s.indexOf(':') + 2 == s.lastIndexOf('/'))
        {
            stringbuilder.append('/');
        }
        return stringbuilder;
    }

    public static String append(CharSequence charsequence, Map map)
    {
        Object obj = charsequence.toString();
        if (map == null || map.isEmpty())
        {
            return ((String) (obj));
        }
        charsequence = new StringBuilder(((String) (obj)));
        addPathSeparator(((String) (obj)), charsequence);
        addParamPrefix(((String) (obj)), charsequence);
        map = map.entrySet().iterator();
        obj = (java.util.Map.Entry)map.next();
        charsequence.append(((java.util.Map.Entry) (obj)).getKey().toString());
        charsequence.append('=');
        obj = ((java.util.Map.Entry) (obj)).getValue();
        if (obj != null)
        {
            charsequence.append(obj);
        }
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            charsequence.append('&');
            Object obj1 = (java.util.Map.Entry)map.next();
            charsequence.append(((java.util.Map.Entry) (obj1)).getKey().toString());
            charsequence.append('=');
            obj1 = ((java.util.Map.Entry) (obj1)).getValue();
            if (obj1 != null)
            {
                charsequence.append(obj1);
            }
        } while (true);
        return charsequence.toString();
    }

    public static transient String append(CharSequence charsequence, Object aobj[])
    {
        Object obj = charsequence.toString();
        if (aobj == null || aobj.length == 0)
        {
            return ((String) (obj));
        }
        if (aobj.length % 2 != 0)
        {
            throw new IllegalArgumentException("Must specify an even number of parameter names/values");
        }
        charsequence = new StringBuilder(((String) (obj)));
        addPathSeparator(((String) (obj)), charsequence);
        addParamPrefix(((String) (obj)), charsequence);
        charsequence.append(aobj[0]);
        charsequence.append('=');
        obj = aobj[1];
        if (obj != null)
        {
            charsequence.append(obj);
        }
        for (int i = 2; i < aobj.length; i += 2)
        {
            charsequence.append('&');
            charsequence.append(aobj[i]);
            charsequence.append('=');
            Object obj1 = aobj[i + 1];
            if (obj1 != null)
            {
                charsequence.append(obj1);
            }
        }

        return charsequence.toString();
    }

    private HttpURLConnection createConnection()
    {
        HttpURLConnection httpurlconnection;
        if (httpProxyHost == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        httpurlconnection = CONNECTION_FACTORY.create(url, createProxy());
_L1:
        httpurlconnection.setRequestMethod(requestMethod);
        return httpurlconnection;
        try
        {
            httpurlconnection = CONNECTION_FACTORY.create(url);
        }
        catch (IOException ioexception)
        {
            throw new HttpRequestException(ioexception);
        }
          goto _L1
    }

    private Proxy createProxy()
    {
        return new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(httpProxyHost, httpProxyPort));
    }

    public static HttpRequest delete(CharSequence charsequence)
    {
        return new HttpRequest(charsequence, "DELETE");
    }

    public static HttpRequest delete(CharSequence charsequence, Map map, boolean flag)
    {
        map = append(charsequence, map);
        charsequence = map;
        if (flag)
        {
            charsequence = encode(map);
        }
        return delete(charsequence);
    }

    public static transient HttpRequest delete(CharSequence charsequence, boolean flag, Object aobj[])
    {
        aobj = append(charsequence, aobj);
        charsequence = ((CharSequence) (aobj));
        if (flag)
        {
            charsequence = encode(((CharSequence) (aobj)));
        }
        return delete(charsequence);
    }

    public static HttpRequest delete(URL url1)
    {
        return new HttpRequest(url1, "DELETE");
    }

    public static String encode(CharSequence charsequence)
    {
        String s;
        URL url1;
        int i;
        try
        {
            url1 = new URL(charsequence.toString());
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            throw new HttpRequestException(charsequence);
        }
        s = url1.getHost();
        i = url1.getPort();
        charsequence = s;
        if (i != -1)
        {
            charsequence = (new StringBuilder()).append(s).append(':').append(Integer.toString(i)).toString();
        }
        try
        {
            s = (new URI(url1.getProtocol(), charsequence, url1.getPath(), url1.getQuery(), null)).toASCIIString();
            i = s.indexOf('?');
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            IOException ioexception = new IOException("Parsing URI failed");
            ioexception.initCause(charsequence);
            throw new HttpRequestException(ioexception);
        }
        charsequence = s;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        charsequence = s;
        if (i + 1 < s.length())
        {
            charsequence = (new StringBuilder()).append(s.substring(0, i + 1)).append(s.substring(i + 1).replace("+", "%2B")).toString();
        }
        return charsequence;
    }

    public static HttpRequest get(CharSequence charsequence)
    {
        return new HttpRequest(charsequence, "GET");
    }

    public static HttpRequest get(CharSequence charsequence, Map map, boolean flag)
    {
        map = append(charsequence, map);
        charsequence = map;
        if (flag)
        {
            charsequence = encode(map);
        }
        return get(charsequence);
    }

    public static transient HttpRequest get(CharSequence charsequence, boolean flag, Object aobj[])
    {
        aobj = append(charsequence, aobj);
        charsequence = ((CharSequence) (aobj));
        if (flag)
        {
            charsequence = encode(((CharSequence) (aobj)));
        }
        return get(charsequence);
    }

    public static HttpRequest get(URL url1)
    {
        return new HttpRequest(url1, "GET");
    }

    private static String getValidCharset(String s)
    {
        if (s != null && s.length() > 0)
        {
            return s;
        } else
        {
            return "UTF-8";
        }
    }

    public static HttpRequest head(CharSequence charsequence)
    {
        return new HttpRequest(charsequence, "HEAD");
    }

    public static HttpRequest head(CharSequence charsequence, Map map, boolean flag)
    {
        map = append(charsequence, map);
        charsequence = map;
        if (flag)
        {
            charsequence = encode(map);
        }
        return head(charsequence);
    }

    public static transient HttpRequest head(CharSequence charsequence, boolean flag, Object aobj[])
    {
        aobj = append(charsequence, aobj);
        charsequence = ((CharSequence) (aobj));
        if (flag)
        {
            charsequence = encode(((CharSequence) (aobj)));
        }
        return head(charsequence);
    }

    public static HttpRequest head(URL url1)
    {
        return new HttpRequest(url1, "HEAD");
    }

    public static void keepAlive(boolean flag)
    {
        setProperty("http.keepAlive", Boolean.toString(flag));
    }

    public static transient void nonProxyHosts(String as[])
    {
        if (as != null && as.length > 0)
        {
            StringBuilder stringbuilder = new StringBuilder();
            int j = as.length - 1;
            for (int i = 0; i < j; i++)
            {
                stringbuilder.append(as[i]).append('|');
            }

            stringbuilder.append(as[j]);
            setProperty("http.nonProxyHosts", stringbuilder.toString());
            return;
        } else
        {
            setProperty("http.nonProxyHosts", null);
            return;
        }
    }

    public static HttpRequest options(CharSequence charsequence)
    {
        return new HttpRequest(charsequence, "OPTIONS");
    }

    public static HttpRequest options(URL url1)
    {
        return new HttpRequest(url1, "OPTIONS");
    }

    public static HttpRequest post(CharSequence charsequence)
    {
        return new HttpRequest(charsequence, "POST");
    }

    public static HttpRequest post(CharSequence charsequence, Map map, boolean flag)
    {
        map = append(charsequence, map);
        charsequence = map;
        if (flag)
        {
            charsequence = encode(map);
        }
        return post(charsequence);
    }

    public static transient HttpRequest post(CharSequence charsequence, boolean flag, Object aobj[])
    {
        aobj = append(charsequence, aobj);
        charsequence = ((CharSequence) (aobj));
        if (flag)
        {
            charsequence = encode(((CharSequence) (aobj)));
        }
        return post(charsequence);
    }

    public static HttpRequest post(URL url1)
    {
        return new HttpRequest(url1, "POST");
    }

    public static void proxyHost(String s)
    {
        setProperty("http.proxyHost", s);
        setProperty("https.proxyHost", s);
    }

    public static void proxyPort(int i)
    {
        String s = Integer.toString(i);
        setProperty("http.proxyPort", s);
        setProperty("https.proxyPort", s);
    }

    public static HttpRequest put(CharSequence charsequence)
    {
        return new HttpRequest(charsequence, "PUT");
    }

    public static HttpRequest put(CharSequence charsequence, Map map, boolean flag)
    {
        map = append(charsequence, map);
        charsequence = map;
        if (flag)
        {
            charsequence = encode(map);
        }
        return put(charsequence);
    }

    public static transient HttpRequest put(CharSequence charsequence, boolean flag, Object aobj[])
    {
        aobj = append(charsequence, aobj);
        charsequence = ((CharSequence) (aobj));
        if (flag)
        {
            charsequence = encode(((CharSequence) (aobj)));
        }
        return put(charsequence);
    }

    public static HttpRequest put(URL url1)
    {
        return new HttpRequest(url1, "PUT");
    }

    public static void setConnectionFactory(ConnectionFactory connectionfactory)
    {
        if (connectionfactory == null)
        {
            CONNECTION_FACTORY = ConnectionFactory.DEFAULT;
            return;
        } else
        {
            CONNECTION_FACTORY = connectionfactory;
            return;
        }
    }

    private static String setProperty(String s, String s1)
    {
        if (s1 != null)
        {
            s = new _cls1(s, s1);
        } else
        {
            s = new _cls2(s);
        }
        return (String)AccessController.doPrivileged(s);
    }

    public static HttpRequest trace(CharSequence charsequence)
    {
        return new HttpRequest(charsequence, "TRACE");
    }

    public static HttpRequest trace(URL url1)
    {
        return new HttpRequest(url1, "TRACE");
    }

    public HttpRequest accept(String s)
    {
        return header("Accept", s);
    }

    public HttpRequest acceptCharset(String s)
    {
        return header("Accept-Charset", s);
    }

    public HttpRequest acceptEncoding(String s)
    {
        return header("Accept-Encoding", s);
    }

    public HttpRequest acceptGzipEncoding()
    {
        return acceptEncoding("gzip");
    }

    public HttpRequest acceptJson()
    {
        return accept("application/json");
    }

    public HttpRequest authorization(String s)
    {
        return header("Authorization", s);
    }

    public boolean badRequest()
    {
        return 400 == code();
    }

    public HttpRequest basic(String s, String s1)
    {
        return authorization((new StringBuilder()).append("Basic ").append(Base64.encode((new StringBuilder()).append(s).append(':').append(s1).toString())).toString());
    }

    public HttpRequest body(AtomicReference atomicreference)
    {
        atomicreference.set(body());
        return this;
    }

    public HttpRequest body(AtomicReference atomicreference, String s)
    {
        atomicreference.set(body(s));
        return this;
    }

    public String body()
    {
        return body(charset());
    }

    public String body(String s)
    {
        ByteArrayOutputStream bytearrayoutputstream = byteStream();
        try
        {
            copy(buffer(), bytearrayoutputstream);
            s = bytearrayoutputstream.toString(getValidCharset(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new HttpRequestException(s);
        }
        return s;
    }

    public BufferedInputStream buffer()
    {
        return new BufferedInputStream(stream(), bufferSize);
    }

    public int bufferSize()
    {
        return bufferSize;
    }

    public HttpRequest bufferSize(int i)
    {
        if (i < 1)
        {
            throw new IllegalArgumentException("Size must be greater than zero");
        } else
        {
            bufferSize = i;
            return this;
        }
    }

    public BufferedReader bufferedReader()
    {
        return bufferedReader(charset());
    }

    public BufferedReader bufferedReader(String s)
    {
        return new BufferedReader(reader(s), bufferSize);
    }

    protected ByteArrayOutputStream byteStream()
    {
        int i = contentLength();
        if (i > 0)
        {
            return new ByteArrayOutputStream(i);
        } else
        {
            return new ByteArrayOutputStream();
        }
    }

    public byte[] bytes()
    {
        ByteArrayOutputStream bytearrayoutputstream = byteStream();
        try
        {
            copy(buffer(), bytearrayoutputstream);
        }
        catch (IOException ioexception)
        {
            throw new HttpRequestException(ioexception);
        }
        return bytearrayoutputstream.toByteArray();
    }

    public String cacheControl()
    {
        return header("Cache-Control");
    }

    public String charset()
    {
        return parameter("Content-Type", "charset");
    }

    public HttpRequest chunk(int i)
    {
        getConnection().setChunkedStreamingMode(i);
        return this;
    }

    protected HttpRequest closeOutput()
    {
        if (output == null)
        {
            return this;
        }
        if (multipart)
        {
            output.write("\r\n--00content0boundary00--\r\n");
        }
        if (ignoreCloseExceptions)
        {
            try
            {
                output.close();
            }
            catch (IOException ioexception) { }
        } else
        {
            output.close();
        }
        output = null;
        return this;
    }

    protected HttpRequest closeOutputQuietly()
    {
        HttpRequest httprequest;
        try
        {
            httprequest = closeOutput();
        }
        catch (IOException ioexception)
        {
            throw new HttpRequestException(ioexception);
        }
        return httprequest;
    }

    public int code()
    {
        int i;
        try
        {
            closeOutput();
            i = getConnection().getResponseCode();
        }
        catch (IOException ioexception)
        {
            throw new HttpRequestException(ioexception);
        }
        return i;
    }

    public HttpRequest code(AtomicInteger atomicinteger)
    {
        atomicinteger.set(code());
        return this;
    }

    public HttpRequest connectTimeout(int i)
    {
        getConnection().setConnectTimeout(i);
        return this;
    }

    public String contentEncoding()
    {
        return header("Content-Encoding");
    }

    public int contentLength()
    {
        return intHeader("Content-Length");
    }

    public HttpRequest contentLength(int i)
    {
        getConnection().setFixedLengthStreamingMode(i);
        return this;
    }

    public HttpRequest contentLength(String s)
    {
        return contentLength(Integer.parseInt(s));
    }

    public HttpRequest contentType(String s)
    {
        return contentType(s, null);
    }

    public HttpRequest contentType(String s, String s1)
    {
        if (s1 != null && s1.length() > 0)
        {
            return header("Content-Type", (new StringBuilder()).append(s).append("; charset=").append(s1).toString());
        } else
        {
            return header("Content-Type", s);
        }
    }

    public String contentType()
    {
        return header("Content-Type");
    }

    protected HttpRequest copy(InputStream inputstream, OutputStream outputstream)
    {
        return (HttpRequest)(new _cls6(inputstream, ignoreCloseExceptions, inputstream, outputstream)).call();
    }

    protected HttpRequest copy(Reader reader1, Writer writer1)
    {
        return (HttpRequest)(new _cls7(reader1, ignoreCloseExceptions, reader1, writer1)).call();
    }

    public boolean created()
    {
        return 201 == code();
    }

    public long date()
    {
        return dateHeader("Date");
    }

    public long dateHeader(String s)
    {
        return dateHeader(s, -1L);
    }

    public long dateHeader(String s, long l)
    {
        closeOutputQuietly();
        return getConnection().getHeaderFieldDate(s, l);
    }

    public HttpRequest disconnect()
    {
        getConnection().disconnect();
        return this;
    }

    public String eTag()
    {
        return header("ETag");
    }

    public long expires()
    {
        return dateHeader("Expires");
    }

    public HttpRequest followRedirects(boolean flag)
    {
        getConnection().setInstanceFollowRedirects(flag);
        return this;
    }

    public HttpRequest form(Object obj, Object obj1)
    {
        return form(obj, obj1, "UTF-8");
    }

    public HttpRequest form(Object obj, Object obj1, String s)
    {
        boolean flag;
        if (!form)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            contentType("application/x-www-form-urlencoded", s);
            form = true;
        }
        s = getValidCharset(s);
        try
        {
            openOutput();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new HttpRequestException(((IOException) (obj)));
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        output.write(38);
        output.write(URLEncoder.encode(obj.toString(), s));
        output.write(61);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        output.write(URLEncoder.encode(obj1.toString(), s));
        return this;
    }

    public HttpRequest form(java.util.Map.Entry entry)
    {
        return form(entry, "UTF-8");
    }

    public HttpRequest form(java.util.Map.Entry entry, String s)
    {
        return form(entry.getKey(), entry.getValue(), s);
    }

    public HttpRequest form(Map map)
    {
        return form(map, "UTF-8");
    }

    public HttpRequest form(Map map, String s)
    {
        if (!map.isEmpty())
        {
            for (map = map.entrySet().iterator(); map.hasNext(); form((java.util.Map.Entry)map.next(), s)) { }
        }
        return this;
    }

    public HttpURLConnection getConnection()
    {
        if (connection == null)
        {
            connection = createConnection();
        }
        return connection;
    }

    protected String getParam(String s, String s1)
    {
        if (s != null && s.length() != 0) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        int k = s.length();
        int i = s.indexOf(';') + 1;
        if (i == 0 || i == k)
        {
            return null;
        }
        int j = s.indexOf(';', i);
        if (j == -1)
        {
            j = k;
        }
        int l;
        for (; i < j; j = l)
        {
            l = s.indexOf('=', i);
            if (l != -1 && l < j && s1.equals(s.substring(i, l).trim()))
            {
                String s2 = s.substring(l + 1, j).trim();
                i = s2.length();
                if (i != 0)
                {
                    s = s2;
                    if (i > 2)
                    {
                        s = s2;
                        if ('"' == s2.charAt(0))
                        {
                            s = s2;
                            if ('"' == s2.charAt(i - 1))
                            {
                                return s2.substring(1, i - 1);
                            }
                        }
                    }
                    continue; /* Loop/switch isn't completed */
                }
            }
            j++;
            l = s.indexOf(';', j);
            i = l;
            if (l == -1)
            {
                i = k;
            }
            l = i;
            i = j;
        }

        return null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected Map getParams(String s)
    {
        if (s == null || s.length() == 0)
        {
            return Collections.emptyMap();
        }
        int j = s.length();
        int k = s.indexOf(';') + 1;
        if (k == 0 || k == j)
        {
            return Collections.emptyMap();
        }
        int l = s.indexOf(';', k);
        int i = l;
        if (l == -1)
        {
            i = j;
        }
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        do
        {
            if (k >= i)
            {
                break;
            }
            int i1 = s.indexOf('=', k);
            if (i1 != -1 && i1 < i)
            {
                String s1 = s.substring(k, i1).trim();
                if (s1.length() > 0)
                {
                    String s2 = s.substring(i1 + 1, i).trim();
                    k = s2.length();
                    int j1;
                    if (k != 0)
                    {
                        if (k > 2 && '"' == s2.charAt(0) && '"' == s2.charAt(k - 1))
                        {
                            linkedhashmap.put(s1, s2.substring(1, k - 1));
                        } else
                        {
                            linkedhashmap.put(s1, s2);
                        }
                    }
                }
            }
            i1 = i + 1;
            j1 = s.indexOf(';', i1);
            i = j1;
            k = i1;
            if (j1 == -1)
            {
                i = j;
                k = i1;
            }
        } while (true);
        return linkedhashmap;
    }

    public HttpRequest header(String s, Number number)
    {
        if (number != null)
        {
            number = number.toString();
        } else
        {
            number = null;
        }
        return header(s, ((String) (number)));
    }

    public HttpRequest header(String s, String s1)
    {
        getConnection().setRequestProperty(s, s1);
        return this;
    }

    public HttpRequest header(java.util.Map.Entry entry)
    {
        return header((String)entry.getKey(), (String)entry.getValue());
    }

    public String header(String s)
    {
        closeOutputQuietly();
        return getConnection().getHeaderField(s);
    }

    public HttpRequest headers(Map map)
    {
        if (!map.isEmpty())
        {
            for (map = map.entrySet().iterator(); map.hasNext(); header((java.util.Map.Entry)map.next())) { }
        }
        return this;
    }

    public Map headers()
    {
        closeOutputQuietly();
        return getConnection().getHeaderFields();
    }

    public String[] headers(String s)
    {
        Map map = headers();
        if (map == null || map.isEmpty())
        {
            return EMPTY_STRINGS;
        }
        s = (List)map.get(s);
        if (s != null && !s.isEmpty())
        {
            return (String[])s.toArray(new String[s.size()]);
        } else
        {
            return EMPTY_STRINGS;
        }
    }

    public HttpRequest ifModifiedSince(long l)
    {
        getConnection().setIfModifiedSince(l);
        return this;
    }

    public HttpRequest ifNoneMatch(String s)
    {
        return header("If-None-Match", s);
    }

    public HttpRequest ignoreCloseExceptions(boolean flag)
    {
        ignoreCloseExceptions = flag;
        return this;
    }

    public boolean ignoreCloseExceptions()
    {
        return ignoreCloseExceptions;
    }

    public int intHeader(String s)
    {
        return intHeader(s, -1);
    }

    public int intHeader(String s, int i)
    {
        closeOutputQuietly();
        return getConnection().getHeaderFieldInt(s, i);
    }

    public boolean isBodyEmpty()
    {
        return contentLength() == 0;
    }

    public long lastModified()
    {
        return dateHeader("Last-Modified");
    }

    public String location()
    {
        return header("Location");
    }

    public String message()
    {
        String s;
        try
        {
            closeOutput();
            s = getConnection().getResponseMessage();
        }
        catch (IOException ioexception)
        {
            throw new HttpRequestException(ioexception);
        }
        return s;
    }

    public String method()
    {
        return getConnection().getRequestMethod();
    }

    public boolean notFound()
    {
        return 404 == code();
    }

    public boolean notModified()
    {
        return 304 == code();
    }

    public boolean ok()
    {
        return 200 == code();
    }

    protected HttpRequest openOutput()
    {
        if (output != null)
        {
            return this;
        } else
        {
            getConnection().setDoOutput(true);
            String s = getParam(getConnection().getRequestProperty("Content-Type"), "charset");
            output = new RequestOutputStream(getConnection().getOutputStream(), s, bufferSize);
            return this;
        }
    }

    public String parameter(String s, String s1)
    {
        return getParam(header(s), s1);
    }

    public Map parameters(String s)
    {
        return getParams(header(s));
    }

    public HttpRequest part(String s, File file)
    {
        return part(s, null, file);
    }

    public HttpRequest part(String s, InputStream inputstream)
    {
        return part(s, null, null, inputstream);
    }

    public HttpRequest part(String s, Number number)
    {
        return part(s, null, number);
    }

    public HttpRequest part(String s, String s1)
    {
        return part(s, null, s1);
    }

    public HttpRequest part(String s, String s1, File file)
    {
        return part(s, s1, null, file);
    }

    public HttpRequest part(String s, String s1, Number number)
    {
        if (number != null)
        {
            number = number.toString();
        } else
        {
            number = null;
        }
        return part(s, s1, ((String) (number)));
    }

    public HttpRequest part(String s, String s1, String s2)
    {
        return part(s, s1, null, s2);
    }

    public HttpRequest part(String s, String s1, String s2, File file)
    {
        BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(file));
        file = bufferedinputstream;
        s = part(s, s1, s2, ((InputStream) (bufferedinputstream)));
        if (bufferedinputstream != null)
        {
            try
            {
                bufferedinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return s;
            }
        }
        return s;
        s;
        file = null;
_L4:
        throw new HttpRequestException(s);
        s;
_L2:
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
        }
        throw s;
        s;
        file = null;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        file = bufferedinputstream;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public HttpRequest part(String s, String s1, String s2, InputStream inputstream)
    {
        try
        {
            startPart();
            writePartHeader(s, s1, s2);
            copy(inputstream, output);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new HttpRequestException(s);
        }
        return this;
    }

    public HttpRequest part(String s, String s1, String s2, String s3)
    {
        try
        {
            startPart();
            writePartHeader(s, s1, s2);
            output.write(s3);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new HttpRequestException(s);
        }
        return this;
    }

    public HttpRequest partHeader(String s, String s1)
    {
        return send(s).send(": ").send(s1).send("\r\n");
    }

    public HttpRequest proxyAuthorization(String s)
    {
        return header("Proxy-Authorization", s);
    }

    public HttpRequest proxyBasic(String s, String s1)
    {
        return proxyAuthorization((new StringBuilder()).append("Basic ").append(Base64.encode((new StringBuilder()).append(s).append(':').append(s1).toString())).toString());
    }

    public HttpRequest readTimeout(int i)
    {
        getConnection().setReadTimeout(i);
        return this;
    }

    public InputStreamReader reader()
    {
        return reader(charset());
    }

    public InputStreamReader reader(String s)
    {
        try
        {
            s = new InputStreamReader(stream(), getValidCharset(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new HttpRequestException(s);
        }
        return s;
    }

    public HttpRequest receive(File file)
    {
        try
        {
            file = new BufferedOutputStream(new FileOutputStream(file), bufferSize);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new HttpRequestException(file);
        }
        return (HttpRequest)(new _cls3(file, ignoreCloseExceptions, file)).call();
    }

    public HttpRequest receive(OutputStream outputstream)
    {
        try
        {
            outputstream = copy(buffer(), outputstream);
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            throw new HttpRequestException(outputstream);
        }
        return outputstream;
    }

    public HttpRequest receive(PrintStream printstream)
    {
        return receive(((OutputStream) (printstream)));
    }

    public HttpRequest receive(Writer writer1)
    {
        BufferedReader bufferedreader = bufferedReader();
        return (HttpRequest)(new _cls5(bufferedreader, ignoreCloseExceptions, bufferedreader, writer1)).call();
    }

    public HttpRequest receive(Appendable appendable)
    {
        BufferedReader bufferedreader = bufferedReader();
        return (HttpRequest)(new _cls4(bufferedreader, ignoreCloseExceptions, bufferedreader, appendable)).call();
    }

    public HttpRequest referer(String s)
    {
        return header("Referer", s);
    }

    public HttpRequest send(File file)
    {
        try
        {
            file = new BufferedInputStream(new FileInputStream(file));
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new HttpRequestException(file);
        }
        return send(((InputStream) (file)));
    }

    public HttpRequest send(InputStream inputstream)
    {
        try
        {
            openOutput();
            copy(inputstream, output);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new HttpRequestException(inputstream);
        }
        return this;
    }

    public HttpRequest send(Reader reader1)
    {
        OutputStreamWriter outputstreamwriter;
        try
        {
            openOutput();
        }
        // Misplaced declaration of an exception variable
        catch (Reader reader1)
        {
            throw new HttpRequestException(reader1);
        }
        outputstreamwriter = new OutputStreamWriter(output, RequestOutputStream.access._mth200(output).charset());
        return (HttpRequest)(new _cls8(outputstreamwriter, reader1, outputstreamwriter)).call();
    }

    public HttpRequest send(CharSequence charsequence)
    {
        try
        {
            openOutput();
            output.write(charsequence.toString());
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            throw new HttpRequestException(charsequence);
        }
        return this;
    }

    public HttpRequest send(byte abyte0[])
    {
        return send(((InputStream) (new ByteArrayInputStream(abyte0))));
    }

    public String server()
    {
        return header("Server");
    }

    public boolean serverError()
    {
        return 500 == code();
    }

    protected HttpRequest startPart()
    {
        if (!multipart)
        {
            multipart = true;
            contentType("multipart/form-data; boundary=00content0boundary00").openOutput();
            output.write("--00content0boundary00\r\n");
            return this;
        } else
        {
            output.write("\r\n--00content0boundary00\r\n");
            return this;
        }
    }

    public InputStream stream()
    {
        if (code() >= 400) goto _L2; else goto _L1
_L1:
        Object obj;
        try
        {
            obj = getConnection().getInputStream();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new HttpRequestException(((IOException) (obj)));
        }
_L4:
        if (!uncompress || !"gzip".equals(contentEncoding()))
        {
            return ((InputStream) (obj));
        }
        break; /* Loop/switch isn't completed */
_L2:
        InputStream inputstream = getConnection().getErrorStream();
        obj = inputstream;
        if (inputstream == null)
        {
            try
            {
                obj = getConnection().getInputStream();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new HttpRequestException(((IOException) (obj)));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            obj = new GZIPInputStream(((InputStream) (obj)));
        }
        catch (IOException ioexception)
        {
            throw new HttpRequestException(ioexception);
        }
        return ((InputStream) (obj));
    }

    public String toString()
    {
        return (new StringBuilder()).append(method()).append(' ').append(url()).toString();
    }

    public HttpRequest trustAllCerts()
    {
        return this;
    }

    public HttpRequest trustAllHosts()
    {
        return this;
    }

    public HttpRequest uncompress(boolean flag)
    {
        uncompress = flag;
        return this;
    }

    public URL url()
    {
        return getConnection().getURL();
    }

    public HttpRequest useCaches(boolean flag)
    {
        getConnection().setUseCaches(flag);
        return this;
    }

    public HttpRequest useProxy(String s, int i)
    {
        if (connection != null)
        {
            throw new IllegalStateException("The connection has already been created. This method must be called before reading or writing to the request.");
        } else
        {
            httpProxyHost = s;
            httpProxyPort = i;
            return this;
        }
    }

    public HttpRequest userAgent(String s)
    {
        return header("User-Agent", s);
    }

    protected HttpRequest writePartHeader(String s, String s1)
    {
        return writePartHeader(s, s1, null);
    }

    protected HttpRequest writePartHeader(String s, String s1, String s2)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("form-data; name=\"").append(s);
        if (s1 != null)
        {
            stringbuilder.append("\"; filename=\"").append(s1);
        }
        stringbuilder.append('"');
        partHeader("Content-Disposition", stringbuilder.toString());
        if (s2 != null)
        {
            partHeader("Content-Type", s2);
        }
        return send("\r\n");
    }

    public OutputStreamWriter writer()
    {
        OutputStreamWriter outputstreamwriter;
        try
        {
            openOutput();
            outputstreamwriter = new OutputStreamWriter(output, RequestOutputStream.access._mth200(output).charset());
        }
        catch (IOException ioexception)
        {
            throw new HttpRequestException(ioexception);
        }
        return outputstreamwriter;
    }

    static 
    {
        CONNECTION_FACTORY = ConnectionFactory.DEFAULT;
    }



    /* member class not found */
    class HttpRequestException {}


    /* member class not found */
    class ConnectionFactory {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class Base64 {}


    /* member class not found */
    class RequestOutputStream {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls8 {}

}
