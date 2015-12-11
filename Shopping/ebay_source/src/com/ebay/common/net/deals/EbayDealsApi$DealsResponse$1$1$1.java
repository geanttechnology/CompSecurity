// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.deals;

import com.ebay.common.model.EbayDeals;
import com.ebay.nautilus.domain.net.AckElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.deals:
//            EbayDealsApi

class kuElement extends com.ebay.nautilus.kernel.util.ement
{

    com.ebay.common.model._cls1._cls1.subSectionElement subSection;
    com.ebay.nautilus.kernel.util.ectionElement subSectionElement;
    final subSectionElement this$2;

    public com.ebay.nautilus.kernel.util.ement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Items".equals(s1))
        {
            subSection = new com.ebay.common.model._cls1._cls1.subSection();
            ction.section(subSection);
            int j = attributes.getLength();
            for (int i = 0; i < j; i++)
            {
                if ("SubTitle".equals(attributes.getLocalName(i)))
                {
                    subSection.subSection = attributes.getValue(i);
                }
            }

            return subSectionElement;
        } else
        {
            return super.ectionElement(s, s1, s2, attributes);
        }
    }

    nit>()
    {
        this$2 = this._cls2.this;
        super();
        subSection = null;
        subSectionElement = new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

            EbayDealsApi.DealsResponse.ItemElement itemElement;
            EbayDealsApi.DealsResponse.MultiSkuElement multiSkuElement;
            final EbayDealsApi.DealsResponse._cls1._cls1._cls1 this$3;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("Item".equals(s1))
                {
                    return itemElement.get(subSection, attributes);
                }
                if ("MultiSKU".equals(s1))
                {
                    return multiSkuElement.get(subSection);
                } else
                {
                    return super.get(s, s1, s2, attributes);
                }
            }

            
            {
                this$3 = EbayDealsApi.DealsResponse._cls1._cls1._cls1.this;
                super();
                itemElement = new EbayDealsApi.DealsResponse.ItemElement();
                multiSkuElement = new EbayDealsApi.DealsResponse.MultiSkuElement(itemElement);
            }
        };
    }

    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$1

/* anonymous class */
    class EbayDealsApi.DealsResponse._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.kernel.util.SaxHandler.Element initiativeElement;
        final EbayDealsApi.DealsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(EbayDealsApi.DealsResponse.this);
            }
            if ("Initiative".equals(s1))
            {
                return initiativeElement;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$0 = EbayDealsApi.DealsResponse.this;
                super();
                initiativeElement = new EbayDealsApi.DealsResponse._cls1._cls1();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$1$1

/* anonymous class */
    class EbayDealsApi.DealsResponse._cls1._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.common.model.EbayDeals.Section section;
        com.ebay.nautilus.kernel.util.SaxHandler.Element sectionElement;
        final EbayDealsApi.DealsResponse._cls1 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("InitiativeSection".equals(s1))
            {
                section = new com.ebay.common.model.EbayDeals.Section();
                EbayDealsApi.DealsResponse.access$000(this$0).add(section);
                int j = attributes.getLength();
                int i = 0;
                while (i < j) 
                {
                    if ("SectionID".equals(attributes.getLocalName(i)))
                    {
                        section.id = Integer.parseInt(attributes.getValue(i));
                    } else
                    if ("DisplayTitle".equals(attributes.getLocalName(i)))
                    {
                        section.title = attributes.getValue(i);
                    } else
                    if ("Description".equals(attributes.getLocalName(i)))
                    {
                        section.description = attributes.getValue(i);
                    }
                    i++;
                }
                return sectionElement;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$1 = EbayDealsApi.DealsResponse._cls1.this;
                super();
                section = null;
                sectionElement = new EbayDealsApi.DealsResponse._cls1._cls1._cls1();
            }
    }

}
