// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.Duration;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

// Referenced classes of package com.ebay.mobile.notifications:
//            PollServiceListCache

private static final class timestamp extends com.ebay.nautilus.kernel.util.timestamp
{
    static final class Item extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final PollServiceListCache.WatchItemDates item;
        final long timestamp;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final Item this$0;

                    public void setValue(long l)
                        throws SAXException
                    {
                        item.id = l;
                    }

            
            {
                this$0 = Item.this;
                super();
            }
                };
            }
            if ("ListingDetails".equals(s1))
            {
                return new ListingDetails(null);
            }
            if ("TimeLeft".equals(s1) && timestamp != 0L && item.endDate == 0x7fffffffffffffffL)
            {
                return new TimeLeft(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public Item(PollServiceListCache.WatchItemDates watchitemdates, long l)
        {
            item = watchitemdates;
            timestamp = l;
        }
    }

    private final class Item.EndTime extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final Item this$0;

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

        private Item.EndTime()
        {
            this$0 = Item.this;
            super();
        }

        Item.EndTime(PollServiceListCache._cls1 _pcls1)
        {
            this();
        }
    }

    private final class Item.ListingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("EndTime".equals(s1))
            {
                return new Item.EndTime(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Item.ListingDetails()
        {
            this$0 = Item.this;
            super();
        }

        Item.ListingDetails(PollServiceListCache._cls1 _pcls1)
        {
            this();
        }
    }

    private final class Item.TimeLeft extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final Item this$0;

        public void text(String s)
            throws SAXException
        {
            try
            {
                Date date = new Date(timestamp);
                