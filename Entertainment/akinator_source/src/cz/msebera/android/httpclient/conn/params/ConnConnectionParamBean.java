// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.params;

import cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import cz.msebera.android.httpclient.params.HttpParams;

public class ConnConnectionParamBean extends HttpAbstractParamBean
{

    public ConnConnectionParamBean(HttpParams httpparams)
    {
        super(httpparams);
    }

    public void setMaxStatusLineGarbage(int i)
    {
        params.setIntParameter("http.connection.max-status-line-garbage", i);
    }
}
