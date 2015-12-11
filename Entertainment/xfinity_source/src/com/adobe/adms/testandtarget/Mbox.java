// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.testandtarget;

import android.util.Log;
import com.adobe.adms.measurement.ADMS_Churn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.adobe.adms.testandtarget:
//            MboxFactory, MboxContentConsumer, MissingDefaultContentException, MissingOnLoadConsumerException

public final class Mbox
{
    private static class TimeoutTimerTask extends TimerTask
    {

        private Mbox _mbox;

        public void run()
        {
            _mbox.getFactory().disable();
            _mbox.callOnLoadConsumers(null);
        }

        private TimeoutTimerTask(Mbox mbox)
        {
            _mbox = mbox;
        }

    }


    private static final long DEFAULT_MAX_RESPONSE_TIME = 15000L;
    private static final String LOG_TAG = "Mbox";
    private static final String MBOX_DEFAULT = "/images/log.gif";
    private static final String OFFER_CONTENT_TYPE = "text/plain; charset=utf-8";
    private static volatile boolean TargetLifecycleString_pred = true;
    private static String _lifecycleParamsString;
    private String defaultContent;
    private long maxOfferResponseTime;
    private String mboxName;
    private ConcurrentHashMap mboxParameterList;
    private TimeoutTimerTask offerTimeoutTask;
    private Timer offerTimer;
    private Vector onLoadConsumers;
    private boolean onLoadConsumersCalled;
    private MboxFactory parentFactory;

    protected Mbox(MboxFactory mboxfactory, String s)
    {
        maxOfferResponseTime = 15000L;
        mboxParameterList = new ConcurrentHashMap();
        onLoadConsumers = new Vector();
        onLoadConsumersCalled = false;
        parentFactory = mboxfactory;
        mboxName = s;
    }

    private String GetLifecycleParamsString()
    {
        if (TargetLifecycleString_pred)
        {
            TargetLifecycleString_pred = false;
            StringBuilder stringbuilder = new StringBuilder();
            Object obj = ADMS_Churn.getLifecycleContextData();
            if (obj != null)
            {
                java.util.Map.Entry entry;
                for (obj = ((HashMap) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append("&").append((String)entry.getKey()).append("=").append(parentFactory.encode(entry.getValue().toString())))
                {
                    entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                }

            }
            _lifecycleParamsString = stringbuilder.toString();
        }
        return _lifecycleParamsString;
    }

    private String buildMboxRequestURL()
    {
        long l = System.currentTimeMillis();
        StringBuilder stringbuilder = new StringBuilder(parentFactory.getBaseRequestURL());
        stringbuilder.append("mbox=").append(parentFactory.encode(mboxName)).append("&mboxDefault=").append(parentFactory.encode("/images/log.gif")).append("&mboxContentType=").append(parentFactory.encode("text/plain; charset=utf-8")).append("&mboxTime=").append(String.valueOf(l));
        java.util.Map.Entry entry;
        for (Iterator iterator = mboxParameterList.entrySet().iterator(); iterator.hasNext(); stringbuilder.append("&").append(parentFactory.encode((String)entry.getKey())).append("=").append(parentFactory.encode((String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        String s = GetLifecycleParamsString();
        if (s != null && s.length() > 0)
        {
            stringbuilder.append(s);
        }
        Log.d("TARGET", (new StringBuilder()).append("request url: ").append(stringbuilder.toString()).toString());
        return stringbuilder.toString();
    }

    private void startOfferTimer()
    {
        offerTimer = new Timer();
        offerTimeoutTask = new TimeoutTimerTask(this);
        offerTimer.schedule(offerTimeoutTask, maxOfferResponseTime);
    }

    public void addMboxParameter(String s, String s1)
    {
        if (s == null || s.length() == 0)
        {
            Log.d("TARGET", "Parameter 'paramName' in addMboxParameter() cannot be null");
            return;
        }
        ConcurrentHashMap concurrenthashmap = mboxParameterList;
        if (s1 == null)
        {
            s1 = "";
        }
        concurrenthashmap.putIfAbsent(s, s1);
    }

    public void addOnLoadConsumer(MboxContentConsumer mboxcontentconsumer)
    {
        onLoadConsumers.add(mboxcontentconsumer);
    }

    protected void callOnLoadConsumers(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (offerTimer != null)
        {
            offerTimer.cancel();
        }
        String s1;
        s1 = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        s1 = defaultContent;
        if (onLoadConsumersCalled)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        onLoadConsumersCalled = true;
        int i = 0;
_L1:
        int j = onLoadConsumers.size();
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        ((MboxContentConsumer)onLoadConsumers.elementAt(i)).consume(s1);
_L2:
        i++;
          goto _L1
        s;
        s.printStackTrace();
          goto _L2
        s;
        throw s;
        this;
        JVM INSTR monitorexit ;
    }

    public MboxFactory getFactory()
    {
        return parentFactory;
    }

    public void load()
        throws MissingDefaultContentException, MissingOnLoadConsumerException
    {
        this;
        JVM INSTR monitorenter ;
        if (defaultContent == null)
        {
            throw new MissingDefaultContentException();
        }
        break MISSING_BLOCK_LABEL_22;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (onLoadConsumers.isEmpty())
        {
            throw new MissingOnLoadConsumerException();
        }
        if (parentFactory.isEnabled())
        {
            break MISSING_BLOCK_LABEL_69;
        }
        Log.w("Mbox", "WARNING: MboxFactory is disabled. Consuming default content.");
        callOnLoadConsumers(defaultContent);
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        startOfferTimer();
        parentFactory.getMboxResponse(this, buildMboxRequestURL());
          goto _L1
    }

    public void setDefaultContent(String s)
    {
        this;
        JVM INSTR monitorenter ;
        defaultContent = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setMaxResponseTime(long l)
    {
        maxOfferResponseTime = l;
    }

}
