// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.audio;

import android.media.AudioTimestamp;
import android.media.MediaFormat;
import android.os.ConditionVariable;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import shared_presage.com.google.android.exoplayer.util.Ac3Util;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.MimeTypes;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.audio:
//            b, a

public final class AudioTrack
{
    public static final class InitializationException extends Exception
    {

        public final int audioTrackState;

        public InitializationException(int i, int j, int k, int l)
        {
            super((new StringBuilder("AudioTrack init failed: ")).append(i).append(", Config(").append(j).append(", ").append(k).append(", ").append(l).append(")").toString());
            audioTrackState = i;
        }
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException
    {

        public InvalidAudioTrackTimestampException(String s)
        {
            super(s);
        }
    }

    public static final class WriteException extends Exception
    {

        public final int errorCode;

        public WriteException(int i)
        {
            super((new StringBuilder("AudioTrack write failed: ")).append(i).toString());
            errorCode = i;
        }
    }

    private static class a
    {

        protected android.media.AudioTrack a;
        private boolean b;
        private int c;
        private long d;
        private long e;
        private long f;

        public void a(android.media.AudioTrack audiotrack, boolean flag)
        {
            a = audiotrack;
            b = flag;
            d = 0L;
            e = 0L;
            f = 0L;
            if (audiotrack != null)
            {
                c = audiotrack.getSampleRate();
            }
        }

        public final boolean a()
        {
            return Util.SDK_INT <= 22 && b && a.getPlayState() == 2 && a.getPlaybackHeadPosition() == 0;
        }

        public final long b()
        {
            long l;
            long l1;
            l1 = 0xffffffffL & (long)a.getPlaybackHeadPosition();
            l = l1;
            if (Util.SDK_INT > 22) goto _L2; else goto _L1
_L1:
            l = l1;
            if (!b) goto _L2; else goto _L3
_L3:
            if (a.getPlayState() != 1) goto _L5; else goto _L4
_L4:
            d = l1;
_L7:
            l = l1 + f;
_L2:
            if (d > l)
            {
                e = e + 1L;
            }
            d = l;
            return l + (e << 32);
_L5:
            if (a.getPlayState() == 2 && l1 == 0L)
            {
                f = d;
            }
            if (true) goto _L7; else goto _L6
_L6:
        }

        public final long c()
        {
            return (b() * 0xf4240L) / (long)c;
        }

        public boolean d()
        {
            return false;
        }

        public long e()
        {
            throw new UnsupportedOperationException();
        }

        public long f()
        {
            throw new UnsupportedOperationException();
        }

        private a()
        {
        }

        a(byte byte0)
        {
            this();
        }
    }

    private static final class b extends a
    {

        private final AudioTimestamp b = new AudioTimestamp();
        private long c;
        private long d;
        private long e;

        public final void a(android.media.AudioTrack audiotrack, boolean flag)
        {
            super.a(audiotrack, flag);
            c = 0L;
            d = 0L;
            e = 0L;
        }

        public final boolean d()
        {
            boolean flag = a.getTimestamp(b);
            if (flag)
            {
                long l = b.framePosition;
                if (d > l)
                {
                    c = c + 1L;
                }
                d = l;
                e = l + (c << 32);
            }
            return flag;
        }

        public final long e()
        {
            return b.nanoTime;
        }

        public final long f()
        {
            return e;
        }

        public b()
        {
            super((byte)0);
        }
    }


