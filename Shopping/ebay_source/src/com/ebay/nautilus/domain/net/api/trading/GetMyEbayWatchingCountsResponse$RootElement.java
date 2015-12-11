// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayWatchingCountsResponse

private static final class response extends com.ebay.nautilus.kernel.util.ootElement
{
    private static final class ListElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final GetMyEbayWatchingCountsResponse.ResponseUserDefinedList data;
        private final com.ebay.nautilus.kernel.util.SaxHandler.Element pagination = new _cls1();

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

        public ListElement(GetMyEbayWatchingCountsResponse.ResponseUserDefinedList responseuserdefinedlist)
        {
            data = responseuserdefinedlist;
        }
    }

    private static final class UserDefinedListElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final GetMyEbayWatchingCountsResponse.ResponseUserDefinedList list;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ItemCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final UserDefinedListElement this$0;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        list.count = i;
                    }

            
            {
                this$0 = UserDefinedListElement.this;
                super();
            }
                };
            }
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final UserDefinedListElement this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        list.name = s;
                    }

            
            {
                this$0 = UserDefinedListElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public UserDefinedListElement(GetMyEbayWatchingCountsResponse.ResponseUserDefinedList responseuserdefinedlist)
        {
            list = responseuserdefinedlist;
        }
    }


    final GetMyEbayWatchingCountsResponse response;

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
            if ("WatchList".equals(s1))
            {
                return new ListElement((DefinedList)response.userDefinedLists.get(0));
            }
            if ("UserDefinedList".equals(s1))
            {
                s = new DefinedList();
                response.userDefinedLists.add(s);
                return new UserDefinedListElement(s);
            }
        }
        return super.esponseUserDefinedList(s, s1, s2, attributes);
    }

    public UserDefinedListElement.list(GetMyEbayWatchingCountsResponse getmyebaywatchingcountsresponse)
    {
        response = getmyebaywatchingcountsresponse;
    }

    // Unreferenced inner class com/ebay/nautilus/domain/net/api/trading/GetMyEbayWatchingCountsResponse$RootElement$ListElement$1

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


    // Unreferenced inner class com/ebay/nautilus/domain/net/api/trading/GetMyEbayWatchingCountsResponse$RootElement$ListElement$1$1

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
