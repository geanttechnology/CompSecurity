// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            p, q, l, k, 
//            r, o, n, c, 
//            ad, ak, g, y, 
//            aa

final class i extends p
{
    private final class a
    {

        int a;
        ByteArrayOutputStream b;
        final i c;

        public final boolean a(c c1)
        {
            w.a(c1);
            if (a + 1 > ad.g())
            {
                return false;
            }
            String s = c.a(c1, false);
            if (s == null)
            {
                ((o) (c)).i.a().a(c1, "Error formatting hit");
                return true;
            }
            byte abyte0[] = s.getBytes();
            int i1 = abyte0.length;
            if (i1 > ad.c())
            {
                ((o) (c)).i.a().a(c1, "Hit size exceeds the maximum size limit");
                return true;
            }
            int j = i1;
            if (b.size() > 0)
            {
                j = i1 + 1;
            }
            if (b.size() + j > ((Integer)ak.A.a()).intValue())
            {
                return false;
            }
            try
            {
                if (b.size() > 0)
                {
                    b.write(i.c());
                }
                b.write(abyte0);
            }
            // Misplaced declaration of an exception variable
            catch (c c1)
            {
                c.e("Failed to write payload when batching hits", c1);
                return true;
            }
            a = a + 1;
            return true;
        }

        public a()
        {
            c = i.this;
            super();
            b = new ByteArrayOutputStream();
        }
    }


    private static final byte c[] = "\n".getBytes();
    private final String a;
    private final k b;

