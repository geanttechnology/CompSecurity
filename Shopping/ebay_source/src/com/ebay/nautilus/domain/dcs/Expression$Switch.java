// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            Expression, DcsException, DcsState, DcsUtil

public static abstract class entries
    implements or
{
    public static final class Entry
    {

        public final Expression.BooleanExpression condition;
        public final Object value;

        public Entry(Expression.BooleanExpression booleanexpression, Object obj)
        {
            condition = booleanexpression;
            value = obj;
        }
    }


    private final List entries;

    public final or get(DcsState dcsstate)
        throws DcsException
    {
        for (Iterator iterator = entries.iterator(); iterator.hasNext();)
        {
            Entry entry = (Entry)iterator.next();
            if (entry.condition.eval(dcsstate))
            {
                return (or)entry.value;
            }
        }

        return null;
    }

    public final or getExpression(DcsState dcsstate)
        throws DcsException
    {
        dcsstate = get(dcsstate);
        if (dcsstate == null)
        {
            throw new DcsException("Missing value for condition");
        } else
        {
            return dcsstate;
        }
    }

    public void validate(DcsUtil dcsutil)
        throws DcsException
    {
        Entry entry;
        for (Iterator iterator = entries.iterator(); iterator.hasNext(); ((or)entry.value).validate(dcsutil))
        {
            entry = (Entry)iterator.next();
            entry.condition.validate(dcsutil);
        }

    }

    public Entry.value(List list)
    {
        entries = list;
    }
}
