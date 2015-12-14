// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class bwd
    implements bwl
{

    private final btb a;
    private bwn b;
    private SSLSocketFactory c;
    private boolean d;

    public bwd()
    {
        this(((btb) (new bsn())));
    }

    public bwd(btb btb1)
    {
        a = btb1;
    }

    private void a()
    {
        this;
        JVM INSTR monitorenter ;
        d = false;
        c = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean a(String s)
    {
        return s != null && s.toLowerCase(Locale.US).startsWith("https");
    }

    private SSLSocketFactory b()
    {
        this;
        JVM INSTR monitorenter ;
        SSLSocketFactory sslsocketfactory;
        if (c == null && !d)
        {
            c = c();
        }
        sslsocketfactory = c;
        this;
        JVM INSTR monitorexit ;
        return sslsocketfactory;
        Exception exception;
        exception;
        throw exception;
    }

    private SSLSocketFactory c()
    {
        this;
        JVM INSTR monitorenter ;
        d = true;
        SSLSocketFactory sslsocketfactory;
        sslsocketfactory = bwm.a(b);
        a.a("Fabric", "Custom SSL pinning enabled");
_L2:
        this;
        JVM INSTR monitorexit ;
        return sslsocketfactory;
        Object obj;
        obj;
        a.e("Fabric", "Exception while validating pinned certs", ((Throwable) (obj)));
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    public HttpRequest a(HttpMethod httpmethod, String s)
    {
        return a(httpmethod, s, Collections.emptyMap());
    }

    public HttpRequest a(HttpMethod httpmethod, String s, Map map)
    {
        bwe.a[httpmethod.ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 50
    //                   2 94
    //                   3 104
    //                   4 112;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        throw new IllegalArgumentException("Unsupported HTTP method!");
_L2:
        httpmethod = HttpRequest.a(s, map, true);
_L7:
        if (a(s) && b != null)
        {
            s = b();
            if (s != null)
            {
                ((HttpsURLConnection)httpmethod.a()).setSSLSocketFactory(s);
            }
        }
        return httpmethod;
_L3:
        httpmethod = HttpRequest.b(s, map, true);
        continue; /* Loop/switch isn't completed */
_L4:
        httpmethod = HttpRequest.d(s);
        continue; /* Loop/switch isn't completed */
_L5:
        httpmethod = HttpRequest.e(s);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void a(bwn bwn)
    {
        if (b != bwn)
        {
            b = bwn;
            a();
        }
    }
}
