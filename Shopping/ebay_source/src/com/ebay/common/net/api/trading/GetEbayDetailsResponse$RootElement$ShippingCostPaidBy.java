// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayDetail;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetEbayDetailsResponse

private final class option extends com.ebay.nautilus.kernel.util.y
{

    private final com.ebay.common.model.ostPaidBy option = new com.ebay.common.model.ostPaidBy();
    final option this$1;

    public com.ebay.nautilus.kernel.util.y get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Description".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetEbayDetailsResponse.RootElement.ShippingCostPaidBy this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        option.description = s3;
                    }

            
            {
                this$2 = GetEbayDetailsResponse.RootElement.ShippingCostPaidBy.this;
                super();
            }
                };
            }
            if ("ShippingCostPaidByOption".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetEbayDetailsResponse.RootElement.ShippingCostPaidBy this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        option.token = s3;
                    }

            
            {
                this$2 = GetEbayDetailsResponse.RootElement.ShippingCostPaidBy.this;
                super();
            }
                };
            }
        }
        return super.y(s, s1, s2, attributes);
    }


    public _cls2.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
        detail.returnPolicyDetails._fld1.add(option);
    }
}
