// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework.security;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.amazon.identity.auth.device.framework.security:
//            StrongCipherSSLSocketFactory, CertificatePinning

final class EnhancedSSLSocketFactory
{

    static final SSLSocketFactory INSTANCE;

    static 
    {
        INSTANCE = new StrongCipherSSLSocketFactory(CertificatePinning.SSL_CONTEXT.getSocketFactory());
    }
}
