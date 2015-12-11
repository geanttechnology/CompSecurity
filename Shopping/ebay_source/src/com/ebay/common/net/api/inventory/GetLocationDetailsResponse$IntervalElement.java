// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.inventory:
//            GetLocationDetailsResponse

public static final class interval extends com.ebay.nautilus.kernel.util.ent
{

    private final com.ebay.common.model.inventory.t interval;

    public com.ebay.nautilus.kernel.util.ent get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Open".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.IntervalElement this$0;

                public void text(String s3)
                    throws SAXException
                {
                    interval.open = s3;
                }

            
            {
                this$0 = GetLocationDetailsResponse.IntervalElement.this;
                super();
            }
            };
        }
        if ("Close".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.IntervalElement this$0;

                public void text(String s3)
                    throws SAXException
                {
                    interval.close = s3;
                }

            
            {
                this$0 = GetLocationDetailsResponse.IntervalElement.this;
                super();
            }
            };
        } else
        {
            return super.ent(s, s1, s2, attributes);
        }
    }


    public _cls2.this._cls0(com.ebay.common.model.inventory.t t)
    {
        interval = t;
    }
}
