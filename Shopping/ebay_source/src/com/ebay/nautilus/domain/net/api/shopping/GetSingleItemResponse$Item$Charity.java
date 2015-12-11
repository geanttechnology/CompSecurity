// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class <init> extends com.ebay.nautilus.kernel.util.tem.Charity
{

    final _cls7 this$1;

    public com.ebay.nautilus.kernel.util.tem.Charity get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("CharityID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetSingleItemResponse.Item.Charity this$2;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.charityId = i;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.Charity.this;
                super();
            }
                };
            }
            if ("CharityName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.Charity this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.charityName = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.Charity.this;
                super();
            }
                };
            }
            if ("CharityNumber".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetSingleItemResponse.Item.Charity this$2;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.charityNumber = i;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.Charity.this;
                super();
            }
                };
            }
            if ("DonationPercent".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.FloatElement() {

                    final GetSingleItemResponse.Item.Charity this$2;

                    public void setValue(float f)
                        throws SAXException
                    {
                        item.charityDonationPercent = f;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.Charity.this;
                super();
            }
                };
            }
            if ("LogoURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.Charity this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.charityLogoUrl = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.Charity.this;
                super();
            }
                };
            }
            if ("Mission".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.Charity this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.charityMission = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.Charity.this;
                super();
            }
                };
            }
            if ("Status".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.Charity this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.charityStatus = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.Charity.this;
                super();
            }
                };
            }
        }
        return super.Charity(s, s1, s2, attributes);
    }

    private _cls7.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
