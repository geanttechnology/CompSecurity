// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.aps:
//            GetUserActivitySummary, UserActivitySummary

private final class <init> extends com.ebay.nautilus.kernel.util.nit>
{

    final this._cls0 this$0;

    public com.ebay.nautilus.kernel.util.nit> get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("newAlertCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.MessageSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).messagesNewAlertCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.MessageSummaryElement.this;
                super();
            }
            };
        }
        if ("newMessageCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.MessageSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).messagesNewMessageCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.MessageSummaryElement.this;
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
