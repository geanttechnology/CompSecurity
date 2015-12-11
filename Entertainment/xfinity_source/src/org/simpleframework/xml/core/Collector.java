// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package org.simpleframework.xml.core:
//            Criteria, Variable, Contact, Label

class Collector
    implements Criteria
{
    private static class Registry extends LinkedHashMap
    {

        public Iterator iterator()
        {
            return keySet().iterator();
        }

        private Registry()
        {
        }

    }


    private final Registry alias = new Registry();
    private final Registry registry = new Registry();

    public Collector()
    {
    }

    public void commit(Object obj)
        throws Exception
    {
        Variable variable;
        for (Iterator iterator1 = registry.values().iterator(); iterator1.hasNext(); variable.getContact().set(obj, variable.getValue()))
        {
            variable = (Variable)iterator1.next();
        }

    }

    public Variable get(Object obj)
    {
        return (Variable)registry.get(obj);
    }

    public Variable get(Label label)
        throws Exception
    {
        if (label != null)
        {
            label = ((Label) (label.getKey()));
            return (Variable)registry.get(label);
        } else
        {
            return null;
        }
    }

    public Iterator iterator()
    {
        return registry.iterator();
    }

    public Variable remove(Object obj)
        throws Exception
    {
        return (Variable)registry.remove(obj);
    }

    public Variable resolve(String s)
    {
        return (Variable)alias.get(s);
    }

    public void set(Label label, Object obj)
        throws Exception
    {
        obj = new Variable(label, obj);
        if (label != null)
        {
            String as[] = label.getPaths();
            label = ((Label) (label.getKey()));
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                alias.put(s, obj);
            }

            registry.put(label, obj);
        }
    }
}
