// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package org.simpleframework.xml.core:
//            ModelList, PathException, Model

class ModelMap extends LinkedHashMap
    implements Iterable
{

    private final Class type;

    public ModelMap(Class class1)
    {
        type = class1;
    }

    public ModelMap getModels()
        throws Exception
    {
        ModelMap modelmap = new ModelMap(type);
        ModelList modellist;
        String s;
        for (Iterator iterator1 = keySet().iterator(); iterator1.hasNext(); modelmap.put(s, modellist))
        {
            s = (String)iterator1.next();
            ModelList modellist1 = (ModelList)get(s);
            modellist = modellist1;
            if (modellist1 != null)
            {
                modellist = modellist1.build();
            }
            if (modelmap.containsKey(s))
            {
                throw new PathException("Path with name '%s' is a duplicate in %s ", new Object[] {
                    s, type
                });
            }
        }

        return modelmap;
    }

    public Iterator iterator()
    {
        return values().iterator();
    }

    public Model lookup(String s, int i)
    {
        s = (ModelList)get(s);
        if (s != null)
        {
            return s.lookup(i);
        } else
        {
            return null;
        }
    }

    public void register(String s, Model model)
    {
        ModelList modellist1 = (ModelList)get(s);
        ModelList modellist = modellist1;
        if (modellist1 == null)
        {
            modellist = new ModelList();
            put(s, modellist);
        }
        modellist.register(model);
    }
}
