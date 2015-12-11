// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.apache.http.impl.client.AbstractHttpClient;

final class bgw extends bmr
{

    private bgv a;

    bgw(bgv bgv1)
    {
        a = bgv1;
        super();
    }

    public final Object a()
    {
        Object obj = a;
        obj = a.a(((bgv) (obj)).n(), ((bgv) (obj)).e(), (new bke()).a());
        if (obj instanceof AbstractHttpClient)
        {
            AbstractHttpClient abstracthttpclient = (AbstractHttpClient)obj;
            abstracthttpclient.setRedirectHandler(new bks());
            abstracthttpclient.setCookieStore(new bjz());
        }
        return obj;
    }
}
