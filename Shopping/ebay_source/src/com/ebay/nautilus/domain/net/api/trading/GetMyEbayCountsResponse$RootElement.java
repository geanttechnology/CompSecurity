// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayCountsResponse

private static final class response extends com.ebay.nautilus.kernel.util.ootElement
{
    private static final class ListElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected GetMyEbayCountsResponse.ListCount data;
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

        public final ListElement set(GetMyEbayCountsResponse.ListCount listcount)
        {
            data = listcount;
            return this;
        }

        private ListElement()
        {
            data = null;
            pagination = new _cls1();
        }

        ListElement(GetMyEbayCountsResponse._cls1 _pcls1)
        {
            this();
        }
    }


    final ListElement listElement = new ListElement(null);
    final GetMyEbayCountsResponse response;

    public com.ebay.nautilus.kernel.util.ootElement get(String s, String s1, String s2, Attributes attributes)
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
            ListElement.data data = (response)response.counts.get(s1);
            if (data != null)
            {
                return listElement.set(data);
            }
        }
        return super.istCount(s, s1, s2, attributes);
    }

    public ListElement(GetMyEbayCountsResponse getmyebaycountsresponse)
    {
        response = getmyebaycountsresponse;
    }

    // Unreferenced inner class com/ebay/nautilus/domain/net/api/trading/GetMyEbayCountsResponse$RootElement$ListElement$1

/* anonymous class */
    class ListElement._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.nautilus.kernel.util.SaxHandler.TextElement entries = new _cls1();
        final ListElement this$0;

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
                this$0 = ListElement.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/nautilus/domain/net/api/trading/GetMyEbayCountsResponse$RootElement$ListElement$1$1

/* anonymous class */
    class ListElement._cls1._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ListElement._cls1 this$1;

        public void text(String s)
            throws SAXException
        {
            try
            {
    class ListElement._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.nautilus.kernel.util.SaxHandler.TextElement entries = new _cls1();
        final ListElement this$0;

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
                this$0 = ListElement.this;
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
                this$1 = ListElement._cls1.this;
                super();
            }
    }

}
