// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.disney.datg.videoplatforms.sdk.common.AsyncHandler;
import com.disney.datg.videoplatforms.sdk.common.ThreadPoolAccessor;
import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.models.api.AdAsset;
import com.disney.datg.videoplatforms.sdk.models.api.AdBreak;
import com.disney.datg.videoplatforms.sdk.models.api.AdCollection;
import com.disney.datg.videoplatforms.sdk.models.api.Ads;
import com.disney.datg.videoplatforms.sdk.models.api.PlayManifest;
import com.disney.datg.videoplatforms.sdk.models.api.ResponseMessage;
import com.disney.datg.videoplatforms.sdk.models.api.UplynkData;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import com.uplynk.media.CaptionEvent;
import com.uplynk.media.MediaPlayer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMediaPlayer, VPMedia, VPMediaMetadata, CaptionUtils, 
//            CaptionData, Configuration

public class VODMediaPlayer extends VPMediaPlayer
{
    class PingUplynk
    {

        String host;
        String session;
        final VODMediaPlayer this$0;

        public Future ping(final int playerTime, String s)
        {
            return ThreadPoolAccessor.getManager().execute(s. new Callable() {

                final PingUplynk this$1;
                final String val$event;
                final int val$playerTime;

                public Integer call()
                    throws Exception
                {
                    Object obj;
                    Object obj1;
                    StringBuilder stringbuilder;
                    obj = "";
                    obj1 = String.format("%s/session/ping/%s.json?v=1&pt=%s", new Object[] {
                        host, session, Integer.valueOf(playerTime)
                    });
                    String s = ((String) (obj1));
                    if (!TextUtils.isEmpty(event))
                    {
                        s = (new StringBuilder()).append(((String) (obj1))).append("&ev=").append(event).toString();
                    }
                    BufferedReader bufferedreader;
                    String s1;
                    int i;
                    try
                    {
                        obj1 = (new DefaultHttpClient()).execute(new HttpGet(s)).getEntity().getContent();
                    }
                    catch (Exception exception)
                    {
                        LogUtils.LOGE(VODMediaPlayer.TAG, exception.getMessage());
                        return Integer.valueOf(-1);
                    }
                    bufferedreader = new BufferedReader(new InputStreamReader(((InputStream) (obj1)), "utf-8"), 8);
                    stringbuilder = new StringBuilder();
_L3:
                    s1 = bufferedreader.readLine();
                    if (s1 == null) goto _L2; else goto _L1
_L1:
                    stringbuilder.append((new StringBuilder()).append(s1).append("\n").toString());
                      goto _L3
                    obj1;
                    nextPingTime = -1;
_L9:
                    obj = new JSONObject(((String) (obj)));
                    LogUtils.LOGD(VODMediaPlayer.TAG, String.format("result of uplynk pint ss-ad %s -- %s", new Object[] {
                        s, ((JSONObject) (obj)).toString()
                    }));
                    i = ((JSONObject) (obj)).getInt("next_time");
                    if (i >= 0) goto _L5; else goto _L4
_L4:
                    needsPing = false;
_L7:
                    return Integer.valueOf(i);
_L2:
                    ((InputStream) (obj1)).close();
                    obj1 = stringbuilder.toString();
                    obj = obj1;
                    continue; /* Loop/switch isn't completed */
_L5:
                    needsPing = true;
                    if (true) goto _L7; else goto _L6
_L6:
                    JSONException jsonexception;
                    jsonexception;
                    LogUtils.LOGE(VODMediaPlayer.TAG, jsonexception.getMessage());
                    return Integer.valueOf(-1);
                    if (true) goto _L9; else goto _L8
_L8:
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                this$1 = final_pinguplynk;
                playerTime = i;
                event = String.this;
                super();
            }
            });
        }

        public PingUplynk(String s, String s1)
        {
            this$0 = VODMediaPlayer.this;
            super();
            host = s;
            session = s1;
        }
    }

