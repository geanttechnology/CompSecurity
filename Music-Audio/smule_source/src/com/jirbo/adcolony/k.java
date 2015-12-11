// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

// Referenced classes of package com.jirbo.adcolony:
//            bj, an, l, bl, 
//            ak, be, n, q

class k extends bj
    implements Runnable
{

    be a;
    l b;
    String c;
    File d;
    Object e;
    String f;
    String g;
    boolean h;
    boolean i;
    boolean j;
    Map k;
    int l;
    String m;

    k(be be1, String s, l l1)
    {
        this(be1, s, l1, null);
    }

    k(be be1, String s, l l1, String s1)
    {
        super(be1, false);
        c = s;
        b = l1;
        if (s1 != null)
        {
            d = new File(s1);
        }
    }

    k a(Object obj)
    {
        e = obj;
        return this;
    }

    k a(String s, String s1)
    {
        f = s;
        g = s1;
        return this;
    }

    public void a()
    {
        an.a(this);
    }

    void b()
    {
        b.a(this);
    }

    public void run()
    {
        int l1 = 1;
_L46:
        if (l1 > 3) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        byte abyte0[] = (HttpURLConnection)(HttpURLConnection)(new URL(c)).openConnection();
        if (f == null) goto _L4; else goto _L3
_L3:
        bl.a.b("Performing POST");
        if (!c.startsWith("https://") || android.os.Build.VERSION.SDK_INT < 10) goto _L6; else goto _L5
_L5:
        obj = (HttpsURLConnection)(HttpsURLConnection)(new URL(c)).openConnection();
        j = true;
_L47:
        if (!j) goto _L8; else goto _L7
_L7:
        ((HttpsURLConnection) (obj)).setRequestMethod("POST");
_L26:
        if (!j) goto _L10; else goto _L9
_L9:
        ((HttpsURLConnection) (obj)).setDoOutput(true);
_L27:
        if (!j) goto _L12; else goto _L11
_L11:
        obj1 = new PrintStream(((HttpsURLConnection) (obj)).getOutputStream());
_L28:
        ((PrintStream) (obj1)).println(g);
        bl.a.a("Post data: ").b(g);
        if (!j) goto _L14; else goto _L13
_L13:
        ((HttpsURLConnection) (obj)).connect();
_L29:
        if ((!j || ((HttpsURLConnection) (obj)).getResponseCode() != 200) && (j || abyte0.getResponseCode() != 200)) goto _L16; else goto _L15
_L15:
        if (!j) goto _L18; else goto _L17
_L17:
        obj1 = ((HttpsURLConnection) (obj)).getInputStream();
_L30:
        Object obj2 = new StringBuilder();
        if (!j) goto _L20; else goto _L19
_L19:
        obj = ((HttpsURLConnection) (obj)).getHeaderFields();
_L31:
        int i1;
        k = ((Map) (obj));
        obj = new byte[1024];
        i1 = ((InputStream) (obj1)).read(((byte []) (obj)), 0, 1024);
          goto _L21
_L24:
        int j1;
        j1++;
        if (j1 >= i1) goto _L23; else goto _L22
_L22:
        ((StringBuilder) (obj2)).append((char)obj[j1]);
          goto _L24
_L16:
        if (l1 != 3) goto _L25; else goto _L2
_L2:
        i = false;
        ak.a(this);
        return;
_L8:
        abyte0.setRequestMethod("POST");
          goto _L26
_L10:
        abyte0.setDoOutput(true);
          goto _L27
_L12:
        obj1 = new PrintStream(abyte0.getOutputStream());
          goto _L28
_L14:
        abyte0.connect();
          goto _L29
_L18:
        obj1 = abyte0.getInputStream();
          goto _L30
_L20:
        obj = abyte0.getHeaderFields();
          goto _L31
_L23:
        i1 = ((InputStream) (obj1)).read(((byte []) (obj)), 0, 1024);
          goto _L21
_L49:
        try
        {
            ((InputStream) (obj1)).close();
            m = ((StringBuilder) (obj2)).toString();
            l = m.length();
            i = true;
            ak.a(this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ak.c((new StringBuilder()).append("Download of ").append(c).append(" failed:\n").append(((IOException) (obj)).toString()).toString());
        }
          goto _L16
_L4:
        abyte0.setReadTimeout(30000);
        if (h)
        {
            abyte0.setInstanceFollowRedirects(false);
        }
        if (d == null) goto _L33; else goto _L32
_L32:
        if (a != null && a.f != null)
        {
            a.f.b();
        }
        obj = d.getAbsolutePath();
        obj1 = new FileOutputStream(((String) (obj)));
        obj2 = abyte0.getInputStream();
        j1 = abyte0.getContentLength();
        l = 0;
        abyte0 = new byte[1024];
        i1 = ((InputStream) (obj2)).read(abyte0, 0, 1024);
          goto _L34
_L51:
        int k1;
        l = l + k1;
        ((OutputStream) (obj1)).write(abyte0, 0, k1);
        i1 = ((InputStream) (obj2)).read(abyte0, 0, 1024);
        int i2;
        j1 = i2;
        if (i2 != 0) goto _L34; else goto _L35
_L35:
        ((InputStream) (obj2)).close();
        ((OutputStream) (obj1)).flush();
        ((OutputStream) (obj1)).close();
        bl.b.a("Downloaded ").a(c).a(" to ").b(obj);
_L45:
        i = true;
        ak.a(this);
        return;
_L33:
        if (!h)
        {
            break MISSING_BLOCK_LABEL_789;
        }
        obj = obj1;
        if (!c.startsWith("https://"))
        {
            break MISSING_BLOCK_LABEL_704;
        }
        obj = obj1;
        if (android.os.Build.VERSION.SDK_INT >= 10)
        {
            obj = (HttpsURLConnection)(HttpsURLConnection)(new URL(c)).openConnection();
            j = true;
        }
        if (!j)
        {
            break MISSING_BLOCK_LABEL_780;
        }
        i1 = ((HttpsURLConnection) (obj)).getResponseCode();
_L36:
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_789;
        }
        bl.a.a("Got HTTP response ").a(i1).b(" - counting as completed submission for 3rd party tracking.");
        bl.b.a("Downloaded ").b(c);
        m = "";
        l = 0;
        i = true;
        ak.a(this);
        return;
        i1 = abyte0.getResponseCode();
          goto _L36
        if (!c.startsWith("https://") || android.os.Build.VERSION.SDK_INT < 10) goto _L38; else goto _L37
_L37:
        obj = (HttpsURLConnection)(HttpsURLConnection)(new URL(c)).openConnection();
        j = true;
        bl.a.b("ADCDownload - use ssl!");
_L42:
        bl.a.b("ADCDownload - before pause");
        try
        {
            Thread.sleep(3000L);
        }
        catch (Exception exception) { }
        bl.a.b("ADCDownload - getInputStream");
        if (!j) goto _L40; else goto _L39
_L39:
        obj = ((HttpsURLConnection) (obj)).getInputStream();
_L43:
        obj1 = new StringBuilder();
        abyte0 = new byte[1024];
        i1 = ((InputStream) (obj)).read(abyte0, 0, 1024);
_L44:
        if (i1 == -1)
        {
            break MISSING_BLOCK_LABEL_988;
        }
        j1 = -1;
_L41:
        j1++;
        if (j1 >= i1)
        {
            break MISSING_BLOCK_LABEL_974;
        }
        ((StringBuilder) (obj1)).append((char)abyte0[j1]);
          goto _L41
        obj;
        bl.d.b("Out of memory, disabling AdColony");
        q.a();
        return;
_L38:
        j = false;
          goto _L42
_L40:
        obj = abyte0.getInputStream();
          goto _L43
        i1 = ((InputStream) (obj)).read(abyte0, 0, 1024);
          goto _L44
        ((InputStream) (obj)).close();
        m = ((StringBuilder) (obj1)).toString();
        l = m.length();
        if (c.contains("androidads21"))
        {
            ak.S = System.currentTimeMillis();
        }
        bl.b.a("Downloaded ").b(c);
          goto _L45
        obj;
        bl.d.b("Out of memory, disabling AdColony");
        q.a();
        return;
_L25:
        long l2 = (l1 + 1) * 10 * 1000;
        try
        {
            Thread.sleep(l2);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        bl.b.a("Trying again (").a(l1 + 1).b("/3)");
        l1++;
          goto _L46
_L6:
        obj = null;
          goto _L47
_L21:
        if (i1 == -1) goto _L49; else goto _L48
_L48:
        j1 = -1;
          goto _L24
_L34:
        if (i1 == -1) goto _L35; else goto _L50
_L50:
        k1 = i1;
        i2 = j1;
        if (j1 > 0)
        {
            k1 = i1;
            if (i1 > j1)
            {
                k1 = j1;
            }
            i2 = j1 - k1;
        }
          goto _L51
    }
}
