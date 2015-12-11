// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.mediacoder;

import java.nio.ByteBuffer;

// Referenced classes of package com.lifevibes.mediacoder:
//            LVMediaCoderFactory, LVMediaCoderImpl

public class LVMediaCoderSFVideoEncoder
{
    public static final class LVSF_mediaDSI
    {

        public byte bufferDSI[];
        public int bufferSize;

        public LVSF_mediaDSI()
        {
        }
    }


    public static int LVMC_STREAM_AUDIO = 0;
    public static int LVMC_STREAM_VIDEO = 0;
    private static int LVSFVideoContext = 0;
    private static int MAX_DSI_LEN = 0;
    static int MAX_FRAME_LEN = 0;
    private static final String TAG = "LVSF_VideoEncoder";
    static int mFrameHeight = 0;
    static int mFrameWidth = 0;
    static int mFramerate = 0;
    static byte mOutEncodedData[];
    static int mVideoBitrate = 0;
    static String mVideoMime;

    public LVMediaCoderSFVideoEncoder()
    {
    }

    private static native int LVSFVideoEncoderInit(LVSF_mediaDSI lvsf_mediadsi, int i, int j, int k, int l);

    private static native int LifeVibesICSMediaCoderDestroy(int i);

    private static native int LifeVibesICSMediaCoderEncode(int i, byte abyte0[], byte abyte1[], boolean flag);

    private static native int LifeVibesICSPollEncoderForOutput(int i, byte abyte0[]);

    public static LVMediaCoderSFVideoEncoder create(String s)
    {
        mVideoMime = s;
        if (!s.equalsIgnoreCase("video/avc"))
        {
            LVMediaCoderFactory.printLog("[LVSF_VideoEncoder] Creation not supported for non H264 mime", true);
            return null;
        } else
        {
            return new LVMediaCoderSFVideoEncoder();
        }
    }

    public void configure(int i, int j, int k, int l)
    {
        mFrameWidth = j;
        mFrameHeight = i;
        mVideoBitrate = k;
        mFramerate = l;
        MAX_FRAME_LEN = (int)((double)(mFrameHeight * mFrameWidth) * 0.80000000000000004D);
        mOutEncodedData = new byte[MAX_FRAME_LEN];
    }

    public void encode(byte abyte0[], boolean flag)
    {
        LifeVibesICSMediaCoderEncode(LVSFVideoContext, abyte0, mOutEncodedData, flag);
    }

    public ByteBuffer pollEncoderForOutput()
    {
        int j = LifeVibesICSPollEncoderForOutput(LVSFVideoContext, mOutEncodedData);
        if (j == 0)
        {
            LVMediaCoderFactory.printLog("[LVSF_VideoEncoder] LVSF Native ICS Video Encode poll has DataLen = 0 !", true);
            return null;
        }
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVSF_VideoEncoder] LVSF Native ICS Video Encode poll has DataLen = ").append(j).toString(), false);
        byte abyte0[] = new byte[j];
        for (int i = 0; i < j; i++)
        {
            abyte0[i] = mOutEncodedData[i];
        }

        return ByteBuffer.wrap(abyte0);
    }

    public void start()
    {
        LVSF_mediaDSI lvsf_mediadsi = new LVSF_mediaDSI();
        lvsf_mediadsi.bufferDSI = new byte[MAX_DSI_LEN];
        lvsf_mediadsi.bufferSize = 0;
        LVSFVideoContext = LVSFVideoEncoderInit(lvsf_mediadsi, mFrameWidth, mFrameHeight, mVideoBitrate, mFramerate);
        if (LVSFVideoContext == 0)
        {
            LVMediaCoderFactory.printLog("[LVSF_VideoEncoder] LVSF Native ICS Video Encoder creation failed", true);
            throw new IllegalStateException("LVSF Native ICS Video Encoder creation failed ..!");
        }
        LVMediaCoderImpl.mVideoDSI = new byte[lvsf_mediadsi.bufferSize];
        for (int i = 0; i < lvsf_mediadsi.bufferSize; i++)
        {
            LVMediaCoderImpl.mVideoDSI[i] = lvsf_mediadsi.bufferDSI[i];
        }

    }

    public void stop()
    {
        if (LifeVibesICSMediaCoderDestroy(LVSFVideoContext) != 0)
        {
            LVMediaCoderFactory.printLog("[LVSF_VideoEncoder] LVSF Native ICS Video stop failed ", true);
            throw new RuntimeException("LVSF Native ICS Video stop failed ..!");
        } else
        {
            return;
        }
    }

    static 
    {
        LVMC_STREAM_VIDEO = 1;
        LVMC_STREAM_AUDIO = 2;
        MAX_DSI_LEN = 128;
        LVSFVideoContext = 0;
    }
}
