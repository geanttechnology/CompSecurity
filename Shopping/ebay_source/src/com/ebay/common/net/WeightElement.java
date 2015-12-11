// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;

import com.ebay.nautilus.domain.data.ItemWeight;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class WeightElement extends com.ebay.nautilus.kernel.util.SaxHandler.FloatElement
{

    private final ItemWeight weight;

    public WeightElement(ItemWeight itemweight, Attributes attributes)
    {
        if (itemweight == null)
        {
            throw new NullPointerException("weight");
        }
        weight = itemweight;
        int j = attributes.getLength();
        for (int i = 0; i < j; i++)
        {
            if ("unit".equals(attributes.getLocalName(i)))
            {
                itemweight.units = attributes.getValue(i);
            }
        }

    }

    public void setValue(float f)
        throws SAXException
    {
        weight.value = f;
    }
}
