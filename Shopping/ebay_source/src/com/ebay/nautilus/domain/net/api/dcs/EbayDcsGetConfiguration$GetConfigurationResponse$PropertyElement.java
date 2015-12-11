// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.dcs;

import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.dcs:
//            EbayDcsGetConfiguration

private final class <init> extends com.ebay.nautilus.kernel.util.lement
{

    private String name;
    final addIfReady this$0;
    private String value;

    private void addIfReady()
    {
        if (name != null && value != null)
        {
            this._cls0.this.value.put(name, value);
        }
    }

    public com.ebay.nautilus.kernel.util.lement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final EbayDcsGetConfiguration.GetConfigurationResponse.PropertyElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    setName(s3);
                }

            
            {
                this$1 = EbayDcsGetConfiguration.GetConfigurationResponse.PropertyElement.this;
                super();
            }
            };
        }
        if ("value".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final EbayDcsGetConfiguration.GetConfigurationResponse.PropertyElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    setValue(s3);
                }

            
            {
                this$1 = EbayDcsGetConfiguration.GetConfigurationResponse.PropertyElement.this;
                super();
            }
            };
        } else
        {
            return super.lement(s, s1, s2, attributes);
        }
    }

    void setName(String s)
    {
        name = new String(s);
        addIfReady();
    }

    void setValue(String s)
    {
        value = new String(s);
        addIfReady();
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
