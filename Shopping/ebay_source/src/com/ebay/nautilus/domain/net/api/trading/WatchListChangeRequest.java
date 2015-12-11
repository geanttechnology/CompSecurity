// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.EbayItemIdAndVariationSpecifics;
import com.ebay.nautilus.domain.data.ImmutableNameValue;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            EbayTradingRequest, WatchListChangeResponse, EbayTradingApi

public final class WatchListChangeRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{
    public static abstract class Change
    {

        final String operation;

        public static transient Change addItems(long al[])
        {
            return create(true, al);
        }

        public static transient Change addItems(EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
        {
            return create(true, aebayitemidandvariationspecifics);
        }

        public static transient Change create(boolean flag, long al[])
        {
            if (al == null || al.length == 0)
            {
                throw new IllegalArgumentException("ids is invalid");
            } else
            {
                return new Ids(flag, al);
            }
        }

        public static transient Change create(boolean flag, EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
        {
            if (aebayitemidandvariationspecifics == null || aebayitemidandvariationspecifics.length == 0)
            {
                throw new IllegalArgumentException("items is invalid");
            } else
            {
                return new Variations(flag, aebayitemidandvariationspecifics);
            }
        }

        public static Change removeAllItems()
        {
            return new RemoveAll();
        }

        public static transient Change removeItems(long al[])
        {
            return create(false, al);
        }

        public static transient Change removeItems(EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
        {
            return create(false, aebayitemidandvariationspecifics);
        }

        abstract void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException;

        Change(boolean flag)
        {
            String s;
            if (flag)
            {
                s = "AddToWatchList";
            } else
            {
                s = "RemoveFromWatchList";
            }
            operation = s;
        }
    }

    private static class Ids extends Change
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private final long data[];

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            long al[] = data;
            int j = al.length;
            for (int i = 0; i < j; i++)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemID", String.valueOf(al[i]));
            }

        }

        public Ids(boolean flag, long al[])
        {
            super(flag);
            data = al;
        }
    }

    private static class RemoveAll extends Change
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "RemoveAllItems", "true");
        }

        public RemoveAll()
        {
            super(false);
        }
    }

    private static class Variations extends Change
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private final EbayItemIdAndVariationSpecifics data[];

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[] = data;
            int j = aebayitemidandvariationspecifics.length;
            for (int i = 0; i < j; i++)
            {
                Object obj = aebayitemidandvariationspecifics[i];
                xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "VariationKey");
                XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemID", String.valueOf(((EbayItemIdAndVariationSpecifics) (obj)).id));
                xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "VariationSpecifics");
                for (obj = ((EbayItemIdAndVariationSpecifics) (obj)).variationSpecifics.iterator(); ((Iterator) (obj)).hasNext(); xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "NameValueList"))
                {
                    Object obj1 = (ImmutableNameValue)((Iterator) (obj)).next();
                    xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "NameValueList");
                    XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Name", ((ImmutableNameValue) (obj1)).name);
                    for (obj1 = ((ImmutableNameValue) (obj1)).values.iterator(); ((Iterator) (obj1)).hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Value", (String)((Iterator) (obj1)).next())) { }
                }

                xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "VariationSpecifics");
                xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "VariationKey");
            }

        }

        public Variations(boolean flag, EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
        {
            super(flag);
            data = aebayitemidandvariationspecifics;
        }
    }


    private final Change helper;

    public WatchListChangeRequest(EbayTradingApi ebaytradingapi, Change change)
    {
        super(ebaytradingapi, change.operation);
        helper = change;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        String s = (new StringBuilder()).append(getOperationName()).append("Request").toString();
        xmlserializer.setPrefix("", "urn:ebay:apis:eBLBaseComponents");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", s);
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        helper.buildXmlRequest(xmlserializer);
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", s);
    }

    public WatchListChangeResponse getResponse()
    {
        return new WatchListChangeResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
