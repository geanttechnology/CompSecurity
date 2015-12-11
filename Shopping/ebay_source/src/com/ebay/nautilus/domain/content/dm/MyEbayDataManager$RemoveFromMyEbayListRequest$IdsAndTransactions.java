// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.data.EbayItemIdAndTransaction;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayDataManager

private static final class items
    implements com.ebay.nautilus.domain.net.ctions
{

    private final EbayItemIdAndTransaction items[];

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        EbayItemIdAndTransaction aebayitemidandtransaction[] = items;
        int j = aebayitemidandtransaction.length;
        for (int i = 0; i < j; i++)
        {
            EbayItemIdAndTransaction ebayitemidandtransaction = aebayitemidandtransaction[i];
            if (ebayitemidandtransaction.transactionId != null)
            {
                xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "item");
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "itemID", String.valueOf(ebayitemidandtransaction.id));
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "transactionID", ebayitemidandtransaction.transactionId);
                xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "item");
            }
        }

    }

    public (MyEbayListItem amyebaylistitem[])
    {
        int j = amyebaylistitem.length;
        items = new EbayItemIdAndTransaction[j];
        for (int i = 0; i < j; i++)
        {
            items[i] = new EbayItemIdAndTransaction(amyebaylistitem[i]);
        }

    }
}