    private static final int BUFFER_MULTIPLICATION_FACTOR = 4;
    public static final long CURRENT_POSITION_NOT_SET = 0x8000000000000000L;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 0x4c4b40L;
    private static final long MAX_BUFFER_DURATION_US = 0xb71b0L;
    private static final long MAX_LATENCY_US = 0x4c4b40L;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final long MIN_BUFFER_DURATION_US = 0x3d090L;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final int MIN_TIMESTAMP_SAMPLE_INTERVAL_US = 0x7a120;
    public static final int RESULT_BUFFER_CONSUMED = 2;
    public static final int RESULT_POSITION_DISCONTINUITY = 1;
    public static final int SESSION_ID_NOT_SET = 0;
    private static final int START_IN_SYNC = 1;
    private static final int START_NEED_SYNC = 2;
    private static final int START_NOT_SET = 0;
    private static final String TAG = "AudioTrack";
    private static final int UNKNOWN_AC3_BITRATE = 0;
    public static boolean enablePreV21AudioSessionWorkaround = false;
    public static boolean failOnSpuriousAudioTimestamp = false;
    private int ac3Bitrate;
    private boolean audioTimestampSet;
    private android.media.AudioTrack audioTrack;
    private final a audioTrackUtil;
    private int bufferSize;
    private int channelConfig;
    private int encoding;
    private int frameSize;
    private Method getLatencyMethod;
    private boolean isAc3;
    private android.media.AudioTrack keepSessionIdAudioTrack;
    private long lastPlayheadSampleTimeUs;
    private long lastTimestampSampleTimeUs;
    private long latencyUs;
    private int minBufferSize;
    private int nextPlayheadOffsetIndex;
    private int playheadOffsetCount;
    private final long playheadOffsets[] = new long[10];
    private final ConditionVariable releasingConditionVariable = new ConditionVariable(true);
    private long resumeSystemTimeUs;
    private int sampleRate;
    private long smoothedPlayheadOffsetUs;
    private int startMediaTimeState;
    private long startMediaTimeUs;
    private long submittedBytes;
    private byte temporaryBuffer[];
    private int temporaryBufferOffset;
    private int temporaryBufferSize;
    private float volume;

    public AudioTrack()
    {
        if (Util.SDK_INT >= 18)
        {
            try
            {
                getLatencyMethod = android/media/AudioTrack.getMethod("getLatency", null);
            }
            catch (NoSuchMethodException nosuchmethodexception) { }
        }
        if (Util.SDK_INT >= 19)
        {
            audioTrackUtil = new b();
        } else
        {
            audioTrackUtil = new a((byte)0);
        }
        volume = 1.0F;
        startMediaTimeState = 0;
    }

    private long bytesToFrames(long l)
    {
        if (isAc3)
        {
            if (ac3Bitrate == 0)
            {
                return 0L;
            } else
            {
                return (8L * l * (long)sampleRate) / (long)(ac3Bitrate * 1000);
            }
        } else
        {
            return l / (long)frameSize;
        }
    }

    private void checkAudioTrackInitialized()
    {
        int i;
        i = audioTrack.getState();
        if (i == 1)
        {
            return;
        }
        audioTrack.release();
        audioTrack = null;
_L2:
        throw new InitializationException(i, sampleRate, channelConfig, bufferSize);
        Object obj;
        obj;
        audioTrack = null;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        audioTrack = null;
        throw obj;
    }

    private long durationUsToFrames(long l)
    {
        return ((long)sampleRate * l) / 0xf4240L;
    }

    private long framesToDurationUs(long l)
    {
        return (0xf4240L * l) / (long)sampleRate;
    }

    private boolean hasCurrentPositionUs()
    {
        return isInitialized() && startMediaTimeState != 0;
    }

