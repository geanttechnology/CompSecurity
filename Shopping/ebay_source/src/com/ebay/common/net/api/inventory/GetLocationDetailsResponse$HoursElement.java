// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.inventory:
//            GetLocationDetailsResponse

public static final class hours extends com.ebay.nautilus.kernel.util.ent
{

    private final com.ebay.common.model.inventory.<init> hours;

    public com.ebay.nautilus.kernel.util.ent get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Day".equals(s1))
        {
            if (hours.hours == null)
            {
                hours.hours = new ArrayList();
            }
            s = new com.ebay.common.model.inventory.t.hours();
            hours.hours.add(s);
            return new nit>(s);
        } else
        {
            return super.t(s, s1, s2, attributes);
        }
    }

    public (com.ebay.common.model.inventory.t t)
    {
        hours = t;
    }
}
