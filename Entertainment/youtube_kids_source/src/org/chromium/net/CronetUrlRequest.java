// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.util.Log;
import android.util.Pair;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

// Referenced classes of package org.chromium.net:
//            UrlRequest, UrlRequestException, UrlRequestListener, CronetUrlRequestContext

final class CronetUrlRequest
    implements UrlRequest
{

    private long a;
    private boolean b;
    private boolean c;
    private boolean d;
    private final Object e;
    private final CronetUrlRequestContext f;
    private final Executor g;
    private final List h;
    private final UrlRequestListener i;
    private final String j;
    private final int k;
    private final HeadersList l;
    private NativeResponseInfo m;
    private OnDataReceivedRunnable n;

    CronetUrlRequest(CronetUrlRequestContext croneturlrequestcontext, String s, int i1, UrlRequestListener urlrequestlistener, Executor executor)
    {
        i1 = 0;
        super();
        b = false;
        c = false;
        d = false;
        e = new Object();
        h = new ArrayList();
        l = new HeadersList();
        if (s == null)
        {
            throw new NullPointerException("URL is required");
        }
        if (urlrequestlistener == null)
        {
            throw new NullPointerException("Listener is required");
        }
        if (executor == null)
        {
            throw new NullPointerException("Executor is required");
        }
        f = croneturlrequestcontext;
        j = s;
        h.add(s);
        3;
        JVM INSTR tableswitch 0 4: default 156
    //                   0 158
    //                   1 176
    //                   2 181
    //                   3 186
    //                   4 191;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i1 = 3;
_L8:
        k = i1;
        i = urlrequestlistener;
        g = executor;
        return;
_L3:
        i1 = 1;
        continue; /* Loop/switch isn't completed */
_L4:
        i1 = 2;
        continue; /* Loop/switch isn't completed */
_L5:
        i1 = 3;
        continue; /* Loop/switch isn't completed */
_L6:
        i1 = 4;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static Object a(CronetUrlRequest croneturlrequest)
    {
        return croneturlrequest.e;
    }

    private NativeResponseInfo a(int i1)
    {
label0:
        {
            synchronized (e)
            {
                if (a != 0L)
                {
                    break label0;
                }
            }
            return null;
        }
        long l1 = a;
        obj;
        JVM INSTR monitorexit ;
        obj = new NativeResponseInfo((String[])h.toArray(new String[h.size()]), i1, nativeGetHttpStatusText(l1), nativeGetWasCached(l1), nativeGetNegotiatedProtocol(l1));
        nativePopulateResponseHeaders(l1, NativeResponseInfo.a(((NativeResponseInfo) (obj))));
        return ((NativeResponseInfo) (obj));
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void a(Runnable runnable)
    {
        g.execute(runnable);
    }

    static void a(CronetUrlRequest croneturlrequest, long l1)
    {
        croneturlrequest.nativeReceiveData(l1);
    }

    static void a(CronetUrlRequest croneturlrequest, Exception exception)
    {
        UrlRequestException urlrequestexception;
label0:
        {
            urlrequestexception = new UrlRequestException("CalledByNative method has thrown an exception", exception);
            Log.e("ChromiumNetwork", "Exception in CalledByNative method", exception);
            synchronized (croneturlrequest.e)
            {
                if (!croneturlrequest.c())
                {
                    break label0;
                }
            }
            return;
        }
        croneturlrequest.b();
        exception;
        JVM INSTR monitorexit ;
        try
        {
            croneturlrequest.i.a(croneturlrequest.m, urlrequestexception);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (CronetUrlRequest croneturlrequest)
        {
            Log.e("ChromiumNetwork", "Exception notifying of failed request", croneturlrequest);
        }
        return;
        croneturlrequest;
        exception;
        JVM INSTR monitorexit ;
        throw croneturlrequest;
    }

    static boolean a(CronetUrlRequest croneturlrequest, boolean flag)
    {
        croneturlrequest.d = flag;
        return flag;
    }

    static long b(CronetUrlRequest croneturlrequest)
    {
        return croneturlrequest.a;
    }

    static void b(CronetUrlRequest croneturlrequest, long l1)
    {
        croneturlrequest.nativeFollowDeferredRedirect(l1);
    }

    static NativeResponseInfo c(CronetUrlRequest croneturlrequest)
    {
        return croneturlrequest.m;
    }

    static UrlRequestListener d(CronetUrlRequest croneturlrequest)
    {
        return croneturlrequest.i;
    }

    private void d()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        if (b || c())
        {
            throw new IllegalStateException("Request is already started.");
        }
        break MISSING_BLOCK_LABEL_36;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    private void e()
    {
label0:
        {
            synchronized (e)
            {
                if (a != 0L)
                {
                    break label0;
                }
            }
            return;
        }
        nativeDestroyRequestAdapter(a);
        CronetUrlRequestContext croneturlrequestcontext = f;
        throw new NullPointerException();
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void e(CronetUrlRequest croneturlrequest)
    {
        croneturlrequest.e();
    }

    static List f(CronetUrlRequest croneturlrequest)
    {
        return croneturlrequest.h;
    }

    private native boolean nativeAddHeader(long l1, String s, String s1);

    private native long nativeCreateRequestAdapter(long l1, String s, int i1);

    private native void nativeDestroyRequestAdapter(long l1);

    private native void nativeFollowDeferredRedirect(long l1);

    private native String nativeGetHttpStatusText(long l1);

    private native String nativeGetNegotiatedProtocol(long l1);

    private native long nativeGetTotalReceivedBytes(long l1);

    private native boolean nativeGetWasCached(long l1);

    private native void nativePopulateResponseHeaders(long l1, HeadersList headerslist);

    private native void nativeReceiveData(long l1);

    private native boolean nativeSetHttpMethod(long l1, String s);

    private native void nativeStart(long l1);

    private void onAppendResponseHeader(HeadersList headerslist, String s, String s1)
    {
        headerslist.add(Pair.create(s, s1));
    }

    private void onDataReceived(ByteBuffer bytebuffer)
    {
        if (n == null)
        {
            n = new OnDataReceivedRunnable();
        }
        n.a = bytebuffer;
        a(n);
    }

    private void onError(int i1, String s)
    {
        a(new _cls4(s, i1));
    }

    private void onRedirect(String s, int i1)
    {
        a(new _cls1(a(i1), s));
    }

    private void onResponseStarted(int i1)
    {
        m = a(i1);
        a(new _cls2());
    }

    private void onSucceeded()
    {
label0:
        {
            synchronized (e)
            {
                if (a != 0L)
                {
                    break label0;
                }
            }
            return;
        }
        long l1 = nativeGetTotalReceivedBytes(a);
        obj;
        JVM INSTR monitorexit ;
        a(new _cls3(new NativeExtendedResponseInfo(m, l1)));
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        d();
        CronetUrlRequestContext croneturlrequestcontext = f;
        if (0L != 0L)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        throw new IllegalStateException("Context Adapter is destroyed.");
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        a = nativeCreateRequestAdapter(0L, j, k);
        CronetUrlRequestContext croneturlrequestcontext1 = f;
        throw new NullPointerException();
    }

    public final void a(String s, String s1)
    {
        d();
        if (s == null)
        {
            throw new NullPointerException("Invalid header name.");
        }
        if (s1 == null)
        {
            throw new NullPointerException("Invalid header value.");
        } else
        {
            l.add(Pair.create(s, s1));
            return;
        }
    }

    public final void b()
    {
label0:
        {
            synchronized (e)
            {
                if (!c && b)
                {
                    break label0;
                }
            }
            return;
        }
        c = true;
        if (!d)
        {
            e();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean c()
    {
        boolean flag;
        synchronized (e)
        {
            flag = c;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private class HeadersList extends ArrayList
    {

        HeadersList()
        {
        }
    }


    private class NativeResponseInfo
        implements ResponseInfo
    {

        private final int a;
        private final String b;
        private final HeadersList c = new HeadersList();

        static HeadersList a(NativeResponseInfo nativeresponseinfo)
        {
            return nativeresponseinfo.c;
        }

        public final int a()
        {
            return a;
        }

        public final String b()
        {
            return b;
        }

        NativeResponseInfo(String as[], int i1, String s, boolean flag, String s1)
        {
            a = i1;
            b = s;
        }
    }


    private class OnDataReceivedRunnable
        implements Runnable
    {

        ByteBuffer a;
        private CronetUrlRequest b;

        public final void run()
        {
            if (b.c())
            {
                return;
            }
            synchronized (CronetUrlRequest.a(b))
            {
                if (CronetUrlRequest.b(b) != 0L)
                {
                    break MISSING_BLOCK_LABEL_89;
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            try
            {
                throw exception;
            }
            catch (Exception exception1)
            {
                synchronized (CronetUrlRequest.a(b))
                {
                    CronetUrlRequest.a(b, false);
                    if (b.c())
                    {
                        CronetUrlRequest.e(b);
                    }
                }
                CronetUrlRequest.a(b, exception1);
                return;
            }
            CronetUrlRequest.a(b, true);
            obj;
            JVM INSTR monitorexit ;
            obj = CronetUrlRequest.d(b);
            CronetUrlRequest croneturlrequest = b;
            ((UrlRequestListener) (obj)).a(CronetUrlRequest.c(b), a);
            a = null;
            synchronized (CronetUrlRequest.a(b))
            {
                CronetUrlRequest.a(b, false);
                if (!b.c())
                {
                    break MISSING_BLOCK_LABEL_179;
                }
                CronetUrlRequest.e(b);
            }
            return;
            exception2;
            obj;
            JVM INSTR monitorexit ;
            throw exception2;
            CronetUrlRequest.a(b, CronetUrlRequest.b(b));
            obj;
            JVM INSTR monitorexit ;
            return;
            exception3;
            obj;
            JVM INSTR monitorexit ;
            throw exception3;
        }

        OnDataReceivedRunnable()
        {
            b = CronetUrlRequest.this;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        private String a;
        private int b;
        private CronetUrlRequest c;

        public void run()
        {
            if (c.c())
            {
                return;
            }
            CronetUrlRequest.e(c);
            try
            {
                UrlRequestException urlrequestexception = new UrlRequestException((new StringBuilder("Exception in CronetUrlRequest: ")).append(a).toString(), b);
                UrlRequestListener urlrequestlistener = CronetUrlRequest.d(c);
                CronetUrlRequest croneturlrequest = c;
                urlrequestlistener.a(CronetUrlRequest.c(c), urlrequestexception);
                return;
            }
            catch (Exception exception)
            {
                Log.e("ChromiumNetwork", "Exception in onError method", exception);
            }
        }

        _cls4(String s, int i1)
        {
            c = CronetUrlRequest.this;
            a = s;
            b = i1;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        private NativeResponseInfo a;
        private String b;
        private CronetUrlRequest c;

        public void run()
        {
            if (c.c())
            {
                return;
            }
            UrlRequestListener urlrequestlistener = CronetUrlRequest.d(c);
            CronetUrlRequest croneturlrequest = c;
            urlrequestlistener.a(a, b);
            synchronized (CronetUrlRequest.a(c))
            {
                if (!c.c())
                {
                    break MISSING_BLOCK_LABEL_76;
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            try
            {
                throw exception;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                CronetUrlRequest.a(c, ((Exception) (obj)));
            }
            return;
            CronetUrlRequest.f(c).add(b);
            CronetUrlRequest.b(c, CronetUrlRequest.b(c));
            obj;
            JVM INSTR monitorexit ;
        }

        _cls1(NativeResponseInfo nativeresponseinfo, String s)
        {
            c = CronetUrlRequest.this;
            a = nativeresponseinfo;
            b = s;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        private CronetUrlRequest a;

        public void run()
        {
            if (a.c())
            {
                return;
            }
            UrlRequestListener urlrequestlistener = CronetUrlRequest.d(a);
            CronetUrlRequest croneturlrequest = a;
            urlrequestlistener.a(CronetUrlRequest.c(a));
            synchronized (CronetUrlRequest.a(a))
            {
                if (!a.c())
                {
                    break MISSING_BLOCK_LABEL_75;
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            try
            {
                throw exception;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                CronetUrlRequest.a(a, ((Exception) (obj)));
            }
            return;
            CronetUrlRequest.a(a, CronetUrlRequest.b(a));
            obj;
            JVM INSTR monitorexit ;
        }

        _cls2()
        {
            a = CronetUrlRequest.this;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        private NativeExtendedResponseInfo a;
        private CronetUrlRequest b;

        public void run()
        {
label0:
            {
                synchronized (CronetUrlRequest.a(b))
                {
                    if (!b.c())
                    {
                        break label0;
                    }
                }
                return;
            }
            CronetUrlRequest.e(b);
            obj;
            JVM INSTR monitorexit ;
            try
            {
                obj = CronetUrlRequest.d(b);
                CronetUrlRequest croneturlrequest = b;
                ((UrlRequestListener) (obj)).a(a);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e("ChromiumNetwork", "Exception in onComplete method", ((Throwable) (obj)));
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        _cls3(NativeExtendedResponseInfo nativeextendedresponseinfo)
        {
            b = CronetUrlRequest.this;
            a = nativeextendedresponseinfo;
            super();
        }
    }


    private class NativeExtendedResponseInfo
        implements ExtendedResponseInfo
    {

        private final ResponseInfo a;

        public final ResponseInfo a()
        {
            return a;
        }

        NativeExtendedResponseInfo(ResponseInfo responseinfo, long l1)
        {
            a = responseinfo;
        }
    }

}
