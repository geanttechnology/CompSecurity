// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.EbayItemIdAndVariationSpecifics;
import com.ebay.nautilus.domain.data.ImmutableNameValue;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            WatchListChangeRequest

private static class data extends data
    implements com.ebay.nautilus.domain.net.lder
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

    public (boolean flag, EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
    {
        super(flag);
        data = aebayitemidandvariationspecifics;
    }
}
