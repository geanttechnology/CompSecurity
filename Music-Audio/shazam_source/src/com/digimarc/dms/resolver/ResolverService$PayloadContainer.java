// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;


// Referenced classes of package com.digimarc.dms.resolver:
//            ResolverService, PayoffContainer

private class mState
{

    private PayoffContainer mPayoff;
    private mState mState;
    final ResolverService this$0;

    public PayoffContainer getPayoff()
    {
        return mPayoff;
    }

    public mPayoff getState()
    {
        return mState;
    }

    public void update(mState mstate, PayoffContainer payoffcontainer)
    {
        mPayoff = payoffcontainer;
        mState = mstate;
    }

    public ( )
    {
        this$0 = ResolverService.this;
        super();
        mPayoff = null;
        mState = ;
    }
}
