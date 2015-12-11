// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.MessageFolder;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyMessagesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.derSummary
{

    com.ebay.nautilus.domain.data.derSummary.builder builder;
    final GetMyMessagesResponse this$0;

    public void endElement()
        throws SAXException
    {
        super.derSummary();
        folders.add(getMessageFolder());
    }

    public com.ebay.nautilus.kernel.util.derSummary get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("FolderID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetMyMessagesResponse.FolderSummary this$1;

                    public void setValue(long l)
                        throws SAXException
                    {
                        builder.folderId(l);
                    }

            
            {
                this$1 = GetMyMessagesResponse.FolderSummary.this;
                super();
            }
                };
            }
            if ("FolderName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMyMessagesResponse.FolderSummary this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        builder.folderName(s3);
                    }

            
            {
                this$1 = GetMyMessagesResponse.FolderSummary.this;
                super();
            }
                };
            }
            if ("NewMessageCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetMyMessagesResponse.FolderSummary this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        builder.newMessageCount(i);
                    }

            
            {
                this$1 = GetMyMessagesResponse.FolderSummary.this;
                super();
            }
                };
            }
            if ("TotalMessageCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetMyMessagesResponse.FolderSummary this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        builder.totalMessageCount(i);
                    }

            
            {
                this$1 = GetMyMessagesResponse.FolderSummary.this;
                super();
            }
                };
            }
        }
        return super.derSummary(s, s1, s2, attributes);
    }

    public MessageFolder getMessageFolder()
    {
        return builder.builder();
    }

    private _cls4.this._cls1()
    {
        this$0 = GetMyMessagesResponse.this;
        super();
        builder = new com.ebay.nautilus.domain.data.derSummary.builder();
    }

    builder(builder builder1)
    {
        this();
    }
}
