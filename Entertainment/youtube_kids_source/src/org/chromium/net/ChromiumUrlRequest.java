// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package org.chromium.net:
//            HttpUrlRequest, ChromiumUrlRequestContext, HttpUrlRequestListener

public class ChromiumUrlRequest
    implements HttpUrlRequest
{

    private long a;
    private final ChromiumUrlRequestContext b;
    private final String c;
    private final int d;
    private final Map e;
    private final WritableByteChannel f;
    private volatile boolean g;
    private volatile boolean h;
    private volatile boolean i;
    private volatile boolean j;
    private String k;
    private final HttpUrlRequestListener l;
    private long m;
    private boolean n;
    private boolean o;
    private long p;
    private final Object q;

    public ChromiumUrlRequest(ChromiumUrlRequestContext chromiumurlrequestcontext, String s, int i1, Map map, WritableByteChannel writablebytechannel, HttpUrlRequestListener httpurlrequestlistener)
    {
        int j1;
        byte byte0;
        byte0 = 3;
        super();
        q = new Object();
        if (chromiumurlrequestcontext == null)
        {
            throw new NullPointerException("Context is required");
        }
        if (s == null)
        {
            throw new NullPointerException("URL is required");
        }
        b = chromiumurlrequestcontext;
        c = s;
        j1 = byte0;
        i1;
        JVM INSTR tableswitch 0 4: default 96
    //                   0 148
    //                   1 154
    //                   2 160
    //                   3 100
    //                   4 166;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        j1 = byte0;
_L8:
        d = j1;
        e = map;
        f = writablebytechannel;
        a = nativeCreateRequestAdapter(b.a, c, d);
        l = httpurlrequestlistener;
        return;
_L2:
        j1 = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        j1 = 1;
        continue; /* Loop/switch isn't completed */
_L4:
        j1 = 2;
        continue; /* Loop/switch isn't completed */
_L6:
        j1 = 4;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void a(Exception exception)
    {
        new IOException("CalledByNative method has thrown an exception", exception);
        Log.e("ChromiumNetwork", "Exception in CalledByNative method", exception);
        try
        {
            d();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            Log.e("ChromiumNetwork", "Exception trying to cancel request", exception);
        }
    }

    private void finish()
    {
label0:
        {
            synchronized (q)
            {
                j = true;
                if (!i)
                {
                    break label0;
                }
            }
            return;
        }
        try
        {
            f.close();
        }
        catch (IOException ioexception) { }
        l.a(this);
        nativeDestroyRequestAdapter(a);
        a = 0L;
        i = true;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception1;
        }
        catch (Exception exception)
        {
            new IOException("Exception in finish", exception);
        }
        return;
    }

    private native void nativeAddHeader(long l1, String s, String s1);

    private native void nativeAppendChunk(long l1, ByteBuffer bytebuffer, int i1, boolean flag);

    private native void nativeCancel(long l1);

    private native long nativeCreateRequestAdapter(long l1, String s, int i1);

    private native void nativeDestroyRequestAdapter(long l1);

    private native void nativeDisableRedirects(long l1);

    private native void nativeEnableChunkedUpload(long l1, String s);

    private native void nativeGetAllHeaders(long l1, ResponseHeadersMap responseheadersmap);

    private native long nativeGetContentLength(long l1);

    private native String nativeGetContentType(long l1);

    private native int nativeGetErrorCode(long l1);

    private native String nativeGetErrorString(long l1);

    private native String nativeGetHeader(long l1, String s);

    private native int nativeGetHttpStatusCode(long l1);

    private native String nativeGetHttpStatusText(long l1);

    private native String nativeGetNegotiatedProtocol(long l1);

    private native void nativeSetMethod(long l1, String s);

    private native void nativeSetUploadChannel(long l1, String s, long l2);

    private native void nativeSetUploadData(long l1, String s, byte abyte0[]);

    private native void nativeStart(long l1);

    private void onAppendResponseHeader(ResponseHeadersMap responseheadersmap, String s, String s1)
    {
        try
        {
            if (!responseheadersmap.containsKey(s))
            {
                responseheadersmap.put(s, new ArrayList());
            }
            ((List)responseheadersmap.get(s)).add(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ResponseHeadersMap responseheadersmap)
        {
            a(responseheadersmap);
        }
    }

    private void onBytesRead(ByteBuffer bytebuffer)
    {
        boolean flag;
        flag = true;
        int i1;
        try
        {
            if (n)
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (ByteBuffer bytebuffer)
        {
            a(bytebuffer);
            return;
        }
        i1 = bytebuffer.remaining();
        p = p + (long)i1;
        if (o)
        {
            if (p <= 0L)
            {
                break MISSING_BLOCK_LABEL_139;
            }
            o = false;
            bytebuffer.position((int)(0L - (p - (long)i1)));
        }
        if (0L == 0L) goto _L2; else goto _L1
_L1:
        if (p <= 0L) goto _L2; else goto _L3
_L3:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        bytebuffer.limit(i1 - (int)p);
        for (; bytebuffer.hasRemaining(); f.write(bytebuffer)) { }
        break; /* Loop/switch isn't completed */
_L2:
        flag = false;
        if (true) goto _L3; else goto _L4
_L4:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        n = true;
        d();
    }

    private void onResponseStarted()
    {
        long l1;
        try
        {
            k = nativeGetContentType(a);
            m = nativeGetContentLength(a);
        }
        catch (Exception exception)
        {
            a(exception);
            return;
        }
        if (0L <= 0L)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        l1 = m;
        if (0L == 0L)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        if (nativeGetHttpStatusCode(a) != 200)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (m != -1L)
        {
            m = m;
        }
        o = true;
_L2:
        l.b(this);
        return;
        p = 0L;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private int readFromUploadChannel(ByteBuffer bytebuffer)
    {
        return -1;
    }

    public final long a()
    {
        return m;
    }

    public final int b()
    {
        int j1 = nativeGetHttpStatusCode(a);
        int i1 = j1;
        if (j1 == 206)
        {
            i1 = 200;
        }
        return i1;
    }

    public final void c()
    {
label0:
        {
            synchronized (q)
            {
                if (!h)
                {
                    break label0;
                }
            }
            return;
        }
        if (g)
        {
            throw new IllegalStateException("Request already started");
        }
        break MISSING_BLOCK_LABEL_39;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (i)
        {
            throw new IllegalStateException("Accessing recycled request");
        }
        g = true;
        if (e != null && !e.isEmpty())
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = e.entrySet().iterator(); iterator.hasNext(); nativeAddHeader(a, (String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        nativeStart(a);
        obj;
        JVM INSTR monitorexit ;
    }

    public final void d()
    {
label0:
        {
            synchronized (q)
            {
                if (!h)
                {
                    break label0;
                }
            }
            return;
        }
        h = true;
        if (!i)
        {
            nativeCancel(a);
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final String e()
    {
        return k;
    }

    private class ResponseHeadersMap extends HashMap
    {

        private ResponseHeadersMap()
        {
        }
    }

}
