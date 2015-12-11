// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.analytics;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.comcast.playerplatform.analytics.java.AnalyticsProvider;
import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.messages.AdProgressMessage;
import com.comcast.playerplatform.analytics.java.xmessage.messages.BitrateChangedMessage;
import com.comcast.playerplatform.analytics.java.xmessage.messages.ErrorMessage;
import com.comcast.playerplatform.analytics.java.xmessage.messages.FragmentWarningMessage;
import com.comcast.playerplatform.analytics.java.xmessage.messages.HeartbeatMessage;
import com.comcast.playerplatform.analytics.java.xmessage.messages.MediaEndedMessage;
import com.comcast.playerplatform.analytics.java.xmessage.messages.MediaFailedMessage;
import com.comcast.playerplatform.analytics.java.xmessage.messages.MediaInfoMessage;
import com.comcast.playerplatform.analytics.java.xmessage.messages.MediaOpenedMessage;
import com.comcast.playerplatform.analytics.java.xmessage.messages.OpeningMediaMessage;
import com.comcast.playerplatform.analytics.java.xmessage.messages.PlayStateChangedMessage;
import com.comcast.playerplatform.analytics.java.xmessage.messages.PluginInitializedMessage;
import com.comcast.playerplatform.analytics.java.xmessage.messages.ScrubMessageEnded;
import com.comcast.playerplatform.analytics.java.xmessage.messages.ScrubMessageStarted;
import com.comcast.playerplatform.analytics.java.xmessage.messages.TrickPlayMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.values.XuaPluginInitializedValue;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.util.FragmentInfo;
import com.comcast.playerplatform.primetime.android.util.PlayerPlatformVersion;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.comcast.playerplatform.primetime.android.analytics:
//            PlayerAnalytics

