// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mftd;

import com.ebay.common.model.mftd.MessageList;
import com.ebay.common.util.EbayDateFormat;
import java.text.ParseException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.mftd:
//            GetMFTD

private final class ml extends com.ebay.nautilus.kernel.util.l
{

    MessageList ml;
    final ml this$0;

    public com.ebay.nautilus.kernel.util.l get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("messageId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMFTD.GetMFTDResponse.MainElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    ml.messageId = i;
                }

            
            {
                this$1 = GetMFTD.GetMFTDResponse.MainElement.this;
                super();
            }
            };
        }
        if ("message".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMFTD.GetMFTDResponse.MainElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    ml.message = s3;
                }

            
            {
                this$1 = GetMFTD.GetMFTDResponse.MainElement.this;
                super();
            }
            };
        }
        if ("messageType".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMFTD.GetMFTDResponse.MainElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    ml.messageType = s3;
                }

            
            {
                this$1 = GetMFTD.GetMFTDResponse.MainElement.this;
                super();
            }
            };
        }
        if ("contentType".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMFTD.GetMFTDResponse.MainElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    ml.contentType = s3;
                }

            
            {
                this$1 = GetMFTD.GetMFTDResponse.MainElement.this;
                super();
            }
            };
        }
        if ("maxNumberOfViews".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMFTD.GetMFTDResponse.MainElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    ml.maxNumberOfViews = i;
                }

            
            {
                this$1 = GetMFTD.GetMFTDResponse.MainElement.this;
                super();
            }
            };
        }
        if ("validFromTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMFTD.GetMFTDResponse.MainElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    try
                    {
                        ml.validFromTime = EbayDateFormat.parse(s3);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s3)
                    {
                        throw new SAXNotRecognizedException(s3.getLocalizedMessage());
                    }
                }

            
            {
                this$1 = GetMFTD.GetMFTDResponse.MainElement.this;
                super();
            }
            };
        }
        if ("validToTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMFTD.GetMFTDResponse.MainElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    try
                    {
                        ml.validToTime = EbayDateFormat.parse(s3);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s3)
                    {
                        throw new SAXNotRecognizedException(s3.getLocalizedMessage());
                    }
                }

            
            {
                this$1 = GetMFTD.GetMFTDResponse.MainElement.this;
                super();
            }
            };
        } else
        {
            return super.l(s, s1, s2, attributes);
        }
    }

    protected _cls7.this._cls1(MessageList messagelist)
    {
        this$0 = this._cls0.this;
        super();
        ml = messagelist;
    }
}
