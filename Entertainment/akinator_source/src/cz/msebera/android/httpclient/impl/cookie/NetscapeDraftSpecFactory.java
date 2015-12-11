// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecFactory;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Collection;

// Referenced classes of package cz.msebera.android.httpclient.impl.cookie:
//            NetscapeDraftSpec

public class NetscapeDraftSpecFactory
    implements CookieSpecFactory, CookieSpecProvider
{

    private final String datepatterns[];

    public NetscapeDraftSpecFactory()
    {
        this(null);
    }

    public NetscapeDraftSpecFactory(String as[])
    {
        datepatterns = as;
    }

    public CookieSpec create(HttpContext httpcontext)
    {
        return new NetscapeDraftSpec(datepatterns);
    }

    public CookieSpec newInstance(HttpParams httpparams)
    {
        if (httpparams != null)
        {
            Object obj = null;
            Collection collection = (Collection)httpparams.getParameter("http.protocol.cookie-datepatterns");
            httpparams = obj;
            if (collection != null)
            {
                httpparams = (String[])collection.toArray(new String[collection.size()]);
            }
            return new NetscapeDraftSpec(httpparams);
        } else
        {
            return new NetscapeDraftSpec();
        }
    }
}