    class ProgressionTask extends TimerTask
    {

        final VODMediaPlayer this$0;

        public void run()
        {
            if (!isPlaying()) goto _L2; else goto _L1
_L1:
            int i;
            int j;
            j = getCurrentPosition();
            isCurrentTimeInAdBreak(j);
            i = j / 1000;
            j = (j * 100) / getDuration();
            if (j < 99 || omnitureTagFiredForWatchedPercentage >= 99) goto _L4; else goto _L3
_L3:
            omnitureTagFiredForWatchedPercentage = 99;
            sendTrackable(VPMediaPlayer.TrackableState.COMPLETE);
_L7:
            if (currentAdBreak != null || i < nextPingTime || !needsPing || pingUplynk == null) goto _L2; else goto _L5
_L5:
            needsPing = false;
            if (i != 0)
            {
                break; /* Loop/switch isn't completed */
            }
            nextPingTime = ((Integer)pingUplynk.ping(i, "start").get(5L, TimeUnit.SECONDS)).intValue();
_L2:
            return;
_L4:
            if (j >= 75 && omnitureTagFiredForWatchedPercentage < 75)
            {
                omnitureTagFiredForWatchedPercentage = 75;
                sendTrackable(VPMediaPlayer.TrackableState.COMPLETE_75);
            } else
            if (j >= 50 && omnitureTagFiredForWatchedPercentage < 50)
            {
                omnitureTagFiredForWatchedPercentage = 50;
                sendTrackable(VPMediaPlayer.TrackableState.COMPLETE_50);
            } else
            if (j >= 25 && omnitureTagFiredForWatchedPercentage < 25)
            {
                omnitureTagFiredForWatchedPercentage = 25;
                sendTrackable(VPMediaPlayer.TrackableState.COMPLETE_25);
            }
            if (true) goto _L7; else goto _L6
            Object obj;
            obj;
            LogUtils.LOGE(VODMediaPlayer.TAG, ((InterruptedException) (obj)).getMessage());
            return;
            obj;
            LogUtils.LOGE(VODMediaPlayer.TAG, ((ExecutionException) (obj)).getMessage());
            return;
            obj;
            LogUtils.LOGE(VODMediaPlayer.TAG, ((TimeoutException) (obj)).getMessage());
            return;
_L6:
            try
            {
                nextPingTime = ((Integer)pingUplynk.ping(i, null).get(5L, TimeUnit.SECONDS)).intValue();
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                LogUtils.LOGE(VODMediaPlayer.TAG, interruptedexception.getMessage());
                return;
            }
            catch (ExecutionException executionexception)
            {
                LogUtils.LOGE(VODMediaPlayer.TAG, executionexception.getMessage());
                return;
            }
            catch (TimeoutException timeoutexception)
            {
                LogUtils.LOGE(VODMediaPlayer.TAG, timeoutexception.getMessage());
            }
            return;
        }

        ProgressionTask()
        {
            this$0 = VODMediaPlayer.this;
            super();
        }
    }


    private static String TAG = com/disney/datg/videoplatforms/sdk/media/VODMediaPlayer.getName();
    protected LinkedHashSet adCues;
    protected AdAsset currentAd;
    protected AdBreak currentAdBreak;
    protected Ads currentAdGroup;
    protected int currentAdIndex;
    protected int currentAdTotal;
    private boolean inAd;
    protected boolean loop;
    boolean needsPing;
    protected int nextPingTime;
    private int omnitureTagFiredForWatchedPercentage;
    PingUplynk pingUplynk;
    protected PlayManifest playManifest;
    protected Timer progressionTimer;
    protected int timeToSeekToAfterUnlockingAdBreak;

    protected VODMediaPlayer(Context context, Configuration configuration)
        throws AndroidSDKException
    {
        super(context, configuration);
        adCues = new LinkedHashSet();
        timeToSeekToAfterUnlockingAdBreak = -1;
        needsPing = true;
        inAd = false;
        loop = false;
        omnitureTagFiredForWatchedPercentage = 0;
        omnitureTagFiredForWatchedPercentage = 0;
    }

