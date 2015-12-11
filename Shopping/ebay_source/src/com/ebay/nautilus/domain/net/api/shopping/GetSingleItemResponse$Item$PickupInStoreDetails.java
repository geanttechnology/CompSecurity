// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class <init> extends com.ebay.nautilus.kernel.util.toreDetails
{

    final _cls2 this$1;

    public com.ebay.nautilus.kernel.util.toreDetails get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("EligibleForPickupInStore".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.PickupInStoreDetails this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.eligibleForPickupInStore = "true".equals(s3);
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.PickupInStoreDetails.this;
                super();
            }
                };
            }
            if ("AvailableForPickupInStore".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.PickupInStoreDetails this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.availableForPickupInStore = "true".equals(s3);
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.PickupInStoreDetails.this;
                super();
            }
                };
            }
        }
        return super.toreDetails(s, s1, s2, attributes);
    }

    private _cls2.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
