// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.net.http.SslError;
import android.webkit.WebChromeClient;

// Referenced classes of package com.google.android.gms.d:
//            gn, hl, he

public static class  extends 
{

    public final WebChromeClient a(he he)
    {
        return new hl(he);
    }

    public final String a(SslError sslerror)
    {
        return sslerror.getUrl();
    }

    public ()
    {
    }
}
