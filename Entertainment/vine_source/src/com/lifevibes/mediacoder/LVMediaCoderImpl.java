// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.mediacoder;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.lifevibes.mediacoder:
//            LVMediaCoder, LVMediaCoderFactory, LVMediaCoderConfiguration, LVMediaCoderSFVideoEncoder, 
//            LVMediaCoderSFAudioEncoder, LVMediaCoderProperties, LVMediaCoderWriterJNI, ScriptC_Filters

public class LVMediaCoderImpl
    implements LVMediaCoder
{

    private static final String AAC_ADTS = "audio/mp4a-latm";
    private static final int AUDIO_SAMPLE_SIZE = 2;
    public static final String H264_AVC = "video/avc";
    private static final int PCM_SIZE_MONO = 2048;
    private static final int PCM_SIZE_STEREO = 4096;
    private static final String TAG = "LVMediaCoderImpl";
    static boolean isRunningOnICS;
    static byte mAudioDSI[];
    static byte mVideoDSI[];
    private static ByteBuffer outData;
    private Allocation ain;
    private Allocation ain2;
    private Allocation ain3;
    private Allocation ain4;
    private Allocation aout;
    private boolean correctVideoBitRate;
    private boolean isAudioEncoderRunning;
    private boolean isEndOfStream;
    private boolean isRecordingSession;
    private boolean isStride512Aligned;
    private boolean isUVInterchanged;
    private boolean isUVStride2KAligned;
    private boolean isVideoEncoderRunning;
    private boolean isYUVStride2KAligned;
    private android.media.MediaCodec.BufferInfo mAudioBufferInfo;
    private MediaCodec mAudioEncoder;
    private MediaFormat mAudioFormat;
    private int mAudioFrameDuration;
    private int mAudioFrameNumber;
    private int mAudioFramesRecorded;
    private android.media.MediaCodec.BufferInfo mBufferInfo;
    private LVMediaCoderConfiguration mConfiguration;
    private Context mContext;
    private LVMediaCoderSFAudioEncoder mICSAudioEncoder;
    private LVMediaCoderSFVideoEncoder mICSVideoEncoder;
    private LVMediaCoder.LVMediaCoderICSEncoderProgressListener mICSVideoEncoderListener;
    private ByteBuffer mInputAudioBuffers[];
    private byte mInputDataToRSFilter[];
    private ByteBuffer mInputVideoBuffers[];
    private ByteBuffer mOutBuffer;
    private ByteBuffer mOutputAudioBuffers[];
    private String mOutputFilePath;
    private byte mOutputFromRSFilter[];
    private FileOutputStream mOutputH264Dump;
    private ByteBuffer mOutputVideoBuffers[];
    private byte mPCMFrameData[];
    private int mRGBABufferSize;
    private int mRGBBufferSize;
    private RenderScript mRenderScript;
    private int mRetrievedEncodedFrameCount;
    private ScriptC_Filters mScript;
    private int mSonyXperiaZ1_Height;
    private int mSonyXperiaZ1_Width;
    private int mSuppliedEncodedFrameCount;
    private ArrayList mSupportedAudioCodecs;
    private int mSupportedColorFormat;
    private byte mVideoDataInput[];
    private MediaCodec mVideoEncoder;
    private MediaFormat mVideoFormat;
    private int mVideoFrameNumber;
    private int mVideoFramesRecorded;
    private int mWriterJNIContext;
    private int mYUVBufferSize;
    private byte mYUVData[];
    private boolean pullerFlagExit;
    private boolean run;
    private boolean skipExtraBytesAtStart;
    private byte tempBuffer[];
    private byte tempBuffer1[];

    public LVMediaCoderImpl(Context context, LVMediaCoderConfiguration lvmediacoderconfiguration)
        throws NullPointerException
    {
        run = false;
        pullerFlagExit = false;
        mVideoFrameNumber = 0;
        mAudioFrameNumber = 0;
        if (context == null)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Context is NULL.", true);
            throw new NullPointerException("Context is NULL.");
        }
        if (lvmediacoderconfiguration == null)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Configuration is NULL.", true);
            throw new NullPointerException("Configuration is NULL.");
        }
        mConfiguration = lvmediacoderconfiguration;
        if (!isRunningOnICS)
        {
            configure(context, mConfiguration);
        }
    }

    private void cancelEncodingICS()
    {
        if (!isVideoEncoderRunning || !isAudioEncoderRunning)
        {
            throw new IllegalStateException("Encoder is not running.");
        } else
        {
            mSuppliedEncodedFrameCount = mRetrievedEncodedFrameCount;
            return;
        }
    }

    private void checkAudioCodecs()
    {
        int i;
        mSupportedAudioCodecs = new ArrayList();
        i = 0;
_L2:
        MediaCodecInfo mediacodecinfo;
        if (i >= MediaCodecList.getCodecCount())
        {
            break MISSING_BLOCK_LABEL_207;
        }
        mediacodecinfo = MediaCodecList.getCodecInfoAt(i);
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Encoder ").append(i).append(": ").append(mediacodecinfo.getName()).toString(), false);
        if (mediacodecinfo.isEncoder())
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        String as[];
        int j;
        int k;
        as = mediacodecinfo.getSupportedTypes();
        k = as.length;
        j = 0;
_L4:
        if (j < k)
        {
label0:
            {
                String s = as[j];
                if (!s.toLowerCase(Locale.ENGLISH).contains("mp4a-latm"))
                {
                    break label0;
                }
                mSupportedAudioCodecs.add(mediacodecinfo.getName());
                LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Encoder ").append(i).append("/").append(MediaCodecList.getCodecCount()).append(": ").append(mediacodecinfo.getName()).append(" supports [").append(s).append("]").toString(), false);
            }
        }
          goto _L3
        j++;
          goto _L4
          goto _L3
    }

    private void checkDevice()
    {
        if (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("lge") && Build.BOARD.toLowerCase(Locale.ENGLISH).contains("hammerhead") || Build.BOARD.toLowerCase(Locale.ENGLISH).contains("msm8974") || Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("lge") && Build.MODEL.toLowerCase(Locale.ENGLISH).contains("lg-d802"))
        {
            correctVideoBitRate = true;
        }
        if (android.os.Build.VERSION.SDK_INT < 19) goto _L2; else goto _L1
_L1:
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Application is running on Android version: ").append(android.os.Build.VERSION.SDK_INT).append(". No need of special color-conv filters.").toString(), false);
_L4:
        return;
_L2:
        if (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("asus") && Build.BOARD.equalsIgnoreCase("flo"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on ASUS on flo board!", false);
            isYUVStride2KAligned = true;
            return;
        }
        if (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("motorola") && Build.BOARD.equalsIgnoreCase("msm8960"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on Motorola on msm8960 board!", false);
            isUVStride2KAligned = true;
            return;
        }
        if (!Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("htc") || !Build.MODEL.toLowerCase(Locale.ENGLISH).contains("htc one"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (Build.BOARD.toLowerCase(Locale.ENGLISH).equals("apq8064"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on HTC One [APQ8064] with 2048 bit align stride!", false);
            isYUVStride2KAligned = true;
            return;
        }
        if (Build.HARDWARE.equals("m7"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on HTC One [APQ8064T] with 2048 bit align stride!", false);
            isUVStride2KAligned = true;
            return;
        }
        if (Build.HARDWARE.equals("elite") || Build.HARDWARE.equals("ville"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on HTC One X/S with 2048 bit align stride!", false);
            isUVStride2KAligned = true;
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("sony"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (Build.BOARD.equalsIgnoreCase("MSM8660_SURF"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on SONY device with 2048 bit align stride!", false);
            isYUVStride2KAligned = true;
        } else
        if (Build.BOARD.toLowerCase(Locale.ENGLISH).contains("msm8974"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on SONY XPeria Z1 with 512 bit align stride!", false);
            isStride512Aligned = true;
        }
        if (Build.BOARD.equalsIgnoreCase("MSM8226"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on SONY XPeria Z1 with bit rate correction!", false);
            correctVideoBitRate = true;
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (!Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("lge"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (Build.BOARD.equalsIgnoreCase("MAKO"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on LGE Nexus 4 with 2048 bit aligned stride!", false);
            isYUVStride2KAligned = true;
            return;
        }
        if (Build.MODEL.toLowerCase(Locale.ENGLISH).contains("lg-d802"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on LGE G2 with 512 bit aligned stride!", false);
            isStride512Aligned = true;
            return;
        }
        if (Build.BOARD.equalsIgnoreCase("gee"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on LG device on gee board!", false);
            isUVStride2KAligned = true;
            return;
        }
        if (Build.BOARD.equalsIgnoreCase("u2"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on LG device that returns extra zeores with 1st encoded frame!", false);
            skipExtraBytesAtStart = true;
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
        if (!Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("samsung"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (Build.BOARD.toLowerCase(Locale.ENGLISH).contains("smdk4x12") && Build.MODEL.toLowerCase(Locale.ENGLISH).contains("gt-i9300") && android.os.Build.VERSION.SDK_INT < 18)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on Samsung smdk4x12 with UV-planes interchanged!", false);
            isUVInterchanged = true;
            return;
        }
        if (Build.BOARD.equalsIgnoreCase("msm8960"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on Samsung MSM8960 board!", false);
            isUVStride2KAligned = true;
            return;
        }
        if (Build.BOARD.equalsIgnoreCase("piranha"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on Samsung Piranha board!", false);
            skipExtraBytesAtStart = true;
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
        if (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("huawei") && Build.BOARD.toLowerCase(Locale.ENGLISH).contains("y301a1"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on Huawei device, which has UV planes interleaved!", false);
            isUVInterchanged = true;
            return;
        }
        if (Build.BOARD.toLowerCase(Locale.ENGLISH).contains("msm8974"))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Application is running on Qualcomm MSM8974!", false);
            isYUVStride2KAligned = true;
            return;
        }
        if (true) goto _L4; else goto _L8
_L8:
    }

    private void configure(Context context, LVMediaCoderConfiguration lvmediacoderconfiguration)
    {
        LVMediaCoderFactory.printLog("[LVMediaCoderImpl] configure called!", false);
        mContext = context;
        mRGBBufferSize = mConfiguration.videoWidth * mConfiguration.videoHeight * 3;
        mRGBABufferSize = mConfiguration.videoWidth * mConfiguration.videoHeight * 4;
        mYUVBufferSize = mRGBBufferSize / 2;
        checkDevice();
        checkAudioCodecs();
        mVideoFormat = MediaFormat.createVideoFormat("video/avc", mConfiguration.videoWidth, mConfiguration.videoHeight);
        mVideoFormat.setInteger("color-format", getColorFormat());
        if (correctVideoBitRate)
        {
            mVideoFormat.setInteger("bitrate", mConfiguration.videoBitRate * 8);
        } else
        {
            mVideoFormat.setInteger("bitrate", mConfiguration.videoBitRate);
        }
        mVideoFormat.setInteger("frame-rate", mConfiguration.videoFrameRate);
        mVideoFormat.setInteger("i-frame-interval", mConfiguration.videoIFrameInterval);
        mVideoFormat.setInteger("aac-profile", 1);
        mAudioFormat = new MediaFormat();
        mAudioFormat.setString("mime", "audio/mp4a-latm");
        mAudioFormat.setInteger("bitrate", mConfiguration.audioBitRate);
        mAudioFormat.setInteger("channel-count", mConfiguration.audioChannelCount);
        mAudioFormat.setInteger("sample-rate", mConfiguration.audioSampleRate);
        mAudioFormat.setInteger("aac-profile", 2);
    }

    private void configureLVSFSession()
    {
        mRGBBufferSize = mConfiguration.videoWidth * mConfiguration.videoHeight * 3;
        mRGBABufferSize = mConfiguration.videoWidth * mConfiguration.videoHeight * 4;
        mYUVBufferSize = mRGBBufferSize / 2;
        mICSVideoEncoder = LVMediaCoderSFVideoEncoder.create("video/avc");
        mICSVideoEncoder.configure(mConfiguration.videoHeight, mConfiguration.videoWidth, mConfiguration.videoBitRate, mConfiguration.videoFrameRate);
        mICSVideoEncoder.start();
        isVideoEncoderRunning = true;
        mRetrievedEncodedFrameCount = 0;
        mSuppliedEncodedFrameCount = 0;
        mICSAudioEncoder = LVMediaCoderSFAudioEncoder.create("audio/mp4a-latm");
        mICSAudioEncoder.configure(mConfiguration.audioBitRate, mConfiguration.audioSampleRate, mConfiguration.audioChannelCount);
        mICSAudioEncoder.start();
        isAudioEncoderRunning = true;
        mICSAudioEncoder.getDSI();
    }

    private void configureSession()
        throws Exception
    {
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] \nBOARD = ").append(Build.BOARD).append("\nBOOTLOADER = ").append(Build.BOOTLOADER).append("\nBRAND = ").append(Build.BRAND).append("\nCPU_ABI = ").append(Build.CPU_ABI).append("\nCPU_ABI2 = ").append(Build.CPU_ABI2).append("\nDEVICE = ").append(Build.DEVICE).append("\nAndroid Version = ").append(android.os.Build.VERSION.SDK_INT).append("\nFINGERPRINT = ").append(Build.FINGERPRINT).append("\nHARDWARE = ").append(Build.HARDWARE).append("\nHOST = ").append(Build.HOST).append("\nID = ").append(Build.ID).append("\nMANUFACTURER = ").append(Build.MANUFACTURER).append("\nMODEL = ").append(Build.MODEL).append("\nPRODUCT = ").append(Build.PRODUCT).append("\nSERIAL = ").append(Build.SERIAL).append("\nTAGS = ").append(Build.TAGS).append("\nTIME = ").append(Build.TIME).append("\nTYPE = ").append(Build.TYPE).append("\nUNKNOWN = ").append("unknown").append("\nUSER = ").append(Build.USER).append("\ngetRadioVersion() = ").append(Build.getRadioVersion()).toString(), false);
        generateVideoDSI();
        if (mVideoEncoder == null)
        {
            mVideoEncoder = MediaCodec.createEncoderByType("video/avc");
            mVideoEncoder.configure(mVideoFormat, null, null, 1);
            mVideoEncoder.start();
            mInputVideoBuffers = mVideoEncoder.getInputBuffers();
            mOutputVideoBuffers = mVideoEncoder.getOutputBuffers();
            isVideoEncoderRunning = true;
        }
        if (isAudioEncoderRunning && mAudioEncoder != null) goto _L2; else goto _L1
_L1:
        mAudioEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
        mAudioEncoder.configure(mAudioFormat, null, null, 1);
_L4:
        mAudioEncoder.start();
        mInputAudioBuffers = mAudioEncoder.getInputBuffers();
        mOutputAudioBuffers = mAudioEncoder.getOutputBuffers();
        isAudioEncoderRunning = true;
_L2:
        generateAudioDSI();
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Session configuration_______________\n\t\t\t\t Is Recording ON:\t").append(isRecordingSession).append("\n\t\t\t\t Color Format:\t\t").append(mVideoFormat.getInteger("color-format")).append("\n\t\t\t\t Video Resolution:\t").append(mConfiguration.videoWidth).append("x").append(mConfiguration.videoHeight).append("\n\t\t\t\t Video BitRate:\t\t").append(mVideoFormat.getInteger("bitrate")).append("\n\t\t\t\t Video Frame Rate:\t").append(mVideoFormat.getInteger("frame-rate")).append("\n\t\t\t\t Video I-Frame Int:\t").append(mVideoFormat.getInteger("i-frame-interval")).append("\n\t\t\t\t Audio Bit Rate:\t").append(mAudioFormat.getInteger("bitrate")).append("\n\t\t\t\t Audio Channels:\t").append(mAudioFormat.getInteger("channel-count")).append("\n\t\t\t\t Audio Sample Rate:\t").append(mAudioFormat.getInteger("sample-rate")).toString(), false);
        return;
        Exception exception;
        exception;
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] ").append(exception.toString()).toString(), true);
        Iterator iterator = mSupportedAudioCodecs.iterator();
        String s;
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            s = (String)iterator.next();
            try
            {
                if (mAudioEncoder != null)
                {
                    mAudioEncoder.release();
                }
                LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] ").append(exception.toString()).append(", Trying to instantiate AudioEncoder with ").append(s).toString(), false);
                mAudioEncoder = MediaCodec.createByCodecName(s);
                mAudioEncoder.configure(mAudioFormat, null, null, 1);
                continue; /* Loop/switch isn't completed */
            }
            catch (Exception exception1)
            {
                LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] ").append(exception.toString()).toString(), true);
            }
        } while (mSupportedAudioCodecs.indexOf(s) != mSupportedAudioCodecs.size() - 1);
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] ").append(exception.toString()).append(", AudioEncoder creation failed with available audio codecs on the device. Try with different audio parameters.").toString(), true);
        throw new IllegalStateException("AudioEncoder creation failed with available audio codecs on the device. Try with different audio parameters.");
        if (true) goto _L4; else goto _L3
_L3:
    }

    private byte[] convertICSRGBToYUV(ByteBuffer bytebuffer, int i)
    {
        mRGBBufferSize = mConfiguration.videoWidth * mConfiguration.videoHeight * 3;
        mRGBABufferSize = mConfiguration.videoWidth * mConfiguration.videoHeight * 4;
        mYUVBufferSize = mRGBBufferSize / 2;
        if (mVideoDataInput != null) goto _L2; else goto _L1
_L1:
        if (i != 0) goto _L4; else goto _L3
_L3:
        mVideoDataInput = new byte[mRGBBufferSize];
_L2:
        mYUVData = new byte[mRGBBufferSize / 2];
        bytebuffer.get(mVideoDataInput);
        if (LVMediaCoderProperties.DUMPS)
        {
            LVMediaCoderFactory.dumpInputVideoData(mVideoDataInput);
        }
        LVMediaCoderWriterJNI.RGB888toYUV420WithPlanar(mVideoDataInput, mYUVData, mConfiguration.videoWidth, mConfiguration.videoHeight, i);
        return mYUVData;
_L4:
        if (i == 1)
        {
            mVideoDataInput = new byte[mRGBABufferSize];
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private byte[] convertRGBToYUV(ByteBuffer bytebuffer, int i)
    {
        if (mVideoDataInput == null)
        {
            if (i == 0)
            {
                mVideoDataInput = new byte[mRGBBufferSize];
            } else
            if (i == 1)
            {
                mVideoDataInput = new byte[mRGBABufferSize];
            }
        }
        bytebuffer.get(mVideoDataInput);
        if (LVMediaCoderProperties.DUMPS)
        {
            LVMediaCoderFactory.dumpInputVideoData(mVideoDataInput);
        }
        if (isStride512Aligned)
        {
            if (mYUVData == null)
            {
                if (mConfiguration.videoWidth % 128 != 0)
                {
                    mSonyXperiaZ1_Width = (mConfiguration.videoWidth / 128 + 1) * 128;
                } else
                {
                    mSonyXperiaZ1_Width = mConfiguration.videoWidth;
                }
                if (mConfiguration.videoHeight % 32 != 0)
                {
                    mSonyXperiaZ1_Height = (mConfiguration.videoHeight / 32 + 1) * 32;
                } else
                {
                    mSonyXperiaZ1_Height = mConfiguration.videoHeight;
                }
                mYUVData = new byte[(mSonyXperiaZ1_Width * mSonyXperiaZ1_Height * 3) / 2];
            }
            LVMediaCoderWriterJNI.RGB888toYUV420WithStride512Aligned(mVideoDataInput, mYUVData, mSonyXperiaZ1_Width, mSonyXperiaZ1_Height, mConfiguration.videoWidth, mConfiguration.videoHeight, i);
        } else
        if (isYUVStride2KAligned)
        {
            if (mYUVData == null)
            {
                int l = (mConfiguration.videoWidth * mConfiguration.videoHeight) % 2048;
                int j = l;
                if (l > 0)
                {
                    j = 2048 - l;
                }
                int j1 = ((mConfiguration.videoWidth * mConfiguration.videoHeight) / 2) % 2048;
                l = j;
                if (j1 > 0)
                {
                    l = j + (2048 - j1);
                }
                mYUVData = new byte[mYUVBufferSize + l];
            }
            LVMediaCoderWriterJNI.RGB888toYUV420WithSemiPlanar(mVideoDataInput, mYUVData, mConfiguration.videoWidth, mConfiguration.videoHeight, i);
        } else
        if (isUVStride2KAligned)
        {
            if (mYUVData == null)
            {
                int i1 = (mConfiguration.videoWidth * mConfiguration.videoHeight) % 2048;
                LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Calling HTCOne stride:").append(i1).toString(), false);
                int k = i1;
                if (i1 > 0)
                {
                    k = 2048 - i1;
                }
                mYUVData = new byte[mYUVBufferSize + k];
            }
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Calling HTCOne filter....", false);
            LVMediaCoderWriterJNI.RGB888toYUV420WithUVStride2KAligned(mVideoDataInput, mYUVData, mConfiguration.videoWidth, mConfiguration.videoHeight, i);
        } else
        {
            if (mYUVData == null)
            {
                mYUVData = new byte[mYUVBufferSize];
            }
            if (mSupportedColorFormat == 19)
            {
                LVMediaCoderWriterJNI.RGB888toYUV420WithPlanar(mVideoDataInput, mYUVData, mConfiguration.videoWidth, mConfiguration.videoHeight, i);
            } else
            if (isUVInterchanged)
            {
                LVMediaCoderWriterJNI.RGB888toYUV420WithUVInterchanged(mVideoDataInput, mYUVData, mConfiguration.videoWidth, mConfiguration.videoHeight, i);
            } else
            {
                LVMediaCoderWriterJNI.RGB888toYUV420WithSemiPlanar(mVideoDataInput, mYUVData, mConfiguration.videoWidth, mConfiguration.videoHeight, i);
            }
        }
        return mYUVData;
    }

    private byte[] convertRGBToYUVinRS(ByteBuffer bytebuffer, int i)
    {
        if (mVideoDataInput == null)
        {
            if (i == 0)
            {
                mVideoDataInput = new byte[mRGBBufferSize];
            } else
            if (i == 1)
            {
                mVideoDataInput = new byte[mRGBABufferSize];
            }
        }
        bytebuffer.get(mVideoDataInput);
        if (LVMediaCoderProperties.DUMPS)
        {
            LVMediaCoderFactory.dumpInputVideoData(mVideoDataInput);
        }
        if (mYUVData == null)
        {
            if (isStride512Aligned)
            {
                mYUVData = new byte[0x5a000];
            } else
            {
                mYUVData = new byte[mYUVBufferSize];
            }
        }
        if (i == 0)
        {
            if (mInputDataToRSFilter == null)
            {
                mInputDataToRSFilter = new byte[mVideoDataInput.length + mVideoDataInput.length / 3];
            }
            int j = 0;
            for (i = 0; j < mVideoDataInput.length; i += 4)
            {
                mInputDataToRSFilter[i] = mVideoDataInput[j];
                mInputDataToRSFilter[i + 1] = mVideoDataInput[j + 1];
                mInputDataToRSFilter[i + 2] = mVideoDataInput[j + 2];
                j += 3;
            }

        } else
        {
            if (mInputDataToRSFilter == null)
            {
                mInputDataToRSFilter = new byte[mVideoDataInput.length];
            }
            mInputDataToRSFilter = mVideoDataInput;
        }
        if (mOutputFromRSFilter == null)
        {
            mOutputFromRSFilter = new byte[mInputDataToRSFilter.length];
        }
        long l = System.currentTimeMillis();
        if (ain == null || aout == null)
        {
            bytebuffer = Element.RGB_888(mRenderScript);
            ain = Allocation.createSized(mRenderScript, bytebuffer, mInputDataToRSFilter.length / 4);
            ain2 = Allocation.createSized(mRenderScript, Element.U8(mRenderScript), mVideoDataInput.length);
            ain3 = Allocation.createSized(mRenderScript, Element.U8(mRenderScript), mVideoDataInput.length);
            ain4 = Allocation.createSized(mRenderScript, Element.U8(mRenderScript), 0x70800);
            aout = Allocation.createSized(mRenderScript, bytebuffer, mInputDataToRSFilter.length / 4);
            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Time taken for setting up RS: ").append(System.currentTimeMillis() - l).toString(), false);
        }
        if (tempBuffer == null)
        {
            tempBuffer = new byte[0xa8c00];
            tempBuffer1 = new byte[0x70800];
        }
        ain2.copyFrom(mVideoDataInput);
        mScript.set_input(ain2);
        mScript.forEach_RGB888YUV444(ain);
        mScript.set_output(ain3);
        mScript.forEach_YUVPackedToPlanar(ain, aout);
        mScript.set_output1(ain3);
        mScript.set_output2(ain4);
        if (mSupportedColorFormat == 19)
        {
            mScript.forEach_YUV444ToYUV420(ain4);
        } else
        if (mSupportedColorFormat == 21)
        {
            mScript.forEach_YUV444ToYUV420SemiPlanar(ain4);
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("RenderScript doesn't have color conversion filter for Color Format: ").append(mSupportedColorFormat).toString());
        }
        ain3.copyTo(tempBuffer);
        ain4.copyTo(tempBuffer1);
        System.arraycopy(tempBuffer, 0, mYUVData, 0, 0x38400);
        System.arraycopy(tempBuffer1, 0, mYUVData, 0x38400, 0x1c200);
        return mYUVData;
    }

    private void deleteOutputFile()
    {
        File file = new File(mOutputFilePath);
        if (file.exists())
        {
            file.delete();
        }
    }

    private void dumpH264DataToFile(byte abyte0[])
        throws Exception
    {
        try
        {
            (new File("/mnt/sdcard/Twitter/")).mkdir();
            mOutputH264Dump = new FileOutputStream(new File("/mnt/sdcard/Twitter/Encoded Video.h264"), true);
            mOutputH264Dump.write(abyte0);
            mOutputH264Dump.flush();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
        }
        throw new Exception((new StringBuilder()).append("Error while dumping H264 data to file: ").append(abyte0.getMessage()).toString());
    }

    private ShortBuffer encodeAudioFrame(byte abyte0[], int i, int j)
    {
        int k1;
        if (!isAudioEncoderRunning)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] LVMediaCoder is not running.", true);
            throw new IllegalStateException("LVMediaCoder is not running.");
        }
        if (i + j > abyte0.length)
        {
            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Index out of bound. Length of pcmFrame is: ").append(abyte0.length).append(" however (Start + ShortCount) = ").append(i + j).toString(), true);
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Index out of bound. Length of pcmFrame is: ").append(abyte0.length).append(" Start + ShortCount = ").append(i + j).toString());
        }
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] \t\tencodeAudio(): Length of input pcmFrame# ").append(mAudioFrameNumber).append(": ").append(abyte0.length).append(", Length: ").append(j).append(", Position: ").append(i).toString(), false);
        if (mPCMFrameData == null)
        {
            if (mConfiguration.audioChannelCount == 1)
            {
                mPCMFrameData = new byte[2048];
            } else
            {
                mPCMFrameData = new byte[4096];
            }
        }
        if (mConfiguration.audioChannelCount == 1 && j == 2048)
        {
            int l1 = 0;
            for (int k = i; k < i + j; k++)
            {
                mPCMFrameData[l1] = abyte0[k];
                l1++;
            }

        } else
        if (mConfiguration.audioChannelCount == 1 && j != 2048)
        {
            if (j < 2048)
            {
                LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] \t\tencodeAudio(): pcmFrame# ").append(mAudioFrameNumber).append(": Length < PCM_MONO, hence wraping it in 2048 byte array.").toString(), false);
                int i2 = 0;
                for (int l = i; l < i + j; l++)
                {
                    mPCMFrameData[i2] = abyte0[l];
                    i2++;
                }

                for (; j < 2048; j++)
                {
                    mPCMFrameData[j] = 0;
                }

            } else
            {
                LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Check the size of input PCM data. For Mono PCM Data, this should be 1024 bytes.\nSize of input pcmFrame: ").append(j).toString(), true);
                throw new IllegalArgumentException("Check the size of input PCM data. For Mono PCM Data, this should be 1024 bytes.");
            }
        } else
        {
            if (mConfiguration.audioChannelCount == 2 && j != 4096)
            {
                LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Check the size of input PCM data. For Stereo PCM Data, this should be 2048 bytes.\nSize of input pcmFrame: ").append(j).toString(), true);
                throw new IllegalArgumentException("Check the size of input PCM data. For Stereo PCM Data, this should be 2048 bytes.");
            }
            if (mConfiguration.audioChannelCount == 2 && j == 4096)
            {
                int j2 = 0;
                for (int i1 = i; i1 < i + j; i1++)
                {
                    mPCMFrameData[j2] = abyte0[i1];
                    j2++;
                }

            }
        }
        if (LVMediaCoderProperties.DUMPS)
        {
            LVMediaCoderFactory.dumpInputAudioData(mPCMFrameData);
        }
        i = 0;
        do
        {
            do
            {
                do
                {
                    do
                    {
                        j = i;
                        if (i == 0)
                        {
                            int j1 = mAudioEncoder.dequeueInputBuffer(1L);
                            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] \t\tencodeAudio(): Audio Input BufferIndex: ").append(j1).toString(), false);
                            j = i;
                            if (j1 != -1)
                            {
                                j = i;
                                if (j1 >= 0)
                                {
                                    abyte0 = mPCMFrameData;
                                    mInputAudioBuffers[j1].clear();
                                    mInputAudioBuffers[j1].put(abyte0);
                                    mAudioEncoder.queueInputBuffer(j1, 0, abyte0.length, 0L, 0);
                                    j = 1;
                                    mAudioFrameNumber = mAudioFrameNumber + 1;
                                }
                            }
                        }
                        i = j;
                    } while (j == 0);
                    if (mAudioBufferInfo == null)
                    {
                        mAudioBufferInfo = new android.media.MediaCodec.BufferInfo();
                    }
                    k1 = mAudioEncoder.dequeueOutputBuffer(mAudioBufferInfo, 0L);
                    LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] \t\tencodeAudio(): Audio Output BufferIndex: ").append(k1).toString(), false);
                    i = j;
                } while (k1 == -1);
                i = j;
            } while (k1 == -2);
            if (k1 != -3)
            {
                break;
            }
            mOutputAudioBuffers = mAudioEncoder.getOutputBuffers();
            i = j;
        } while (true);
        ByteBuffer bytebuffer = mOutputAudioBuffers[k1];
        abyte0 = new byte[mAudioBufferInfo.size];
        bytebuffer.get(abyte0);
        bytebuffer.clear();
        if ((mAudioBufferInfo.flags & 4) == 0) goto _L2; else goto _L1
_L1:
        ShortBuffer shortbuffer;
        short aword0[];
        shortbuffer = ShortBuffer.allocate(abyte0.length);
        j = abyte0.length;
        aword0 = new short[j];
        for (i = 0; i < j; i++)
        {
            aword0[i] = abyte0[i];
        }

        break; /* Loop/switch isn't completed */
_L2:
        mAudioEncoder.releaseOutputBuffer(k1, false);
        if (mAudioFrameNumber == 1 && mAudioDSI == null)
        {
            mAudioDSI = abyte0;
            mAudioFrameNumber = mAudioFrameNumber + 1;
        }
        if (true) goto _L1; else goto _L3
_L3:
        shortbuffer.put(aword0);
        if (LVMediaCoderProperties.DEBUG)
        {
            try
            {
                writeAACToFile(abyte0);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new IllegalStateException(abyte0.getMessage());
            }
        }
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] \t\tencodeAudio(): Operation Ended! returning ").append(aword0.length).append(" bytes.").toString(), false);
        return shortbuffer;
    }

    private ShortBuffer encodeICSAudioFrame(byte abyte0[], int i, int j)
    {
        LVMediaCoderFactory.printLog("[LVMediaCoderImpl] ICS: encodeICSAudioFrame", false);
        if (!isAudioEncoderRunning)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] LVMediaCoder is not running.", true);
            throw new IllegalStateException("LVMediaCoder is not running.");
        }
        if (i + j > abyte0.length)
        {
            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Index out of bound. Length of pcmFrame is: ").append(abyte0.length).append(" however (Start + ShortCount) = ").append(i + j).toString(), true);
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Index out of bound. Length of pcmFrame is: ").append(abyte0.length).append(" Start + ShortCount = ").append(i + j).toString());
        }
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] \t\tencodeAudio(): Length of input pcmFrame# ").append(mAudioFrameNumber).append(": ").append(abyte0.length).append(", Length: ").append(j).append(", Position: ").append(i).toString(), false);
        if (mPCMFrameData == null)
        {
            if (mConfiguration.audioChannelCount == 1)
            {
                mPCMFrameData = new byte[2048];
            } else
            {
                mPCMFrameData = new byte[4096];
            }
        }
        if (mConfiguration.audioChannelCount == 1 && j == 2048)
        {
            int j1 = 0;
            for (int k = i; k < i + j; k++)
            {
                mPCMFrameData[j1] = abyte0[k];
                j1++;
            }

        } else
        if (mConfiguration.audioChannelCount == 1 && j != 2048)
        {
            if (j < 2048)
            {
                LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] \t\tencodeAudio(): pcmFrame# ").append(mAudioFrameNumber).append(": Length < PCM_MONO, hence wraping it in 2048 byte array.").toString(), false);
                int k1 = 0;
                for (int l = i; l < i + j; l++)
                {
                    mPCMFrameData[k1] = abyte0[l];
                    k1++;
                }

                for (; j < 2048; j++)
                {
                    mPCMFrameData[j] = 0;
                }

            } else
            {
                LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Check the size of input PCM data. For Mono PCM Data, this should be 1024 bytes.\nSize of input pcmFrame: ").append(j).toString(), true);
                throw new IllegalArgumentException("Check the size of input PCM data. For Mono PCM Data, this should be 1024 bytes.");
            }
        } else
        {
            if (mConfiguration.audioChannelCount == 2 && j != 4096)
            {
                LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Check the size of input PCM data. For Stereo PCM Data, this should be 2048 bytes.\nSize of input pcmFrame: ").append(j).toString(), true);
                throw new IllegalArgumentException("Check the size of input PCM data. For Stereo PCM Data, this should be 2048 bytes.");
            }
            if (mConfiguration.audioChannelCount == 2 && j == 4096)
            {
                int l1 = 0;
                for (int i1 = i; i1 < i + j; i1++)
                {
                    mPCMFrameData[l1] = abyte0[i1];
                    l1++;
                }

            }
        }
        if (LVMediaCoderProperties.DUMPS)
        {
            LVMediaCoderFactory.dumpInputAudioData(mPCMFrameData);
        }
        abyte0 = mICSAudioEncoder.encode(mPCMFrameData);
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] \t\tencodeAudio(): Operation Ended! returning ").append(abyte0.limit()).append(" bytes.").toString(), false);
        return abyte0;
    }

    private ByteBuffer encodeICSVideo(ByteBuffer bytebuffer, int i, boolean flag)
        throws IllegalStateException
    {
        if (i == 0 && bytebuffer.remaining() != mRGBBufferSize)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] encodeVideo(): Improper size of input RGB data.", true);
            throw new IllegalArgumentException("Improper size of input RGB data.");
        }
        if (i == 1 && bytebuffer.remaining() != mRGBABufferSize)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] encodeVideo(): Improper size of input RGBA data.", true);
            throw new IllegalArgumentException("Improper size of input RGBA data.");
        }
        LVMediaCoderFactory.printLog("[LVMediaCoderImpl] encodeVideo(): Called.", false);
        bytebuffer = convertICSRGBToYUV(bytebuffer, i);
        if (LVMediaCoderProperties.DEBUG)
        {
            try
            {
                writeYUVToFile(bytebuffer);
            }
            // Misplaced declaration of an exception variable
            catch (ByteBuffer bytebuffer)
            {
                bytebuffer.printStackTrace();
                throw new IllegalStateException(bytebuffer.getMessage());
            }
        }
        mICSVideoEncoder.encode(bytebuffer, flag);
        return null;
    }

    private void encodeVideoAsyncPull()
        throws IllegalStateException
    {
        if (!isRunningOnICS)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        this;
        JVM INSTR monitorenter ;
        (new Thread(new Runnable() )).start();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private ByteBuffer encodeYUVToH264(byte abyte0[])
        throws Exception
    {
        int i;
        if (abyte0 == null)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] encodeYUVToH264(): YUV Data is null", true);
            throw new IllegalArgumentException("YUV Data is null");
        }
        i = 0;
_L4:
        boolean flag;
        int l;
        do
        {
            do
            {
                do
                {
                    do
                    {
                        flag = i;
                        if (i == 0)
                        {
                            int j = mVideoEncoder.dequeueInputBuffer(1L);
                            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] encodeYUVToH264(): Video InputBufferIndex : ").append(j).append(" for frame# ").append(mVideoFrameNumber).toString(), false);
                            flag = i;
                            if (j != -1)
                            {
                                flag = i;
                                if (j >= 0)
                                {
                                    mInputVideoBuffers[j].clear();
                                    mInputVideoBuffers[j].put(abyte0);
                                    mVideoEncoder.queueInputBuffer(j, 0, abyte0.length, mVideoFrameNumber * 33, 0);
                                    flag = true;
                                    mVideoFrameNumber = mVideoFrameNumber + 1;
                                }
                            }
                        }
                        i = ((flag) ? 1 : 0);
                    } while (!flag);
                    if (mBufferInfo == null)
                    {
                        mBufferInfo = new BufferInfo();
                    }
                    l = mVideoEncoder.dequeueOutputBuffer(mBufferInfo, 0L);
                    if (SLog.sLogsOn)
                    {
                        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] encodeYUVToH264(): Video OutputBufferIndex : ").append(l).append(" for frame# ").append(mVideoFrameNumber).toString(), false);
                    }
                    i = ((flag) ? 1 : 0);
                } while (l == -1);
                i = ((flag) ? 1 : 0);
            } while (l == -2);
            if (l != -3)
            {
                break;
            }
            mOutputVideoBuffers = mVideoEncoder.getOutputBuffers();
            i = ((flag) ? 1 : 0);
        } while (true);
        ByteBuffer bytebuffer = mOutputVideoBuffers[l];
        if (skipExtraBytesAtStart && mVideoFrameNumber == 3)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            i = mBufferInfo.size + mVideoDSI.length;
            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] OutputBufferSize: ").append(bytebuffer.remaining()).append("mBufferInfo.size: ").append(mBufferInfo.size).append("mVideoDSI.length: ").append(mVideoDSI.length).toString(), false);
        } else
        {
            i = mBufferInfo.size;
        }
        if (mOutBuffer == null || mOutBuffer.capacity() < i)
        {
            mOutBuffer = ByteBuffer.allocate(i);
        }
        mOutBuffer.position(0);
        mOutBuffer.limit(i);
        for (int k = 0; k < i; k++)
        {
            mOutBuffer.put(bytebuffer.get());
        }

        bytebuffer.clear();
        if ((mBufferInfo.flags & 4) == 0) goto _L2; else goto _L1
