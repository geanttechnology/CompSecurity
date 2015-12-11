// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.util.HashMap;

public final class da extends Enum
{

    public static final da A;
    public static final da B;
    private static HashMap C;
    private static final da F[];
    public static final da a;
    public static final da b;
    public static final da c;
    public static final da d;
    public static final da e;
    public static final da f;
    public static final da g;
    public static final da h;
    public static final da i;
    public static final da j;
    public static final da k;
    public static final da l;
    public static final da m;
    public static final da n;
    public static final da o;
    public static final da p;
    public static final da q;
    public static final da r;
    public static final da s;
    public static final da t;
    public static final da u;
    public static final da v;
    public static final da w;
    public static final da x;
    public static final da y;
    public static final da z;
    private int D;
    private String E;

    private da(String s1, int i1, int j1, String s2)
    {
        super(s1, i1);
        D = j1;
        E = s2;
    }

    public static da a(Throwable throwable)
    {
        if (C == null)
        {
            b();
        }
        Object obj = null;
        if (throwable != null)
        {
            obj = throwable.getClass().getName();
        }
        obj = (da)C.get(obj);
        throwable = ((Throwable) (obj));
        if (obj == null)
        {
            throwable = B;
        }
        return throwable;
    }

    private static void b()
    {
        a/a/da;
        JVM INSTR monitorenter ;
        HashMap hashmap = C;
        if (hashmap == null) goto _L2; else goto _L1
_L1:
        a/a/da;
        JVM INSTR monitorexit ;
        return;
_L2:
        da ada[];
        int j1;
        hashmap = new HashMap();
        ada = values();
        j1 = ada.length;
        int i1 = 0;
_L4:
        da da1;
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        da1 = ada[i1];
        hashmap.put(da1.E, da1);
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        C = hashmap;
        if (true) goto _L1; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public static da valueOf(String s1)
    {
        return (da)Enum.valueOf(a/a/da, s1);
    }

    public static da[] values()
    {
        return (da[])F.clone();
    }

    public final int a()
    {
        return D;
    }

    static 
    {
        a = new da("OK", 0, 0, null);
        b = new da("ASSERTION_ERROR", 1, 1, "java.lang.AssertionError");
        c = new da("BIND_EXCEPTION", 2, 2, "java.net.BindException");
        d = new da("CLASS_NOT_FOUND_EXCEPTION", 3, 3, "java.lang.ClassNotFoundException");
        e = new da("ERROR", 4, 4, "java.lang.Error");
        f = new da("IO_EXCEPTION", 5, 5, "java.io.IOException");
        g = new da("ILLEGAL_ARGUMENT_EXCEPTION", 6, 6, "java.lang.IllegalArgumentException");
        h = new da("ILLEGAL_STATE_EXCEPTION", 7, 7, "java.lang.IllegalStateException");
        i = new da("INDEX_OUT_OF_BOUNDS_EXCEPTION", 8, 8, "java.lang.IndexOutOfBoundsException");
        j = new da("MALFORMED_URL_EXCEPTION", 9, 9, "java.net.MalformedURLException");
        k = new da("NO_SUCH_PROVIDER_EXCEPTION", 10, 10, "java.security.NoSuchProviderException");
        l = new da("NULL_POINTER_EXCEPTION", 11, 11, "java.lang.NullPointerException");
        m = new da("PROTOCOL_EXCEPTION", 12, 12, "java.net.ProtocolException");
        n = new da("SECURITY_EXCEPTION", 13, 13, "java.lang.SecurityException");
        o = new da("SOCKET_EXCEPTION", 14, 14, "java.net.SocketException");
        p = new da("SOCKET_TIMEOUT_EXCEPTION", 15, 15, "java.net.SocketTimeoutException");
        q = new da("SSL_PEER_UNVERIFIED_EXCEPTION", 16, 16, "javax.net.ssl.SSLPeerUnverifiedException");
        r = new da("STRING_INDEX_OUT_OF_BOUNDS_EXCEPTION", 17, 17, "java.lang.StringIndexOutOfBoundsException");
        s = new da("UNKNOWN_HOST_EXCEPTION", 18, 18, "java.net.UnknownHostException");
        t = new da("UNKNOWN_SERVICE_EXCEPTION", 19, 19, "java.net.UnknownServiceException");
        u = new da("UNSUPPORTED_OPERATION_EXCEPTION", 20, 20, "java.lang.UnsupportedOperationException");
        v = new da("URI_SYNTAX_EXCEPTION", 21, 21, "java.net.URISyntaxException");
        w = new da("CONNECT_EXCEPTION", 22, 22, "java.net.ConnectException");
        x = new da("SSL_EXCEPTION", 23, 23, "javax.net.ssl.SSLException");
        y = new da("SSL_HANDSHAKE_EXCEPTION", 24, 24, "javax.net.ssl.SSLHandshakeException");
        z = new da("SSL_KEY_EXCEPTION", 25, 25, "javax.net.ssl.SSLKeyException");
        A = new da("SSL_PROTOCOL_EXCEPTION", 26, 26, "javax.net.ssl.SSLProtocolException");
        B = new da("UNDEFINED_EXCEPTION", 27, -1, "__UNKNOWN__");
        F = (new da[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B
        });
    }
}
