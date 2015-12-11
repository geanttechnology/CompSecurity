// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyMessagesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.se.Summary
{

    final GetMyMessagesResponse this$0;

    public com.ebay.nautilus.kernel.util.se.Summary get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("FolderSummary".equals(s1))
            {
                return new mmary(GetMyMessagesResponse.this, null);
            }
            if ("NewMessageCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetMyMessagesResponse.Summary this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        newMessageCount = i;
                    }

            
            {
                this$1 = GetMyMessagesResponse.Summary.this;
                super();
            }
                };
            }
            if ("TotalMessageCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetMyMessagesResponse.Summary this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        totalMessageCount = i;
                    }

            
            {
                this$1 = GetMyMessagesResponse.Summary.this;
                super();
            }
                };
            }
        }
        return super.Summary(s, s1, s2, attributes);
    }

    private _cls2.this._cls1()
    {
        this$0 = GetMyMessagesResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
