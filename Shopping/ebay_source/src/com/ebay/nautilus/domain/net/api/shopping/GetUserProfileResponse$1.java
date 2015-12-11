// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.UserProfile;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.text.ParseException;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetUserProfileResponse

class this._cls0 extends com.ebay.nautilus.kernel.util.eResponse._cls1
{

    private final com.ebay.nautilus.kernel.util.ry feedbackHistory = new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

        final GetUserProfileResponse._cls1 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("UniqueNegativeFeedbackCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final _cls2 this$2;

                        public void setValue(long l)
                            throws SAXException
                        {
                            result.uniqueNegativeFeedbackCount = l;
                        }

            
            {
                this$2 = _cls2.this;
                super();
            }
                    };
                }
                if ("UniqueNeutralFeedbackCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final _cls2 this$2;

                        public void setValue(long l)
                            throws SAXException
                        {
                            result.uniqueNeutralFeedbackCount = l;
                        }

            
            {
                this$2 = _cls2.this;
                super();
            }
                    };
                }
                if ("UniquePositiveFeedbackCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final _cls2 this$2;

                        public void setValue(long l)
                            throws SAXException
                        {
                            result.uniquePositiveFeedbackCount = l;
                        }

            
            {
                this$2 = _cls2.this;
                super();
            }
                    };
                }
                if ("AverageRatingDetails".equals(s1))
                {
                    s = new GetUserProfileResponse.AverageRatingDetails();
                    averageRatingDetails.add(s);
                    return s;
                }
                if ("NegativeFeedbackPeriods".equals(s1))
                {
                    s = new GetUserProfileResponse.FeedbackPeriod();
                    negativeFeedbackPeriods.add(s);
                    return s;
                }
                if ("NeutralFeedbackPeriods".equals(s1))
                {
                    s = new GetUserProfileResponse.FeedbackPeriod();
                    neutralFeedbackPeriods.add(s);
                    return s;
                }
                if ("PositiveFeedbackPeriods".equals(s1))
                {
                    s = new GetUserProfileResponse.FeedbackPeriod();
                    positiveFeedbackPeriods.add(s);
                    return s;
                }
            }
            return super.get(s, s1, s2, attributes);
        }

            
            {
                this$1 = GetUserProfileResponse._cls1.this;
                super();
            }
    };
    final GetUserProfileResponse this$0;
    private final com.ebay.nautilus.kernel.util.eResponse user = new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

        final GetUserProfileResponse._cls1 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("PositiveFeedbackPercent".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                        final _cls1 this$2;

                        public void setValue(double d)
                            throws SAXException
                        {
                            result.positiveFeedbackPercent = d;
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    };
                }
                if ("FeedbackScore".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final _cls1 this$2;

                        public void setValue(int i)
                            throws SAXException
                        {
                            result.feedbackScore = i;
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    };
                }
                if ("RegistrationDate".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final _cls1 this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            try
                            {
                                result.registrationDate = EbayDateUtils.parse(s);
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (String s)
                            {
                                throw new SAXNotRecognizedException(s.getLocalizedMessage());
                            }
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    };
                }
                if ("MyWorldSmallImage".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final _cls1 this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            result.myWorldSmallImage = s;
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    };
                }
                if ("MyWorldLargeImage".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final _cls1 this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            result.myWorldLargeImage = s;
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    };
                }
                if ("UserID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final _cls1 this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            result.userId = s;
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    };
                }
                if ("TopRatedSeller".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final _cls1 this$2;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            result.bIsTopRatedSeller = flag;
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    };
                }
                if ("SellerBusinessType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final _cls1 this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            result.sellerBusinessType = s;
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    };
                }
                if ("FeedbackRatingStar".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final _cls1 this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            result.ratingStar = s;
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

            
            {
                this$1 = GetUserProfileResponse._cls1.this;
                super();
            }
    };

    public com.ebay.nautilus.kernel.util.eResponse._cls1 get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(GetUserProfileResponse.this);
            }
            if ("Errors".equals(s1))
            {
                return new ErrorElement(GetUserProfileResponse.this, "urn:ebay:apis:eBLBaseComponents");
            }
            if ("Timestamp".equals(s1))
            {
                return new TimestampElement(GetUserProfileResponse.this);
            }
            if ("User".equals(s1))
            {
                return user;
            }
            if ("FeedbackHistory".equals(s1))
            {
                return feedbackHistory;
            }
        }
        return super.feedbackHistory(s, s1, s2, attributes);
    }

    _cls2.this._cls1()
    {
        this$0 = GetUserProfileResponse.this;
        super();
    }
}
