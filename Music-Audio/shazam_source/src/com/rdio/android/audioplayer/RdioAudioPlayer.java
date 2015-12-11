// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.rdio.android.audioplayer.extractors.AacExtractor;
import com.rdio.android.audioplayer.extractors.AndroidMediaFormat;
import com.rdio.android.audioplayer.extractors.MediaExtractor;
import com.rdio.android.audioplayer.extractors.Mp3Extractor;
import com.rdio.android.audioplayer.interfaces.AudioError;
import com.rdio.android.audioplayer.interfaces.AudioInfo;
import com.rdio.android.audioplayer.interfaces.AudioPlayer;
import com.rdio.android.audioplayer.interfaces.AudioPlayerListener;
import com.rdio.android.audioplayer.io.AndroidByteBuffer;
import com.rdio.android.audioplayer.io.AudioStream;
import com.rdio.android.audioplayer.sources.MediaSource;
import com.rdio.android.audioplayer.sources.MediaSourceCallbacks;
import com.rdio.android.audioplayer.util.DeviceHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class RdioAudioPlayer
    implements AudioPlayer
{
    private class AudioWriter
    {

        public static final int TRIM_ALL_SILENCE = 0x7fffffff;
        public static final int TRIM_NONE = 0;
        private final int DEFAULT_SAMPLE_SIZE = 4;
        private final String GAPLESS_TAG = "Gapless";
        private final int INVALID_INDEX = -1;
        private List bufferList;
        private int currIndex;
        private int firstIndex;
        private boolean isGapless;
        private int numBuffers;
        private int sampleSize;
        final RdioAudioPlayer this$0;
        private int totalPaddingBytesTrimmed;
        private int totalPrimingBytesTrimmed;
        private int trimPadding;
        private int trimPriming;

        public int getTotalPaddingBytesTrimmed()
        {
            return totalPaddingBytesTrimmed;
        }

        public int getTotalPrimingBytesTrimmed()
        {
            return totalPrimingBytesTrimmed;
        }

        public void setGaplessParameters(int i, int j)
        {
            setGaplessParameters(i, j, 4);
        }

        public void setGaplessParameters(int i, int j, int k)
        {
            trimPriming = i;
            trimPadding = j;
            sampleSize = k;
            boolean flag;
            if (trimPriming != 0 || trimPadding != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isGapless = flag;
            firstIndex = -1;
            currIndex = 0;
        }

        public void write(AndroidByteBuffer androidbytebuffer, int i, boolean flag)
        {
            WriteBuffer writebuffer;
            if (bufferList.size() <= currIndex)
            {
                writebuffer = new WriteBuffer(i);
                bufferList.add(writebuffer);
            } else
            {
                WriteBuffer writebuffer1 = (WriteBuffer)bufferList.get(currIndex);
                writebuffer = writebuffer1;
                if (writebuffer1.getCapacity() < i)
                {
                    writebuffer1.resize(i);
                    writebuffer = writebuffer1;
                }
            }
            writebuffer.get(androidbytebuffer, i);
            if (firstIndex == -1 && currIndex == numBuffers - 1)
            {
                firstIndex = 0;
            }
            androidbytebuffer = writebuffer;
            if (isGapless)
            {
                if (trimPriming > 0)
                {
                    int j = Math.min(trimPriming, writebuffer.getSize());
                    i = writebuffer.getSize();
                    j = writebuffer.trimPriming(j, sampleSize);
                    if (j != i || j == trimPriming)
                    {
                        trimPriming = 0;
                    } else
                    {
                        trimPriming = trimPriming - j;
                    }
                    totalPrimingBytesTrimmed = j + totalPrimingBytesTrimmed;
                }
                if (flag && trimPadding > 0)
                {
                    i = currIndex + 1;
                    do
                    {
                        i = ((i + numBuffers) - 1) % numBuffers;
                        androidbytebuffer = (WriteBuffer)bufferList.get(i);
                        j = androidbytebuffer.getSize();
                        int k = androidbytebuffer.trimPadding(trimPadding, sampleSize);
                        if (k != j || k == trimPadding)
                        {
                            trimPadding = 0;
                        } else
                        {
                            trimPadding = trimPadding - k;
                        }
                    } while (trimPadding != 0 && i != firstIndex);
                    totalPaddingBytesTrimmed = k + totalPaddingBytesTrimmed;
                }
                if (firstIndex != -1)
                {
                    androidbytebuffer = (WriteBuffer)bufferList.get(firstIndex);
                } else
                {
                    androidbytebuffer = null;
                }
            }
            if (androidbytebuffer != null && androidbytebuffer.getSize() > 0)
            {
                RdioAudioPlayer.this.write(androidbytebuffer.getData(), androidbytebuffer.getOffset(), androidbytebuffer.getSize());
            }
            if (firstIndex != -1)
            {
                i = firstIndex;
            } else
            {
                i = currIndex + 1;
            }
            currIndex = i;
            if (firstIndex != -1)
            {
                firstIndex = (firstIndex + 1) % numBuffers;
            }
            if (isGapless && flag)
            {
                if (firstIndex == -1)
                {
                    i = 0;
                } else
                {
                    i = firstIndex;
                }
                for (; i != currIndex; i = (i + 1) % numBuffers)
                {
                    androidbytebuffer = (WriteBuffer)bufferList.get(i);
                    if (androidbytebuffer.getSize() > 0)
                    {
                        RdioAudioPlayer.this.write(androidbytebuffer.getData(), androidbytebuffer.getOffset(), androidbytebuffer.getSize());
                    }
                }

                firstIndex = -1;
                currIndex = 0;
            }
        }

        public AudioWriter(int i)
        {
            this$0 = RdioAudioPlayer.this;
            super();
            numBuffers = i;
            bufferList = new ArrayList();
            setGaplessParameters(0, 0);
        }
    }

    public class AudioWriter.WriteBuffer
    {

        private byte data[];
        private int offset;
        private int size;
        final AudioWriter this$1;

        public void get(AndroidByteBuffer androidbytebuffer, int i)
        {
            androidbytebuffer.get(data, 0, i);
            offset = 0;
            size = i;
        }

        public int getCapacity()
        {
            if (getData() != null)
            {
                return getData().length;
            } else
            {
                return 0;
            }
        }

        public byte[] getData()
        {
            return data;
        }

        public int getOffset()
        {
            return offset;
        }

        public int getSize()
        {
            return size;
        }

        public void resize(int i)
        {
            data = new byte[i];
            offset = 0;
            size = 0;
        }

        public int trimPadding(int i, int j)
        {
            int l = (getOffset() + getSize()) - 1;
            int k;
            for (k = 0; k < i && l >= getOffset() && data[l] == 0; k++)
            {
                l--;
            }

            i = k - k % j;
            size = size - i;
            return i;
        }

        public int trimPriming(int i, int j)
        {
            for (int k = getCapacity(); getOffset() < i && getOffset() < k && getData()[getOffset()] == 0;)
            {
                offset = offset + 1;
            }

            offset = offset - offset % j;
            size = size - offset;
            return offset;
        }

        public AudioWriter.WriteBuffer(int i)
        {
            this$1 = AudioWriter.this;
            super();
            resize(i);
        }
    }

    private class PostStartDataSourceListener
        implements MediaSourceCallbacks
    {

        private boolean isRemovalPosted;
        final RdioAudioPlayer this$0;

        public void onError(MediaSource mediasource, AudioError audioerror)
        {
        }

        public void onProgress(MediaSource mediasource)
        {
            while (isRemovalPosted || mediasource == null || mediasource != getCurrentSource() || state != com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Prepared || mediasource.getBytesBuffered() <= 12000L) 
            {
                return;
            }
            isRemovalPosted = true;
            mainThread.post(removePostStartListener);
            try
            {
                performStart();
            }
            // Misplaced declaration of an exception variable
            catch (MediaSource mediasource)
            {
                Log.e("RdioAudioPlayer", "postStartDataSourceListener:Caught Exception when starting", mediasource);
            }
            onInfo(bufferingEnd);
        }

        public void onReady(MediaSource mediasource)
        {
        }

        public void reset()
        {
            isRemovalPosted = false;
        }

        public void shouldGetAd(MediaSource mediasource)
        {
        }

        private PostStartDataSourceListener()
        {
            this$0 = RdioAudioPlayer.this;
            super();
            isRemovalPosted = false;
        }

    }

    private static class RdioAudioError
        implements AudioError
    {

        private String description;
        private com.rdio.android.audioplayer.interfaces.AudioError.ErrorType info;
        private boolean shouldStopPlayback;

        public String getDescription()
        {
            return description;
        }

        public com.rdio.android.audioplayer.interfaces.AudioError.ErrorType getType()
        {
            return info;
        }

        public boolean shouldStopPlayback()
        {
            return shouldStopPlayback;
        }

        public RdioAudioError(Exception exception, com.rdio.android.audioplayer.interfaces.AudioError.ErrorType errortype, boolean flag)
        {
            description = exception.getMessage();
            info = errortype;
            shouldStopPlayback = flag;
        }

        public RdioAudioError(String s, com.rdio.android.audioplayer.interfaces.AudioError.ErrorType errortype, boolean flag)
        {
            description = s;
            info = errortype;
            shouldStopPlayback = flag;
        }
    }

    private static class RdioAudioInfo
        implements AudioInfo
    {

        private String description;
        private com.rdio.android.audioplayer.interfaces.AudioInfo.AudioInfoDetail detail;

        public String getDescription()
        {
            return description;
        }

        public com.rdio.android.audioplayer.interfaces.AudioInfo.AudioInfoDetail getDetail()
        {
            return detail;
        }

        public RdioAudioInfo(com.rdio.android.audioplayer.interfaces.AudioInfo.AudioInfoDetail audioinfodetail)
        {
            detail = audioinfodetail;
            description = String.format("RdioAudioInfo: Detail=%s", new Object[] {
                audioinfodetail.toString()
            });
        }
    }


    private static final String AAC_DECODER_DEFAULT_NAME = "aac-decoder";
    private static final double BYTES_PER_MSEC = 176.40000000000001D;
    private static final long DECODER_TIMEOUT_US = 20000L;
    private static final int GAPLESS_PADDING_LIMIT = 12000;
    private static final int INITIAL_BYTES_NEEDED = 12000;
    private static final int MAX_OUTPUT_RETRIES = 50;
    private static final String MP3_DECODER_DEFAULT_NAME = "mp3-decoder";
    private static final int NO_SEEK_REQUESTED = -1;
    private static final int SEEK_ONLINE_WAIT_LIMIT_MSEC = 7000;
    private static final String TAG = "RdioAudioPlayer";
    private static final int WAIT_FOR_DECODE_COMPLETE_TIMEOUT = 5000;
    private static final int WIFI_MP3_BITRATE = 192;
    private static boolean reinitDecoder;
    private MediaCodec aacDecoder;
    private MediaExtractor aacExtracor;
    private AudioPlayerListener audioPlayerListener;
    private Thread audioProcessingThread;
    private final RdioAudioInfo audioStart;
    private android.media.MediaCodec.BufferInfo bufferInfo;
    private final RdioAudioInfo bufferingEnd;
    private final RdioAudioInfo bufferingStart;
    private boolean configureDecoder;
    private volatile boolean continueProcessing;
    protected int currTrackOffsetMsec;
    private MediaSource currentSource;
    private final MediaSourceCallbacks dataSourceErrorListener = new MediaSourceCallbacks() {

        final RdioAudioPlayer this$0;

        public void onError(MediaSource mediasource, AudioError audioerror)
        {
            if (mediasource == null || mediasource != getCurrentSource())
            {
                Log.e("RdioAudioPlayer", "Source raised an error, but is not the current source");
                return;
            } else
            {
                RdioAudioPlayer.this.onError(new RdioAudioError(audioerror.getDescription(), audioerror.getType(), audioerror.shouldStopPlayback()));
                return;
            }
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
                this$0 = RdioAudioPlayer.this;
                super();
            }
    };
    private final Condition doneProcessing;
    private boolean isAudioDecodeComplete;
    private boolean isPlaying;
    protected int lastSeekOffsetMsec;
    public AudioPlayerListener listener;
    private final Handler mainThread = new Handler(Looper.getMainLooper());
    private MediaCodec mediaDecoder;
    private String mediaDecoderName;
    private MediaExtractor mediaExtractor;
    private MediaCodec mp3Decoder;
    private MediaExtractor mp3Extractor;
    private MediaSource nextSource;
    private com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlaybackMode playbackMode;
    private final PostStartDataSourceListener postStartDataSourceListener = new PostStartDataSourceListener();
    private final Lock reentrantLock = new ReentrantLock();
    private final Runnable removePostStartListener = new Runnable() {

        final RdioAudioPlayer this$0;

        public void run()
        {
            if (getCurrentSource() != null)
            {
                getCurrentSource().removeCallbacksListener(postStartDataSourceListener);
            }
        }

            
            {
                this$0 = RdioAudioPlayer.this;
                super();
            }
    };
    private final Object resourceMutexLock = new Object();
    private volatile int seekRequestedMsec;
    private final Condition seekingOnlineCondition;
    private com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState state;
    private String streamQuality;
    private final Object threadMutexLock = new Object();

    protected RdioAudioPlayer()
    {
        isAudioDecodeComplete = false;
        bufferingStart = new RdioAudioInfo(com.rdio.android.audioplayer.interfaces.AudioInfo.AudioInfoDetail.BufferingStart);
        audioStart = new RdioAudioInfo(com.rdio.android.audioplayer.interfaces.AudioInfo.AudioInfoDetail.AudioStart);
        bufferingEnd = new RdioAudioInfo(com.rdio.android.audioplayer.interfaces.AudioInfo.AudioInfoDetail.BufferingEnd);
        seekingOnlineCondition = reentrantLock.newCondition();
        doneProcessing = reentrantLock.newCondition();
        mp3Extractor = new Mp3Extractor();
        aacExtracor = new AacExtractor();
        mediaExtractor = null;
        com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState audioplayerstate;
        if (initializeMediaDecoder())
        {
            audioplayerstate = com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Reset;
        } else
        {
            audioplayerstate = com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Uninitialized;
        }
        state = audioplayerstate;
    }

    private boolean checkState(com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState audioplayerstate)
    {
        if (getState() != audioplayerstate)
        {
            onError(new RdioAudioError((new StringBuilder("Invalid audio state expected: ")).append(audioplayerstate).append(" was: ").append(state).toString(), com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.AudioError, false));
            return false;
        } else
        {
            return true;
        }
    }

    private boolean checkStates(com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState aaudioplayerstate[])
    {
        int k = aaudioplayerstate.length;
        for (int i = 0; i < k; i++)
        {
            if (aaudioplayerstate[i] == getState())
            {
                return true;
            }
        }

        StringBuilder stringbuilder = new StringBuilder("[ ");
        k = aaudioplayerstate.length;
        for (int j = 0; j < k; j++)
        {
            stringbuilder.append(aaudioplayerstate[j]);
            stringbuilder.append(" ");
        }

        stringbuilder.append("]");
        onError(new RdioAudioError((new StringBuilder("Invalid audio state expected: ")).append(stringbuilder.toString()).append(" was: ").append(state).toString(), com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.AudioError, false));
        return false;
    }

    private boolean configureMediaDecoder(com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType mediatype)
    {
        if (reinitDecoder)
        {
            releaseMediaDecoder();
            if (!initializeMediaDecoder())
            {
                return false;
            }
        }
        AndroidMediaFormat androidmediaformat;
        if (mediatype == com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType.AAC)
        {
            mediaDecoder = aacDecoder;
        } else
        {
            mediaDecoder = mp3Decoder;
        }
        androidmediaformat = new AndroidMediaFormat();
        if (!mediaExtractor.getTrackFormat(0, androidmediaformat))
        {
            Log.e("RdioAudioPlayer", "Unable to retrieve MediaFormat from MediaExtractor");
            return false;
        }
        try
        {
            (new StringBuilder("Configuring ")).append(mediatype).append(" decoder...");
            mediaDecoder.configure(androidmediaformat.getMediaFormat(), null, null, 0);
        }
        // Misplaced declaration of an exception variable
        catch (com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType mediatype)
        {
            Log.e("RdioAudioPlayer", "MediaDecoder threw exception, trying to reconfigure...", mediatype);
            if (initializeMediaDecoder())
            {
                mediaDecoder.configure(androidmediaformat.getMediaFormat(), null, null, 0);
            } else
            {
                Log.e("RdioAudioPlayer", "Failed to reconfigure decoder!");
                return false;
            }
        }
        configureDecoder = false;
        return true;
    }

    private boolean inGaplessPlaybackMode()
    {
        return getPlaybackMode() == com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlaybackMode.Gapless;
    }

    private boolean initializeMediaDecoder()
    {
        bufferInfo = new android.media.MediaCodec.BufferInfo();
        mp3Decoder = MediaCodec.createDecoderByType("audio/mpeg");
        aacDecoder = MediaCodec.createDecoderByType("audio/mp4a-latm");
        if (mp3Decoder == null || aacDecoder == null)
        {
            Log.e("RdioAudioPlayer", (new StringBuilder("Initialization failed! mp3 = ")).append(mp3Decoder).append(", aac = ").append(aacDecoder).toString());
        }
        return mp3Decoder != null && aacDecoder != null;
    }

    private void initializeMediaExtractor(MediaSource mediasource, com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType mediatype, boolean flag)
    {
        if (mediatype == com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType.AAC)
        {
            mediatype = aacExtracor;
        } else
        {
            mediatype = mp3Extractor;
        }
        mediaExtractor = mediatype;
        mediaExtractor.setDataSource(mediasource);
        configureDecoder = flag;
    }

    private void onAudioDecodeCompleted()
    {
        if (inGaplessPlaybackMode())
        {
            getNextSource();
        }
        reentrantLock.lock();
        isAudioDecodeComplete = true;
        doneProcessing.signalAll();
        reentrantLock.unlock();
    }

    private void onAudioExtractCompleted()
    {
    }

    private void onProcessAudioCompleted()
    {
    }

    private void onWaitForStreamProgressBegin(AudioStream audiostream)
    {
        if (isPlaying())
        {
            internalPauseAudio();
        }
        onInfo(bufferingStart);
    }

    private void onWaitForStreamProgressEnd(AudioStream audiostream, com.rdio.android.audioplayer.sources.MediaSource.WaitStatus waitstatus)
    {
        if (waitstatus == com.rdio.android.audioplayer.sources.MediaSource.WaitStatus.Success && isPlaying())
        {
            internalPlayAudio();
        }
        onInfo(bufferingEnd);
    }

    private void performSeek(int i)
    {
        boolean flag = isPlaying;
        pause();
        onSeekStart();
        currTrackOffsetMsec = 0;
        lastSeekOffsetMsec = mediaExtractor.seek(i, com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin.Begin);
        if (lastSeekOffsetMsec == -1)
        {
            onError(new RdioAudioError("Unable to seek, extractor's media source is null or could not be determined", com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.AudioError, false));
            lastSeekOffsetMsec = 0;
        }
        flushAudio(true);
        if (flag)
        {
            try
            {
                start();
            }
            catch (IOException ioexception)
            {
                onError(new RdioAudioError("start() threw exception when seeking", com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.AudioError, false));
            }
        }
        onSeekComplete();
    }

    private void performStart()
    {
        performStart(false);
    }

    private void performStart(boolean flag)
    {
        Object obj = threadMutexLock;
        obj;
        JVM INSTR monitorenter ;
        if (audioProcessingThread == null)
        {
            audioProcessingThread = new Thread(new Runnable() {

                final RdioAudioPlayer this$0;

                public void run()
                {
                    mediaExtractor.selectTrack(0);
                    if (!checkStates(new com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState[] {
                com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Prepared
            }))
                    {
                        (new StringBuilder("Process audio interrupted, state is now: ")).append(state);
                        return;
                    }
                    try
                    {
                        if (configureDecoder && !configureMediaDecoder(getCurrentSource().getMediaType()))
                        {
                            onError(new RdioAudioError("performStart() - Could not initialize or configure decoder!", com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.DecoderError, true));
                            isPlaying = false;
                            return;
                        }
                    }
                    catch (IOException ioexception)
                    {
                        ioexception.printStackTrace();
                    }
                    onInfo(audioStart);
                    processAudio();
                }

            
            {
                this$0 = RdioAudioPlayer.this;
                super();
            }
            });
            continueProcessing = true;
            seekRequestedMsec = -1;
            audioProcessingThread.setName("processAudio Thread");
            audioProcessingThread.start();
        }
        isPlaying = true;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        setTrackEndMarker(currTrackOffsetMsec + (getDuration() - lastSeekOffsetMsec));
        internalPlayAudio();
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void processAudio()
    {
        AndroidByteBuffer androidbytebuffer;
        AndroidByteBuffer androidbytebuffer1;
        int i;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        i = 0;
        flag4 = false;
        flag1 = false;
        androidbytebuffer = new AndroidByteBuffer();
        androidbytebuffer1 = new AndroidByteBuffer();
        flag2 = flag1;
        flag3 = flag4;
        mediaDecoder.start();
        flag2 = flag1;
        flag3 = flag4;
        java.nio.ByteBuffer abytebuffer1[] = mediaDecoder.getInputBuffers();
        flag2 = flag1;
        flag3 = flag4;
        java.nio.ByteBuffer abytebuffer[] = mediaDecoder.getOutputBuffers();
        AudioWriter audiowriter;
        boolean flag;
        audiowriter = null;
        flag1 = false;
        flag = false;
_L31:
        if (flag1 || i >= 50)
        {
            break MISSING_BLOCK_LABEL_607;
        }
        if (!continueProcessing)
        {
            break MISSING_BLOCK_LABEL_607;
        }
        if (seekRequestedMsec != -1)
        {
            performSeek(seekRequestedMsec);
            seekRequestedMsec = -1;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        int j1 = mediaDecoder.dequeueInputBuffer(20000L);
        if (j1 < 0) goto _L2; else goto _L3
_L3:
        int j;
        androidbytebuffer.buffer = abytebuffer1[j1];
        androidbytebuffer.clear();
        j = mediaExtractor.readSampleData(androidbytebuffer, 0);
        long l1 = 0L;
        if (j >= 0) goto _L5; else goto _L4
_L4:
        flag = true;
        j = 0;
        onAudioExtractCompleted();
_L17:
        Object obj1 = mediaDecoder;
        int i1;
        if (flag)
        {
            i1 = 4;
        } else
        {
            i1 = 0;
        }
        ((MediaCodec) (obj1)).queueInputBuffer(j1, 0, j, l1, i1);
        if (flag) goto _L2; else goto _L6
_L6:
        mediaExtractor.advance();
_L2:
        i1 = mediaDecoder.dequeueOutputBuffer(bufferInfo, 20000L);
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_510;
        }
        j1 = bufferInfo.size;
        if (j1 > 0)
        {
            i = 0;
        }
        androidbytebuffer1.buffer = abytebuffer[i1];
        j = bufferInfo.flags;
        if ((j & 4) != 0)
        {
            flag1 = true;
        }
        obj1 = audiowriter;
        flag2 = flag1;
        flag3 = flag1;
        if (!continueProcessing) goto _L8; else goto _L7
_L7:
        obj1 = audiowriter;
        if (j1 <= 0) goto _L8; else goto _L9
_L9:
        obj1 = audiowriter;
        if (audiowriter != null) goto _L11; else goto _L10
_L10:
        j = 1;
        flag2 = flag1;
        flag3 = flag1;
        if (!inGaplessPlaybackMode()) goto _L13; else goto _L12
_L12:
        if (j1 <= 12000) goto _L15; else goto _L14
_L14:
        j = 2;
_L13:
        flag2 = flag1;
        flag3 = flag1;
        audiowriter = new AudioWriter(j);
        obj1 = audiowriter;
        flag2 = flag1;
        flag3 = flag1;
        if (!inGaplessPlaybackMode()) goto _L11; else goto _L16
_L16:
        flag2 = flag1;
        flag3 = flag1;
        audiowriter.setGaplessParameters(0x7fffffff, 0x7fffffff);
        obj1 = audiowriter;
_L11:
        flag2 = flag1;
        flag3 = flag1;
        ((AudioWriter) (obj1)).write(androidbytebuffer1, j1, flag1);
_L8:
        flag2 = flag1;
        flag3 = flag1;
        androidbytebuffer1.clear();
        flag2 = flag1;
        flag3 = flag1;
        mediaDecoder.releaseOutputBuffer(i1, false);
        audiowriter = ((AudioWriter) (obj1));
        continue; /* Loop/switch isn't completed */
_L5:
        l1 = mediaExtractor.getSampleTime();
          goto _L17
_L15:
        flag2 = flag1;
        flag3 = flag1;
        j = 12000 / j1;
          goto _L13
        if (i1 != -3)
        {
            break MISSING_BLOCK_LABEL_528;
        }
        abytebuffer = mediaDecoder.getOutputBuffers();
        continue; /* Loop/switch isn't completed */
        if (i1 != -2)
        {
            break MISSING_BLOCK_LABEL_835;
        }
        obj1 = mediaDecoder.getOutputFormat();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_595;
        }
        int k = ((MediaFormat) (obj1)).getInteger("sample-rate");
        if (setPlaybackRate(k) != com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioStatusCode.Success)
        {
            Log.e("RdioAudioPlayer", (new StringBuilder("Could not set playback rate to ")).append(k).toString());
        }
        continue; /* Loop/switch isn't completed */
        Log.e("RdioAudioPlayer", "output format has changed but is null");
        continue; /* Loop/switch isn't completed */
        if (i < 50) goto _L19; else goto _L18
_L18:
        Log.e("RdioAudioPlayer", "Unable to dequeue output buffer");
        onError(new RdioAudioError("media decoder - timed out while trying to dequeue output buffer", com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.DecoderError, true));
_L21:
        mediaDecoder.stop();
        if (flag1)
        {
            onAudioDecodeCompleted();
        }
        onProcessAudioCompleted();
        return;
_L19:
        writeEOT();
        if (true) goto _L21; else goto _L20
_L20:
        Object obj;
        obj;
        flag3 = flag1;
_L29:
        flag2 = flag3;
        obj1 = com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.AudioError;
        flag2 = flag3;
        if (!(obj instanceof com.rdio.android.audioplayer.extractors.AudioExtractor.NoProgressOnReadException)) goto _L23; else goto _L22
_L22:
        flag2 = flag3;
        obj1 = com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.StreamProgressTimedOut;
_L26:
        flag2 = flag3;
        onError(new RdioAudioError(((Exception) (obj)), ((com.rdio.android.audioplayer.interfaces.AudioError.ErrorType) (obj1)), true));
        mediaDecoder.stop();
        if (flag3)
        {
            onAudioDecodeCompleted();
        }
        onProcessAudioCompleted();
        return;
_L23:
        flag2 = flag3;
        if (!(obj instanceof IllegalStateException)) goto _L25; else goto _L24
_L24:
        flag2 = flag3;
        Log.e("RdioAudioPlayer", "IllegalStateException caught!", ((Throwable) (obj)));
          goto _L26
        obj;
        flag1 = flag2;
_L27:
        mediaDecoder.stop();
        if (flag1)
        {
            onAudioDecodeCompleted();
        }
        onProcessAudioCompleted();
        throw obj;
_L25:
        flag2 = flag3;
        Log.e("RdioAudioPlayer", "Unexpected exception caught!", ((Throwable) (obj)));
          goto _L26
        obj;
          goto _L27
        obj;
        if (true) goto _L29; else goto _L28
_L28:
        if (i1 == -1)
        {
            int l = i + 1;
            i = l;
            if (l > 10)
            {
                i = l;
            }
        } else
        {
            i++;
        }
        if (true) goto _L31; else goto _L30
_L30:
    }

    private void releaseMediaDecoder()
    {
        if (mp3Decoder != null)
        {
            mp3Decoder.release();
        }
        if (aacDecoder != null)
        {
            aacDecoder.release();
        }
        mediaDecoder = null;
        mediaDecoderName = "";
        bufferInfo = null;
    }

    private void releaseMediaExtractor()
    {
        if (mp3Extractor != null)
        {
            mp3Extractor.releaseDataSource();
        }
        if (aacExtracor != null)
        {
            aacExtracor.releaseDataSource();
        }
        mediaExtractor = null;
    }

    private void stopProcessing(final Runnable postAction)
    {
        continueProcessing = false;
        if (mediaExtractor != null)
        {
            mediaExtractor.cancelIfWaiting();
        }
        if (isPlaying())
        {
            isPlaying = false;
            internalStopAudio();
        } else
        {
            flushAudio();
        }
        (new Thread(new Runnable() {

            final RdioAudioPlayer this$0;
            final Runnable val$postAction;

            public void run()
            {
                Object obj = threadMutexLock;
                obj;
                JVM INSTR monitorenter ;
                Thread thread = audioProcessingThread;
                if (thread == null) goto _L2; else goto _L1
_L1:
                audioProcessingThread.join();
_L3:
                audioProcessingThread = null;
_L2:
                if (postAction != null)
                {
                    postAction.run();
                }
                obj;
                JVM INSTR monitorexit ;
                return;
                Object obj1;
                obj1;
                ((InterruptedException) (obj1)).printStackTrace();
                Log.e("RdioAudioPlayer", "Could not join audioProcessingThread");
                  goto _L3
                obj1;
                obj;
                JVM INSTR monitorexit ;
                throw obj1;
            }

            
            {
                this$0 = RdioAudioPlayer.this;
                postAction = runnable;
                super();
            }
        })).start();
    }

    protected abstract void flushAudio();

    protected abstract void flushAudio(boolean flag);

    public abstract int getCurrentPosition();

    protected MediaSource getCurrentSource()
    {
        return currentSource;
    }

    public int getDuration()
    {
        return (int)getCurrentSource().getDuration();
    }

    public int getLastReportedBufferedPercent()
    {
        if (getCurrentSource() != null)
        {
            return getCurrentSource().getBufferedPercent();
        } else
        {
            return 0;
        }
    }

    protected MediaSource getNextSource()
    {
        return nextSource;
    }

    public com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlaybackMode getPlaybackMode()
    {
        return playbackMode;
    }

    public abstract int getSessionId();

    public com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState getState()
    {
        return state;
    }

    public String getStreamQuality()
    {
        return streamQuality;
    }

    protected abstract void internalPauseAudio();

    protected abstract void internalPlayAudio();

    protected abstract void internalStopAudio();

    public boolean isCompleted()
    {
        return getState() == com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Completed;
    }

    public boolean isPlaying()
    {
        return isPlaying;
    }

    public boolean isPrepared()
    {
        return getState() == com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Prepared;
    }

    public boolean isPreparing()
    {
        return getState() == com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Preparing;
    }

    public boolean isReset()
    {
        return getState() == com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Reset;
    }

    public boolean isResetting()
    {
        return getState() == com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Resetting;
    }

    protected void onCompletion()
    {
        reentrantLock.lock();
        if (!isAudioDecodeComplete)
        {
            try
            {
                if (!doneProcessing.await(5000L, TimeUnit.MILLISECONDS))
                {
                    Log.e("RdioAudioPlayer", "Timed out waiting for audio processing to finish. onAudioDecodeCompleted hasn't been called");
                }
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }
        reentrantLock.unlock();
        getNextSource();
        if (audioPlayerListener != null)
        {
            audioPlayerListener.onComplete();
        }
    }

    protected void onError(final AudioError error)
    {
        Log.e("RdioAudioPlayer", (new StringBuilder("onError: ")).append(error.getDescription()).toString());
        if (state != com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Error)
        {
            state = com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Error;
            mainThread.post(new Runnable() {

                final RdioAudioPlayer this$0;
                final AudioError val$error;

                public void run()
                {
                    audioPlayerListener.onError(error);
                }

            
            {
                this$0 = RdioAudioPlayer.this;
                error = audioerror;
                super();
            }
            });
        }
    }

    protected void onInfo(final AudioInfo info)
    {
        mainThread.post(new Runnable() {

            final RdioAudioPlayer this$0;
            final AudioInfo val$info;

            public void run()
            {
                audioPlayerListener.onInfo(info);
            }

            
            {
                this$0 = RdioAudioPlayer.this;
                info = audioinfo;
                super();
            }
        });
    }

    protected void onPrepared()
    {
        state = com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Prepared;
        mainThread.post(new Runnable() {

            final RdioAudioPlayer this$0;

            public void run()
            {
                audioPlayerListener.onPrepared();
            }

            
            {
                this$0 = RdioAudioPlayer.this;
                super();
            }
        });
    }

    protected void onReleased()
    {
    }

    protected void onResetComplete()
    {
        audioPlayerListener.onResetComplete();
    }

    protected void onSeekComplete()
    {
        mainThread.post(new Runnable() {

            final RdioAudioPlayer this$0;

            public void run()
            {
                audioPlayerListener.onSeekCompleted();
            }

            
            {
                this$0 = RdioAudioPlayer.this;
                super();
            }
        });
    }

    protected void onSeekStart()
    {
        mainThread.post(new Runnable() {

            final RdioAudioPlayer this$0;

            public void run()
            {
                audioPlayerListener.onSeekStarted();
            }

            
            {
                this$0 = RdioAudioPlayer.this;
                super();
            }
        });
    }

    public void pause()
    {
        if (!checkStates(new com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState[] {
    com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Prepared, com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Error
}))
        {
            return;
        }
        synchronized (threadMutexLock)
        {
            isPlaying = false;
            internalPauseAudio();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean prepare()
    {
        if (!checkStates(new com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState[] {
    com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Ready, com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Prepared, com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Preparing
}))
        {
            (new StringBuilder("Prepare called when in wrong state, expected Ready or Prepared was ")).append(state);
            return false;
        }
        if (mediaExtractor == null)
        {
            com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType mediatype = getCurrentSource().blockingGetMediaType();
            if (mediatype == com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType.Unknown)
            {
                Log.e("RdioAudioPlayer", "No MediaType could be gotten from the current media source!");
                onError(new RdioAudioError("Current media source has Unknown MediaType!", com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.AudioError, true));
                return false;
            }
            if (!checkStates(new com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState[] {
    com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Preparing
}))
            {
                (new StringBuilder("Preparing interrupted, state is now: ")).append(state);
                return false;
            }
            try
            {
                initializeMediaExtractor(getCurrentSource(), mediatype, true);
            }
            catch (com.rdio.android.audioplayer.extractors.MediaExtractor.InvalidSourceException invalidsourceexception)
            {
                Log.e("RdioAudioPlayer", "Could not initialize extractor!", invalidsourceexception);
                onError(new RdioAudioError(invalidsourceexception, com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.ExtractorError, true));
            }
        }
        try
        {
            state = com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Prepared;
        }
        catch (Exception exception)
        {
            Log.e("RdioAudioPlayer", "MediaParseException caught", exception);
            onError(new RdioAudioError("MediaExtractor: MediaParseException in prepare()", com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.ExtractorError, true));
            return false;
        }
        return true;
    }

    public void prepareAsync()
    {
        state = com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Preparing;
        (new Thread(new Runnable() {

            final RdioAudioPlayer this$0;

            public void run()
            {
                if (prepare())
                {
                    onPrepared();
                    return;
                } else
                {
                    Log.e("RdioAudioPlayer", "Player failed to prepare.");
                    return;
                }
            }

            
            {
                this$0 = RdioAudioPlayer.this;
                super();
            }
        })).start();
    }

    protected abstract void prepareAudio();

    public void release()
    {
label0:
        {
            synchronized (resourceMutexLock)
            {
                if (state != com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Uninitialized && state != com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Uninitialized)
                {
                    break label0;
                }
            }
            return;
        }
        state = com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Uninitializing;
        obj;
        JVM INSTR monitorexit ;
        stopProcessing(new Runnable() {

            final RdioAudioPlayer this$0;

            public void run()
            {
                releaseMediaExtractor();
                releaseMediaDecoder();
                releaseAudio();
                if (getCurrentSource() != null)
                {
                    getCurrentSource().removeCallbacksListener(dataSourceErrorListener);
                    getCurrentSource().removeCallbacksListener(postStartDataSourceListener);
                }
                mp3Extractor = null;
                aacExtracor = null;
                state = com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Uninitialized;
                onReleased();
            }

            
            {
                this$0 = RdioAudioPlayer.this;
                super();
            }
        });
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected abstract void releaseAudio();

    public void reset()
    {
        if (state == com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Uninitialized || state == com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Uninitializing || state == com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Reset)
        {
            return;
        } else
        {
            state = com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Resetting;
            stopProcessing(new Runnable() {

                final RdioAudioPlayer this$0;

                public void run()
                {
label0:
                    {
                        synchronized (resourceMutexLock)
                        {
                            if (state != com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Uninitialized && state != com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Uninitializing && state != com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Reset)
                            {
                                break label0;
                            }
                        }
                        return;
                    }
                    isAudioDecodeComplete = false;
                    releaseMediaExtractor();
                    if (getCurrentSource() != null)
                    {
                        getCurrentSource().removeCallbacksListener(dataSourceErrorListener);
                        getCurrentSource().removeCallbacksListener(postStartDataSourceListener);
                    }
                    state = com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Reset;
                    onResetComplete();
                    obj;
                    JVM INSTR monitorexit ;
                    return;
                    exception;
                    obj;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                this$0 = RdioAudioPlayer.this;
                super();
            }
            });
            return;
        }
    }

    public void seekTo(int i)
    {
        if (!checkState(com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Prepared))
        {
            return;
        } else
        {
            seekRequestedMsec = i;
            return;
        }
    }

    public void setAudioPlayerListener(AudioPlayerListener audioplayerlistener)
    {
        audioPlayerListener = audioplayerlistener;
    }

    protected void setCurrentSource(MediaSource mediasource)
    {
        currentSource = mediasource;
        currentSource.addCallbacksListener(dataSourceErrorListener);
        if (currentSource == null)
        {
            doneProcessing.signalAll();
        }
    }

    public void setDataSource(MediaSource mediasource, com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType mediatype, int i)
    {
        i = 0;
        Object obj = resourceMutexLock;
        obj;
        JVM INSTR monitorenter ;
        if (getState() != com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Reset || mediasource == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        setCurrentSource(mediasource);
        if (mediatype != com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType.Unknown)
        {
            initializeMediaExtractor(mediasource, mediatype, true);
        }
        lastSeekOffsetMsec = 0;
        currTrackOffsetMsec = 0;
        state = com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Ready;
_L1:
        obj;
        JVM INSTR monitorexit ;
        if (i != 0)
        {
            checkState(com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Reset);
        }
        return;
        i = 1;
          goto _L1
        mediasource;
        obj;
        JVM INSTR monitorexit ;
        throw mediasource;
    }

    public void setNextDataSource(MediaSource mediasource)
    {
    }

    public void setPlaybackMode(com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlaybackMode audioplaybackmode)
    {
        playbackMode = audioplaybackmode;
    }

    protected abstract com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioStatusCode setPlaybackRate(int i);

    protected abstract void setTrackEndMarker(int i);

    public abstract void setVolume(float f, float f1);

    public void start()
    {
        if (!checkState(com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Prepared))
        {
            return;
        }
        prepareAudio();
        if (getCurrentSource().getBytesBuffered() > 12000L)
        {
            performStart();
            return;
        } else
        {
            postStartDataSourceListener.reset();
            getCurrentSource().addCallbacksListener(postStartDataSourceListener);
            onInfo(bufferingStart);
            return;
        }
    }

    public void stop()
    {
        if (!checkStates(new com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState[] {
    com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Prepared, com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Error
}))
        {
            return;
        } else
        {
            stopProcessing(null);
            return;
        }
    }

    public boolean supportsGaplessPlayback()
    {
        return true;
    }

    protected abstract int write(byte abyte0[], int i, int j);

    protected abstract void writeEOT();

    static 
    {
        boolean flag;
        if (!DeviceHelper.hasJellyBeanMr2())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        reinitDecoder = flag;
    }







/*
    static boolean access$1402(RdioAudioPlayer rdioaudioplayer, boolean flag)
    {
        rdioaudioplayer.isPlaying = flag;
        return flag;
    }

*/






/*
    static Thread access$1802(RdioAudioPlayer rdioaudioplayer, Thread thread)
    {
        rdioaudioplayer.audioProcessingThread = thread;
        return thread;
    }

*/





/*
    static com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState access$202(RdioAudioPlayer rdioaudioplayer, com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState audioplayerstate)
    {
        rdioaudioplayer.state = audioplayerstate;
        return audioplayerstate;
    }

*/





/*
    static boolean access$302(RdioAudioPlayer rdioaudioplayer, boolean flag)
    {
        rdioaudioplayer.isAudioDecodeComplete = flag;
        return flag;
    }

*/






/*
    static MediaExtractor access$802(RdioAudioPlayer rdioaudioplayer, MediaExtractor mediaextractor)
    {
        rdioaudioplayer.mp3Extractor = mediaextractor;
        return mediaextractor;
    }

*/


/*
    static MediaExtractor access$902(RdioAudioPlayer rdioaudioplayer, MediaExtractor mediaextractor)
    {
        rdioaudioplayer.aacExtracor = mediaextractor;
        return mediaextractor;
    }

*/
}
