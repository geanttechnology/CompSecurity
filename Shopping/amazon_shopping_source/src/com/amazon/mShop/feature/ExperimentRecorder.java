// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.feature;

import android.util.Log;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.ClientLogInfo;
import com.amazon.rio.j2me.client.services.mShop.ClientMetrics;
import com.amazon.rio.j2me.client.services.mShop.Feature;
import com.amazon.rio.j2me.client.services.mShop.FeatureExperience;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.Null;
import com.amazon.rio.j2me.client.services.mShop.PostMetricsResponseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.mShop.feature:
//            Features

public class ExperimentRecorder
{
    private static class TreatmentEvent
    {

        private final Integer cacheStamp;
        private final String featureName;
        private final String session;
        private final long time;
        private final String treatment;

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("session: ").append(session).append(", time: ").append(time).append(", featureName: ").append(featureName).append(", treatment: ").append(treatment).append(", cacheStamp: ").append(cacheStamp);
            return stringbuilder.toString();
        }






        private TreatmentEvent(String s, long l, String s1, String s2, Integer integer)
        {
            session = s;
            time = l;
            featureName = s1;
            treatment = s2;
            cacheStamp = integer;
        }

        TreatmentEvent(String s, long l, String s1, String s2, Integer integer, _cls1 _pcls1)
        {
            this(s, l, s1, s2, integer);
        }
    }


    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static final String TAG = com/amazon/mShop/feature/ExperimentRecorder.getSimpleName();
    private static ExperimentRecorder instance;
    private final Object eventLock = new Object();
    private LinkedList events;
    private final HashMap features = new HashMap(4);
    private AtomicBoolean running;

    public ExperimentRecorder()
    {
        events = new LinkedList();
        running = new AtomicBoolean();
    }

    public static ExperimentRecorder getInstance()
    {
        com/amazon/mShop/feature/ExperimentRecorder;
        JVM INSTR monitorenter ;
        ExperimentRecorder experimentrecorder;
        if (instance == null)
        {
            instance = new ExperimentRecorder();
        }
        experimentrecorder = instance;
        com/amazon/mShop/feature/ExperimentRecorder;
        JVM INSTR monitorexit ;
        return experimentrecorder;
        Exception exception;
        exception;
        throw exception;
    }

    private void sendEvents()
    {
        if (DEBUG)
        {
            Log.d(TAG, "Sending events");
        }
        Object obj2;
        synchronized (eventLock)
        {
            obj2 = events;
            events = new LinkedList();
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        boolean flag = ((List) (obj2)).isEmpty();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception1;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Failed to send events", exception);
        }
        return;
        Object obj1;
        String s;
        obj1 = new ArrayList(((List) (obj2)).size());
        s = CookieBridge.getCurrentSessionId();
        obj2 = ((List) (obj2)).iterator();
_L1:
        TreatmentEvent treatmentevent;
        do
        {
            if (!((Iterator) (obj2)).hasNext())
            {
                break MISSING_BLOCK_LABEL_261;
            }
            treatmentevent = (TreatmentEvent)((Iterator) (obj2)).next();
            if (Util.isEqual(treatmentevent.session, s))
            {
                break MISSING_BLOCK_LABEL_177;
            }
            if (DEBUG)
            {
                Log.d(TAG, (new StringBuilder()).append("Event has stale session: event: [").append(treatmentevent).append("], session: ").append(s).toString());
            }
        } while (true);
        FeatureExperience featureexperience = new FeatureExperience();
        featureexperience.setFeatureName(treatmentevent.featureName);
        featureexperience.setTreatment(treatmentevent.treatment);
        featureexperience.setCacheStamp(treatmentevent.cacheStamp);
        ((List) (obj1)).add(featureexperience);
        if (DEBUG)
        {
            Log.d(TAG, (new StringBuilder()).append("Logging event: ").append(treatmentevent).toString());
        }
          goto _L1
        ClientLogInfo clientloginfo = new ClientLogInfo();
        clientloginfo.setFeatures(new Vector(((java.util.Collection) (obj1))));
        clientloginfo.setPageAssemblyType("main");
        obj1 = new ClientMetrics();
        ((ClientMetrics) (obj1)).setLogInfo(clientloginfo);
        sendMetrics(((ClientMetrics) (obj1)));
        return;
    }

    private void sendMetrics(ClientMetrics clientmetrics)
    {
        PostMetricsResponseListener postmetricsresponselistener = new PostMetricsResponseListener() {

            final ExperimentRecorder this$0;

            public void cancelled(ServiceCall servicecall)
            {
                if (ExperimentRecorder.DEBUG)
                {
                    Log.d(ExperimentRecorder.TAG, "Post metrics cancelled");
                }
            }

            public void completed(Null null1, ServiceCall servicecall)
            {
                if (ExperimentRecorder.DEBUG)
                {
                    Log.d(ExperimentRecorder.TAG, "Finished posting metrics");
                }
            }

            public void error(Exception exception, ServiceCall servicecall)
            {
                Log.e(ExperimentRecorder.TAG, "Failed to post metrics", exception);
            }

            
            {
                this$0 = ExperimentRecorder.this;
                super();
            }
        };
        ServiceController.getMShopService().postMetrics(clientmetrics, postmetricsresponselistener);
    }

    public String getTreatment(String s)
    {
        return getTreatment(s, true, 0x75300L);
    }

    public String getTreatment(String s, boolean flag, long l)
    {
        long l1 = System.currentTimeMillis();
        Object obj;
        Object obj1;
        HashMap hashmap;
        String s1;
        if (Util.isEmpty(s))
        {
            return "C";
        }
        TreatmentEvent treatmentevent;
        int i;
        try
        {
            obj = Features.getInstance().getFeature(s);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e(TAG, (new StringBuilder()).append("Failed to get treatment for feature: ").append(s).toString(), ((Throwable) (obj)));
            return "C";
        }
        if (obj == null)
        {
            return "C";
        }
        s1 = ((Feature) (obj)).getClientTreatmentPath();
        if (Util.isEmpty(s1))
        {
            return "C";
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (!((Feature) (obj)).getSendTrigger().booleanValue()) goto _L2; else goto _L3
_L3:
        obj1 = CookieBridge.getCurrentSessionId();
        hashmap = features;
        hashmap;
        JVM INSTR monitorenter ;
        treatmentevent = (TreatmentEvent)features.get(s);
        if (treatmentevent == null) goto _L5; else goto _L4
_L4:
        if (!Util.isEqual(obj1, treatmentevent.session) || l1 - treatmentevent.time > l || !s1.equals(treatmentevent.treatment)) goto _L5; else goto _L6
_L6:
        if (!DEBUG) goto _L8; else goto _L7
_L7:
        Log.d(TAG, (new StringBuilder()).append("Treatment is unchanged: ").append(treatmentevent).toString());
        obj = null;
_L12:
        hashmap;
        JVM INSTR monitorexit ;
        if (obj == null) goto _L2; else goto _L9
_L9:
        obj1 = eventLock;
        obj1;
        JVM INSTR monitorenter ;
        i = events.size();
        if (i <= 511)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        events.subList(0, (i - 512) + 1).clear();
        if (DEBUG)
        {
            Log.w(TAG, "Event queue exceeded capacity");
        }
        events.add(obj);
        obj1;
        JVM INSTR monitorexit ;
        if (!running.compareAndSet(false, true)) goto _L2; else goto _L10
_L10:
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ExperimentRecorder this$0;

            public void run()
            {
                try
                {
                    running.getAndSet(false);
                    sendEvents();
                    return;
                }
                catch (Exception exception)
                {
                    Log.e(ExperimentRecorder.TAG, "Failed to send events", exception);
                }
            }

            
            {
                this$0 = ExperimentRecorder.this;
                super();
            }
        }, 20000L);
        return s1;
_L5:
        obj1 = new TreatmentEvent(((String) (obj1)), l1, s, s1, ((Feature) (obj)).getCacheStamp());
        features.put(s, obj1);
        obj = obj1;
        if (!DEBUG) goto _L12; else goto _L11
_L11:
        Log.d(TAG, (new StringBuilder()).append("Queueing event: ").append(obj1).toString());
        obj = obj1;
          goto _L12
_L13:
        hashmap;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
          goto _L13
_L8:
        obj = null;
          goto _L12
_L2:
        return s1;
        obj;
          goto _L13
    }





}
