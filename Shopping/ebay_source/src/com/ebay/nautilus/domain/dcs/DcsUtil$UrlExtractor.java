// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsUtil, DcsException, DcsState

static final class or
    implements ctor
{

    public volatile Object eval(DcsState dcsstate, Object obj)
        throws DcsException
    {
        return eval(dcsstate, obj);
    }

    public URL eval(DcsState dcsstate, Object obj)
        throws DcsException
    {
        Object obj1 = obj;
        if (obj instanceof ession)
        {
            obj1 = DcsUtil.STRING_EXTRACTOR.eval(dcsstate, obj);
        }
        return tryGet(obj1);
    }

    public volatile Object get(Object obj)
        throws Exception
    {
        return get(obj);
    }

    public URL get(Object obj)
        throws Exception
    {
        if (obj instanceof String)
        {
            return new URL((String)obj);
        } else
        {
            return (URL)obj;
        }
    }

    public volatile Object testEval(DcsState dcsstate, Object obj)
        throws Exception
    {
        return testEval(dcsstate, obj);
    }

    public URL testEval(DcsState dcsstate, Object obj)
        throws Exception
    {
        Object obj1 = obj;
        if (obj instanceof ession)
        {
            obj1 = DcsUtil.STRING_EXTRACTOR.testEval(dcsstate, obj);
        }
        return get(obj1);
    }

    public volatile Object tryGet(Object obj)
    {
        return tryGet(obj);
    }

    public URL tryGet(Object obj)
    {
        if (obj instanceof URL)
        {
            return (URL)obj;
        }
        if (!(obj instanceof String))
        {
            break MISSING_BLOCK_LABEL_38;
        }
        obj = new URL((String)obj);
        return ((URL) (obj));
        obj;
        ((MalformedURLException) (obj)).printStackTrace();
        return null;
    }

    or()
    {
    }
}
