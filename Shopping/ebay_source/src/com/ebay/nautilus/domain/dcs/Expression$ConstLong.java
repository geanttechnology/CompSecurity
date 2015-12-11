// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            Expression, DcsState

static final class value extends ssion
    implements sion
{

    private final long value;

    public long eval(DcsState dcsstate)
    {
        return value;
    }

    public sion(long l)
    {
        value = l;
    }
}
