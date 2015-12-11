// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java;

import android.content.Context;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.analytics.java.event.AbstractPlayerPlatformAnalyticsEvent;
import com.comcast.playerplatform.analytics.java.event.ApplicationStateDelegate;
import com.comcast.playerplatform.analytics.java.util.HostInfo;
import com.comcast.playerplatform.analytics.java.util.JsonFileIo;
import com.comcast.playerplatform.analytics.java.util.ObjectStream;
import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xmessage.XMessageComposer;
import com.comcast.playerplatform.analytics.java.xua.SizeBoundedQueue;
import com.comcast.playerplatform.analytics.java.xua.XuaApplicationInfo;
import com.comcast.playerplatform.analytics.java.xua.XuaBaseEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaDeviceInfo;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.XuaJsonInterpreter;
import com.comcast.playerplatform.analytics.java.xua.XuaMessage;
import com.comcast.playerplatform.analytics.java.xua.XuaNetworkInfo;
import com.comcast.playerplatform.analytics.java.xua.XuaSessionInfo;
import com.comcast.playerplatform.util.android.AbstractResponseEventListener;
import com.comcast.playerplatform.util.android.ConfigurationManager;
import com.comcast.playerplatform.util.android.XrestHelper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AnalyticsProvider
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/playerplatform/analytics/java/AnalyticsProvider);
    private static AnalyticsProvider analyticsProvider;
    private boolean analyticsConfigured;
    private AbstractPlayerPlatformAnalyticsEvent analyticsEventListener;
    private String analyticsUrl;
    private ApplicationStateDelegate appStateDelegate;
    private XuaApplicationInfo applicationInfo;
    private long batchInterval;
    private XuaDeviceInfo deviceInfo;
    private HttpClient httpClient;
    private boolean isEnabled;
    private com.comcast.playerplatform.analytics.java.util.JsonFileIo.JsonInterpreter jsonInterpreter;
    private Vector listeners;
    private int maxBatchSize;
    private SizeBoundedQueue messageQueue;
    private ScheduledFuture messagingTask;
    private boolean offlineStorageEnabled;
    private final ScheduledThreadPoolExecutor scheduledExecutor = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1);
    private int serverRetries;
    private XuaSessionInfo sessionInfo;
    private JsonFileIo xuaMessageFileIo;

    private AnalyticsProvider()
    {
        serverRetries = 0;
        analyticsEventListener = new AbstractPlayerPlatformAnalyticsEvent() {

            final AnalyticsProvider this$0;

            public void messagesFailed(String s, Collection collection)
            {
                Vector vector = listeners;
                vector;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformAnalyticsEvent)iterator.next()).messagesFailed(s, collection)) { }
                break MISSING_BLOCK_LABEL_55;
                s;
                vector;
                JVM INSTR monitorexit ;
                throw s;
                vector;
                JVM INSTR monitorexit ;
                int i = 
