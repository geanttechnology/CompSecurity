// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            Expression, DcsException, Operator, DcsUtil

static abstract class op
    implements op
{

    protected final  left;
    protected final Operator op;
    protected final  right;

    public void validate(DcsUtil dcsutil)
        throws DcsException
    {
        left.(dcsutil);
        right.(dcsutil);
    }

    public ( ,  1, Operator operator)
    {
        left = ;
        right = 1;
        op = operator;
    }
}
