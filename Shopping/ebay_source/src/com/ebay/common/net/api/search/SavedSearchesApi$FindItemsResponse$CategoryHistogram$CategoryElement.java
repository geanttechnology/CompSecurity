// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

private static class <init> extends com.ebay.nautilus.kernel.util.
{
    private final class FieldElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private int field;
        final SavedSearchesApi.FindItemsResponse.CategoryHistogram.CategoryElement this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element getCount()
        {
            field = 2;
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element getId()
        {
            field = 0;
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element getName()
        {
            field = 1;
            return this;
        }

        public void text(String s)
            throws SAXException
        {
            switch (field)
            {
            default:
                return;

            case 0: // '\0'
                category.id = Long.parseLong(s);
                return;

            case 1: // '\001'
                category.name = s;
                return;

            case 2: // '\002'
                category.count = Integer.parseInt(s);
                break;
            }
        }

        private FieldElement()
        {
            this$0 = SavedSearchesApi.FindItemsResponse.CategoryHistogram.CategoryElement.this;
            super();
            field = 0;
        }

        FieldElement(SavedSearchesApi._cls1 _pcls1)
        {
            this();
        }
    }


    protected com.ebay.common.model.search.t.FieldElement.getCount category;
    private final FieldElement field;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
        {
            if ("categoryId".equals(s1))
            {
                return field.getId();
            }
            if ("categoryName".equals(s1))
            {
                return field.getName();
            }
            if ("count".equals(s1))
            {
                return field.getCount();
            }
        }
        return super.getCount(s, s1, s2, attributes);
    }

    private FieldElement()
    {
        category = null;
        field = new FieldElement(null);
    }

    FieldElement(FieldElement fieldelement)
    {
        this();
    }
}
