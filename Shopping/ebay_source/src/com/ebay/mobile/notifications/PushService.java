// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbayBroadcast;
import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.common.model.mdns.PlatformNotificationsEvent;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.ServiceContentOverride;
import com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager;
import com.ebay.nautilus.domain.content.dm.SymbanDataManager;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.kernel.util.SaxHandler;
import com.ebay.nautilus.shell.app.BaseIntentService;
import com.ebay.nautilus.shell.app.FwContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.mobile.notifications:
//            EbaySmartNotificationManager, ItemCache, NotificationPreferenceManager, NotificationTrackingUtil, 
//            NotificationUtil, EbayNotificationManager, SharedWakeLock

public class PushService extends BaseIntentService
{
    private static final class LocalEbayRequestHelper
    {

        public static EbayResponse sendRequest(EbayContext ebaycontext, Request request)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            ebaycontext = (EbayResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(ebaycontext, request);
            verify(ebaycontext);
            return ebaycontext;
        }

        public static void verify(EbayResponse ebayresponse)
            throws com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException
        {
            if (!ebayresponse.hasSuccessResponseCode())
            {
                throw new com.ebay.nautilus.kernel.net.Connector.HostErrorException(ebayresponse.responseCode, ebayresponse.responseMessage);
            } else
            {
                return;
            }
        }

        private LocalEbayRequestHelper()
        {
        }
    }

