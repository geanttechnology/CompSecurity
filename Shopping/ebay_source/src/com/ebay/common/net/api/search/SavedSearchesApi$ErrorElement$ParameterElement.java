// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

private static final class parameter extends com.ebay.nautilus.kernel.util.
{

    private final com.ebay.nautilus.domain.net.t.parameter parameter;

    public void text(String s)
        throws SAXException
    {
        parameter.parameter = s;
    }

    public (com.ebay.nautilus.domain.net.t t, Attributes attributes)
    {
        parameter = t;
        int j = attributes.getLength();
        for (int i = 0; i < j; i++)
        {
            if (attributes.getLocalName(i).equals("name"))
            {
                t.parameter = attributes.getValue(i);
            }
        }

    }
}
