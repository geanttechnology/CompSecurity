// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.e;

import c.a.a.a.q;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.security.auth.x500.X500Principal;

// Referenced classes of package c.a.a.a.a.e:
//            n, m, l, b, 
//            d

public class a
{

    private final q a;
    private l b;
    private SSLSocketFactory c;
    private boolean d;

    public a()
    {
        this(new q());
    }

    public a(q q1)
    {
        a = q1;
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

    private static boolean a(X509Certificate x509certificate, X509Certificate x509certificate1)
    {
        if (!x509certificate.getSubjectX500Principal().equals(x509certificate1.getIssuerX500Principal()))
        {
            return false;
        }
        try
        {
            x509certificate1.verify(x509certificate.getPublicKey());
        }
        // Misplaced declaration of an exception variable
        catch (X509Certificate x509certificate)
        {
            return false;
        }
        return true;
    }

    public static X509Certificate[] a(X509Certificate ax509certificate[], n n1)
    {
        boolean flag2 = true;
        LinkedList linkedlist = new LinkedList();
        boolean flag;
        boolean flag1;
        int i;
        if (n1.a(ax509certificate[0]))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        linkedlist.add(ax509certificate[0]);
        i = 1;
        do
        {
            flag1 = flag;
            if (i >= ax509certificate.length)
            {
                break;
            }
            if (n1.a(ax509certificate[i]))
            {
                flag = true;
            }
            flag1 = flag;
            if (!a(ax509certificate[i], ax509certificate[i - 1]))
            {
                break;
            }
            linkedlist.add(ax509certificate[i]);
            i++;
        } while (true);
        ax509certificate = n1.b(ax509certificate[i - 1]);
        if (ax509certificate != null)
        {
            linkedlist.add(ax509certificate);
            flag = flag2;
        } else
        {
            flag = flag1;
        }
        if (flag)
        {
            return (X509Certificate[])linkedlist.toArray(new X509Certificate[linkedlist.size()]);
        } else
        {
            throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
        }
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
        Object obj;
        obj = b;
        SSLContext sslcontext = SSLContext.getInstance("TLS");
        sslcontext.init(null, new TrustManager[] {
            new m(new n(((l) (obj)).getKeyStoreStream(), ((l) (obj)).getKeyStorePassword()), ((l) (obj)))
        }, null);
        obj = sslcontext.getSocketFactory();
        a.a("Fabric", "Custom SSL pinning enabled");
_L2:
        this;
        JVM INSTR monitorexit ;
        return ((SSLSocketFactory) (obj));
        Object obj1;
        obj1;
        a.c("Fabric", "Exception while validating pinned certs", ((Throwable) (obj1)));
        obj1 = null;
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        throw obj1;
    }

    public d a(int i, String s)
    {
        return a(i, s, Collections.emptyMap());
    }

    public d a(int i, String s, Map map)
    {
        boolean flag = true;
        b.a[i - 1];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 50
    //                   2 112
    //                   3 122
    //                   4 130;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_130;
_L1:
        throw new IllegalArgumentException("Unsupported HTTP method!");
_L2:
        map = c.a.a.a.a.e.d.a(s, map, true);
_L6:
        if (s != null && s.toLowerCase(Locale.US).startsWith("https"))
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        if (i != 0 && b != null)
        {
            s = b();
            if (s != null)
            {
                ((HttpsURLConnection)map.a()).setSSLSocketFactory(s);
            }
        }
        return map;
_L3:
        map = c.a.a.a.a.e.d.b(s, map, true);
          goto _L6
_L4:
        map = c.a.a.a.a.e.d.a(s);
          goto _L6
        map = c.a.a.a.a.e.d.b(s);
          goto _L6
    }

    public void a(l l1)
    {
        if (b != l1)
        {
            b = l1;
            a();
        }
    }
}
