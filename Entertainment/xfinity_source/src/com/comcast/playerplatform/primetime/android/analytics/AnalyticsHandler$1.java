// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.analytics;

import android.content.Context;
import android.graphics.Point;
import com.comcast.playerplatform.analytics.java.xmessage.messages.PluginInitializedMessage;
import com.comcast.playerplatform.analytics.java.xua.values.XuaPluginInitializedValue;
import com.comcast.playerplatform.primetime.android.util.PlayerPlatformVersion;

// Referenced classes of package com.comcast.playerplatform.primetime.android.analytics:
//            AnalyticsHandler

class val.context
    implements Runnable
{

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
        Point point = AnalyticsHandler.access$000(val$context);
        ((XuaPluginInitializedValue) (obj)).setScreenHeight(String.valueOf(point.y));
        ((XuaPluginInitializedValue) (obj)).setScreenWidth(String.valueOf(point.x));
        obj = new PluginInitializedMessage(AnalyticsHandler.access$100(AnalyticsHandler.this), ((XuaPluginInitializedValue) (obj)));
        AnalyticsHandler.access$200(AnalyticsHandler.this, ((com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder) (obj)));
    }

    zedMessage()
    {
        this$0 = final_analyticshandler;
        val$context = Context.this;
        super();
    }
}
