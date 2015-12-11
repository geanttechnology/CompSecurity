// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay;

import android.content.Context;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.playerplatform.util.android.ConfigurationManager;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay:
//            PlayerConfigurationListener

public class PlayerConfigUtil
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/PlayerConfigUtil);
    private final AndroidDevice androidDevice;
    private final boolean isDebuggable;
    private final PlayNowUserManager userManager;

    public PlayerConfigUtil(AndroidDevice androiddevice, PlayNowUserManager playnowusermanager, boolean flag)
    {
        androidDevice = androiddevice;
        userManager = playnowusermanager;
        isDebuggable = flag;
    }

    public void configureESPNPlayer(final Context context)
    {
        if (ConfigurationManager.getInstance().isReady())
        {
            if (!ConfigurationManager.getInstance().isEspnReady())
            {
                ConfigurationManager.getInstance().initializeESPN(context, false);
            }
            return;
        } else
        {
            configurePlayerPlatform(new PlayerConfigurationListener() {

                final PlayerConfigUtil this$0;
                final Context val$context;

                public void configurationFailed(String s)
                {
                    super.configurationFailed(s);
                    PlayerConfigUtil.LOG.error("configurationFailed: {}", s);
                }

                public void configurationLoaded()
                {
                    super.configurationLoaded();
                    if (!ConfigurationManager.getInstance().isEspnReady())
                    {
                        ConfigurationManager.getInstance().initializeESPN(context, false);
                    }
                }

            
            {
                this$0 = PlayerConfigUtil.this;
                context = context1;
                super();
            }
            });
            return;
        }
    }

    public void configurePlayerPlatform(PlayerConfigurationListener playerconfigurationlistener)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        String s;
        ConfigurationManager configurationmanager;
        boolean flag;
        if (!androidDevice.wantsStaticBitrate() && !((PlayerUserSettings)userManager.getUserSettings()).getWantsStaticBitrate())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ConfigurationManager.getInstance().addListener(playerconfigurationlistener);
        if (isDebuggable)
        {
            playerconfigurationlistener = "<configuration type=\"stage\" version=\"0.10\">\n";
        } else
        {
            playerconfigurationlistener = "<configuration type=\"prod\" version=\"2.0\">\n";
        }
        if (isDebuggable)
        {
            obj = "<add key=\"AnalyticsEndpoint\" value=\"http://qa-analytics.bdn.lab.xcal.tv/qa/player\"/>\n";
        } else
        {
            obj = "<add key=\"AnalyticsEndpoint\" value=\"http://analytics.xcal.tv/player\"/>\n";
        }
        if (isDebuggable)
        {
            s = "androidpts";
        } else
        {
            s = "androidptp";
        }
        configurationmanager = ConfigurationManager.getInstance();
        obj = (new StringBuilder()).append(playerconfigurationlistener).append("<analyticsSettings>\n").append(((String) (obj))).append("<add key=\"AnalyticsProtocol\" value=\"1.2-p1\"/>\n").append("<add key=\"AnalyticsDeviceType\" value=\"tvgo-android\"/>\n").append("<add key=\"MaxBatchSize\" value=\"10\"/>\n").append("<add key=\"MaxQueueSize\" value=\"100\"/>\n").append("<add key=\"BatchInterval\" value=\"5000\"/>\n").append("</analyticsSettings>\n").append("<appSettings>\n").append("<add key=\"HeartbeatInterval\" value=\"60000\"/>\n").append("<add key=\"Autoplay\" value=\"").append(String.valueOf(flag)).append("\"/>\n").append("<add key=\"AbrPolicy\" value=\"ABR_MODERATE\"/>\n").append("<add key=\"MinimumBitrate\" value=\"150000\"/>\n").append("<add key=\"MaximumBitrate\" value=\"4000000\"/>\n").append("<add key=\"InitialBitrate\" value=\"150000\"/>\n").append("<add key=\"InitialBuffer\" value=\"4000\"/>\n").append("<add key=\"PlaybackBuffer\" value=\"80000\"/>\n").append("<add key=\"PlayingLinearBufferTime\" value=\"15000\"/>\n").append("<add key=\"RetryOnMediaFailed\" value=\"true\"/>").append("</appSettings>\n").append("<auditudeSettings>\n").append("<add key=\"DomainId\" value=\"auditude.com\"/>\n").append("<add key=\"ZoneId\" value=\"2637\"/>\n").append("<add key=\"CustomParams\" paramKey=\"plr\" paramValue=\"").append(s).append("\"/>\n").append("<add key=\"CustomParams\" paramKey=\"device\" paramValue=\"");
        if (androidDevice.isTabletDevice())
        {
            playerconfigurationlistener = "androidtablet";
        } else
        {
            playerconfigurationlistener = "android";
        }
        configurationmanager.loadConfigurationFromXml(((StringBuilder) (obj)).append(playerconfigurationlistener).append("\"/>\n").append("</auditudeSettings>\n").append("</configuration>").toString());
        this;
        JVM INSTR monitorexit ;
        return;
        playerconfigurationlistener;
        throw playerconfigurationlistener;
    }

    public void configureSynchronous(long l)
        throws CimException
    {
        final CountDownLatch waitForConfig = new CountDownLatch(1);
        PlayerConfigurationListener playerconfigurationlistener = new PlayerConfigurationListener() {

            final PlayerConfigUtil this$0;
            final CountDownLatch val$waitForConfig;

            public void configurationFailed(String s)
            {
                super.configurationFailed(s);
                PlayerConfigUtil.LOG.error("configurationFailed: {}", s);
                waitForConfig.countDown();
            }

            public void configurationLoaded()
            {
                super.configurationLoaded();
                waitForConfig.countDown();
            }

            
            {
                this$0 = PlayerConfigUtil.this;
                waitForConfig = countdownlatch;
                super();
            }
        };
        boolean flag;
        try
        {
            configurePlayerPlatform(playerconfigurationlistener);
            flag = waitForConfig.await(l, TimeUnit.SECONDS);
        }
        catch (InterruptedException interruptedexception)
        {
            throw new CimException("Failed to Configure PlayerPlatform", interruptedexception);
        }
        if (!flag)
        {
            throw new CimException("Failed to Configure PlayerPlatform within allotted timeout");
        } else
        {
            return;
        }
    }


}
