// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

public class HttpRequest
{
    protected static abstract class CloseOperation extends Operation
    {

        private final Closeable closeable;
        private final boolean ignoreCloseExceptions;

        protected void done()
            throws IOException
        {
            if (closeable instanceof Flushable)
            {
                ((Flushable)closeable).flush();
            }
            if (ignoreCloseExceptions)
            {
                try
                {
                    closeable.close();
                    return;
                }
                catch (IOException ioexception)
                {
                    return;
                }
            } else
            {
                closeable.close();
                return;
            }
        }

        protected CloseOperation(Closeable closeable1, boolean flag)
        {
            closeable = closeable1;
            ignoreCloseExceptions = flag;
        }
    }

    public static interface ConnectionFactory
    {

        public static final ConnectionFactory DEFAULT = new ConnectionFactory() {

            public HttpURLConnection create(URL url1)
                throws IOException
            {
                return (HttpURLConnection)url1.openConnection();
            }

            public HttpURLConnection create(URL url1, Proxy proxy)
                throws IOException
            {
                return (HttpURLConnection)url1.openConnection(proxy);
            }

        };

        public abstract HttpURLConnection create(URL url1)
            throws IOException;

        public abstract HttpURLConnection create(URL url1, Proxy proxy)
            throws IOException;

    }

    public static class HttpRequestException extends RuntimeException
    {

        public IOException getCause()
        {
            return (IOException)super.getCause();
        }

        public volatile Throwable getCause()
        {
            return getCause();
        }

        protected HttpRequestException(IOException ioexception)
        {
            super(ioexception);
        }
    }

    protected static abstract class Operation
        implements Callable
    {

        public Object call()
            throws HttpRequestException
        {
            boolean flag = false;
            Object obj = run();
            done();
_L2:
            return obj;
            IOException ioexception;
            ioexception;
            if (false) goto _L2; else goto _L1
_L1:
            throw new HttpRequestException(ioexception);
            Object obj1;
            obj1;
            flag = true;
            throw obj1;
            obj1;
            try
            {
                done();
            }
            catch (IOException ioexception1)
            {
                if (!flag)
                {
                    throw new HttpRequestException(ioexception1);
                }
            }
            throw obj1;
            obj1;
            flag = true;
            throw new HttpRequestException(((IOException) (obj1)));
        }

        protected abstract void done()
            throws IOException;

        protected abstract Object run()
            throws HttpRequestException, IOException;

        protected Operation()
        {
        }
    }

    public static class RequestOutputStream extends BufferedOutputStream
    {

        private final CharsetEncoder encoder;

        public RequestOutputStream write(String s)
            throws IOException
        {
            s = encoder.encode(CharBuffer.wrap(s));
            super.write(s.array(), 0, s.limit());
            return this;
        }

        public RequestOutputStream(OutputStream outputstream, String s, int i)
        {
            super(outputstream, i);
            encoder = Charset.forName(HttpRequest.getValidCharset(s)).newEncoder();
        }
    }


    private static ConnectionFactory CONNECTION_FACTORY;
    private static final String EMPTY_STRINGS[] = new String[0];
    private int bufferSize;
    private HttpURLConnection connection;
    private String httpProxyHost;
    private int httpProxyPort;
    private boolean ignoreCloseExceptions;
    private boolean multipart;
    private RequestOutputStream output;
    private final String requestMethod;
    private boolean uncompress;
    public final URL url;

    public HttpRequest(CharSequence charsequence, String s)
        throws HttpRequestException
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
        throws HttpRequestException
    {
        return new HttpRequest(charsequence, "DELETE");
    }

    public static String encode(CharSequence charsequence)
        throws HttpRequestException
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
        throws HttpRequestException
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

    public static HttpRequest post(CharSequence charsequence)
        throws HttpRequestException
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

    public static HttpRequest put(CharSequence charsequence)
        throws HttpRequestException
    {
        return new HttpRequest(charsequence, "PUT");
    }

    public String body()
        throws HttpRequestException
    {
        return body(charset());
    }

