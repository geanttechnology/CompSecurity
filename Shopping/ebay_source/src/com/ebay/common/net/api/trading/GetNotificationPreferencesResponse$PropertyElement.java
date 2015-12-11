// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.data.NameValue;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetNotificationPreferencesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.t
{

    final GetNotificationPreferencesResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetNotificationPreferencesResponse.PropertyElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    property.setName(s3);
                }

            
            {
                this$1 = GetNotificationPreferencesResponse.PropertyElement.this;
                super();
            }
            };
        }
        if ("Value".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetNotificationPreferencesResponse.PropertyElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    property.addValue(s3);
                }

            
            {
                this$1 = GetNotificationPreferencesResponse.PropertyElement.this;
                super();
            }
            };
        } else
        {
            return super.t(s, s1, s2, attributes);
        }
    }

    private _cls2.this._cls1()
    {
        this$0 = GetNotificationPreferencesResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
