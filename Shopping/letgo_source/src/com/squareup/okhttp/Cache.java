// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import android.support.v7.apv;
import android.support.v7.apw;
import android.support.v7.apx;
import android.support.v7.apy;
import android.support.v7.aqa;
import android.support.v7.aqb;
import android.support.v7.aqe;
import android.support.v7.aqj;
import android.support.v7.aqk;
import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.CacheRequest;
import com.squareup.okhttp.internal.http.CacheStrategy;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import com.squareup.okhttp.internal.io.FileSystem;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// Referenced classes of package com.squareup.okhttp:
//            Response, Request, ResponseBody, MediaType, 
//            Handshake, Headers, Protocol

public final class Cache
{
    private static class CacheResponseBody extends ResponseBody
    {

        private final apx bodySource;
        private final String contentLength;
        private final String contentType;
        private final com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot;

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

        public apx source()
        {
            return bodySource;
        }


        public CacheResponseBody(com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot1, String s, String s1)
        {
            snapshot = snapshot1;
            contentType = s;
            contentLength = s1;
            bodySource = aqe.a(snapshot1.getSource(1). new _cls1(snapshot1));
        }
    }

    private static final class Entry
    {

        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final String url;
        private final Headers varyHeaders;

        private boolean isHttps()
        {
            return url.startsWith("https://");
        }

        private List readCertificateList(apx apx1)
            throws IOException
        {
            int j = Cache.readInt(apx1);
            if (j != -1) goto _L2; else goto _L1
_L1:
            Object obj = Collections.emptyList();
_L4:
            return ((List) (obj));
_L2:
            ArrayList arraylist;
            CertificateFactory certificatefactory;
            apv apv1;
            int i;
            try
            {
                certificatefactory = CertificateFactory.getInstance("X.509");
                arraylist = new ArrayList(j);
            }
            // Misplaced declaration of an exception variable
            catch (apx apx1)
            {
                throw new IOException(apx1.getMessage());
            }
            i = 0;
            obj = arraylist;
            if (i >= j) goto _L4; else goto _L3
_L3:
            obj = apx1.r();
            apv1 = new apv();
            apv1.a(apy.b(((String) (obj))));
            arraylist.add(certificatefactory.generateCertificate(apv1.g()));
            i++;
            break MISSING_BLOCK_LABEL_38;
        }

        private void writeCertList(apw apw1, List list)
            throws IOException
        {
            int i;
            int j;
            try
            {
                apw1.k(list.size());
                apw1.g(10);
                j = list.size();
            }
            // Misplaced declaration of an exception variable
            catch (apw apw1)
            {
                throw new IOException(apw1.getMessage());
            }
            i = 0;
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            apw1.b(apy.a(((Certificate)list.get(i)).getEncoded()).b());
            apw1.g(10);
            i++;
            if (true) goto _L2; else goto _L1
_L2:
            break MISSING_BLOCK_LABEL_33;
_L1:
        }

        public boolean matches(Request request, Response response1)
        {
            return url.equals(request.urlString()) && requestMethod.equals(request.method()) && OkHeaders.varyMatches(response1, varyHeaders, request);
        }

        public Response response(Request request, com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot)
        {
            request = responseHeaders.get("Content-Type");
            String s = responseHeaders.get("Content-Length");
            Request request1 = (new Request.Builder()).url(url).method(requestMethod, null).headers(varyHeaders).build();
            return (new Response.Builder()).request(request1).protocol(protocol).code(code).message(message).headers(responseHeaders).body(new CacheResponseBody(snapshot, request, s)).handshake(handshake).build();
        }

        public void writeTo(com.squareup.okhttp.internal.DiskLruCache.Editor editor)
            throws IOException
        {
            boolean flag = false;
            editor = aqe.a(editor.newSink(0));
            editor.b(url);
            editor.g(10);
            editor.b(requestMethod);
            editor.g(10);
            editor.k(varyHeaders.size());
            editor.g(10);
            int k = varyHeaders.size();
            for (int i = 0; i < k; i++)
            {
                editor.b(varyHeaders.name(i));
                editor.b(": ");
                editor.b(varyHeaders.value(i));
                editor.g(10);
            }

            editor.b((new StatusLine(protocol, code, message)).toString());
            editor.g(10);
            editor.k(responseHeaders.size());
            editor.g(10);
            k = responseHeaders.size();
            for (int j = ((flag) ? 1 : 0); j < k; j++)
            {
                editor.b(responseHeaders.name(j));
                editor.b(": ");
                editor.b(responseHeaders.value(j));
                editor.g(10);
            }

            if (isHttps())
            {
                editor.g(10);
                editor.b(handshake.cipherSuite());
                editor.g(10);
                writeCertList(editor, handshake.peerCertificates());
                writeCertList(editor, handshake.localCertificates());
            }
            editor.close();
        }

