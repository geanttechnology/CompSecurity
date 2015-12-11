// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayDetail;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetEbayDetailsResponse

private final class returnPolicy extends com.ebay.nautilus.kernel.util.e
{

    private final com.ebay.common.model.tailsNode.this._cls1 returnPolicy = new com.ebay.common.model.tailsNode.this._cls1();
    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util.e get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Refund".equals(s1))
            {
                return new returnPolicy(this._cls1.this);
            }
            if ("ReturnsAccepted".equals(s1))
            {
                return new this._cls1(this._cls1.this);
            }
            if ("ReturnsWithin".equals(s1))
            {
                return new this._cls1(this._cls1.this);
            }
            if ("ShippingCostPaidBy".equals(s1))
            {
                return new >(this._cls1.this);
            }
        }
        return super._mth1(s, s1, s2, attributes);
    }

    public ()
    {
        this$1 = this._cls1.this;
        super();
        detail.returnPolicyDetails = returnPolicy;
    }
}