    private void maybeSampleSyncParams()
    {
        long l = audioTrackUtil.c();
        if (l != 0L)
        {
            long l1 = System.nanoTime() / 1000L;
            if (l1 - lastPlayheadSampleTimeUs >= 30000L)
            {
                playheadOffsets[nextPlayheadOffsetIndex] = l - l1;
                nextPlayheadOffsetIndex = (nextPlayheadOffsetIndex + 1) % 10;
                if (playheadOffsetCount < 10)
                {
                    playheadOffsetCount = playheadOffsetCount + 1;
                }
                lastPlayheadSampleTimeUs = l1;
                smoothedPlayheadOffsetUs = 0L;
                for (int i = 0; i < playheadOffsetCount; i++)
                {
                    smoothedPlayheadOffsetUs = smoothedPlayheadOffsetUs + playheadOffsets[i] / (long)playheadOffsetCount;
                }

            }
            if (!isAc3 && l1 - lastTimestampSampleTimeUs >= 0x7a120L)
            {
                audioTimestampSet = audioTrackUtil.d();
                if (audioTimestampSet)
                {
                    long l2 = audioTrackUtil.e() / 1000L;
                    long l3 = audioTrackUtil.f();
                    if (l2 < resumeSystemTimeUs)
                    {
                        audioTimestampSet = false;
                    } else
                    if (Math.abs(l2 - l1) > 0x4c4b40L)
                    {
                        String s = (new StringBuilder("Spurious audio timestamp (system clock mismatch): ")).append(l3).append(", ").append(l2).append(", ").append(l1).append(", ").append(l).toString();
                        if (failOnSpuriousAudioTimestamp)
                        {
                            throw new InvalidAudioTrackTimestampException(s);
                        }
                        Log.w("AudioTrack", s);
                        audioTimestampSet = false;
                    } else
                    if (Math.abs(framesToDurationUs(l3) - l) > 0x4c4b40L)
                    {
                        String s1 = (new StringBuilder("Spurious audio timestamp (frame position mismatch): ")).append(l3).append(", ").append(l2).append(", ").append(l1).append(", ").append(l).toString();
                        if (failOnSpuriousAudioTimestamp)
                        {
                            throw new InvalidAudioTrackTimestampException(s1);
                        }
                        Log.w("AudioTrack", s1);
                        audioTimestampSet = false;
                    }
                }
                if (getLatencyMethod != null)
                {
                    try
                    {
                        latencyUs = (long)((Integer)getLatencyMethod.invoke(audioTrack, null)).intValue() * 1000L - framesToDurationUs(bytesToFrames(bufferSize));
                        latencyUs = Math.max(latencyUs, 0L);
                        if (latencyUs > 0x4c4b40L)
                        {
                            Log.w("AudioTrack", (new StringBuilder("Ignoring impossibly large audio latency: ")).append(latencyUs).toString());
                            latencyUs = 0L;
                        }
                    }
                    catch (Exception exception)
                    {
                        getLatencyMethod = null;
                    }
                }
                lastTimestampSampleTimeUs = l1;
                return;
            }
        }
    }

    private void releaseKeepSessionIdAudioTrack()
    {
        if (keepSessionIdAudioTrack == null)
        {
            return;
        } else
        {
            android.media.AudioTrack audiotrack = keepSessionIdAudioTrack;
            keepSessionIdAudioTrack = null;
            (new shared_presage.com.google.android.exoplayer.audio.b(this, audiotrack)).start();
            return;
        }
    }

    private void resetSyncParams()
    {
        smoothedPlayheadOffsetUs = 0L;
        playheadOffsetCount = 0;
        nextPlayheadOffsetIndex = 0;
        lastPlayheadSampleTimeUs = 0L;
        audioTimestampSet = false;
        lastTimestampSampleTimeUs = 0L;
    }

    private static void setVolumeV21(android.media.AudioTrack audiotrack, float f)
    {
        audiotrack.setVolume(f);
    }

    private static void setVolumeV3(android.media.AudioTrack audiotrack, float f)
    {
        audiotrack.setStereoVolume(f, f);
    }

    private static int writeNonBlockingV21(android.media.AudioTrack audiotrack, ByteBuffer bytebuffer, int i)
    {
        return audiotrack.write(bytebuffer, i, 1);
    }

    public final long getCurrentPositionUs(boolean flag)
    {
        long l1;
        if (!hasCurrentPositionUs())
        {
            l1 = 0x8000000000000000L;
        } else
        {
            if (audioTrack.getPlayState() == 3)
            {
                maybeSampleSyncParams();
            }
            long l = System.nanoTime() / 1000L;
            if (audioTimestampSet)
            {
                return framesToDurationUs(durationUsToFrames(l - audioTrackUtil.e() / 1000L) + audioTrackUtil.f()) + startMediaTimeUs;
            }
            if (playheadOffsetCount == 0)
            {
                l = audioTrackUtil.c() + startMediaTimeUs;
            } else
            {
                l = l + smoothedPlayheadOffsetUs + startMediaTimeUs;
            }
            l1 = l;
            if (!flag)
            {
                return l - latencyUs;
            }
        }
        return l1;
    }

