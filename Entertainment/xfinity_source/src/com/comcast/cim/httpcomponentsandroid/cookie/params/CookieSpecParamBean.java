// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.cookie.params;

import com.comcast.cim.httpcomponentsandroid.params.HttpAbstractParamBean;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import java.util.Collection;

public class CookieSpecParamBean extends HttpAbstractParamBean
{

    public void setDatePatterns(Collection collection)
    {
        params.setParameter("http.protocol.cookie-datepatterns", collection);
    }

    public void setSingleHeader(boolean flag)
    {
        params.setBooleanParameter("http.protocol.single-cookie-header", flag);
    }
}
