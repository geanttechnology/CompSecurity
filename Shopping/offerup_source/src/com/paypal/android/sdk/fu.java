// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

// Referenced classes of package com.paypal.android.sdk:
//            fv, hl, kt, kp

public final class fu
{

    public static final fu a = (new fv()).a();
    private final Map b;

    private fu(fv fv1)
    {
        b = hl.a(fv.a(fv1));
    }

    fu(fv fv1, byte byte0)
    {
        this(fv1);
    }

    private static kt a(X509Certificate x509certificate)
    {
        return hl.a(kt.a(x509certificate.getPublicKey().getEncoded()));
    }

    public static String a(Certificate certificate)
    {
        if (!(certificate instanceof X509Certificate))
        {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        } else
        {
            return (new StringBuilder("sha1/")).append(kp.a(a((X509Certificate)certificate).b)).toString();
        }
    }

    public final void a(String s, List list)
    {
        Object obj2 = null;
        Object obj1 = (Set)b.get(s);
        int i = s.indexOf('.');
        Object obj;
        int j;
        if (i != s.lastIndexOf('.'))
        {
            obj = (Set)b.get((new StringBuilder("*.")).append(s.substring(i + 1)).toString());
        } else
        {
            obj = null;
        }
        if (obj1 != null || obj != null) goto _L2; else goto _L1
_L1:
        obj = obj2;
_L7:
        if (obj != null) goto _L4; else goto _L3
_L3:
        return;
_L2:
        if (obj1 != null && obj != null)
        {
            obj2 = new LinkedHashSet();
            ((Set) (obj2)).addAll(((java.util.Collection) (obj1)));
            ((Set) (obj2)).addAll(((java.util.Collection) (obj)));
            obj = obj2;
        } else
        if (obj1 != null)
        {
            obj = obj1;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        j = list.size();
        i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                if (((Set) (obj)).contains(a((X509Certificate)list.get(i))))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L3; else goto _L5
_L5:
        obj1 = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        j = list.size();
        for (i = 0; i < j; i++)
        {
            obj2 = (X509Certificate)list.get(i);
            ((StringBuilder) (obj1)).append("\n    ").append(a(((Certificate) (obj2)))).append(": ").append(((X509Certificate) (obj2)).getSubjectDN().getName());
        }

        ((StringBuilder) (obj1)).append("\n  Pinned certificates for ").append(s).append(":");
        for (s = ((Set) (obj)).iterator(); s.hasNext(); ((StringBuilder) (obj1)).append("\n    sha1/").append(kp.a(((kt) (list)).b)))
        {
            list = (kt)s.next();
        }

        throw new SSLPeerUnverifiedException(((StringBuilder) (obj1)).toString());
        if (true) goto _L7; else goto _L6
_L6:
    }

}
