// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.espn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.primetime.android.ads.managers.BaseAdManager;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.enums.DrmWorkflow;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.primetime.android.events.AbstractPlayerPlatformVideoEventListener;
import com.comcast.playerplatform.primetime.android.player.AndroidPlayer;
import com.comcast.playerplatform.primetime.android.player.DisneyEspnTokenDelegate;
import com.comcast.playerplatform.primetime.android.player.Player;
import com.comcast.playerplatform.primetime.android.player.PlayerSettings;
import com.comcast.playerplatform.primetime.android.primetime.PlayerAudioTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerClosedCaptionsTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import com.comcast.playerplatform.primetime.android.primetime.PrimeTimePlayer;
import com.comcast.playerplatform.primetime.android.util.ConfigurationHelper;
import com.comcast.playerplatform.primetime.android.util.FragmentInfo;
import com.comcast.playerplatform.primetime.android.util.LogFactory;
import com.comcast.playerplatform.primetime.android.util.PlayerLogger;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import com.comcast.playerplatform.util.android.StringUtil;
import com.espn.androidplayersdk.datamanager.EPCatalogManager;
import com.espn.androidplayersdk.datamanager.EPEvents;
import com.espn.androidplayersdk.datamanager.EPPlaybackManager;
import com.espn.androidplayersdk.datamanager.EPStream;
import com.espn.androidplayersdk.objects.EPAuthError;
import com.espn.androidplayersdk.playbackmanager.EPPlaybackManagerListener;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EspnPlayer
    implements Player
{

    private static final Logger logger = LoggerFactory.getLogger(com/comcast/playerplatform/primetime/android/espn/EspnPlayer);
    private Context applicationContext;
    private EPCatalogManager catalogManager;
    private CookieManager cookieManager;
    private Asset currentChannel;
    private AbstractPlayerPlatformVideoEventListener eventListener;
    private boolean firstAuthAttempt;
    private EPPlaybackManagerListener playbackListener;
    private EPPlaybackManager playbackManager;
    private Player primeTimePlayer;
    private Runnable tokenRefreshRunnable;

    public EspnPlayer(Context context, HttpClient httpclient, PlayerSettings playersettings)
    {
        firstAuthAttempt = true;
        playbackListener = new EPPlaybackManagerListener() {

            final EspnPlayer this$0;

            public boolean shouldWaitForUpdatedAdobePassParams()
            {
                EspnPlayer.logger.debug("shouldWaitForUpdatedAdobePass");
                return false;
            }

            public boolean shouldWaitForUpdatedAffiliateToken()
            {
                EspnPlayer.logger.debug("shouldWaitForUpdatedAffiliateToken");
                if (currentChannel.getDisneyEspnTokenDelegate() != null && !firstAuthAttempt)
                {
                    ThreadManager.getInstance().executeRunnable(tokenRefreshRunnable);
                }
                return !firstAuthAttempt;
            }

            public void streamAuthorizationFailedWithError(EPAuthError epautherror)
            {
                firstAuthAttempt = false;
                if (eventListener != null)
                {
                    String s = String.valueOf(epautherror.geterrorCode());
                    String s1 = epautherror.getMessage();
                    eventListener.drmFailure(s, s1, "", null);
                    sendMediaFailed(s, s1);
                }
                EspnPlayer.logger.debug((new StringBuilder()).append("Stream Authorization failed with error:").append(epautherror.getMessage()).toString());
            }

            public void streamAuthorizationSucceeded(EPStream epstream)
            {
                EspnPlayer.logger.debug("AuthorizationSucceeded");
                firstAuthAttempt = false;
                HttpCookie httpcookie = new HttpCookie(epstream.getAuthCookieName(), epstream.getToken());
                URI uri = URI.create("https://broadband.espn.go.com/");
                httpcookie.setDomain(uri.getHost());
                httpcookie.setPath(uri.getPath());
                httpcookie.setVersion(0);
                cookieManager.getCookieStore().removeAll();
                cookieManager.getCookieStore().add(uri, httpcookie);
                updatePrimetime(epstream);
            }

            public void streamCookieUpdated(EPStream epstream)
            {
                EspnPlayer.logger.debug("CookieUpdated");
                HttpCookie httpcookie = new HttpCookie(epstream.getAuthCookieName(), epstream.getToken());
                URI uri = URI.create("https://broadband.espn.go.com/");
                httpcookie.setDomain(uri.getHost());
                httpcookie.setPath(uri.getPath());
                httpcookie.setVersion(0);
                cookieManager.getCookieStore().removeAll();
                cookieManager.getCookieStore().add(uri, httpcookie);
                updatePrimetime(epstream);
            }

            public void streamDidEnterBlackout(EPAuthError epautherror)
            {
                EspnPlayer.logger.debug((new StringBuilder()).append("Stream Entered Blackout:").append(epautherror.getMessage()).toString());
                firstAuthAttempt = false;
                if (eventListener != null)
                {
                    eventListener.drmFailure(String.valueOf("7101"), epautherror.getMessage(), "", null);
                    sendMediaFailed(String.valueOf("7101"), epautherror.getMessage());
                    if (primeTimePlayer.getPlayerStatus() == PlayerStatus.PLAYING || primeTimePlayer.getPlayerStatus() == PlayerStatus.PAUSED)
                    {
                        primeTimePlayer.stop();
                    }
                }
            }

            public void streamDidFailAuthorizationWithMessage(String s)
            {
                firstAuthAttempt = false;
                if (eventListener != null)
                {
                    String s1 = String.valueOf(7);
                    if (s.equals("Unable to retrive live event for linear network"))
                    {
                        s1 = String.valueOf(8);
                    }
                    eventListener.drmFailure(s1, s, "", null);
                    sendMediaFailed(s1, s);
                }
                EspnPlayer.logger.debug((new StringBuilder()).append("Authorization failed with message:").append(s).toString());
            }

            
            {
                this$0 = EspnPlayer.this;
                super();
            }
        };
        tokenRefreshRunnable = new Runnable() {

            final EspnPlayer this$0;

            public void run()
            {
                String s = currentChannel.getDisneyEspnTokenDelegate().onTokenExpired(currentChannel.getChannelName(), currentChannel.getDrmKey());
                currentChannel.setDrmKey(s);
                playbackManager.updateAffiliateToken(s);
            }

            
            {
                this$0 = EspnPlayer.this;
                super();
            }
        };
        applicationContext = context;
        if (false)
        {
            primeTimePlayer = new AndroidPlayer(context);
        } else
        {
            primeTimePlayer = new PrimeTimePlayer(context, httpclient, playersettings, null);
        }
        primeTimePlayer.setLogger(LogFactory.getInstance());
        playbackManager = new EPPlaybackManager(playbackListener);
        cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
    }

    private void checkForActiveChannelEvents()
    {
        Object obj;
label0:
        {
            catalogManager = EPCatalogManager.instantiate();
            Object obj1 = null;
            obj = obj1;
            if (!isChannelListAvailable())
            {
                break label0;
            }
            Iterator iterator = catalogManager.getLiveEvents().iterator();
            do
            {
                obj = obj1;
                if (!iterator.hasNext())
                {
                    break label0;
                }
                obj = (EPEvents)iterator.next();
            } while (!((EPEvents) (obj)).getNetworkId().equals(currentChannel.getChannelName()));
            obj = ((EPEvents) (obj)).getEventId();
        }
        if (obj != null)
        {
            currentChannel.setEventId(((String) (obj)));
            playbackManager.initiateStartSessionRequest(((String) (obj)));
            return;
        } else
        {
            sendMediaFailed(String.valueOf(8), "Event can not be found");
            return;
        }
    }

    private boolean isChannelListAvailable()
    {
label0:
        {
label1:
            {
                final CountDownLatch waitForConfig = new CountDownLatch(1);
                BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {

                    final EspnPlayer this$0;
                    final CountDownLatch val$waitForConfig;

                    public void onReceive(Context context, Intent intent)
                    {
                        waitForConfig.countDown();
                        context.unregisterReceiver(this);
                    }

            
            {
                this$0 = EspnPlayer.this;
                waitForConfig = countdownlatch;
                super();
            }
                };
                IntentFilter intentfilter = new IntentFilter("com.espn.action.LIVE_EVENT_UPDATED");
                applicationContext.registerReceiver(broadcastreceiver, intentfilter);
                catalogManager.getLiveEvents();
                boolean flag;
                try
                {
                    if (catalogManager.getLiveEvents().size() > 0)
                    {
                        break label1;
                    }
                    flag = waitForConfig.await(7L, TimeUnit.SECONDS);
                }
                catch (InterruptedException interruptedexception)
                {
                    return false;
                }
                if (!flag)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    private boolean isEspnReady()
    {
label0:
        {
label1:
            {
                final CountDownLatch waitForConfig = new CountDownLatch(1);
                BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {

                    final EspnPlayer this$0;
                    final CountDownLatch val$waitForConfig;

                    public void onReceive(Context context, Intent intent)
                    {
                        waitForConfig.countDown();
                        context.unregisterReceiver(this);
                    }

            
            {
                this$0 = EspnPlayer.this;
                waitForConfig = countdownlatch;
                super();
            }
                };
                IntentFilter intentfilter = new IntentFilter("com.espn.action.CONFIG_UPDATED");
                applicationContext.registerReceiver(broadcastreceiver, intentfilter);
                boolean flag;
                try
                {
                    if ((new ConfigurationHelper()).isEspnReady())
                    {
                        break label1;
                    }
                    flag = waitForConfig.await(7L, TimeUnit.SECONDS);
                }
                catch (InterruptedException interruptedexception)
                {
                    sendMediaFailed(String.valueOf(2), "Failed to configure ESPN playback.");
                    return false;
                }
                if (!flag)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    private void updatePrimetime(EPStream epstream)
    {
        this;
        JVM INSTR monitorenter ;
        if (StringUtil.isNotNullOrEmpty(epstream.getPlaybackUrl()) && !epstream.getPlaybackUrl().equals(currentChannel.getManifestUri()))
        {
            currentChannel.setManifestUri(epstream.getPlaybackUrl());
            currentChannel.setDrmWorkflow(DrmWorkflow.NO_DRM);
            currentChannel.authCookieName = epstream.getAuthCookieName();
            currentChannel.authCookieValue = epstream.getToken();
            ThreadManager.getInstance().executeOnUIThread(new Runnable() {

                final EspnPlayer this$0;

                public void run()
                {
                    primeTimePlayer.setAsset(currentChannel, -1L, null);
                }

            
            {
                this$0 = EspnPlayer.this;
                super();
            }
            });
        }
        this;
        JVM INSTR monitorexit ;
        return;
        epstream;
        throw epstream;
    }

    public void addEventListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        eventListener = abstractplayerplatformvideoeventlistener;
        primeTimePlayer.addEventListener(abstractplayerplatformvideoeventlistener);
    }

    public void destroy()
    {
        if (playbackManager != null)
        {
            playbackManager.releaseSession();
        }
        primeTimePlayer.destroy();
    }

    public BaseAdManager getAdManager()
    {
        return null;
    }

    public List getAvailableAudioLanguages()
    {
        return primeTimePlayer.getAvailableAudioLanguages();
    }

    public List getAvailableBitrates()
    {
        return primeTimePlayer.getAvailableBitrates();
    }

    public List getAvailableClosedCaptionTracks()
    {
        return primeTimePlayer.getAvailableClosedCaptionTracks();
    }

    public List getAvailableProfiles()
    {
        return primeTimePlayer.getAvailableProfiles();
    }

    public boolean getClosedCaptionsStatus()
    {
        return primeTimePlayer.getClosedCaptionsStatus();
    }

    public PlayerAudioTrack getCurrentAudioTrack()
    {
        return primeTimePlayer.getCurrentAudioTrack();
    }

    public int getCurrentBitrate()
    {
        return primeTimePlayer.getCurrentBitrate();
    }

    public Asset getCurrentChannel()
    {
        return primeTimePlayer.getCurrentChannel();
    }

    public PlayerClosedCaptionsTrack getCurrentClosedCaptionTrack()
    {
        return primeTimePlayer.getCurrentClosedCaptionTrack();
    }

    public float getCurrentPlaybackSpeed()
    {
        return 0.0F;
    }

    public long getCurrentPosition()
    {
        return primeTimePlayer.getCurrentPosition();
    }

    public long getDuration()
    {
        return primeTimePlayer.getDuration();
    }

    public long getEndPosition()
    {
        return primeTimePlayer.getEndPosition();
    }

    public FragmentInfo getFragmentInfo()
    {
        return null;
    }

    public PlayerLogger getLogger()
    {
        return primeTimePlayer.getLogger();
    }

    public PlayerStatus getPlayerStatus()
    {
        return primeTimePlayer.getPlayerStatus();
    }

    public List getSupportedClosedCaptionsOptions()
    {
        return primeTimePlayer.getSupportedClosedCaptionsOptions();
    }

    public List getSupportedPlaybackSpeeds()
    {
        return null;
    }

    public PlayerTimeline getTimeline()
    {
        return primeTimePlayer.getTimeline();
    }

    public String getVersion()
    {
        return primeTimePlayer.getVersion();
    }

    public long getVideoHeight()
    {
        return primeTimePlayer.getVideoHeight();
    }

    public StreamType getVideoType()
    {
        return primeTimePlayer.getVideoType();
    }

    public long getVideoWidth()
    {
        return primeTimePlayer.getVideoWidth();
    }

    public View getView()
    {
        return primeTimePlayer.getView();
    }

    public boolean hasCC()
    {
        return primeTimePlayer.hasCC();
    }

    public boolean hasDRM()
    {
        return primeTimePlayer.hasDRM();
    }

    public void pause()
    {
        primeTimePlayer.pause();
    }

    public void play()
    {
        primeTimePlayer.play();
    }

    public void removeEventListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        eventListener = null;
        primeTimePlayer.removeEventListener(abstractplayerplatformvideoeventlistener);
    }

    public void seekToLive()
    {
        primeTimePlayer.seekToLive();
    }

    public void sendMediaFailed(String s, String s1)
    {
        if (eventListener != null)
        {
            eventListener.mediaFailed(s, s1);
        }
    }

    public void setAsset(Asset asset, long l, BaseAdManager baseadmanager)
    {
        firstAuthAttempt = true;
        currentChannel = asset;
        currentChannel.setChannelName(currentChannel.getChannelName().toLowerCase().replace(" ", ""));
        if (asset.getManifestUri() != null)
        {
            primeTimePlayer.setAsset(asset, l, baseadmanager);
            return;
        } else
        {
            ThreadManager.getInstance().executeRunnable(new Runnable() {

                final EspnPlayer this$0;

                public void run()
                {
                    if (isEspnReady())
                    {
                        playbackManager.initWithToken(currentChannel.getDrmKey());
                        String s = currentChannel.getEventId();
                        if (StringUtil.isNotNullOrEmpty(s))
                        {
                            playbackManager.initiateStartSessionRequest(s);
                            return;
                        }
                        if (currentChannel.getChannelName().equals("espn3") || currentChannel.getChannelName().equals("secplus") || currentChannel.getChannelName().equals("goalline"))
                        {
                            checkForActiveChannelEvents();
                            return;
                        } else
                        {
                            playbackManager.initiateLiveEventSessionForLinearNetwork(currentChannel.getChannelName());
                            return;
                        }
                    } else
                    {
                        sendMediaFailed(String.valueOf(1), "Failed to initialize playback for ESPN.");
                        return;
                    }
                }

            
            {
                this$0 = EspnPlayer.this;
                super();
            }
            });
            return;
        }
    }

    public void setClosedCaptionsEnabled(boolean flag)
    {
        primeTimePlayer.setClosedCaptionsEnabled(flag);
    }

    public void setClosedCaptionsTrack(PlayerClosedCaptionsTrack playerclosedcaptionstrack)
    {
        primeTimePlayer.setClosedCaptionsTrack(playerclosedcaptionstrack);
    }

    public void setLogger(LogFactory logfactory)
    {
    }

    public void setLoggingVerbosity(com.adobe.mediacore.logging.Logger.Verbosity verbosity)
    {
        primeTimePlayer.setLoggingVerbosity(verbosity);
    }

    public void setPosition(long l, boolean flag)
    {
        primeTimePlayer.setPosition(l, flag);
    }

    public void setPositionRelative(long l)
    {
        primeTimePlayer.setPositionRelative(l);
    }

    public void setPreferredAudioLanguage(PlayerAudioTrack playeraudiotrack)
    {
        primeTimePlayer.setPreferredAudioLanguage(playeraudiotrack);
    }

    public void setVolume(int i)
    {
        primeTimePlayer.setVolume(i);
    }

    public void stop()
    {
        primeTimePlayer.stop();
    }









/*
    static boolean access$402(EspnPlayer espnplayer, boolean flag)
    {
        espnplayer.firstAuthAttempt = flag;
        return flag;
    }

*/





}
