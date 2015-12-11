// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            Expression, DcsException, DcsState

public static final class ion extends ion
    implements ion
{

    public boolean eval(DcsState dcsstate)
        throws DcsException
    {
        return ((ion)getExpression(dcsstate)).eval(dcsstate);
    }

    public ion(List list)
    {
        super(list);
    }
}
