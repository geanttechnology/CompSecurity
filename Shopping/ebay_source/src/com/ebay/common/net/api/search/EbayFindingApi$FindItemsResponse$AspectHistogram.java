// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayAspectHistogram;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            EbayFindingApi

static final class data extends com.ebay.nautilus.kernel.util.
{
    static final class Aspect extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private com.ebay.common.model.search.EbayAspectHistogram.Aspect a;
        private final Value value = new Value();

        Aspect add(ArrayList arraylist, Attributes attributes)
        {
            com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1 = new com.ebay.common.model.search.EbayAspectHistogram.Aspect();
            a = aspect1;
            arraylist.add(aspect1);
            a.name = attributes.getValue("name");
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("valueHistogram".equals(s1))
            {
                return value.add(a, attributes);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        Aspect()
        {
            a = null;
        }
    }

    static final class Aspect.Value extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private com.ebay.common.model.search.EbayAspectHistogram.AspectValue v;

        Aspect.Value add(ArrayList arraylist, Attributes attributes)
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

                    final Aspect.Value this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        v.count = i;
                    }

            
            {
                this$0 = Aspect.Value.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        Aspect.Value()
        {
            v = null;
        }
    }


    private final Aspect aspect = new Aspect();
    private final EbayAspectHistogram data;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("aspect".equals(s1))
        {
            return aspect.add(data, attributes);
        }
        if ("domainName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final EbayFindingApi.FindItemsResponse.AspectHistogram this$0;

                public void text(String s3)
                    throws SAXException
                {
                    data.domainName = s3;
                }

            
            {
                this$0 = EbayFindingApi.FindItemsResponse.AspectHistogram.this;
                super();
            }
            };
        }
        if ("domainDisplayName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final EbayFindingApi.FindItemsResponse.AspectHistogram this$0;

                public void text(String s3)
                    throws SAXException
                {
                    data.domainDisplayName = s3;
                }

            
            {
                this$0 = EbayFindingApi.FindItemsResponse.AspectHistogram.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }


    public _cls2.this._cls0(EbayAspectHistogram ebayaspecthistogram)
    {
        data = ebayaspecthistogram;
    }
}
