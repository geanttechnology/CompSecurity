// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.e;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

// Referenced classes of package com.b.e:
//            r

final class s
    implements X509TrustManager
{

    final r a;

    s(r r)
    {
        a = r;
        super();
    }

    public final void checkClientTrusted(X509Certificate ax509certificate[], String s1)
    {
    }

    public final void checkServerTrusted(X509Certificate ax509certificate[], String s1)
    {
    }

    public final X509Certificate[] getAcceptedIssuers()
    {
        return null;
    }
}
