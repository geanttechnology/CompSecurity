// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.rtm;

import android.util.Base64;
import com.ebay.common.rtm.RtmContentResult;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.kernel.util.XmlFormatter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.rtm:
//            GetRtm, EbayRtmApi

private final class <init> extends com.ebay.nautilus.kernel.util.nit>
{

    final _cls2 this$0;

    public com.ebay.nautilus.kernel.util.nit> get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ack".equals(s1))
        {
            return new AckElement(this._cls0.this);
        }
        if ("version".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetRtm.GetRtmResponse.ResponseElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    rcr.setVersion(s3);
                }

            
            {
                this$1 = GetRtm.GetRtmResponse.ResponseElement.this;
                super();
            }
            };
        }
        if ("errorMessage".equals(s1))
        {
            return new ErrorMessageElement(this._cls0.this, "http://www.ebay.com/marketplace/mobileor/v1/commonservices");
        }
        if ("rtmContent".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetRtm.GetRtmResponse.ResponseElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if (EbayRtmApi.debugLogger.isLoggable)
                    {
                        EbayRtmApi.debugLogger.log(XmlFormatter.format(Base64.decode(s3, 0)));
                    }
                    rcr.rtmContentBase64 = s3;
                }

            
            {
                this$1 = GetRtm.GetRtmResponse.ResponseElement.this;
                super();
            }
            };
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private _cls2.this._cls1()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}