    public final int handleBuffer(ByteBuffer bytebuffer, int i, int j, long l)
    {
        if (j == 0)
        {
            i = 2;
        } else
        {
            if (Util.SDK_INT <= 22 && isAc3)
            {
                if (audioTrack.getPlayState() == 2)
                {
                    return 0;
                }
                if (audioTrack.getPlayState() == 1 && audioTrackUtil.b() != 0L)
                {
                    return 0;
                }
            }
            boolean flag = false;
            int k = ((flag) ? 1 : 0);
            if (temporaryBufferSize == 0)
            {
                if (isAc3 && ac3Bitrate == 0)
                {
                    ac3Bitrate = Ac3Util.getBitrate(j, sampleRate);
                }
                l -= framesToDurationUs(bytesToFrames(j));
                if (startMediaTimeState == 0)
                {
                    startMediaTimeUs = Math.max(0L, l);
                    startMediaTimeState = 1;
                    k = ((flag) ? 1 : 0);
                } else
                {
                    long l1 = startMediaTimeUs + framesToDurationUs(bytesToFrames(submittedBytes));
                    if (startMediaTimeState == 1 && Math.abs(l1 - l) > 0x30d40L)
                    {
                        Log.e("AudioTrack", (new StringBuilder("Discontinuity detected [expected ")).append(l1).append(", got ").append(l).append("]").toString());
                        startMediaTimeState = 2;
                    }
                    k = ((flag) ? 1 : 0);
                    if (startMediaTimeState == 2)
                    {
                        startMediaTimeUs = startMediaTimeUs + (l - l1);
                        startMediaTimeState = 1;
                        k = 1;
                    }
                }
            }
            if (temporaryBufferSize == 0)
            {
                temporaryBufferSize = j;
                bytebuffer.position(i);
                if (Util.SDK_INT < 21)
                {
                    if (temporaryBuffer == null || temporaryBuffer.length < j)
                    {
                        temporaryBuffer = new byte[j];
                    }
                    bytebuffer.get(temporaryBuffer, 0, j);
                    temporaryBufferOffset = 0;
                }
            }
            i = 0;
            if (Util.SDK_INT < 21)
            {
                j = (int)(submittedBytes - audioTrackUtil.b() * (long)frameSize);
                j = bufferSize - j;
                if (j > 0)
                {
                    i = Math.min(temporaryBufferSize, j);
                    j = audioTrack.write(temporaryBuffer, temporaryBufferOffset, i);
                    i = j;
                    if (j >= 0)
                    {
                        temporaryBufferOffset = temporaryBufferOffset + j;
                        i = j;
                    }
                }
            } else
            {
                i = writeNonBlockingV21(audioTrack, bytebuffer, temporaryBufferSize);
            }
            if (i < 0)
            {
                throw new WriteException(i);
            }
            temporaryBufferSize = temporaryBufferSize - i;
            submittedBytes = submittedBytes + (long)i;
            i = k;
            if (temporaryBufferSize == 0)
            {
                return k | 2;
            }
        }
        return i;
    }

    public final void handleDiscontinuity()
    {
        if (startMediaTimeState == 1)
        {
            startMediaTimeState = 2;
        }
    }

    public final boolean hasEnoughDataToBeginPlayback()
    {
        return submittedBytes > (long)((minBufferSize * 3) / 2);
    }

    public final boolean hasPendingData()
    {
        return isInitialized() && (bytesToFrames(submittedBytes) > audioTrackUtil.b() || audioTrackUtil.a());
    }

    public final int initialize()
    {
        return initialize(0);
    }

