// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.rtm;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.ebay.common.rtm.RtmContextProperty;
import com.ebay.common.rtm.RtmContextTypeId;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.UnifiedStream.KeyValue;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.rtm:
//            GetRtm

public static class placementId extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlRequestBuilder
{
    class nvPair
    {

        public String name;
        final GetRtm.GetRtmRequest this$0;
        public String value;

        public nvPair(String s, String s1)
        {
            this$0 = GetRtm.GetRtmRequest.this;
            super();
            name = s;
            value = s1;
        }
    }


    private static final String CID_TAG = "CID";
    private static final String CLIENT_ID = "AEAPP";
    private static final String CORRELATION_GUID_PARAMETER_TAG = "CORRELATION_GUID";
    private static final String CORRELATION_GUID_REQUEST_TAG = "correlationGuid";
    private static final String IS_ANONYMOUS_TAG = "IS_ANONYMOUS";
    private static final String KEYVALUEPAIR_TAG = "KeyValuePair";
    private static final String KEY_TAG = "key";
    private static final String PLACEMENTS_TAG = "placements";
    private static final String RTMCONTEXT_TAG = "rtmContext";
    private static final String SOJOURNER_GUID_PARAMETER_TAG = "SOJOURNER_GUID";
    private static final String SOJOURNER_GUID_REQUEST_TAG = "sojournerGuid";
    private static final String VALUE_TAG = "value";
    private static final String operationName = "getRTMContent";
    protected String adCategoryIdString;
    protected String adKeywords;
    protected boolean adRequest;
    private String campaignSelector;
    protected String categoryId;
    private String cguid;
    private String installedApps;
    protected String itemId;
    protected String placementId;
    protected String promoCguid;
    protected String promoPlacementId;
    private String rtmClientVersion;
    private ArrayList rtmContextList;
    protected int searchResultCount;
    private String sojournerGuid;
    private String strDisplayHeight;
    private String strDisplayWidth;
    protected String title;

    private List getPromoKeyValues(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new KeyValue("RTM", RtmContextProperty.MOBILE_APP_CARRIER.toString(), s1));
        arraylist.add(new KeyValue("RTM", RtmContextProperty.MOBILE_APP_OS_VERSION.toString(), android.os.));
        arraylist.add(new KeyValue("RTM", RtmContextProperty.MOBILE_APP_INSTALLED_APPS.toString(), installedApps));
        arraylist.add(new KeyValue("RTM", RtmContextProperty.MOBILE_APP_VERSION.toString(), rtmClientVersion));
        arraylist.add(new KeyValue("RTM", RtmContextProperty.REFERRER_NAME.toString(), sojournerGuid));
        arraylist.add(new KeyValue("RTM", "CORRELATION_GUID", promoCguid));
        arraylist.add(new KeyValue("RTM", RtmContextProperty.MOBILE_APP_NEW_USER.toString(), "false"));
        arraylist.add(new KeyValue("RTM", "CID", RtmContextTypeId.MOBILE_APP_HOME_PAGE_CONTEXT_ID.toString()));
        arraylist.add(new KeyValue("RTM", "SOJOURNER_GUID", sojournerGuid));
        arraylist.add(new KeyValue("RTM", "placements", promoPlacementId));
        arraylist.add(new KeyValue("RTM", RtmContextProperty.SITE_ID.toString(), soaGlobalId));
        arraylist.add(new KeyValue("RTM", RtmContextProperty.MOBILE_APP_DEVICE_TYPE.toString(), s));
        arraylist.add(new KeyValue("RTM", RtmContextProperty.MOBILE_APP_ID.toString(), "AEAPP"));
        arraylist.add(new KeyValue("RTM", RtmContextProperty.MOBILE_APP_NEW_UPDATE.toString(), "false"));
        return arraylist;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.tDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        String s;
        Object obj;
        if (adRequest)
        {
            s = "http://www.ebay.com/marketplace/mobileor/v2/commonservices";
        } else
        {
            s = "http://www.ebay.com/marketplace/mobileor/v1/commonservices";
        }
        xmlserializer.setPrefix("soap", "http://schemas.xmlsoap.org/soap/envelope/");
        if (adRequest)
        {
            obj = "";
        } else
        {
            obj = "com";
        }
        xmlserializer.setPrefix(((String) (obj)), s);
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.startTag(s, "getRTMContentRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, s, "placements", placementId);
        XmlSerializerHelper.writeSimple(xmlserializer, s, "correlationGuid", cguid);
        XmlSerializerHelper.writeSimple(xmlserializer, s, "sojournerGuid", sojournerGuid);
        xmlserializer.startTag(s, "rtmContext");
        for (int i = 0; i < rtmContextList.size(); i++)
        {
            obj = (nvPair)rtmContextList.get(i);
            xmlserializer.startTag(s, "KeyValuePair");
            XmlSerializerHelper.writeSimple(xmlserializer, s, "key", ((nvPair) (obj)).name);
            XmlSerializerHelper.writeSimple(xmlserializer, s, "value", ((nvPair) (obj)).value);
            xmlserializer.endTag(s, "KeyValuePair");
        }

        xmlserializer.endTag(s, "rtmContext");
        xmlserializer.endTag(s, "getRTMContentRequest");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
    }

