// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mdns;

import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.ebay.common.model.mdns.DeviceHandle;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.mdns:
//            ActivateUserOnDeviceRequest, DeactivateUserOnDeviceRequest, GetDeviceNotificationSubscriptionsRequest, GetDeviceNotificationSubscriptionsResponse, 
//            SetDeviceNotificationSubscriptionsRequest, DeviceNotificationSubscriptions

public final class EbayMdnsApi
{
    public static abstract class MdnsRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private final DeviceHandle deviceHandle;
        private final String language;
        private final String metaCategories;
        private final String userId;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return XmlSerializerHelper.buildXmlRequest(this);
        }

        protected abstract void buildSpecificXmlRequest(XmlSerializer xmlserializer)
            throws IOException;

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            String s = getOperationName();
            EbayMdnsApi.writeCommonFirstElements(s, userId, language, deviceHandle, xmlserializer);
            buildSpecificXmlRequest(xmlserializer);
            EbayMdnsApi.writeCommonLastElements(s, xmlserializer);
        }

        public URL getRequestUrl()
        {
            return ApiSettings.getUrl(EbaySettings.notificationApi);
        }

        public MdnsResponse getResponse()
        {
            return new MdnsResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public void onAddHeaders(IHeaders iheaders)
        {
            super.onAddHeaders(iheaders);
            iheaders.setHeader("x-ebay3pp-device-id", EbayIdentity.get3ppFingerprint(getContext()));
        }

        protected MdnsRequest(String s, String s1, String s2, String s3, String s4, DeviceHandle devicehandle, EbaySite ebaysite)
        {
            super("MobileDeviceNotificationService", true, s);
            iafToken = s1;
            userId = s2;
            deviceHandle = devicehandle;
            language = s3;
            soaMessageProtocol = "SOAP12";
            if (ebaysite != null)
            {
                s = ebaysite.idString;
            } else
            {
                s = GLOBAL_ID;
            }
            soaGlobalId = s;
            dataFormat = "XML";
            isConvertedToAlternateHttpFaultStatus = true;
            metaCategories = s4;
        }
    }

    public static class MdnsResponse extends EbayResponse
    {

        private void parseAck(XmlPullParser xmlpullparser)
            throws IOException, SAXException, XmlPullParserException
        {
            if (xmlpullparser.nextText().equals("Success"))
            {
                ackCode = 1;
                return;
            } else
            {
                ackCode = -1;
                return;
            }
        }

        private void parseError(XmlPullParser xmlpullparser)
            throws IOException, SAXException, XmlPullParserException
        {
            EbayResponseError ebayresponseerror = new EbayResponseError();
            String s = "error";
            do
            {
                if (s.equals("errorId"))
                {
                    break;
                }
                if (xmlpullparser.next() == 2)
                {
                    s = xmlpullparser.getName();
                }
            } while (true);
            ebayresponseerror.code = xmlpullparser.nextText();
            do
            {
                if (s.equals("message"))
                {
                    break;
                }
                if (xmlpullparser.next() == 2)
                {
                    s = xmlpullparser.getName();
                }
            } while (true);
            ebayresponseerror.longMessage = xmlpullparser.nextText();
            addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                ebayresponseerror
            });
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            int i;
            int j;
            XmlPullParser xmlpullparser = Xml.newPullParser();
            int k;
            try
            {
                xmlpullparser.setInput(new InputStreamReader(inputstream));
                j = xmlpullparser.getEventType();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                Log.w("MdnsResponse", "Exception parsing response", inputstream);
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
              goto _L1
_L3:
            k = xmlpullparser.next();
            i = j;
            j = k;
              goto _L1
_L6:
            inputstream = xmlpullparser.getName();
            if (!inputstream.equals("ack"))
            {
                break MISSING_BLOCK_LABEL_87;
            }
            parseAck(xmlpullparser);
            j = i;
            if (ackCode != 1) goto _L3; else goto _L2
_L2:
            j = 1;
              goto _L3
            j = i;
            if (!inputstream.equals("error")) goto _L3; else goto _L4
_L4:
            parseError(xmlpullparser);
            j = i;
              goto _L3
_L1:
            for (i = 0; j == 1 || i != 0;)
            {
                return;
            }

            j;
            JVM INSTR tableswitch 2 2: default 168
        //                       2 49;
               goto _L5 _L6
_L5:
            j = i;
              goto _L3
        }

        public MdnsResponse()
        {
        }
    }

    public static final class NotificationParams
    {

        public String clientId;
        public String deviceType;
        public String iafToken;
        public String language;
        public String metaCategories;
        public ArrayList prefs;
        public String quietTimeStart;
        public String quietTimeStop;
        public String registrationId;
        public EbaySite site;
        public String userId;

        public DeviceHandle getDeviceHandle()
        {
            return new DeviceHandle(registrationId, deviceType, clientId);
        }

        public NotificationParams()
        {
        }
    }


    private static final String DESCRIPTION = "eBay App for Android phone";
    public static final String DEVICE_TYPE_C2DM = "C2DM";
    public static final String DEVICE_TYPE_GOOGLENOW = "GOOGLENOW";
    public static final String MOBILE_SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobile/v1/services";
    public static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/services";
    public static final String SERVICE_NAME = "MobileDeviceNotificationService";
    public static final String SOAP_DOMAIN = "http://www.w3.org/2003/05/soap-envelope";
    private static final String clientId = "clientID";
    private static final String description = "description";
    private static final String deviceHandle = "deviceHandle";
    private static final String deviceToken = "deviceToken";
    private static final String deviceType = "deviceType";
    private static final String lang = "language";
    private static final String userid = "userid";
    private final EbayContext context;

    public EbayMdnsApi(EbayContext ebaycontext)
    {
        context = ebaycontext;
    }

    protected static void writeCommonFirstElements(String s, String s1, String s2, DeviceHandle devicehandle, XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("soap", "http://www.w3.org/2003/05/soap-envelope");
        xmlserializer.setPrefix("ser", "http://www.ebay.com/marketplace/mobile/v1/services");
        xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Envelope");
        xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Body");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", s);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "userid", s1);
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "deviceHandle");
        if (!TextUtils.isEmpty(devicehandle.deviceToken))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "deviceToken", devicehandle.deviceToken);
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "deviceType", devicehandle.deviceType);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "clientID", devicehandle.clientId);
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "deviceHandle");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "description", "eBay App for Android phone");
        if (!TextUtils.isEmpty(s2))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "language", s2);
        }
    }

    protected static void writeCommonLastElements(String s, XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", s);
        xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Body");
        xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Envelope");
    }

    public boolean activateUserOnDevice(String s, String s1, String s2, String s3, String s4, String s5, EbaySite ebaysite)
        throws IOException, InterruptedException
    {
        s = new ActivateUserOnDeviceRequest(s, s1, s3, s5, new DeviceHandle(s2, "C2DM", s4), ebaysite);
        return ((MdnsResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(context, s)).ackCode == 1;
    }

    public boolean deactivateUserOnDevice(String s, String s1, String s2, String s3, String s4, String s5, EbaySite ebaysite, 
            String s6)
        throws IOException, InterruptedException
    {
        s = new DeactivateUserOnDeviceRequest(s, s1, s3, s5, new DeviceHandle(s2, s6, s4), ebaysite);
        return ((MdnsResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(context, s)).ackCode == 1;
    }

    public DeviceNotificationSubscriptions getDeviceNotificationSubscriptions(NotificationParams notificationparams)
        throws IOException, InterruptedException
    {
        notificationparams = (GetDeviceNotificationSubscriptionsResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(context, new GetDeviceNotificationSubscriptionsRequest(notificationparams.userId, notificationparams.iafToken, notificationparams.site, notificationparams.getDeviceHandle(), notificationparams.language));
        if (notificationparams.isSuccessful() && ((GetDeviceNotificationSubscriptionsResponse) (notificationparams)).subscriptions != null)
        {
            return ((GetDeviceNotificationSubscriptionsResponse) (notificationparams)).subscriptions;
        } else
        {
            return null;
        }
    }

    public EbayResponse setDeviceNotificationSubscriptions(NotificationParams notificationparams)
        throws IOException, InterruptedException
    {
        return (EbayResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(context, new SetDeviceNotificationSubscriptionsRequest(notificationparams));
    }
}
