// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import android.content.Context;
import android.view.View;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.httpcomponentsandroid.client.utils.URIUtils;
import com.comcast.playerplatform.analytics.java.AnalyticsProvider;
import com.comcast.playerplatform.analytics.java.xmessage.messages.GenericTupleMessage;
import com.comcast.playerplatform.primetime.android.events.AbstractPlayerPlatformVideoEventListener;
import com.comcast.playerplatform.primetime.android.player.IPlayerPlatform;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import com.comcast.playerplatform.util.android.Clock;
import com.comcast.playerplatform.util.android.StringUtil;
import com.comcast.playerplatform.util.android.XrestHelper;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

// Referenced classes of package com.comcast.playerplatform.primetime.android.eas:
//            AlertResponseHandler, AlertZipResponseHandler, AlertAnimationManager, EmergencyAlertSettings, 
//            Alert, AlertEventListener

public class EmergencyAlertProvider
{

    private static EmergencyAlertProvider instance;
    private Vector activeAlerts;
    private AlertEventListener alertEventListener;
    private com.comcast.playerplatform.util.android.Clock.ClockEventListener alertReadyClockListener;
    private Clock alertReadyTimer;
    private AlertResponseHandler alertResponseHandler;
    private URI alertServiceUrl;
    private AlertAnimationManager animationManager;
    private Context applicationContext;
    private HttpClient httpClient;
    private boolean isEANActive;
    private boolean isPaused;
    private boolean isScrolling;
    private Vector listeners;
    private Hashtable oldAlerts;
    private IPlayerPlatform playerPlatform;
    private com.comcast.playerplatform.util.android.Clock.ClockEventListener pollingClockTick;
    private long pollingInterval;
    private boolean pollingIsReady;
    private Clock pollingTimer;
    private HashMap requestHeaders;
    private EmergencyAlertSettings settings;
    private AlertZipResponseHandler zipResponseHandler;

    private EmergencyAlertProvider()
    {
        alertEventListener = new AlertEventListener() {

            final EmergencyAlertProvider this$0;

            public void emergencyAlertCompleted(String s, boolean flag)
            {
                if (flag) goto _L2; else goto _L1
_L1:
                Vector vector = listeners;
                vector;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).emergencyAlertCompleted(s)) { }
                break MISSING_BLOCK_LABEL_58;
                s;
                vector;
                JVM INSTR monitorexit ;
                throw s;
                vector;
                JVM INSTR monitorexit ;
_L2:
                isScrolling = false;
                return;
            }

            public void emergencyAlertFailed(String s, String s1, String s2, boolean flag)
            {
                isScrolling = false;
                generateEasFailure(s1, s2);
            }

            public void emergencyAlertStarted(String s, boolean flag)
            {
                isScrolling = true;
                if (flag) goto _L2; else goto _L1
_L1:
                Vector vector = listeners;
                vector;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).emergencyAlertStarted(s)) { }
                break MISSING_BLOCK_LABEL_67;
                s;
                vector;
                JVM INSTR monitorexit ;
                throw s;
                vector;
                JVM INSTR monitorexit ;
