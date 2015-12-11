// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetUserProfileResponse

static class ratingDetail extends com.ebay.nautilus.kernel.util.tingDetails
{

    public com.ebay.nautilus.domain.data.tingDetails rating;
    public String ratingDetail;

    public com.ebay.nautilus.kernel.util.tingDetails get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Rating".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                final GetUserProfileResponse.AverageRatingDetails this$0;

                public void setValue(double d)
                    throws SAXException
                {
                    rating.rating = d;
                }

            
            {
                this$0 = GetUserProfileResponse.AverageRatingDetails.this;
                super();
            }
            };
        }
        if ("RatingCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final GetUserProfileResponse.AverageRatingDetails this$0;

                public void setValue(long l)
                    throws SAXException
                {
                    rating.ratingCount = l;
                }

            
            {
                this$0 = GetUserProfileResponse.AverageRatingDetails.this;
                super();
            }
            };
        }
        if ("RatingDetail".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetUserProfileResponse.AverageRatingDetails this$0;

                public void text(String s3)
                    throws SAXException
                {
                    ratingDetail = s3;
                }

            
            {
                this$0 = GetUserProfileResponse.AverageRatingDetails.this;
                super();
            }
            };
        } else
        {
            return super.tingDetails(s, s1, s2, attributes);
        }
    }

    _cls3.this._cls0()
    {
        rating = new com.ebay.nautilus.domain.data.tingDetails.rating();
        ratingDetail = null;
    }
}
