// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            FindNonProfitResponse

private final class data extends com.ebay.nautilus.kernel.util.ement
{

    private final com.ebay.common.model.givingworks.t data;
    final data this$1;

    public com.ebay.nautilus.kernel.util.ement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if (FindNonProfitResponse.access$000(this._cls1.this.data).equals(s))
        {
            if ("externalId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindNonProfitResponse.RootElement.NonprofitElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        data.externalId = s3;
                    }

            
            {
                this$2 = FindNonProfitResponse.RootElement.NonprofitElement.this;
                super();
            }
                };
            }
            if ("nonprofitId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindNonProfitResponse.RootElement.NonprofitElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        data.nonprofitId = s3;
                    }

            
            {
                this$2 = FindNonProfitResponse.RootElement.NonprofitElement.this;
                super();
            }
                };
            }
            if ("name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindNonProfitResponse.RootElement.NonprofitElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        data.name = s3;
                    }

            
            {
                this$2 = FindNonProfitResponse.RootElement.NonprofitElement.this;
                super();
            }
                };
            }
            if ("mission".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindNonProfitResponse.RootElement.NonprofitElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        data.mission = s3;
                    }

            
            {
                this$2 = FindNonProfitResponse.RootElement.NonprofitElement.this;
                super();
            }
                };
            }
            if ("logoURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindNonProfitResponse.RootElement.NonprofitElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        data.logoUrl = s3;
                    }

            
            {
                this$2 = FindNonProfitResponse.RootElement.NonprofitElement.this;
                super();
            }
                };
            }
            if ("largeLogoURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindNonProfitResponse.RootElement.NonprofitElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        data.largeLogoUrl = s3;
                    }

            
            {
                this$2 = FindNonProfitResponse.RootElement.NonprofitElement.this;
                super();
            }
                };
            }
            if ("address".equals(s1))
            {
                return new nit>(this._cls1.this, data.data);
            }
            if ("favoriteCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final FindNonProfitResponse.RootElement.NonprofitElement this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        data.favoriteCount = i;
                    }

            
            {
                this$2 = FindNonProfitResponse.RootElement.NonprofitElement.this;
                super();
            }
                };
            }
        }
        return super.ement(s, s1, s2, attributes);
    }


    public _cls7.this._cls2(com.ebay.common.model.givingworks.t t)
    {
        this$1 = this._cls1.this;
        super();
        data = t;
    }
}
