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
//            RFC2109Spec

public class RFC2109SpecFactory
    implements CookieSpecFactory, CookieSpecProvider
{

    private final String datepatterns[];
    private final boolean oneHeader;

    public RFC2109SpecFactory()
    {
        this(null, false);
    }

    public RFC2109SpecFactory(String as[], boolean flag)
    {
        datepatterns = as;
        oneHeader = flag;
    }

    public CookieSpec create(HttpContext httpcontext)
    {
        return new RFC2109Spec(datepatterns, oneHeader);
    }

    public CookieSpec newInstance(HttpParams httpparams)
    {
        if (httpparams != null)
        {
            String as[] = null;
            Collection collection = (Collection)httpparams.getParameter("http.protocol.cookie-datepatterns");
            if (collection != null)
            {
                as = (String[])collection.toArray(new String[collection.size()]);
            }
            return new RFC2109Spec(as, httpparams.getBooleanParameter("http.protocol.single-cookie-header", false));
        } else
        {
            return new RFC2109Spec();
        }
    }
}
