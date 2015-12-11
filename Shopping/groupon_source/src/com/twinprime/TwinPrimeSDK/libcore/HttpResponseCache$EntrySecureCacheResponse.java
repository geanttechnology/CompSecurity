// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK.libcore;

import java.io.InputStream;
import java.net.SecureCacheResponse;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;

// Referenced classes of package com.twinprime.TwinPrimeSDK.libcore:
//            HttpResponseCache, RawHeaders

public static class in extends SecureCacheResponse
{

    private final entry entry;
    private final InputStream in;

    public InputStream getBody()
    {
        return in;
    }

    public String getCipherSuite()
    {
        return entry.entry;
    }

    public Map getHeaders()
    {
        return entry.entry.toMultimap(true);
    }

    public List getLocalCertificateChain()
    {
        if (entry.entry == null || entry.entry.length == 0)
        {
            return null;
        } else
        {
            return Arrays.asList((Object[])entry.entry.clone());
        }
    }

    public Principal getLocalPrincipal()
    {
        if (entry.entry == null || entry.entry.length == 0)
        {
            return null;
        } else
        {
            return ((X509Certificate)entry.entry[0]).getSubjectX500Principal();
        }
    }

    public Principal getPeerPrincipal()
        throws SSLPeerUnverifiedException
    {
        if (entry.entry == null || entry.entry.length == 0)
        {
            throw new SSLPeerUnverifiedException(null);
        } else
        {
            return ((X509Certificate)entry.entry[0]).getSubjectX500Principal();
        }
    }

    public List getServerCertificateChain()
        throws SSLPeerUnverifiedException
    {
        if (entry.entry == null || entry.entry.length == 0)
        {
            throw new SSLPeerUnverifiedException(null);
        } else
        {
            return Arrays.asList((Object[])entry.entry.clone());
        }
    }

    public ( ,  1)
    {
        entry = ;
        in = 1.in(1);
    }
}
