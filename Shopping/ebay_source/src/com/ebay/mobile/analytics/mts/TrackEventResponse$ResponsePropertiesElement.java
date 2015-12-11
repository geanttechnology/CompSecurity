// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics.mts;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.analytics.mts:
//            TrackEventResponse, AnalyticsProviderModule

private final class <init> extends com.ebay.nautilus.kernel.util.<init>
{

    String lastKey;
    final TrackEventResponse this$0;

    public com.ebay.nautilus.kernel.util.<init> get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("key".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final TrackEventResponse.ResponsePropertiesElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    lastKey = s3;
                }

            
            {
                this$1 = TrackEventResponse.ResponsePropertiesElement.this;
                super();
            }
            };
        }
        if ("value".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final TrackEventResponse.ResponsePropertiesElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if ("rovercookie".equals(lastKey))
                    {
                        AnalyticsProviderModule.saveCookie(TrackEventResponse.access$400(this$0), s3);
                    }
                }

            
            {
                this$1 = TrackEventResponse.ResponsePropertiesElement.this;
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
        this$0 = TrackEventResponse.this;
        super();
        lastKey = "";
    }

    lastKey(lastKey lastkey)
    {
        this();
    }
}
