// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetUserProfileResponse

static class periodInDays extends com.ebay.nautilus.kernel.util.dbackPeriod
{

    public long count;
    public int periodInDays;

    public com.ebay.nautilus.kernel.util.dbackPeriod get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Count".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final GetUserProfileResponse.FeedbackPeriod this$0;

                public void setValue(long l)
                    throws SAXException
                {
                    count = l;
                }

            
            {
                this$0 = GetUserProfileResponse.FeedbackPeriod.this;
                super();
            }
            };
        }
        if ("PeriodInDays".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserProfileResponse.FeedbackPeriod this$0;

                public void setValue(int i)
                    throws SAXException
                {
                    periodInDays = i;
                }

            
            {
                this$0 = GetUserProfileResponse.FeedbackPeriod.this;
                super();
            }
            };
        } else
        {
            return super.dbackPeriod(s, s1, s2, attributes);
        }
    }

    _cls2.this._cls0()
    {
        count = -1L;
        periodInDays = -1;
    }
}
