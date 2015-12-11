// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas.models;

import com.ebay.nautilus.domain.data.NameValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas.models:
//            EcasShoppingCart

public static class Q
{

    protected List innerList;

    public List asList()
    {
        if (innerList != null)
        {
            return innerList;
        } else
        {
            return Collections.emptyList();
        }
    }

    public Map asMap()
    {
        HashMap hashmap = new HashMap();
        if (innerList != null)
        {
            NameValue namevalue;
            for (Iterator iterator = innerList.iterator(); iterator.hasNext(); hashmap.put(namevalue.getName(), namevalue.getValues()))
            {
                namevalue = (NameValue)iterator.next();
            }

        }
        return Collections.unmodifiableMap(hashmap);
    }

    public Q()
    {
    }
}