    public final int initialize(int i)
    {
        releasingConditionVariable.block();
        if (i == 0)
        {
            audioTrack = new android.media.AudioTrack(3, sampleRate, channelConfig, encoding, bufferSize, 1);
        } else
        {
            audioTrack = new android.media.AudioTrack(3, sampleRate, channelConfig, encoding, bufferSize, 1, i);
        }
        checkAudioTrackInitialized();
        i = audioTrack.getAudioSessionId();
        if (enablePreV21AudioSessionWorkaround && Util.SDK_INT < 21)
        {
            if (keepSessionIdAudioTrack != null && i != keepSessionIdAudioTrack.getAudioSessionId())
            {
                releaseKeepSessionIdAudioTrack();
            }
            if (keepSessionIdAudioTrack == null)
            {
                keepSessionIdAudioTrack = new android.media.AudioTrack(3, 4000, 4, 2, 2, 0, i);
            }
        }
        audioTrackUtil.a(audioTrack, isAc3);
        setVolume(volume);
        return i;
    }

    public final boolean isInitialized()
    {
        return audioTrack != null;
    }

    public final void pause()
    {
        if (isInitialized())
        {
            resetSyncParams();
            audioTrack.pause();
        }
    }

    public final void play()
    {
        if (isInitialized())
        {
            resumeSystemTimeUs = System.nanoTime() / 1000L;
            audioTrack.play();
        }
    }

    public final void reconfigure(MediaFormat mediaformat)
    {
        reconfigure(mediaformat, 0);
    }

    public final void reconfigure(MediaFormat mediaformat, int i)
    {
        int l;
        boolean flag1;
        flag1 = true;
        l = mediaformat.getInteger("channel-count");
        l;
        JVM INSTR tableswitch 1 8: default 60
    //                   1 86
    //                   2 162
    //                   3 60
    //                   4 60
    //                   5 60
    //                   6 168
    //                   7 60
    //                   8 175;
           goto _L1 _L2 _L3 _L1 _L1 _L1 _L4 _L1 _L5
_L5:
        break MISSING_BLOCK_LABEL_175;
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unsupported channel count: ")).append(l).toString());
_L2:
        int j = 4;
_L6:
        int j1;
        int l1;
        boolean flag;
        j1 = mediaformat.getInteger("sample-rate");
        l1 = MimeTypes.getEncodingForMimeType(mediaformat.getString("mime"));
        if (l1 == 5 || l1 == 6)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (isInitialized() && sampleRate == j1 && channelConfig == j && !isAc3 && !flag)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_188;
_L3:
        j = 12;
          goto _L6
_L4:
        j = 252;
          goto _L6
        j = 1020;
          goto _L6
        reset();
        encoding = l1;
        sampleRate = j1;
        channelConfig = j;
        isAc3 = flag;
        ac3Bitrate = 0;
        frameSize = l * 2;
        minBufferSize = android.media.AudioTrack.getMinBufferSize(j1, j, l1);
        if (minBufferSize != -2)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (i == 0) goto _L8; else goto _L7
_L7:
        bufferSize = i;
        return;
_L8:
        int k = minBufferSize * 4;
        int i1 = (int)durationUsToFrames(0x3d090L) * frameSize;
        int k1 = (int)Math.max(minBufferSize, durationUsToFrames(0xb71b0L) * (long)frameSize);
        i = i1;
        if (k >= i1)
        {
            if (k > k1)
            {
                i = k1;
            } else
            {
                i = k;
            }
        }
        if (true) goto _L7; else goto _L9
_L9:
    }

    public final void release()
    {
        reset();
        releaseKeepSessionIdAudioTrack();
    }

    public final void reset()
    {
        if (isInitialized())
        {
            submittedBytes = 0L;
            temporaryBufferSize = 0;
            startMediaTimeState = 0;
            latencyUs = 0L;
            resetSyncParams();
            if (audioTrack.getPlayState() == 3)
            {
                audioTrack.pause();
            }
            android.media.AudioTrack audiotrack = audioTrack;
            audioTrack = null;
            audioTrackUtil.a(null, false);
            releasingConditionVariable.close();
            (new shared_presage.com.google.android.exoplayer.audio.a(this, audiotrack)).start();
        }
    }

    public final void setVolume(float f)
    {
label0:
        {
            volume = f;
            if (isInitialized())
            {
                if (Util.SDK_INT < 21)
                {
                    break label0;
                }
                audioTrack.setVolume(f);
            }
            return;
        }
        audioTrack.setStereoVolume(f, f);
    }


}