    private void configurePlayManifest(VPMedia vpmedia)
    {
        LogUtils.LOGD(TAG, "configurePlayManifest");
        adCues.clear();
        if (vpmedia.getPlayManifest() != null)
        {
            vpmedia = vpmedia.getPlayManifest();
            if (vpmedia != null && vpmedia.getAdCollection() != null && vpmedia.getAdCollection().getAdbreak() != null && vpmedia.getAdCollection().getAdbreak().size() > 0)
            {
                if (vpmedia.getEntitlmentResponse() != null && vpmedia.getEntitlmentResponse().getUplynkData() != null)
                {
                    String s = vpmedia.getEntitlmentResponse().getUplynkData().getHost();
                    String s1 = vpmedia.getEntitlmentResponse().getUplynkData().getSessionId();
                    if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
                    {
                        pingUplynk = new PingUplynk(s, s1);
                        needsPing = true;
                    }
                }
                setPlayManifest(vpmedia);
                AdBreak adbreak;
                for (vpmedia = vpmedia.getAdCollection().getAdbreak().iterator(); vpmedia.hasNext(); adCues.add(adbreak))
                {
                    adbreak = (AdBreak)vpmedia.next();
                }

                LogUtils.LOGD(TAG, "manifest file returned and cues inserted");
                return;
            } else
            {
                LogUtils.LOGD(TAG, "manifest file returned with no ad cues");
                return;
            }
        } else
        {
            LogUtils.LOGD(TAG, "manifest file returned null");
            return;
        }
    }

    private void startProgressionTimer()
    {
        stopProgressionTimer();
        progressionTimer = new Timer();
        progressionTimer.schedule(new ProgressionTask(), 0L, 500L);
    }

    private void stopProgressionTimer()
    {
        if (progressionTimer != null)
        {
            progressionTimer.cancel();
            progressionTimer.purge();
        }
    }

    protected void enteredAd(AdAsset adasset)
    {
        if (currentAdBreak != null && currentAdGroup != null && adasset != null)
        {
            currentAd = adasset;
            adasset = new Bundle();
            if (currentAdGroup != null && !TextUtils.isEmpty(currentAdGroup.getType()))
            {
                adasset.putString(VPMediaMetadata.ADINFO_AD_TYPE, currentAdGroup.getType());
            }
            adasset.putString(VPMediaMetadata.ADINFO_AD_DURATION, currentAd.getDuration());
            adasset.putInt(VPMediaMetadata.ADINFO_TOTAL_ADS, currentAdTotal);
            adasset.putInt(VPMediaMetadata.ADINFO_AD_INDEX, currentAdIndex);
            sendMetadataEvent(VPMediaMetadata.BOUNDARY_EVENT_AD_START, adasset);
            sendTrackable(VPMediaPlayer.TrackableState.AD_START);
            LogUtils.LOGD(TAG, (new StringBuilder()).append("VODMediaPlayer: enteredAd ").append(Math.floor(currentAd.getStart() * 1000F)).append(" ").append(Math.floor(currentAd.getEnd() * 1000F)).toString());
        }
    }

    protected void enteredAdBreak(AdBreak adbreak)
    {
        if (adbreak != null)
        {
            currentAdBreak = adbreak;
            resetCurrentAd();
            currentAdBreak.setAdEventStarted(true);
            sendMetadataEvent(VPMediaMetadata.BOUNDARY_EVENT_AD_BREAK_START);
            sendTrackable(VPMediaPlayer.TrackableState.AD_BREAK_START);
            LogUtils.LOGD(TAG, (new StringBuilder()).append("VODMediaPlayer: enteredAdBreak ").append(Math.floor(currentAdBreak.getStart() * 1000F)).append(" ").append(Math.floor(currentAdBreak.getEnd() * 1000F)).toString());
        }
        printAdBreakStatus();
    }