    public String body(String s)
        throws HttpRequestException
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
        throws HttpRequestException
    {
        return new BufferedInputStream(stream(), bufferSize);
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

    public String charset()
    {
        return parameter("Content-Type", "charset");
    }

    protected HttpRequest closeOutput()
        throws IOException
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
        throws HttpRequestException
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
        throws HttpRequestException
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

    protected HttpRequest copy(final InputStream final_closeable, OutputStream outputstream)
        throws IOException
    {
        return (HttpRequest)(new CloseOperation(final_closeable, outputstream) {

            final HttpRequest this$0;
            final InputStream val$input;
            final OutputStream val$output;

            public HttpRequest run()
                throws IOException
            {
                byte abyte0[] = new byte[bufferSize];
                do
                {
                    int i = input.read(abyte0);
                    if (i != -1)
                    {
                        output.write(abyte0, 0, i);
                    } else
                    {
                        return HttpRequest.this;
                    }
                } while (true);
            }

            public volatile Object run()
                throws HttpRequestException, IOException
            {
                return run();
            }

            
            {
                this$0 = HttpRequest.this;
                input = inputstream;
                output = outputstream;
                super(final_closeable, final_flag);
            }
        }).call();
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
        int j = s.length();
        int l = s.indexOf(';') + 1;
        if (l == 0 || l == j)
        {
            return null;
        }
        int j1 = s.indexOf(';', l);
        int i = j1;
        int k = l;
        if (j1 == -1)
        {
            i = j;
            k = l;
        }
        do
        {
            if (k >= i)
            {
                break;
            }
            int i1 = s.indexOf('=', k);
            if (i1 != -1 && i1 < i && s1.equals(s.substring(k, i1).trim()))
            {
                String s2 = s.substring(i1 + 1, i).trim();
                k = s2.length();
                if (k != 0)
                {
                    s = s2;
                    if (k > 2)
                    {
                        s = s2;
                        if ('"' == s2.charAt(0))
                        {
                            s = s2;
                            if ('"' == s2.charAt(k - 1))
                            {
                                return s2.substring(1, k - 1);
                            }
                        }
                    }
                    continue; /* Loop/switch isn't completed */
                }
            }
            i1 = i + 1;
            int k1 = s.indexOf(';', i1);
            i = k1;
            k = i1;
            if (k1 == -1)
            {
                i = j;
                k = i1;
            }
        } while (true);
        return null;
        if (true) goto _L4; else goto _L3
_L3:
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
        throws HttpRequestException
    {
        closeOutputQuietly();
        return getConnection().getHeaderField(s);
    }

    public int intHeader(String s)
        throws HttpRequestException
    {
        return intHeader(s, -1);
    }

    public int intHeader(String s, int i)
        throws HttpRequestException
    {
        closeOutputQuietly();
        return getConnection().getHeaderFieldInt(s, i);
    }

    public String method()
    {
        return getConnection().getRequestMethod();
    }

    public boolean ok()
        throws HttpRequestException
    {
        return 200 == code();
    }

    protected HttpRequest openOutput()
        throws IOException
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

    public HttpRequest part(String s, Number number)
        throws HttpRequestException
    {
        return part(s, null, number);
    }

    public HttpRequest part(String s, String s1)
    {
        return part(s, null, s1);
    }

    public HttpRequest part(String s, String s1, Number number)
        throws HttpRequestException
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
        throws HttpRequestException
    {
        return part(s, s1, null, s2);
    }

    public HttpRequest part(String s, String s1, String s2, File file)
        throws HttpRequestException
    {
        File file1;
        Object obj;
        file1 = null;
        obj = null;
        file = new BufferedInputStream(new FileInputStream(file));
        s = part(s, s1, s2, ((InputStream) (file)));
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return s;
            }
        }
        return s;
        s;
        file1 = obj;
_L4:
        throw new HttpRequestException(s);
        s;
_L2:
        if (file1 != null)
        {
            try
            {
                file1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
        }
        throw s;
        s;
        file1 = file;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        file1 = file;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public HttpRequest part(String s, String s1, String s2, InputStream inputstream)
        throws HttpRequestException
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
        throws HttpRequestException
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
        throws HttpRequestException
    {
        return send(s).send(": ").send(s1).send("\r\n");
    }

    public HttpRequest send(CharSequence charsequence)
        throws HttpRequestException
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

    protected HttpRequest startPart()
        throws IOException
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
        throws HttpRequestException
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

    public URL url()
    {
        return getConnection().getURL();
    }

    public HttpRequest useCaches(boolean flag)
    {
        getConnection().setUseCaches(flag);
        return this;
    }

    protected HttpRequest writePartHeader(String s, String s1, String s2)
        throws IOException
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

    static 
    {
        CONNECTION_FACTORY = ConnectionFactory.DEFAULT;
    }


}
