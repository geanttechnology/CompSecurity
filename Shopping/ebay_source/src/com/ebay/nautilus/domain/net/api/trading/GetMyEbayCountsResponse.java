// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

public final class GetMyEbayCountsResponse extends EbayResponse
{
    public static final class ListCount
    {

        public int count;

        public ListCount()
        {
        }
    }

    private static final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ListElement listElement = new ListElement();
        final GetMyEbayCountsResponse response;

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
                    return new TimestampElement(response);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(response, "urn:ebay:apis:eBLBaseComponents");
                }
                ListCount listcount = (ListCount)response.counts.get(s1);
                if (listcount != null)
                {
                    return listElement.set(listcount);
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public RootElement(GetMyEbayCountsResponse getmyebaycountsresponse)
        {
            response = getmyebaycountsresponse;
        }
    }

    private static final class RootElement.ListElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected ListCount data;
        private final com.ebay.nautilus.kernel.util.SaxHandler.Element pagination;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("PaginationResult".equals(s1))
            {
                return pagination;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public final RootElement.ListElement set(ListCount listcount)
        {
            data = listcount;
            return this;
        }

        private RootElement.ListElement()
        {
            data = null;
            pagination = new _cls1();
        }

    }


    public final HashMap counts;

    public GetMyEbayCountsResponse(Set set)
    {
        counts = new HashMap(set.size());
        String s;
        for (set = set.iterator(); set.hasNext(); counts.put(s, new ListCount()))
        {
            s = (String)set.next();
        }

    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement(this));
    }

    // Unreferenced inner class com/ebay/nautilus/domain/net/api/trading/GetMyEbayCountsResponse$RootElement$ListElement$1

/* anonymous class */
    class RootElement.ListElement._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.nautilus.kernel.util.SaxHandler.TextElement entries = new _cls1();
        final RootElement.ListElement this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("TotalNumberOfEntries".equals(s1))
            {
                return entries;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$0 = RootElement.ListElement.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/nautilus/domain/net/api/trading/GetMyEbayCountsResponse$RootElement$ListElement$1$1

/* anonymous class */
    class RootElement.ListElement._cls1._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final RootElement.ListElement._cls1 this$1;

        public void text(String s)
            throws SAXException
        {
            try
            {
    class RootElement.ListElement._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.nautilus.kernel.util.SaxHandler.TextElement entries = new _cls1();
        final RootElement.ListElement this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("TotalNumberOfEntries".equals(s1))
            {
                return entries;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$0 = RootElement.ListElement.this;
                super();
            }
    }

                data.count = Integer.parseInt(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotRecognizedException(s.getLocalizedMessage());
            }
        }

            
            {
                this$1 = RootElement.ListElement._cls1.this;
                super();
            }
    }

}
