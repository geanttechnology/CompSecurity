// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            Expression, DcsException, Operator, DcsState

static final class on extends on
    implements on
{

    public boolean eval(DcsState dcsstate)
        throws DcsException
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = false;
        om.ebay.nautilus.domain.dcs.Operator[op.ordinal()];
        JVM INSTR lookupswitch 4: default 56
    //                   1: 94
    //                   2: 132
    //                   9: 163
    //                   10: 197;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        throw new DcsException((new StringBuilder()).append("Operation '").append(op.symbol).append("' not valid for Boolean comparison!").toString());
_L2:
        if (((on)left).eval(dcsstate) == ((on)right).eval(dcsstate))
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L7:
        return flag;
_L3:
        if (((on)left).eval(dcsstate) != ((on)right).eval(dcsstate)) goto _L7; else goto _L6
_L6:
        return false;
_L4:
        if (((on)left).eval(dcsstate) && ((on)right).eval(dcsstate)) goto _L7; else goto _L8
_L8:
        return false;
_L5:
        if (((on)left).eval(dcsstate)) goto _L10; else goto _L9
_L9:
        flag = flag1;
        if (!((on)right).eval(dcsstate)) goto _L11; else goto _L10
_L10:
        flag = true;
_L11:
        return flag;
    }

    public on(on on, on on1, Operator operator)
    {
        super(on, on1, operator);
    }
}
