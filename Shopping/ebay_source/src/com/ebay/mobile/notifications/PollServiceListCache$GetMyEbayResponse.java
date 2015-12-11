// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.Duration;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

// Referenced classes of package com.ebay.mobile.notifications:
//            PollServiceListCache

private static final class <init> extends EbayResponse
{
    private static final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        ListElement bidList;
        private final PollServiceListCache.GetMyEbayResponse response;
        private final TimestampElement timestamp;
        ListElement watchList;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(response);
                }
                if ("Timestamp".equals(s1))
                {
                    return timestamp;
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(response, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("BidList".equals(s1))
                {
                    s = new ListElement(1, timestamp.hostTime);
                    bidList = s;
                    return s;
                }
                if ("WatchList".equals(s1))
                {
                    s = new ListElement(200, timestamp.hostTime);
                    watchList = s;
                    return s;
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public RootElement(PollServiceListCache.GetMyEbayResponse getmyebayresponse)
        {
            bidList = null;
            watchList = null;
            response = getmyebayresponse;
            timestamp = new TimestampElement(getmyebayresponse);
        }
    }

    static final class RootElement.Item extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final PollServiceListCache.WatchItemDates item;
        final long timestamp;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final RootElement.Item this$0;

                    public void setValue(long l)
                        throws SAXException
                    {
                        item.id = l;
                    }

            
            {
                this$0 = RootElement.Item.this;
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

        public RootElement.Item(PollServiceListCache.WatchItemDates watchitemdates, long l)
        {
            item = watchitemdates;
            timestamp = l;
        }
    }

    private final class RootElement.Item.EndTime extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final RootElement.Item this$0;

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

        private RootElement.Item.EndTime()
        {
            this$0 = RootElement.Item.this;
            super();
        }

        RootElement.Item.EndTime(PollServiceListCache._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement.Item.ListingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("EndTime".equals(s1))
            {
                return new RootElement.Item.EndTime(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.Item.ListingDetails()
        {
            this$0 = RootElement.Item.this;
            super();
        }

        RootElement.Item.ListingDetails(PollServiceListCache._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement.Item.TimeLeft extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final RootElement.Item this$0;

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

        private RootElement.Item.TimeLeft()
        {
            this$0 = RootElement.Item.this;
            super();
        }

        RootElement.Item.TimeLeft(PollServiceListCache._cls1 _pcls1)
        {
            this();
        }
    }

    private static final class RootElement.ListElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public ArrayList items;
        private final int maxItemCount;
        private final long timestamp;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ItemArray".equals(s1))
            {
                s = new ArrayList(maxItemCount);
                items = s;
                return new ItemArray(s, timestamp);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.ListElement(int i, long l)
        {
            items = null;
            maxItemCount = i;
            timestamp = l;
        }
    }

    private static final class RootElement.ListElement.ItemArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final ArrayList items;
        private final long timestamp;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Item".equals(s1))
            {
                s = new PollServiceListCache.WatchItemDates();
                items.add(s);
                return new RootElement.Item(s, timestamp);
            } else
            {
                return super.get(s,