_L1:
        LVMediaCoderFactory.printLog("[LVMediaCoderImpl] encodeYUVToH264(): BUFFER_FLAG_END_OF_STREAM. Breaking out!!!!", false);
_L3:
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] encodeYUVToH264(): Returning ").append(mOutBuffer.array().length).append(" bytes.").toString(), false);
        return mOutBuffer;
_L2:
        if (mOutBuffer.get(0) != 0 || mOutBuffer.get(1) != 0 || mOutBuffer.get(2) != 0 || mOutBuffer.get(3) != 1)
        {
            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] encodeYUVToH264(): Header missing! for Frame: ").append(mVideoFrameNumber).toString(), false);
        }
        mVideoEncoder.releaseOutputBuffer(l, false);
        mOutBuffer.position(0);
        if (mVideoFrameNumber == 1)
        {
            mVideoDSI = new byte[mOutBuffer.limit()];
            mOutBuffer.get(mVideoDSI);
            if (isRecordingSession && LVMediaCoderProperties.DEBUG)
            {
                (new File("/mnt/sdcard/Twitter/")).mkdir();
                File file = new File("/mnt/sdcard/Twitter/Encoded Video.h264");
                try
                {
                    mOutputH264Dump = new FileOutputStream(file);
                    mOutputH264Dump.write(mVideoDSI);
                    mOutputH264Dump.flush();
                    mOutputH264Dump.close();
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    abyte0.printStackTrace();
                    throw new Exception((new StringBuilder()).append("Error while writing VideoDSI to debug file: ").append(abyte0.getMessage()).toString());
                }
            }
            mVideoFrameNumber = mVideoFrameNumber + 1;
            i = 0;
            break; /* Loop/switch isn't completed */
        }
        i = ((flag) ? 1 : 0);
        if (mVideoFrameNumber <= 1) goto _L4; else goto _L3
    }

    private void generateAudioDSI()
    {
        ByteBuffer bytebuffer;
        if (mConfiguration.audioChannelCount == 1)
        {
            bytebuffer = ByteBuffer.allocate(2048);
            bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        } else
        {
            bytebuffer = ByteBuffer.allocate(4096);
        }
        encodeAudio(bytebuffer.array(), 0, bytebuffer.array().length);
    }

    private void generateVideoDSI()
        throws Exception
    {
        mVideoEncoder = MediaCodec.createEncoderByType("video/avc");
        mVideoEncoder.configure(mVideoFormat, null, null, 1);
        mVideoEncoder.start();
        mInputVideoBuffers = mVideoEncoder.getInputBuffers();
        mOutputVideoBuffers = mVideoEncoder.getOutputBuffers();
        byte abyte0[] = new byte[mYUVBufferSize];
        try
        {
            encodeYUVToH264(abyte0);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        mVideoEncoder.stop();
        mVideoEncoder.release();
        mVideoEncoder = null;
        mInputVideoBuffers = null;
        mOutputVideoBuffers = null;
        mVideoFrameNumber = 0;
        isVideoEncoderRunning = false;
    }

    private int getAudioTimeStamp(int i)
    {
        return mAudioFrameDuration * i;
    }

    private int getColorFormat()
    {
        Object obj;
        int i;
        int j;
        j = 0;
        obj = new ArrayList();
        i = 0;
_L5:
        if (i >= MediaCodecList.getCodecCount()) goto _L2; else goto _L1
_L1:
        MediaCodecInfo mediacodecinfo = MediaCodecList.getCodecInfoAt(i);
        if (mediacodecinfo.isEncoder()) goto _L4; else goto _L3
_L3:
        int k = j;
_L6:
        i++;
        j = k;
          goto _L5
_L4:
        String as[];
        int l;
        int i1;
        as = mediacodecinfo.getSupportedTypes();
        i1 = as.length;
        l = 0;
_L7:
        k = j;
        if (l < i1)
        {
label0:
            {
                if (!as[l].toLowerCase(Locale.ENGLISH).contains("avc"))
                {
                    break label0;
                }
                ((ArrayList) (obj)).add(mediacodecinfo);
                k = i;
            }
        }
          goto _L6
        l++;
          goto _L7
_L2:
        obj = MediaCodecList.getCodecInfoAt(j).getCapabilitiesForType("video/avc");
        j = 0;
        i = 0;
_L9:
        if (i >= ((android.media.MediaCodecInfo.CodecCapabilities) (obj)).colorFormats.length)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        k = ((android.media.MediaCodecInfo.CodecCapabilities) (obj)).colorFormats[i];
        switch (k)
        {
        default:
            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Skipping unsupported color format ").append(k).toString(), false);
            break;

        case 19: // '\023'
        case 20: // '\024'
        case 21: // '\025'
        case 39: // '\''
        case 2130706688: 
            break; /* Loop/switch isn't completed */
        }
_L10:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
        j = k;
          goto _L10
        if (true) goto _L9; else goto _L11
_L11:
        mSupportedColorFormat = j;
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Color format selected: ").append(mSupportedColorFormat).toString(), false);
        return j;
          goto _L6
    }

    private void writeAACToFile(byte abyte0[])
        throws Exception
    {
        (new File("mnt/sdcard/Twitter/")).mkdirs();
        Object obj = new File("mnt/sdcard/Twitter/Twitter_Audio.aac");
        try
        {
            obj = new FileOutputStream(((File) (obj)), true);
            ((FileOutputStream) (obj)).write(abyte0);
            ((FileOutputStream) (obj)).flush();
            ((FileOutputStream) (obj)).close();
            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] writeAACToFile(): ").append(abyte0.length).append(" bytes written to file.").toString(), false);
            return;
        }
        catch (Exception exception)
        {
            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] writeAACToFile(): Error writting ").append(abyte0.length).append(" bytes to file.").toString(), true);
        }
        throw new Exception((new StringBuilder()).append("writeAACToFile(): Error writting ").append(abyte0.length).append(" bytes to file.").toString());
    }

    private void writeYUVToFile(byte abyte0[])
        throws Exception
    {
        (new File("mnt/sdcard/Twitter/")).mkdirs();
        Object obj = new File((new StringBuilder()).append("mnt/sdcard/Twitter/YUV_CF_").append(mSupportedColorFormat).append(".yuv").toString());
        try
        {
            obj = new FileOutputStream(((File) (obj)), true);
            ((FileOutputStream) (obj)).write(abyte0);
            ((FileOutputStream) (obj)).flush();
            ((FileOutputStream) (obj)).close();
            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] writeYUVToFile(): ").append(abyte0.length).append(" bytes written to file.").toString(), false);
            return;
        }
        catch (Exception exception)
        {
            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] writeYUVToFile(): Error writting ").append(abyte0.length).append(" bytes to file.").toString(), true);
            throw new Exception((new StringBuilder()).append("Error writting ").append(abyte0.length).append(" bytes to file: ").append(exception.getMessage()).toString());
        }
    }

    public void cancel()
        throws IllegalStateException
    {
        if (isRunningOnICS)
        {
            cancelEncodingICS();
        } else
        if (mVideoEncoder == null || !isVideoEncoderRunning || mAudioEncoder == null || !isAudioEncoderRunning)
        {
            throw new IllegalStateException("Encoder is not running.");
        }
        stop();
        if (isRecordingSession)
        {
            deleteOutputFile();
        }
    }

    public ShortBuffer encodeAudio(byte abyte0[], int i, int j)
        throws IllegalStateException
    {
        if (isRunningOnICS)
        {
            return encodeICSAudioFrame(abyte0, i, j);
        } else
        {
            return encodeAudioFrame(abyte0, i, j);
        }
    }

    public ByteBuffer encodeVideo(ByteBuffer bytebuffer, int i)
        throws IllegalStateException
    {
        LVMediaCoderFactory.printLog("[LVMediaCoderImpl] encodeVideo(): Called.", false);
        if (isRunningOnICS)
        {
            throw new IllegalStateException("LVMediaCoder is running on ICS. Call encodeVideoAsync instead.");
        }
        if (!isVideoEncoderRunning)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] encodeVideo(): LVMediaCoder is not running.", true);
            throw new IllegalStateException("LVMediaCoder is not running.");
        }
        if (i == 0 && bytebuffer.remaining() != mRGBBufferSize)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] encodeVideo(): Improper size of input RGB data.", true);
            throw new IllegalArgumentException("Improper size of input RGB data.");
        }
        if (i == 1 && bytebuffer.remaining() != mRGBABufferSize)
        {
            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] encodeVideo(): Improper size of input RGBA data.").append(bytebuffer.remaining()).append(" bytes.").toString(), true);
            throw new IllegalArgumentException("Improper size of input RGBA data.");
        }
        bytebuffer = convertRGBToYUV(bytebuffer, i);
        if (LVMediaCoderProperties.DEBUG)
        {
            try
            {
                writeYUVToFile(bytebuffer);
            }
            // Misplaced declaration of an exception variable
            catch (ByteBuffer bytebuffer)
            {
                bytebuffer.printStackTrace();
                throw new IllegalStateException(bytebuffer.getMessage());
            }
        }
        try
        {
            bytebuffer = encodeYUVToH264(bytebuffer);
        }
        // Misplaced declaration of an exception variable
        catch (ByteBuffer bytebuffer)
        {
            bytebuffer.printStackTrace();
            throw new IllegalStateException(bytebuffer.getMessage());
        }
        if (LVMediaCoderProperties.DEBUG)
        {
            try
            {
                dumpH264DataToFile(bytebuffer.array());
            }
            // Misplaced declaration of an exception variable
            catch (ByteBuffer bytebuffer)
            {
                bytebuffer.printStackTrace();
                throw new IllegalStateException(bytebuffer.getMessage());
            }
        }
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] encodeVideo(): Returning ").append(bytebuffer.array().length).append(" bytes.").toString(), false);
        return bytebuffer;
    }

    public void encodeVideoAsync(ByteBuffer bytebuffer, int i, boolean flag)
        throws IllegalStateException
    {
        if (!isVideoEncoderRunning)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] encodeVideo(): LVMediaCoder is not running.", true);
            throw new IllegalStateException("LVMediaCoder is not running.");
        }
        if (isRunningOnICS)
        {
            if (!run)
            {
                encodeVideoAsyncPull();
                LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Starting encodeVideoAsyncPull()", false);
                run = true;
            }
            isEndOfStream = flag;
            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Sending RGB frame ").append(mSuppliedEncodedFrameCount).toString(), false);
            encodeICSVideo(bytebuffer, i, flag);
            mSuppliedEncodedFrameCount = mSuppliedEncodedFrameCount + 1;
            return;
        } else
        {
            throw new IllegalStateException("Method encodeVideoAsync is not supported on JB and above.");
        }
    }

    public LVMediaCoderConfiguration getConfiguration()
    {
        return mConfiguration;
    }

    public String getOutputFilePath()
    {
        return mOutputFilePath;
    }

    public void recordAudio(ShortBuffer shortbuffer)
        throws IllegalStateException
    {
        if (!isAudioEncoderRunning)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] LVMediaCoder is not running.", true);
            throw new IllegalStateException("LVMediaCoder is not running.");
        }
        if (!isRecordingSession)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Current session is not configured for audio-recording.", true);
            throw new IllegalStateException("Current session is not configured for audio-recording.");
        }
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] recordAudio(): Capacity of input aacFrame #").append(mAudioFramesRecorded).append(": ").append(shortbuffer.capacity()).append(" shorts, Remaining: ").append(shortbuffer.remaining()).toString(), false);
        int j = getAudioTimeStamp(mAudioFramesRecorded);
        mAudioFramesRecorded = mAudioFramesRecorded + 1;
        ByteBuffer bytebuffer = ByteBuffer.allocate(shortbuffer.remaining());
        short aword0[] = new short[shortbuffer.remaining()];
        shortbuffer.get(aword0);
        int k = aword0.length;
        for (int i = 0; i < k; i++)
        {
            bytebuffer.put((byte)aword0[i]);
        }

        shortbuffer = bytebuffer.array();
        if (mWriterJNIContext == 0)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] recordAudio(): WriterJNIContext is NULL", true);
            throw new IllegalArgumentException("recordAudio(): WriterJNIContext is NULL");
        } else
        {
            LVMediaCoderWriterJNI.LVMediaCoderWriterProcess(mWriterJNIContext, shortbuffer.length, j, j, shortbuffer, 1);
            return;
        }
    }

    public void recordVideo(ByteBuffer bytebuffer, int i)
        throws IllegalStateException
    {
        if (!isVideoEncoderRunning)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] LVMediaCoder is not running.", true);
            throw new IllegalStateException("LVMediaCoder is not running.");
        }
        if (!isRecordingSession)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Current session is not configured for video-recording.", true);
            throw new IllegalStateException("Current session is not configured for video-recording.");
        }
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] recordVideo(): Size of input h264Frame #").append(mVideoFramesRecorded).append(": ").append(bytebuffer.remaining()).append(" bytes. ").append("Position: ").append(bytebuffer.position()).append(" Limit: ").append(bytebuffer.limit()).append(" Capacity: ").append(bytebuffer.capacity()).toString(), false);
        byte abyte0[] = new byte[bytebuffer.remaining()];
        bytebuffer.get(abyte0);
        mVideoFramesRecorded = mVideoFramesRecorded + 1;
        if (mWriterJNIContext == 0)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] recordVideo(): WriterJNIContext is NULL", true);
            throw new IllegalArgumentException("recordVideo(): WriterJNIContext is NULL");
        } else
        {
            LVMediaCoderWriterJNI.LVMediaCoderWriterProcess(mWriterJNIContext, abyte0.length, i, i, abyte0, 0);
            return;
        }
    }

    public void setEncoderVideoAsyncListener(LVMediaCoder.LVMediaCoderICSEncoderProgressListener lvmediacodericsencoderprogresslistener)
    {
        mICSVideoEncoderListener = lvmediacodericsencoderprogresslistener;
    }

    public void startEncoding()
    {
        if (isAudioEncoderRunning || isVideoEncoderRunning)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] LVMediaCoder is already running.", true);
            throw new IllegalStateException("LVMediaCoder is already running.");
        }
        isRecordingSession = false;
        if (isRunningOnICS)
        {
            configureLVSFSession();
            return;
        }
        try
        {
            configureSession();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw new IllegalStateException(exception.getMessage());
        }
    }

    public void startRecording(String s)
    {
        if (isAudioEncoderRunning || isVideoEncoderRunning)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] LVMediaCoder is already running.", true);
            throw new IllegalStateException("LVMediaCoder is already running.");
        }
        if (s == null || s.equals(""))
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] Invalid output filepath", true);
            throw new IllegalArgumentException("Invalid output filepath parameter.");
        }
        mOutputFilePath = s;
        String as[] = mOutputFilePath.split("/");
        String s1 = "";
        for (int i = 0; i < as.length - 1; i++)
        {
            s1 = (new StringBuilder()).append(s1).append("/").toString();
            s1 = (new StringBuilder()).append(s1).append(as[i]).toString();
        }

        (new File(s1)).mkdirs();
        isRecordingSession = true;
        if (!isRunningOnICS) goto _L2; else goto _L1