    public List getPromoRtmContext(Context context)
    {
        String s1 = (new StringBuilder()).append("oem:").append(Build.MANUFACTURER).append(" model:").append(Build.MODEL).toString();
        String s = "unknown";
        Object obj = (TelephonyManager)context.getSystemService("phone");
        context = s;
        if (obj != null)
        {
            obj = ((TelephonyManager) (obj)).getNetworkOperatorName();
            context = s;
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                context = ((Context) (obj));
            }
        }
        return getPromoKeyValues(s1, context);
    }

    public URL getRequestUrl()
    {
        if (adRequest)
        {
            return ApiSettings.getUrl(EbaySettings.rtmAds);
        } else
        {
            return ApiSettings.getUrl(EbaySettings.rtm);
        }
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public List getRtmContext(boolean flag, Context context)
    {
        String s = (new StringBuilder()).append("oem:").append(Build.MANUFACTURER).append(" model:").append(Build.MODEL).toString();
        Object obj = "unknown";
        Object obj1 = (TelephonyManager)context.getSystemService("phone");
        context = ((Context) (obj));
        if (obj1 != null)
        {
            obj1 = ((TelephonyManager) (obj1)).getNetworkOperatorName();
            context = ((Context) (obj));
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                context = ((Context) (obj1));
            }
        }
        obj = new ArrayList();
        ((ArrayList) (obj)).add(new KeyValue("RTM2", "CID", RtmContextTypeId.ANDROID_MOBILE_APP_CONTEXT_ID_TYPE.toString()));
        ((ArrayList) (obj)).add(new KeyValue("RTM2", RtmContextProperty.MOBILE_APP_VERSION.toString(), rtmClientVersion));
        ((ArrayList) (obj)).add(new KeyValue("RTM2", RtmContextProperty.MOBILE_APP_ID.toString(), "AEAPP"));
        ((ArrayList) (obj)).add(new KeyValue("RTM2", RtmContextProperty.MOBILE_APP_DEVICE_TYPE.toString(), s));
        ((ArrayList) (obj)).add(new KeyValue("RTM2", RtmContextProperty.MOBILE_APP_OS_VERSION.toString(), android.os.));
        ((ArrayList) (obj)).add(new KeyValue("RTM2", RtmContextProperty.MOBILE_APP_CARRIER.toString(), context));
        if (flag)
        {
            ((ArrayList) (obj)).add(new KeyValue("RTM2", "IS_ANONYMOUS", "TRUE"));
        } else
        {
            ((ArrayList) (obj)).add(new KeyValue("RTM2", "IS_ANONYMOUS", "FALSE"));
        }
        if (!TextUtils.isEmpty(placementId))
        {
            ((ArrayList) (obj)).add(new KeyValue("RTM2", "placements", placementId));
        }
        ((ArrayList) (obj)).add(new KeyValue("RTM2", RtmContextProperty.SITE_ID.toString(), soaGlobalId));
        ((ArrayList) (obj)).add(new KeyValue("RTM2", "CORRELATION_GUID", cguid));
        ((ArrayList) (obj)).add(new KeyValue("RTM2", "SOJOURNER_GUID", sojournerGuid));
        if (!TextUtils.isEmpty(campaignSelector))
        {
            ((ArrayList) (obj)).add(new KeyValue("RTM2", RtmContextProperty.MOBILE_APP_MESSAGE_SELECTOR.toString(), campaignSelector));
        }
        if (adRequest)
        {
            if (!TextUtils.isEmpty(adKeywords))
            {
                ((ArrayList) (obj)).add(new KeyValue("RTM2", RtmContextProperty.KEYWORDS.toString(), adKeywords));
            }
            ((ArrayList) (obj)).add(new KeyValue("RTM2", RtmContextProperty.CAT_ID.toString(), adCategoryIdString));
            ((ArrayList) (obj)).add(new KeyValue("RTM2", RtmContextProperty.CLIENT_CHANNEL.toString(), "MAPP"));
            if (!TextUtils.isEmpty(title))
            {
                ((ArrayList) (obj)).add(new KeyValue("RTM2", RtmContextProperty.ITEM_TITLE.toString(), title));
            }
            if (!TextUtils.isEmpty(itemId))
            {
                ((ArrayList) (obj)).add(new KeyValue("RTM2", RtmContextProperty.ITEM_ID.toString(), itemId));
            }
            if (!TextUtils.isEmpty(categoryId))
            {
                ((ArrayList) (obj)).add(new KeyValue("RTM2", RtmContextProperty.ITEM_CATEGORY.toString(), categoryId));
            }
        }
        if (promoPlacementId != null)
        {
            ((ArrayList) (obj)).addAll(getPromoKeyValues(s, context));
        }
        return ((List) (obj));
    }

    protected void initRtmContext(Context context)
    {
        String s = (new StringBuilder()).append("oem:").append(Build.MANUFACTURER).append(" model:").append(Build.MODEL).toString();
        Object obj = "unknown";
        Object obj1 = (TelephonyManager)context.getSystemService("phone");
        context = ((Context) (obj));
        if (obj1 != null)
        {
            obj1 = ((TelephonyManager) (obj1)).getNetworkOperatorName();
            context = ((Context) (obj));
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                context = ((Context) (obj1));
            }
        }
        rtmContextList = new ArrayList();
        rtmContextList.add(new nvPair("CID", RtmContextTypeId.ANDROID_MOBILE_APP_CONTEXT_ID_TYPE.toString()));
        rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.MOBILE_APP_VERSION).toString(), rtmClientVersion));
        rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.MOBILE_APP_ID).toString(), "AEAPP"));
        rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.MOBILE_APP_DEVICE_TYPE).toString(), s));
        rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.MOBILE_APP_OS_VERSION).toString(), android.os.));
        rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.MOBILE_APP_CARRIER).toString(), context));
        if (!TextUtils.isEmpty(campaignSelector))
        {
            rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.MOBILE_APP_MESSAGE_SELECTOR).toString(), campaignSelector));
        }
        if (adRequest)
        {
            if (!TextUtils.isEmpty(adKeywords))
            {
                rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.KEYWORDS).toString(), adKeywords));
            }
            rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.CAT_ID).toString(), adCategoryIdString));
            rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.CATEGORY_ID_FILTER).toString(), adCategoryIdString));
            rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.UNMODIFIED_KEYWORDS).toString(), null));
            rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.SEARCH_RESULT).toString(), Integer.toString(searchResultCount)));
            rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.CLIENT_CHANNEL).toString(), "MAPP"));
            if (!TextUtils.isEmpty(title))
            {
                rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.ITEM_TITLE).toString(), title));
            }
            if (!TextUtils.isEmpty(itemId))
            {
                rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.ITEM_ID).toString(), itemId));
            }
            if (!TextUtils.isEmpty(categoryId))
            {
                rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.ITEM_CATEGORY).toString(), categoryId));
            }
            return;
        }
        rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.REFERRER_NAME).toString(), sojournerGuid));
        obj = rtmContextList;
        obj1 = (new StringBuilder()).append("p").append(RtmContextProperty.MOBILE_APP_NEW_USER).toString();
        if (true)
        {
            context = "true";
        } else
        {
            context = "false";
        }
        ((ArrayList) (obj)).add(new nvPair(((String) (obj1)), context));
        obj = rtmContextList;
        obj1 = (new StringBuilder()).append("p").append(RtmContextProperty.MOBILE_APP_NEW_UPDATE).toString();
        if (true)
        {
            context = "true";
        } else
        {
            context = "false";
        }
        ((ArrayList) (obj)).add(new nvPair(((String) (obj1)), context));
        rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.MOBILE_APP_INSTALLED_APPS).toString(), installedApps));
        rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.MOBILE_APP_SCREEN_WIDTH).toString(), strDisplayWidth));
        rtmContextList.add(new nvPair((new StringBuilder()).append("p").append(RtmContextProperty.MOBILE_APP_SCREEN_HEIGHT).toString(), strDisplayHeight));
    }

    public nvPair.value(Context context, String s, EbaySite ebaysite, String s1, String s2, String s3, String s4, 
            int i, int j, String s5)
    {
        this("CommonMobileAppService", true, "getRTMContent", context, s, ebaysite, s1, s2, s4);
        adRequest = false;
        super.soaMessageProtocol = "SOAP12";
        super.soaServiceVersion = "1.1.0";
        installedApps = new String(s3);
        strDisplayWidth = Integer.toString(i);
        strDisplayHeight = Integer.toString(j);
        campaignSelector = s5;
        initRtmContext(context);
    }

    protected initRtmContext(String s, boolean flag, String s1, Context context, String s2, EbaySite ebaysite, String s3, 
            String s4, String s5)
    {
        super(s, flag, s1);
        rtmClientVersion = null;
        sojournerGuid = null;
        cguid = null;
        installedApps = null;
        strDisplayWidth = null;
        strDisplayHeight = null;
        campaignSelector = null;
        searchResultCount = 0;
        adRequest = false;
        adKeywords = null;
        adCategoryIdString = null;
        itemId = null;
        title = null;
        categoryId = null;
        placementId = null;
        promoPlacementId = null;
        promoCguid = null;
        super.iafToken = s2;
        super.soaGlobalId = ebaysite.idString;
        super.dataFormat = "XML";
        super.soaContentType = "text/xml";
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        cguid = new String(s4);
        rtmClientVersion = new String(s3);
        sojournerGuid = EbayIdentity.getDeviceIdString(context);
        placementId = s5;
    }
}
