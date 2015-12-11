// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.mediacoder;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Environment;
import android.util.Log;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

// Referenced classes of package com.lifevibes.mediacoder:
//            LVMediaCoderProperties, LVMediaCoderImpl, LVMediaCoderConfiguration

public class LVMediaCoderFactory
{

    private static final String TAG = "LVMediaCoderFactory";
    private static File inputAudioFile;
    private static File inputVideoFile;
    private static File mLogFile;
    private static PrintStream mPrintLogStream;
    private static String mUnsupportedColorFormat;

    private LVMediaCoderFactory()
    {
    }

    private static boolean checkColorFormat()
    {
        ArrayList arraylist;
        MediaCodecInfo mediacodecinfo;
        int i;
        int l;
        int j1;
        l = 0;
        if (LVMediaCoderProperties.DEBUG)
        {
            arraylist = new ArrayList();
        } else
        {
            arraylist = null;
        }
        i = 0;
        if (i >= MediaCodecList.getCodecCount())
        {
            break MISSING_BLOCK_LABEL_235;
        }
        mediacodecinfo = MediaCodecList.getCodecInfoAt(i);
        if (LVMediaCoderProperties.DEBUG)
        {
            printLog((new StringBuilder()).append("[LVMediaCoderFactory] Encoder ").append(i).append(": ").append(mediacodecinfo.getName()).toString(), false);
        }
        if (mediacodecinfo.isEncoder())
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = l;
_L6:
        i++;
        l = j1;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_20;
_L1:
        String as[];
        int l1;
        int i2;
        as = mediacodecinfo.getSupportedTypes();
        i2 = as.length;
        l1 = 0;
_L4:
        j1 = l;
        if (l1 < i2)
        {
label0:
            {
                String s = as[l1];
                if (!s.contains("avc"))
                {
                    break label0;
                }
                if (LVMediaCoderProperties.DEBUG)
                {
                    printLog((new StringBuilder()).append("[LVMediaCoderFactory] Encoder ").append(i).append("/").append(MediaCodecList.getCodecCount()).append(": ").append(mediacodecinfo.getName()).append(" supports [").append(s).append("]").toString(), false);
                    if (arraylist != null)
                    {
                        arraylist.add(mediacodecinfo);
                    }
                }
                j1 = i;
            }
        }
        continue; /* Loop/switch isn't completed */
        l1++;
        if (true) goto _L4; else goto _L3
_L3:
        android.media.MediaCodecInfo.CodecCapabilities codeccapabilities = MediaCodecList.getCodecInfoAt(l).getCapabilitiesForType("video/avc");
        if (LVMediaCoderProperties.DEBUG)
        {
            int ai[] = codeccapabilities.colorFormats;
            int i1 = ai.length;
            for (int j = 0; j < i1; j++)
            {
                int k1 = ai[j];
                printLog((new StringBuilder()).append("[LVMediaCoderFactory] Color Format: ").append(k1).toString(), false);
            }

        }
        ArrayList arraylist1 = new ArrayList();
        for (int k = 0; k < codeccapabilities.colorFormats.length; k++)
        {
            arraylist1.add(Integer.valueOf(codeccapabilities.colorFormats[k]));
        }

        if (arraylist1.contains(Integer.valueOf(19)) || arraylist1.contains(Integer.valueOf(20)) || arraylist1.contains(Integer.valueOf(21)) || arraylist1.contains(Integer.valueOf(39)) || arraylist1.contains(Integer.valueOf(0x7f000100)))
        {
            return true;
        }
        mUnsupportedColorFormat = (new StringBuilder()).append(arraylist1.get(0)).append("").toString();
        return false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static LVMediaCoderImpl create(Context context, LVMediaCoderConfiguration lvmediacoderconfiguration)
        throws IllegalArgumentException
    {
        if (SLog.sLogsOn && !(new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/Twitter/").toString())).mkdirs())
        {
            SLog.e("Logs may not be working.");
        }
        if (android.os.Build.VERSION.SDK_INT <= 15)
        {
            LVMediaCoderImpl.isRunningOnICS = true;
        } else
        if (!checkColorFormat())
        {
            throw new IllegalStateException((new StringBuilder()).append("Currently color format ").append(mUnsupportedColorFormat).append(" is NOT supported").toString());
        }
        validateConfiguration(lvmediacoderconfiguration);
        return new LVMediaCoderImpl(context, lvmediacoderconfiguration);
    }

    static void dumpInputAudioData(byte abyte0[])
    {
        if (!LVMediaCoderProperties.DUMPS && inputAudioFile == null)
        {
            return;
        }
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(inputAudioFile, true);
            fileoutputstream.write(abyte0);
            fileoutputstream.flush();
            fileoutputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
        }
    }

    static void dumpInputVideoData(byte abyte0[])
    {
        if (!LVMediaCoderProperties.DUMPS && inputVideoFile == null)
        {
            return;
        }
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(inputVideoFile, true);
            fileoutputstream.write(abyte0);
            fileoutputstream.flush();
            fileoutputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
        }
    }

    static void printLog(String s, boolean flag)
    {
        if (LVMediaCoderProperties.DEBUG)
        {
            if (mPrintLogStream == null || mLogFile == null || !mLogFile.exists())
            {
                Log.d("LVMediaCoderFactory", "Exception while writing to the log file.");
                return;
            }
            Log.d("LVMediaCoderFactory", s.replace("[LVMediaCoderFactory] ", ""));
            if (flag)
            {
                mPrintLogStream.println("======================= EXCEPTION [START] =======================");
                mPrintLogStream.flush();
            }
            mPrintLogStream.println(s);
            mPrintLogStream.flush();
            if (flag)
            {
                mPrintLogStream.println("======================== EXCEPTION [END] ========================");
                mPrintLogStream.flush();
                return;
            }
        }
    }

    public static void setDumpingEnabled(boolean flag)
    {
        LVMediaCoderProperties.DUMPS = flag;
        if (flag)
        {
            (new File("/mnt/sdcard/Twitter/")).mkdir();
            inputVideoFile = new File("/mnt/sdcard/Twitter/Twitter_Input_Video.raw");
            inputAudioFile = new File("/mnt/sdcard/Twitter/Twitter_Input_Audio.raw");
            if (inputVideoFile.exists())
            {
                inputVideoFile.delete();
            }
            if (inputAudioFile.exists())
            {
                inputAudioFile.delete();
            }
            inputVideoFile = new File("/mnt/sdcard/Twitter/Twitter_Input_Video.raw");
            inputAudioFile = new File("/mnt/sdcard/Twitter/Twitter_Input_Audio.raw");
        }
    }

    public static void setLoggingEnabled(boolean flag)
    {
        LVMediaCoderProperties.DEBUG = flag;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        (new File("/mnt/sdcard/Twitter/")).mkdirs();
        mLogFile = new File("/mnt/sdcard/Twitter/LVMediaCoderLog.txt");
        if (mLogFile.exists())
        {
            mLogFile.delete();
        }
        mLogFile = new File("/mnt/sdcard/Twitter/LVMediaCoderLog.txt");
        mPrintLogStream = new PrintStream(mLogFile);
        return;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        filenotfoundexception.printStackTrace();
        return;
    }

    private static void validateConfiguration(LVMediaCoderConfiguration lvmediacoderconfiguration)
    {
        if (lvmediacoderconfiguration == null)
        {
            throw new NullPointerException("Configuration is null.");
        }
        if (LVMediaCoderProperties.DEBUG)
        {
            printLog((new StringBuilder()).append("[LVMediaCoderFactory] Session configuration:\n\t\t\t\t Video BitRate:\t\t").append(lvmediacoderconfiguration.videoBitRate).append("\n\t\t\t\t Video Frame Rate:\t").append(lvmediacoderconfiguration.videoFrameRate).append("\n\t\t\t\t Video I-Frame Int:\t").append(lvmediacoderconfiguration.videoIFrameInterval).append("\n\t\t\t\t Audio Bit Rate:\t").append(lvmediacoderconfiguration.audioBitRate).append("\n\t\t\t\t Audio Channels:\t").append(lvmediacoderconfiguration.audioChannelCount).append("\n\t\t\t\t Audio Sample Rate:\t").append(lvmediacoderconfiguration.audioSampleRate).toString(), false);
        }
        if (lvmediacoderconfiguration.videoIFrameInterval <= 0)
        {
            throw new IllegalArgumentException("Video IFrame interval should be greater than 0.");
        }
        if (!LVMediaCoderProperties.getSupportedVideoBitrates().contains(Integer.valueOf(lvmediacoderconfiguration.videoBitRate)))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(lvmediacoderconfiguration.videoBitRate).append(" video bit-rate is not supported. Use LVMediaCoderProperties.getSupportedBitrates() to get the list of supported video bit-rates.").toString());
        }
        if (!LVMediaCoderProperties.getSupportedHeightAndWidth().contains(Integer.valueOf(lvmediacoderconfiguration.videoWidth)) || !LVMediaCoderProperties.getSupportedHeightAndWidth().contains(Integer.valueOf(lvmediacoderconfiguration.videoHeight)))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Video resolution: ").append(lvmediacoderconfiguration.videoWidth).append("x").append(lvmediacoderconfiguration.videoHeight).append(" is not supported. Please use LVMediaCoderProperties.getSupportedHeightAndWidth() to get the list of supported Heights and Widths.").toString());
        }
        if (lvmediacoderconfiguration.videoWidth != lvmediacoderconfiguration.videoHeight)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Video resolution: ").append(lvmediacoderconfiguration.videoWidth).append("x").append(lvmediacoderconfiguration.videoHeight).append(" is not supported. Currenly only aspect ratio of 1:1 is supported.").toString());
        }
        if (!LVMediaCoderProperties.getSupportedFrameRates().contains(Integer.valueOf(lvmediacoderconfiguration.videoFrameRate)))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(lvmediacoderconfiguration.videoFrameRate).append(" frame-rate is not supported. Use LVMediaCoderProperties.getSupportedFrameRates() to get the list of supported frame-rates.").toString());
        }
        if (!LVMediaCoderProperties.getSupportedAudioBitrates().contains(Integer.valueOf(lvmediacoderconfiguration.audioBitRate)))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(lvmediacoderconfiguration.audioBitRate).append(" audio bit-rate is not supported. Use LVMediaCoderProperties.getSupportedBitrates() to get the list of supported audio bit-rates.").toString());
        }
        if (!LVMediaCoderProperties.getSupportedChannelCounts().contains(Integer.valueOf(lvmediacoderconfiguration.audioChannelCount)))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(lvmediacoderconfiguration.audioChannelCount).append(" audio channel count is not supported. Use LVMediaCoderProperties.getSupportedChannelCounts() to get the list of supported audio channel counts.").toString());
        }
        if (!LVMediaCoderProperties.getSupportedSampleRates().contains(Integer.valueOf(lvmediacoderconfiguration.audioSampleRate)))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(lvmediacoderconfiguration.audioSampleRate).append(" audio sample rate is not supported. Use LVMediaCoderProperties.getSupportedSampleRates()to get the list of supported audio sample rates.").toString());
        } else
        {
            return;
        }
    }
}
