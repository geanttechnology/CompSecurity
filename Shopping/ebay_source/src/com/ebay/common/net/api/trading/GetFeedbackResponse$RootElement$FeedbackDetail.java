// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetFeedbackResponse, Feedback

private final class this._cls1 extends com.ebay.nautilus.kernel.util.l
{

    final _cls18.val.feedback this$1;

    public com.ebay.nautilus.kernel.util.l get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        final Feedback feedback = (Feedback)feedbackList.get(feedbackList.size() - 1);
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("CommentingUser".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void text(String s3)
                        throws SAXException
                    {
                        feedback.commentingUser = s3;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("CommentingUserScore".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void setValue(int i)
                        throws SAXException
                    {
                        feedback.commentingUserScore = i;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("CommentReplaced".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        feedback.commentReplaced = flag;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("CommentText".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void text(String s3)
                        throws SAXException
                    {
                        feedback.commentText = s3;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("CommentTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void text(String s3)
                        throws SAXException
                    {
                        feedback.commentTime = EbayDateUtils.parseXml(s3);
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("CommentType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void text(String s3)
                        throws SAXException
                    {
                        feedback.commentType = s3;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("Countable".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        feedback.countable = flag;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("FeedbackID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void text(String s3)
                        throws SAXException
                    {
                        feedback.feedbackId = s3;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("FeedbackResponse".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void text(String s3)
                        throws SAXException
                    {
                        feedback.feedbackResponse = s3;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("FeedbackRevised".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        feedback.feedbackRevised = flag;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("Followup".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void text(String s3)
                        throws SAXException
                    {
                        feedback.followUp = s3;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("FollowUpReplaced".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        feedback.followUpReplaced = flag;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("ItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void text(String s3)
                        throws SAXException
                    {
                        feedback.itemId = s3;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("ItemTitle".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void text(String s3)
                        throws SAXException
                    {
                        feedback.itemTitle = s3;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("OrderLineItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void text(String s3)
                        throws SAXException
                    {
                        feedback.orderLineItemId = s3;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("ResponseReplaced".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        feedback.responseReplaced = flag;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("Role".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void text(String s3)
                        throws SAXException
                    {
                        feedback.role = s3;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
            if ("TransactionID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetFeedbackResponse.RootElement.FeedbackDetail this$2;
                    final Feedback val$feedback;

                    public void text(String s3)
                        throws SAXException
                    {
                        feedback.transactionId = s3;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.FeedbackDetail.this;
                feedback = feedback1;
                super();
            }
                };
            }
        }
        return super.l(s, s1, s2, attributes);
    }

    public _cls9.val.feedback()
    {
        this$1 = this._cls1.this;
        super();
        feedbackList.add(new Feedback(false));
    }
}