        public Entry(aqk aqk1)
            throws IOException
        {
            boolean flag;
            flag = false;
            super();
            Object obj;
            Object obj1;
            int j;
            obj = aqe.a(aqk1);
            url = ((apx) (obj)).r();
            requestMethod = ((apx) (obj)).r();
            obj1 = new Headers.Builder();
            j = Cache.readInt(((apx) (obj)));
            int i = 0;
_L2:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            ((Headers.Builder) (obj1)).addLenient(((apx) (obj)).r());
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            varyHeaders = ((Headers.Builder) (obj1)).build();
            obj1 = StatusLine.parse(((apx) (obj)).r());
            protocol = ((StatusLine) (obj1)).protocol;
            code = ((StatusLine) (obj1)).code;
            message = ((StatusLine) (obj1)).message;
            obj1 = new Headers.Builder();
            j = Cache.readInt(((apx) (obj)));
            i = ((flag) ? 1 : 0);
_L4:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            ((Headers.Builder) (obj1)).addLenient(((apx) (obj)).r());
            i++;
            if (true) goto _L4; else goto _L3
_L3:
            responseHeaders = ((Headers.Builder) (obj1)).build();
            if (!isHttps())
            {
                break MISSING_BLOCK_LABEL_263;
            }
            obj1 = ((apx) (obj)).r();
            if (((String) (obj1)).length() > 0)
            {
                throw new IOException((new StringBuilder()).append("expected \"\" but was \"").append(((String) (obj1))).append("\"").toString());
            }
            break MISSING_BLOCK_LABEL_233;
            obj;
            aqk1.close();
            throw obj;
            handshake = Handshake.get(((apx) (obj)).r(), readCertificateList(((apx) (obj))), readCertificateList(((apx) (obj))));
_L5:
            aqk1.close();
            return;
            handshake = null;
              goto _L5
        }

