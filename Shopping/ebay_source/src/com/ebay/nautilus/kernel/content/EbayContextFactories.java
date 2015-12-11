// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.kernel.content:
//            EbayContextFactory, EbayContext

public final class EbayContextFactories
{

    private final Map map = new HashMap();

    public EbayContextFactories()
    {
    }

    public final Object get(Class class1, EbayContext ebaycontext)
    {
        class1 = getFactory(class1);
        if (class1 == null)
        {
            return null;
        } else
        {
            return class1.get(ebaycontext);
        }
    }

    public final EbayContextFactory getFactory(Class class1)
    {
        return (EbayContextFactory)map.get(class1);
    }

    public final Set keySet()
    {
        return map.keySet();
    }

    public final EbayContextFactories put(Class class1, EbayContextFactory ebaycontextfactory)
    {
        map.put(class1, ebaycontextfactory);
        return this;
    }
}
