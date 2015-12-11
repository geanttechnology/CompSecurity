// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net.http;

import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.sessionm.core.Config;
import com.sessionm.core.i;
import com.sessionm.net.b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;

// Referenced classes of package com.sessionm.net.http:
//            d

public class c
    implements Runnable
{

    static final String TAG = "SessionM.Request";
    private static int gG = 0;
    static final String gs = "SessionM.Cookies";
    public static final int gt = 30000;
    private static final int gu = 10;
    private File eJ;
    private boolean eK;
    private Throwable er;
    private boolean eu;
    private int gA;
    private String gB;
    private long gC;
    private long gD;
    private long gE;
    private long gF;
    private int gH;
    private b gv;
    private String gw;
    private Map gx;
    private Map gy;
    private d gz;
    private String method;
    private int priority;
    private int statusCode;
    private String url;

    public c()
    {
        eK = true;
        gF = 30000L;
        gH = 0;
    }

    public static List a(Map map, String s)
    {
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            if (s1 != null && s.equalsIgnoreCase(s1))
            {
                return (List)map.get(s1);
            }
        }

        return null;
    }

    public static int by()
    {
        return gG;
    }

    void B(String s)
    {
        url = s;
    }

    void C(String s)
    {
        gw = s;
    }

    public void D(String s)
    {
        gB = s;
    }

    void a(b b1)
    {
        gv = b1;
    }

    protected b bw()
    {
        return gv;
    }

    public boolean bx()
    {
        return eK;
    }

    void c(Map map)
    {
        gy = map;
    }

    void e(long l)
    {
        gC = l;
    }

    public void g(boolean flag)
    {
        eK = flag;
    }

    int getPriority()
    {
        return priority;
    }

    void h(boolean flag)
    {
        eu = flag;
    }

    void r(int j)
    {
        priority = j;
    }

    public void run()
    {
        Object obj;
        Object obj2;
        Object obj3;
        obj2 = null;
        obj3 = null;
        if (Log.isLoggable("SessionM.Request", 3))
        {
            Log.d("SessionM.Request", (new StringBuilder()).append("Start request, URL: ").append(url).append(", POST params: ").append(gw).append(", timeout: ").append(gF).toString());
        }
        gD = System.currentTimeMillis();
        obj = obj2;
        Object obj1 = new URL(url);
        obj = obj2;
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        obj = obj2;
        if (!Config.h().getServerType().equals(com.sessionm.core.Config.ServerType.at))
        {
            break MISSING_BLOCK_LABEL_157;
        }
        obj = obj2;
        URI uri = new URI(url);
        obj = obj2;
        obj1 = new URL(((URL) (obj1)).getProtocol(), uri.getHost(), uri.getPort(), ((URL) (obj1)).getFile());
        obj = obj2;
        obj1 = (HttpURLConnection)((URL) (obj1)).openConnection();
        long l1;
        long l2;
        ((HttpURLConnection) (obj1)).setInstanceFollowRedirects(false);
        if (obj1 instanceof HttpsURLConnection)
        {
            ((HttpsURLConnection)obj1).setHostnameVerifier(new AllowAllHostnameVerifier());
        }
        l1 = gF;
        l2 = System.currentTimeMillis();
        ((HttpURLConnection) (obj1)).setConnectTimeout((int)l1);
        long l = l1;
        if (l1 <= 0L) goto _L2; else goto _L1
_L1:
        l1 -= System.currentTimeMillis() - l2;
        l = l1;
        if (l1 > 0L) goto _L2; else goto _L3
_L3:
        throw new SocketTimeoutException("Connect timeout");
        obj2;
_L15:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        obj = obj1;
        statusCode = ((HttpURLConnection) (obj1)).getResponseCode();
_L12:
        obj = obj1;
        if (!(obj2 instanceof SocketTimeoutException)) goto _L5; else goto _L4
_L4:
        obj = obj1;
        if (!Log.isLoggable("SessionM.Request", 3))
        {
            break MISSING_BLOCK_LABEL_300;
        }
        obj = obj1;
        Log.d("SessionM.Request", "Request timeout");
_L14:
        obj = obj1;
        er = ((Throwable) (obj2));
        gE = System.currentTimeMillis();
        if (Log.isLoggable("SessionM.Request", 3))
        {
            obj = String.format(Locale.US, "URL: %s, code: %d, error: %s, start delta: %d, finish delta: %d, processing time: %d, response size: %d", new Object[] {
                url, Integer.valueOf(statusCode), er, Long.valueOf(gD - gC), Long.valueOf(gE - gC), Long.valueOf(gE - gD), Integer.valueOf(gA)
            });
            Log.d("SessionM.Request", (new StringBuilder()).append("Finish request, ").append(((String) (obj))).toString());
        }
        if (gv != null)
        {
            gv.a(gz, er, statusCode, gx);
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_482;
        }
        ((HttpURLConnection) (obj1)).disconnect();
_L9:
        return;
_L2:
        int j = (int)l;
        ((HttpURLConnection) (obj1)).setReadTimeout(j);
        if (gy != null)
        {
            for (obj = gy.keySet().iterator(); ((Iterator) (obj)).hasNext();)
            {
                obj2 = (String)((Iterator) (obj)).next();
                obj3 = ((List)gy.get(obj2)).iterator();
                while (((Iterator) (obj3)).hasNext()) 
                {
                    ((HttpURLConnection) (obj1)).addRequestProperty(((String) (obj2)), (String)((Iterator) (obj3)).next());
                }
            }

        }
          goto _L6
        obj2;
        obj = obj1;
        obj1 = obj2;
_L16:
        gE = System.currentTimeMillis();
        if (Log.isLoggable("SessionM.Request", 3))
        {
            obj2 = String.format(Locale.US, "URL: %s, code: %d, error: %s, start delta: %d, finish delta: %d, processing time: %d, response size: %d", new Object[] {
                url, Integer.valueOf(statusCode), er, Long.valueOf(gD - gC), Long.valueOf(gE - gC), Long.valueOf(gE - gD), Integer.valueOf(gA)
            });
            Log.d("SessionM.Request", (new StringBuilder()).append("Finish request, ").append(((String) (obj2))).toString());
        }
        if (gv != null)
        {
            gv.a(gz, er, statusCode, gx);
        }
        Throwable throwable;
        if (obj != null)
        {
            try
            {
                ((HttpURLConnection) (obj)).disconnect();
            }
            catch (Throwable throwable1)
            {
                if (Log.isLoggable("SessionM.Request", 3))
                {
                    Log.d("SessionM.Request", "Exception on disconnect.", throwable1);
                }
            }
        }
        throw obj1;
_L6:
        ((HttpURLConnection) (obj1)).setRequestMethod(method.toString());
        if (gv != null)
        {
            gv.aJ();
        }
        if (Log.isLoggable("SessionM.Cookies", 3))
        {
            Log.d("SessionM.Cookies", String.format("Full cookie for api request: %s", new Object[] {
                gB
            }));
        }
        ((HttpURLConnection) (obj1)).setRequestProperty("Cookie", CookieManager.getInstance().getCookie(url));
        if (eu)
        {
            ((HttpURLConnection) (obj1)).addRequestProperty(com.sessionm.net.Request.Header.eM.getKey(), "only-if-cached");
        }
        if (gz != null || eu)
        {
            break MISSING_BLOCK_LABEL_1333;
        }
        if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT"))
        {
            ((HttpURLConnection) (obj1)).setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            ((HttpURLConnection) (obj1)).setDoOutput(true);
            ((HttpURLConnection) (obj1)).setDoInput(true);
            obj = new BufferedOutputStream(((HttpURLConnection) (obj1)).getOutputStream());
            ((OutputStream) (obj)).write(gw.getBytes("UTF-8"));
            ((OutputStream) (obj)).flush();
            ((OutputStream) (obj)).close();
        }
        obj = new BufferedInputStream(((HttpURLConnection) (obj1)).getInputStream(), 0x10000);
        statusCode = ((HttpURLConnection) (obj1)).getResponseCode();
        gx = ((HttpURLConnection) (obj1)).getHeaderFields();
        gv.b(gx);
        eJ = gv.aK();
        gz = null;
        if (statusCode >= 200 && statusCode < 400)
        {
            if (eJ == null)
            {
                break MISSING_BLOCK_LABEL_1186;
            }
            obj2 = new BufferedOutputStream(new FileOutputStream(eJ));
            gA = i.a(((InputStream) (obj)), ((OutputStream) (obj2)));
            gz = new d(null);
            gz.b(eJ);
            ((OutputStream) (obj2)).close();
        }
_L7:
        ((InputStream) (obj)).close();
        if (er != null || gx == null || !eK)
        {
            break MISSING_BLOCK_LABEL_1227;
        }
        obj2 = a(gx, com.sessionm.net.Request.Header.eP.getKey());
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_1227;
        }
        obj = CookieManager.getInstance();
        CookieSyncManager.getInstance().startSync();
        for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); ((CookieManager) (obj)).setCookie(url, ((String) (obj3))))
        {
            obj3 = (String)((Iterator) (obj2)).next();
        }

        break MISSING_BLOCK_LABEL_1221;
        obj2 = new ByteArrayOutputStream(0x10000);
        gA = i.a(((InputStream) (obj)), ((OutputStream) (obj2)));
        gz = new d(((ByteArrayOutputStream) (obj2)));
          goto _L7
        CookieSyncManager.getInstance().stopSync();
        if (statusCode >= 300 && statusCode < 310 && statusCode != 304 && gH < 10 && ((HttpURLConnection) (obj1)).getHeaderField("Location") != null)
        {
            url = (new URL(((HttpURLConnection) (obj1)).getHeaderField("Location"))).toString();
            gz = null;
            gG = statusCode;
            gH = gH + 1;
            while (gz == null) 
            {
                run();
            }
        }
        gE = System.currentTimeMillis();
        if (Log.isLoggable("SessionM.Request", 3))
        {
            obj = String.format(Locale.US, "URL: %s, code: %d, error: %s, start delta: %d, finish delta: %d, processing time: %d, response size: %d", new Object[] {
                url, Integer.valueOf(statusCode), er, Long.valueOf(gD - gC), Long.valueOf(gE - gC), Long.valueOf(gE - gD), Integer.valueOf(gA)
            });
            Log.d("SessionM.Request", (new StringBuilder()).append("Finish request, ").append(((String) (obj))).toString());
        }
        if (gv != null)
        {
            gv.a(gz, er, statusCode, gx);
        }
        if (obj1 == null) goto _L9; else goto _L8
