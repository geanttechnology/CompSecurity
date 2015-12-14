// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.squareup.okhttp:
//            CipherSuite, TlsVersion, Route, Address

public final class ConnectionSpec
{

    public static final ConnectionSpec CLEARTEXT = (false. new Builder()).build();
    public static final ConnectionSpec COMPATIBLE_TLS;
    public static final ConnectionSpec MODERN_TLS;
    private final String cipherSuites[];
    private ConnectionSpec supportedSpec;
    final boolean supportsTlsExtensions;
    final boolean tls;
    private final String tlsVersions[];

    private ConnectionSpec(Builder builder)
    {
        tls = builder.tls;
        cipherSuites = builder.cipherSuites;
        tlsVersions = builder.tlsVersions;
        supportsTlsExtensions = builder.supportsTlsExtensions;
    }


    private ConnectionSpec supportedSpec(SSLSocket sslsocket)
    {
        List list = Util.intersect(Arrays.asList(cipherSuites), Arrays.asList(sslsocket.getSupportedCipherSuites()));
        sslsocket = Util.intersect(Arrays.asList(tlsVersions), Arrays.asList(sslsocket.getSupportedProtocols()));
        return (new Builder()).cipherSuites((String[])list.toArray(new String[list.size()])).tlsVersions((String[])sslsocket.toArray(new String[sslsocket.size()])).build();
    }

    void apply(SSLSocket sslsocket, Route route)
    {
        Object obj = supportedSpec;
        ConnectionSpec connectionspec = ((ConnectionSpec) (obj));
        if (obj == null)
        {
            connectionspec = supportedSpec(sslsocket);
            supportedSpec = connectionspec;
        }
        sslsocket.setEnabledProtocols(connectionspec.tlsVersions);
        sslsocket.setEnabledCipherSuites(connectionspec.cipherSuites);
        obj = Platform.get();
        if (connectionspec.supportsTlsExtensions)
        {
            ((Platform) (obj)).configureTlsExtensions(sslsocket, route.address.uriHost, route.address.protocols);
        }
    }

    public List cipherSuites()
    {
        CipherSuite aciphersuite[] = new CipherSuite[cipherSuites.length];
        for (int i = 0; i < cipherSuites.length; i++)
        {
            aciphersuite[i] = CipherSuite.forJavaName(cipherSuites[i]);
        }

        return Util.immutableList(aciphersuite);
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof ConnectionSpec)
        {
            if (tls == ((ConnectionSpec) (obj = (ConnectionSpec)obj)).tls && (!tls || Arrays.equals(cipherSuites, ((ConnectionSpec) (obj)).cipherSuites) && Arrays.equals(tlsVersions, ((ConnectionSpec) (obj)).tlsVersions) && supportsTlsExtensions == ((ConnectionSpec) (obj)).supportsTlsExtensions))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        int i = 17;
        if (tls)
        {
            int j = Arrays.hashCode(cipherSuites);
            int k = Arrays.hashCode(tlsVersions);
            if (supportsTlsExtensions)
            {
                i = 0;
            } else
            {
                i = 1;
            }
            i += ((j + 527) * 31 + k) * 31;
        }
        return i;
    }

    public boolean isTls()
    {
        return tls;
    }

    public boolean supportsTlsExtensions()
    {
        return supportsTlsExtensions;
    }

    public List tlsVersions()
    {
        TlsVersion atlsversion[] = new TlsVersion[tlsVersions.length];
        for (int i = 0; i < tlsVersions.length; i++)
        {
            atlsversion[i] = TlsVersion.forJavaName(tlsVersions[i]);
        }

        return Util.immutableList(atlsversion);
    }

    public String toString()
    {
        if (tls)
        {
            return (new StringBuilder()).append("ConnectionSpec(cipherSuites=").append(cipherSuites()).append(", tlsVersions=").append(tlsVersions()).append(", supportsTlsExtensions=").append(supportsTlsExtensions).append(")").toString();
        } else
        {
            return "ConnectionSpec()";
        }
    }

    static 
    {
        MODERN_TLS = (true. new Builder()).cipherSuites(new CipherSuite[] {
            CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_RC4_128_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_RC4_128_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, 
            CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_RSA_WITH_RC4_128_SHA, CipherSuite.TLS_RSA_WITH_RC4_128_MD5
        }).tlsVersions(new TlsVersion[] {
            TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0, TlsVersion.SSL_3_0
        }).supportsTlsExtensions(true).build();
        COMPATIBLE_TLS = (MODERN_TLS. new Builder()).tlsVersions(new TlsVersion[] {
            TlsVersion.SSL_3_0
        }).build();
    }



    private class Builder
    {

        private String cipherSuites[];
        private boolean supportsTlsExtensions;
        private boolean tls;
        private String tlsVersions[];

        public ConnectionSpec build()
        {
            return new ConnectionSpec(this);
        }

        public transient Builder cipherSuites(CipherSuite aciphersuite[])
        {
            if (!tls)
            {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String as[] = new String[aciphersuite.length];
            for (int i = 0; i < aciphersuite.length; i++)
            {
                as[i] = aciphersuite[i].javaName;
            }

            return cipherSuites(as);
        }

        Builder cipherSuites(String as[])
        {
            cipherSuites = as;
            return this;
        }

        public Builder supportsTlsExtensions(boolean flag)
        {
            if (!tls)
            {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            } else
            {
                supportsTlsExtensions = flag;
                return this;
            }
        }

        public transient Builder tlsVersions(TlsVersion atlsversion[])
        {
            if (!tls)
            {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String as[] = new String[atlsversion.length];
            for (int i = 0; i < atlsversion.length; i++)
            {
                as[i] = atlsversion[i].javaName;
            }

            return tlsVersions(as);
        }

        transient Builder tlsVersions(String as[])
        {
            tlsVersions = as;
            return this;
        }





        public Builder()
        {
            tls = ConnectionSpec.this.tls;
            cipherSuites = ConnectionSpec.this.cipherSuites;
            tlsVersions = ConnectionSpec.this.tlsVersions;
            supportsTlsExtensions = ConnectionSpec.this.supportsTlsExtensions;
        }

        private Builder()
        {
            tls = Z.this;
        }

    }

}
