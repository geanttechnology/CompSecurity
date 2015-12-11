// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetFeedbackResponse, Feedback

private final class <init> extends com.ebay.nautilus.kernel.util.t
{
    private final class FeedbackDetail extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetFeedbackResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            Feedback feedback = (Feedback)feedbackList.get(feedbackList.size() - 1);
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CommentingUser".equals(s1))
                {
                    return feedback. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

                        final FeedbackDetail this$2;
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

        public FeedbackDetail()
        {
            this$1 = GetFeedbackResponse.RootElement.this;
            super();
            feedbackList.add(new Feedback(false));
        }
    }

    private final class FeedbackDetailArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetFeedbackResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "FeedbackDetail".equals(s1))
            {
                return new FeedbackDetail();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private FeedbackDetailArray()
        {
            this$1 = GetFeedbackResponse.RootElement.this;
            super();
        }

        FeedbackDetailArray(GetFeedbackResponse._cls1 _pcls1)
        {
            this();
        }
    }

    public final class FeedbackScoreElement extends com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement
    {

        final GetFeedbackResponse.RootElement this$1;

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

        public FeedbackScoreElement()
        {
            this$1 = GetFeedbackResponse.RootElement.this;
            super();
        }
    }

    private final class PaginationResult extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetFeedbackResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("TotalNumberOfEntries".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final PaginationResult this$2;

                        public void setValue(int i)
                            throws SAXException
                        {
                            totalNumberOfEntries = i;
                        }

            
            {
                this$2 = PaginationResult.this;
                super();
            }
                    };
                }
                if ("TotalNumberOfPages".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final PaginationResult this$2;

                        public void setValue(int i)
                            throws SAXException
                        {
                            totalNumberOfPages = i;
                        }

            
            {
                this$2 = PaginationResult.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private PaginationResult()
        {
            this$1 = GetFeedbackResponse.RootElement.this;
            super();
        }

        PaginationResult(GetFeedbackResponse._cls1 _pcls1)
        {
            this();
        }
    }


    final GetFeedbackResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
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
                return new FeedbackDetailArray(null);
            }
            if ("PaginationResult".equals(s1))
            {
                return new PaginationResult(null);
            }
            if ("FeedbackScore".equals(s1))
            {
                return new FeedbackScoreElement();
            }
        }
        return super.t(s, s1, s2, attributes);
    }

    private PaginationResult()
    {
        this$0 = GetFeedbackResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
