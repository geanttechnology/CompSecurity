// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

// Referenced classes of package com.paypal.android.sdk:
//            hl

public final class ge
{

    private final String a;
    private final List b;
    private final List c;

    private ge(String s, List list, List list1)
    {
        a = s;
        b = list;
        c = list1;
    }

    public static ge a(SSLSession sslsession)
    {
        String s = sslsession.getCipherSuite();
        if (s == null)
        {
            throw new IllegalStateException("cipherSuite == null");
        }
        List list;
        try
        {
            list = sslsession.getPeerCertificates();
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list = null;
        }
        if (list != null)
        {
            list = hl.a(list);
        } else
        {
            list = Collections.emptyList();
        }
        sslsession = sslsession.getLocalCertificates();
        if (sslsession != null)
        {
            sslsession = hl.a(sslsession);
        } else
        {
            sslsession = Collections.emptyList();
        }
        return new ge(s, list, sslsession);
    }

    public final String a()
    {
        return a;
    }

    public final List b()
    {
        return b;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof ge)
        {
            if (a.equals(((ge) (obj = (ge)obj)).a) && b.equals(((ge) (obj)).b) && c.equals(((ge) (obj)).c))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return ((a.hashCode() + 527) * 31 + b.hashCode()) * 31 + c.hashCode();
    }
}
