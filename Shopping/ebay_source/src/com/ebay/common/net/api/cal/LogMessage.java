// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import com.ebay.common.net.EbayRequestHelper;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.SaxHandler;
import com.ebay.nautilus.kernel.util.StackUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Locale;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

public final class LogMessage
{
    private static final class LogMessageClientDetails
    {

        private static final String OPERATING_SYSTEM_NAME = "Android";
        private static final String OPERATING_SYSTEM_VERSION;
        private static final String PLATFORM;
        private final String averageNetworkTransferRate;
        private final String localeIdentifier;
        private final String network;
        private final String userLanguage;

        static LogMessageClientDetails createLogMessageClientDetail(Context context)
        {
            Object obj;
            String s;
            String s1;
            String s3;
            Object obj1;
            String s4;
            Locale locale;
            NetworkInfo networkinfo;
            locale = Locale.getDefault();
            networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            s1 = null;
            s3 = null;
            s4 = null;
            context = null;
            obj1 = null;
            s = s3;
            obj = s4;
            String s2 = URLEncoder.encode("", "UTF-8");
            s1 = s2;
            s = s3;
            obj = s4;
            s3 = URLEncoder.encode(locale.toString(), "UTF-8");
            if (networkinfo == null)
            {
                break MISSING_BLOCK_LABEL_93;
            }
            s1 = s2;
            s = s3;
            obj = s4;
            context = URLEncoder.encode(networkinfo.getTypeName(), "UTF-8");
            s1 = s2;
            s = s3;
            obj = context;
            s4 = URLEncoder.encode(locale.getLanguage(), "UTF-8");
            obj = s4;
            s = s3;
            s1 = s2;
_L2:
            return new LogMessageClientDetails(s1, s, context, ((String) (obj)));
            context;
            Log.e(LogMessage.TAG, "Logic error: bad encoding scheme", context);
            context = ((Context) (obj));
            obj = obj1;
            if (true) goto _L2; else goto _L1
_L1:
        }

        String toQueryString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("averageNetworkTransferRate=").append(averageNetworkTransferRate);
            stringbuilder.append("&localeIdentifier=").append(localeIdentifier);
            stringbuilder.append("&network=").append(network);
            stringbuilder.append("&operatingSystemName=").append("Android");
            stringbuilder.append("&operatingSystemVersion=").append(OPERATING_SYSTEM_VERSION);
            stringbuilder.append("&platform=").append(PLATFORM);
            stringbuilder.append("&userLanguage=").append(userLanguage);
            return stringbuilder.toString();
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            try
            {
                stringbuilder.append("averageNetworkTransferRate=").append(URLDecoder.decode(averageNetworkTransferRate, "UTF-8")).append("\n");
                stringbuilder.append("localeIdentifier=").append(URLDecoder.decode(localeIdentifier, "UTF-8")).append("\n");
                stringbuilder.append("network=").append(URLDecoder.decode(network, "UTF-8")).append("\n");
                stringbuilder.append("operatingSystemName=").append(URLDecoder.decode("Android", "UTF-8")).append("\n");
                stringbuilder.append("operatingSystemVersion=").append(URLDecoder.decode(OPERATING_SYSTEM_VERSION, "UTF-8")).append("\n");
                stringbuilder.append("platform=").append(URLDecoder.decode(PLATFORM, "UTF-8")).append("\n");
                stringbuilder.append("userLanguage=").append(URLDecoder.decode(userLanguage, "UTF-8")).append("\n");
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                Log.e(LogMessage.TAG, "Logic error: bad encoding scheme", unsupportedencodingexception);
            }
            return stringbuilder.toString();
        }

        static 
        {
            OPERATING_SYSTEM_VERSION = android.os.Build.VERSION.RELEASE;
            PLATFORM = (new StringBuilder()).append(Build.MANUFACTURER).append("/").append(Build.MODEL).toString();
        }

