// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.mediacoder;

import java.nio.ShortBuffer;

// Referenced classes of package com.lifevibes.mediacoder:
//            LVMediaCoderFactory, LVMediaCoderImpl

public class LVMediaCoderSFAudioEncoder
{

    private static int MAX_DSI_LEN = 0;
    static int MAX_FRAME_LEN = 0;
    private static final String TAG = "LVSF_AudioEncoder";
    static int mAudioBitrate = 0;
    static byte mAudioDataInput[];
    static String mAudioMime;
    static int mChannels = 0;
    static byte mOutEncodedData[];
    static int mSampleRate = 0;
    private int LVSFAudioContext;

    public LVMediaCoderSFAudioEncoder()
    {
        LVSFAudioContext = 0;
    }

    private static native int LVSFAudioEncoderEncode(int i, byte abyte0[], byte abyte1[], int j);

    private static native int LVSFAudioEncoderGetDSIInfo(int i, byte abyte0[]);

    private static native int LVSFAudioEncoderInit(int i, int j, int k);

    private static native int LVSFAudioEncoderStop(int i);

    public static LVMediaCoderSFAudioEncoder create(String s)
    {
        mAudioMime = s;
        if (!s.equalsIgnoreCase("audio/mp4a-latm"))
        {
            LVMediaCoderFactory.printLog("[LVSF_AudioEncoder] Creation not supported for non AAC mime", true);
            return null;
        } else
        {
            return new LVMediaCoderSFAudioEncoder();
        }
    }

    public void configure(int i, int j, int k)
    {
        mAudioBitrate = i;
        mSampleRate = j;
        mChannels = k;
    }

    public ShortBuffer encode(byte abyte0[])
    {
        int i = mChannels;
        int k = LVSFAudioEncoderEncode(LVSFAudioContext, abyte0, mOutEncodedData, i * 2048);
        abyte0 = ShortBuffer.allocate(k);
        short aword0[] = new short[k];
        for (int j = 0; j < k; j++)
        {
            aword0[j] = mOutEncodedData[j];
        }

        abyte0.put(aword0);
        return abyte0;
    }

    public void getDSI()
    {
        byte abyte0[] = new byte[MAX_DSI_LEN];
        if (LVSFAudioContext != 0)
        {
            int j = LVSFAudioEncoderGetDSIInfo(LVSFAudioContext, abyte0);
            LVMediaCoderImpl.mAudioDSI = new byte[j];
            for (int i = 0; i < j; i++)
            {
                LVMediaCoderImpl.mAudioDSI[i] = abyte0[i];
            }

        }
    }

    public void start()
    {
        LVSFAudioContext = LVSFAudioEncoderInit(mAudioBitrate, mSampleRate, mChannels);
        if (LVSFAudioContext == 0)
        {
            throw new IllegalStateException("LVSF Native ICS Audio Encoder creation failed ..!");
        } else
        {
            return;
        }
    }

    public void stop()
    {
        if (LVSFAudioEncoderStop(LVSFAudioContext) != 0)
        {
            throw new IllegalStateException("LVSF Native ICS Audio Encoder stop failed ..!");
        } else
        {
            return;
        }
    }

    static 
    {
        MAX_DSI_LEN = 128;
        MAX_FRAME_LEN = 4096;
        mOutEncodedData = new byte[MAX_FRAME_LEN];
    }
}
