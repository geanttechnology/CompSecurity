// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetAllBiddersResponse

private final class user extends com.ebay.nautilus.kernel.util.r
{

    final GetAllBiddersResponse this$0;
    private final com.ebay.common.model.onse user;

    public com.ebay.nautilus.kernel.util.r get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("AboutMePage".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        user.aboutMePage = flag;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("BiddingSummary".equals(s1))
            {
                return new ngSummary(GetAllBiddersResponse.this, user.iddingSummary);
            }
            if ("BuyerInfo".equals(s1))
            {
                return new Info(GetAllBiddersResponse.this, user.uyerInfo);
            }
            if ("eBayGoodStanding".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        user.eBayGoodStanding = flag;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("Email".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        user.email = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("FeedbackPrivate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        user.feedbackPrivate = flag;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("FeedbackRatingStar".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        user.feedbackRatingStar = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("FeedbackScore".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        user.feedbackScore = i;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("IDVerified".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        user.IdVerified = flag;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("NewUser".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        user.newUser = flag;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("PositiveFeedbackPercent".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.FloatElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void setValue(float f)
                        throws SAXException
                    {
                        user.positiveFeedbackPercent = f;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("RegistrationDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        user.registrationDate = EbayDateUtils.parseXml(s3);
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("Site".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        user.site = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("Status".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        user.status = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("UserAnonymized".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        user.userAnonymized = flag;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("UserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        user.userId = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("UserIDChanged".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        user.userIdChanged = flag;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("UserIDLastChanged".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        user.userIdLastChanged = EbayDateUtils.parseXml(s3);
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
            if ("VATStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.User this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        user.vatStatus = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.User.this;
                super();
            }
                };
            }
        }
        return super.r(s, s1, s2, attributes);
    }


    public >(com.ebay.common.model.onse onse)
    {
        this$0 = GetAllBiddersResponse.this;
        super();
        user = onse;
    }
}
