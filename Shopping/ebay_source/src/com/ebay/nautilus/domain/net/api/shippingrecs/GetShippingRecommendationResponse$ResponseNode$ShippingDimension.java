// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.ShippingRecommendation;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingRecommendationResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ippingDimension
{

    final _cls4 this$1;

    public com.ebay.nautilus.kernel.util.ippingDimension get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("length".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                final GetShippingRecommendationResponse.ResponseNode.ShippingDimension this$2;

                protected void setValue(double d)
                    throws SAXException
                {
                    GetShippingRecommendationResponse.access$900(this$0).length = d;
                }

            
            {
                this$2 = GetShippingRecommendationResponse.ResponseNode.ShippingDimension.this;
                super();
            }
            };
        }
        if ("width".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                final GetShippingRecommendationResponse.ResponseNode.ShippingDimension this$2;

                protected void setValue(double d)
                    throws SAXException
                {
                    GetShippingRecommendationResponse.access$900(this$0).width = d;
                }

            
            {
                this$2 = GetShippingRecommendationResponse.ResponseNode.ShippingDimension.this;
                super();
            }
            };
        }
        if ("height".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                final GetShippingRecommendationResponse.ResponseNode.ShippingDimension this$2;

                protected void setValue(double d)
                    throws SAXException
                {
                    GetShippingRecommendationResponse.access$900(this$0).height = d;
                }

            
            {
                this$2 = GetShippingRecommendationResponse.ResponseNode.ShippingDimension.this;
                super();
            }
            };
        }
        if ("dimensionUnitType".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShippingRecommendationResponse.ResponseNode.ShippingDimension this$2;

                public void text(String s3)
                    throws SAXException
                {
                    GetShippingRecommendationResponse.access$900(this$0).dimensionUnitType = s3;
                }

            
            {
                this$2 = GetShippingRecommendationResponse.ResponseNode.ShippingDimension.this;
                super();
            }
            };
        } else
        {
            return super.ippingDimension(s, s1, s2, attributes);
        }
    }

    private _cls4.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
