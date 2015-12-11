// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            EbayTradingRequest, GetMyEbayResponse, EbayTradingApi

public abstract class GetMyEbayRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{
    public static interface Buying
    {

        public static final String BestOfferList = "BestOfferList";
        public static final String BidList = "BidList";
        public static final String LostList = "LostList";
        public static final String WonList = "WonList";
    }

    public static interface Selling
    {

        public static final String ActiveList = "ActiveList";
        public static final String ScheduledList = "ScheduledList";
        public static final String SoldList = "SoldList";
        public static final String UnsoldList = "UnsoldList";
    }

    public static interface Watching
    {

        public static final String UserDefinedList = "UserDefinedList";
        public static final String WatchList = "WatchList";
    }


    private final int countPerPage;
    private final String listType;
    private final int pageIndex;
    private final String sort;

    public GetMyEbayRequest(EbayTradingApi ebaytradingapi, String s, int i, int j, String s1)
    {
        this(ebaytradingapi, s, i, j, s1, null);
    }

    public GetMyEbayRequest(EbayTradingApi ebaytradingapi, String s, int i, int j, String s1, String s2)
    {
        super(ebaytradingapi, s1);
        listType = s;
        countPerPage = i;
        pageIndex = j;
        sort = s2;
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
        buildXmlRequest(xmlserializer, listType);
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", s);
    }

    protected abstract void buildXmlRequest(XmlSerializer xmlserializer, String s)
        throws IOException;

    public String getListType()
    {
        return listType;
    }

    public GetMyEbayResponse getResponse()
    {
        return new GetMyEbayResponse(countPerPage);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected final void writeInclude(XmlSerializer xmlserializer, String s, String s1)
        throws IOException
    {
        writeInclude(xmlserializer, s, s1, null, null);
    }

    protected final void writeInclude(XmlSerializer xmlserializer, String s, String s1, String s2, String s3)
        throws IOException
    {
        xmlserializer.startTag(s, s1);
        if (listType.equals(s1)) goto _L2; else goto _L1
_L1:
        XmlSerializerHelper.writeSimple(xmlserializer, s, "Include", "false");
_L8:
        xmlserializer.endTag(s, s1);
        return;
_L2:
        if (!TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, s, s2, s3);
        }
        if (!s1.equals("UnsoldList") && !s1.equals("SoldList") && !s1.equals("WonList") && !s1.equals("BestOfferList")) goto _L4; else goto _L3
_L3:
        XmlSerializerHelper.writeSimple(xmlserializer, s, "DurationInDays", "60");
_L6:
        XmlSerializerHelper.writePagination(xmlserializer, s, pageIndex, countPerPage);
        if (TextUtils.isEmpty(sort))
        {
            break; /* Loop/switch isn't completed */
        }
        XmlSerializerHelper.writeSimple(xmlserializer, s, "Sort", sort);
        continue; /* Loop/switch isn't completed */
_L4:
        if (s1.equals("LostList"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, s, "DurationInDays", "31");
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (s1.equals("ActiveList") || s1.equals("WatchList") || s1.equals("BidList"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, s, "Sort", "TimeLeft");
        }
        if (true) goto _L8; else goto _L7
_L7:
    }
}
