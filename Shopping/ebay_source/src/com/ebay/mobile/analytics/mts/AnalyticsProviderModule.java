// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics.mts;

import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.ebay.mobile.analytics.AnalyticsProvider;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.FwContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.mobile.analytics.mts:
//            TrackEventRequest

public class AnalyticsProviderModule
    implements AnalyticsProvider
{

    private static final int MAX_BATCH_SIZE = 10;
    private static final String MTS_PREFS_COOKIE_KEY = "com.ebay.mobile.analytics.mts.cookie";
    private static final String MTS_PREFS_FILE = "com.ebay.mobile.analytics.mts.preferences";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo verboseLogger;
    private final List batch = new ArrayList(11);
    private Bundle sessionData;

    public AnalyticsProviderModule()
    {
    }

    private void addToBatch(TrackingData trackingdata)
    {
        String s;
        int j;
        byte byte0;
        int k;
        byte0 = -1;
        trackingdata.addKeyValuePair("eventTimestamp", getBatchTimestamp());
        s = trackingdata.getName();
        k = batch.size();
        j = byte0;
        if (!"Foreground".equals(s)) goto _L2; else goto _L1
_L1:
        j = byte0;
        if (k <= 0) goto _L2; else goto _L3
_L3:
        j = 0;
_L9:
        int i = byte0;
        if (j >= k) goto _L5; else goto _L4
_L4:
        boolean flag = shouldIgnoreEventLocationInBatch((TrackingData)batch.get(j));
        if (flag) goto _L7; else goto _L6
_L6:
        i = j;
_L5:
        j = i;
        if (i != -1)
        {
            TrackingData trackingdata1 = (TrackingData)batch.get(i);
            String s1 = trackingdata1.getValueForKey("eventTimestamp");
            trackingdata1.addKeyValuePair("eventTimestamp", trackingdata.getValueForKey("eventTimestamp"));
            trackingdata.addKeyValuePair("eventTimestamp", s1);
            j = i;
        }
_L2:
        IndexOutOfBoundsException indexoutofboundsexception;
        if (j == -1)
        {
            batch.add(trackingdata);
            return;
        } else
        {
            batch.add(j, trackingdata);
            return;
        }
        indexoutofboundsexception;
_L7:
        j++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private boolean doesEventWarrantMtsFlush(TrackingData trackingdata)
    {
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        for (String s = trackingdata.getName(); "Foreground".equals(s) || "Install".equals(s) || "Referral".equals(s) || "PromotedListingClick".equals(s) || deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.ViewItem.B.realtimeMtsFlush) && "ViewItem".equals(s) || trackingdata.getTrackingType() == TrackingType.ROI;)
        {
            return true;
        }

        return false;
    }

    private boolean doesSessionDataWarrantFlush(Bundle bundle)
    {
        boolean flag1;
        boolean flag2;
        flag1 = false;
        flag2 = flag1;
        if (sessionData == null) goto _L2; else goto _L1
_L1:
        flag2 = flag1;
        if (bundle == null) goto _L2; else goto _L3
_L3:
        String s;
        String s1;
        s1 = bundle.getString("ids");
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        String s2 = sessionData.getString("ids");
        s1 = s2;
        if (s2 == null)
        {
            s1 = "";
        }
        boolean flag;
        if (!s.equals(s1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag2 = false | flag;
        s = sessionData.getString("iafToken");
        s1 = bundle.getString("iafToken");
        if (s == null || s.equals(s1)) goto _L5; else goto _L4
_L4:
        flag1 = true;
_L7:
        if (bundle.containsKey("usecase"))
        {
            sessionData.putString("usecase", bundle.getString("usecase"));
            s = bundle.getString("mppid");
            if (s != null)
            {
                sessionData.putString("mppid", s);
            }
            s = bundle.getString("rlutype");
            if (s != null)
            {
                sessionData.putString("rlutype", s);
            }
        }
        flag2 = flag1;
        if (bundle.containsKey("gadid"))
        {
            flag2 = flag1;
            if (!sessionData.containsKey("gadid"))
            {
                sessionData.putString("gadid", bundle.getString("gadid"));
                flag2 = flag1;
            }
        }
_L2:
        return flag2;
_L5:
        flag1 = flag2;
        if (s == null)
        {
            flag1 = flag2;
            if (s1 != null)
            {
                sessionData.putString("iafToken", s1);
                flag1 = flag2;
            }
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    private String getBatchTimestamp()
    {
        return EbayDateUtils.formatIso8601DateTimeUtc(new Date());
    }

    static String getCookie(Context context)
    {
        return context.getSharedPreferences("com.ebay.mobile.analytics.mts.preferences", 0).getString("com.ebay.mobile.analytics.mts.cookie", "");
    }

    private boolean isTerminatingEvent(String s)
    {
        return "Background".equals(s);
    }

    static void saveCookie(Context context, String s)
    {
        context = context.getSharedPreferences("com.ebay.mobile.analytics.mts.preferences", 0).edit();
        context.putString("com.ebay.mobile.analytics.mts.cookie", s);
        context.commit();
    }

    private void sendRequest(Service service)
    {
        if (sessionData != null && batch != null)
        {
            try
            {
                com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(((FwContext)service).getEbayContext(), new TrackEventRequest(service, sessionData, batch));
            }
            // Misplaced declaration of an exception variable
            catch (Service service)
            {
                service.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (Service service)
            {
                service.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (Service service)
            {
                service.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (Service service)
            {
                service.printStackTrace();
            }
            batch.clear();
            sessionData = null;
        }
    }

    private void setSessionData(Bundle bundle)
    {
        sessionData = bundle;
    }

    private boolean shouldFlushIfOnlyEventInBatch(String s)
    {
        return batch.size() == 1 && ("NotificationReceived".equals(s) || "BundledNotificationsReceived".equals(s) || "NotificationAction".equals(s) || "NotificationError".equals(s));
    }

    private boolean shouldIgnoreEventLocationInBatch(TrackingData trackingdata)
    {
        trackingdata = trackingdata.getName();
        return "NotificationReceived".equals(trackingdata) || "NotificationAction".equals(trackingdata) || "NotificationError".equals(trackingdata);
    }

    public void start(Service service, TrackingData trackingdata)
    {
        this;
        JVM INSTR monitorenter ;
        if (debugLogger.isLoggable)
        {
            FwLog.logMethod(debugLogger, new Object[] {
                service, trackingdata
            });
        }
        if (service != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        obj = trackingdata.getSessionData();
        trackingdata.clearSessionData();
        if (sessionData != null) goto _L4; else goto _L3
_L3:
        setSessionData(((Bundle) (obj)));
_L6:
        addToBatch(trackingdata);
        obj = trackingdata.getName();
        if (!shouldFlushIfOnlyEventInBatch(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_116;
        }
        sendRequest(service);
          goto _L1
        service;
        throw service;
_L4:
        if (!doesSessionDataWarrantFlush(((Bundle) (obj))) && !trackingdata.requiresFlush()) goto _L6; else goto _L5
_L5:
        sendRequest(service);
        setSessionData(((Bundle) (obj)));
          goto _L6
label0:
        {
            if (batch.size() < 10 || "BidState".equals(obj))
            {
                break label0;
            }
            sendRequest(service);
        }
          goto _L1
        if (!isTerminatingEvent(((String) (obj)))) goto _L8; else goto _L7
_L7:
        sendRequest(service);
          goto _L1
_L8:
        if (!doesEventWarrantMtsFlush(trackingdata)) goto _L1; else goto _L9
_L9:
        sendRequest(service);
          goto _L1
    }

    static 
    {
        debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ebayMtsAnalytics", 3, "Log eBay MTS Analytics events");
        verboseLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(debugLogger.tag, 2, "Log extended eBay MTS Analytics events");
    }
}
