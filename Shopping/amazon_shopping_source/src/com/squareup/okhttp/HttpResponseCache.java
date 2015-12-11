// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.Headers;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.Request;
import com.squareup.okhttp.internal.http.Response;
import com.squareup.okhttp.internal.okio.BufferedSource;
import com.squareup.okhttp.internal.okio.ByteString;
import com.squareup.okhttp.internal.okio.Okio;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.squareup.okhttp:
//            OkResponseCache, ResponseSource, MediaType, Handshake

public final class HttpResponseCache extends ResponseCache
    implements OkResponseCache
{
    private static class CacheResponseBody extends com.squareup.okhttp.internal.http.Response.Body
    {

        private final InputStream bodyIn;
        private final String contentLength;
        private final String contentType;
        private final com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot;

        public InputStream byteStream()
        {
            return bodyIn;
        }

        public long contentLength()
        {
            long l = -1L;
            try
            {
                if (contentLength != null)
                {
                    l = Long.parseLong(contentLength);
                }
            }
            catch (NumberFormatException numberformatexception)
            {
                return -1L;
            }
            return l;
        }

        public MediaType contentType()
        {
            if (contentType != null)
            {
                return MediaType.parse(contentType);
            } else
            {
                return null;
            }
        }

        public boolean ready()
            throws IOException
        {
            return true;
        }


        public CacheResponseBody(com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot1, String s, String s1)
        {
            snapshot = snapshot1;
            contentType = s;
            contentLength = s1;
            bodyIn = snapshot1.getInputStream(1). new _cls1(snapshot1);
        }
    }

    private static final class Entry
    {

        private final Handshake handshake;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final String statusLine;
        private final String url;
        private final Headers varyHeaders;

        private boolean isHttps()
        {
            return url.startsWith("https://");
        }

        private List readCertificateList(BufferedSource bufferedsource)
            throws IOException
        {
            int j = HttpResponseCache.readInt(bufferedsource);
            if (j != -1) goto _L2; else goto _L1
_L1:
            Object obj = Collections.emptyList();
_L4:
            return ((List) (obj));
_L2:
            ArrayList arraylist;
            CertificateFactory certificatefactory;
            int i;
            try
            {
                certificatefactory = CertificateFactory.getInstance("X.509");
                arraylist = new ArrayList(j);
            }
            // Misplaced declaration of an exception variable
            catch (BufferedSource bufferedsource)
            {
                throw new IOException(bufferedsource.getMessage());
            }
            i = 0;
            obj = arraylist;
            if (i >= j) goto _L4; else goto _L3
_L3:
            arraylist.add(certificatefactory.generateCertificate(new ByteArrayInputStream(ByteString.decodeBase64(bufferedsource.readUtf8Line(true)).toByteArray())));
            i++;
            break MISSING_BLOCK_LABEL_38;
        }

        private void writeCertArray(Writer writer, List list)
            throws IOException
        {
            String s;
            int i;
            int j;
            try
            {
                writer.write((new StringBuilder()).append(Integer.toString(list.size())).append('\n').toString());
            }
            // Misplaced declaration of an exception variable
            catch (Writer writer)
            {
                throw new IOException(writer.getMessage());
            }
            i = 0;
            j = list.size();
_L2:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            s = ByteString.of(((Certificate)list.get(i)).getEncoded()).base64();
            writer.write((new StringBuilder()).append(s).append('\n').toString());
            i++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public boolean matches(Request request, Response response1)
        {
            return url.equals(request.urlString()) && requestMethod.equals(request.method()) && response1.varyMatches(varyHeaders, request);
        }

        public Response response(Request request, com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot)
        {
            String s = responseHeaders.get("Content-Type");
            String s1 = responseHeaders.get("Content-Length");
            return (new com.squareup.okhttp.internal.http.Response.Builder()).request(request).statusLine(statusLine).headers(responseHeaders).body(new CacheResponseBody(snapshot, s, s1)).handshake(handshake).build();
        }

        public void writeTo(com.squareup.okhttp.internal.DiskLruCache.Editor editor)
            throws IOException
        {
            editor = new BufferedWriter(new OutputStreamWriter(editor.newOutputStream(0), Util.UTF_8));
            editor.write((new StringBuilder()).append(url).append('\n').toString());
            editor.write((new StringBuilder()).append(requestMethod).append('\n').toString());
            editor.write((new StringBuilder()).append(Integer.toString(varyHeaders.size())).append('\n').toString());
            for (int i = 0; i < varyHeaders.size(); i++)
            {
                editor.write((new StringBuilder()).append(varyHeaders.name(i)).append(": ").append(varyHeaders.value(i)).append('\n').toString());
            }

            editor.write((new StringBuilder()).append(statusLine).append('\n').toString());
            editor.write((new StringBuilder()).append(Integer.toString(responseHeaders.size())).append('\n').toString());
            for (int j = 0; j < responseHeaders.size(); j++)
            {
                editor.write((new StringBuilder()).append(responseHeaders.name(j)).append(": ").append(responseHeaders.value(j)).append('\n').toString());
            }

            if (isHttps())
            {
                editor.write(10);
                editor.write((new StringBuilder()).append(handshake.cipherSuite()).append('\n').toString());
                writeCertArray(editor, handshake.peerCertificates());
                writeCertArray(editor, handshake.localCertificates());
            }
            editor.close();
        }

        public Entry(Response response1)
        {
            url = response1.request().urlString();
            varyHeaders = response1.request().headers().getAll(response1.getVaryFields());
            requestMethod = response1.request().method();
            statusLine = response1.statusLine();
            responseHeaders = response1.headers();
            handshake = response1.handshake();
        }

        public Entry(InputStream inputstream)
            throws IOException
        {
            Object obj;
            Object obj1;
            int j;
            obj = Okio.buffer(Okio.source(inputstream));
            url = ((BufferedSource) (obj)).readUtf8Line(true);
            requestMethod = ((BufferedSource) (obj)).readUtf8Line(true);
            obj1 = new com.squareup.okhttp.internal.http.Headers.Builder();
            j = HttpResponseCache.readInt(((BufferedSource) (obj)));
            int i = 0;
_L2:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            ((com.squareup.okhttp.internal.http.Headers.Builder) (obj1)).addLine(((BufferedSource) (obj)).readUtf8Line(true));
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            varyHeaders = ((com.squareup.okhttp.internal.http.Headers.Builder) (obj1)).build();
            statusLine = ((BufferedSource) (obj)).readUtf8Line(true);
            obj1 = new com.squareup.okhttp.internal.http.Headers.Builder();
            j = HttpResponseCache.readInt(((BufferedSource) (obj)));
            i = 0;
_L4:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            ((com.squareup.okhttp.internal.http.Headers.Builder) (obj1)).addLine(((BufferedSource) (obj)).readUtf8Line(true));
            i++;
            if (true) goto _L4; else goto _L3
_L3:
            responseHeaders = ((com.squareup.okhttp.internal.http.Headers.Builder) (obj1)).build();
            if (!isHttps())
            {
                break MISSING_BLOCK_LABEL_241;
            }
            obj1 = ((BufferedSource) (obj)).readUtf8Line(true);
            if (((String) (obj1)).length() > 0)
            {
                throw new IOException((new StringBuilder()).append("expected \"\" but was \"").append(((String) (obj1))).append("\"").toString());
            }
            break MISSING_BLOCK_LABEL_212;
            obj;
            inputstream.close();
            throw obj;
            handshake = Handshake.get(((BufferedSource) (obj)).readUtf8Line(true), readCertificateList(((BufferedSource) (obj))), readCertificateList(((BufferedSource) (obj))));
_L5:
            inputstream.close();
            return;
            handshake = null;
              goto _L5
        }
    }


    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 0x31191;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    public HttpResponseCache(File file, long l)
        throws IOException
    {
        cache = DiskLruCache.open(file, 0x31191, 2, l);
    }

    private void abortQuietly(com.squareup.okhttp.internal.DiskLruCache.Editor editor)
    {
        if (editor == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        editor.abort();
        return;
        editor;
    }

    private static int readInt(BufferedSource bufferedsource)
        throws IOException
    {
        bufferedsource = bufferedsource.readUtf8Line(true);
        int i;
        try
        {
            i = Integer.parseInt(bufferedsource);
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new IOException((new StringBuilder()).append("Expected an integer but was \"").append(bufferedsource).append("\"").toString());
        }
        return i;
    }

    private static String urlToKey(Request request)
    {
        return Util.hash(request.urlString());
    }

    public void close()
        throws IOException
    {
        cache.close();
    }

    public void delete()
        throws IOException
    {
        cache.delete();
    }

    public void flush()
        throws IOException
    {
        cache.flush();
    }

    public Response get(Request request)
    {
        Object obj = urlToKey(request);
        obj = cache.get(((String) (obj)));
        if (obj == null)
        {
            return null;
        }
        Entry entry = new Entry(((com.squareup.okhttp.internal.DiskLruCache.Snapshot) (obj)).getInputStream(0));
        Response response = entry.response(request, ((com.squareup.okhttp.internal.DiskLruCache.Snapshot) (obj)));
        obj = response;
        if (!entry.matches(request, response))
        {
            Util.closeQuietly(response.body());
            return null;
        }
        break MISSING_BLOCK_LABEL_66;
        request;
        obj = null;
        return ((Response) (obj));
    }

    public CacheResponse get(URI uri, String s, Map map)
        throws IOException
    {
        throw new UnsupportedOperationException("This is not a general purpose response cache.");
    }

    public File getDirectory()
    {
        return cache.getDirectory();
    }

    public int getHitCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = hitCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public long getMaxSize()
    {
        return cache.getMaxSize();
    }

    public int getNetworkCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = networkCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getRequestCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = requestCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public long getSize()
    {
        return cache.size();
    }

    public int getWriteAbortCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = writeAbortCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getWriteSuccessCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = writeSuccessCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isClosed()
    {
        return cache.isClosed();
    }

    public boolean maybeRemove(Request request)
    {
        if (HttpMethod.invalidatesCache(request.method()))
        {
            try
            {
                cache.remove(urlToKey(request));
            }
            // Misplaced declaration of an exception variable
            catch (Request request) { }
            return true;
        } else
        {
            return false;
        }
    }

    public CacheRequest put(Response response)
        throws IOException
    {
        Object obj;
        obj = response.request().method();
        break MISSING_BLOCK_LABEL_8;
        while (response == null) 
        {
            do
            {
                return null;
            } while (maybeRemove(response.request()) || !((String) (obj)).equals("GET") || response.hasVaryAll());
            Entry entry = new Entry(response);
            obj = null;
            try
            {
                response = cache.edit(urlToKey(response.request()));
            }
            // Misplaced declaration of an exception variable
            catch (Response response)
            {
                abortQuietly(((com.squareup.okhttp.internal.DiskLruCache.Editor) (obj)));
                return null;
            }
        }
        obj = response;
        entry.writeTo(response);
        obj = response;
        response = new CacheRequestImpl(response);
        return response;
    }

    public CacheRequest put(URI uri, URLConnection urlconnection)
        throws IOException
    {
        throw new UnsupportedOperationException("This is not a general purpose response cache.");
    }

    public void trackConditionalCacheHit()
    {
        this;
        JVM INSTR monitorenter ;
        hitCount = hitCount + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void trackResponse(ResponseSource responsesource)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        requestCount = requestCount + 1;
        static class _cls1
        {

            static final int $SwitchMap$com$squareup$okhttp$ResponseSource[];

            static 
            {
                $SwitchMap$com$squareup$okhttp$ResponseSource = new int[ResponseSource.values().length];
                try
                {
                    $SwitchMap$com$squareup$okhttp$ResponseSource[ResponseSource.CACHE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$squareup$okhttp$ResponseSource[ResponseSource.CONDITIONAL_CACHE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$squareup$okhttp$ResponseSource[ResponseSource.NETWORK.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        i = _cls1..SwitchMap.com.squareup.okhttp.ResponseSource[responsesource.ordinal()];
        i;
        JVM INSTR tableswitch 1 3: default 48
    //                   1 51
    //                   2 69
    //                   3 69;
           goto _L1 _L2 _L3 _L3
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        hitCount = hitCount + 1;
          goto _L1
        responsesource;
        throw responsesource;
_L3:
        networkCount = networkCount + 1;
          goto _L1
    }

    public void update(Response response, Response response1)
    {
        Entry entry = new Entry(response1);
        response1 = ((CacheResponseBody)response.body()).snapshot;
        response = null;
        try
        {
            response1 = response1.edit();
        }
        // Misplaced declaration of an exception variable
        catch (Response response1)
        {
            abortQuietly(response);
            return;
        }
        if (response1 == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        response = response1;
        entry.writeTo(response1);
        response = response1;
        response1.commit();
    }


/*
    static int access$208(HttpResponseCache httpresponsecache)
    {
        int i = httpresponsecache.writeSuccessCount;
        httpresponsecache.writeSuccessCount = i + 1;
        return i;
    }

*/


/*
    static int access$308(HttpResponseCache httpresponsecache)
    {
        int i = httpresponsecache.writeAbortCount;
        httpresponsecache.writeAbortCount = i + 1;
        return i;
    }

*/


    // Unreferenced inner class com/squareup/okhttp/HttpResponseCache$CacheRequestImpl$1

/* anonymous class */
    class CacheRequestImpl._cls1 extends FilterOutputStream
    {

        final CacheRequestImpl this$1;
        final com.squareup.okhttp.internal.DiskLruCache.Editor val$editor;
        final HttpResponseCache val$this$0;

        public void close()
            throws IOException
        {
label0:
            {
                synchronized (_fld0)
                {
                    if (!done)
                    {
                        break label0;
                    }
                }
                return;
            }
            done = true;
            int i = ((write) (this)).write;
            httpresponsecache;
            JVM INSTR monitorexit ;
            super.close();
            editor.commit();
            return;
            exception;
            httpresponsecache;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void write(byte abyte0[], int i, int j)
            throws IOException
        {
            out.write(abyte0, i, j);
        }

            
            {
                this$1 = final_cacherequestimpl;
                this$0 = HttpResponseCache.this;
                editor = editor1;
                super(final_outputstream);
            }
    }


    // Unreferenced inner class com/squareup/okhttp/HttpResponseCache$CacheResponseBody$1

/* anonymous class */
    class CacheResponseBody._cls1 extends FilterInputStream
    {

        final CacheResponseBody this$0;
        final com.squareup.okhttp.internal.DiskLruCache.Snapshot val$snapshot;

        public void close()
            throws IOException
        {
            snapshot.close();
            super.close();
        }

            
            {
                this$0 = final_cacheresponsebody;
                snapshot = snapshot1;
                super(InputStream.this);
            }
    }

}