    protected AdBreak getAdBreakBeforeTime(int i)
    {
        AdBreak adbreak;
        AdBreak adbreak1;
        Iterator iterator;
        iterator = null;
        adbreak = null;
        adbreak1 = iterator;
        if (adCues == null) goto _L2; else goto _L1
_L1:
        adbreak1 = iterator;
        if (adCues.isEmpty()) goto _L2; else goto _L3
_L3:
        iterator = adCues.iterator();
_L8:
        adbreak1 = adbreak;
        if (!iterator.hasNext()) goto _L2; else goto _L4
_L4:
        float f;
        adbreak1 = (AdBreak)iterator.next();
        f = (float)Math.floor(adbreak1.getStart() * 1000F);
        float f2 = (float)Math.ceil(adbreak1.getEnd() * 1000F);
        if (adbreak == null || (float)i >= f || (float)i <= (float)Math.floor(adbreak.getStart() * 1000F)) goto _L6; else goto _L5
_L5:
        adbreak1 = adbreak;
_L2:
        if (adbreak1 != null)
        {
            float f1 = (float)Math.floor(adbreak1.getStart() * 1000F);
            float f3 = (float)Math.ceil(adbreak1.getEnd() * 1000F);
            boolean flag = adbreak1.isWatched();
            LogUtils.LOGD(TAG, (new StringBuilder()).append("VODMediaPlayer: getAdBreakBeforeTime: ").append(i).append(" curAdBreak.watched: ").append(flag).append(" curAdBreak.start: ").append(f1).append(" curAdBreak.end: ").append(f3).toString());
        }
        return adbreak1;
_L6:
        adbreak = adbreak1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected boolean isCurrentTimeInAdBreak(int i)
    {
label0:
        {
            if (adCues == null || adCues.isEmpty())
            {
                break label0;
            }
            Iterator iterator = adCues.iterator();
            float f;
            float f1;
            AdBreak adbreak;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                adbreak = (AdBreak)iterator.next();
                f = (float)Math.floor(adbreak.getStart() * 1000F);
                f1 = (float)Math.ceil(adbreak.getEnd() * 1000F);
            } while ((float)i < f || (float)i >= f1);
            if (!inAd)
            {
                enteredAdBreak(adbreak);
            }
            inAd = true;
            seekAllowed = false;
            if (inAd && currentAdBreak != null)
            {
                sendAdInfoCurrentAdBreak(i);
            }
            return inAd;
        }
        seekAllowed = true;
        if (inAd && currentAdBreak != null && currentAdBreak.isAdEventStarted() && (float)i >= (float)Math.ceil(currentAdBreak.getEnd() * 1000F))
        {
            leftAd();
            leftAdBreak();
            if (timeToSeekToAfterUnlockingAdBreak >= 0)
            {
                seekTo(timeToSeekToAfterUnlockingAdBreak);
                timeToSeekToAfterUnlockingAdBreak = -1;
            }
        }
        inAd = false;
        return inAd;
    }

    protected void leftAd()
    {
        if (currentAdBreak != null && currentAd != null)
        {
            LogUtils.LOGD(TAG, (new StringBuilder()).append("VODMediaPlayer: leftAd ").append(Math.floor(currentAd.getStart() * 1000F)).append(" ").append(Math.floor(currentAd.getEnd() * 1000F)).toString());
            Bundle bundle = new Bundle();
            if (currentAdGroup != null && !TextUtils.isEmpty(currentAdGroup.getType()))
            {
                bundle.putString(VPMediaMetadata.ADINFO_AD_TYPE, currentAdGroup.getType());
            }
            bundle.putString(VPMediaMetadata.ADINFO_AD_DURATION, currentAd.getDuration());
            bundle.putInt(VPMediaMetadata.ADINFO_TOTAL_ADS, currentAdTotal);
            bundle.putInt(VPMediaMetadata.ADINFO_AD_INDEX, currentAdIndex);
            sendMetadataEvent(VPMediaMetadata.BOUNDARY_EVENT_AD_END, bundle);
            sendTrackable(VPMediaPlayer.TrackableState.AD_END);
        }
    }