_L2:
            }

            public void fipsCodeFound(String s)
            {
                if (StringUtil.isNotNullOrEmpty(s))
                {
                    appendPollingUriWithFips(s);
                    pollingIsReady = true;
                    initClock();
                    return;
                } else
                {
                    generateEasFailure("9006", "Fips code not found");
                    return;
                }
            }

            public void requestFailed(String s)
            {
                generateEasFailure("9005", (new StringBuilder()).append("EAS Network Request Failed:").append(String.valueOf(s)).toString());
            }

            public void updateAlertsReceived(ArrayList arraylist)
            {
                updateActiveAlerts(arraylist);
            }

            
            {
                this$0 = EmergencyAlertProvider.this;
                super();
            }
        };
        pollingClockTick = new com.comcast.playerplatform.util.android.Clock.ClockEventListener() {

            final EmergencyAlertProvider this$0;

            public void onTick(String s)
            {
                playAlertIfReady();
                ThreadManager.getInstance().executeRunnable(new XrestHelper("", alertServiceUrl.toString(), "GET", requestHeaders, alertResponseHandler, httpClient, null));
            }

            
            {
                this$0 = EmergencyAlertProvider.this;
                super();
            }
        };
        alertReadyClockListener = new com.comcast.playerplatform.util.android.Clock.ClockEventListener() {

            final EmergencyAlertProvider this$0;

            public void onTick(String s)
            {
                playAlertIfReady();
            }

            
            {
                this$0 = EmergencyAlertProvider.this;
                super();
            }
        };
        listeners = new Vector();
        alertResponseHandler = new AlertResponseHandler(alertEventListener);
        zipResponseHandler = new AlertZipResponseHandler(alertEventListener);
        animationManager = new AlertAnimationManager();
        activeAlerts = new Vector();
        oldAlerts = new Hashtable();
        settings = new EmergencyAlertSettings();
        requestHeaders = new HashMap();
        requestHeaders.put("Origin", "http://player.xcal.tv");
    }

    private boolean alertsNeedPlaying()
    {
        this;
        JVM INSTR monitorenter ;
        if (activeAlerts.isEmpty() || isPaused || isScrolling) goto _L2; else goto _L1
_L1:
        Alert alert = animationManager.getCurrentAlert();
        if (alert != null) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    private void appendPollingUriWithFips(String s)
    {
        alertServiceUrl = URIUtils.resolve(alertServiceUrl, s);
    }

    private void checkForEan(ArrayList arraylist)
    {
        boolean flag = false;
        arraylist = arraylist.iterator();
        do
        {
            if (!arraylist.hasNext())
            {
                break;
            }
            if (((Alert)arraylist.next()).getIdentifier().equals(animationManager.getCurrentAlert().getIdentifier()))
            {
                flag = true;
            }
        } while (true);
        if (!flag)
        {
            stopEmergencyActionNotification();
        }
    }

    private void destroyAlertReadyClock()
    {
        if (alertReadyTimer != null)
        {
            synchronized (alertReadyTimer)
            {
                alertReadyTimer.stop();
                alertReadyTimer.removeClockEventListener(alertReadyClockListener);
                alertReadyTimer = null;
            }
            return;
        } else
        {
            return;
        }
        exception;
        clock;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void displayNextAlert()
    {
        this;
        JVM INSTR monitorenter ;
        animationManager.displayAlert(playerPlatform, applicationContext, settings, alertEventListener, (Alert)activeAlerts.remove(0));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void generateEasFailure(String s, String s1)
    {
        if (listeners != null)
        {
            for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).emergencyAlertFailed(s, s1)) { }
        }
        Hashtable hashtable = new Hashtable();
        hashtable.put("code", String.valueOf(s));
        hashtable.put("description", String.valueOf(s1));
        if (alertServiceUrl != null)
        {
            s = alertServiceUrl.toString();
        } else
        {
            s = null;
        }
        hashtable.put("alertEndpoint", s);
        AnalyticsProvider.getInstance().buildMessage(new GenericTupleMessage((new Date()).getTime(), "xuaEASFailure", hashtable, null));
    }

    public static EmergencyAlertProvider getInstance()
    {
        com/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;
        JVM INSTR monitorenter ;
        EmergencyAlertProvider emergencyalertprovider;
        if (instance == null)
        {
            instance = new EmergencyAlertProvider();
        }
        emergencyalertprovider = instance;
        com/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;
        JVM INSTR monitorexit ;
        return emergencyalertprovider;
        Exception exception;
        exception;
        throw exception;
    }

    private void initAlertReadyClock()
    {
        if (alertReadyTimer != null)
        {
            destroyAlertReadyClock();
        }
        alertReadyTimer = new Clock("alertReadyTimer", settings.getAlertPollingInterval());
        alertReadyTimer.addClockEventListener(alertReadyClockListener);
        alertReadyTimer.start();
    }

    private void initClock()
    {
        this;
        JVM INSTR monitorenter ;
        if (pollingIsReady && !isPaused)
        {
            pollingTimer = new Clock("alertProviderClock", pollingInterval);
            pollingTimer.addClockEventListener(pollingClockTick);
            pollingTimer.start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void playAlertIfReady()
    {
        this;
        JVM INSTR monitorenter ;
        if (!alertsNeedPlaying()) goto _L2; else goto _L1
_L1:
        if (!playerViewActive()) goto _L4; else goto _L3
_L3:
        isScrolling = true;
        destroyAlertReadyClock();
        displayNextAlert();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (alertReadyTimer == null)
        {
            initAlertReadyClock();
        }
        if (true) goto _L2; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    private boolean playerViewActive()
    {
        return playerPlatform != null && playerPlatform.getView() != null && playerPlatform.getView().getHeight() > 0;
    }

    private void stopEmergencyActionNotification()
    {
        animationManager.stopEmergencyActionNotification();
    }

    private void updateActiveAlerts(ArrayList arraylist)
    {
        this;
        JVM INSTR monitorenter ;
        if (animationManager != null && animationManager.getCurrentAlert() != null && animationManager.getCurrentAlert().isEmergencyActionNotification())
        {
            checkForEan(arraylist);
        }
        if (arraylist.isEmpty())
        {
            break MISSING_BLOCK_LABEL_195;
        }
        arraylist = arraylist.iterator();
_L6:
        Alert alert;
        do
        {
            if (!arraylist.hasNext())
            {
                break MISSING_BLOCK_LABEL_195;
            }
            alert = (Alert)arraylist.next();
        } while (oldAlerts.containsKey(alert.getIdentifier()));
        if (!alert.isEmergencyActionNotification() || isEANActive)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        boolean flag1 = false;
        Iterator iterator = activeAlerts.iterator();
_L4:
        boolean flag = flag1;
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (!((Alert)iterator.next()).getIdentifier().equalsIgnoreCase(alert.getIdentifier())) goto _L4; else goto _L3
_L3:
        flag = true;
_L2:
        if (flag) goto _L6; else goto _L5
_L5:
        activeAlerts.add(0, alert);
          goto _L6
        arraylist;
        throw arraylist;
        oldAlerts.put(alert.getIdentifier(), Integer.valueOf(1));
        activeAlerts.add(alert);
          goto _L6
        playAlertIfReady();
        this;
        JVM INSTR monitorexit ;
    }

    public void removeListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        listeners.remove(abstractplayerplatformvideoeventlistener);
    }

    public void setCustomSettings(EmergencyAlertSettings emergencyalertsettings)
    {
        settings = emergencyalertsettings;
        pollingInterval = emergencyalertsettings.getAlertPollingInterval();
    }

    public void setPlayer(IPlayerPlatform iplayerplatform)
    {
        playerPlatform = iplayerplatform;
    }






/*
    static boolean access$202(EmergencyAlertProvider emergencyalertprovider, boolean flag)
    {
        emergencyalertprovider.pollingIsReady = flag;
        return flag;
    }

*/




/*
    static boolean access$502(EmergencyAlertProvider emergencyalertprovider, boolean flag)
    {
        emergencyalertprovider.isScrolling = flag;
        return flag;
    }

*/




}
