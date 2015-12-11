// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyMessagesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.se.Message
{
    private final class Folder extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyMessagesResponse.Message this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "FolderID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final Folder this$2;

                    public void setValue(long l)
                        throws SAXException
                    {
                        builder.folderId(l);
                    }

            
            {
                this$2 = Folder.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Folder()
        {
            this$1 = GetMyMessagesResponse.Message.this;
            super();
        }

        Folder(GetMyMessagesResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ResponseDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyMessagesResponse.Message this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "ResponseEnabled".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final ResponseDetails this$2;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        builder.responseEnabled(flag);
                    }

            
            {
                this$2 = ResponseDetails.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseDetails()
        {
            this$1 = GetMyMessagesResponse.Message.this;
            super();
        }

        ResponseDetails(GetMyMessagesResponse._cls1 _pcls1)
        {
            this();
        }
    }


    com.ebay.nautilus.domain.data.se.Message.builder builder;
    final GetMyMessagesResponse this$0;

    public void endElement()
        throws SAXException
    {
        super.Message();
        messages.add(getEbayMessage());
    }

    public com.ebay.nautilus.kernel.util.se.Message get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("ExternalMessageID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMyMessagesResponse.Message this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        builder.externalMessageId(s3);
                    }

            
            {
                this$1 = GetMyMessagesResponse.Message.this;
                super();
            }
                };
            }
            if ("Flagged".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetMyMessagesResponse.Message this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        builder.flagged(flag);
                    }

            
            {
                this$1 = GetMyMessagesResponse.Message.this;
                super();
            }
                };
            }
            if ("Folder".equals(s1))
            {
                return new Folder(null);
            }
            if ("HighPriority".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetMyMessagesResponse.Message this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        builder.highPriority(flag);
                    }

            
            {
                this$1 = GetMyMessagesResponse.Message.this;
                super();
            }
                };
            }
            if ("ItemEndTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMyMessagesResponse.Message this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        builder.itemEndDate(EbayDateUtils.parseXml(s3));
                    }

            
            {
                this$1 = GetMyMessagesResponse.Message.this;
                super();
            }
                };
            }
            if ("ItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetMyMessagesResponse.Message this$1;

                    public void setValue(long l)
                        throws SAXException
                    {
                        builder.itemId(l);
                    }

            
            {
                this$1 = GetMyMessagesResponse.Message.this;
                super();
            }
                };
            }
            if ("ItemTitle".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMyMessagesResponse.Message this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        builder.itemTitle(s3);
                    }

            
            {
                this$1 = GetMyMessagesResponse.Message.this;
                super();
            }
                };
            }
            if ("MessageID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMyMessagesResponse.Message this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        builder.messageId(s3);
                    }

            
            {
                this$1 = GetMyMessagesResponse.Message.this;
                super();
            }
                };
            }
            if ("Read".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetMyMessagesResponse.Message this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        builder.read(flag);
                    }

            
            {
                this$1 = GetMyMessagesResponse.Message.this;
                super();
            }
                };
            }
            if ("ReceiveDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMyMessagesResponse.Message this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        builder.receiveDate(EbayDateUtils.parseXml(s3));
                    }

            
            {
                this$1 = GetMyMessagesResponse.Message.this;
                super();
            }
                };
            }
            if ("Replied".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetMyMessagesResponse.Message this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        builder.replied(flag);
                    }

            
            {
                this$1 = GetMyMessagesResponse.Message.this;
                super();
            }
                };
            }
            if ("Sender".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMyMessagesResponse.Message this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        builder.sender(s3);
                    }

            
            {
                this$1 = GetMyMessagesResponse.Message.this;
                super();
            }
                };
            }
            if ("SendToName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMyMessagesResponse.Message this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        builder.sendToName(s3);
                    }

            
            {
                this$1 = GetMyMessagesResponse.Message.this;
                super();
            }
                };
            }
            if ("Subject".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMyMessagesResponse.Message this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        builder.subject(s3);
                    }

            
            {
                this$1 = GetMyMessagesResponse.Message.this;
                super();
            }
                };
            }
            if ("Text".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMyMessagesResponse.Message this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        builder.text(s3);
                    }

            
            {
                this$1 = GetMyMessagesResponse.Message.this;
                super();
            }
                };
            }
            if ("ResponseDetails".equals(s1))
            {
                return new ResponseDetails(null);
            }
        }
        return super._mth1(s, s1, s2, attributes);
    }

    public EbayMessage getEbayMessage()
    {
        return builder.builder();
    }

    private _cls9.this._cls1()
    {
        this$0 = GetMyMessagesResponse.this;
        super();
        builder = new com.ebay.nautilus.domain.data.se.Message.builder();
    }

    builder(builder builder1)
    {
        this();
    }
}
