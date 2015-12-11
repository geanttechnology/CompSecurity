// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.domain.data.EbayItemIdAndTransaction;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager, UserContextDataManager

public abstract class MyEbayDataManager extends UserContextObservingDataManager
{
    static class RemoveFromMyEbayListRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobile/v1/services";
        private final com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder helper;

        public static RemoveFromMyEbayListRequest getRemoveFromDidntWinListRequest(EbaySite ebaysite, String s, MyEbayListItem amyebaylistitem[])
        {
            return new RemoveFromMyEbayListRequest(ebaysite, s, "removeFromDidntWinList", new Ids(amyebaylistitem));
        }

        public static RemoveFromMyEbayListRequest getRemoveFromSoldListRequest(EbaySite ebaysite, String s, MyEbayListItem amyebaylistitem[])
        {
            return new RemoveFromMyEbayListRequest(ebaysite, s, "removeFromSoldList", new IdsAndTransactions(amyebaylistitem));
        }

        public static RemoveFromMyEbayListRequest getRemoveFromUnsoldListRequest(EbaySite ebaysite, String s, MyEbayListItem amyebaylistitem[])
        {
            return new RemoveFromMyEbayListRequest(ebaysite, s, "removeFromUnsoldList", new Ids(amyebaylistitem));
        }

        public static RemoveFromMyEbayListRequest getRemoveFromWonListRequest(EbaySite ebaysite, String s, MyEbayListItem amyebaylistitem[])
        {
            return new RemoveFromMyEbayListRequest(ebaysite, s, "removeFromWonList", new IdsAndTransactions(amyebaylistitem));
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
            xmlserializer.setPrefix("", "http://www.ebay.com/marketplace/mobile/v1/services");
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", s);
            helper.buildXmlRequest(xmlserializer);
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", s);
        }

        public URL getRequestUrl()
        {
            return ApiSettings.getUrl(ApiSettings.myEbaySvcApi);
        }

        public RemoveFromMyEbayListResponse getResponse()
        {
            return new RemoveFromMyEbayListResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        private RemoveFromMyEbayListRequest(EbaySite ebaysite, String s, String s1, com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder ixmlrequestbuilder)
        {
            super("MyEbayApplicationService", true, s1);
            helper = ixmlrequestbuilder;
            iafToken = s;
            soaGlobalId = ebaysite.idString;
            soaAppIdHeaderName = "x-ebay-soa-security-appname";
            dataFormat = "XML";
        }
    }

    private static final class RemoveFromMyEbayListRequest.Ids
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

        public RemoveFromMyEbayListRequest.Ids(MyEbayListItem amyebaylistitem[])
        {
            int j = amyebaylistitem.length;
            ids = new long[j];
            for (int i = 0; i < j; i++)
            {
                ids[i] = amyebaylistitem[i].id;
            }

        }
    }

    private static final class RemoveFromMyEbayListRequest.IdsAndTransactions
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

        public RemoveFromMyEbayListRequest.IdsAndTransactions(MyEbayListItem amyebaylistitem[])
        {
            int j = amyebaylistitem.length;
            items = new EbayItemIdAndTransaction[j];
            for (int i = 0; i < j; i++)
            {
                items[i] = new EbayItemIdAndTransaction(amyebaylistitem[i]);
            }

        }
    }

    static class RemoveFromMyEbayListResponse extends EbayResponse
    {

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }

        RemoveFromMyEbayListResponse()
        {
        }
    }

    private final class RemoveFromMyEbayListResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RemoveFromMyEbayListResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(RemoveFromMyEbayListResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(RemoveFromMyEbayListResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(RemoveFromMyEbayListResponse.this, "http://www.ebay.com/marketplace/mobile/v1/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RemoveFromMyEbayListResponse.RootElement()
        {
            this$0 = RemoveFromMyEbayListResponse.this;
            super();
        }

    }


    protected static final int ITEMS_PER_PAGE = 25;
    protected static final int MAX_PAGES = 100;
    private volatile EbayCountry currentCountry;
    private volatile String currentIafToken;

    protected MyEbayDataManager(EbayContext ebaycontext, Class class1, UserContextObservingDataManager.KeyBase keybase)
    {
        super(ebaycontext, class1, keybase);
    }

    protected final EbayTradingApi getApi(ResultStatusOwner resultstatusowner)
    {
        EbayCountry ebaycountry = currentCountry;
        String s = currentIafToken;
        if (ebaycountry == null)
        {
            resultstatusowner.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                InternalDomainError.getCountryNotSpecifiedMessage()
            });
        }
        if (s == null)
        {
            resultstatusowner.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                InternalDomainError.getPleaseSignInMessage()
            });
            return null;
        } else
        {
            return new EbayTradingApi(ebaycountry.site, s);
        }
    }

    public void invalidateRelatedDataManagers()
    {
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        super.onCurrentCountryChanged(usercontextdatamanager, ebaycountry);
        currentCountry = ebaycountry;
    }

    public final void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        super.onCurrentUserChanged(usercontextdatamanager, s, s1, flag);
        currentIafToken = s1;
        if (s1 == null || s == null)
        {
            onUserSignedOut();
            return;
        }
        if (flag)
        {
            onUserAuthChanged();
            return;
        } else
        {
            onNewUser(s);
            return;
        }
    }

    protected abstract void onNewUser(String s);

    protected abstract void onUserAuthChanged();

    protected abstract void onUserSignedOut();

    public void setTestAuth(String s, EbayCountry ebaycountry)
    {
        currentIafToken = s;
        currentCountry = ebaycountry;
    }
}
