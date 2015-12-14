// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.SparseIntArray;
import com.targetspot.android.sdk.AdClient;
import com.targetspot.android.sdk.AdListener;
import com.targetspot.android.sdk.AdSettings;
import com.targetspot.android.sdk.ui.AdPopup;
import com.targetspot.android.sdk.util.MediaUtil;
import java.io.IOException;

// Referenced classes of package com.targetspot.android.sdk.service:
//            AdManager, AdBreak, DownloadManager, AdSegment, 
//            AdData, LoggingManager

public class AdClientImpl
    implements AdClient
{

    private static final int STATE_FETCHING = 1;
    private static final int STATE_NONE = 0;
    private static final int STATE_PLAYING = 2;
    private AdBreak adBreak;
    private AdListener adListener;
    private AdBreak.SegmentPosition adPosition;
    private com.targetspot.android.sdk.util.MediaUtil.MediaHandler audioHandler;
    private AdListener backgroundListener;
    private Service backgroundService;
    private final int clientId;
    private Activity currentActivity;
    private int duration;
    private Handler handler;
    private int lastPos;
    private AdManager manager;
    private PhoneStateListener phoneStateListener;
    private AdPopup popup;
    private int popupId;
    private boolean preRollAd;
    private int state;
    private ProgressDialog throbber;
    private int throbberId;
    private android.os.PowerManager.WakeLock wakeLock;

    public AdClientImpl(int i)
    {
        manager = AdManager.getInstance();
        currentActivity = null;
        adListener = null;
        backgroundService = null;
        backgroundListener = null;
        throbber = null;
        throbberId = 0;
        popup = null;
        popupId = 0;
        adBreak = null;
        adPosition = new AdBreak.SegmentPosition();
        state = 0;
        preRollAd = false;
        duration = 0;
        lastPos = 0;
        wakeLock = null;
        handler = new Handler() {

            final AdClientImpl this$0;

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR tableswitch 5 8: default 36
            //                           5 37
            //                           6 99
            //                           7 53
            //                           8 45;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                return;
_L2:
                sendAdAvailable();
                return;
_L5:
                sendAdRefreshing();
                return;
_L4:
                if (state == 1)
                {
                    dismissPopup();
                    state = 0;
                }
                sendPlaybackError(message.arg1, (Exception)message.obj);
                return;
_L3:
                if (state == 1)
                {
                    Log.d("AdClient", "Starting preroll playback");
                    state = 2;
                    if (throbber != null)
                    {
                        throbber.dismiss();
                    }
                    startAd();
                    return;
                }
                if (true) goto _L1; else goto _L6
_L6:
            }

            
            {
                this$0 = AdClientImpl.this;
                super();
            }
        };
        phoneStateListener = new PhoneStateListener() {

            final AdClientImpl this$0;

            public void onCallStateChanged(int j, String s)
            {
                if (j != 1) goto _L2; else goto _L1
_L1:
                if (((AudioManager)backgroundService.getSystemService("audio")).getStreamVolume(2) > 0 && j == 2)
                {
                    stopAd(3);
                }
_L4:
                return;
_L2:
                if (j != 2)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (j != 2) goto _L4; else goto _L3
_L3:
                stopAd(3);
                return;
                if (j != 0) goto _L4; else goto _L5
_L5:
            }

            
            {
                this$0 = AdClientImpl.this;
                super();
            }
        };
        audioHandler = new com.targetspot.android.sdk.util.MediaUtil.MediaHandler() {

            final AdClientImpl this$0;

            public void onPlaybackComplete()
            {
                AdManager.getInstance().getLogger().logImpression(adPosition.segment);
                if (adBreak.nextSegment(adPosition))
                {
                    Log.d("AdClient", (new StringBuilder()).append("Switching ads, pos ").append(adPosition.beginning).toString());
                    startAudio(adBreak, adPosition.beginning);
                    if (popup != null)
                    {
                        popup.setPosition(adPosition);
                    }
                    return;
                } else
                {
                    dismissPopup();
                    stopAd(1);
                    return;
                }
            }

            public void onPlaybackError()
            {
                dismissPopup();
                sendPlaybackError(-1, new Exception("Ad playback error"));
            }

            
            {
                this$0 = AdClientImpl.this;
                super();
            }
        };
        clientId = i;
    }

    private void dismissPopup()
    {
        if (popup != null)
        {
            popupId = popupId + 1;
            Throwable throwable;
            try
            {
                popup.dismissPopup();
            }
            catch (Throwable throwable1) { }
            popup = null;
        }
        if (throbber != null)
        {
            try
            {
                throbberId = throbberId + 1;
                throbber.dismiss();
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable) { }
            throbber = null;
        }
    }

    private void pauseAudio()
    {
        int i = MediaUtil.pauseMedia();
        lastPos = adPosition.beginning + i;
        Log.d("AdClient", (new StringBuilder()).append("Paused at position ").append(lastPos).toString());
    }

    private void releaseWakeLock()
    {
        if (wakeLock != null)
        {
            if (wakeLock.isHeld())
            {
                wakeLock.release();
            }
            wakeLock = null;
        }
    }

    private boolean resumeAudio()
    {
        if (adBreak.getSegment(lastPos, adPosition))
        {
            int i = lastPos - adPosition.beginning;
            Log.d("AdCLient", (new StringBuilder()).append("Resumed at position ").append(i).toString());
            MediaUtil.playMedia(i);
            return true;
        } else
        {
            return false;
        }
    }

    public void adClicked(AdSegment adsegment)
    {
        manager.logAdClicked(adsegment);
    }

    public void adPlayed(AdSegment adsegment)
    {
        manager.logAdPlayed(adsegment);
    }

    public AdBreak beginBreak(boolean flag, int i)
    {
        if (!sessionStarted())
        {
            Log.e("AdClient", "AdSession is not started");
            return null;
        }
        if (!inActivity() && !inBackground())
        {
            Log.e("AdClient", "No current activity or service registered,  can't play ad");
            return null;
        }
        if (manager.isManagedMode())
        {
            Log.e("AdClient", "Cannot access AdBreak when in Managed mode");
            return null;
        }
        if (state != 0)
        {
            Log.e("AdClient", "Cannot call beginBreak when in playback or fetching state");
            return null;
        }
        AdBreak adbreak = manager.playbackStart(flag, i);
        if (adbreak != null)
        {
            preRollAd = flag;
            duration = i;
            state = 2;
            return adbreak;
        } else
        {
            Log.e("AdClient", "No ads currently available");
            return null;
        }
    }

    public boolean breakAvail()
    {
        return manager.isAdAvailable(false);
    }

    public boolean breakAvail(int i)
    {
        int ai[] = getAvailableAds();
        if (ai != null)
        {
            int j = 0;
            while (j < ai.length) 
            {
                if (ai[j] == i)
                {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    void createPopup()
    {
        Activity activity = currentActivity;
        int i = popupId + 1;
        popupId = i;
        popup = new AdPopup(activity, this, i);
        popup.showPopup(false, adBreak, 0);
        wakeLock = ((PowerManager)currentActivity.getSystemService("power")).newWakeLock(0x30000006, "AdClient");
        wakeLock.acquire();
    }

    public void endBreak(boolean flag)
    {
        if (!inActivity() && !inBackground())
        {
            Log.e("AdClient", "No current activity or service registered,  can't end break");
            return;
        }
        if (manager.isManagedMode())
        {
            Log.e("AdClient", "Cannot access AdBreak when in Managed mode");
            return;
        }
        if (state != 2)
        {
            Log.e("AdClient", "endBreak called when not in playback state");
            return;
        } else
        {
            state = 0;
            manager.playbackEnd(flag);
            return;
        }
    }

    public void enterActivity(Activity activity, AdListener adlistener)
    {
        Log.d("AdClient", "Entering activity");
        currentActivity = activity;
        adListener = adlistener;
        manager.enterActivity(this);
        if (state == 1)
        {
            showThrobber();
            if (manager.isAdAvailable(true))
            {
                handler.sendEmptyMessage(6);
            }
        } else
        if (state == 2)
        {
            resumeAd();
            return;
        }
    }

    public void enterService(Service service, AdListener adlistener)
    {
        Log.d("AdClient", "Entering service");
        backgroundService = service;
        backgroundListener = adlistener;
        manager.enterService(this);
        ((TelephonyManager)backgroundService.getSystemService("phone")).listen(phoneStateListener, 32);
    }

    int getAudioPosition()
    {
        return adPosition.beginning + MediaUtil.getPosition();
    }

    public SparseIntArray getAvailBreaks()
    {
        int ai[] = getAvailableAds();
        SparseIntArray sparseintarray = new SparseIntArray();
        if (ai != null)
        {
            int i = 0;
            while (i < ai.length) 
            {
                Integer integer = Integer.valueOf(sparseintarray.get(ai[i]));
                if (integer == null)
                {
                    sparseintarray.put(ai[i], 1);
                } else
                {
                    sparseintarray.put(ai[i], integer.intValue() + 1);
                }
                i++;
            }
        }
        return sparseintarray;
    }

    public int[] getAvailableAds()
    {
        return manager.getAdLengths();
    }

    public String getCacheURL(String s)
    {
        String s1;
        try
        {
            s1 = manager.getDownloader().getContentURL(s);
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return s;
        }
        return s1;
    }

    public int getId()
    {
        return clientId;
    }

    Handler gethandler()
    {
        return handler;
    }

    public void hideInlineAd()
    {
        Log.d("AdClient", "Hiding ad");
        dismissPopup();
        if (state == 2)
        {
            stopAd(5);
        }
    }

    boolean inActivity()
    {
        return currentActivity != null;
    }

    boolean inBackground()
    {
        return backgroundService != null;
    }

    public void leaveActivity()
    {
        Log.d("AdClient", "Leaving activity");
        if (!inActivity()) goto _L2; else goto _L1
_L1:
        dismissPopup();
        releaseWakeLock();
        if (state != 2) goto _L4; else goto _L3
_L3:
        if (currentActivity.getChangingConfigurations() == 0)
        {
            if (!inBackground())
            {
                stopAd(3);
            }
        } else
        {
            Log.d("AdClient", "Leaving activity for configuration change, leaving audio playing");
        }
_L6:
        manager.leaveActivity(this);
        currentActivity = null;
        adListener = null;
_L2:
        return;
_L4:
        if (state == 1)
        {
            if (currentActivity.getChangingConfigurations() == 0)
            {
                state = 0;
                sendPlaybackStopped(3);
            } else
            {
                Log.d("AdClient", "Saving throbber state");
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void leaveService()
    {
        Log.d("AdClient", "Leaving service");
        if (inBackground())
        {
            ((TelephonyManager)backgroundService.getSystemService("phone")).listen(phoneStateListener, 0);
            if (!inActivity() && state == 2)
            {
                stopAd(5);
            }
            manager.leaveService(this);
            backgroundService = null;
            backgroundListener = null;
        }
    }

    public void onAdClosed(int i)
    {
        releaseWakeLock();
        if (popup != null && popup.getId() == popupId)
        {
            popup = null;
            if (!inBackground())
            {
                stopAd(i);
            }
        }
    }

    public void refreshBreaks()
    {
        manager.refreshAds();
    }

    void restorePopup()
    {
        Log.d("AdCLient", (new StringBuilder()).append("Restoring position ").append(lastPos).toString());
        if (adBreak != null)
        {
            Activity activity = currentActivity;
            int i = popupId + 1;
            popupId = i;
            popup = new AdPopup(activity, this, i);
            popup.showPopupDelayed(preRollAd, adBreak, lastPos);
        }
    }

    void resumeAd()
    {
        if (adBreak == null)
        {
            Log.d("AdClient", "No ad to resume");
            return;
        } else
        {
            lastPos = getAudioPosition();
            restorePopup();
            return;
        }
    }

    void sendAdAvailable()
    {
        if (adListener != null)
        {
            adListener.onAdAvailable();
        }
        if (backgroundListener != null)
        {
            backgroundListener.onAdAvailable();
        }
    }

    void sendAdRefreshing()
    {
        if (adListener != null)
        {
            adListener.onAdRefreshing();
        }
        if (backgroundListener != null)
        {
            backgroundListener.onAdRefreshing();
        }
    }

    void sendPlaybackError(int i, Exception exception)
    {
        if (adListener != null)
        {
            adListener.onError(i, exception);
        }
        if (backgroundListener != null)
        {
            backgroundListener.onError(i, exception);
        }
    }

    void sendPlaybackStarting()
    {
        if (adListener != null)
        {
            adListener.onPlaybackStarting();
        }
        if (backgroundListener != null)
        {
            backgroundListener.onPlaybackStarting();
        }
    }

    void sendPlaybackStopped(int i)
    {
        if (adListener != null)
        {
            adListener.onPlaybackStopped(i);
        }
        if (backgroundListener != null)
        {
            backgroundListener.onPlaybackStopped(i);
        }
    }

    boolean sessionStarted()
    {
        return manager.getAdSettings() != null;
    }

    public void showInlineAd(int i)
    {
        if (!sessionStarted())
        {
            Log.e("AdClient", "AdSession is not started");
        } else
        {
            if (!inActivity() && !inBackground())
            {
                Log.e("AdClient", "No current activity or service registered, can't play ad");
                return;
            }
            if (!manager.isManagedMode())
            {
                Log.e("AdClient", "SDK is in unmanaged mode, can't play ad.");
                return;
            }
            if (state == 0)
            {
                duration = i;
                preRollAd = false;
                startAd();
                return;
            }
        }
    }

    public void showPreRollAd(int i)
    {
        if (!inActivity())
        {
            Log.e("AdClient", "No current activity registered, can't preroll ad");
        } else
        {
            if (!manager.isManagedMode())
            {
                Log.e("AdClient", "SDK is in unmanaged mode, can't play ad.");
                return;
            }
            if (state == 0)
            {
                duration = i;
                preRollAd = true;
                showThrobber();
                manager.requestAd(true, i);
                return;
            }
        }
    }

    void showThrobber()
    {
        throbberId = throbberId + 1;
        throbber = ProgressDialog.show(currentActivity, "", "Buffering...", true, true, new android.content.DialogInterface.OnCancelListener() {

            final AdClientImpl this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
            }

            
            {
                this$0 = AdClientImpl.this;
                super();
            }
        });
        throbber.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final int myId;
            final AdClientImpl this$0;

            public void onDismiss(DialogInterface dialoginterface)
            {
                if (state == 1 && throbberId == myId)
                {
                    Log.d("AdClient", "User cancelled preroll");
                    sendPlaybackStopped(2);
                    state = 0;
                }
            }

            
            {
                this$0 = AdClientImpl.this;
                super();
                myId = throbberId;
            }
        });
        state = 1;
    }

    boolean startAd()
    {
        adBreak = manager.playbackStart(preRollAd, duration);
        if (adBreak == null)
        {
            Log.d("AdClient", "No ad available for playback");
            sendPlaybackError(-3, new Exception("No ad suitable for playback"));
            return false;
        }
        state = 2;
        sendPlaybackStarting();
        if (inActivity())
        {
            createPopup();
        }
        lastPos = 0;
        startAudio(adBreak, 0);
        return true;
    }

    void startAudio(AdBreak adbreak, int i)
    {
        if (!adbreak.getSegment(i, adPosition))
        {
            return;
        }
        adbreak = adPosition.segment;
        String s;
        try
        {
            s = manager.getDownloader().getContentURL(adbreak.getAudioFile().getUrl());
        }
        catch (IOException ioexception)
        {
            Log.e("AdClient", (new StringBuilder()).append("Unable to load audio from ").append(adbreak.getAudioFile().getUrl()).toString());
            return;
        }
        MediaUtil.loadMedia(s, audioHandler);
        adbreak = manager.getAdSettings();
        if (adbreak.getPlaybackVolume() > 0.0D && adbreak.getPlaybackVolume() <= 1.0D)
        {
            MediaUtil.setVolume((float)adbreak.getPlaybackVolume());
        }
        MediaUtil.playMedia(i - adPosition.beginning);
    }

    void stopAd(int i)
    {
        boolean flag = true;
        if (state == 2)
        {
            state = 0;
            AdManager admanager = manager;
            if (i != 1)
            {
                flag = false;
            }
            admanager.playbackEnd(flag);
            MediaUtil.stopMedia();
            sendPlaybackStopped(i);
        }
    }



/*
    static int access$002(AdClientImpl adclientimpl, int i)
    {
        adclientimpl.state = i;
        return i;
    }

*/







}