public class AnalyticsHandler
    implements PlayerAnalytics
{

    private boolean adProgressFlags[];
    private final AnalyticsProvider analyticsProvider;

    public AnalyticsHandler(AnalyticsProvider analyticsprovider)
    {
        adProgressFlags = new boolean[5];
        analyticsProvider = analyticsprovider;
    }

    private static Point getDisplaySize(Context context)
    {
        context = (WindowManager)context.getSystemService("window");
        Point point = new Point();
        context.getDefaultDisplay().getSize(point);
        return point;
    }

    private long now()
    {
        return System.currentTimeMillis();
    }

    private void resetAdProgressFlags()
    {
        for (int i = 0; i < 5; i++)
        {
            adProgressFlags[i] = false;
        }

    }

    private void sendAnalyticsMessage(AbstractXMessageBuilder abstractxmessagebuilder)
    {
        analyticsProvider.buildMessage(abstractxmessagebuilder);
    }

    public void adProgress(int i, AbstractXuaAsset abstractxuaasset)
    {
        int j = i / 25;
        int k = j * 25;
        if (!adProgressFlags[j] && i >= k)
        {
            sendAnalyticsMessage(new AdProgressMessage(now(), k, abstractxuaasset));
            adProgressFlags[j] = true;
        }
        if (i == 100)
        {
            resetAdProgressFlags();
        }
    }

    public void bitrateChanged(long l, AbstractXuaAsset abstractxuaasset)
    {
        sendAnalyticsMessage(new BitrateChangedMessage(now(), l, abstractxuaasset));
    }

    public void fragmentWarning(int i, int j, int k, String s, AbstractXuaAsset abstractxuaasset)
    {
        sendAnalyticsMessage(new FragmentWarningMessage(now(), abstractxuaasset, s, k, 0, i, j));
    }

    public void heartBeat(final Long currentPosition, final Long bitrate, final Integer fps, final String cc, final String sap, final Long millisecondsBuffered, final AbstractXuaAsset asset, 
            final FragmentInfo fragmentInfo)
    {
        ThreadManager.getInstance().executeRunnable(new Runnable() {

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
                com.comcast.playerplatform.analytics.java.xua.events.XuaHeartbeatEvent.HeartbeatEnvironment heartbeatenvironment;
                Runtime runtime = Runtime.getRuntime();
                heartbeatenvironment = new com.comcast.playerplatform.analytics.java.xua.events.XuaHeartbeatEvent.HeartbeatEnvironment(null, null, null, Float.valueOf((runtime.totalMemory() - runtime.freeMemory()) / runtime.totalMemory()), millisecondsBuffered);
                if (fragmentInfo == null) goto _L2; else goto _L1
_L1:
                FragmentInfo fragmentinfo = fragmentInfo;
                fragmentinfo;
                JVM INSTR monitorenter ;
                Object obj = new com.comcast.playerplatform.analytics.java.xua.events.XuaHeartbeatEvent.HeartbeatFragment(fragmentInfo.getNumberOfFragments(), (int)fragmentInfo.getFragmentSize(), (int)fragmentInfo.getDownloadLatency(), (int)fragmentInfo.getDownloadDuration(), Integer.valueOf((int)fragmentInfo.getFragmentDuration()));
                fragmentInfo.reset();
                fragmentinfo;
                JVM INSTR monitorexit ;
_L5:
                obj = new HeartbeatMessage(now(), currentPosition, bitrate, fps, cc, sap, asset, heartbeatenvironment, ((com.comcast.playerplatform.analytics.java.xua.events.XuaHeartbeatEvent.HeartbeatFragment) (obj)));
                sendAnalyticsMessage(((AbstractXMessageBuilder) (obj)));
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

            
            {
                this$0 = AnalyticsHandler.this;
                millisecondsBuffered = long1;
                fragmentInfo = fragmentinfo;
                currentPosition = long2;
                bitrate = long3;
                fps = integer;
                cc = s;
                sap = s1;
                asset = abstractxuaasset;
                super();
            }
        });
    }

    public void mediaEnded(AbstractXuaAsset abstractxuaasset)
    {
        sendAnalyticsMessage(new MediaEndedMessage(now(), abstractxuaasset));
    }

    public void mediaFailed(String s, long l, String s1, String s2, AbstractXuaAsset abstractxuaasset)
    {
        sendAnalyticsMessage(new MediaFailedMessage(now(), s1, s2, l, s, abstractxuaasset));
    }

    public void mediaInfo(int i, String s, AbstractXuaAsset abstractxuaasset)
    {
        sendAnalyticsMessage(new MediaInfoMessage(now(), i, s, abstractxuaasset));
    }

    public void mediaOpened(String s, long l, Long long1, AbstractXuaAsset abstractxuaasset)
    {
        sendAnalyticsMessage(new MediaOpenedMessage(now(), long1, l, s, abstractxuaasset));
    }

    public void openingMedia(String s, AbstractXuaAsset abstractxuaasset)
    {
        sendAnalyticsMessage(new OpeningMediaMessage(now(), abstractxuaasset, s));
    }

    public void playStateChanged(PlayerStatus playerstatus, AbstractXuaAsset abstractxuaasset)
    {
        sendAnalyticsMessage(new PlayStateChangedMessage(now(), playerstatus.name(), abstractxuaasset));
    }

    public void playStateChanged(String s, AbstractXuaAsset abstractxuaasset)
    {
        sendAnalyticsMessage(new PlayStateChangedMessage(now(), s, abstractxuaasset));
    }

    public void pluginInitialized(final Context context)
    {
        ThreadManager.getInstance().executeRunnable(new Runnable() {

            final AnalyticsHandler this$0;
            final Context val$context;

            public void run()
            {
                Object obj = new XuaPluginInitializedValue();
                ((XuaPluginInitializedValue) (obj)).setPlayerId("PlayerPlatform");
                ((XuaPluginInitializedValue) (obj)).setPlayerVersion(PlayerPlatformVersion.getPlayerPlatformVersion());
                ((XuaPluginInitializedValue) (obj)).setOrganization("VIPER");
                ((XuaPluginInitializedValue) (obj)).setNative(Boolean.valueOf(true));
                ((XuaPluginInitializedValue) (obj)).setSupportVod(Boolean.valueOf(true));
                ((XuaPluginInitializedValue) (obj)).setSupportLinear(Boolean.valueOf(true));
                ((XuaPluginInitializedValue) (obj)).setSupportCdvr(Boolean.valueOf(true));
                ((XuaPluginInitializedValue) (obj)).setOsId(System.getProperty("os.name"));
                ((XuaPluginInitializedValue) (obj)).setOsVersion(System.getProperty("os.version"));
                ((XuaPluginInitializedValue) (obj)).setOsArchitecture(System.getProperty("os.arch"));
                ((XuaPluginInitializedValue) (obj)).setCpuCore(String.valueOf(Runtime.getRuntime().availableProcessors()));
                Point point = AnalyticsHandler.getDisplaySize(context);
                ((XuaPluginInitializedValue) (obj)).setScreenHeight(String.valueOf(point.y));
                ((XuaPluginInitializedValue) (obj)).setScreenWidth(String.valueOf(point.x));
                obj = new PluginInitializedMessage(now(), ((XuaPluginInitializedValue) (obj)));
                sendAnalyticsMessage(((AbstractXMessageBuilder) (obj)));
            }

            
            {
                this$0 = AnalyticsHandler.this;
                context = context1;
                super();
            }
        });
    }

    public void retryAttempt(String s, String s1, String s2, int i, AbstractXuaAsset abstractxuaasset)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("RETRY", String.valueOf(i));
        sendAnalyticsMessage(new ErrorMessage(now(), s, s1, s2, hashmap, abstractxuaasset));
    }

    public void scrubEnded(int i, AbstractXuaAsset abstractxuaasset)
    {
        sendAnalyticsMessage(new ScrubMessageEnded(now(), i, abstractxuaasset));
    }

    public void scrubStarted(int i, AbstractXuaAsset abstractxuaasset)
    {
        sendAnalyticsMessage(new ScrubMessageStarted(now(), i, abstractxuaasset));
    }

    public void trickPlay(int i, String s, AbstractXuaAsset abstractxuaasset)
    {
        sendAnalyticsMessage(new TrickPlayMessage(now(), i, s, abstractxuaasset));
    }



}
