// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsRequest, LdsResponse, LdsRequestParams

public class GetSavedListingDraftsRequest extends LdsRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{
    public static class DraftFilterConfig
    {

        public boolean androidMotors;
        public boolean bear;
        public boolean cub;
        public boolean ipad;
        public boolean iphone;
        public boolean syi;
        public boolean webnext;
        public boolean windows8;
        public boolean windows8Phone;

        public DraftFilterConfig()
        {
            androidMotors = true;
            webnext = true;
            syi = true;
            iphone = true;
            ipad = true;
            windows8 = true;
            windows8Phone = true;
            bear = true;
            cub = true;
        }
    }


    private static final String ANDROID_APP_ID;
    private static final String ANDROID_MOTORS_APP_ID;
    private static final String BEAR_APP_ID;
    public static final String BODY_TAG = "getSavedListingDraftsResponse";
    private static final String CUB_APP_ID;
    private static final String IPAD_APP_ID;
    private static final String IPHONE_APP_ID;
    private static final String SYI_APP_ID;
    private static final String WEBNEXT_APP_ID;
    private static final String WINDOWS_8_APP_ID;
    private static final String WINDOWS_8_PHONE_APP_ID;
    private final DraftFilterConfig filterConfig;

    public GetSavedListingDraftsRequest(LdsRequestParams ldsrequestparams, DraftFilterConfig draftfilterconfig)
    {
        super("getSavedListingDrafts", ldsrequestparams);
        filterConfig = draftfilterconfig;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/listing/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "getSavedListingDraftsRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "draftFilter");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "appName", ANDROID_APP_ID);
        if (filterConfig.androidMotors)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "appName", ANDROID_MOTORS_APP_ID);
        }
        if (filterConfig.syi)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "appName", SYI_APP_ID);
        }
        if (filterConfig.webnext)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "appName", WEBNEXT_APP_ID);
        }
        if (filterConfig.iphone)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "appName", IPHONE_APP_ID);
        }
        if (filterConfig.ipad)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "appName", IPAD_APP_ID);
        }
        if (filterConfig.windows8)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "appName", WINDOWS_8_APP_ID);
        }
        if (filterConfig.windows8Phone)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "appName", WINDOWS_8_PHONE_APP_ID);
        }
        if (filterConfig.bear)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "appName", BEAR_APP_ID);
        }
        if (filterConfig.cub)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "appName", CUB_APP_ID);
        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "draftFilter");
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "getSavedListingDraftsRequest");
    }

    public volatile URL getRequestUrl()
    {
        return super.getRequestUrl();
    }

    public LdsResponse getResponse()
    {
        return new LdsResponse("getSavedListingDraftsResponse", params.site, null);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    static 
    {
        if (NautilusKernel.isQaMode())
        {
            ANDROID_APP_ID = "AndrApp";
            ANDROID_MOTORS_APP_ID = "AMOTORSApp";
            WEBNEXT_APP_ID = "CseApp";
            SYI_APP_ID = "No Application Id";
            IPHONE_APP_ID = "eBayiPhoneQAApp";
            IPAD_APP_ID = "AdminApp";
            WINDOWS_8_APP_ID = "Windows8MobileQAApp";
            WINDOWS_8_PHONE_APP_ID = "Windows7App";
            BEAR_APP_ID = "170002649881hong";
            CUB_APP_ID = "CUB_APP_ID";
        } else
        {
            ANDROID_APP_ID = "eBayInc52-907e-4b8a-ba0c-707469bb4d5";
            ANDROID_MOTORS_APP_ID = "eBayInc3a-d0c7-4af3-954e-9bcf5974a26";
            WEBNEXT_APP_ID = "ebayc2c5c-03c1-4fe1-9f61-eb24dfec232";
            SYI_APP_ID = "No Application Id";
            IPHONE_APP_ID = "eBayInc80-8977-4f05-a933-3daa1311213";
            IPAD_APP_ID = "eBayInc64-7662-48ae-8d31-2b168593ee5";
            WINDOWS_8_APP_ID = "eBayInc98-31e1-4fec-911d-7d71fac63c2";
            WINDOWS_8_PHONE_APP_ID = "eBayMobi-c93c-4486-8615-f63a90b510e4";
            BEAR_APP_ID = "BEARAppl-630e-4eca-951f-e5e91f02e9e0";
            CUB_APP_ID = "eBayInca1-dff0-4f7f-bf8b-a9f902863b6";
        }
    }
}
