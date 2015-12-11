// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.sources;

import android.util.Log;
import com.rdio.android.audioplayer.extractors.MediaTypeUtil;
import com.rdio.android.audioplayer.interfaces.AudioError;
import com.rdio.android.audioplayer.io.AudioStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.rdio.android.audioplayer.sources:
//            MediaSource, UriMediaSource, MediaSourceCallbacks

public abstract class RdioMediaSource
    implements MediaSource
{
    public static class PlaybackInfo
    {

        public byte encryptedPlaybackKey[];
        public com.rdio.android.audioplayer.interfaces.AudioError.ErrorType error;
        public boolean isManualPlay;
        public boolean isOfflineStreamable;
        public long playbackKeyVerison;
        public boolean shouldGetAd;
        public String streamType;
        public long trackDuration;
        public String trackKey;
        public String uri;

        public PlaybackInfo()
        {
        }
    }

    public static class PlaybackInfoRequestArgs
    {

        public String deviceId;
        public boolean encrypted;
        public boolean manualPlay;
        public String parentKey;
        public String playerName;
        public String streamQuality;
        public String trackKey;

        public PlaybackInfoRequestArgs()
        {
        }
    }

    protected static class RdioMediaSourceAudioError
        implements AudioError
    {

        private final String description;
        private final com.rdio.android.audioplayer.interfaces.AudioError.ErrorType type;

        public String getDescription()
        {
            return description;
        }

        public com.rdio.android.audioplayer.interfaces.AudioError.ErrorType getType()
        {
            return type;
        }

        public boolean shouldStopPlayback()
        {
            return true;
        }

        public RdioMediaSourceAudioError(String s, com.rdio.android.audioplayer.interfaces.AudioError.ErrorType errortype)
        {
            description = s;
            type = errortype;
        }
    }


    private static final int MAX_RETRY_ATTEMPTS = 5;
    private static final int RECOVERY_BACK_BUFFER_SIZE = 1024;
    private static final int RECOVERY_RETRY_INTERVALS[] = {
        100, 500, 1000, 2000, 4000
    };
    private static final int STREAM_RESTART_TIMEOUT = 5000;
    private static final String TAG = "RdioMediaSource";
    private final int bufferSize;
    private final List callbacksList = Collections.synchronizedList(new ArrayList());
    private boolean isCancelled;
    private boolean isInRecovery;
    private boolean isReadyToStream;
    private boolean isStarted;
    private UriMediaSource mediaSource;
    private final MediaSourceCallbacks mediaSourceListener = new MediaSourceCallbacks() ;
    private final Object readyToStreamMonitor = new Object();
    private UriMediaSource recoveredMediaSource;
    private final MediaSourceCallbacks recoveryMediaSourceListener = new MediaSourceCallbacks() {

        final RdioMediaSource this$0;

        public void onError(MediaSource mediasource, AudioError audioerror)
        {
        }

        public void onProgress(MediaSource mediasource)
        {
        }

        public void onReady(MediaSource mediasource)
        {
        }

        public void shouldGetAd(MediaSource mediasource)
        {
        }

            
            {
                this$0 = RdioMediaSource.this;
                super();
            }
    };
    private final Runnable recoveryRunnable = new Runnable() {

        final RdioMediaSource this$0;

        public void run()
        {
            onPrepareUri();
        }

            
            {
                this$0 = RdioMediaSource.this;
                super();
            }
    };
    private long recoveryStreamStartByteOffset;
    private int retryAttempts;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private long streamStartByteOffset;

    public RdioMediaSource(int i)
    {
        bufferSize = i;
        createInternalMediaSource();
    }

    private void createInternalMediaSource()
    {
        if (mediaSource != null)
        {
            mediaSource.removeCallbacksListener(mediaSourceListener);
        }
        mediaSource = new UriMediaSource(bufferSize);
        mediaSource.addCallbacksListener(mediaSourceListener);
    }

    private void createRecoveryMediaSource()
    {
        if (recoveredMediaSource != null)
        {
            recoveredMediaSource.removeCallbacksListener(recoveryMediaSourceListener);
            recoveredMediaSource.destroy();
        }
        recoveredMediaSource = new UriMediaSource(bufferSize);
        recoveredMediaSource.addCallbacksListener(recoveryMediaSourceListener);
    }

    private RdioMediaSourceAudioError getError(String s, com.rdio.android.audioplayer.interfaces.AudioError.ErrorType errortype)
    {
        return new RdioMediaSourceAudioError(s, errortype);
    }

    private void raiseOnProgress()
    {
        if (isInRecovery)
        {
            return;
        }
        List list = callbacksList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = callbacksList.iterator(); iterator.hasNext(); ((MediaSourceCallbacks)iterator.next()).onProgress(this)) { }
        break MISSING_BLOCK_LABEL_57;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    private void raiseOnReady()
    {
        if (isInRecovery)
        {
            return;
        }
        List list = callbacksList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = callbacksList.iterator(); iterator.hasNext(); ((MediaSourceCallbacks)iterator.next()).onReady(this)) { }
        break MISSING_BLOCK_LABEL_57;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    private void recover()
    {
        if (retryAttempts < 5 && !isInRecovery)
        {
            Log.e("RdioMediaSource", "Stream has stalled, attempting to recover");
            retryAttempts = retryAttempts + 1;
            isInRecovery = true;
            scheduler.schedule(recoveryRunnable, RECOVERY_RETRY_INTERVALS[retryAttempts - 1], TimeUnit.MILLISECONDS);
            return;
        } else
        {
            Log.e("RdioMediaSource", (new StringBuilder("Stream has failed ")).append(retryAttempts).append(" times. Giving up.").toString());
            return;
        }
    }

    private void restart()
    {
        Object obj;
        if (recoveredMediaSource != null)
        {
            isInRecovery = false;
            recoveredMediaSource.removeCallbacksListener(recoveryMediaSourceListener);
            recoveredMediaSource.destroy();
            recoveredMediaSource = null;
        }
        mediaSource.getAudioStream().cancel();
        Object obj1;
        boolean flag;
        try
        {
            createInternalMediaSource();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            raiseOnError(getError((new StringBuilder("Failed to create internal media source: ")).append(((IOException) (obj)).getMessage()).toString(), com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.Network));
            return;
        }
        isReadyToStream = false;
        onPrepareUri();
        obj = readyToStreamMonitor;
        obj;
        JVM INSTR monitorenter ;
_L1:
        flag = isReadyToStream;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        readyToStreamMonitor.wait(5000L);
          goto _L1
        obj1;
        ((InterruptedException) (obj1)).printStackTrace();
        raiseOnError(getError("Stream restart timed out.", com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.Network));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj;
        JVM INSTR monitorexit ;
    }

    private void switchToRecoveredMediaSource(long l)
    {
        if (recoveredMediaSource != null && mediaSource.getCurrDataSize() < l)
        {
            l = mediaSource.getStreamPosition() - recoveredMediaSource.getStreamPosition();
            (new StringBuilder("Skipping: ")).append(l).append(" bytes into recovery stream to fill frame.");
            try
            {
                recoveredMediaSource.seekBytes(l, MediaSource.SeekOrigin.Current);
            }
            catch (IOException ioexception)
            {
                Log.e("RdioMediaSource", "Failed to reposition recovered source!", ioexception);
                return;
            }
            recoveredMediaSource.removeCallbacksListener(recoveryMediaSourceListener);
            mediaSource = recoveredMediaSource;
            mediaSource.addCallbacksListener(mediaSourceListener);
            recoveredMediaSource = null;
        }
    }

    public void addCallbacksListener(MediaSourceCallbacks mediasourcecallbacks)
    {
        synchronized (callbacksList)
        {
            callbacksList.add(mediasourcecallbacks);
        }
        return;
        mediasourcecallbacks;
        list;
        JVM INSTR monitorexit ;
        throw mediasourcecallbacks;
    }

    public com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType blockingGetMediaType()
    {
        Object obj = readyToStreamMonitor;
        obj;
        JVM INSTR monitorenter ;
_L1:
        boolean flag;
        if (isReadyToStream)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        flag = isCancelled;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        readyToStreamMonitor.wait(10000L);
          goto _L1
        Object obj1;
        obj1;
        com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType mediatype = com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType.Unknown;
        obj;
        JVM INSTR monitorexit ;
        return mediatype;
        mediatype = mediaSource.getMediaType();
        obj;
        JVM INSTR monitorexit ;
        return mediatype;
        mediatype;
        obj;
        JVM INSTR monitorexit ;
        throw mediatype;
    }

    public void cancelWait()
    {
        mediaSource.cancelWait();
        synchronized (readyToStreamMonitor)
        {
            isCancelled = true;
            readyToStreamMonitor.notifyAll();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void destroy()
    {
        if (recoveredMediaSource != null)
        {
            recoveredMediaSource.removeCallbacksListener(recoveryMediaSourceListener);
            recoveredMediaSource.destroy();
            recoveredMediaSource = null;
        }
        if (isValid())
        {
            mediaSource.destroy();
            synchronized (callbacksList)
            {
                callbacksList.clear();
            }
            setIsInUse(false);
        }
        return;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getBitRate()
    {
        return mediaSource.getBitRate();
    }

    public int getBufferedPercent()
    {
        return mediaSource.getBufferedPercent();
    }

    public long getBytesBuffered()
    {
        return mediaSource.getBytesBuffered();
    }

    public long getBytesRead()
    {
        return mediaSource.getBytesRead();
    }

    public long getCurrDataSize()
    {
        return mediaSource.getCurrDataSize();
    }

    public double getDuration()
    {
        return mediaSource.getDuration();
    }

    public com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType getMediaType()
    {
        return mediaSource.getMediaType();
    }

    public boolean getWaitForStreamLoad()
    {
        return mediaSource.getWaitForStreamLoad();
    }

    public boolean hasStream(AudioStream audiostream)
    {
        return audiostream == mediaSource.getAudioStream();
    }

    public boolean isFullyConsumed()
    {
        return mediaSource.isFullyConsumed();
    }

    public boolean isInUse()
    {
        return mediaSource.isInUse();
    }

    public boolean isValid()
    {
        return mediaSource.isValid();
    }

    public boolean isWaitingForStreamToLoad()
    {
        return mediaSource.isWaitingForStreamToLoad();
    }

    public abstract void onPrepareUri();

    public void onUriPrepared(String s, String s1, long l)
    {
        onUriPrepared(s, s1, l, null);
    }

    protected void onUriPrepared(String s, String s1, long l, com.rdio.android.audioplayer.io.UriAudioStream.StreamWrapper streamwrapper)
    {
        if (isCancelled)
        {
            return;
        }
        if (isInRecovery)
        {
            isInRecovery = false;
            try
            {
                createRecoveryMediaSource();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("RdioMediaSource", (new StringBuilder("Failed to create recovery source! ")).append(s.getMessage()).toString(), s);
                return;
            }
            recoveredMediaSource.start(s, streamwrapper, recoveryStreamStartByteOffset);
            recoveryStreamStartByteOffset = 0L;
            retryAttempts = 0;
            return;
        }
        mediaSource.start(s, streamwrapper, streamStartByteOffset);
        streamStartByteOffset = 0L;
        updateMediaInfo(MediaTypeUtil.fromServerString(s1), 0, l);
        synchronized (readyToStreamMonitor)
        {
            isReadyToStream = true;
            readyToStreamMonitor.notifyAll();
        }
        return;
        s1;
        s;
        JVM INSTR monitorexit ;
        throw s1;
    }

    protected void raiseOnError(AudioError audioerror)
    {
        if (isInRecovery)
        {
            isInRecovery = false;
            Log.e("RdioMediaSource", "Recovery attempt failed!");
            recover();
            return;
        }
        List list = callbacksList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = callbacksList.iterator(); iterator.hasNext(); ((MediaSourceCallbacks)iterator.next()).onError(this, audioerror)) { }
        break MISSING_BLOCK_LABEL_76;
        audioerror;
        list;
        JVM INSTR monitorexit ;
        throw audioerror;
        list;
        JVM INSTR monitorexit ;
    }

    protected void raiseShouldGetAd()
    {
        if (isInRecovery)
        {
            return;
        }
        List list = callbacksList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = callbacksList.iterator(); iterator.hasNext(); ((MediaSourceCallbacks)iterator.next()).shouldGetAd(this)) { }
        break MISSING_BLOCK_LABEL_57;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    public byte readByte()
    {
        return mediaSource.readByte();
    }

    public int readByteAsInt()
    {
        return mediaSource.readByteAsInt();
    }

    public int readBytes(byte abyte0[], int i, int j)
    {
        return mediaSource.readBytes(abyte0, i, j);
    }

    public long readLong()
    {
        return mediaSource.readLong();
    }

    public String readString(int i)
    {
        return mediaSource.readString(i);
    }

    public long readUInt()
    {
        return mediaSource.readUInt();
    }

    public long readUInt(int i)
    {
        return mediaSource.readUInt(i);
    }

    public int readUShort()
    {
        return mediaSource.readUShort();
    }

    public void removeCallbacksListener(MediaSourceCallbacks mediasourcecallbacks)
    {
        synchronized (callbacksList)
        {
            callbacksList.remove(mediasourcecallbacks);
        }
        return;
        mediasourcecallbacks;
        list;
        JVM INSTR monitorexit ;
        throw mediasourcecallbacks;
    }

    public int seek(int i, MediaSource.SeekOrigin seekorigin)
    {
        return mediaSource.seek(i, seekorigin);
    }

    public long seekBytes(long l, MediaSource.SeekOrigin seekorigin)
    {
        boolean flag;
        if (!mediaSource.getAudioStream().reverseSeekingSupported() && mediaSource.getAudioStream().isSeekReverse(l, seekorigin) || mediaSource.getAudioStream().isSeekBeyondBuffer(l, seekorigin))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            streamStartByteOffset = l;
            restart();
            return l;
        } else
        {
            return mediaSource.seekBytes(l, seekorigin);
        }
    }

    public void setIsInUse(boolean flag)
    {
        mediaSource.setIsInUse(flag);
    }

    public void setWaitForStreamLoad(boolean flag)
    {
        mediaSource.setWaitForStreamLoad(flag);
    }

    public void start()
    {
        if (isStarted)
        {
            return;
        } else
        {
            isStarted = true;
            onPrepareUri();
            return;
        }
    }

    public void updateMediaBitrate(int i)
    {
        mediaSource.updateMediaBitrate(i);
    }

    public void updateMediaDuration(long l)
    {
        mediaSource.updateMediaDuration(l);
    }

    public void updateMediaInfo(com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType mediatype, int i, long l)
    {
        mediaSource.updateMediaInfo(mediatype, i, l);
    }

    public void updateMediaType(com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType mediatype)
    {
        mediaSource.updateMediaType(mediatype);
    }

    public MediaSource.WaitStatus waitForData(long l, int i)
    {
        switchToRecoveredMediaSource(l);
        return mediaSource.waitForData(l, i);
    }

    public MediaSource.WaitStatus waitForData(long l, long l1, int i, int j)
    {
        switchToRecoveredMediaSource(l1);
        return mediaSource.waitForData(l, l1, i, j);
    }






/*
    static long access$302(RdioMediaSource rdiomediasource, long l)
    {
        rdiomediasource.recoveryStreamStartByteOffset = l;
        return l;
    }

*/


/*
    static long access$322(RdioMediaSource rdiomediasource, long l)
    {
        l = rdiomediasource.recoveryStreamStartByteOffset - l;
        rdiomediasource.recoveryStreamStartByteOffset = l;
        return l;
    }

*/

}
