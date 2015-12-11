// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework.security;

import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.amazon.identity.auth.device.framework.security:
//            CertificatePinnedSSLContext, StrongCipherSSLSocketFactory

final class EnhancedSSLSocketFactory
{

    private static SSLSocketFactory sTheOnlyInstance;

    private EnhancedSSLSocketFactory()
    {
    }

    static SSLSocketFactory getInstance()
        throws GeneralSecurityException, IOException
    {
        com/amazon/identity/auth/device/framework/security/EnhancedSSLSocketFactory;
        JVM INSTR monitorenter ;
        if (sTheOnlyInstance != null) goto _L2; else goto _L1
_L1:
        Object obj = CertificatePinnedSSLContext.getInstance();
        if (obj != null) goto _L4; else goto _L3
_L3:
        obj = null;
_L6:
        sTheOnlyInstance = ((SSLSocketFactory) (obj));
_L2:
        obj = sTheOnlyInstance;
        com/amazon/identity/auth/device/framework/security/EnhancedSSLSocketFactory;
        JVM INSTR monitorexit ;
        return ((SSLSocketFactory) (obj));
_L4:
        obj = new StrongCipherSSLSocketFactory(((SSLContext) (obj)).getSocketFactory());
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }
}
