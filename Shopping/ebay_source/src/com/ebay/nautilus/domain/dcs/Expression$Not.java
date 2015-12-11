// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            Expression, DcsException, DcsState

static final class dator extends perExpression
    implements eanExpression
{

    public boolean eval(DcsState dcsstate)
        throws DcsException
    {
        return !((eanExpression)value).eval(dcsstate);
    }

    public dator(eanExpression eanexpression)
    {
        super(eanexpression);
    }
}
