// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private final class parameter extends com.ebay.nautilus.kernel.util.
{

    private final com.ebay.nautilus.domain.net.t.parameter parameter;
    final parameter this$1;

    public void text(String s)
        throws SAXException
    {
        parameter.parameter = s;
    }

    public (com.ebay.nautilus.domain.net.t t, Attributes attributes)
    {
        this$1 = this._cls1.this;
        super();
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