        private LogMessageClientDetails(String s, String s1, String s2, String s3)
        {
            String s4 = s;
            if (s == null)
            {
                s4 = "";
            }
            averageNetworkTransferRate = s4;
            s = s1;
            if (s1 == null)
            {
                s = "";
            }
            localeIdentifier = s;
            s = s2;
            if (s2 == null)
            {
                s = "";
            }
            network = s;
            s = s3;
            if (s3 == null)
            {
                s = "";
            }
            userLanguage = s;
        }
    }

    public static final class LogMessageRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        static final String REQUEST_NAME = "logMessageRequest";
        final String data;
        final String details;
        final String version;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return XmlSerializerHelper.buildXmlRequest(this);
        }

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            xmlserializer.setPrefix("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
            xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/mobile/v1/services");
            xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
            xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "logMessageRequest");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "name", "APIError");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "level", "ERROR");
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "clientInfo");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "clientDetails", details);
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "appDetails");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "environment", "PRODUCTION");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "version", version);
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "appName", "eBayAndroid");
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "appDetails");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "clientType", "Mobile");
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "clientInfo");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "data", data);
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "logMessageRequest");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        }

        public URL getRequestUrl()
        {
            return ApiSettings.getUrl(EbaySettings.cal);
        }

        public LogMessageResponse getResponse()
        {
            return new LogMessageResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public boolean isErrorReportable()
        {
            return false;
        }

        public boolean isTrafficReportable()
        {
            return false;
        }

        protected LogMessageRequest(String s, String s1, String s2, EbaySite ebaysite)
        {
            super("ApplicationLoggingService", true, "logMessage");
            super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
            super.bUseSoaServiceVersion = true;
            if (ebaysite != null)
            {
                ebaysite = ebaysite.idString;
            } else
            {
                ebaysite = GLOBAL_ID;
            }
            super.soaGlobalId = ebaysite;
            super.soaMessageProtocol = "SOAP12";
            super.soaContentType = "text/xml";
            details = s;
            version = s1;
            data = s2;
        }
    }

    public static final class LogMessageResponse extends EbayResponse
    {

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }

        public LogMessageResponse()
        {
        }
    }

    private final class LogMessageResponse.BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final LogMessageResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("logMessageResponse".equals(s1))
            {
                return new LogMessageResponse.ResponseElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private LogMessageResponse.BodyElement()
        {
            this$0 = LogMessageResponse.this;
            super();
        }

    }

    private final class LogMessageResponse.ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final LogMessageResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(LogMessageResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(LogMessageResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(LogMessageResponse.this, "http://www.ebay.com/marketplace/mobile/v1/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private LogMessageResponse.ResponseElement()
        {
            this$0 = LogMessageResponse.this;
            super();
        }

    }

    private final class LogMessageResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final LogMessageResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new LogMessageResponse.BodyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private LogMessageResponse.RootElement()
        {
            this$0 = LogMessageResponse.this;
            super();
        }

    }


    static final String CALL_NAME = "logMessageRequest";
    static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobile/v1/services";
    static final String SERVICE_NAME = "ApplicationLoggingService";
    static final String SOAP_DOMAIN = "http://schemas.xmlsoap.org/soap/envelope/";
    static final String TAG = com/ebay/common/net/api/cal/LogMessage.getSimpleName();

    public LogMessage()
    {
    }

    public static boolean execute(EbayContext ebaycontext, String s, EbaySite ebaysite)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        String s1 = LogMessageClientDetails.createLogMessageClientDetail((Context)ebaycontext.getExtension(android/content/Context)).toQueryString();
        String s2 = ebaycontext.getAppInfo().getAppVersionName();
        int i;
        try
        {
            i = ((LogMessageResponse)EbayRequestHelper.sendRequest(ebaycontext, new LogMessageRequest(s1, s2, s, ebaysite))).ackCode;
        }
        // Misplaced declaration of an exception variable
        catch (EbayContext ebaycontext)
        {
            return false;
        }
        return i == 1;
    }

    public static String getBackTrace()
    {
        return StackUtil.getCurrentThreadBackTrace(3, 30, "<-");
    }

}
