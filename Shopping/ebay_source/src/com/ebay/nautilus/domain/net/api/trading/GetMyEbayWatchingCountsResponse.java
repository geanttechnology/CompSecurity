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
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

public final class GetMyEbayWatchingCountsResponse extends EbayResponse
{
    public static final class ResponseUserDefinedList
    {

        public int count;
        public String name;

        public ResponseUserDefinedList()
        {
        }
    }

    private static final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyEbayWatchingCountsResponse response;

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
                if ("WatchList".equals(s1))
                {
                    return new ListElement((ResponseUserDefinedList)response.userDefinedLists.get(0));
                }
                if ("UserDefinedList".equals(s1))
                {
                    s = new ResponseUserDefinedList();
                    response.userDefinedLists.add(s);
                    return new UserDefinedListElement(s);
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public RootElement(GetMyEbayWatchingCountsResponse getmyebaywatchingcountsresponse)
        {
            response = getmyebaywatchingcountsresponse;
        }
    }

    private static final class RootElement.ListElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final ResponseUserDefinedList data;
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

        public RootElement.ListElement(ResponseUserDefinedList responseuserdefinedlist)
        {
            data = responseuserdefinedlist;
        }
    }

    private static final class RootElement.UserDefinedListElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final ResponseUserDefinedList list;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ItemCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.UserDefinedListElement this$0;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        list.count = i;
                    }

            
            {
                this$0 = RootElement.UserDefinedListElement.this;
                super();
            }
                };
            }
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.UserDefinedListElement this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        list.name = s;
                    }

            
            {
                this$0 = RootElement.UserDefinedListElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.UserDefinedListElement(ResponseUserDefinedList responseuserdefinedlist)
        {
            list = responseuserdefinedlist;
        }
    }


    public ArrayList userDefinedLists;

    public GetMyEbayWatchingCountsResponse()
    {
        userDefinedLists = new ArrayList();
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        ResponseUserDefinedList responseuserdefinedlist = new ResponseUserDefinedList();
        responseuserdefinedlist.name = "";
        userDefinedLists.add(responseuserdefinedlist);
        SaxHandler.parseXml(inputstream, new RootElement(this));
    }

    // Unreferenced inner class com/ebay/nautilus/domain/net/api/trading/GetMyEbayWatchingCountsResponse$RootElement$ListElement$1

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


    // Unreferenced inner class com/ebay/nautilus/domain/net/api/trading/GetMyEbayWatchingCountsResponse$RootElement$ListElement$1$1

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
