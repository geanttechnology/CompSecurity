// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.data.MessageFolder;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class GetMyMessagesResponse extends EbayResponse
{
    private final class FolderSummary extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.domain.data.MessageFolder.Builder builder;
        final GetMyMessagesResponse this$0;

        public void endElement()
            throws SAXException
        {
            super.endElement();
            folders.add(getMessageFolder());
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("FolderID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final FolderSummary this$1;

                        public void setValue(long l)
                            throws SAXException
                        {
                            builder.folderId(l);
                        }

            
            {
                this$1 = FolderSummary.this;
                super();
            }
                    };
                }
                if ("FolderName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final FolderSummary this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            builder.folderName(s);
                        }

            
            {
                this$1 = FolderSummary.this;
                super();
            }
                    };
                }
                if ("NewMessageCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final FolderSummary this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            builder.newMessageCount(i);
                        }

            
            {
                this$1 = FolderSummary.this;
                super();
            }
                    };
                }
                if ("TotalMessageCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final FolderSummary this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            builder.totalMessageCount(i);
                        }

            
            {
                this$1 = FolderSummary.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public MessageFolder getMessageFolder()
        {
            return builder.build();
        }

        private FolderSummary()
        {
            this$0 = GetMyMessagesResponse.this;
            super();
            builder = new com.ebay.nautilus.domain.data.MessageFolder.Builder();
        }

    }

    private final class Message extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.domain.data.EbayMessage.Builder builder;
        final GetMyMessagesResponse this$0;

        public void endElement()
            throws SAXException
        {
            super.endElement();
            messages.add(getEbayMessage());
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("ExternalMessageID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Message this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            builder.externalMessageId(s);
                        }

            
            {
                this$1 = Message.this;
                super();
            }
                    };
                }
                if ("Flagged".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Message this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            builder.flagged(flag);
                        }

            
            {
                this$1 = Message.this;
                super();
            }
                    };
                }
                if ("Folder".equals(s1))
                {
                    return new Folder();
                }
                if ("HighPriority".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Message this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            builder.highPriority(flag);
                        }

            
            {
                this$1 = Message.this;
                super();
            }
                    };
                }
                if ("ItemEndTime".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Message this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            builder.itemEndDate(EbayDateUtils.parseXml(s));
                        }

            
            {
                this$1 = Message.this;
                super();
            }
                    };
                }
                if ("ItemID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final Message this$1;

                        public void setValue(long l)
                            throws SAXException
                        {
                            builder.itemId(l);
                        }

            
            {
                this$1 = Message.this;
                super();
            }
                    };
                }
                if ("ItemTitle".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Message this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            builder.itemTitle(s);
                        }

            
            {
                this$1 = Message.this;
                super();
            }
                    };
                }
                if ("MessageID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Message this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            builder.messageId(s);
                        }

            
            {
                this$1 = Message.this;
                super();
            }
                    };
                }
                if ("Read".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Message this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            builder.read(flag);
                        }

            
            {
                this$1 = Message.this;
                super();
            }
                    };
                }
                if ("ReceiveDate".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Message this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            builder.receiveDate(EbayDateUtils.parseXml(s));
                        }

            
            {
                this$1 = Message.this;
                super();
            }
                    };
                }
                if ("Replied".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Message this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            builder.replied(flag);
                        }

            
            {
                this$1 = Message.this;
                super();
            }
                    };
                }
                if ("Sender".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Message this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            builder.sender(s);
                        }

            
            {
                this$1 = Message.this;
                super();
            }
                    };
                }
                if ("SendToName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Message this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            builder.sendToName(s);
                        }

            
            {
                this$1 = Message.this;
                super();
            }
                    };
                }
                if ("Subject".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Message this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            builder.subject(s);
                        }

            
            {
                this$1 = Message.this;
                super();
            }
                    };
                }
                if ("Text".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Message this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            builder.text(s);
                        }

            
            {
                this$1 = Message.this;
                super();
            }
                    };
                }
                if ("ResponseDetails".equals(s1))
                {
                    return new ResponseDetails();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public EbayMessage getEbayMessage()
        {
            return builder.build();
        }

        private Message()
        {
            this$0 = GetMyMessagesResponse.this;
            super();
            builder = new com.ebay.nautilus.domain.data.EbayMessage.Builder();
        }

    }

    private final class Message.Folder extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Message this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "FolderID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final Message.Folder this$2;

                    public void setValue(long l)
                        throws SAXException
                    {
                        builder.folderId(l);
                    }

            
            {
                this$2 = Message.Folder.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Message.Folder()
        {
            this$1 = Message.this;
            super();
        }

    }

    private final class Message.ResponseDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Message this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "ResponseEnabled".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final Message.ResponseDetails this$2;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        builder.responseEnabled(flag);
                    }

            
            {
                this$2 = Message.ResponseDetails.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Message.ResponseDetails()
        {
            this$1 = Message.this;
            super();
        }

    }

    private final class Messages extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyMessagesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "Message".equals(s1))
            {
                return new Message();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Messages()
        {
            this$0 = GetMyMessagesResponse.this;
            super();
        }

    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyMessagesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetMyMessagesResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(GetMyMessagesResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(GetMyMessagesResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("Summary".equals(s1))
                {
                    return new Summary();
                }
                if ("Messages".equals(s1))
                {
                    return new Messages();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = GetMyMessagesResponse.this;
            super();
        }

    }

    private final class Summary extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyMessagesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("FolderSummary".equals(s1))
                {
                    return new FolderSummary();
                }
                if ("NewMessageCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Summary this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            newMessageCount = i;
                        }

            
            {
                this$1 = Summary.this;
                super();
            }
                    };
                }
                if ("TotalMessageCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Summary this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            totalMessageCount = i;
                        }

            
            {
                this$1 = Summary.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Summary()
        {
            this$0 = GetMyMessagesResponse.this;
            super();
        }

    }


    public List folders;
    public List messages;
    public int newMessageCount;
    public int totalMessageCount;

    public GetMyMessagesResponse()
    {
        newMessageCount = -1;
        totalMessageCount = -1;
        folders = new ArrayList();
        messages = new ArrayList();
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
