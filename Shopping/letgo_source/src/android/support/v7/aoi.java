// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package android.support.v7:
//            aol, als, aom, amc, 
//            aoj, aok, aon

public class aoi
    implements aol
{

    private final amc a;
    private aon b;
    private SSLSocketFactory c;
    private boolean d;

    public aoi()
    {
        this(((amc) (new als())));
    }

    public aoi(amc amc1)
    {
        a = amc1;
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
        sslsocketfactory = aom.a(b);
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

    public aok a(aoj aoj1, String s)
    {
        return a(aoj1, s, Collections.emptyMap());
    }

    public aok a(aoj aoj1, String s, Map map)
    {
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[aoj.values().length];
                try
                {
                    a[aoj.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[aoj.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[aoj.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[aoj.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[aoj1.ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 50
    //                   2 94
    //                   3 104
    //                   4 112;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        throw new IllegalArgumentException("Unsupported HTTP method!");
_L2:
        aoj1 = aok.a(s, map, true);
_L7:
        if (a(s) && b != null)
        {
            s = b();
            if (s != null)
            {
                ((HttpsURLConnection)aoj1.a()).setSSLSocketFactory(s);
            }
        }
        return aoj1;
_L3:
        aoj1 = aok.b(s, map, true);
        continue; /* Loop/switch isn't completed */
_L4:
        aoj1 = aok.d(s);
        continue; /* Loop/switch isn't completed */
_L5:
        aoj1 = aok.e(s);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void a(aon aon)
    {
        if (b != aon)
        {
            b = aon;
            a();
        }
    }
}
