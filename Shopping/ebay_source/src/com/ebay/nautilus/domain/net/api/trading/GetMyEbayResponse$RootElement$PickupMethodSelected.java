// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.OrderPickupStatus;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

static final class tx extends com.ebay.nautilus.kernel.util.odSelected
{

    protected final com.ebay.nautilus.domain.data.odSelected tx;

    public com.ebay.nautilus.kernel.util.odSelected get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("PickupMethod".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.PickupMethodSelected this$0;

                public void text(String s3)
                    throws SAXException
                {
                    tx.pickupMethod = s3;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.PickupMethodSelected.this;
                super();
            }
            };
        }
        if ("PickupStoreID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.PickupMethodSelected this$0;

                public void text(String s3)
                    throws SAXException
                {
                    tx.pickupStoreId = s3;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.PickupMethodSelected.this;
                super();
            }
            };
        }
        if ("PickupStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.PickupMethodSelected this$0;

                public void text(String s3)
                    throws SAXException
                {
                    tx.pickupStatus = OrderPickupStatus.getByName(s3);
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.PickupMethodSelected.this;
                super();
            }
            };
        } else
        {
            return super.odSelected(s, s1, s2, attributes);
        }
    }

    public _cls3.this._cls0(com.ebay.nautilus.domain.data.odSelected odselected)
    {
        tx = odselected;
    }
}
