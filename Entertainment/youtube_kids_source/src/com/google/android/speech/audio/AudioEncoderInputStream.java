// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import android.media.MediaCodec;
import android.media.MediaFormat;
import emp;
import f;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;

public class AudioEncoderInputStream extends InputStream
{

    public static final String AAC_MIME_TYPE = "audio/mp4a-latm";
    private static final int ADTS_HEADER_LENGTH = 7;
    private static final String AMR_HEADER = "#!AMR-WB\n";
    public static final String AMR_WB_MIME_TYPE = "audio/amr-wb";
    public static final int AMR_WB_MODE_8_BITRATE = 23850;
    public static final int AMR_WB_SAMPLE_RATE = 16000;
    private static final int CODEC_AAC = 0;
    private static final int CODEC_AMR_WB = 1;
    private static final boolean DBG = false;
    private static final String TAG = "AudioEncoderInputStream";
    private static final int TIMEOUT_USECS = 10000;
    private final int mChannels;
    private MediaCodec mCodec;
    private ByteBuffer mCodecInputBuffers[];
    private ByteBuffer mCodecOutputBuffers[];
    private final int mCodecType;
    private int mCurrentOutputBufferIndex;
    private final ByteBuffer mDataIn;
    private boolean mEof;
    private final String mMimeType;
    private final ByteBuffer mPendingHeader;
    private final int mReadSize;
    private final int mSampleRate;
    private final InputStream mStream;
    private int mTotalRead;

    public AudioEncoderInputStream(InputStream inputstream, String s, int i, int j, int k, int l)
    {
        boolean flag2 = false;
        boolean flag3 = true;
        super();
        mCurrentOutputBufferIndex = -1;
        mReadSize = j;
        mStream = inputstream;
        mSampleRate = i;
        mChannels = l;
        mMimeType = s;
        if ("audio/mp4a-latm".equals(s))
        {
            boolean flag;
            if (mSampleRate == 11025)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f.b(flag);
            if (mChannels == 1)
            {
                flag = flag3;
            } else
            {
                flag = false;
            }
            f.b(flag);
            mCodecType = 0;
            mPendingHeader = ByteBuffer.wrap(new byte[7]);
        } else
        if ("audio/amr-wb".equals(s))
        {
            boolean flag1;
            if (mSampleRate == 16000)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            f.b(flag1);
            flag1 = flag2;
            if (mChannels == 1)
            {
                flag1 = true;
            }
            f.b(flag1);
            mCodecType = 1;
            mPendingHeader = ByteBuffer.wrap("#!AMR-WB\n".getBytes());
        } else
        {
            throw new IllegalArgumentException("Unsupported audio codec");
        }
        mDataIn = ByteBuffer.wrap(new byte[mReadSize]);
        mDataIn.position(mReadSize);
        inputstream = new MediaFormat();
        inputstream.setString("mime", s);
        inputstream.setInteger("sample-rate", mSampleRate);
        inputstream.setInteger("bitrate", k);
        inputstream.setInteger("channel-count", mChannels);
        if (isAac())
        {
            try
            {
                startCodecByName("OMX.google.aac.encoder", inputstream);
                return;
            }
            catch (Exception exception) { }
        }
        startCodecByMimeType(s, inputstream);
    }

