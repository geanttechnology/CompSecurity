// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.analytics;

import com.comcast.playerplatform.analytics.java.xmessage.messages.HeartbeatMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.primetime.android.util.FragmentInfo;

// Referenced classes of package com.comcast.playerplatform.primetime.android.analytics:
//            AnalyticsHandler

class val.asset
    implements Runnable
{

    final AnalyticsHandler this$0;
    final AbstractXuaAsset val$asset;
    final Long val$bitrate;
    final String val$cc;
    final Long val$currentPosition;
    final Integer val$fps;
    final FragmentInfo val$fragmentInfo;
    final Long val$millisecondsBuffered;
    final String val$sap;

    public void run()
    {
        com.comcast.playerplatform.analytics.java.xua.events.eartbeatEnvironment eartbeatenvironment;
        Runtime runtime = Runtime.getRuntime();
        eartbeatenvironment = new com.comcast.playerplatform.analytics.java.xua.events.eartbeatEnvironment(null, null, null, Float.valueOf((runtime.totalMemory() - runtime.freeMemory()) / runtime.totalMemory()), val$millisecondsBuffered);
        if (val$fragmentInfo == null) goto _L2; else goto _L1
_L1:
        FragmentInfo fragmentinfo = val$fragmentInfo;
        fragmentinfo;
        JVM INSTR monitorenter ;
        Object obj = new com.comcast.playerplatform.analytics.java.xua.events.eartbeatFragment(val$fragmentInfo.getNumberOfFragments(), (int)val$fragmentInfo.getFragmentSize(), (int)val$fragmentInfo.getDownloadLatency(), (int)val$fragmentInfo.getDownloadDuration(), Integer.valueOf((int)val$fragmentInfo.getFragmentDuration()));
        val$fragmentInfo.reset();
        fragmentinfo;
        JVM INSTR monitorexit ;
_L5:
        obj = new HeartbeatMessage(AnalyticsHandler.access$100(AnalyticsHandler.this), val$currentPosition, val$bitrate, val$fps, val$cc, val$sap, val$asset, eartbeatenvironment, ((com.comcast.playerplatform.analytics.java.xua.events.eartbeatFragment) (obj)));
        AnalyticsHandler.access$200(AnalyticsHandler.this, ((com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder) (obj)));
        return;
        obj;
_L3:
        fragmentinfo;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        if (true) goto _L3; else goto _L2
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    ge()
    {
        this$0 = final_analyticshandler;
        val$millisecondsBuffered = long1;
        val$fragmentInfo = fragmentinfo;
        val$currentPosition = long2;
        val$bitrate = long3;
        val$fps = integer;
        val$cc = s;
        val$sap = s1;
        val$asset = AbstractXuaAsset.this;
        super();
    }
}
