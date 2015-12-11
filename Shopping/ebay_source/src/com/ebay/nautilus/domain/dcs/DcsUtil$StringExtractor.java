// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsUtil, DcsException, DcsState

static final class ion
    implements r
{

    private String eval(DcsState dcsstate, Object obj, boolean flag)
        throws DcsException
    {
        Object obj1 = obj;
        if (obj instanceof r)
        {
            obj1 = ((r)obj).get(dcsstate);
        }
        if (obj1 instanceof ion)
        {
            return ((ion)obj1).eval(dcsstate);
        }
        if (flag)
        {
            return get(obj1);
        } else
        {
            return tryGet(obj1);
        }
    }

    public volatile Object eval(DcsState dcsstate, Object obj)
        throws DcsException
    {
        return eval(dcsstate, obj);
    }

    public String eval(DcsState dcsstate, Object obj)
        throws DcsException
    {
        return eval(dcsstate, obj, false);
    }

    public volatile Object get(Object obj)
        throws Exception
    {
        return get(obj);
    }

    public String get(Object obj)
    {
        return (String)obj;
    }

    public volatile Object testEval(DcsState dcsstate, Object obj)
        throws Exception
    {
        return testEval(dcsstate, obj);
    }

    public String testEval(DcsState dcsstate, Object obj)
        throws Exception
    {
        return eval(dcsstate, obj, true);
    }

    public volatile Object tryGet(Object obj)
    {
        return tryGet(obj);
    }

    public String tryGet(Object obj)
    {
        if (obj instanceof String)
        {
            return get(obj);
        } else
        {
            return null;
        }
    }

    ion()
    {
    }
}
