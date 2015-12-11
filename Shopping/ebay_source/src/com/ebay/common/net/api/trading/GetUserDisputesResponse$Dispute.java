// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.UserDispute;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetUserDisputesResponse

private final class utes extends com.ebay.nautilus.kernel.util.e
{

    final GetUserDisputesResponse this$0;

    public com.ebay.nautilus.kernel.util.e get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            final UserDispute dispute = (UserDispute)userDisputes.get(userDisputes.size() - 1);
            if ("DisputeCreatedTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserDisputesResponse.Dispute this$1;
                    final UserDispute val$dispute;

                    public void text(String s3)
                        throws SAXException
                    {
                        dispute.createdTime = EbayDateUtils.parseXml(s3);
                    }

            
            {
                this$1 = GetUserDisputesResponse.Dispute.this;
                dispute = userdispute;
                super();
            }
                };
            }
            if ("DisputeCreditEligibility".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserDisputesResponse.Dispute this$1;
                    final UserDispute val$dispute;

                    public void text(String s3)
                        throws SAXException
                    {
                        dispute.creditEligibility = s3;
                    }

            
            {
                this$1 = GetUserDisputesResponse.Dispute.this;
                dispute = userdispute;
                super();
            }
                };
            }
            if ("DisputeExplanation".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserDisputesResponse.Dispute this$1;
                    final UserDispute val$dispute;

                    public void text(String s3)
                        throws SAXException
                    {
                        dispute.explanation = s3;
                    }

            
            {
                this$1 = GetUserDisputesResponse.Dispute.this;
                dispute = userdispute;
                super();
            }
                };
            }
            if ("DisputeID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserDisputesResponse.Dispute this$1;
                    final UserDispute val$dispute;

                    public void text(String s3)
                        throws SAXException
                    {
                        dispute.id = s3;
                    }

            
            {
                this$1 = GetUserDisputesResponse.Dispute.this;
                dispute = userdispute;
                super();
            }
                };
            }
            if ("DisputeReason".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserDisputesResponse.Dispute this$1;
                    final UserDispute val$dispute;

                    public void text(String s3)
                        throws SAXException
                    {
                        dispute.reason = s3;
                    }

            
            {
                this$1 = GetUserDisputesResponse.Dispute.this;
                dispute = userdispute;
                super();
            }
                };
            }
            if ("DisputeState".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserDisputesResponse.Dispute this$1;
                    final UserDispute val$dispute;

                    public void text(String s3)
                        throws SAXException
                    {
                        dispute.state = s3;
                    }

            
            {
                this$1 = GetUserDisputesResponse.Dispute.this;
                dispute = userdispute;
                super();
            }
                };
            }
            if ("DisputeStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserDisputesResponse.Dispute this$1;
                    final UserDispute val$dispute;

                    public void text(String s3)
                        throws SAXException
                    {
                        dispute.status = s3;
                    }

            
            {
                this$1 = GetUserDisputesResponse.Dispute.this;
                dispute = userdispute;
                super();
            }
                };
            }
            if ("Item".equals(s1))
            {
                return new it>(GetUserDisputesResponse.this, dispute);
            }
            if ("OrderLineItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserDisputesResponse.Dispute this$1;
                    final UserDispute val$dispute;

                    public void text(String s3)
                        throws SAXException
                    {
                        dispute.orderLineItemId = s3;
                    }

            
            {
                this$1 = GetUserDisputesResponse.Dispute.this;
                dispute = userdispute;
                super();
            }
                };
            }
            if ("TransactionID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserDisputesResponse.Dispute this$1;
                    final UserDispute val$dispute;

                    public void text(String s3)
                        throws SAXException
                    {
                        dispute.transactionId = s3;
                    }

            
            {
                this$1 = GetUserDisputesResponse.Dispute.this;
                dispute = userdispute;
                super();
            }
                };
            }
        }
        return super.e(s, s1, s2, attributes);
    }

    public _cls9.val.dispute()
    {
        this$0 = GetUserDisputesResponse.this;
        super();
        userDisputes.add(new UserDispute());
    }
}
