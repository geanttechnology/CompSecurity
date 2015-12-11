// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.params;

import cz.msebera.android.httpclient.util.Args;

// Referenced classes of package cz.msebera.android.httpclient.params:
//            HttpParams

public abstract class HttpAbstractParamBean
{

    protected final HttpParams params;

    public HttpAbstractParamBean(HttpParams httpparams)
    {
        params = (HttpParams)Args.notNull(httpparams, "HTTP parameters");
    }
}
