// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsUtil, DcsException, DcsState

static final class ion
    implements ctor
{

    private Integer eval(DcsState dcsstate, Object obj, boolean flag)
        throws DcsException
    {
        Object obj1 = obj;
        if (obj instanceof ctor)
        {
            obj1 = ((ctor)obj).get(dcsstate);
        }
        if (obj1 instanceof ion)
        {
            return Integer.valueOf(((ion)obj1).eval(dcsstate));
        }
        if (flag)
        {
            return get(obj1);
        } else
        {
            return tryGet(obj1);
        }
    }

    public Integer eval(DcsState dcsstate, Object obj)
        throws DcsException
    {
        return eval(dcsstate, obj, false);
    }

    public volatile Object eval(DcsState dcsstate, Object obj)
        throws DcsException
    {
        return eval(dcsstate, obj);
    }

    public Integer get(Object obj)
    {
        return (Integer)obj;
    }

    public volatile Object get(Object obj)
        throws Exception
    {
        return get(obj);
    }

    public Integer testEval(DcsState dcsstate, Object obj)
        throws Exception
    {
        return eval(dcsstate, obj, true);
    }

    public volatile Object testEval(DcsState dcsstate, Object obj)
        throws Exception
    {
        return testEval(dcsstate, obj);
    }

    public Integer tryGet(Object obj)
    {
        if (obj instanceof Integer)
        {
            return (Integer)obj;
        } else
        {
            return null;
        }
    }

    public volatile Object tryGet(Object obj)
    {
        return tryGet(obj);
    }

    ion()
    {
    }
}
