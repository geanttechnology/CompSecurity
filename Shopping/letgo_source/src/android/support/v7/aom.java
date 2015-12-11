// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

// Referenced classes of package android.support.v7:
//            aoo, aop, aon

public final class aom
{

    public static final SSLSocketFactory a(aon aon1)
        throws KeyManagementException, NoSuchAlgorithmException
    {
        SSLContext sslcontext = SSLContext.getInstance("TLS");
        sslcontext.init(null, new TrustManager[] {
            new aoo(new aop(aon1.getKeyStoreStream(), aon1.getKeyStorePassword()), aon1)
        }, null);
        return sslcontext.getSocketFactory();
    }
}
