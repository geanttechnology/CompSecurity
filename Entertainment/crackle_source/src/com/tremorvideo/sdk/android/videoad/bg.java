// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import com.tremorvideo.sdk.android.richmedia.ae;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bf, ad, n, y

public class bg extends bf
{
    private class a extends Exception
    {

        final bg a;

        public a(String s)
        {
            a = bg.this;
            super(s);
        }
    }


    Context a;
    String b;
    String c;
    long d;
    Checksum e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;

    public bg(bf.a a1, Context context, String s, Map map)
    {
        super(a1);
        if (map.containsKey("checkCache"))
        {
            f = ((Boolean)map.get("checkCache")).booleanValue();
        } else
        {
            f = true;
        }
        if (map.containsKey("mraid"))
        {
            i = ((Boolean)map.get("mraid")).booleanValue();
        } else
        {
            i = false;
        }
        a = context;
        b = (String)map.get("url");
        c = a(b, ((String) (null)));
        if (map.containsKey("crc"))
        {
            d = ((Long)map.get("crc")).longValue();
        } else
        {
            d = 0L;
        }
        e = new CRC32();
    }

    private long a(String s)
        throws Exception
    {
        Object obj = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj)), 18000);
        HttpConnectionParams.setSoTimeout(((HttpParams) (obj)), 18000);
        ((HttpParams) (obj)).setBooleanParameter("http.protocol.expect-continue", false);
        ((HttpParams) (obj)).setParameter("http.protocol.version", HttpVersion.HTTP_1_0);
        obj = new DefaultHttpClient(((HttpParams) (obj)));
        HttpGet httpget = new HttpGet(s);
        ae.a(httpget, s);
        return ((HttpClient) (obj)).execute(httpget).getEntity().getContentLength();
    }

    public static String a(String s, String s1)
    {
        if (s1 == null)
        {
            return (new StringBuilder()).append(ae.a(s)).append("_").append(s.substring(s.lastIndexOf(File.separatorChar) + 1)).toString();
        } else
        {
            return (new StringBuilder()).append(ae.a(s)).append("_").append(s.substring(s.lastIndexOf(File.separatorChar) + 1)).append(s1).toString();
        }
    }

    private void a(boolean flag)
    {
        boolean flag1;
        boolean flag3;
        flag1 = true;
        flag3 = false;
        if (b != null)
        {
            j();
        }
        boolean flag2;
        flag1 = false;
        flag2 = false;
_L2:
        if (h)
        {
            a(bf.b.e);
            return;
        }
        break; /* Loop/switch isn't completed */
        Object obj;
        obj;
        ad.a("Timeout Downloading Asset: ", ((Throwable) (obj)));
        flag2 = false;
        flag3 = true;
        flag1 = false;
        continue; /* Loop/switch isn't completed */
        obj;
        ad.a("An error occured while downloading an asset: ", ((Throwable) (obj)));
        flag2 = false;
        continue; /* Loop/switch isn't completed */
        obj;
        ad.a("An error occured while downloading an asset: ", ((Throwable) (obj)));
        flag2 = true;
        flag1 = false;
        if (true) goto _L2; else goto _L1
_L1:
        if (flag3)
        {
            a(bf.b.f);
            return;
        }
        if (flag1)
        {
            a(bf.b.d);
            return;
        }
        if (flag2)
        {
            a(bf.b.c);
            return;
        } else
        {
            a(bf.b.b);
            return;
        }
    }

    private String i()
    {
        return c;
    }

    private void j()
        throws Exception
    {
        Object obj1;
        Object obj3;
        obj3 = null;
        obj1 = null;
        File file = h();
        if (file.exists()) goto _L2; else goto _L1
_L1:
        long l = 0L;
_L11:
        long l1 = a(b);
        if (l1 == l) goto _L4; else goto _L3
_L3:
        java.io.FileOutputStream fileoutputstream;
        ad.a(e, file);
        fileoutputstream = a.openFileOutput(file.getName(), 32769);
        if (l != 0L) goto _L6; else goto _L5
_L5:
        ad.d("Starting download");
_L12:
        Object obj;
        obj = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj)), 18000);
        HttpConnectionParams.setSoTimeout(((HttpParams) (obj)), 18000);
        ((HttpParams) (obj)).setBooleanParameter("http.protocol.expect-continue", false);
        ((HttpParams) (obj)).setParameter("http.protocol.version", HttpVersion.HTTP_1_0);
        obj = new DefaultHttpClient(((HttpParams) (obj)));
        obj1 = new HttpGet(b);
        ae.a(((HttpGet) (obj1)), b);
        ((HttpGet) (obj1)).addHeader("Range", (new StringBuilder()).append("bytes=").append(l).append("-").toString());
        obj = ((HttpClient) (obj)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)));
        obj1 = ((HttpResponse) (obj)).getEntity();
        if (l1 == l) goto _L8; else goto _L7
