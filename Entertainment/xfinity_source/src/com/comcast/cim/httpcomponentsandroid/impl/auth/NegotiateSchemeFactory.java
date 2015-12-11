// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.auth;

import com.comcast.cim.httpcomponentsandroid.auth.AuthScheme;
import com.comcast.cim.httpcomponentsandroid.auth.AuthSchemeFactory;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.auth:
//            NegotiateScheme, SpnegoTokenGenerator

public class NegotiateSchemeFactory
    implements AuthSchemeFactory
{

    private final SpnegoTokenGenerator spengoGenerator;
    private final boolean stripPort;

    public NegotiateSchemeFactory()
    {
        this(null, false);
    }

    public NegotiateSchemeFactory(SpnegoTokenGenerator spnegotokengenerator, boolean flag)
    {
        spengoGenerator = spnegotokengenerator;
        stripPort = flag;
    }

    public SpnegoTokenGenerator getSpengoGenerator()
    {
        return spengoGenerator;
    }

    public boolean isStripPort()
    {
        return stripPort;
    }

    public AuthScheme newInstance(HttpParams httpparams)
    {
        return new NegotiateScheme(spengoGenerator, stripPort);
    }
}
