// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

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

// Referenced classes of package com.paypal.android.sdk:
//            kj

public final class kk
    implements HostnameVerifier
{

    public static final kk a = new kk();
    private static final Pattern b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private kk()
    {
    }

    public static List a(X509Certificate x509certificate)
    {
        List list = a(x509certificate, 7);
        x509certificate = a(x509certificate, 2);
        ArrayList arraylist = new ArrayList(list.size() + x509certificate.size());
        arraylist.addAll(list);
        arraylist.addAll(x509certificate);
        return arraylist;
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
        if (s != null && s.length() != 0 && !s.startsWith(".") && !s.endsWith("..") && s1 != null && s1.length() != 0 && !s1.startsWith(".") && !s1.endsWith(".."))
        {
            String s2 = s;
            if (!s.endsWith("."))
            {
                s2 = (new StringBuilder()).append(s).append('.').toString();
            }
            s = s1;
            if (!s1.endsWith("."))
            {
                s = (new StringBuilder()).append(s1).append('.').toString();
            }
            s = s.toLowerCase(Locale.US);
            if (!s.contains("*"))
            {
                return s2.equals(s);
            }
            if (s.startsWith("*.") && s.indexOf('*', 1) == -1 && s2.length() >= s.length() && !"*.".equals(s))
            {
                s = s.substring(1);
                if (s2.endsWith(s))
                {
                    int i = s2.length() - s.length();
                    if (i <= 0 || s2.lastIndexOf('.', i - 1) == -1)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean verify(String s, SSLSession sslsession)
    {
        sslsession = (X509Certificate)sslsession.getPeerCertificates()[0];
        if (!b.matcher(s).matches()) goto _L2; else goto _L1
_L1:
        int j;
        sslsession = a(sslsession, 7);
        j = sslsession.size();
        int i = 0;
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
          goto _L3
_L2:
        List list;
        int k;
        boolean flag;
        try
        {
            s = s.toLowerCase(Locale.US);
            list = a(sslsession, 2);
            k = list.size();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        j = 0;
        i = 0;
_L6:
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        if (a(s, (String)list.get(j)))
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_177;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        sslsession = (new kj(sslsession.getSubjectX500Principal())).a("cn");
        if (sslsession == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        flag = a(s, sslsession);
        return flag;
        return false;
_L3:
        if (s.equalsIgnoreCase((String)sslsession.get(i)))
        {
            return true;
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        return false;
        j++;
        i = 1;
          goto _L6
    }

}
