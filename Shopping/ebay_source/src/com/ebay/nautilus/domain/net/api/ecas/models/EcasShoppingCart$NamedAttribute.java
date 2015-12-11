// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas.models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas.models:
//            EcasShoppingCart

public static class 
{

    public String name;
    public String value;

    public static final  getAttribute(List list, String s)
    {
        if (list == null)
        {
            return null;
        }
        for (list = list.iterator(); list.hasNext();)
        {
              = ()list.next();
            if ( != null && .name.equalsIgnoreCase(s))
            {
                return ;
            }
        }

        return null;
    }

    public static final Map listToMap(List list)
    {
        if (list == null || list.isEmpty())
        {
            return Collections.emptyMap();
        }
        HashMap hashmap = new HashMap();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            name name1 = (name)list.next();
            if (name1 != null)
            {
                hashmap.put(name1.name, name1.value);
            }
        } while (true);
        return Collections.unmodifiableMap(hashmap);
    }

    public ()
    {
    }
}
