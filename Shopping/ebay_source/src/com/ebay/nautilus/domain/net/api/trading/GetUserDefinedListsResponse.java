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
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

public final class GetUserDefinedListsResponse extends EbayResponse
{
    private final class Item extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final UserDefinedList item;
        final GetUserDefinedListsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Name".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.name = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("ItemCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            try
                            {
                                item.count = Integer.parseInt(s);
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (String s)
                            {
                                throw new SAXNotRecognizedException(s.getLocalizedMessage());
                            }
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public Item()
        {
            this$0 = GetUserDefinedListsResponse.this;
            super();
            item = new UserDefinedList();
            lists.add(item);
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserDefinedListsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetUserDefinedListsResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(GetUserDefinedListsResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(GetUserDefinedListsResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("UserDefinedList".equals(s1))
                {
                    return new Item();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = GetUserDefinedListsResponse.this;
            super();
        }

    }

    public class UserDefinedList
    {

        public int count;
        public String name;
        final GetUserDefinedListsResponse this$0;

        public UserDefinedList()
        {
            this$0 = GetUserDefinedListsResponse.this;
            super();
        }
    }


    protected final List lists = new ArrayList();

    public GetUserDefinedListsResponse()
    {
    }

    public List getLists()
    {
        return lists;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
