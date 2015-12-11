// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Instantiator, Creator, PersistenceException, ParameterMap, 
//            Parameter, Criteria

class ClassInstantiator
    implements Instantiator
{

    private final List creators;
    private final Creator primary;
    private final ParameterMap registry;
    private final Class type;

    public ClassInstantiator(List list, Creator creator, ParameterMap parametermap, Class class1)
    {
        creators = list;
        registry = parametermap;
        primary = creator;
        type = class1;
    }

    private Creator getCreator(Criteria criteria)
        throws Exception
    {
        Creator creator = primary;
        double d = 0.0D;
        Iterator iterator = creators.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Creator creator1 = (Creator)iterator.next();
            double d1 = creator1.getScore(criteria);
            if (d1 > d)
            {
                creator = creator1;
                d = d1;
            }
        } while (true);
        return creator;
    }

    public List getCreators()
    {
        return new ArrayList(creators);
    }

    public Object getInstance()
        throws Exception
    {
        return primary.getInstance();
    }

    public Object getInstance(Criteria criteria)
        throws Exception
    {
        Creator creator = getCreator(criteria);
        if (creator == null)
        {
            throw new PersistenceException("Constructor not matched for %s", new Object[] {
                type
            });
        } else
        {
            return creator.getInstance(criteria);
        }
    }

    public Parameter getParameter(String s)
    {
        return (Parameter)registry.get(s);
    }

    public List getParameters()
    {
        return registry.getAll();
    }

    public boolean isDefault()
    {
        if (creators.size() <= 1)
        {
            return primary != null;
        } else
        {
            return false;
        }
    }

    public String toString()
    {
        return String.format("creator for %s", new Object[] {
            type
        });
    }
}
