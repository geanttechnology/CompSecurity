// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.crypto.params:
//            GOST3410KeyParameters, GOST3410Parameters

public class GOST3410PrivateKeyParameters extends GOST3410KeyParameters
{

    private BigInteger b;

    public GOST3410PrivateKeyParameters(BigInteger biginteger, GOST3410Parameters gost3410parameters)
    {
        super(true, gost3410parameters);
        b = biginteger;
    }

    public final BigInteger c()
    {
        return b;
    }
}
