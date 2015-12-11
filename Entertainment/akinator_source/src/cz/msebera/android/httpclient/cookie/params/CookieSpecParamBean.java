// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.cookie.params;

import cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import cz.msebera.android.httpclient.params.HttpParams;
import java.util.Collection;

public class CookieSpecParamBean extends HttpAbstractParamBean
{

    public CookieSpecParamBean(HttpParams httpparams)
    {
        super(httpparams);
    }

    public void setDatePatterns(Collection collection)
    {
        params.setParameter("http.protocol.cookie-datepatterns", collection);
    }

    public void setSingleHeader(boolean flag)
    {
        params.setBooleanParameter("http.protocol.single-cookie-header", flag);
    }
}
