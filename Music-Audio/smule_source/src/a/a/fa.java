// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.os.ConditionVariable;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            ez, en, c, cj, 
//            a, v

public final class fa
    implements ez, Runnable
{

    private List a;
    private URL b;
    private long c;
    private ConditionVariable d;
    private v e;
    private ConditionVariable f;
    private volatile boolean g;
    private final Object h;
    private int i;
    private volatile long j;

    public fa(v v, URL url)
    {
        this(v, url, (byte)0);
    }

    private fa(v v, URL url, byte byte0)
    {
        a = new LinkedList();
        b = null;
        c = System.currentTimeMillis();
        d = new ConditionVariable(false);
        f = new ConditionVariable(false);
        g = false;
        h = new Object();
        i = 50;
        j = 10000L;
        e = v;
        b = url;
        i = 50;
        j = 10000L;
    }

    private static boolean a(HttpURLConnection httpurlconnection, JSONObject jsonobject)
    {
        boolean flag = false;
        int k;
        try
        {
            httpurlconnection.getOutputStream().write(jsonobject.toString().getBytes("UTF8"));
            k = httpurlconnection.getResponseCode();
            httpurlconnection.disconnect();
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            (new StringBuilder("Request failed for ")).append(httpurlconnection.getURL().toExternalForm());
            en.a();
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            (new StringBuilder("Request failed for ")).append(httpurlconnection.getURL().toExternalForm());
            en.a();
            return false;
        }
        if (k == 202)
        {
            flag = true;
        }
        return flag;
    }

    private long b()
    {
        long l1 = 0L;
        long l2 = j;
        long l3 = System.currentTimeMillis() - c;
        long l = l2;
        if (l3 > 0L)
        {
            l2 -= l3;
            l = l2;
            if (l2 < 0L)
            {
                l = l1;
            }
        }
        l1 = j;
        return l;
    }

    private HttpURLConnection c()
    {
        Object obj1 = (HttpURLConnection)b.openConnection();
        javax.net.ssl.SSLSocketFactory sslsocketfactory;
        HttpsURLConnection httpsurlconnection;
        ((HttpURLConnection) (obj1)).setConnectTimeout(2500);
        ((HttpURLConnection) (obj1)).setRequestProperty("User-Agent", "5.0.6");
        ((HttpURLConnection) (obj1)).setRequestProperty("Content-Type", "application/json");
        ((HttpURLConnection) (obj1)).setDoOutput(true);
        ((HttpURLConnection) (obj1)).setRequestMethod("POST");
        if (!(obj1 instanceof HttpsURLConnection))
        {
            break MISSING_BLOCK_LABEL_103;
        }
        httpsurlconnection = (HttpsURLConnection)obj1;
        SSLContext sslcontext = SSLContext.getInstance("TLS");
        sslcontext.init(null, null, null);
        sslsocketfactory = sslcontext.getSocketFactory();
        Object obj;
        if (sslsocketfactory == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        obj = sslsocketfactory;
        if (sslsocketfactory instanceof c)
        {
            obj = ((c)sslsocketfactory).a();
        }
        httpsurlconnection.setSSLSocketFactory(((javax.net.ssl.SSLSocketFactory) (obj)));
        return ((HttpURLConnection) (obj1));
        obj1;
        obj = null;
_L2:
        en.b((new StringBuilder("Failed to instantiate URLConnection to APM server: ")).append(((IOException) (obj1)).getMessage()).toString());
        return ((HttpURLConnection) (obj));
        GeneralSecurityException generalsecurityexception;
        generalsecurityexception;
        en.b((new StringBuilder("Failed to instantiate URLConnection to APM server: ")).append(generalsecurityexception.getMessage()).toString());
        return null;
        IOException ioexception;
        ioexception;
        generalsecurityexception = ((GeneralSecurityException) (obj1));
        obj1 = ioexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private boolean d()
    {
        return !g && a.size() < i;
    }

    public final void a()
    {
        f.open();
    }

    public final void a(int k, TimeUnit timeunit)
    {
        j = timeunit.toMillis(k);
    }

    public final void a(cj cj1)
    {
        boolean flag;
label0:
        {
            flag = false;
            if (!d())
            {
                return;
            }
            synchronized (h)
            {
                if (d())
                {
                    break label0;
                }
            }
            return;
        }
        String s;
        a.add(cj1);
        s = b.getHost();
        if (!cj1.a().contains(s)) goto _L2; else goto _L1
_L1:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        d.open();
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        cj1 = cj1.f;
        if (cj1 == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        boolean flag1 = cj1.toLowerCase().equals("connect");
        if (flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = true;
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void run()
    {
_L2:
        boolean flag;
        if (g)
        {
            break; /* Loop/switch isn't completed */
        }
        f.block();
        d.block();
        flag = g;
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            if (b() > 0L)
            {
                Thread.sleep(b());
            }
        }
        catch (InterruptedException interruptedexception) { }
        c = System.currentTimeMillis();
        obj = c();
        if (obj == null)
        {
            List list;
            try
            {
                g = true;
                en.b("Disabling APM due to failure instantiating connection");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e("Crittercism", (new StringBuilder("Exited APM send task due to: \n")).append(obj).toString());
            }
            break MISSING_BLOCK_LABEL_158;
        }
        synchronized (h)
        {
            list = a;
            a = new LinkedList();
            d.close();
        }
        obj1 = a.a.a.a(e, list);
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        g = true;
        en.b("Disabling APM due to failure building request");
        return;
        return;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        a(((HttpURLConnection) (obj)), ((a) (obj1)).a);
        if (true) goto _L2; else goto _L1
_L1:
    }
}