    protected void leftAdBreak()
    {
        if (currentAdBreak != null)
        {
            LogUtils.LOGD(TAG, (new StringBuilder()).append("VODMediaPlayer: leftAdBreak ").append(Math.floor(currentAdBreak.getStart() * 1000F)).append(" ").append(Math.floor(currentAdBreak.getEnd() * 1000F)).toString());
            currentAdBreak.setWatched(true);
            currentAdBreak = null;
            resetCurrentAd();
            sendMetadataEvent(VPMediaMetadata.BOUNDARY_EVENT_AD_BREAK_END);
            sendTrackable(VPMediaPlayer.TrackableState.AD_BREAK_END);
        }
        printAdBreakStatus();
    }

    public boolean onCaptionEvent(MediaPlayer mediaplayer, CaptionEvent captionevent)
    {
        if (captionevent != null && closeCaptionsOn && captionevent.eventType != null)
        {
            mediaplayer = CaptionUtils.parseEvent(captionevent, "00:00:00", "00:00:00");
            sendTimedText(mediaplayer.getWebVTT(), mediaplayer);
            return true;
        } else
        {
            return false;
        }
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        super.onCompletion(mediaplayer);
        if (loop && uplynkMediaPlayer != null)
        {
            uplynkMediaPlayer.start();
        }
        stopProgressionTimer();
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        Bundle bundle = new Bundle();
        if (i == 100)
        {
            String s = ErrorCode.ANDROID_SDK_MEDIA_PLAYER_PLAYBACK_ERROR.getReason().replace("[video id]", getCurrentMedia().getMediaId());
            bundle.putString("trackCode", s);
            bundle.putString("error", String.format("lf:video playback:%s", new Object[] {
                s
            }));
        } else
        {
            String s1 = (new StringBuilder()).append("unknown:vodplayer:").append(i).append(",").append(j).toString();
            bundle.putString("trackCode", s1);
            bundle.putString("error", String.format("lf:video playback:%s", new Object[] {
                s1
            }));
        }
        sendTrackable(VPMediaPlayer.TrackableState.MEDIA_ERROR, bundle);
        super.onError(mediaplayer, i, j);
        return false;
    }

