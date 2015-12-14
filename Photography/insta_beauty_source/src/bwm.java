// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class bwm
{

    public static final SSLSocketFactory a(bwn bwn1)
    {
        SSLContext sslcontext = SSLContext.getInstance("TLS");
        sslcontext.init(null, new TrustManager[] {
            new bwo(new bwp(bwn1.getKeyStoreStream(), bwn1.getKeyStorePassword()), bwn1)
        }, null);
        return sslcontext.getSocketFactory();
    }
}
