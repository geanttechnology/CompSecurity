// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;

import com.ebay.common.util.EbayDateFormat;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.inventory:
//            GetLocationDetailsResponse

public static final class day extends com.ebay.nautilus.kernel.util.ent
{

    private final com.ebay.common.model.inventory.lement day;

    public com.ebay.nautilus.kernel.util.ent get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Date".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.DayElement this$0;

                public void text(String s3)
                    throws SAXException
                {
                    day.date = EbayDateFormat.parseInventoryDate(s3);
                }

            
            {
                this$0 = GetLocationDetailsResponse.DayElement.this;
                super();
            }
            };
        }
        if ("DayOfWeek".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetLocationDetailsResponse.DayElement this$0;

                protected void setValue(int i)
                    throws SAXException
                {
                    day.dayOfWeek = i + 1;
                    if (day.dayOfWeek == 8)
                    {
                        day.dayOfWeek = 1;
                    }
                }

            
            {
                this$0 = GetLocationDetailsResponse.DayElement.this;
                super();
            }
            };
        }
        if ("Interval".equals(s1))
        {
            s = new com.ebay.common.model.inventory.t();
            day.day.add(s);
            return new ment(s);
        } else
        {
            return super.lElement(s, s1, s2, attributes);
        }
    }


    public _cls2.this._cls0(com.ebay.common.model.inventory.t t)
    {
        day = t;
    }
}
