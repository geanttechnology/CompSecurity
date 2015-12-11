// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.UserDetail;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetUserResponse

private final class <init> extends com.ebay.nautilus.kernel.util.t
{
    private final class User extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Email".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.email = s;
                        }

            
            {
                this$2 = User.this;
                super();
            }
                    };
                }
                if ("Site".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.site = s;
                        }

            
            {
                this$2 = User.this;
                super();
            }
                    };
                }
                if ("Status".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.status = s;
                        }

            
            {
                this$2 = User.this;
                super();
            }
                    };
                }
                if ("UserID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.userId = s;
                        }

            
            {
                this$2 = User.this;
                super();
            }
                    };
                }
                if ("SellerInfo".equals(s1))
                {
                    s = detail;
                    s1 = new com.ebay.common.model.UserDetail.SellerInfo();
                    s.sellerInfo = s1;
                    return new GetUserResponse.SellerInfo(s1);
                }
                if ("FeedbackRatingStar".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.feedbackRatingStar = s;
                        }

            
            {
                this$2 = User.this;
                super();
            }
                    };
                }
                if ("RegistrationAddress".equals(s1))
                {
                    detail.registrationAddress = new com.ebay.common.model.UserDetail.Address();
                    return new GetUserResponse.Address(detail.registrationAddress);
                }
                if ("PayPalAccountLevel".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.payPalAccountLevel = s;
                        }

            
            {
                this$2 = User.this;
                super();
            }
                    };
                }
                if ("PayPalAccountStatus".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.payPalAccountStatus = s;
                        }

            
            {
                this$2 = User.this;
                super();
            }
                    };
                }
                if ("PayPalAccountType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.payPalAccountType = s;
                        }

            
            {
                this$2 = User.this;
                super();
            }
                    };
                }
                if ("BusinessRole".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.isPpa = "Shopper".equals(s);
                        }

            
            {
                this$2 = User.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private User()
        {
            this$1 = GetUserResponse.RootElement.this;
            super();
        }

        User(GetUserResponse._cls1 _pcls1)
        {
            this();
        }
    }


    final GetUserResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(GetUserResponse.this);
            }
            if ("Timestamp".equals(s1))
            {
                return new TimestampElement(GetUserResponse.this);
            }
            if ("Errors".equals(s1))
            {
                return new ErrorElement(GetUserResponse.this, "urn:ebay:apis:eBLBaseComponents");
            }
            if ("User".equals(s1))
            {
                return new User(null);
            }
        }
        return super.t(s, s1, s2, attributes);
    }

    private User()
    {
        this$0 = GetUserResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
