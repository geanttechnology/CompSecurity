// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

// Referenced classes of package com.paypal.android.sdk:
//            gn, bq, bo, bp, 
//            fv

public class bn
{

    public bn()
    {
    }

    public static gn a(int i, boolean flag, boolean flag1, String s, String s1)
    {
        gn gn1;
        (new StringBuilder("Creating okhttp client.  networkTimeout=90000")).append(", isTrustAll=").append(flag).append(", useSslPinning=").append(flag1).append(", userAgent=").append(s).append(", baseUrl=").append(s1);
        gn1 = new gn();
        gn1.a(Integer.valueOf(0x15f90).longValue(), TimeUnit.SECONDS);
        gn1.u().add(new bq(s));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        s = new bo();
        s1 = SSLContext.getInstance("TLSv1");
        s1.init(null, new TrustManager[] {
            s
        }, null);
        gn1.a(s1.getSocketFactory());
        gn1.a(new bp());
        return gn1;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        s1 = (new URI(s1)).getHost();
        s = s1;
        if (s1.startsWith("www."))
        {
            s = s1.substring(4);
        }
        gn1.a((new fv()).a(s, new String[] {
            "sha1/u8I+KQuzKHcdrT6iTb30I70GsD0="
        }).a(s, new String[] {
            "sha1/7Q3I1izTEynYgv4tw/zFENNNuxQ="
        }).a(s, new String[] {
            "sha1/sYEIGhmkwJQf+uiVKMEkyZs0rMc="
        }).a(s, new String[] {
            "sha1/gzF+YoVCU9bXeDGQ7JGQVumRueM="
        }).a());
        return gn1;
        s;
_L2:
        throw new RuntimeException(s);
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L2; else goto _L1
_L1:
        return gn1;
    }

    static 
    {
        com/paypal/android/sdk/bn.getSimpleName();
    }
}
