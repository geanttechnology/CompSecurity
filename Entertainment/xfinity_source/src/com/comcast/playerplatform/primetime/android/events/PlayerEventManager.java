// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.events;

import com.adobe.ave.drm.DRMManager;
import com.adobe.ave.drm.DRMMetadata;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.comcast.playerplatform.primetime.android.events:
//            AbstractPlayerPlatformVideoEventListener

public class PlayerEventManager extends AbstractPlayerPlatformVideoEventListener
{

    List listeners;

    public PlayerEventManager()
    {
        listeners = new CopyOnWriteArrayList();
    }

    public void acquiringLicense(final String asset)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final String val$asset;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).acquiringLicense(asset)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                asset = s;
                super();
            }
        });
    }

    public void adBreakComplete(final VideoAdBreak adBreak)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final VideoAdBreak val$adBreak;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).adBreakComplete(adBreak)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                adBreak = videoadbreak;
                super();
            }
        });
    }

    public void adBreakExited(final VideoAdBreak adBreak)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final VideoAdBreak val$adBreak;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).adBreakExited(adBreak)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                adBreak = videoadbreak;
                super();
            }
        });
    }

    public void adBreakStart(final VideoAdBreak adBreak, final VideoAd ad)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final VideoAd val$ad;
            final VideoAdBreak val$adBreak;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).adBreakStart(adBreak, ad)) { }
                break MISSING_BLOCK_LABEL_60;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                adBreak = videoadbreak;
                ad = videoad;
                super();
            }
        });
    }

    public void adComplete(final String id)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final String val$id;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).adComplete(id)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                id = s;
                super();
            }
        });
    }

    public void adExited(final String id)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final String val$id;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).adExited(id)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                id = s;
                super();
            }
        });
    }

    public void adProgress(final VideoAdBreak adBreak, final VideoAd ad, final int progress, final long timeRemaining)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final VideoAd val$ad;
            final VideoAdBreak val$adBreak;
            final int val$progress;
            final long val$timeRemaining;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).adProgress(adBreak, ad, progress, timeRemaining)) { }
                break MISSING_BLOCK_LABEL_68;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                adBreak = videoadbreak;
                ad = videoad;
                progress = i;
                timeRemaining = l;
                super();
            }
        });
    }

    public void adStart(final VideoAd ad)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final VideoAd val$ad;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).adStart(ad)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                ad = videoad;
                super();
            }
        });
    }

    public void addListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        this;
        JVM INSTR monitorenter ;
        listeners.add(abstractplayerplatformvideoeventlistener);
        this;
        JVM INSTR monitorexit ;
        return;
        abstractplayerplatformvideoeventlistener;
        throw abstractplayerplatformvideoeventlistener;
    }

    public void bitrateChanged(final long bitrate, final String changeReason, final long videoHeight, final long videoWidth)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final long val$bitrate;
            final String val$changeReason;
            final long val$videoHeight;
            final long val$videoWidth;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).bitrateChanged(bitrate, changeReason, videoHeight, videoWidth)) { }
                break MISSING_BLOCK_LABEL_68;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                bitrate = l;
                changeReason = s;
                videoHeight = l1;
                videoWidth = l2;
                super();
            }
        });
    }

    public void clearListeners()
    {
        this;
        JVM INSTR monitorenter ;
        listeners.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void drmComplete(final String asset, final Date licenseStart, final Date licenseEnd)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final String val$asset;
            final Date val$licenseEnd;
            final Date val$licenseStart;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).drmComplete(asset, licenseStart, licenseEnd)) { }
                break MISSING_BLOCK_LABEL_64;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                asset = s;
                licenseStart = date;
                licenseEnd = date1;
                super();
            }
        });
    }

    public void drmFailure(final String code, final String description, final String messageId, final Exception e)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final String val$code;
            final String val$description;
            final Exception val$e;
            final String val$messageId;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).drmFailure(code, description, messageId, e)) { }
                break MISSING_BLOCK_LABEL_68;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                code = s;
                description = s1;
                messageId = s2;
                e = exception;
                super();
            }
        });
    }

    public void drmMetaDataAvailable(final DRMManager drmManager, final DRMMetadata drmMetadata)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final DRMManager val$drmManager;
            final DRMMetadata val$drmMetadata;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).drmMetaDataAvailable(drmManager, drmMetadata)) { }
                break MISSING_BLOCK_LABEL_60;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                drmManager = drmmanager;
                drmMetadata = drmmetadata;
                super();
            }
        });
    }

    public void droppedFPSChanged(final long droppedFPS)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final long val$droppedFPS;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).droppedFPSChanged(droppedFPS)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                droppedFPS = l;
                super();
            }
        });
    }

    public void durationChanged(final long duration)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final long val$duration;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).durationChanged(duration)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                duration = l;
                super();
            }
        });
    }

    public void emergencyAlertCompleted(final String identifier)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final String val$identifier;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).emergencyAlertCompleted(identifier)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                identifier = s;
                super();
            }
        });
    }

    public void emergencyAlertFailed(final String errorCode, final String description)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final String val$description;
            final String val$errorCode;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).emergencyAlertFailed(errorCode, description)) { }
                break MISSING_BLOCK_LABEL_60;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                errorCode = s;
                description = s1;
                super();
            }
        });
    }

    public void emergencyAlertStarted(final String identifier)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final String val$identifier;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).emergencyAlertStarted(identifier)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                identifier = s;
                super();
            }
        });
    }

    public void fpsChanged(final long FPS)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final long val$FPS;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).fpsChanged(FPS)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                FPS = l;
                super();
            }
        });
    }

    public void fragmentWarning(final long downloadDuration, final long fragmentDuration, final long fragmentSize, final String url)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final long val$downloadDuration;
            final long val$fragmentDuration;
            final long val$fragmentSize;
            final String val$url;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).fragmentWarning(downloadDuration, fragmentDuration, fragmentSize, url)) { }
                break MISSING_BLOCK_LABEL_68;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                downloadDuration = l;
                fragmentDuration = l1;
                fragmentSize = l2;
                url = s;
                super();
            }
        });
    }

    public void mediaEnded()
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).mediaEnded()) { }
                break MISSING_BLOCK_LABEL_52;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                super();
            }
        });
    }

    public void mediaFailed(final String code, final String description)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final String val$code;
            final String val$description;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).mediaFailed(code, description)) { }
                break MISSING_BLOCK_LABEL_60;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                code = s;
                description = s1;
                super();
            }
        });
    }

    public void mediaOpened(final String type, final String mediaType, final List playbackSpeeds, final List availableAudioLanguages, final List availableClosedCaptionTracks, final long width, 
            final long height, final long duration, final double openingLatency, final boolean hasCC)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final List val$availableAudioLanguages;
            final List val$availableClosedCaptionTracks;
            final long val$duration;
            final boolean val$hasCC;
            final long val$height;
            final String val$mediaType;
            final double val$openingLatency;
            final List val$playbackSpeeds;
            final String val$type;
            final long val$width;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).mediaOpened(type, mediaType, playbackSpeeds, availableAudioLanguages, availableClosedCaptionTracks, width, height, duration, openingLatency, hasCC)) { }
                break MISSING_BLOCK_LABEL_92;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                type = s;
                mediaType = s1;
                playbackSpeeds = list;
                availableAudioLanguages = list1;
                availableClosedCaptionTracks = list2;
                width = l;
                height = l1;
                duration = l2;
                openingLatency = d;
                hasCC = flag;
                super();
            }
        });
    }

    public void mediaProgress(final long position, final double playbackSpeed, final long startPosition, final long endPosition, final int updateInterval)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final long val$endPosition;
            final double val$playbackSpeed;
            final long val$position;
            final long val$startPosition;
            final int val$updateInterval;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).mediaProgress(position, playbackSpeed, startPosition, endPosition, updateInterval)) { }
                break MISSING_BLOCK_LABEL_72;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                position = l;
                playbackSpeed = d;
                startPosition = l1;
                endPosition = l2;
                updateInterval = i;
                super();
            }
        });
    }

    public void mediaWarning(final String code, final String description)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final String val$code;
            final String val$description;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).mediaWarning(code, description)) { }
                break MISSING_BLOCK_LABEL_60;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                code = s;
                description = s1;
                super();
            }
        });
    }

    public void numberOfAlternativeAudioStreamsChanged(final int numberOfAlternativeAudioStreams)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final int val$numberOfAlternativeAudioStreams;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).numberOfAlternativeAudioStreamsChanged(numberOfAlternativeAudioStreams)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                numberOfAlternativeAudioStreams = i;
                super();
            }
        });
    }

    public void offlineDRMComplete(final String asset, final Date licenseStart, final Date licenseEnd, final String policyId)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final String val$asset;
            final Date val$licenseEnd;
            final Date val$licenseStart;
            final String val$policyId;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).offlineDRMComplete(asset, licenseStart, licenseEnd, policyId)) { }
                break MISSING_BLOCK_LABEL_68;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                asset = s;
                licenseStart = date;
                licenseEnd = date1;
                policyId = s1;
                super();
            }
        });
    }

    public void offlineDRMFailure(final String code, final String description)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final String val$code;
            final String val$description;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).offlineDRMFailure(code, description)) { }
                break MISSING_BLOCK_LABEL_60;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                code = s;
                description = s1;
                super();
            }
        });
    }

    public void onBufferComplete()
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).onBufferComplete()) { }
                break MISSING_BLOCK_LABEL_52;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                super();
            }
        });
    }

    public void onBufferStart()
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).onBufferStart()) { }
                break MISSING_BLOCK_LABEL_52;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                super();
            }
        });
    }

    public void onPlayStarted()
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).onPlayStarted()) { }
                break MISSING_BLOCK_LABEL_52;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                super();
            }
        });
    }

    public void onSeekComplete(final long position)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final long val$position;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).onSeekComplete(position)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                position = l;
                super();
            }
        });
    }

    public void onSeekStart()
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).onSeekStart()) { }
                break MISSING_BLOCK_LABEL_52;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                super();
            }
        });
    }

    public void onTimelineUpdated()
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).onTimelineUpdated()) { }
                break MISSING_BLOCK_LABEL_52;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                super();
            }
        });
    }

    public void playStateChanged(final PlayerStatus status)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final PlayerStatus val$status;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).playStateChanged(status)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                status = playerstatus;
                super();
            }
        });
    }

    public void playbackSpeedChanged(final float speed)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final float val$speed;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).playbackSpeedChanged(speed)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                speed = f;
                super();
            }
        });
    }

    public void removeListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        this;
        JVM INSTR monitorenter ;
        listeners.remove(abstractplayerplatformvideoeventlistener);
        this;
        JVM INSTR monitorexit ;
        return;
        abstractplayerplatformvideoeventlistener;
        throw abstractplayerplatformvideoeventlistener;
    }

    public void retryAttempted(final String code, final String description, final int retryCount)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerEventManager this$0;
            final String val$code;
            final String val$description;
            final int val$retryCount;

            public void run()
            {
                List list = listeners;
                list;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).retryAttempted(code, description, retryCount)) { }
                break MISSING_BLOCK_LABEL_64;
                Exception exception;
                exception;
                list;
                JVM INSTR monitorexit ;
                throw exception;
                list;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = PlayerEventManager.this;
                code = s;
                description = s1;
                retryCount = i;
                super();
            }
        });
    }
}
