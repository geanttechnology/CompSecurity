// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsUtil, DcsException, DcsState

static interface 
{

    public abstract Object eval(DcsState dcsstate, Object obj)
        throws DcsException;

    public abstract Object get(Object obj)
        throws Exception;

    public abstract Object testEval(DcsState dcsstate, Object obj)
        throws Exception;

    public abstract Object tryGet(Object obj);
}