// JavaClassFileOutputException: get_constant: invalid tag

            public void messagesSent(Collection collection)
            {
                Vector vector = listeners;
                vector;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformAnalyticsEvent)iterator.next()).messagesSent(collection)) { }
                break MISSING_BLOCK_LABEL_51;
                collection;
                vector;
                JVM INSTR monitorexit ;
                throw collection;
                vector;
                JVM INSTR monitorexit ;
                serverRetries = 0;
                AnalyticsProvider.LOG.debug("messagesSent callback");
                AnalyticsProvider.LOG.debug((new StringBuilder()).append(collection.size()).append(" messages were sent successfully").toString());
                messageQueue.removeAll(collection);
                AnalyticsProvider.LOG.debug((new StringBuilder()).append("there are ").append(messageQueue.size()).append(" messages remaining in the queue").toString());
                if (xuaMessageFileIo != null)
                {
                    scheduledExecutor.execute(new Runnable() {

                        final _cls5 this$1;

                        public void run()
                        {
                            int i = Math.min(messageQueue.maxSize() - messageQueue.size(), xuaMessageFileIo.size());
                            List list = xuaMessageFileIo.removeItems(i);
                            messageQueue.addAll(list);
                            xuaMessageFileIo.save();
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    if (!offlineStorageEnabled && !xuaMessageFileIo.hasSavedItems())
                    {
                        xuaMessageFileIo = null;
                    }
                }
                return;
            }

            
            {
                this$0 = AnalyticsProvider.this;
                super();
            }
        };
        messageQueue = new SizeBoundedQueue();
        listeners = new Vector();
        isEnabled = true;
        jsonInterpreter = new XuaJsonInterpreter();
    }

    private void batchSendMessages(List list)
    {
        LOG.debug("batchSendMessages");
        StringBuilder stringbuilder = new StringBuilder();
        int j = list.size();
        ArrayList arraylist = new ArrayList(j);
        LOG.debug((new StringBuilder()).append("found ").append(j).append(" messages to send").toString());
        int i = 0;
        while (i < j) 
        {
            XuaMessage xuamessage = (XuaMessage)list.remove(0);
            try
            {
                stringbuilder.append(jsonInterpreter.toJson(xuamessage)).append('\036');
                arraylist.add(xuamessage);
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
            i++;
        }
        sendDataToServer(arraylist, stringbuilder.toString());
    }

    private void checkForHeartBeat(XuaMessage xuamessage)
    {
        if (isEnabled && xuamessage.getEventName().equals(XuaEventType.xuaHeartBeat.name()))
        {
            sendNextMessages(false);
        }
    }

    private XuaNetworkInfo getCurrentNetworkInfo()
    {
        String s;
        String s1;
        s1 = "unknown";
        s = s1;
        if (appStateDelegate == null) goto _L2; else goto _L1
_L1:
        static class _cls8
        {

            static final int $SwitchMap$com$comcast$playerplatform$analytics$java$event$ApplicationStateDelegate$InHomeState[];

            static 
            {
                $SwitchMap$com$comcast$playerplatform$analytics$java$event$ApplicationStateDelegate$InHomeState = new int[com.comcast.playerplatform.analytics.java.event.ApplicationStateDelegate.InHomeState.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$analytics$java$event$ApplicationStateDelegate$InHomeState[com.comcast.playerplatform.analytics.java.event.ApplicationStateDelegate.InHomeState.IN_HOME.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$analytics$java$event$ApplicationStateDelegate$InHomeState[com.comcast.playerplatform.analytics.java.event.ApplicationStateDelegate.InHomeState.OUT_OF_HOME.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls8..SwitchMap.com.comcast.playerplatform.analytics.java.event.ApplicationStateDelegate.InHomeState[appStateDelegate.getInHomeState().ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 59
    //                   2 66;
           goto _L3 _L4 _L5
_L3:
        s = s1;
_L2:
        return new XuaNetworkInfo(s);
_L4:
        s = "inHome";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "outOfHome";
        if (true) goto _L2; else goto _L6
_L6:
    }

    public static AnalyticsProvider getInstance()
    {
        com/comcast/playerplatform/analytics/java/AnalyticsProvider;
        JVM INSTR monitorenter ;
        AnalyticsProvider analyticsprovider;
        LOG.debug("getInstance");
        LOG.info("Analytics provider instance requested");
        if (analyticsProvider == null)
        {
            analyticsProvider = new AnalyticsProvider();
        }
        analyticsprovider = analyticsProvider;
        com/comcast/playerplatform/analytics/java/AnalyticsProvider;
        JVM INSTR monitorexit ;
        return analyticsprovider;
        Exception exception;
        exception;
        throw exception;
    }

    private void saveQueue()
    {
        if (offlineStorageEnabled && xuaMessageFileIo != null && messageQueue != null)
        {
            scheduledExecutor.execute(new Runnable() {

                final AnalyticsProvider this$0;

                public void run()
                {
                    xuaMessageFileIo.append(new ArrayList(messageQueue));
                    messageQueue.clear();
                    xuaMessageFileIo.save();
                }

            
            {
                this$0 = AnalyticsProvider.this;
                super();
            }
            });
        }
    }

    private void sendDataToServer(final List dataMessages, String s)
    {
        LOG.debug("sendDataToServer");
        scheduledExecutor.execute(new XrestHelper(s, analyticsUrl, "POST", null, new AbstractResponseEventListener() {

            final AnalyticsProvider this$0;
            final List val$dataMessages;

            public void requestFailed(String s1)
            {
                analyticsEventListener.messagesFailed(s1, dataMessages);
            }

            public void responseReceived(String s1)
            {
                analyticsEventListener.messagesSent(dataMessages);
            }

            
            {
                this$0 = AnalyticsProvider.this;
                dataMessages = list;
                super();
            }
        }, httpClient));
    }

    private void sendNextMessages(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int j = messageQueue.size();
        if (flag) goto _L2; else goto _L1
_L1:
        if (j < maxBatchSize) goto _L3; else goto _L2
_L7:
        Object obj1;
        StringBuilder stringbuilder;
        obj1 = LOG;
        stringbuilder = (new StringBuilder()).append("messages ");
        Object obj;
        int i;
        if (i != 0)
        {
            obj = "are";
        } else
        {
            obj = "are not";
        }
        ((Logger) (obj1)).debug(stringbuilder.append(((String) (obj))).append(" ready to send").toString());
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        j = Math.min(j, maxBatchSize);
        LOG.debug((new StringBuilder()).append("calculated batch size = ").append(j).toString());
        obj = new ArrayList(j);
        obj1 = messageQueue.iterator();
        i = 0;
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!((Iterator) (obj1)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        ((List) (obj)).add((XuaMessage)((Iterator) (obj1)).next());
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        if (((List) (obj)).size() > 0)
        {
            batchSendMessages(((List) (obj)));
        }
        if (offlineStorageEnabled && serverRetries >= 5)
        {
            LOG.debug("server retries exceeded defined amount, saving messages to disk");
            saveQueue();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
_L2:
        i = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 0;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void startMessagingTask()
    {
        LOG.debug("startMessagingTask");
        if (messagingTask == null)
        {
            messagingTask = scheduledExecutor.scheduleAtFixedRate(new Runnable() {

                final AnalyticsProvider this$0;

                public void run()
                {
                    forceSendMessages();
                }

            
            {
                this$0 = AnalyticsProvider.this;
                super();
            }
            }, batchInterval, batchInterval, TimeUnit.MILLISECONDS);
        }
    }

    public void buildMessage(final AbstractXMessageBuilder xuaMessage)
    {
        this;
        JVM INSTR monitorenter ;
        if (!analyticsConfigured)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        XMessageComposer xmessagecomposer = new XMessageComposer();
        xmessagecomposer.setMessageBuilder(xuaMessage);
        xmessagecomposer.constructMessage();
        xuaMessage = xmessagecomposer.getMessage();
        xuaMessage.setProtocol("2.0");
        xuaMessage.setApplicationInfo(applicationInfo);
        xuaMessage.setDeviceInfo(deviceInfo);
        xuaMessage.setSessionInfo(new XuaSessionInfo(String.valueOf(System.currentTimeMillis())));
        if (xuaMessage.getEvent().getEventName().equals(XuaEventType.xuaOpeningMedia.name()))
        {
            sessionInfo.setPluginId(String.valueOf(xuaMessage.getEvent().getTimeStamp()));
        }
        xuaMessage.setSessionInfo(sessionInfo);
        XuaNetworkInfo xuanetworkinfo = getCurrentNetworkInfo();
        xuaMessage.getEvent().setNetworkInfo(xuanetworkinfo);
        xuaMessage = xmessagecomposer.getFormattedMessage();
        if (!offlineStorageEnabled || messageQueue.size() != messageQueue.maxSize()) goto _L2; else goto _L1
_L1:
        scheduledExecutor.execute(new Runnable() {

            final AnalyticsProvider this$0;
            final XuaMessage val$xuaMessage;

            public void run()
            {
                xuaMessageFileIo.append(new ArrayList(messageQueue));
                messageQueue.clear();
                messageQueue.offer(xuaMessage);
                xuaMessageFileIo.save();
            }

            
            {
                this$0 = AnalyticsProvider.this;
                xuaMessage = xuamessage;
                super();
            }
        });
_L3:
        LOG.info("Added message to queue : {}", xuaMessage.getEventName());
        checkForHeartBeat(xuaMessage);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        messageQueue.offer(xuaMessage);
          goto _L3
        xuaMessage;
        throw xuaMessage;
        LOG.warn("The analytics plugin must be first configured to send messages");
          goto _L4
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        LOG.debug("clone");
        throw new CloneNotSupportedException();
    }

    public void configureAnalytics(HostInfo hostinfo, HttpClient httpclient)
    {
        LOG.debug("configureAnalytics");
        ConfigurationManager configurationmanager = ConfigurationManager.getInstance();
        if (configurationmanager.isReady())
        {
            try
            {
                applicationInfo = new XuaApplicationInfo(hostinfo.getApplicationName(), hostinfo.getApplicationVersion(), "PlayerPlatform", "0.3.005", hostinfo.getAccountId());
                deviceInfo = new XuaDeviceInfo(hostinfo.getDeviceName(), hostinfo.getDeviceVersion(), hostinfo.getDeviceId());
                sessionInfo = new XuaSessionInfo(String.valueOf(System.currentTimeMillis()));
                httpClient = httpclient;
                analyticsUrl = configurationmanager.getConfigValue("AnalyticsEndpoint");
                maxBatchSize = Integer.parseInt(configurationmanager.getConfigValue("MaxBatchSize"));
                batchInterval = Long.parseLong(configurationmanager.getConfigValue("BatchInterval"));
                int i = Integer.parseInt(configurationmanager.getConfigValue("MaxQueueSize"));
                messageQueue.setMaxSize(i);
                analyticsConfigured = true;
                if (isEnabled)
                {
                    enable();
                }
                LOG.info((new StringBuilder()).append("Analytics plugin configuredEnabled:").append(isEnabled).toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (HostInfo hostinfo)
            {
                LOG.info("The analytics plugin must be first configured to send messages");
            }
            return;
        } else
        {
            LOG.info("The analytics plugin must be first configured to send messages");
            return;
        }
    }

    public void enable()
    {
        LOG.debug("enable");
        isEnabled = true;
        if (analyticsConfigured)
        {
            startMessagingTask();
            return;
        } else
        {
            LOG.warn("The analytics plugin must be first configured to send messages");
            return;
        }
    }

    public void forceSendMessages()
    {
        this;
        JVM INSTR monitorenter ;
        if (!analyticsConfigured || !isEnabled) goto _L2; else goto _L1
_L1:
        sendNextMessages(true);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        saveQueue();
        LOG.warn("The analytics plugin must be first configured to send messages");
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public int getMaxBatchSize()
    {
        LOG.debug("getMaxBatchSize");
        return maxBatchSize;
    }

    public int getMaxQueueSize()
    {
        LOG.debug("getMaxQueueSize");
        return messageQueue.maxSize();
    }

    public void setMaxBatchSize(int i)
    {
        LOG.debug("setMaxBatchSize");
        maxBatchSize = i;
    }

    public void setMaxQueueSize(int i)
    {
        LOG.debug("setMaxQueueSize");
        messageQueue.setMaxSize(i);
    }





/*
    static JsonFileIo access$102(AnalyticsProvider analyticsprovider, JsonFileIo jsonfileio)
    {
        analyticsprovider.xuaMessageFileIo = jsonfileio;
        return jsonfileio;
    }

*/





/*
    static int access$502(AnalyticsProvider analyticsprovider, int i)
    {
        analyticsprovider.serverRetries = i;
        return i;
    }

*/


/*
    static int access$508(AnalyticsProvider analyticsprovider)
    {
        int i = analyticsprovider.serverRetries;
        analyticsprovider.serverRetries = i + 1;
        return i;
    }

*/



    // Unreferenced inner class com/comcast/playerplatform/analytics/java/AnalyticsProvider$6

/* anonymous class */
    class _cls6
        implements ObjectStream
    {

        final Context val$appContext;
        final String val$fileName;

        public ObjectInputStream objectInputStream()
            throws IOException
        {
            ObjectInputStream objectinputstream = new ObjectInputStream(appContext.openFileInput(fileName));
            AnalyticsProvider.LOG.debug("objectInputStream created");
            return objectinputstream;
        }

        public ObjectOutputStream objectOutputStream()
            throws IOException
        {
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(appContext.openFileOutput(fileName, 0));
            AnalyticsProvider.LOG.debug("objectOutputStream created");
            return objectoutputstream;
        }
    }


    // Unreferenced inner class com/comcast/playerplatform/analytics/java/AnalyticsProvider$7

/* anonymous class */
    class _cls7
        implements com.comcast.playerplatform.analytics.java.util.FileIo.FileReadListener
    {

        final AnalyticsProvider this$0;

        public void onError(Throwable throwable)
        {
            AnalyticsProvider.LOG.debug("onError");
        }

        public void onItemsRead(List list)
        {
            AnalyticsProvider.LOG.debug("onItemsRead");
            AnalyticsProvider.LOG.debug((new StringBuilder()).append(list.size()).append(" items read from disk").toString());
            messageQueue.addAll(list);
        }
    }

}
