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

class this._cls2 extends com.ebay.nautilus.kernel.util.ponse._cls1._cls1._cls4
{

    final  this$2;

    public void text(String s)
        throws SAXException
    {
        result.myWorldSmallImage = s;
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1

/* anonymous class */
    class GetUserProfileResponse._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.nautilus.kernel.util.SaxHandler.Element feedbackHistory = new GetUserProfileResponse._cls1._cls2();
        final GetUserProfileResponse this$0;
        private final com.ebay.nautilus.kernel.util.SaxHandler.Element user = new GetUserProfileResponse._cls1._cls1();

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
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
            return super.get(s, s1, s2, attributes);
        }

            
            {
                this$0 = GetUserProfileResponse.this;
                super();
            }

        // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$2

/* anonymous class */
        class GetUserProfileResponse._cls1._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
        {

            final GetUserProfileResponse._cls1 this$1;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("urn:ebay:apis:eBLBaseComponents".equals(s))
                {
                    if ("UniqueNegativeFeedbackCount".equals(s1))
                    {
                        return new GetUserProfileResponse._cls1._cls2._cls1();
                    }
                    if ("UniqueNeutralFeedbackCount".equals(s1))
                    {
                        return new GetUserProfileResponse._cls1._cls2._cls2();
                    }
                    if ("UniquePositiveFeedbackCount".equals(s1))
                    {
                        return new GetUserProfileResponse._cls1._cls2._cls3();
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
        }


        // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$2$1

/* anonymous class */
        class GetUserProfileResponse._cls1._cls2._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.LongElement
        {

            final GetUserProfileResponse._cls1._cls2 this$2;

            public void setValue(long l)
                throws SAXException
            {
                result.uniqueNegativeFeedbackCount = l;
            }

                    
                    {
                        this$2 = GetUserProfileResponse._cls1._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$2$2

/* anonymous class */
        class GetUserProfileResponse._cls1._cls2._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.LongElement
        {

            final GetUserProfileResponse._cls1._cls2 this$2;

            public void setValue(long l)
                throws SAXException
            {
                result.uniqueNeutralFeedbackCount = l;
            }

                    
                    {
                        this$2 = GetUserProfileResponse._cls1._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$2$3

/* anonymous class */
        class GetUserProfileResponse._cls1._cls2._cls3 extends com.ebay.nautilus.kernel.util.SaxHandler.LongElement
        {

            final GetUserProfileResponse._cls1._cls2 this$2;

            public void setValue(long l)
                throws SAXException
            {
                result.uniquePositiveFeedbackCount = l;
            }

                    
                    {
                        this$2 = GetUserProfileResponse._cls1._cls2.this;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$1

/* anonymous class */
    class GetUserProfileResponse._cls1._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserProfileResponse._cls1 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("PositiveFeedbackPercent".equals(s1))
                {
                    return new GetUserProfileResponse._cls1._cls1._cls1();
                }
                if ("FeedbackScore".equals(s1))
                {
                    return new GetUserProfileResponse._cls1._cls1._cls2();
                }
                if ("RegistrationDate".equals(s1))
                {
                    return new GetUserProfileResponse._cls1._cls1._cls3();
                }
                if ("MyWorldSmallImage".equals(s1))
                {
                    return new GetUserProfileResponse._cls1._cls1._cls4();
                }
                if ("MyWorldLargeImage".equals(s1))
                {
                    return new GetUserProfileResponse._cls1._cls1._cls5();
                }
                if ("UserID".equals(s1))
                {
                    return new GetUserProfileResponse._cls1._cls1._cls6();
                }
                if ("TopRatedSeller".equals(s1))
                {
                    return new GetUserProfileResponse._cls1._cls1._cls7();
                }
                if ("SellerBusinessType".equals(s1))
                {
                    return new GetUserProfileResponse._cls1._cls1._cls8();
                }
                if ("FeedbackRatingStar".equals(s1))
                {
                    return new GetUserProfileResponse._cls1._cls1._cls9();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

            
            {
                this$1 = GetUserProfileResponse._cls1.this;
                super();
            }

        // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$1$1

/* anonymous class */
        class GetUserProfileResponse._cls1._cls1._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement
        {

            final GetUserProfileResponse._cls1._cls1 this$2;

            public void setValue(double d)
                throws SAXException
            {
                result.positiveFeedbackPercent = d;
            }

                    
                    {
                        this$2 = GetUserProfileResponse._cls1._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$1$2

/* anonymous class */
        class GetUserProfileResponse._cls1._cls1._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement
        {

            final GetUserProfileResponse._cls1._cls1 this$2;

            public void setValue(int i)
                throws SAXException
            {
                result.feedbackScore = i;
            }

                    
                    {
                        this$2 = GetUserProfileResponse._cls1._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$1$3

/* anonymous class */
        class GetUserProfileResponse._cls1._cls1._cls3 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetUserProfileResponse._cls1._cls1 this$2;

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
                        this$2 = GetUserProfileResponse._cls1._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$1$5

/* anonymous class */
        class GetUserProfileResponse._cls1._cls1._cls5 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetUserProfileResponse._cls1._cls1 this$2;

            public void text(String s)
                throws SAXException
            {
                result.myWorldLargeImage = s;
            }

                    
                    {
                        this$2 = GetUserProfileResponse._cls1._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$1$6

/* anonymous class */
        class GetUserProfileResponse._cls1._cls1._cls6 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetUserProfileResponse._cls1._cls1 this$2;

            public void text(String s)
                throws SAXException
            {
                result.userId = s;
            }

                    
                    {
                        this$2 = GetUserProfileResponse._cls1._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$1$7

/* anonymous class */
        class GetUserProfileResponse._cls1._cls1._cls7 extends com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement
        {

            final GetUserProfileResponse._cls1._cls1 this$2;

            public void setValue(boolean flag)
                throws SAXException
            {
                result.bIsTopRatedSeller = flag;
            }

                    
                    {
                        this$2 = GetUserProfileResponse._cls1._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$1$8

/* anonymous class */
        class GetUserProfileResponse._cls1._cls1._cls8 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetUserProfileResponse._cls1._cls1 this$2;

            public void text(String s)
                throws SAXException
            {
                result.sellerBusinessType = s;
            }

                    
                    {
                        this$2 = GetUserProfileResponse._cls1._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$1$9

/* anonymous class */
        class GetUserProfileResponse._cls1._cls1._cls9 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetUserProfileResponse._cls1._cls1 this$2;

            public void text(String s)
                throws SAXException
            {
                result.ratingStar = s;
            }

                    
                    {
                        this$2 = GetUserProfileResponse._cls1._cls1.this;
                        super();
                    }
        }

    }

}