_L8:
        try
        {
            ((HttpURLConnection) (obj1)).disconnect();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        if (!Log.isLoggable("SessionM.Request", 3)) goto _L9; else goto _L10
_L10:
        Log.d("SessionM.Request", "Exception on disconnect.", ((Throwable) (obj)));
        return;
        obj3;
        obj = obj1;
        if (!Log.isLoggable("SessionM.Request", 3)) goto _L12; else goto _L11
_L11:
        obj = obj1;
        Log.d("SessionM.Request", "Status code unavailable.", ((Throwable) (obj3)));
          goto _L12
_L5:
        obj = obj1;
        if (!Log.isLoggable("SessionM.Request", 3)) goto _L14; else goto _L13
_L13:
        obj = obj1;
        Log.d("SessionM.Request", "Uncaught exception during request processing", ((Throwable) (obj2)));
          goto _L14
        throwable;
        if (Log.isLoggable("SessionM.Request", 3))
        {
            Log.d("SessionM.Request", "Exception on disconnect.", throwable);
            return;
        }
          goto _L9
        obj2;
        obj1 = obj3;
          goto _L15
        obj1;
          goto _L16
    }

    void setMethod(String s)
    {
        method = s;
    }

    void setTimeout(long l)
    {
        if (l < 0L)
        {
            gF = 30000L;
            return;
        } else
        {
            gF = l;
            return;
        }
    }

    static 
    {
        gG = 0;
    }
}
