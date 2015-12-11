// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            Feedback

public final class GetFeedbackResponse extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetFeedbackResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetFeedbackResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(GetFeedbackResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(GetFeedbackResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("FeedbackDetailArray".equals(s1))
                {
                    return new FeedbackDetailArray();
                }
                if ("PaginationResult".equals(s1))
                {
                    return new PaginationResult();
                }
                if ("FeedbackScore".equals(s1))
                {
                    return new FeedbackScoreElement();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = GetFeedbackResponse.this;
            super();
        }

    }

    private final class RootElement.FeedbackDetail extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            Feedback feedback = (Feedback)feedbackList.get(feedbackList.size() - 1);
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CommentingUser".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void text(String s)
                            throws SAXException
                        {
                            feedback.commentingUser = s;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("CommentingUserScore".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void setValue(int i)
                            throws SAXException
                        {
                            feedback.commentingUserScore = i;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("CommentReplaced".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            feedback.commentReplaced = flag;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("CommentText".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void text(String s)
                            throws SAXException
                        {
                            feedback.commentText = s;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("CommentTime".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void text(String s)
                            throws SAXException
                        {
                            feedback.commentTime = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("CommentType".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void text(String s)
                            throws SAXException
                        {
                            feedback.commentType = s;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("Countable".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            feedback.countable = flag;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("FeedbackID".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void text(String s)
                            throws SAXException
                        {
                            feedback.feedbackId = s;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("FeedbackResponse".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void text(String s)
                            throws SAXException
                        {
                            feedback.feedbackResponse = s;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("FeedbackRevised".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            feedback.feedbackRevised = flag;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("Followup".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void text(String s)
                            throws SAXException
                        {
                            feedback.followUp = s;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("FollowUpReplaced".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            feedback.followUpReplaced = flag;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("ItemID".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void text(String s)
                            throws SAXException
                        {
                            feedback.itemId = s;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("ItemTitle".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void text(String s)
                            throws SAXException
                        {
                            feedback.itemTitle = s;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("OrderLineItemID".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void text(String s)
                            throws SAXException
                        {
                            feedback.orderLineItemId = s;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("ResponseReplaced".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            feedback.responseReplaced = flag;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("Role".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void text(String s)
                            throws SAXException
                        {
                            feedback.role = s;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
                if ("TransactionID".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.FeedbackDetail this$2;
                        final Feedback val$feedback;

                        public void text(String s)
                            throws SAXException
                        {
                            feedback.transactionId = s;
                        }

            
            {
                this$2 = final_feedbackdetail;
                feedback = Feedback.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public RootElement.FeedbackDetail()
        {
            this$1 = RootElement.this;
            super();
            feedbackList.add(new Feedback(false));
        }
    }

    private final class RootElement.FeedbackDetailArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "FeedbackDetail".equals(s1))
            {
                return new RootElement.FeedbackDetail();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.FeedbackDetailArray()
        {
            this$1 = RootElement.this;
            super();
        }

    }

    public final class RootElement.FeedbackScoreElement extends com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            return super.get(s, s1, s2, attributes);
        }

        protected void setValue(int i)
            throws SAXException
        {
            feedbackScore = i;
        }

        public RootElement.FeedbackScoreElement()
        {
            this$1 = RootElement.this;
            super();
        }
    }

    private final class RootElement.PaginationResult extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("TotalNumberOfEntries".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final RootElement.PaginationResult this$2;

                        public void setValue(int i)
                            throws SAXException
                        {
                            totalNumberOfEntries = i;
                        }

            
            {
                this$2 = RootElement.PaginationResult.this;
                super();
            }
                    };
                }
                if ("TotalNumberOfPages".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final RootElement.PaginationResult this$2;

                        public void setValue(int i)
                            throws SAXException
                        {
                            totalNumberOfPages = i;
                        }

            
            {
                this$2 = RootElement.PaginationResult.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement.PaginationResult()
        {
            this$1 = RootElement.this;
            super();
        }

    }


    public final ArrayList feedbackList = new ArrayList();
    public int feedbackScore;
    public int totalNumberOfEntries;
    public int totalNumberOfPages;

    public GetFeedbackResponse()
    {
        feedbackScore = 0;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
