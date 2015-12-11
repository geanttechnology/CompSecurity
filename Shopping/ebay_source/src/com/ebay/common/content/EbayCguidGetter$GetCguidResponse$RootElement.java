// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.content:
//            EbayCguidGetter

private final class <init> extends com.ebay.nautilus.kernel.util.
{

    final this._cls0 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/mobileor/v1/commonservices".equals(s))
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(this._cls0.this);
            }
            if ("Timestamp".equals(s1))
            {
                return new TimestampElement(this._cls0.this);
            }
            if ("Fault".equals(s1))
            {
                return new (this._cls0.this, null);
            }
            if ("cguid".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final EbayCguidGetter.GetCguidResponse.RootElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        EbayCguidGetter.GetCguidResponse.access$002(this$0, s3);
                    }

            
            {
                this$1 = EbayCguidGetter.GetCguidResponse.RootElement.this;
                super();
            }
                };
            }
            if ("expire".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final EbayCguidGetter.GetCguidResponse.RootElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        EbayCguidGetter.GetCguidResponse.access$102(this$0, s3);
                    }

            
            {
                this$1 = EbayCguidGetter.GetCguidResponse.RootElement.this;
                super();
            }
                };
            }
            if ("linked".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final EbayCguidGetter.GetCguidResponse.RootElement this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        EbayCguidGetter.GetCguidResponse.access$402(this$0, Boolean.valueOf(flag));
                    }

            
            {
                this$1 = EbayCguidGetter.GetCguidResponse.RootElement.this;
                super();
            }
                };
            }
        }
        return super.(s, s1, s2, attributes);
    }

    private _cls3.this._cls1()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}
