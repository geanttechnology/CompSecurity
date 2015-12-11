// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsUtil, DcsException, DcsState

static final class ion
    implements 
{

    private Boolean eval(DcsState dcsstate, Object obj, boolean flag)
        throws DcsException
    {
        Object obj1 = obj;
        if (obj instanceof )
        {
            obj1 = (()obj).get(dcsstate);
        }
        if (obj1 instanceof ion)
        {
            return Boolean.valueOf(((ion)obj1).eval(dcsstate));
        }
        if (flag)
        {
            return get(obj1);
        } else
        {
            return tryGet(obj1);
        }
    }

    public Boolean eval(DcsState dcsstate, Object obj)
        throws DcsException
    {
        return eval(dcsstate, obj, false);
    }

    public volatile Object eval(DcsState dcsstate, Object obj)
        throws DcsException
    {
        return eval(dcsstate, obj);
    }

    public Boolean get(Object obj)
    {
        return (Boolean)obj;
    }

    public volatile Object get(Object obj)
        throws Exception
    {
        return get(obj);
    }

    public Boolean testEval(DcsState dcsstate, Object obj)
        throws Exception
    {
        return eval(dcsstate, obj, true);
    }

    public volatile Object testEval(DcsState dcsstate, Object obj)
        throws Exception
    {
        return testEval(dcsstate, obj);
    }

    public Boolean tryGet(Object obj)
    {
        if (obj instanceof Boolean)
        {
            return (Boolean)obj;
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