    private static class LogNotificationRequest extends EbayRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private final PlatformNotificationsEvent event;
        private final String packageName;
        private final String targetClient;
        private final String targetUsername;
        private final EbaySmartNotificationManager.NotificationType type;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return XmlSerializerHelper.buildXmlRequest(this);
        }

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            xmlserializer.setPrefix("", "");
            xmlserializer.startTag("", "notification");
            XmlSerializerHelper.writeSimple(xmlserializer, "", "PNSType", event.eventType);
            if (!TextUtils.isEmpty(event.itemId))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "", "itemID", event.itemId);
            }
            if (!TextUtils.isEmpty(event.sellerUserId))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "", "sellerID", event.sellerUserId);
            }
            if (!TextUtils.isEmpty(event.title))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "", "messageID", event.title);
            }
            XmlSerializerHelper.writeSimple(xmlserializer, "", "loggedInUser", MyApp.getPrefs().getAuthentication().user);
            XmlSerializerHelper.writeSimple(xmlserializer, "", "targetClient", targetClient);
            XmlSerializerHelper.writeSimple(xmlserializer, "", "recipientID", targetUsername);
            XmlSerializerHelper.writeSimple(xmlserializer, "", "locale", Locale.getDefault().toString());
            XmlSerializerHelper.writeSimple(xmlserializer, "", "osName", "Android");
            XmlSerializerHelper.writeSimple(xmlserializer, "", "osVersion", String.valueOf(android.os.Build.VERSION.SDK_INT));
            XmlSerializerHelper.writeSimple(xmlserializer, "", "appName", packageName);
            XmlSerializerHelper.writeSimple(xmlserializer, "", "notificationPlatform", type.getValue());
            XmlSerializerHelper.writeSimple(xmlserializer, "", "appVersion", getEbayContext().getAppInfo().getAppVersionName());
            Object obj = (ConnectivityManager)getContext().getSystemService("connectivity");
            if (obj != null)
            {
                Object obj1 = ((ConnectivityManager) (obj)).getNetworkInfo(0);
                String s1 = "";
                String s = s1;
                if (obj1 != null)
                {
                    obj1 = ((NetworkInfo) (obj1)).getState();
                    s = s1;
                    if (obj1 != null)
                    {
                        s = ((android.net.NetworkInfo.State) (obj1)).toString();
                    }
                }
                XmlSerializerHelper.writeSimple(xmlserializer, "", "mobileInterface", s);
                obj = ((ConnectivityManager) (obj)).getNetworkInfo(1);
                s1 = "";
                s = s1;
                if (obj != null)
                {
                    obj = ((NetworkInfo) (obj)).getState();
                    s = s1;
                    if (obj != null)
                    {
                        s = ((android.net.NetworkInfo.State) (obj)).toString();
                    }
                }
                XmlSerializerHelper.writeSimple(xmlserializer, "", "wifiInterface", s);
            }
            xmlserializer.endTag("", "notification");
        }

        public URL getRequestUrl()
        {
            URL url;
            try
            {
                url = new URL("http://scotch.criticalpath.com:8080/notification-timing/end");
            }
            catch (Exception exception)
            {
                return null;
            }
            return url;
        }

        public LogNotificationResponse getResponse()
        {
            return new LogNotificationResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public void onAddHeaders(IHeaders iheaders)
        {
            iheaders.setHeader("Content-type", "application/xml");
        }

        public LogNotificationRequest(String s, PlatformNotificationsEvent platformnotificationsevent, String s1, String s2, EbaySmartNotificationManager.NotificationType notificationtype)
        {
            event = platformnotificationsevent;
            targetClient = s1;
            targetUsername = s2;
            packageName = s;
            type = notificationtype;
        }
    }

    private static class LogNotificationResponse extends EbayResponse
    {

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }

        private LogNotificationResponse()
        {
        }

    }

    private final class LogNotificationResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final LogNotificationResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(LogNotificationResponse.this);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private LogNotificationResponse.RootElement()
        {
            this$0 = LogNotificationResponse.this;
            super();
        }

    }


    public static final int ACTION_RECEIVE_MESSAGE = 3;
    public static final int ACTION_REGISTRATION = 2;
    public static final int ACTION_UNREGISTER_C2DM = 4;
    public static final String AEAPP = "AEAPP";
    public static final String AMOTORS = "AMOTORS";
    public static final String AMOTORS_GCM = "AMOTORS_GCM";
    private static final String APP_EMAIL_ID = "ebaymobile2000@gmail.com";
    public static final String C2DM_RECEIVE = "com.google.android.c2dm.intent.RECEIVE";
    public static final String C2DM_REGISTER = "com.google.android.c2dm.intent.REGISTER";
    private static final int C2DM_REGISTER_MAX_RETRIES = 3;
    public static final String C2DM_REGISTRATION = "com.google.android.c2dm.intent.REGISTRATION";
    public static final String C2DM_UNREGISTER = "com.google.android.c2dm.intent.UNREGISTER";
    private static final boolean DAMPEN_DUPLICATES = false;
    private static final List EVENT_TYPES_AS_ITEM_OVERRIDES = Arrays.asList(new Integer[] {
        Integer.valueOf(8), Integer.valueOf(9)
    });
    private static final List EVENT_TYPES_WITH_LOCAL_OVERRIDES = Arrays.asList(new Integer[] {
        Integer.valueOf(1), Integer.valueOf(17), Integer.valueOf(35)
    });
    private static final String LOG_TAG = "PushService";
    private static final String NAME = "PushService";
    public static String PARAM_OUTBID_INTENT_FILTER = "com.ebay.mobile.notifications.pushservice.outbid";
    private static final String REG_ID = "registration_id";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("PushService", 3, "PushService log");
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTagLogging = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("NotificationLogging", 3, "Notification Logging to server on scotch");
    public static final String notificationLoggingEndpoint = "http://scotch.criticalpath.com:8080/notification-timing/end";
    private static final HashMap recentMessages = new HashMap();

    public PushService()
    {
        super("PushService");
    }

    private static String getSearchName(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            int i = s.indexOf('"');
            int j = s.lastIndexOf('"');
            int k = s.length();
            if (i >= 0 && j > i && j < k)
            {
                return s.substring(i + 1, j);
            }
        }
        return "";
    }

    private void handleEbayResponseErrors(com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException ebayrequesterrorexception)
    {
        if (EbayErrorUtil.userNotLoggedIn(ebayrequesterrorexception.getErrors()) && MyApp.getPrefs().isSignedIn())
        {
            MyApp.signOutForIafTokenFailure(null);
        }
    }

    public static void logNotificationInternal(EbayContext ebaycontext, String s, PlatformNotificationsEvent platformnotificationsevent, String s1, String s2, EbaySmartNotificationManager.NotificationType notificationtype)
    {
        if (platformnotificationsevent == null)
        {
            return;
        }
        s = new LogNotificationRequest(s, platformnotificationsevent, s1, s2, notificationtype);
        try
        {
            LocalEbayRequestHelper.sendRequest(ebaycontext, s);
            FwLog.println(logTagLogging, "success response");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (EbayContext ebaycontext)
        {
            FwLog.println(logTagLogging, "logNotificationInternal exception", ebaycontext);
        }
    }

    private void onReceive(Intent intent)
    {
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "received C2DM message");
        }
        String s = intent.getStringExtra("clientid");
        if (s != null && s.contains("_GCM"))
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, (new StringBuilder()).append("Discarding as client_id=").append(s).toString());
            }
        } else
        {
            EbaySmartNotificationManager.NotificationType notificationtype = EbaySmartNotificationManager.getCurrentConfiguration(this);
            if (notificationtype == EbaySmartNotificationManager.NotificationType.C2DM)
            {
                processNotification(intent, this);
                return;
            }
            if (notificationtype == EbaySmartNotificationManager.NotificationType.POLL && !EbaySmartNotificationManager.isInTransition())
            {
                if (logTag.isLoggable)
                {
                    FwLog.println(logTag, "ESNM reports POLL as current type, attempting to recover");
                }
                ServiceStarter.startNotificationManagerService(this);
                return;
            }
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, (new StringBuilder()).append("Discarding as ESNM reports current configuration as:").append(notificationtype).toString());
                return;
            }
        }
    }

    private void onRegistration(Intent intent)
        throws com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException
    {
        boolean flag1;
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        flag1 = false;
        ItemCache itemcache;
        String s;
        itemcache = new ItemCache(this);
        s = intent.getStringExtra("registration_id");
        if (intent.getStringExtra("error") == null) goto _L2; else goto _L1
_L1:
        int i;
        intent = intent.getStringExtra("error");
        itemcache.setC2dmRegError(intent);
        Log.w("PushService", (new StringBuilder()).append("onRegistration: errors=").append(intent).toString());
        i = itemcache.getC2dmRegRetries();
        if (!"ACCOUNT_MISSING".equals(intent) && !"SERVICE_NOT_AVAILABLE".equals(intent) && !"QuotaExceeded".equals(intent)) goto _L4; else goto _L3
_L3:
        long l;
        l = System.currentTimeMillis();
        intent = MyApp.getPrefs();
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        intent.setUserPref(l, "notifications_timestamp_of_last_service_failure");
        Log.e("PushService", (new StringBuilder()).append("onRegistration: failed google account not setup, give up - retry possible in 6 hours (current time ").append(l).append(")").toString());
        boolean flag = true;
_L9:
        if (flag)
        {
            ServiceStarter.instructNotificationManagerService(this, 9);
        }
_L6:
        return;
_L4:
        flag = flag1;
        if (i <= 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        itemcache.setC2dmRegRetries(i + 1);
        Log.e("PushService", (new StringBuilder()).append("onRegistration: failed ").append(i).append(" times, give up").toString());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L2:
        if (intent.getStringExtra("unregistered") == null)
        {
            break MISSING_BLOCK_LABEL_303;
        }
        flag = flag1;
        if (EbaySmartNotificationManager.getCurrentConfiguration(this) != EbaySmartNotificationManager.NotificationType.C2DM)
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.w("PushService", "onRegistration: Got unregister response");
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        intent;
        if (false)
        {
            ServiceStarter.instructNotificationManagerService(this, 9);
        }
        throw intent;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_466;
        }
        itemcache.setC2dmRegRetries(0);
        itemcache.setC2dmRegError("");
        intent = MyApp.getPrefs().getAuthentication();
        if (intent != null)
        {
            break MISSING_BLOCK_LABEL_349;
        }
        Log.w("PushService", "onRegistration: No auth, not signed in, exiting");
        if (false) goto _L6; else goto _L5
_L5:
        ServiceStarter.instructNotificationManagerService(this, 9);
        return;
        if (((Authentication) (intent)).iafToken != null)
        {
            break MISSING_BLOCK_LABEL_376;
        }
        Log.w("PushService", "onRegistration: Null IAF token, exiting");
        if (false) goto _L6; else goto _L7
_L7:
        ServiceStarter.instructNotificationManagerService(this, 9);
        return;
        intent = ((Authentication) (intent)).user;
        itemcache.setRegistrationId(intent, s);
        flag = flag1;
        if (EbaySmartNotificationManager.getTransitionState() != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        FwLog.println(logTag, (new StringBuilder()).append("onRegistration: get and saved new REG ID, calling load, uid=").append(intent).append(", regid=").append(s).toString());
        intent = new Bundle();
        intent.putSerializable("type", EbaySmartNotificationManager.NotificationType.C2DM);
        ServiceStarter.instructNotificationManagerService(this, 10, intent);
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        flag = true;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static void processNotification(Intent intent, Service service)
    {
        processNotification(intent, service, EbaySmartNotificationManager.NotificationType.C2DM);
    }

    public static void processNotification(Intent intent, Service service, EbaySmartNotificationManager.NotificationType notificationtype)
    {
        NotificationPreferenceManager notificationpreferencemanager;
        Object obj1;
        DeviceConfiguration deviceconfiguration;
        int j;
        obj1 = MyApp.getDeviceConfiguration();
        deviceconfiguration = ((DcsHelper) (obj1)).getConfig();
        notificationpreferencemanager = new NotificationPreferenceManager(service);
        j = 0;
        if (!deviceconfiguration.get(DcsBoolean.KillSwitch)) goto _L2; else goto _L1
_L1:
        FwLog.println(logTag, "processNotification: kill switch enabled, discarding");
_L11:
        return;
_L2:
        String s;
        Object obj;
        String s3;
        String s4;
        ItemCache itemcache;
        Object obj2;
        int i;
        int k;
        String s5;
label0:
        {
label1:
            {
                s5 = intent.getStringExtra("rid");
                if (TextUtils.isEmpty(s5))
                {
                    NotificationTrackingUtil.createAndSendNotificationErrorEvent(service, NotificationTrackingUtil.ErrorType.REF_ID_EMPTY, null);
                }
                String s1 = intent.getStringExtra("evt");
                s = s1;
                if (s1 == null)
                {
                    if (intent.getStringExtra("badge") == null)
                    {
                        break label1;
                    }
                    String s2 = com.ebay.common.model.mdns.NotificationPreference.EventType.INTERNAL_BADGE.name();
                    Authentication authentication = MyApp.getPrefs().getAuthentication();
                    s = s2;
                    if (authentication != null)
                    {
                        intent.putExtra("usr", authentication.user);
                        s = s2;
                    }
                }
                k = NotificationPreference.nameToId(s);
                if (k == 27)
                {
                    if (NotificationTrackingUtil.isTrackingEnabled(notificationtype) && !TextUtils.isEmpty(s5))
                    {
                        NotificationTrackingUtil.sendEvent(service, NotificationTrackingUtil.createNotificationReceivedTrackingData(s5));
                        return;
                    }
                    continue; /* Loop/switch isn't completed */
                }
                break label0;
            }
            NotificationTrackingUtil.createAndSendNotificationErrorEvent(service, NotificationTrackingUtil.ErrorType.MISSING_EVENT_TYPE, s5);
            Log.w("PushService", "processNotification: No event type received, ingoring");
            return;
        }
label2:
        {
            obj = intent.getStringExtra("usr");
            if (obj == null)
            {
                NotificationTrackingUtil.createAndSendNotificationErrorEvent(service, NotificationTrackingUtil.ErrorType.NO_USERNAME, intent.getStringExtra("rid"));
                FwLog.println(logTag, "processNotification: No user specified in notification, exiting");
                return;
            }
            String s6 = ((String) (obj)).trim();
            obj = MyApp.getPrefs().getAuthentication();
            if (obj == null)
            {
                NotificationTrackingUtil.createAndSendNotificationErrorEvent(service, NotificationTrackingUtil.ErrorType.NOT_LOGGED_IN, intent.getStringExtra("rid"));
                FwLog.println(logTag, "processNotification: User not signed in, discarding notification");
                return;
            }
            s3 = ((Authentication) (obj)).user;
            if (!s6.equalsIgnoreCase(s3))
            {
                NotificationTrackingUtil.createAndSendNotificationErrorEvent(service, NotificationTrackingUtil.ErrorType.MISMATCHED_USERS, intent.getStringExtra("rid"));
                FwLog.println(logTag, (new StringBuilder()).append("processNotification: User for notification: ").append(s6).append(" does not match logged in user: ").append(s3).append(" discarding notification").toString());
                j = 1;
            }
            String s7 = intent.getStringExtra("device");
            obj2 = intent.getStringExtra("tid");
            Object obj3 = intent.getStringExtra("odr");
            itemcache = new ItemCache(service);
            s4 = MyApp.getPrefs().getCurrentUser();
            if (notificationtype == EbaySmartNotificationManager.NotificationType.GCM)
            {
                obj = itemcache.getGCMRegistrationId(s4);
            } else
            {
                obj = itemcache.getRegistrationId(s4);
            }
            i = j;
            if (s7 != null)
            {
                i = j;
                if (obj != null)
                {
                    i = j;
                    if (!((String) (obj)).equals(s7))
                    {
                        NotificationUtil.deactivateMdnsOldToken(service, s7, EbaySmartNotificationManager.NotificationType.C2DM);
                        NotificationTrackingUtil.createAndSendNotificationErrorEvent(service, NotificationTrackingUtil.ErrorType.MISMATCHED_TOKENS, s5);
                        FwLog.println(logTag, (new StringBuilder()).append("processNotification: Device for notification: ").append(s7).append(" does not match our current token: ").append(((String) (obj))).append(" discarding notification").toString());
                        i = 1;
                    }
                }
            }
            if (k == 28)
            {
                if (!deviceconfiguration.get(DcsBoolean.Symban))
                {
                    FwLog.println(logTag, "processNotification: INTERNAL_BADGE badge count ignored, discarding notification");
                    return;
                }
                intent = intent.getStringExtra("badge");
                try
                {
                    i = Integer.parseInt(intent);
                    SymbanDataManager.setCount(((FwContext)service).getEbayContext(), i);
                    EbayBroadcast.sendSymbanUpdateBroadcast(service);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Intent intent)
                {
                    FwLog.println(logTag, "processNotification: INTERNAL_BADGE badge count missing or malformed, discarding notification");
                }
                return;
            }
            System.currentTimeMillis();
            obj = intent.getStringExtra("collapse_key");
            FwLog.println(logTag, (new StringBuilder()).append("collapseKey = ").append(((String) (obj))).append(" thread=").append(Thread.currentThread().getName()).toString());
            if (obj != null)
            {
                ((String) (obj)).trim().toLowerCase(Locale.US);
            }
            obj = PlatformNotificationsEvent.createEvent(k, s);
            if (k == 18)
            {
                ((com.ebay.common.model.mdns.PlatformNotificationsEvent.CouponAvailableEvent)obj).setInfo(intent);
            } else
            {
                obj.itemId = intent.getStringExtra("itm");
            }
            obj.refId = s5;
            obj.transactionId = ((String) (obj2));
            if (!TextUtils.isEmpty(((CharSequence) (obj3))) && !"null".equals(obj3))
            {
                obj.orderId = ((String) (obj3));
            }
            if (TextUtils.isEmpty(((PlatformNotificationsEvent) (obj)).orderId) && !TextUtils.isEmpty(((PlatformNotificationsEvent) (obj)).itemId) && !TextUtils.isEmpty(((PlatformNotificationsEvent) (obj)).transactionId))
            {
                obj.orderId = (new StringBuilder()).append(((PlatformNotificationsEvent) (obj)).itemId).append("-").append(((PlatformNotificationsEvent) (obj)).transactionId).toString();
            }
            if (k == 36 || k == 37)
            {
                if (!deviceconfiguration.get(DcsBoolean.Verticals_dealsNotifications))
                {
                    FwLog.println(logTag, "processNotification: DailyDeals and DealsFrenzy are disabled, discarding notification");
                    return;
                }
                notificationpreferencemanager.setEventEnabled(s3, NotificationPreferenceManager.CombinedEvent.GENERAL_DEALS, true);
                obj.header = intent.getStringExtra("header");
                obj.content = intent.getStringExtra("content");
            }
            if (k == 39)
            {
                if (!deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Connect.B.dealMakerNotification))
                {
                    FwLog.println(logTag, "processNotification: Deal Maker notifications are disabled, discarding notification");
                    return;
                }
                notificationpreferencemanager.setEventEnabled(s3, NotificationPreferenceManager.CombinedEvent.BUYING_ITEM_DISCOUNTS, true);
                obj.header = intent.getStringExtra("header");
                obj.content = intent.getStringExtra("content");
            }
            if (k == 38)
            {
                if (!deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Connect.B.dealMakerNotification))
                {
                    FwLog.println(logTag, "processNotification: Deal Maker notifications are disabled, discarding notification");
                    return;
                }
                notificationpreferencemanager.setEventEnabled(s3, NotificationPreferenceManager.CombinedEvent.BUYING_ITEM_DISCOUNTS, true);
                obj.header = intent.getStringExtra("header");
                obj.content = intent.getStringExtra("content");
                obj.itemId = intent.getStringExtra("itm");
            }
            if (k == 0 || k == 1)
            {
                obj2 = intent.getStringExtra("currency");
                s = intent.getStringExtra("curbid");
                if (obj2 != null && s != null)
                {
                    try
                    {
                        obj.currentPrice = new CurrencyAmount(s, ((String) (obj2)));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj2)
                    {
                        if (Log.isLoggable("PushService", 5))
                        {
                            Log.w("PushService", (new StringBuilder()).append("Unable to parse current bid of ").append(s).toString());
                        }
                    }
                }
                s = intent.getStringExtra("itemListingType");
                if (s != null)
                {
                    obj.itemType = com.ebay.common.model.mdns.PlatformNotificationsEvent.ItemListingType.fromListingType(s, Boolean.parseBoolean(intent.getStringExtra("buyItNowAvailable")));
                }
                obj.title = intent.getStringExtra("itemTitle");
                s = intent.getStringExtra("\titemEndTime");
                if (s != null)
                {
                    try
                    {
                        obj.endTimestamp = DateFormat.getDateTimeInstance().parse(s).getTime();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj2)
                    {
                        if (Log.isLoggable("PushService", 5))
                        {
                            Log.w("PushService", (new StringBuilder()).append("Unable to parse datetime in data.itemEndTime: ").append(s).toString());
                        }
                    }
                }
            }
            if (k == 19)
            {
                obj.draftId = intent.getStringExtra("did");
                obj.listingMode = intent.getStringExtra("lmode");
                obj.siteId = intent.getStringExtra("site");
                if (TextUtils.isEmpty(((PlatformNotificationsEvent) (obj)).siteId))
                {
                    obj.siteId = MyApp.getCurrentSite();
                }
            } else
            if (k >= 21 && k <= 23)
            {
                obj.itemId = ((PlatformNotificationsEvent) (obj)).orderId;
            }
            s = intent.getStringExtra("clientid");
            if ("AMOTORS".equals(s) || "AMOTORS_GCM".equals(s))
            {
                obj.clientId = "AMOTORS";
            } else
            {
                obj.clientId = "AEAPP";
            }
            obj2 = intent.getStringExtra("title");
            if (k != 2)
            {
                break MISSING_BLOCK_LABEL_1983;
            }
            obj3 = (com.ebay.common.model.mdns.PlatformNotificationsEvent.SavedSearchEvent)obj;
            if (deviceconfiguration.get(DcsBoolean.searchSavedSearchUseFollowInterest))
            {
                obj3.searchIds = intent.getStringExtra("instid");
            } else
            {
                obj3.searchIds = intent.getStringExtra("sid");
            }
            obj3.title = getSearchName(((String) (obj2)));
            if (((com.ebay.common.model.mdns.PlatformNotificationsEvent.SavedSearchEvent) (obj3)).searchIds != null)
            {
                j = i;
                if (!((com.ebay.common.model.mdns.PlatformNotificationsEvent.SavedSearchEvent) (obj3)).searchIds.isEmpty())
                {
                    break label2;
                }
            }
            Log.d("PushService", "Saved search notification has no ids for the current provider");
            j = 1;
        }
_L3:
label3:
        {
            obj2 = logTag;
            obj3 = (new StringBuilder()).append("processNotification: type=").append(((PlatformNotificationsEvent) (obj)).eventType).append(", itemid=").append(((PlatformNotificationsEvent) (obj)).itemId).append(", title=").append(((PlatformNotificationsEvent) (obj)).title).append(", clientid=");
            if (s != null)
            {
                intent = s;
            } else
            {
                intent = "<null>";
            }
            FwLog.println(((com.ebay.nautilus.kernel.util.FwLog.LogInfo) (obj2)), ((StringBuilder) (obj3)).append(intent).toString());
            if (logTagLogging.isLoggable)
            {
                logNotificationInternal(((FwContext)service).getEbayContext(), service.getPackageName(), ((PlatformNotificationsEvent) (obj)), s, s6, notificationtype);
            }
            if (j == 0 && NotificationTrackingUtil.isTrackingEnabled(notificationtype) && !TextUtils.isEmpty(s5))
            {
                NotificationTrackingUtil.sendEvent(service, NotificationTrackingUtil.createNotificationReceivedTrackingData(s5));
            }
            i = j;
            if (j == 0)
            {
                i = j;
                if (!deviceconfiguration.get(DcsBoolean.Coupons))
                {
                    i = j;
                    if (k == 18)
                    {
                        Log.d("PushService", "Coupon notification received but DCS disabled, discarding");
                        i = 1;
                    }
                }
            }
            j = i;
            if (i != 0)
            {
                break label3;
            }
            j = i;
            if (deviceconfiguration.get(DcsBoolean.eBayNow))
            {
                break label3;
            }
            if (k != 26)
            {
                j = i;
                if (k != 25)
                {
                    break label3;
                }
            }
            Log.d("PushService", (new StringBuilder()).append("eBay Now disabled in DCS, discarding event=").append(((PlatformNotificationsEvent) (obj)).toString()).toString());
            j = 1;
        }
        i = j;
        if (j == 0)
        {
            i = j;
            if (!((DcsHelper) (obj1)).isBopisEnabled())
            {
                i = j;
                if (k >= 21)
                {
                    i = j;
                    if (k <= 23)
                    {
                        Log.d("PushService", (new StringBuilder()).append("BOPIS disabled in DCS, discarding event=").append(((PlatformNotificationsEvent) (obj)).toString()).toString());
                        i = 1;
                    }
                }
            }
        }
        j = i;
        if (i == 0)
        {
            j = i;
            if (deviceconfiguration.get(DcsBoolean.LocalNotifications))
            {
                j = i;
                if (EVENT_TYPES_WITH_LOCAL_OVERRIDES.contains(Integer.valueOf(k)))
                {
                    j = i;
                    if (itemcache.isEventInEventDatabase(((PlatformNotificationsEvent) (obj))))
                    {
                        Log.d("PushService", (new StringBuilder()).append("Event already in database, discarding event=").append(((PlatformNotificationsEvent) (obj)).toString()).toString());
                        j = 1;
                    }
                }
            }
        }
        if (j != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (k == 2 && (obj instanceof com.ebay.common.model.mdns.PlatformNotificationsEvent.SavedSearchEvent))
        {
            notificationtype = (com.ebay.common.model.mdns.PlatformNotificationsEvent.SavedSearchEvent)obj;
            intent = notificationpreferencemanager.getNotifyEnabledSavedSearchIdList(s4);
            notificationtype = notificationtype.searchIdsToArray();
            j = notificationtype.length;
            for (i = 0; i < j; i++)
            {
                obj1 = notificationtype[i];
                if (!intent.contains(obj1))
                {
                    notificationpreferencemanager.addNotifyEnabledSavedSearchId(s4, ((String) (obj1)));
                }
            }

        }
        break MISSING_BLOCK_LABEL_2060;
        if (obj2 == null || ((String) (obj2)).trim().length() == 0)
        {
            Log.d("PushService", "No title found in notification, let's continue with default title");
            j = i;
        } else
        {
            j = i;
            if (TextUtils.isEmpty(((PlatformNotificationsEvent) (obj)).title))
            {
                obj.title = ((String) (obj2));
                ((PlatformNotificationsEvent) (obj)).title.trim();
                j = i;
            }
        }
          goto _L3
        if (!EVENT_TYPES_AS_ITEM_OVERRIDES.contains(Integer.valueOf(k))) goto _L5; else goto _L4
_L4:
        k;
        JVM INSTR tableswitch 8 9: default 2100
    //                   8 2262
    //                   9 2281;
           goto _L6 _L7 _L8
_L6:
        (new Handler(Looper.getMainLooper())).post(new Runnable(service, s4) {

            final Service val$context;
            final String val$userId;

            public void run()
            {
                ((MyEbayBuyingDataManager)MyEbayBuyingDataManager.get(((FwContext)context).getEbayContext(), new com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager.KeyParams(userId))).forceReloadWonList();
            }

            
            {
                context = service;
                userId = s;
                super();
            }
        });
_L5:
        notificationpreferencemanager.setLastActivationTimeMdns(s4, s, System.currentTimeMillis());
        itemcache.insertEventOnDuplicateUpdate(((PlatformNotificationsEvent) (obj)));
        intent = itemcache.getUnviewedEvents(Long.parseLong("15") * 60L * 1000L);
        if (intent != null && !intent.isEmpty())
        {
            notificationtype = intent.iterator();
            do
            {
                if (!notificationtype.hasNext())
                {
                    break;
                }
                PlatformNotificationsEvent platformnotificationsevent = (PlatformNotificationsEvent)notificationtype.next();
                if (!"OTHER".equals(platformnotificationsevent.eventType) && !notificationpreferencemanager.isEventEnabled(s4, platformnotificationsevent.eventType))
                {
                    Log.w("PushService", (new StringBuilder()).append("processNotification: notification disabled but still receive it, type: ").append(platformnotificationsevent.eventType).toString());
                    notificationtype.remove();
                }
            } while (true);
            break MISSING_BLOCK_LABEL_2298;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        ServiceContentOverride.setPaidStatus(((PlatformNotificationsEvent) (obj)).getSafeItemId(), ((PlatformNotificationsEvent) (obj)).transactionId, "Paid");
        continue; /* Loop/switch isn't completed */
_L8:
        ServiceContentOverride.setShipped(((PlatformNotificationsEvent) (obj)).getSafeItemId(), ((PlatformNotificationsEvent) (obj)).transactionId, true);
        if (true) goto _L6; else goto _L9
_L9:
        service = new EbayNotificationManager(service, ((FwContext)service).getEbayContext());
        service.setCurrentUser(s3);
        service.createNotifications(intent);
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private static void putRecentMessage(Context context, String s, long l)
    {
    }

    private void unregister()
    {
        NotificationUtil.deactivateMdns(this, EbaySmartNotificationManager.NotificationType.C2DM, MyApp.getPrefs().getAuthentication(), "AEAPP", "C2DM");
        Object obj = new NotificationPreferenceManager(this);
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication == null)
        {
            FwLog.println(logTag, "unregister: not signed in, exiting");
            return;
        } else
        {
            ((NotificationPreferenceManager) (obj)).unregister(authentication.user);
            (new ItemCache(this)).removeAllData();
            obj = new Intent("com.google.android.c2dm.intent.UNREGISTER");
            ((Intent) (obj)).putExtra("app", PendingIntent.getBroadcast(this, 0, new Intent(), 0));
            startService(((Intent) (obj)));
            return;
        }
    }

    protected void onHandleIntent(Intent intent)
    {
        int i;
        i = intent.getIntExtra("push_action", 3);
        Log.i("PushService", (new StringBuilder()).append("onHandleIntent: action=").append(i).append(", intent data=").append(intent.getExtras().toString()).toString());
        i;
        JVM INSTR tableswitch 2 4: default 80
    //                   2 84
    //                   3 102
    //                   4 116;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_116;
_L5:
        SharedWakeLock.releaseLock();
        return;
_L2:
        onRegistration(intent);
          goto _L5
        intent;
        handleEbayResponseErrors(intent);
        SharedWakeLock.releaseLock();
        return;
_L3:
        onReceive(intent);
          goto _L5
        intent;
        SharedWakeLock.releaseLock();
        throw intent;
        unregister();
          goto _L5
    }

}
