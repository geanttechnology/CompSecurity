// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.client;

import com.comcast.cim.httpcomponentsandroid.conn.ssl.TrustStrategy;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

// Referenced classes of package com.comcast.cim.cmasl.apachehttp.client:
//            HttpClientProvider

class this._cls0
    implements TrustStrategy
{

    final HttpClientProvider this$0;

    public boolean isTrusted(X509Certificate ax509certificate[], String s)
        throws CertificateException
    {
        return true;
    }

    ()
    {
        this$0 = HttpClientProvider.this;
        super();
    }
}
