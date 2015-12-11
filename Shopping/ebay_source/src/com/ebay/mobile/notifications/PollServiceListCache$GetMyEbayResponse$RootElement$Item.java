// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.Duration;
import java.text.ParseException;
import java.util.Date;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

// Referenced classes of package com.ebay.mobile.notifications:
//            PollServiceListCache

static final class timestamp extends com.ebay.nautilus.kernel.util.timestamp
{
    private final class EndTime extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final PollServiceListCache.GetMyEbayResponse.RootElement.Item this$0;

        public void text(String s)
            throws SAXException
        {
            try
            {
                s = EbayDateFormat.parse(s);
                item.endDate = s.getTime();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotRecognizedException(s.getLocalizedMessage());
            }
        }

        private EndTime()
        {
            this$0 = PollServiceListCache.GetMyEbayResponse.RootElement.Item.this;
            super();
        }

        EndTime(PollServiceListCache._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ListingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final PollServiceListCache.GetMyEbayResponse.RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("EndTime".equals(s1))
            {
                return new EndTime(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ListingDetails()
        {
            this$0 = PollServiceListCache.GetMyEbayResponse.RootElement.Item.this;
            super();
        }

        ListingDetails(PollServiceListCache._cls1 _pcls1)
        {
            this();
        }
    }

    private final class TimeLeft extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final PollServiceListCache.GetMyEbayResponse.RootElement.Item this$0;

        public void text(String s)
            throws SAXException
        {
            try
            {
                Date date = new Date(timestamp);
                s = Duration.parse(s, date).getEndFromStart(date);
                item.endDate = s.getTime();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotSupportedException(s.getLocalizedMessage());
            }
        }

        private TimeLeft()
        {
            this$0 = PollServiceListCache.GetMyEbayResponse.RootElement.Item.this;
            super();
        }

        TimeLeft(PollServiceListCache._cls1 _pcls1)
        {
            this();
        }
    }


    final TimeLeft item;
    final long timestamp;

    public com.ebay.nautilus.kernel.util.item get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ItemID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final PollServiceListCache.GetMyEbayResponse.RootElement.Item this$0;

                public void setValue(long l)
                    throws SAXException
                {
                    item.id = l;
                }

            
            {
                this$0 = PollServiceListCache.GetMyEbayResponse.RootElement.Item.this;
                super();
            }
            };
        }
        if ("ListingDetails".equals(s1))
        {
            return new ListingDetails(null);
        }
        if ("TimeLeft".equals(s1) && timestamp != 0L && item.item == 0x7fffffffffffffffL)
        {
            return new TimeLeft(null);
        } else
        {
            return super.TimeLeft(s, s1, s2, attributes);
        }
    }

    public _cls1.this._cls0(_cls1.this._cls0 _pcls0, long l)
    {
        item = _pcls0;
        timestamp = l;
    }
}
