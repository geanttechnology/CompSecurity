// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import com.a.a.a.a.v;
import com.a.a.a.i;
import java.io.InputStream;
import java.net.SecureCacheResponse;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;

// Referenced classes of package com.a.a:
//            f, l

final class n extends SecureCacheResponse
{

    private final l a;
    private final i b;
    private final InputStream c;

    public n(l l1, i i)
    {
        a = l1;
        b = i;
        c = f.a(i);
    }

    static i a(n n1)
    {
        return n1.b;
    }

    public final InputStream getBody()
    {
        return c;
    }

    public final String getCipherSuite()
    {
        return a.e;
    }

    public final Map getHeaders()
    {
        return a.d.a(true);
    }

    public final List getLocalCertificateChain()
    {
        if (a.g == null || a.g.length == 0)
        {
            return null;
        } else
        {
            return Arrays.asList((Object[])a.g.clone());
        }
    }

    public final Principal getLocalPrincipal()
    {
        if (a.g == null || a.g.length == 0)
        {
            return null;
        } else
        {
            return ((X509Certificate)a.g[0]).getSubjectX500Principal();
        }
    }

    public final Principal getPeerPrincipal()
    {
        if (a.f == null || a.f.length == 0)
        {
            throw new SSLPeerUnverifiedException(null);
        } else
        {
            return ((X509Certificate)a.f[0]).getSubjectX500Principal();
        }
    }

    public final List getServerCertificateChain()
    {
        if (a.f == null || a.f.length == 0)
        {
            throw new SSLPeerUnverifiedException(null);
        } else
        {
            return Arrays.asList((Object[])a.f.clone());
        }
    }
}