    public boolean onUplynkMetadata(MediaPlayer mediaplayer, com.uplynk.media.MediaPlayer.UplynkMetadata uplynkmetadata)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        super.onUplynkMetadata(mediaplayer, uplynkmetadata);
        flag = flag1;
        if (!processNextAsset) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (uplynkmetadata == null) goto _L2; else goto _L3
_L3:
        flag = flag1;
        if (TextUtils.isEmpty(uplynkmetadata.getAssetID())) goto _L2; else goto _L4
_L4:
        flag = flag1;
        if (TextUtils.isEmpty(currentAssetId)) goto _L2; else goto _L5
_L5:
        flag = flag1;
        if (!TextUtils.equals(currentAssetId, uplynkmetadata.getAssetID())) goto _L2; else goto _L6
_L6:
        if (getCurrentMedia() != null && getCurrentMedia().getCurrentMetadata() != null)
        {
            getCurrentMedia().getCurrentMetadata().setUplynkMetadata(uplynkmetadata);
        }
        LogUtils.LOGD(TAG, "processing uplynk metadata");
        mediaplayer = uplynkmetadata.getAssetInfo();
        flag = flag1;
        if (mediaplayer == null) goto _L2; else goto _L7
_L7:
        if (!mediaplayer.isAd()) goto _L9; else goto _L8
_L8:
        processNextAsset = false;
        flag = true;
_L2:
        return flag;
_L9:
        if (!TextUtils.equals(currentAssetId, currentProgramId))
        {
            sendMetadataEvent(VPMediaMetadata.BOUNDARY_EVENT_PROGRAM_START);
            uplynkmetadata = new Bundle();
            uplynkmetadata.putString("start_video", "");
            sendTrackable(VPMediaPlayer.TrackableState.PROGRAM_START, uplynkmetadata);
            currentProgramId = currentAssetId;
            int i = mediaplayer.getTvRating();
            int j = mediaplayer.getMovieRating();
            if (i != -1)
            {
                currentRating = i;
            }
            if (j != -1)
            {
                currentRating = j;
            }
        } else
        {
            mediaplayer = new Bundle();
            mediaplayer.putString("start_video", "");
            sendTrackable(VPMediaPlayer.TrackableState.PROGRAM_START, mediaplayer);
        }
        if (true) goto _L8; else goto _L10
_L10:
    }

    public void pause()
        throws IllegalStateException
    {
        super.pause();
        static class _cls1
        {

            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType[];

            static 
            {
                $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType = new int[VPMediaPlayer.BasePlayerType.values().length];
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType[VPMediaPlayer.BasePlayerType.UPLYNK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType[VPMediaPlayer.BasePlayerType.NATIVE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            stopProgressionTimer();
            break;
        }
    }

    protected void printAdBreakStatus()
    {
        LogUtils.LOGD(TAG, (new StringBuilder()).append("VODMediaPlayer: isCurrentTimeInAdBreak: ").append(getCurrentPosition()).append(" inAd: ").append(inAd).toString());
        if (adCues != null)
        {
            AdBreak adbreak;
            for (Iterator iterator = adCues.iterator(); iterator.hasNext(); LogUtils.LOGD(TAG, (new StringBuilder()).append("VODMediaPlayer: AdBreak").append(adbreak.getNum()).append(" watched:").append(adbreak.isWatched()).append(" started:").append(adbreak.isAdEventStarted()).append(" start:").append(adbreak.getStart() * 1000F).append(" end:").append(adbreak.getEnd() * 1000F).toString()))
            {
                adbreak = (AdBreak)iterator.next();
            }

        }
    }

    public void reset()
    {
        super.reset();
        switch (_cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            omnitureTagFiredForWatchedPercentage = 0;
            break;
        }
    }

    protected void resetCurrentAd()
    {
        currentAdTotal = 0;
        currentAdIndex = 0;
        currentAd = null;
        currentAdGroup = null;
    }

    public void seekTo(int i)
        throws IllegalStateException
    {
        _cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 33
    //                   2 339;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (uplynkMediaPlayer == null || !canSeek())
        {
            continue; /* Loop/switch isn't completed */
        }
        int k = i;
        LogUtils.LOGD(TAG, (new StringBuilder()).append("VODMediaPlayer: seekTo: ").append(k).toString());
        Object obj = getAdBreakBeforeTime(k);
        int j;
        if (obj != null && !((AdBreak) (obj)).isWatched())
        {
            if (timeToSeekToAfterUnlockingAdBreak < 0)
            {
                timeToSeekToAfterUnlockingAdBreak = k;
            }
            float f = (float)Math.floor(((AdBreak) (obj)).getStart() * 1000F);
            j = k;
            if (f < (float)i)
            {
                j = (int)f;
                seekAllowed = false;
            }
        } else
        {
            j = k;
            if (obj != null)
            {
                j = k;
                if (((AdBreak) (obj)).isWatched())
                {
                    float f1 = (float)Math.ceil(((AdBreak) (obj)).getEnd() * 1000F);
                    j = k;
                    if ((float)k < f1)
                    {
                        j = (int)f1;
                    }
                }
            }
        }
        LogUtils.LOGD(TAG, (new StringBuilder()).append("VODMediaPlayer: uplynkMediaPlayerSeekTo: ").append(j).toString());
        uplynkMediaPlayer.seekTo(j);
        if (pingUplynk == null) goto _L1; else goto _L4
_L4:
        try
        {
            nextPingTime = ((Integer)pingUplynk.ping(j / 1000, "seek").get(5L, TimeUnit.SECONDS)).intValue();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            LogUtils.LOGE(TAG, ((InterruptedException) (obj)).getMessage());
            return;
        }
        catch (ExecutionException executionexception)
        {
            LogUtils.LOGE(TAG, executionexception.getMessage());
            return;
        }
        catch (TimeoutException timeoutexception)
        {
            LogUtils.LOGE(TAG, timeoutexception.getMessage());
        }
        return;
        if (getOnInfoListener() == null) goto _L1; else goto _L5
_L5:
        getOnInfoListener().onInfo(this, 801, ErrorCode.ANDROID_SEEK_DISABLED.getErrorCode());
        return;
_L3:
        super.seekTo(i);
        return;
    }

    protected void sendAdInfoCurrentAdBreak(int i)
    {
        Iterator iterator;
        if (currentAdBreak == null)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        iterator = currentAdBreak.getAdgroup().iterator();
_L2:
        Ads ads;
        Iterator iterator1;
        int j;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_218;
        }
        ads = (Ads)iterator.next();
        j = currentAdBreak.getAdgroup().indexOf(ads);
        iterator1 = ads.getAd().iterator();
_L4:
        if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
        float f;
        float f1;
        AdAsset adasset;
        adasset = (AdAsset)iterator1.next();
        f = (float)Math.floor(adasset.getStart() * 1000F);
        f1 = (float)Math.floor(adasset.getEnd() * 1000F);
        if ((float)i < f || (float)i > f1) goto _L4; else goto _L3
_L3:
        currentAdGroup = ads;
        if (currentAdBreak.getAdgroup().size() != currentAdTotal || j + 1 != currentAdIndex)
        {
            if (currentAdTotal != 0 && currentAdIndex != 0 && currentAd != null)
            {
                leftAd();
            }
            currentAdTotal = currentAdBreak.getAdgroup().size();
            currentAdIndex = j + 1;
            enteredAd(adasset);
        }
    }

    public Future setDataSource(VPMedia vpmedia, AsyncHandler asynchandler)
        throws IllegalArgumentException, IllegalStateException
    {
        if (vpmedia == null)
        {
            throw new IllegalArgumentException(new AndroidSDKException(ErrorCode.ANDROID_INVALID_MEDIA_EXCEPTION, "valid Media object must be set"));
        }
        if (vpmedia.getMediaType() != VPMedia.MediaType.VOD)
        {
            throw new IllegalArgumentException(new AndroidSDKException(ErrorCode.ANDROID_MEDIA_INITIALIZED_ON_WRONG_PLAYER_TYPE_EXCEPTION, "Media must be a VOD type"));
        } else
        {
            return super.setDataSource(vpmedia, asynchandler);
        }
    }

    public void setDataSource(String s)
        throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
    {
        super.setDataSource(s);
        configurePlayManifest(getCurrentMedia());
    }

    public void setLooping(boolean flag)
    {
        switch (_cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            loop = flag;
            return;

        case 2: // '\002'
            super.setLooping(flag);
            break;
        }
    }

    public void setPlayManifest(PlayManifest playmanifest)
    {
        playManifest = playmanifest;
    }

    public void start()
        throws IllegalStateException
    {
        super.start();
        switch (_cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            startProgressionTimer();
            break;
        }
    }

    public void stop()
    {
        super.stop();
        switch (_cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            stopProgressionTimer();
            break;
        }
    }





/*
    static int access$102(VODMediaPlayer vodmediaplayer, int i)
    {
        vodmediaplayer.omnitureTagFiredForWatchedPercentage = i;
        return i;
    }

*/
}
