// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthSchemeFactory;
import cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.nio.charset.Charset;

// Referenced classes of package cz.msebera.android.httpclient.impl.auth:
//            DigestScheme

public class DigestSchemeFactory
    implements AuthSchemeFactory, AuthSchemeProvider
{

    private final Charset charset;

    public DigestSchemeFactory()
    {
        this(null);
    }

    public DigestSchemeFactory(Charset charset1)
    {
        charset = charset1;
    }

    public AuthScheme create(HttpContext httpcontext)
    {
        return new DigestScheme(charset);
    }

    public AuthScheme newInstance(HttpParams httpparams)
    {
        return new DigestScheme();
    }
}
