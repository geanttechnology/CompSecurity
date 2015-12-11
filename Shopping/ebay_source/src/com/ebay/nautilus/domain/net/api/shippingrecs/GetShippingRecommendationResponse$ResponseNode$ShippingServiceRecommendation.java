// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.ShippingRecommendation;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingRecommendationResponse

private final class <init> extends com.ebay.nautilus.kernel.util.eRecommendation
{

    final _cls1 this$1;

    public com.ebay.nautilus.kernel.util.eRecommendation get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("shippingService".equals(s1))
        {
            return new <init>(this._cls1.this, null);
        }
        if ("zonalCost".equals(s1))
        {
            return new this._cls1(this._cls1.this);
        }
        if ("packageDetail".equals(s1))
        {
            return new this._cls1(this._cls1.this, null);
        }
        if ("requireWeighDimensionValidation".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                final GetShippingRecommendationResponse.ResponseNode.ShippingServiceRecommendation this$2;

                protected void setValue(boolean flag)
                    throws SAXException
                {
                    GetShippingRecommendationResponse.access$900(this$0).requireWeighDimensionValidation = flag;
                }

            
            {
                this$2 = GetShippingRecommendationResponse.ResponseNode.ShippingServiceRecommendation.this;
                super();
            }
            };
        } else
        {
            return super.eRecommendation(s, s1, s2, attributes);
        }
    }

    private _cls1.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
