// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.dcs;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.dcs:
//            EbayDcsGetConfiguration

private final class <init> extends com.ebay.nautilus.kernel.util.lement
{

    final this._cls0 this$0;

    public com.ebay.nautilus.kernel.util.lement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final EbayDcsGetConfiguration.GetConfigurationResponse.ConfigurationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    configName = s3;
                }

            
            {
                this$1 = EbayDcsGetConfiguration.GetConfigurationResponse.ConfigurationElement.this;
                super();
            }
            };
        }
        if ("property".equals(s1))
        {
            return new >(this._cls0.this, null);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private _cls1.this._cls1()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}
