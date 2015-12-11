// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecFactory;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;

// Referenced classes of package cz.msebera.android.httpclient.impl.cookie:
//            IgnoreSpec

public class IgnoreSpecFactory
    implements CookieSpecFactory, CookieSpecProvider
{

    public IgnoreSpecFactory()
    {
    }

    public CookieSpec create(HttpContext httpcontext)
    {
        return new IgnoreSpec();
    }

    public CookieSpec newInstance(HttpParams httpparams)
    {
        return new IgnoreSpec();
    }
}