_L7:
        if (l1 >= 1L) goto _L10; else goto _L9
_L9:
        file.delete();
        throw new a((new StringBuilder()).append("Content length is invalid: ").append(l1).toString());
        obj;
        Object obj2;
        obj2 = null;
        obj1 = fileoutputstream;
_L15:
        if (obj2 != null)
        {
            ((InputStream) (obj2)).close();
        }
        if (obj1 != null)
        {
            ((OutputStream) (obj1)).close();
        }
        throw obj;
_L2:
        if (!f)
        {
            file.delete();
        }
        l = file.length();
          goto _L11
_L4:
        if (!ad.a(e, file, d))
        {
            file.delete();
            throw new a("CRC Failure");
        }
        ad.d("Asset is fully cached, no need to download again.");
        if (false)
        {
            throw new NullPointerException();
        }
        if (false)
        {
            throw new NullPointerException();
        }
_L17:
        return;
_L6:
        ad.d((new StringBuilder()).append("Resuming download from: ").append(Math.round((float)l / 1024F)).append("kB").toString());
          goto _L12
_L10:
        if (l1 >= l)
        {
            break MISSING_BLOCK_LABEL_435;
        }
        e.reset();
        file.delete();
        throw new a("Cache size miss-match.");
        if (((HttpResponse) (obj)).getStatusLine().getStatusCode() / 100 != 2)
        {
            throw new Exception((new StringBuilder()).append("Connection response is invalid: ").append(((HttpResponse) (obj)).getStatusLine().getStatusCode()).toString());
        }
        obj2 = ((HttpEntity) (obj1)).getContent();
        obj = obj2;
        byte abyte0[] = new byte[1024];
_L14:
        obj = obj2;
        int k = ((InputStream) (obj2)).read(abyte0);
        obj1 = obj2;
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_578;
        }
        obj = obj2;
        e.update(abyte0, 0, k);
        obj = obj2;
        fileoutputstream.write(abyte0, 0, k);
        l += k;
        obj = obj2;
        if (!g) goto _L14; else goto _L13
_L13:
        obj = obj2;
        h = true;
        obj1 = obj2;
_L18:
        obj = obj1;
        if (h)
        {
            break MISSING_BLOCK_LABEL_689;
        }
        obj2 = obj3;
        obj = obj1;
        if (ad.a(e, file, d))
        {
            break MISSING_BLOCK_LABEL_652;
        }
        obj = obj1;
        obj2 = (new StringBuilder()).append("CRC is invalid got: ").append(e.getValue()).append(", expected: ").append(d).toString();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_689;
        }
        obj = obj1;
        file.delete();
        obj = obj1;
        throw new a(((String) (obj2)));
        Exception exception;
        exception;
        obj1 = fileoutputstream;
        obj2 = obj;
        obj = exception;
          goto _L15
        if (obj1 != null)
        {
            ((InputStream) (obj1)).close();
        }
        if (fileoutputstream == null) goto _L17; else goto _L16
_L16:
        fileoutputstream.close();
        return;
_L8:
        obj1 = null;
          goto _L18
        obj;
        obj2 = null;
          goto _L15
    }

    public void a(String s, n n1)
        throws Exception
    {
        n1.a(s, h().getAbsolutePath());
    }

    protected void e()
    {
        if (i && Integer.parseInt(android.os.Build.VERSION.SDK) < 7)
        {
            a(bf.b.c);
            return;
        } else
        {
            g = false;
            h = false;
            a(false);
            return;
        }
    }

    protected void f()
    {
        g = true;
    }

    protected void g()
    {
        g = false;
        h = false;
        a(true);
    }

    public File h()
    {
        return y.a(a.getFilesDir(), i());
    }

    public String toString()
    {
        return (new StringBuilder()).append("Download Asset: ").append(c).toString();
    }
}
