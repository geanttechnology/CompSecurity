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
//            ah, aj, q, ac, 
//            d

final class b extends ah
    implements Runnable
{
    public static interface a
    {

        public abstract void a(b b1);
    }


    ac a;
    a b;
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

    b(ac ac1, String s, a a1)
    {
        this(ac1, s, a1, null);
    }

    b(ac ac1, String s, a a1, String s1)
    {
        super(ac1, false);
        c = s;
        b = a1;
        if (s1 != null)
        {
            d = new File(s1);
        }
    }

    final void a()
    {
        b.a(this);
    }

    public final void run()
    {
        int l1 = 1;
_L26:
        if (l1 > 3) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        byte abyte0[] = (HttpURLConnection)(HttpURLConnection)(new URL(c)).openConnection();
        if (f == null) goto _L4; else goto _L3
_L3:
        aj.a.b("Performing POST");
        if (!c.startsWith("https://") || android.os.Build.VERSION.SDK_INT < 10) goto _L6; else goto _L5
_L5:
        obj = (HttpsURLConnection)(HttpsURLConnection)(new URL(c)).openConnection();
        j = true;
_L47:
        if (!j) goto _L8; else goto _L7
_L7:
        ((HttpsURLConnection) (obj)).setRequestMethod("POST");
_L27:
        if (!j) goto _L10; else goto _L9
_L9:
        ((HttpsURLConnection) (obj)).setDoOutput(true);
_L28:
        if (!j) goto _L12; else goto _L11
_L11:
        obj1 = new PrintStream(((HttpsURLConnection) (obj)).getOutputStream());
_L29:
        ((PrintStream) (obj1)).println(g);
        aj.a.a("Post data: ").b(g);
        if (!j) goto _L14; else goto _L13
_L13:
        ((HttpsURLConnection) (obj)).connect();
_L30:
        if ((!j || ((HttpsURLConnection) (obj)).getResponseCode() != 200) && (j || abyte0.getResponseCode() != 200)) goto _L16; else goto _L15
_L15:
        if (!j) goto _L18; else goto _L17
_L17:
        obj1 = ((HttpsURLConnection) (obj)).getInputStream();
_L31:
        Object obj2 = new StringBuilder();
        if (!j) goto _L20; else goto _L19
_L19:
        obj = ((HttpsURLConnection) (obj)).getHeaderFields();
_L32:
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
        if (l1 == 3) goto _L2; else goto _L25
_L25:
        int k1;
        int i2;
        long l2 = (l1 + 1) * 10 * 1000;
        Exception exception;
        try
        {
            Thread.sleep(l2);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        aj.b.a("Trying again (").a(l1 + 1).b("/3)");
        l1++;
          goto _L26
_L8:
        abyte0.setRequestMethod("POST");
          goto _L27
_L10:
        abyte0.setDoOutput(true);
          goto _L28
_L12:
        obj1 = new PrintStream(abyte0.getOutputStream());
          goto _L29
_L14:
        abyte0.connect();
          goto _L30
_L18:
        obj1 = abyte0.getInputStream();
          goto _L31
_L20:
        obj = abyte0.getHeaderFields();
          goto _L32
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
            q.a(this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            q.c((new StringBuilder("Download of ")).append(c).append(" failed:\n").append(((IOException) (obj)).toString()).toString());
        }
          goto _L16
_L4:
        abyte0.setReadTimeout(30000);
        if (h)
        {
            abyte0.setInstanceFollowRedirects(false);
        }
        if (d == null) goto _L34; else goto _L33
_L33:
        if (a != null && a.f != null)
        {
            a.f.a();
        }
        obj = d.getAbsolutePath();
        obj1 = new FileOutputStream(((String) (obj)));
        obj2 = abyte0.getInputStream();
        j1 = abyte0.getContentLength();
        l = 0;
        abyte0 = new byte[1024];
        i1 = ((InputStream) (obj2)).read(abyte0, 0, 1024);
          goto _L35
_L51:
        l = l + k1;
        ((OutputStream) (obj1)).write(abyte0, 0, k1);
        i1 = ((InputStream) (obj2)).read(abyte0, 0, 1024);
        j1 = i2;
        if (i2 != 0) goto _L35; else goto _L36
_L36:
        ((InputStream) (obj2)).close();
        ((OutputStream) (obj1)).flush();
        ((OutputStream) (obj1)).close();
        aj.b.a("Downloaded ").a(c).a(" to ").b(obj);
_L46:
        i = true;
        q.a(this);
        return;
_L34:
        if (!h)
        {
            break MISSING_BLOCK_LABEL_827;
        }
        obj = obj1;
        if (!c.startsWith("https://"))
        {
            break MISSING_BLOCK_LABEL_741;
        }
        obj = obj1;
        if (android.os.Build.VERSION.SDK_INT >= 10)
        {
            obj = (HttpsURLConnection)(HttpsURLConnection)(new URL(c)).openConnection();
            j = true;
        }
        if (!j)
        {
            break MISSING_BLOCK_LABEL_818;
        }
        i1 = ((HttpsURLConnection) (obj)).getResponseCode();
_L37:
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_827;
        }
        aj.a.a("Got HTTP response ").a(i1).b(" - counting as completed submission for 3rd party tracking.");
        aj.b.a("Downloaded ").b(c);
        m = "";
        l = 0;
        i = true;
        q.a(this);
        return;
        i1 = abyte0.getResponseCode();
          goto _L37
        if (!c.startsWith("https://") || android.os.Build.VERSION.SDK_INT < 10) goto _L39; else goto _L38
_L38:
        obj = (HttpsURLConnection)(HttpsURLConnection)(new URL(c)).openConnection();
        j = true;
        aj.a.b("ADCDownload - use ssl!");
_L43:
        aj.a.b("ADCDownload - before pause");
        try
        {
            Thread.sleep(3000L);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception) { }
        aj.a.b("ADCDownload - getInputStream");
        if (!j) goto _L41; else goto _L40
_L40:
        obj = ((HttpsURLConnection) (obj)).getInputStream();
_L44:
        obj1 = new StringBuilder();
        abyte0 = new byte[1024];
        i1 = ((InputStream) (obj)).read(abyte0, 0, 1024);
_L45:
        if (i1 == -1)
        {
            break MISSING_BLOCK_LABEL_1027;
        }
        j1 = -1;
_L42:
        j1++;
        if (j1 >= i1)
        {
            break MISSING_BLOCK_LABEL_1013;
        }
        ((StringBuilder) (obj1)).append((char)abyte0[j1]);
          goto _L42
        obj;
        aj.d.b("Out of memory, disabling AdColony");
        q.h = true;
        return;
_L39:
        j = false;
          goto _L43
_L41:
        obj = abyte0.getInputStream();
          goto _L44
        i1 = ((InputStream) (obj)).read(abyte0, 0, 1024);
          goto _L45
        ((InputStream) (obj)).close();
        m = ((StringBuilder) (obj1)).toString();
        l = m.length();
        if (c.contains("androidads21"))
        {
            q.S = System.currentTimeMillis();
        }
        aj.b.a("Downloaded ").b(c);
          goto _L46
        obj;
        aj.d.b("Out of memory, disabling AdColony");
        q.h = true;
        return;
_L2:
        i = false;
        q.a(this);
        return;
_L6:
        obj = null;
          goto _L47
_L21:
        if (i1 == -1) goto _L49; else goto _L48
_L48:
        j1 = -1;
          goto _L24
_L35:
        if (i1 == -1) goto _L36; else goto _L50
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
