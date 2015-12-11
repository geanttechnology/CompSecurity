// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsUtil, DcsException, DcsState

static final class on
    implements tor
{

    private Long eval(DcsState dcsstate, Object obj, boolean flag)
        throws DcsException
    {
        if (!(obj instanceof tor)) goto _L2; else goto _L1
_L1:
        Object obj1 = ((tor)obj).get(dcsstate);
_L4:
        if (obj1 instanceof ion)
        {
            return Long.valueOf(((ion)obj1).eval(dcsstate));
        }
        break; /* Loop/switch isn't completed */
_L2:
        obj1 = obj;
        if (obj instanceof ion.eval)
        {
            obj1 = ((ion.eval)obj).et(dcsstate);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (obj1 instanceof on)
        {
            return Long.valueOf(((on)obj1).eval(dcsstate));
        }
        if (flag)
        {
            return get(obj1);
        } else
        {
            return tryGet(obj1);
        }
    }

    public Long eval(DcsState dcsstate, Object obj)
        throws DcsException
    {
        return eval(dcsstate, obj, false);
    }

    public volatile Object eval(DcsState dcsstate, Object obj)
        throws DcsException
    {
        return eval(dcsstate, obj);
    }

    public Long get(Object obj)
    {
        if (obj instanceof Integer)
        {
            return Long.valueOf(((Integer)obj).longValue());
        } else
        {
            return (Long)obj;
        }
    }

    public volatile Object get(Object obj)
        throws Exception
    {
        return get(obj);
    }

    public Long testEval(DcsState dcsstate, Object obj)
        throws Exception
    {
        return eval(dcsstate, obj, true);
    }

    public volatile Object testEval(DcsState dcsstate, Object obj)
        throws Exception
    {
        return testEval(dcsstate, obj);
    }

    public Long tryGet(Object obj)
    {
        if ((obj instanceof Long) || (obj instanceof Integer))
        {
            return get(obj);
        } else
        {
            return null;
        }
    }

    public volatile Object tryGet(Object obj)
    {
        return tryGet(obj);
    }

    on()
    {
    }
}
