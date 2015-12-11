// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.c;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

// Referenced classes of package com.a.a.a.c:
//            a

public final class b
    implements HostnameVerifier
{

    public static final b a = new b();
    private static final Pattern b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private b()
    {
    }

    private static List a(X509Certificate x509certificate, int i)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        Object obj;
        Integer integer;
        try
        {
            x509certificate = x509certificate.getSubjectAlternativeNames();
        }
        // Misplaced declaration of an exception variable
        catch (X509Certificate x509certificate)
        {
            return Collections.emptyList();
        }
        if (x509certificate != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        return Collections.emptyList();
        x509certificate = x509certificate.iterator();
_L2:
        do
        {
            if (!x509certificate.hasNext())
            {
                break MISSING_BLOCK_LABEL_118;
            }
            obj = (List)x509certificate.next();
        } while (obj == null);
        if (((List) (obj)).size() < 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        integer = (Integer)((List) (obj)).get(0);
        if (integer == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (integer.intValue() != i)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (String)((List) (obj)).get(1);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        arraylist.add(obj);
        if (true) goto _L2; else goto _L1
_L1:
        return arraylist;
    }

    private static boolean a(String s, String s1)
    {
        boolean flag1 = true;
        if (s != null && s.length() != 0 && s1 != null && s1.length() != 0) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        s1 = s1.toLowerCase(Locale.US);
        if (!s1.contains("*"))
        {
            return s.equals(s1);
        }
        if (!s1.startsWith("*."))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (s.regionMatches(0, s1, 2, s1.length() - 2)) goto _L4; else goto _L3
_L3:
        int i = s1.indexOf('*');
        if (i > s1.indexOf('.'))
        {
            return false;
        }
        if (!s.regionMatches(0, s1, 0, i))
        {
            return false;
        }
        int j = s1.length() - (i + 1);
        int k = s.length() - j;
        if (s.indexOf('.', i) < k && !s.endsWith(".clients.google.com"))
        {
            return false;
        }
        flag = flag1;
        if (!s.regionMatches(k, s1, i + 1, j))
        {
            return false;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public final boolean verify(String s, SSLSession sslsession)
    {
        sslsession = (X509Certificate)sslsession.getPeerCertificates()[0];
        if (!b.matcher(s).matches()) goto _L2; else goto _L1
_L1:
        sslsession = a(sslsession, 7).iterator();
_L6:
        if (!sslsession.hasNext()) goto _L4; else goto _L3
_L3:
        if (!s.equalsIgnoreCase((String)sslsession.next())) goto _L6; else goto _L5
_L5:
        return true;
_L2:
        String s1;
        a a1;
        boolean flag;
        try
        {
            s1 = s.toLowerCase(Locale.US);
            s = a(sslsession, 2).iterator();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        flag = false;
        if (!s.hasNext()) goto _L8; else goto _L7
_L7:
        if (a(s1, (String)s.next()))
        {
            return true;
        }
        flag = true;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_86;
        }
          goto _L9
_L8:
        if (flag) goto _L11; else goto _L10
_L10:
        a1 = new a(sslsession.getSubjectX500Principal());
        a1.c = 0;
        a1.d = 0;
        a1.e = 0;
        a1.f = 0;
        a1.g = a1.a.toCharArray();
        sslsession = a1.a();
        if (sslsession != null) goto _L13; else goto _L12
_L12:
        s = null;
_L24:
        if (s == null) goto _L11; else goto _L14
_L14:
        return a(s1, s);
_L13:
        s = "";
        if (a1.c != a1.b)
        {
            break MISSING_BLOCK_LABEL_211;
        }
        s = null;
        continue; /* Loop/switch isn't completed */
        a1.g[a1.c];
        JVM INSTR lookupswitch 5: default 717
    //                   34: 305
    //                   35: 566
    //                   43: 278
    //                   44: 278
    //                   59: 278;
           goto _L15 _L16 _L17 _L18 _L18 _L18
_L17:
        break MISSING_BLOCK_LABEL_566;
_L18:
        break; /* Loop/switch isn't completed */
_L15:
        s = a1.c();
_L21:
        if ("cn".equalsIgnoreCase(sslsession))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (a1.c >= a1.b)
        {
            s = null;
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_575;
_L16:
        a1.c = a1.c + 1;
        a1.d = a1.c;
        a1.e = a1.d;
_L19:
        if (a1.c == a1.b)
        {
            throw new IllegalStateException((new StringBuilder("Unexpected end of DN: ")).append(a1.a).toString());
        }
        if (a1.g[a1.c] == '"')
        {
            for (a1.c = a1.c + 1; a1.c < a1.b && a1.g[a1.c] == ' '; a1.c = a1.c + 1) { }
            break MISSING_BLOCK_LABEL_534;
        }
        if (a1.g[a1.c] != '\\')
        {
            break MISSING_BLOCK_LABEL_509;
        }
        a1.g[a1.e] = a1.d();
_L20:
        a1.c = a1.c + 1;
        a1.e = a1.e + 1;
          goto _L19
        a1.g[a1.e] = a1.g[a1.c];
          goto _L20
        s = new String(a1.g, a1.d, a1.e - a1.d);
          goto _L21
        s = a1.b();
          goto _L21
        if (a1.g[a1.c] != ',' && a1.g[a1.c] != ';' && a1.g[a1.c] != '+')
        {
            throw new IllegalStateException((new StringBuilder("Malformed DN: ")).append(a1.a).toString());
        }
        a1.c = a1.c + 1;
        sslsession = a1.a();
        if (sslsession != null) goto _L13; else goto _L22
_L22:
        throw new IllegalStateException((new StringBuilder("Malformed DN: ")).append(a1.a).toString());
_L11:
        return false;
_L4:
        return false;
_L9:
        if (true) goto _L24; else goto _L23
_L23:
    }

}