    i(r r1)
    {
        super(r1);
        a = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] {
            "GoogleAnalytics", q.a, android.os.Build.VERSION.RELEASE, l.a(Locale.getDefault()), Build.MODEL, Build.ID
        });
        b = new k(r1.c);
    }

    private int a(URL url)
    {
        URL url1;
        URL url2;
        w.a(url);
        b("GET request", url);
        url2 = null;
        url1 = null;
        url = b(url);
        url1 = url;
        url2 = url;
        url.connect();
        url1 = url;
        url2 = url;
        a(((HttpURLConnection) (url)));
        url1 = url;
        url2 = url;
        int j = url.getResponseCode();
        if (j != 200)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        url1 = url;
        url2 = url;
        super.i.c().e();
        url1 = url;
        url2 = url;
        b("GET status", Integer.valueOf(j));
        if (url != null)
        {
            url.disconnect();
        }
        return j;
        url;
        url2 = url1;
        d("Network GET connection error", url);
        if (url1 != null)
        {
            url1.disconnect();
        }
        return 0;
        url;
        if (url2 != null)
        {
            url2.disconnect();
        }
        throw url;
    }

    private int a(URL url, byte abyte0[])
    {
        URL url2;
        OutputStream outputstream;
        OutputStream outputstream1;
        Object obj;
        url2 = null;
        outputstream1 = null;
        obj = null;
        outputstream = null;
        w.a(url);
        w.a(abyte0);
        b("POST bytes, url", Integer.valueOf(abyte0.length), url);
        if (m())
        {
            a("Post payload\n", new String(abyte0));
        }
        url = b(url);
        URL url1;
        url2 = url;
        url = outputstream1;
        url1 = url2;
        outputstream = obj;
        url2.setDoOutput(true);
        url = outputstream1;
        url1 = url2;
        outputstream = obj;
        url2.setFixedLengthStreamingMode(abyte0.length);
        url = outputstream1;
        url1 = url2;
        outputstream = obj;
        url2.connect();
        url = outputstream1;
        url1 = url2;
        outputstream = obj;
        outputstream1 = url2.getOutputStream();
        url = outputstream1;
        url1 = url2;
        outputstream = outputstream1;
        outputstream1.write(abyte0);
        url = outputstream1;
        url1 = url2;
        outputstream = outputstream1;
        a(((HttpURLConnection) (url2)));
        url = outputstream1;
        url1 = url2;
        outputstream = outputstream1;
        int j = url2.getResponseCode();
        if (j != 200)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        url = outputstream1;
        url1 = url2;
        outputstream = outputstream1;
        super.i.c().e();
        url = outputstream1;
        url1 = url2;
        outputstream = outputstream1;
        b("POST status", Integer.valueOf(j));
        if (outputstream1 != null)
        {
            try
            {
                outputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                e("Error closing http post connection output stream", url);
            }
        }
        if (url2 != null)
        {
            url2.disconnect();
        }
        return j;
        abyte0;
        url2 = null;
_L4:
        url = outputstream;
        url1 = url2;
        d("Network POST connection error", abyte0);
        if (outputstream != null)
        {
            try
            {
                outputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                e("Error closing http post connection output stream", url);
            }
        }
        if (url2 != null)
        {
            url2.disconnect();
        }
        return 0;
        abyte0;
        url1 = null;
        url = url2;
_L2:
        if (url != null)
        {
            try
            {
                url.close();
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                e("Error closing http post connection output stream", url);
            }
        }
        if (url1 != null)
        {
            url1.disconnect();
        }
        throw abyte0;
        abyte0;
        if (true) goto _L2; else goto _L1
_L1:
        abyte0;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private URL a(c c1)
    {
        if (c1.f)
        {
            c1 = (new StringBuilder()).append(ad.h()).append(ad.j()).toString();
        } else
        {
            c1 = (new StringBuilder()).append(ad.i()).append(ad.j()).toString();
        }
        try
        {
            c1 = new URL(c1);
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            e("Error trying to parse the hardcoded host url", c1);
            return null;
        }
        return c1;
    }

    private URL a(c c1, String s)
    {
        if (c1.f)
        {
            c1 = (new StringBuilder()).append(ad.h()).append(ad.j()).append("?").append(s).toString();
        } else
        {
            c1 = (new StringBuilder()).append(ad.i()).append(ad.j()).append("?").append(s).toString();
        }
        try
        {
            c1 = new URL(c1);
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            e("Error trying to parse the hardcoded host url", c1);
            return null;
        }
        return c1;
    }

    private static void a(StringBuilder stringbuilder, String s, String s1)
    {
        if (stringbuilder.length() != 0)
        {
            stringbuilder.append('&');
        }
        stringbuilder.append(URLEncoder.encode(s, "UTF-8"));
        stringbuilder.append('=');
        stringbuilder.append(URLEncoder.encode(s1, "UTF-8"));
    }

    private void a(HttpURLConnection httpurlconnection)
    {
        HttpURLConnection httpurlconnection1 = null;
        httpurlconnection = httpurlconnection.getInputStream();
        httpurlconnection1 = httpurlconnection;
        byte abyte0[] = new byte[1024];
_L2:
        httpurlconnection1 = httpurlconnection;
        int j = httpurlconnection.read(abyte0);
        if (j > 0) goto _L2; else goto _L1
_L1:
        if (httpurlconnection == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        httpurlconnection.close();
        return;
        httpurlconnection;
        e("Error closing http connection input stream", httpurlconnection);
        return;
        httpurlconnection;
        if (httpurlconnection1 != null)
        {
            try
            {
                httpurlconnection1.close();
            }
            catch (IOException ioexception)
            {
                e("Error closing http connection input stream", ioexception);
            }
        }
        throw httpurlconnection;
    }

    private int b(URL url, byte abyte0[])
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        w.a(url);
        w.a(abyte0);
        byte abyte1[];
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        GZIPOutputStream gzipoutputstream = new GZIPOutputStream(bytearrayoutputstream);
        gzipoutputstream.write(abyte0);
        gzipoutputstream.close();
        bytearrayoutputstream.close();
        abyte1 = bytearrayoutputstream.toByteArray();
        super.a(3, "POST compressed size, ratio %, url", Integer.valueOf(abyte1.length), Long.valueOf((100L * (long)abyte1.length) / (long)abyte0.length), url);
        if (abyte1.length > abyte0.length)
        {
            c("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(abyte1.length), Integer.valueOf(abyte0.length));
        }
        if (m())
        {
            a("Post payload", (new StringBuilder("\n")).append(new String(abyte0)).toString());
        }
        url = b(url);
        Exception exception;
        Exception exception1;
        int j;
        try
        {
            url.setDoOutput(true);
            url.addRequestProperty("Content-Encoding", "gzip");
            url.setFixedLengthStreamingMode(abyte1.length);
            url.connect();
            abyte0 = url.getOutputStream();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Object obj2 = null;
            abyte0 = url;
            url = obj2;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            continue; /* Loop/switch isn't completed */
        }
        abyte0.write(abyte1);
        abyte0.close();
        a(url);
        j = url.getResponseCode();
        if (j != 200)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        super.i.c().e();
        b("POST status", Integer.valueOf(j));
        if (url != null)
        {
            url.disconnect();
        }
        return j;
        obj;
        url = null;
        abyte0 = obj1;
_L4:
        d("Network compressed POST connection error", obj);
        if (url != null)
        {
            try
            {
                url.close();
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                e("Error closing http compressed post connection output stream", url);
            }
        }
        if (abyte0 != null)
        {
            abyte0.disconnect();
        }
        return 0;
        abyte0;
        url = null;
_L2:
        if (obj != null)
        {
            try
            {
                ((OutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                e("Error closing http compressed post connection output stream", obj);
            }
        }
        if (url != null)
        {
            url.disconnect();
        }
        throw abyte0;
        exception;
        obj = abyte0;
        abyte0 = exception;
        continue; /* Loop/switch isn't completed */
        exception1;
        obj = abyte0;
        URL url1 = url;
        abyte0 = exception1;
        url = ((URL) (obj));
        obj = url1;
        if (true) goto _L2; else goto _L1
_L1:
        break MISSING_BLOCK_LABEL_187;
        obj;
        URL url2 = url;
        url = abyte0;
        abyte0 = url2;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private HttpURLConnection b(URL url)
    {
        url = url.openConnection();
        if (!(url instanceof HttpURLConnection))
        {
            throw new IOException("Failed to obtain http connection");
        } else
        {
            url = (HttpURLConnection)url;
            url.setDefaultUseCaches(false);
            url.setConnectTimeout(((Integer)ak.E.a()).intValue());
            url.setReadTimeout(((Integer)ak.F.a()).intValue());
            url.setInstanceFollowRedirects(false);
            url.setRequestProperty("User-Agent", a);
            url.setDoInput(true);
            return url;
        }
    }

    private List b(List list)
    {
        ArrayList arraylist;
        arraylist = new ArrayList(list.size());
        list = list.iterator();
_L4:
        c c1;
        Object obj;
        boolean flag;
        if (!list.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        c1 = (c)list.next();
        w.a(c1);
        boolean flag1;
        if (!c1.f)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj = a(c1, flag1);
        if (obj != null) goto _L2; else goto _L1
_L1:
        super.i.a().a(c1, "Error formatting hit for upload");
        flag = true;
_L9:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(Long.valueOf(c1.c));
        if (arraylist.size() < com.google.android.gms.analytics.internal.ad.f()) goto _L4; else goto _L3
_L3:
        return arraylist;
_L2:
        if (((String) (obj)).length() > ((Integer)ak.u.a()).intValue()) goto _L6; else goto _L5
_L5:
        obj = a(c1, ((String) (obj)));
        if (obj != null) goto _L8; else goto _L7
_L7:
        f("Failed to build collect GET endpoint url");
_L10:
        flag = false;
          goto _L9
_L8:
        if (a(((URL) (obj))) == 200)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L9
_L6:
        byte abyte0[];
        String s = a(c1, false);
        if (s == null)
        {
            super.i.a().a(c1, "Error formatting hit for POST upload");
            flag = true;
        } else
        {
label0:
            {
                abyte0 = s.getBytes();
                if (abyte0.length <= ((Integer)ak.z.a()).intValue())
                {
                    break label0;
                }
                super.i.a().a(c1, "Hit payload exceeds size limit");
                flag = true;
            }
        }
          goto _L9
        URL url;
        url = a(c1);
        if (url != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        f("Failed to build collect POST endpoint url");
          goto _L10
        if (a(url, abyte0) != 200) goto _L10; else goto _L11
_L11:
        flag = true;
          goto _L9
    }

    static byte[] c()
    {
        return c;
    }

    private URL d()
    {
        Object obj = (new StringBuilder()).append(ad.h()).append((String)ak.t.a()).toString();
        try
        {
            obj = new URL(((String) (obj)));
        }
        catch (MalformedURLException malformedurlexception)
        {
            e("Error trying to parse the hardcoded host url", malformedurlexception);
            return null;
        }
        return ((URL) (obj));
    }

    final String a(c c1, boolean flag)
    {
        StringBuilder stringbuilder;
        w.a(c1);
        stringbuilder = new StringBuilder();
        try
        {
            Iterator iterator = c1.a.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                String s = (String)entry.getKey();
                if (!"ht".equals(s) && !"qt".equals(s) && !"AppUID".equals(s) && !"z".equals(s) && !"_gmsv".equals(s))
                {
                    a(stringbuilder, s, (String)entry.getValue());
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            e("Failed to encode name or value", c1);
            return null;
        }
        a(stringbuilder, "ht", String.valueOf(c1.d));
        a(stringbuilder, "qt", String.valueOf(super.i.c.a() - c1.d));
        if (f.a)
        {
            a(stringbuilder, "_gmsv", q.a);
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        long l1 = l.b(c1.a("_s", "0"));
        if (l1 == 0L) goto _L4; else goto _L3
_L3:
        c1 = String.valueOf(l1);
_L5:
        a(stringbuilder, "z", ((String) (c1)));
_L2:
        return stringbuilder.toString();
_L4:
        l1 = c1.c;
        c1 = String.valueOf(l1);
          goto _L5
    }

    public final List a(List list)
    {
        boolean flag3;
        flag3 = true;
        r.i();
        o();
        w.a(list);
        if (!super.i.d.k().isEmpty() && b.a((long)((Integer)ak.C.a()).intValue() * 1000L)) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L6:
        boolean flag;
        boolean flag2;
        flag2 = false;
        flag = flag1;
_L7:
        a a1;
        ArrayList arraylist;
        if (!flag) goto _L4; else goto _L3
_L2:
        if (y.a((String)ak.v.a()) != y.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (aa.a((String)com.google.android.gms.analytics.internal.ak.w.a()) != aa.b) goto _L6; else goto _L5
_L5:
        flag2 = true;
          goto _L7
_L3:
        if (list.isEmpty())
        {
            flag3 = false;
        }
        w.b(flag3);
        a("Uploading batched hits. compression, count", Boolean.valueOf(flag2), Integer.valueOf(list.size()));
        a1 = new a();
        arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            c c1 = (c)list.next();
            if (!a1.a(c1))
            {
                break;
            }
            arraylist.add(Long.valueOf(c1.c));
        } while (true);
        if (a1.a == 0)
        {
            return arraylist;
        }
        list = d();
        if (list != null) goto _L9; else goto _L8
_L8:
        f("Failed to build batching endpoint url");
_L10:
        return Collections.emptyList();
_L9:
        int j;
        if (flag2)
        {
            j = b(list, a1.b.toByteArray());
        } else
        {
            j = a(((URL) (list)), a1.b.toByteArray());
        }
        if (200 == j)
        {
            a("Batched upload completed. Hits batched", Integer.valueOf(a1.a));
            return arraylist;
        }
        a("Network error uploading hits. status code", Integer.valueOf(j));
        if (super.i.d.k().contains(Integer.valueOf(j)))
        {
            e("Server instructed the client to stop batching");
            b.a();
        }
        if (true) goto _L10; else goto _L4
_L4:
        return b(list);
    }

    protected final void a()
    {
        a("Network initialized. User agent", a);
    }

    public final boolean b()
    {
        r.i();
        o();
        Object obj = (ConnectivityManager)super.i.a.getSystemService("connectivity");
        try
        {
            obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
        }
        catch (SecurityException securityexception)
        {
            securityexception = null;
        }
        if (obj == null || !((NetworkInfo) (obj)).isConnected())
        {
            b("No network connectivity");
            return false;
        } else
        {
            return true;
        }
    }

}
