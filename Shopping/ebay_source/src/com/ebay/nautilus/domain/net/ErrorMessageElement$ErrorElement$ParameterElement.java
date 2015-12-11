// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            ErrorMessageElement

private static final class parameter extends com.ebay.nautilus.kernel.util.arameter
{

    private final parameter parameter;

    public void text(String s)
        throws SAXException
    {
        parameter.parameter = s;
    }

    public ( , Attributes attributes)
    {
        parameter = ;
        int j = attributes.getLength();
        for (int i = 0; i < j; i++)
        {
            if (attributes.getLocalName(i).equals("name"))
            {
                .parameter = attributes.getValue(i);
            }
        }

    }
}
