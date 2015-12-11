// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.auth.params;

import cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import cz.msebera.android.httpclient.params.HttpParams;

// Referenced classes of package cz.msebera.android.httpclient.auth.params:
//            AuthParams

public class AuthParamBean extends HttpAbstractParamBean
{

    public AuthParamBean(HttpParams httpparams)
    {
        super(httpparams);
    }

    public void setCredentialCharset(String s)
    {
        AuthParams.setCredentialCharset(params, s);
    }
}
