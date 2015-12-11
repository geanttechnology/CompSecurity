// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import com.ebay.nautilus.domain.data.ItemCurrency;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class CurrencyElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
{

    private final ItemCurrency currency;

    public CurrencyElement(ItemCurrency itemcurrency, String s, Attributes attributes)
    {
        if (itemcurrency == null)
        {
            throw new NullPointerException("currency");
        }
        if (s == null)
        {
            throw new NullPointerException("xmlTag");
        }
        currency = itemcurrency;
        int j = attributes.getLength();
        for (int i = 0; i < j; i++)
        {
            if (s.equals(attributes.getLocalName(i)))
            {
                itemcurrency.code = attributes.getValue(i);
            }
        }

    }

    public void text(String s)
        throws SAXException
    {
        currency.value = s;
    }
}
