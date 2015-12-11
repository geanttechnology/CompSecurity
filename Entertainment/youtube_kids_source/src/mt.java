// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

public class mt
    implements ly
{

    private static boolean a;
    private static int b = 3000;
    private static int c = 4096;
    private mx d;
    private mu e;

    public mt(mx mx1)
    {
        this(mx1, new mu(c));
    }

    private mt(mx mx1, mu mu1)
    {
        d = mx1;
        e = mu1;
    }

    private static Map a(Header aheader[])
    {
        HashMap hashmap = new HashMap();
        for (int i = 0; i < aheader.length; i++)
        {
            hashmap.put(aheader[i].getName(), aheader[i].getValue());
        }

        return hashmap;
    }

    private static void a(String s, me me1, mp mp1)
    {
        mm mm1 = me1.h;
        int i = me1.k_();
        try
        {
            mm1.a(mp1);
        }
        // Misplaced declaration of an exception variable
        catch (mp mp1)
        {
            me1.a(String.format("%s-timeout-giveup [timeout=%s]", new Object[] {
                s, Integer.valueOf(i)
            }));
            throw mp1;
        }
        me1.a(String.format("%s-retry [timeout=%s]", new Object[] {
            s, Integer.valueOf(i)
        }));
    }

    private byte[] a(HttpEntity httpentity)
    {
        Object obj;
        Exception exception;
        na na1;
        na1 = new na(e, (int)httpentity.getContentLength());
        exception = null;
        obj = exception;
        InputStream inputstream = httpentity.getContent();
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        obj = exception;
        throw new mn();
        exception;
        byte abyte0[];
        byte abyte1[];
        int i;
        try
        {
            httpentity.consumeContent();
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            mq.a("Error occured when calling consumingContent", new Object[0]);
        }
        e.a(((byte []) (obj)));
        na1.close();
        throw exception;
        obj = exception;
        abyte0 = e.a(1024);
_L2:
        obj = abyte0;
        i = inputstream.read(abyte0);
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = abyte0;
        na1.write(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
_L1:
        obj = abyte0;
        abyte1 = na1.toByteArray();
        try
        {
            httpentity.consumeContent();
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            mq.a("Error occured when calling consumingContent", new Object[0]);
        }
        e.a(abyte0);
        na1.close();
        return abyte1;
    }

    public mb a(me me1)
    {
        long l = SystemClock.elapsedRealtime();
_L3:
        Object obj;
        Object obj2;
        byte abyte0[];
        HttpResponse httpresponse;
        Object obj3;
        HttpResponse httpresponse1;
        httpresponse1 = null;
        obj = null;
        obj3 = new HashMap();
        obj2 = obj3;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        Object obj4 = new HashMap();
        obj2 = obj3;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        Object obj5 = me1.i;
        if (obj5 == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        obj2 = obj3;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        if (((ls) (obj5)).b == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        obj2 = obj3;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        ((Map) (obj4)).put("If-None-Match", ((ls) (obj5)).b);
        obj2 = obj3;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        if (((ls) (obj5)).c <= 0L)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        obj2 = obj3;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        ((Map) (obj4)).put("If-Modified-Since", DateUtils.formatDate(new Date(((ls) (obj5)).c)));
        obj2 = obj3;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        httpresponse1 = d.a(me1, ((Map) (obj4)));
        obj2 = obj3;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        obj5 = httpresponse1.getStatusLine();
        obj2 = obj3;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        int i = ((StatusLine) (obj5)).getStatusCode();
        obj2 = obj3;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        obj4 = a(httpresponse1.getAllHeaders());
        if (i != 304) goto _L2; else goto _L1
_L1:
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        long l1;
        try
        {
            return new mb(304, me1.i.a, ((Map) (obj4)), true);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a("socket", me1, ((mp) (new mo())));
        }
        catch (ConnectTimeoutException connecttimeoutexception)
        {
            a("connection", me1, ((mp) (new mo())));
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException((new StringBuilder("Bad URL ")).append(me1.a()).toString(), malformedurlexception);
        }
        catch (Object obj1)
        {
            if (httpresponse != null)
            {
                int j = httpresponse.getStatusLine().getStatusCode();
                mq.c("Unexpected response code %d for %s", new Object[] {
                    Integer.valueOf(j), me1.a()
                });
                if (abyte0 != null)
                {
                    obj1 = new mb(j, abyte0, ((Map) (obj2)), false);
                    if (j == 401 || j == 403)
                    {
                        a("auth", me1, ((mp) (new lq(((mb) (obj1))))));
                    } else
                    {
                        throw new mn(((mb) (obj1)));
                    }
                } else
                {
                    throw new ma(null);
                }
            } else
            {
                throw new mc(((Throwable) (obj1)));
            }
        }
        if (true) goto _L3; else goto _L2
_L2:
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        if (httpresponse1.getEntity() == null) goto _L5; else goto _L4
_L4:
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        obj = a(httpresponse1.getEntity());
_L11:
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        l1 = SystemClock.elapsedRealtime() - l;
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        if (a) goto _L7; else goto _L6
_L6:
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        if (l1 <= (long)b) goto _L8; else goto _L7
_L7:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_726;
        }
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        obj3 = Integer.valueOf(obj.length);
_L12:
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        mq.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] {
            me1, Long.valueOf(l1), obj3, Integer.valueOf(((StatusLine) (obj5)).getStatusCode()), Integer.valueOf(me1.h.b())
        });
_L8:
        if (i == 200 || i == 204) goto _L10; else goto _L9
_L9:
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        throw new IOException();
_L5:
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        obj = new byte[0];
          goto _L11
_L10:
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        httpresponse = httpresponse1;
        obj = new mb(i, ((byte []) (obj)), ((Map) (obj4)), false);
        return ((mb) (obj));
        obj3 = "null";
          goto _L12
    }

    static 
    {
        a = mq.a;
    }
}
