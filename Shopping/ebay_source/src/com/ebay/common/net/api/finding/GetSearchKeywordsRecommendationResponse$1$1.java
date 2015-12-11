// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finding;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.finding:
//            GetSearchKeywordsRecommendationResponse

class this._cls1 extends com.ebay.nautilus.kernel.util._cls1
{

    final ordsRecommendation this$1;

    public void text(String s)
        throws SAXException
    {
        keywordsRecommendation = s;
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/ebay/common/net/api/finding/GetSearchKeywordsRecommendationResponse$1

/* anonymous class */
    class GetSearchKeywordsRecommendationResponse._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSearchKeywordsRecommendationResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
            {
                if ("ack".equals(s1))
                {
                    return new AckElement(GetSearchKeywordsRecommendationResponse.this);
                }
                if ("timestamp".equals(s1))
                {
                    return new TimestampElement(GetSearchKeywordsRecommendationResponse.this);
                }
                if ("errorMessage".equals(s1))
                {
                    return new ErrorMessageElement(GetSearchKeywordsRecommendationResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
                }
                if ("keywords".equals(s1))
                {
                    return new GetSearchKeywordsRecommendationResponse._cls1._cls1();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

            
            {
                this$0 = GetSearchKeywordsRecommendationResponse.this;
                super();
            }
    }

}
