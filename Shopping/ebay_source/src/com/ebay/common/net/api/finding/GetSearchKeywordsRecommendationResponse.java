// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finding;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class GetSearchKeywordsRecommendationResponse extends EbayResponse
{

    public String keywordsRecommendation;
    com.ebay.nautilus.kernel.util.SaxHandler.Element rootElement;

    public GetSearchKeywordsRecommendationResponse()
    {
        keywordsRecommendation = null;
        rootElement = new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

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
                        return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                            final _cls1 this$1;

                            public void text(String s)
                                throws SAXException
                            {
                                keywordsRecommendation = s;
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        };
                    }
                }
                return super.get(s, s1, s2, attributes);
            }

            
            {
                this$0 = GetSearchKeywordsRecommendationResponse.this;
                super();
            }
        };
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, rootElement);
    }
}
