// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.ShippingRecommendation;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingRecommendationResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ode.PackageType
{

    final _cls1 this$1;

    public com.ebay.nautilus.kernel.util.ode.PackageType get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("packageType".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShippingRecommendationResponse.ResponseNode.PackageType this$2;

                public void text(String s3)
                    throws SAXException
                {
                    GetShippingRecommendationResponse.access$900(this$0).packageType = s3;
                }

            
            {
                this$2 = GetShippingRecommendationResponse.ResponseNode.PackageType.this;
                super();
            }
            };
        } else
        {
            return super.PackageType(s, s1, s2, attributes);
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
