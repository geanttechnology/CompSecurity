// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.EbayItemIdAndTransaction;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayDataManager

static class dataFormat extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.equest
{
    private static final class Ids
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private final long ids[];

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            long al[] = ids;
            int j = al.length;
            for (int i = 0; i < j; i++)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "itemID", String.valueOf(al[i]));
            }

        }

        public Ids(MyEbayListItem amyebaylistitem[])
        {
            int j = amyebaylistitem.length;
            ids = new long[j];
            for (int i = 0; i < j; i++)
            {
                ids[i] = amyebaylistitem[i].id;
            }

        }
    }

    private static final class IdsAndTransactions
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
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

        public IdsAndTransactions(MyEbayListItem amyebaylistitem[])
        {
            int j = amyebaylistitem.length;
            items = new EbayItemIdAndTransaction[j];
            for (int i = 0; i < j; i++)
            {
                items[i] = new EbayItemIdAndTransaction(amyebaylistitem[i]);
            }

        }
    }


    static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobile/v1/services";
    private final com.ebay.nautilus.domain.net.equest.getResponse helper;

    public static IdsAndTransactions.items getRemoveFromDidntWinListRequest(EbaySite ebaysite, String s, MyEbayListItem amyebaylistitem[])
    {
        return new <init>(ebaysite, s, "removeFromDidntWinList", new Ids(amyebaylistitem));
    }

    public static Ids getRemoveFromSoldListRequest(EbaySite ebaysite, String s, MyEbayListItem amyebaylistitem[])
    {
        return new <init>(ebaysite, s, "removeFromSoldList", new IdsAndTransactions(amyebaylistitem));
    }

    public static IdsAndTransactions getRemoveFromUnsoldListRequest(EbaySite ebaysite, String s, MyEbayListItem amyebaylistitem[])
    {
        return new <init>(ebaysite, s, "removeFromUnsoldList", new Ids(amyebaylistitem));
    }

    public static Ids getRemoveFromWonListRequest(EbaySite ebaysite, String s, MyEbayListItem amyebaylistitem[])
    {
        return new <init>(ebaysite, s, "removeFromWonList", new IdsAndTransactions(amyebaylistitem));
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.equest
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        String s = (new StringBuilder()).append(getOperationName()).append("Request").toString();
        xmlserializer.setPrefix("", "http://www.ebay.com/marketplace/mobile/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", s);
        helper.lRequest(xmlserializer);
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", s);
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.myEbaySvcApi);
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    private IdsAndTransactions.items(EbaySite ebaysite, String s, String s1, com.ebay.nautilus.domain.net.equest equest)
    {
        super("MyEbayApplicationService", true, s1);
        helper = equest;
        iafToken = s;
        soaGlobalId = ebaysite.idString;
        soaAppIdHeaderName = "x-ebay-soa-security-appname";
        dataFormat = "XML";
    }
}
