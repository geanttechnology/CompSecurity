// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.UserProfile;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

public final class GetUserProfileResponse extends EbayResponse
{
    static class AverageRatingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public com.ebay.nautilus.domain.data.UserProfile.AverageRatingDetails rating;
        public String ratingDetail;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Rating".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final AverageRatingDetails this$0;

                    public void setValue(double d)
                        throws SAXException
                    {
                        rating.rating = d;
                    }

            
            {
                this$0 = AverageRatingDetails.this;
                super();
            }
                };
            }
            if ("RatingCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final AverageRatingDetails this$0;

                    public void setValue(long l)
                        throws SAXException
                    {
                        rating.ratingCount = l;
                    }

            
            {
                this$0 = AverageRatingDetails.this;
                super();
            }
                };
            }
            if ("RatingDetail".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final AverageRatingDetails this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        ratingDetail = s;
                    }

            
            {
                this$0 = AverageRatingDetails.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        AverageRatingDetails()
        {
            rating = new com.ebay.nautilus.domain.data.UserProfile.AverageRatingDetails();
            ratingDetail = null;
        }
    }

    static class FeedbackPeriod extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public long count;
        public int periodInDays;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Count".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final FeedbackPeriod this$0;

                    public void setValue(long l)
                        throws SAXException
                    {
                        count = l;
                    }

            
            {
                this$0 = FeedbackPeriod.this;
                super();
            }
                };
            }
            if ("PeriodInDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final FeedbackPeriod this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        periodInDays = i;
                    }

            
            {
                this$0 = FeedbackPeriod.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        FeedbackPeriod()
        {
            count = -1L;
            periodInDays = -1;
        }
    }


    private static final String ERROR_CODE_INVALID_INPUT = "10.47";
    private static final String ERROR_PARAMETER_USERID = "UserID";
    final ArrayList averageRatingDetails = new ArrayList(4);
    final ArrayList negativeFeedbackPeriods = new ArrayList();
    final ArrayList neutralFeedbackPeriods = new ArrayList();
    final ArrayList positiveFeedbackPeriods = new ArrayList();
    public final UserProfile result = new UserProfile();
    private final com.ebay.nautilus.kernel.util.SaxHandler.Element rootElement = new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

        private final com.ebay.nautilus.kernel.util.SaxHandler.Element feedbackHistory = new _cls2();
        final GetUserProfileResponse this$0;
        private final com.ebay.nautilus.kernel.util.SaxHandler.Element user = new _cls1();

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s1, String s2, String s3, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s1))
            {
                if ("Ack".equals(s2))
                {
                    return new AckElement(GetUserProfileResponse.this);
                }
                if ("Errors".equals(s2))
                {
                    return new ErrorElement(GetUserProfileResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("Timestamp".equals(s2))
                {
                    return new TimestampElement(GetUserProfileResponse.this);
                }
                if ("User".equals(s2))
                {
                    return user;
                }
                if ("FeedbackHistory".equals(s2))
                {
                    return feedbackHistory;
                }
            }
            return super.get(s1, s2, s3, attributes);
        }

            
            {
                this$0 = GetUserProfileResponse.this;
                super();
            }
    };

    GetUserProfileResponse(String s)
    {
        result.userId = s;
    }

    public static boolean isInvalidUserId(List list)
    {
        if (list != null && !list.isEmpty())
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                Object obj = (com.ebay.nautilus.kernel.content.ResultStatus.Message)list.next();
                if (obj instanceof com.ebay.nautilus.domain.net.EbayResponseError.ShortDetails)
                {
                    obj = (com.ebay.nautilus.domain.net.EbayResponseError.ShortDetails)obj;
                    if ("10.47".equals(((com.ebay.nautilus.domain.net.EbayResponseError.ShortDetails) (obj)).code) && ((com.ebay.nautilus.domain.net.EbayResponseError.ShortDetails) (obj)).parameters != null && !((com.ebay.nautilus.domain.net.EbayResponseError.ShortDetails) (obj)).parameters.isEmpty())
                    {
                        return "UserID".equals(((com.ebay.nautilus.domain.net.EbayResponseError.ShortDetails) (obj)).parameters.get(0));
                    }
                }
            }
        }
        return false;
    }

    private void setFeedback(ArrayList arraylist, long al[])
    {
        if (!arraylist.isEmpty())
        {
            arraylist = arraylist.iterator();
            do
            {
                if (!arraylist.hasNext())
                {
                    break;
                }
                FeedbackPeriod feedbackperiod = (FeedbackPeriod)arraylist.next();
                if (feedbackperiod.periodInDays >= 30)
                {
                    if (feedbackperiod.periodInDays < 31)
                    {
                        al[0] = al[0] + feedbackperiod.count;
                    } else
                    if (feedbackperiod.periodInDays < 181)
                    {
                        al[1] = al[1] + feedbackperiod.count;
                    } else
                    {
                        al[2] = al[2] + feedbackperiod.count;
                    }
                }
            } while (true);
        }
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, rootElement);
        if (!averageRatingDetails.isEmpty())
        {
            inputstream = averageRatingDetails.iterator();
            do
            {
                if (!inputstream.hasNext())
                {
                    break;
                }
                AverageRatingDetails averageratingdetails = (AverageRatingDetails)inputstream.next();
                if ("Communication".equals(averageratingdetails.ratingDetail))
                {
                    result.ratingCommunication = averageratingdetails.rating;
                } else
                if ("ItemAsDescribed".equals(averageratingdetails.ratingDetail))
                {
                    result.ratingItemAsDescribed = averageratingdetails.rating;
                } else
                if ("ShippingAndHandlingCharges".equals(averageratingdetails.ratingDetail))
                {
                    result.ratingShippingAndHandlingCharges = averageratingdetails.rating;
                } else
                if ("ShippingTime".equals(averageratingdetails.ratingDetail))
                {
                    result.ratingShippingTime = averageratingdetails.rating;
                }
            } while (true);
        }
        setFeedback(negativeFeedbackPeriods, result.negativeFeedbackCount);
        setFeedback(neutralFeedbackPeriods, result.neutralFeedbackCount);
        setFeedback(positiveFeedbackPeriods, result.positiveFeedbackCount);
    }

    // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$1

/* anonymous class */
    class _cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final _cls1 this$1;

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
    class _cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
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
                this$1 = _cls1.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/nautilus/domain/net/api/shopping/GetUserProfileResponse$1$2

/* anonymous class */
    class _cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final _cls1 this$1;

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
    class _cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
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
                    s = new AverageRatingDetails();
                    averageRatingDetails.add(s);
                    return s;
                }
                if ("NegativeFeedbackPeriods".equals(s1))
                {
                    s = new FeedbackPeriod();
                    negativeFeedbackPeriods.add(s);
                    return s;
                }
                if ("NeutralFeedbackPeriods".equals(s1))
                {
                    s = new FeedbackPeriod();
                    neutralFeedbackPeriods.add(s);
                    return s;
                }
                if ("PositiveFeedbackPeriods".equals(s1))
                {
                    s = new FeedbackPeriod();
                    positiveFeedbackPeriods.add(s);
                    return s;
                }
            }
            return super.get(s, s1, s2, attributes);
        }

            
            {
                this$1 = _cls1.this;
                super();
            }
    }

}
