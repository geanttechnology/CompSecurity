// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            Expression, DcsState

static final class value extends ion
    implements sion
{

    private final double value;

    public double eval(DcsState dcsstate)
    {
        return value;
    }

    public sion(double d)
    {
        value = d;
    }
}
