// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.registry:
//            TokenSIResponse

public class TokenServiceResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private TokenSIResponse si;

    public TokenServiceResponse()
    {
    }

    public TokenSIResponse getSi()
    {
        return si;
    }

    public void setSi(TokenSIResponse tokensiresponse)
    {
        si = tokensiresponse;
    }
}
