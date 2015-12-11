// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLSocket;

final class AmazonApprovedCiphers
{

    private static final Set ALLOWED_CIPHERS;
    private static final Set APPROVED_CIPHERS;
    private static final String APPROVED_PROTOCOLS[] = {
        "TLSv1"
    };
    private static final Set DEPRECATED_CIPHERS;
    private static final boolean ENABLED_ON_THIS_PLATFORM;

    private AmazonApprovedCiphers()
    {
    }

    private static boolean enable(SSLSocket sslsocket, Set set)
    {
        if (ENABLED_ON_THIS_PLATFORM)
        {
            String as[] = sslsocket.getSupportedCipherSuites();
            ArrayList arraylist = new ArrayList();
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                if (set.contains(s))
                {
                    arraylist.add(s);
                }
            }

            sslsocket.setEnabledCipherSuites((String[])arraylist.toArray(new String[arraylist.size()]));
            sslsocket.setEnabledProtocols(APPROVED_PROTOCOLS);
            return sslsocket.getEnabledCipherSuites().length > 0 && sslsocket.getEnabledProtocols().length > 0;
        } else
        {
            return true;
        }
    }

    static boolean enableAllowed(SSLSocket sslsocket)
    {
        return enable(sslsocket, ALLOWED_CIPHERS);
    }

    static boolean enableApproved(SSLSocket sslsocket)
    {
        return enable(sslsocket, APPROVED_CIPHERS);
    }

    static 
    {
        HashSet hashset;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 10)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ENABLED_ON_THIS_PLATFORM = flag;
        APPROVED_CIPHERS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] {
            "TLS_RSA_WITH_AES_128_CBC_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_DH_RSA_WITH_AES_128_CBC_SHA256", "TLS_DH_RSA_WITH_AES_256_CBC_SHA256", "TLS_DH_RSA_WITH_AES_128_GCM_SHA256", "TLS_DH_RSA_WITH_AES_256_GCM_SHA384", "TLS_DH_DSS_WITH_AES_128_CBC_SHA256", "TLS_DH_DSS_WITH_AES_256_CBC_SHA256", 
            "TLS_DH_DSS_WITH_AES_128_GCM_SHA256", "TLS_DH_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 
            "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 
            "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_DH_anon_WITH_AES_128_CBC_SHA256", "TLS_DH_anon_WITH_AES_256_CBC_SHA256", "TLS_DH_anon_WITH_AES_128_GCM_SHA256", "TLS_DH_anon_WITH_AES_256_GCM_SHA384"
        })));
        DEPRECATED_CIPHERS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] {
            "TLS_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_DH_DSS_WITH_3DES_EDE_CBC_SHA", "TLS_DH_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_DH_anon_WITH_3DES_EDE_CBC_SHA", "SSL_RSA_WITH_3DES_EDE_CBC_SHA", "SSL_DH_DSS_WITH_3DES_EDE_CBC_SHA", "SSL_DH_RSA_WITH_3DES_EDE_CBC_SHA", "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 
            "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_DH_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DH_anon_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_DH_DSS_WITH_AES_256_CBC_SHA", "TLS_DH_RSA_WITH_AES_256_CBC_SHA", 
            "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DH_anon_WITH_AES_256_CBC_SHA"
        })));
        hashset = new HashSet();
        hashset.addAll(APPROVED_CIPHERS);
        hashset.addAll(DEPRECATED_CIPHERS);
        ALLOWED_CIPHERS = Collections.unmodifiableSet(hashset);
    }
}
