// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.UserDetail;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetUserResponse

private final class <init> extends com.ebay.nautilus.kernel.util.r
{

    final _cls9 this$1;

    public com.ebay.nautilus.kernel.util.r get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Email".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.RootElement.User this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        detail.email = s3;
                    }

            
            {
                this$2 = GetUserResponse.RootElement.User.this;
                super();
            }
                };
            }
            if ("Site".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.RootElement.User this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        detail.site = s3;
                    }

            
            {
                this$2 = GetUserResponse.RootElement.User.this;
                super();
            }
                };
            }
            if ("Status".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.RootElement.User this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        detail.status = s3;
                    }

            
            {
                this$2 = GetUserResponse.RootElement.User.this;
                super();
            }
                };
            }
            if ("UserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.RootElement.User this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        detail.userId = s3;
                    }

            
            {
                this$2 = GetUserResponse.RootElement.User.this;
                super();
            }
                };
            }
            if ("SellerInfo".equals(s1))
            {
                s = detail;
                s1 = new com.ebay.common.model.ment.User();
                s.sellerInfo = s1;
                return new (s1);
            }
            if ("FeedbackRatingStar".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.RootElement.User this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        detail.feedbackRatingStar = s3;
                    }

            
            {
                this$2 = GetUserResponse.RootElement.User.this;
                super();
            }
                };
            }
            if ("RegistrationAddress".equals(s1))
            {
                detail.registrationAddress = new com.ebay.common.model.ment.User();
                return new _cls5(detail.registrationAddress);
            }
            if ("PayPalAccountLevel".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.RootElement.User this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        detail.payPalAccountLevel = s3;
                    }

            
            {
                this$2 = GetUserResponse.RootElement.User.this;
                super();
            }
                };
            }
            if ("PayPalAccountStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.RootElement.User this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        detail.payPalAccountStatus = s3;
                    }

            
            {
                this$2 = GetUserResponse.RootElement.User.this;
                super();
            }
                };
            }
            if ("PayPalAccountType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.RootElement.User this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        detail.payPalAccountType = s3;
                    }

            
            {
                this$2 = GetUserResponse.RootElement.User.this;
                super();
            }
                };
            }
            if ("BusinessRole".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.RootElement.User this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        detail.isPpa = "Shopper".equals(s3);
                    }

            
            {
                this$2 = GetUserResponse.RootElement.User.this;
                super();
            }
                };
            }
        }
        return super.r(s, s1, s2, attributes);
    }

    private _cls9.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
