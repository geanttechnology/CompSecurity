// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class asd
    implements art
{

    public static final atj a = new ase();
    private static final Pattern d = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public HttpURLConnection b;
    public long c;
    private final int e;
    private final int f;
    private final String g;
    private final atj h;
    private final HashMap i = new HashMap();
    private final asq j;
    private arx k;
    private InputStream l;
    private boolean m;
    private long n;

    public asd(String s, atj atj1, asq asq1, int i1, int j1)
    {
        g = a.c(s);
        h = atj1;
        j = asq1;
        e = i1;
        f = j1;
    }

    private static long a(HttpURLConnection httpurlconnection)
    {
        String s;
        long l1;
        long l2;
        l2 = -1L;
        s = httpurlconnection.getHeaderField("Content-Length");
        l1 = l2;
        Matcher matcher;
        long l3;
        if (!TextUtils.isEmpty(s))
        {
            try
            {
                l1 = Long.parseLong(s);
            }
            catch (NumberFormatException numberformatexception1)
            {
                Log.e("HttpDataSource", (new StringBuilder(String.valueOf(s).length() + 28)).append("Unexpected Content-Length [").append(s).append("]").toString());
                l1 = l2;
            }
        }
        httpurlconnection = httpurlconnection.getHeaderField("Content-Range");
        l2 = l1;
        if (TextUtils.isEmpty(httpurlconnection)) goto _L2; else goto _L1
_L1:
        matcher = d.matcher(httpurlconnection);
        l2 = l1;
        if (!matcher.find()) goto _L2; else goto _L3
_L3:
        long l4;
        try
        {
            l2 = Long.parseLong(matcher.group(2));
            l3 = Long.parseLong(matcher.group(1));
        }
        catch (NumberFormatException numberformatexception)
        {
            Log.e("HttpDataSource", (new StringBuilder(String.valueOf(httpurlconnection).length() + 27)).append("Unexpected Content-Range [").append(httpurlconnection).append("]").toString());
            return l1;
        }
        l4 = (l2 - l3) + 1L;
        if (l1 >= 0L) goto _L5; else goto _L4
_L4:
        l2 = l4;
_L2:
        return l2;
_L5:
        l2 = l1;
        if (l1 == l4) goto _L2; else goto _L6
_L6:
        Log.w("HttpDataSource", (new StringBuilder(String.valueOf(s).length() + 26 + String.valueOf(httpurlconnection).length())).append("Inconsistent headers [").append(s).append("] [").append(httpurlconnection).append("]").toString());
        l2 = Math.max(l1, l4);
        return l2;
    }

    private HttpURLConnection b(arx arx1)
    {
        HttpURLConnection httpurlconnection;
        httpurlconnection = (HttpURLConnection)(new URL(arx1.a.toString())).openConnection();
        httpurlconnection.setConnectTimeout(e);
        httpurlconnection.setReadTimeout(f);
        httpurlconnection.setDoOutput(false);
        HashMap hashmap = i;
        hashmap;
        JVM INSTR monitorenter ;
        java.util.Map.Entry entry;
        for (Iterator iterator = i.entrySet().iterator(); iterator.hasNext(); httpurlconnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break MISSING_BLOCK_LABEL_119;
        arx1;
        hashmap;
        JVM INSTR monitorexit ;
        throw arx1;
        hashmap;
        JVM INSTR monitorexit ;
        if (arx1.d != 0L || arx1.e != -1L)
        {
            long l1 = arx1.d;
            String s1 = (new StringBuilder(27)).append("bytes=").append(l1).append("-").toString();
            String s = s1;
            if (arx1.e != -1L)
            {
                s = String.valueOf(s1);
                long l2 = arx1.d;
                long l3 = arx1.e;
                s = (new StringBuilder(String.valueOf(s).length() + 20)).append(s).append((l2 + l3) - 1L).toString();
            }
            httpurlconnection.setRequestProperty("Range", s);
        }
        httpurlconnection.setRequestProperty("User-Agent", g);
        httpurlconnection.connect();
        return httpurlconnection;
    }

    private void c()
    {
        if (b != null)
        {
            b.disconnect();
            b = null;
        }
    }

    public int a(byte abyte0[], int i1, int j1)
    {
        try
        {
            i1 = l.read(abyte0, i1, j1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new asf(abyte0, k);
        }
        if (i1 > 0)
        {
            c = c + (long)i1;
            if (j != null)
            {
                j.a(i1);
            }
        } else
        if (n != -1L && n != c)
        {
            throw new asf(new asr(n, c), k);
        }
        return i1;
    }

    public long a(arx arx1)
    {
        k = arx1;
        c = 0L;
        int i1;
        try
        {
            b = b(arx1);
        }
        catch (IOException ioexception1)
        {
            String s = String.valueOf(arx1.a.toString());
            if (s.length() != 0)
            {
                s = "Unable to connect to ".concat(s);
            } else
            {
                s = new String("Unable to connect to ");
            }
            throw new asf(s, ioexception1, arx1);
        }
        try
        {
            i1 = b.getResponseCode();
        }
        catch (IOException ioexception2)
        {
            String s1 = String.valueOf(arx1.a.toString());
            if (s1.length() != 0)
            {
                s1 = "Unable to connect to ".concat(s1);
            } else
            {
                s1 = new String("Unable to connect to ");
            }
            throw new asf(s1, ioexception2, arx1);
        }
        if (i1 < 200 || i1 > 299)
        {
            java.util.Map map = b.getHeaderFields();
            c();
            throw new ash(i1, map, arx1);
        }
        String s2 = b.getContentType();
        if (h != null && !h.a(s2))
        {
            c();
            throw new asg(s2, arx1);
        }
        long l2 = a(b);
        long l1;
        if (arx1.e == -1L)
        {
            l1 = l2;
        } else
        {
            l1 = arx1.e;
        }
        n = l1;
        if (arx1.e != -1L && l2 != -1L && l2 != arx1.e)
        {
            c();
            throw new asf(new asr(arx1.e, l2), arx1);
        }
        try
        {
            l = b.getInputStream();
        }
        catch (IOException ioexception)
        {
            c();
            throw new asf(ioexception, arx1);
        }
        m = true;
        if (j != null)
        {
            j.b();
        }
        return n;
    }

    public void a()
    {
        InputStream inputstream = l;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        l.close();
        l = null;
        if (m)
        {
            m = false;
            if (j != null)
            {
                j.c();
            }
            c();
        }
        return;
        Object obj;
        obj;
        throw new asf(((IOException) (obj)), k);
        obj;
        if (m)
        {
            m = false;
            if (j != null)
            {
                j.c();
            }
            c();
        }
        throw obj;
    }

    public final long b()
    {
        if (n == -1L)
        {
            return n;
        } else
        {
            return n - c;
        }
    }

}
