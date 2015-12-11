// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.net.http.SslError;
import android.webkit.WebChromeClient;

// Referenced classes of package android.support.v7:
//            tq, us, ul

static class r extends r
{

    public WebChromeClient a(ul ul)
    {
        return new us(ul);
    }

    public String a(SslError sslerror)
    {
        return sslerror.getUrl();
    }

    r()
    {
    }
}
