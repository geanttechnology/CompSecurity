// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

static final class a extends com.ebay.nautilus.kernel.util.
{
    static final class Value extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private com.ebay.common.model.search.EbayAspectHistogram.AspectValue v;

        Value add(ArrayList arraylist, Attributes attributes)
        {
            com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue = new com.ebay.common.model.search.EbayAspectHistogram.AspectValue();
            v = aspectvalue;
            arraylist.add(aspectvalue);
            v.value = attributes.getValue("valueName");
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("count".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final Value this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        v.count = i;
                    }

            
            {
                this$0 = Value.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        Value()
        {
            v = null;
        }
    }


    private com.ebay.common.model.search.t.a a;
    private final Value value = new Value();

    Value add(ArrayList arraylist, Attributes attributes)
    {
        com.ebay.common.model.search.t t = new com.ebay.common.model.search.t();
        a = t;
        arraylist.add(t);
        a.a = attributes.getValue("name");
        return this;
    }

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("valueHistogram".equals(s1))
        {
            return value.add(a, attributes);
        } else
        {
            return super.a(s, s1, s2, attributes);
        }
    }

    Value.v()
    {
        a = null;
    }
}