        public Entry(Response response1)
        {
            url = response1.request().urlString();
            varyHeaders = OkHeaders.varyHeaders(response1);
            requestMethod = response1.request().method();
            protocol = response1.protocol();
            code = response1.code();
            message = response1.message();
            responseHeaders = response1.headers();
            handshake = response1.handshake();
        }
    }


    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 0x31191;
    private final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache = new InternalCache() {

        final Cache this$0;

        public Response get(Request request)
            throws IOException
        {
            return Cache.this.get(request);
        }

        public CacheRequest put(Response response)
            throws IOException
        {
            return Cache.this.put(response);
        }

        public void remove(Request request)
            throws IOException
        {
            Cache.this.remove(request);
        }

        public void trackConditionalCacheHit()
        {
            Cache.this.trackConditionalCacheHit();
        }

        public void trackResponse(CacheStrategy cachestrategy)
        {
            Cache.this.trackResponse(cachestrategy);
        }

        public void update(Response response, Response response1)
            throws IOException
        {
            Cache.this.update(response, response1);
        }

            
            {
                this$0 = Cache.this;
                super();
            }
    };
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    public Cache(File file, long l)
    {
        cache = DiskLruCache.create(FileSystem.SYSTEM, file, 0x31191, 2, l);
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

    private CacheRequest put(Response response)
        throws IOException
    {
label0:
        {
            {
                Object obj = response.request().method();
                if (!HttpMethod.invalidatesCache(response.request().method()))
                {
                    break label0;
                }
                IOException ioexception;
                try
                {
                    remove(response.request());
                }
                // Misplaced declaration of an exception variable
                catch (Response response)
                {
                    return null;
                }
            }
            return null;
        }
        if (!((String) (obj)).equals("GET") || OkHeaders.hasVaryAll(response))
        {
            break MISSING_BLOCK_LABEL_29;
        }
        obj = new Entry(response);
        response = cache.edit(urlToKey(response.request()));
        if (response == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        ((Entry) (obj)).writeTo(response);
        obj = new CacheRequestImpl(response);
        return ((CacheRequest) (obj));
        response;
        response = null;
_L2:
        abortQuietly(response);
        return null;
        ioexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static int readInt(apx apx1)
        throws IOException
    {
        long l;
        try
        {
            l = apx1.n();
            apx1 = apx1.r();
        }
        // Misplaced declaration of an exception variable
        catch (apx apx1)
        {
            throw new IOException(apx1.getMessage());
        }
        if (l < 0L || l > 0x7fffffffL)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        if (apx1.isEmpty())
        {
            break MISSING_BLOCK_LABEL_84;
        }
        throw new IOException((new StringBuilder()).append("expected an int but was \"").append(l).append(apx1).append("\"").toString());
        return (int)l;
    }

    private void remove(Request request)
        throws IOException
    {
        cache.remove(urlToKey(request));
    }

    private void trackConditionalCacheHit()
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

    private void trackResponse(CacheStrategy cachestrategy)
    {
        this;
        JVM INSTR monitorenter ;
        requestCount = requestCount + 1;
        if (cachestrategy.networkRequest == null) goto _L2; else goto _L1
_L1:
        networkCount = networkCount + 1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (cachestrategy.cacheResponse != null)
        {
            hitCount = hitCount + 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        cachestrategy;
        throw cachestrategy;
    }

    private void update(Response response, Response response1)
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

    private static String urlToKey(Request request)
    {
        return Util.md5Hex(request.urlString());
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

    public void evictAll()
        throws IOException
    {
        cache.evictAll();
    }

    public void flush()
        throws IOException
    {
        cache.flush();
    }

    Response get(Request request)
    {
        Object obj = urlToKey(request);
        Entry entry;
        try
        {
            obj = cache.get(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Request request)
        {
            return null;
        }
        if (obj == null)
        {
            return null;
        }
        try
        {
            entry = new Entry(((com.squareup.okhttp.internal.DiskLruCache.Snapshot) (obj)).getSource(0));
        }
        // Misplaced declaration of an exception variable
        catch (Request request)
        {
            Util.closeQuietly(((java.io.Closeable) (obj)));
            return null;
        }
        obj = entry.response(request, ((com.squareup.okhttp.internal.DiskLruCache.Snapshot) (obj)));
        if (!entry.matches(request, ((Response) (obj))))
        {
            Util.closeQuietly(((Response) (obj)).body());
            return null;
        } else
        {
            return ((Response) (obj));
        }
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
        throws IOException
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

    public Iterator urls()
        throws IOException
    {
        return new Iterator() {

            boolean canRemove;
            final Iterator _flddelegate;
            String nextUrl;
            final Cache this$0;

            public boolean hasNext()
            {
                if (nextUrl != null)
                {
                    return true;
                }
                canRemove = false;
_L2:
                com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot;
                if (!_flddelegate.hasNext())
                {
                    break; /* Loop/switch isn't completed */
                }
                snapshot = (com.squareup.okhttp.internal.DiskLruCache.Snapshot)_flddelegate.next();
                nextUrl = aqe.a(snapshot.getSource(0)).r();
                snapshot.close();
                return true;
                Object obj;
                obj;
                snapshot.close();
                if (true) goto _L2; else goto _L1
                obj;
                snapshot.close();
                throw obj;
_L1:
                return false;
            }

            public volatile Object next()
            {
                return next();
            }

            public String next()
            {
                if (!hasNext())
                {
                    throw new NoSuchElementException();
                } else
                {
                    String s = nextUrl;
                    nextUrl = null;
                    canRemove = true;
                    return s;
                }
            }

            public void remove()
            {
                if (!canRemove)
                {
                    throw new IllegalStateException("remove() before next()");
                } else
                {
                    _flddelegate.remove();
                    return;
                }
            }

            
                throws IOException
            {
                this$0 = Cache.this;
                super();
                _flddelegate = cache.snapshots();
            }
        };
    }









/*
    static int access$808(Cache cache1)
    {
        int i = cache1.writeSuccessCount;
        cache1.writeSuccessCount = i + 1;
        return i;
    }

*/


/*
    static int access$908(Cache cache1)
    {
        int i = cache1.writeAbortCount;
        cache1.writeAbortCount = i + 1;
        return i;
    }

*/

    // Unreferenced inner class com/squareup/okhttp/Cache$CacheRequestImpl$1

/* anonymous class */

    // Unreferenced inner class com/squareup/okhttp/Cache$CacheResponseBody$1

/* anonymous class */
    class CacheResponseBody._cls1 extends aqb
    {

        final CacheResponseBody this$0;
        final com.squareup.okhttp.internal.DiskLruCache.Snapshot val$snapshot;

        public void close()
            throws IOException
        {
            snapshot.close();
            close();
        }

            
            {
                this$0 = final_cacheresponsebody;
                snapshot = snapshot1;
                super(aqk.this);
            }
    }

}
