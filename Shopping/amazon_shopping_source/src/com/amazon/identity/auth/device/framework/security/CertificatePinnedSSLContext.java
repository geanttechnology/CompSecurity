// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework.security;

import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

// Referenced classes of package com.amazon.identity.auth.device.framework.security:
//            CertificatePinnedKeyStore

final class CertificatePinnedSSLContext
{

    private static SSLContext sTheOnlyInstance;

    private CertificatePinnedSSLContext()
    {
    }

    static SSLContext getInstance()
        throws GeneralSecurityException, IOException
    {
        SSLContext sslcontext = null;
        com/amazon/identity/auth/device/framework/security/CertificatePinnedSSLContext;
        JVM INSTR monitorenter ;
        if (sTheOnlyInstance != null) goto _L2; else goto _L1
_L1:
        java.security.KeyStore keystore = CertificatePinnedKeyStore.getInstance();
        if (keystore != null) goto _L4; else goto _L3
_L3:
        sTheOnlyInstance = sslcontext;
_L2:
        sslcontext = sTheOnlyInstance;
        com/amazon/identity/auth/device/framework/security/CertificatePinnedSSLContext;
        JVM INSTR monitorexit ;
        return sslcontext;
_L4:
        TrustManagerFactory trustmanagerfactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustmanagerfactory.init(keystore);
        sslcontext = SSLContext.getInstance("TLS");
        sslcontext.init(null, trustmanagerfactory.getTrustManagers(), null);
        if (true) goto _L3; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }
}
