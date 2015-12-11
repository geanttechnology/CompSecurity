// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            Expression, DcsException, Operator, DcsState

static final class ion extends ion
    implements ion
{

    public boolean eval(DcsState dcsstate)
        throws DcsException
    {
        boolean flag = true;
        com.ebay.nautilus.domain.dcs.Operator[op.ordinal()];
        JVM INSTR tableswitch 1 8: default 60
    //                   1 98
    //                   2 137
    //                   3 60
    //                   4 60
    //                   5 169
    //                   6 201
    //                   7 233
    //                   8 265;
           goto _L1 _L2 _L3 _L1 _L1 _L4 _L5 _L6 _L7
_L1:
        throw new DcsException((new StringBuilder()).append("Operation '").append(op.symbol).append("' not valid for numeric comparison!").toString());
_L2:
        if (((on)left).eval(dcsstate) == ((on)right).eval(dcsstate))
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L9:
        return flag;
_L3:
        if (((on)left).eval(dcsstate) == ((on)right).eval(dcsstate))
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (((on)left).eval(dcsstate) >= ((on)right).eval(dcsstate))
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (((on)left).eval(dcsstate) > ((on)right).eval(dcsstate))
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (((on)left).eval(dcsstate) <= ((on)right).eval(dcsstate))
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (((on)left).eval(dcsstate) < ((on)right).eval(dcsstate))
        {
            return false;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public on(on on, on on1, Operator operator)
    {
        super(on, on1, operator);
    }
}