_L1:
        configureLVSFSession();
_L4:
        if (mAudioFrameDuration == 0)
        {
            char c = '\u0400';
            if (mConfiguration.audioChannelCount == 2)
            {
                c = '\u0800';
            }
            mAudioFrameDuration = (c * 2 * 1000) / (mConfiguration.audioSampleRate * mConfiguration.audioChannelCount * 2);
        }
        mWriterJNIContext = LVMediaCoderWriterJNI.LVMediaCoderInitWriter(mOutputFilePath);
        if (mWriterJNIContext == 0)
        {
            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] LVMediaCoderInitWriter failed! ").append(s).toString(), true);
            throw new IllegalArgumentException((new StringBuilder()).append("LVMediaCoderInitWriter failed! ").append(s).toString());
        }
        break; /* Loop/switch isn't completed */
_L2:
        try
        {
            configureSession();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            throw new IllegalStateException(s.getMessage());
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (mVideoDSI == null)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] startRecording(): Problem getting the Video DSI.", true);
            throw new IllegalStateException("Problem getting the Video DSI.");
        }
        if (mAudioDSI == null)
        {
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] startRecording(): Problem getting the Audio DSI", true);
            throw new IllegalStateException("Problem getting the Audio DSI.");
        } else
        {
            LVMediaCoderWriterJNI.LVMediaCoderWriterAddStreamVideo(mWriterJNIContext, mVideoDSI, mConfiguration.videoWidth, mConfiguration.videoHeight, mVideoDSI.length);
            LVMediaCoderWriterJNI.LVMediaCoderWriterAddStreamAudio(mWriterJNIContext, mAudioDSI, mAudioDSI.length, mConfiguration.audioBitRate, mConfiguration.audioSampleRate, mConfiguration.audioChannelCount);
            return;
        }
    }

    public void stop()
    {
        try
        {
            if (!isRunningOnICS)
            {
                break MISSING_BLOCK_LABEL_213;
            }
            while (mRetrievedEncodedFrameCount < mSuppliedEncodedFrameCount) 
            {
                LVMediaCoderFactory.printLog("[LVMediaCoderImpl] WAITING to complete frame extraction .... ..... ... !!!!!! ", false);
                LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Got : ").append(mRetrievedEncodedFrameCount).append("sent :").append(mSuppliedEncodedFrameCount).toString(), false);
                pullerFlagExit = false;
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] ").append(exception.toString()).toString(), true);
            throw new IllegalStateException((new StringBuilder()).append(exception.getMessage()).append(" Error while executing stop()").toString());
        }
        LVMediaCoderFactory.printLog((new StringBuilder()).append("[LVMediaCoderImpl] Got : ").append(mRetrievedEncodedFrameCount).append("sent :").append(mSuppliedEncodedFrameCount).toString(), false);
        if (mSuppliedEncodedFrameCount == mRetrievedEncodedFrameCount)
        {
            pullerFlagExit = true;
            mSuppliedEncodedFrameCount = 0;
            mRetrievedEncodedFrameCount = 0;
            LVMediaCoderFactory.printLog("[LVMediaCoderImpl] stop(): DONE with frame extraction .... ..... ... !!!!!! ", false);
        }
        run = false;
        if (isRecordingSession)
        {
            LVMediaCoderWriterJNI.LVMediaCoderWriterClose(mWriterJNIContext);
        }
        isRecordingSession = false;
        isAudioEncoderRunning = false;
        isVideoEncoderRunning = false;
        mInputVideoBuffers = null;
        mOutputVideoBuffers = null;
        mInputAudioBuffers = null;
        mOutputAudioBuffers = null;
        if (!isRunningOnICS && mAudioEncoder != null)
        {
            mAudioEncoder.stop();
            mAudioEncoder.release();
            mAudioEncoder = null;
        }
        if (isRunningOnICS && mICSAudioEncoder != null)
        {
            mICSAudioEncoder.stop();
            mICSAudioEncoder = null;
        }
        if (!isRunningOnICS && mVideoEncoder != null)
        {
            mVideoEncoder.stop();
            mVideoEncoder.release();
            mVideoEncoder = null;
        }
        if (isRunningOnICS && mICSVideoEncoder != null)
        {
            mICSVideoEncoder.stop();
            mICSVideoEncoder = null;
        }
        mWriterJNIContext = 0;
        mAudioDSI = null;
        mVideoDSI = null;
        LVMediaCoderFactory.printLog("[LVMediaCoderImpl] LVMediaCoder stopped!", false);
        return;
    }




/*
    static ByteBuffer access$102(ByteBuffer bytebuffer)
    {
        outData = bytebuffer;
        return bytebuffer;
    }

*/




/*
    static int access$308(LVMediaCoderImpl lvmediacoderimpl)
    {
        int i = lvmediacoderimpl.mRetrievedEncodedFrameCount;
        lvmediacoderimpl.mRetrievedEncodedFrameCount = i + 1;
        return i;
    }

*/




}
