// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthSchemeFactory;
import cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;

// Referenced classes of package cz.msebera.android.httpclient.impl.auth:
//            NTLMScheme

public class NTLMSchemeFactory
    implements AuthSchemeFactory, AuthSchemeProvider
{

    public NTLMSchemeFactory()
    {
    }

    public AuthScheme create(HttpContext httpcontext)
    {
        return new NTLMScheme();
    }

    public AuthScheme newInstance(HttpParams httpparams)
    {
        return new NTLMScheme();
    }
}
