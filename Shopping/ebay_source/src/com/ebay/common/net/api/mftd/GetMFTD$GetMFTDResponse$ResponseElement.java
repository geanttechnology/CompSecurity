// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mftd;

import com.ebay.common.model.mftd.MessageList;
import com.ebay.common.model.mftd.MessageListResult;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import java.text.ParseException;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.mftd:
//            GetMFTD

private final class <init> extends com.ebay.nautilus.kernel.util.init>
{

    final this._cls0 this$0;

    public com.ebay.nautilus.kernel.util.init> get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ack".equals(s1))
        {
            return new AckElement(this._cls0.this);
        }
        if ("version".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMFTD.GetMFTDResponse.ResponseElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    listResult.version = s3;
                }

            
            {
                this$1 = GetMFTD.GetMFTDResponse.ResponseElement.this;
                super();
            }
            };
        }
        if ("timestamp".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMFTD.GetMFTDResponse.ResponseElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    try
                    {
                        listResult.timestamp = EbayDateFormat.parse(s3);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s3)
                    {
                        throw new SAXNotRecognizedException(s3.getLocalizedMessage());
                    }
                }

            
            {
                this$1 = GetMFTD.GetMFTDResponse.ResponseElement.this;
                super();
            }
            };
        }
        if ("errorMessage".equals(s1))
        {
            return new ErrorMessageElement(this._cls0.this, "http://www.ebay.com/marketplace/mobile/v1/services");
        }
        if ("messageList".equals(s1))
        {
            s = new MessageList();
            this._mth0(this._cls0.this).add(s);
            return new t>(this._cls0.this, s);
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
