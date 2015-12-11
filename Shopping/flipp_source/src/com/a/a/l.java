// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import com.a.a.a.a.o;
import com.a.a.a.a.q;
import com.a.a.a.a.r;
import com.a.a.a.a.v;
import com.a.a.a.b;
import com.a.a.a.f;
import com.a.a.a.s;
import com.a.a.a.u;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URI;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

final class l
{

    final String a;
    final v b;
    final String c;
    final v d;
    final String e;
    final Certificate f[];
    final Certificate g[];

    public l(InputStream inputstream)
    {
        boolean flag;
        flag = false;
        super();
        Object obj;
        int j;
        obj = new s(inputstream, u.d);
        a = ((s) (obj)).a();
        c = ((s) (obj)).a();
        b = new v();
        j = ((s) (obj)).b();
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        b.c(((s) (obj)).a());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        d = new v();
        d.b(((s) (obj)).a());
        j = ((s) (obj)).b();
        i = ((flag) ? 1 : 0);
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        d.c(((s) (obj)).a());
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (!a())
        {
            break MISSING_BLOCK_LABEL_225;
        }
        String s1 = ((s) (obj)).a();
        if (s1.length() > 0)
        {
            throw new IOException((new StringBuilder("expected \"\" but was \"")).append(s1).append("\"").toString());
        }
        break MISSING_BLOCK_LABEL_196;
        obj;
        inputstream.close();
        throw obj;
        e = ((s) (obj)).a();
        f = a(((s) (obj)));
        g = a(((s) (obj)));
_L5:
        inputstream.close();
        return;
        e = null;
        f = null;
        g = null;
          goto _L5
    }

    public l(URI uri, v v1, HttpURLConnection httpurlconnection)
    {
        a = uri.toString();
        b = v1;
        c = httpurlconnection.getRequestMethod();
        d = v.a(httpurlconnection.getHeaderFields());
        if (httpurlconnection instanceof r)
        {
            uri = ((r)httpurlconnection).a.b();
        } else
        {
            uri = ((o)httpurlconnection).b();
        }
        if (uri instanceof q)
        {
            uri = ((q)uri).k;
        } else
        {
            uri = null;
        }
        if (uri != null)
        {
            e = uri.getSession().getCipherSuite();
            try
            {
                v1 = uri.getSession().getPeerCertificates();
            }
            // Misplaced declaration of an exception variable
            catch (v v1)
            {
                v1 = null;
            }
            f = v1;
            g = uri.getSession().getLocalCertificates();
            return;
        } else
        {
            e = null;
            f = null;
            g = null;
            return;
        }
    }

    private static void a(Writer writer, Certificate acertificate[])
    {
        if (acertificate != null) goto _L2; else goto _L1
_L1:
        writer.write("-1\n");
_L6:
        return;
_L2:
        String s1;
        int i;
        int j;
        try
        {
            writer.write((new StringBuilder()).append(Integer.toString(acertificate.length)).append('\n').toString());
            j = acertificate.length;
        }
        // Misplaced declaration of an exception variable
        catch (Writer writer)
        {
            throw new IOException(writer.getMessage());
        }
        i = 0;
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = com.a.a.a.b.b(acertificate[i].getEncoded());
        writer.write((new StringBuilder()).append(s1).append('\n').toString());
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        break MISSING_BLOCK_LABEL_86;
_L4:
        break MISSING_BLOCK_LABEL_44;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static Certificate[] a(s s1)
    {
        int i = s1.b();
        if (i != -1) goto _L2; else goto _L1
_L1:
        Certificate acertificate[] = null;
_L4:
        return acertificate;
_L2:
        Certificate acertificate1[];
        CertificateFactory certificatefactory;
        try
        {
            certificatefactory = CertificateFactory.getInstance("X.509");
            acertificate1 = new Certificate[i];
        }
        // Misplaced declaration of an exception variable
        catch (s s1)
        {
            throw new IOException(s1.getMessage());
        }
        i = 0;
        acertificate = acertificate1;
        if (i >= acertificate1.length) goto _L4; else goto _L3
_L3:
        acertificate1[i] = certificatefactory.generateCertificate(new ByteArrayInputStream(com.a.a.a.b.a(s1.a().getBytes("US-ASCII"))));
        i++;
        break MISSING_BLOCK_LABEL_31;
    }

    public final void a(f f1)
    {
        boolean flag = false;
        f1 = new BufferedWriter(new OutputStreamWriter(f1.a(0), u.e));
        f1.write((new StringBuilder()).append(a).append('\n').toString());
        f1.write((new StringBuilder()).append(c).append('\n').toString());
        f1.write((new StringBuilder()).append(Integer.toString(b.a())).append('\n').toString());
        for (int i = 0; i < b.a(); i++)
        {
            f1.write((new StringBuilder()).append(b.a(i)).append(": ").append(b.b(i)).append('\n').toString());
        }

        f1.write((new StringBuilder()).append(d.b).append('\n').toString());
        f1.write((new StringBuilder()).append(Integer.toString(d.a())).append('\n').toString());
        for (int j = ((flag) ? 1 : 0); j < d.a(); j++)
        {
            f1.write((new StringBuilder()).append(d.a(j)).append(": ").append(d.b(j)).append('\n').toString());
        }

        if (a())
        {
            f1.write(10);
            f1.write((new StringBuilder()).append(e).append('\n').toString());
            a(((Writer) (f1)), f);
            a(((Writer) (f1)), g);
        }
        f1.close();
    }

    final boolean a()
    {
        return a.startsWith("https://");
    }
}