    private void encodeStream()
    {
        boolean flag1 = true;
        if (mCurrentOutputBufferIndex >= 0)
        {
            mCodec.releaseOutputBuffer(mCurrentOutputBufferIndex, false);
            mCurrentOutputBufferIndex = -1;
        }
        int i = mCodec.dequeueInputBuffer(10000L);
        if (i != -1)
        {
            onInputBufferReady(mCodec, i);
        }
        android.media.MediaCodec.BufferInfo bufferinfo = new android.media.MediaCodec.BufferInfo();
        int j = mCodec.dequeueOutputBuffer(bufferinfo, 10000L);
        i = j;
        boolean flag;
        if (j == -2)
        {
            MediaFormat mediaformat = mCodec.getOutputFormat();
            if (mSampleRate == mediaformat.getInteger("sample-rate"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f.b(flag);
            if (mChannels == mediaformat.getInteger("channel-count"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f.b(flag);
            f.b(mMimeType.equals(mediaformat.getString("mime")));
            i = mCodec.dequeueOutputBuffer(bufferinfo, 10000L);
        }
        if (i != -2)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        f.b(flag);
        if (i != -1)
        {
            if (i == -3)
            {
                mCodecOutputBuffers = mCodec.getOutputBuffers();
                return;
            }
            if (i != -1)
            {
                onOutputBufferReady(mCodec, i, bufferinfo.offset, bufferinfo.size, bufferinfo.presentationTimeUs, bufferinfo.flags);
                return;
            }
        }
    }

    private static String hexdumpDebug(ByteBuffer bytebuffer, int i, int j)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int k = 0; k < j; k += 16)
        {
            stringbuilder.append(String.format(Locale.US, "%08x:    ", new Object[] {
                Integer.valueOf(k)
            }));
            int l = 0;
            while (l < 16) 
            {
                if (l == 8)
                {
                    stringbuilder.append(" ");
                }
                if (k + l >= j)
                {
                    stringbuilder.append("   ");
                } else
                {
                    stringbuilder.append(String.format(Locale.US, "%02x ", new Object[] {
                        Byte.valueOf(bytebuffer.get(i + k + l))
                    }));
                }
                l++;
            }
            stringbuilder.append(" ");
            l = 0;
            while (l < 16 && k + l < j) 
            {
                byte byte0 = bytebuffer.get(i + k + l);
                if (isPrintableDebug(byte0))
                {
                    stringbuilder.append(String.format(Locale.US, "%c", new Object[] {
                        Byte.valueOf(byte0)
                    }));
                } else
                {
                    stringbuilder.append(".");
                }
                l++;
            }
            stringbuilder.append('\n');
        }

        return stringbuilder.toString();
    }

    private boolean isAac()
    {
        return mCodecType == 0;
    }

    private static boolean isPrintableDebug(byte byte0)
    {
        return byte0 >= 32 && byte0 <= 45;
    }

    private void onInputBufferReady(MediaCodec mediacodec, int i)
    {
        ByteBuffer bytebuffer = mCodecInputBuffers[i];
        bytebuffer.clear();
        bytebuffer.position(0);
        f.b(bytebuffer.hasRemaining());
        do
        {
            if (bytebuffer.position() >= mReadSize || !bytebuffer.hasRemaining() || mEof)
            {
                break;
            }
            if (mDataIn.hasRemaining())
            {
                int j = Math.min(mDataIn.remaining(), Math.min(bytebuffer.remaining(), mReadSize - bytebuffer.position()));
                bytebuffer.put(mDataIn.array(), mDataIn.position(), j);
                mDataIn.position(j + mDataIn.position());
                continue;
            }
            int k = mStream.read(mDataIn.array());
            if (k == -1)
            {
                break;
            }
            mDataIn.position(0);
            mDataIn.limit(k);
            mTotalRead = k + mTotalRead;
        } while (true);
        if (bytebuffer.position() > 0)
        {
            mediacodec.queueInputBuffer(i, 0, bytebuffer.position(), 0L, 0);
            return;
        } else
        {
            mEof = true;
            mediacodec.queueInputBuffer(i, 0, 0, 0L, 4);
            return;
        }
    }

    private void onOutputBufferReady(MediaCodec mediacodec, int i, int j, int k, long l, int i1)
    {
        mCurrentOutputBufferIndex = i;
        if (isAac())
        {
            mPendingHeader.clear();
            setAdtsHeaderBytes(k, mPendingHeader);
            mPendingHeader.flip();
        }
        mediacodec = mCodecOutputBuffers[i];
        mediacodec.clear();
        mediacodec.position(j);
        mediacodec.limit(j + k);
    }

    private void release()
    {
        if (mCodec != null)
        {
            mCodec.release();
        }
        mCodec = null;
    }

    private void setAdtsHeaderBytes(int i, ByteBuffer bytebuffer)
    {
        long l;
        boolean flag;
        if (bytebuffer.remaining() >= 7)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        l = writeBits(writeBits(writeBits(writeBits(writeBits(writeBits(writeBits(writeBits(writeBits(writeBits(writeBits(writeBits(writeBits(writeBits(writeBits(0L, 12, 4095), 1, 0), 2, 0), 1, 1), 2, 0), 4, 10), 1, 0), 3, 1), 1, 0), 1, 0), 1, 0), 1, 0), 13, i + 7), 11, 2047), 2, 0);
        bytebuffer.put((byte)(int)(l >>> 48 & 255L));
        bytebuffer.put((byte)(int)(l >>> 40 & 255L));
        bytebuffer.put((byte)(int)(l >>> 32 & 255L));
        bytebuffer.put((byte)(int)(l >>> 24 & 255L));
        bytebuffer.put((byte)(int)(l >>> 16 & 255L));
        bytebuffer.put((byte)(int)(l >>> 8 & 255L));
        bytebuffer.put((byte)(int)l);
    }

    private void startAndConfigureCodec(MediaCodec mediacodec, MediaFormat mediaformat)
    {
        try
        {
            mCodec = mediacodec;
            mCodec.configure(mediaformat, null, null, 1);
            mCodec.start();
            mCodecInputBuffers = mCodec.getInputBuffers();
            mCodecOutputBuffers = mCodec.getOutputBuffers();
        }
        // Misplaced declaration of an exception variable
        catch (MediaCodec mediacodec)
        {
            mCodec = null;
            mCodecInputBuffers = null;
            mCodecOutputBuffers = null;
        }
        if (mCodec == null)
        {
            throw new IllegalArgumentException("Could not create codec");
        } else
        {
            return;
        }
    }

    private void startCodecByMimeType(String s, MediaFormat mediaformat)
    {
        startAndConfigureCodec(MediaCodec.createEncoderByType(s), mediaformat);
    }

    private void startCodecByName(String s, MediaFormat mediaformat)
    {
        startAndConfigureCodec(MediaCodec.createByCodecName(s), mediaformat);
    }

    private void stop()
    {
        if (mCodec != null)
        {
            mCodec.stop();
        }
    }

    private static long writeBits(long l, int i, int j)
    {
        return -1L >>> 64 - i & (long)j | l << i;
    }

    public void close()
    {
        emp.a(mStream);
        stop();
        release();
    }

    public void finalize()
    {
        if (mCodec != null)
        {
            close();
            throw new IllegalStateException("no one closed");
        } else
        {
            return;
        }
    }

    public int getTotalRead()
    {
        return mTotalRead;
    }

    public int read()
    {
        throw new UnsupportedOperationException("Single-byte read not supported");
    }

    public int read(byte abyte0[])
    {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
    {
        int i1 = 0;
        boolean flag;
        if (mEof && !mDataIn.hasRemaining())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        for (; !flag && (mCurrentOutputBufferIndex == -1 || !mCodecOutputBuffers[mCurrentOutputBufferIndex].hasRemaining()); encodeStream()) { }
        if (mEof)
        {
            return -1;
        }
        int k = i;
        int l = j;
        if (mPendingHeader.hasRemaining())
        {
            i1 = Math.min(j, mPendingHeader.remaining());
            mPendingHeader.get(abyte0, i, i1);
            k = i + i1;
            l = j - i1;
        }
        ByteBuffer bytebuffer = mCodecOutputBuffers[mCurrentOutputBufferIndex];
        f.b(bytebuffer.hasRemaining());
        i = Math.min(l, bytebuffer.remaining());
        bytebuffer.get(abyte0, k, i);
        return i + i1;
    }
}
