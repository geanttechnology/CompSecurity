// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.imagereader;

import android.util.Log;
import java.security.InvalidParameterException;

// Referenced classes of package com.digimarc.dms.imagereader:
//            CpmImage

public class ReaderCpm
{
    public static final class CaptureFormat extends Enum
    {

        private static final CaptureFormat $VALUES[];
        public static final CaptureFormat RGB888;
        public static final CaptureFormat RGBA8888;
        public static final CaptureFormat YUV420;

        public static CaptureFormat valueOf(String s)
        {
            return (CaptureFormat)Enum.valueOf(com/digimarc/dms/imagereader/ReaderCpm$CaptureFormat, s);
        }

        public static CaptureFormat[] values()
        {
            return (CaptureFormat[])$VALUES.clone();
        }

        static 
        {
            YUV420 = new CaptureFormat("YUV420", 0);
            RGB888 = new CaptureFormat("RGB888", 1);
            RGBA8888 = new CaptureFormat("RGBA8888", 2);
            $VALUES = (new CaptureFormat[] {
                YUV420, RGB888, RGBA8888
            });
        }

        private CaptureFormat(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = "ReaderCpm";
    private CaptureFormat mCaptureFormat;
    private boolean mChromaMarks;
    private boolean mClassicMarks;

    protected ReaderCpm()
    {
        mCaptureFormat = CaptureFormat.YUV420;
        mClassicMarks = true;
        mChromaMarks = true;
        System.loadLibrary("DMSImageWatermark");
    }

    private static int PixelFormatToImageType(CaptureFormat captureformat, boolean flag)
    {
        if (captureformat == CaptureFormat.YUV420)
        {
            return !flag ? 1 : 1001;
        }
        if (captureformat == CaptureFormat.RGB888)
        {
            return !flag ? 2 : 1002;
        }
        if (captureformat == CaptureFormat.RGBA8888)
        {
            return !flag ? 3 : 1003;
        }
        captureformat = "Invalid parameter (imageType) passed to readMark";
        if (flag)
        {
            captureformat = "Invalid parameter (imageType) passed to readMarkClassic";
        }
        Log.e("ReaderCpm", captureformat);
        throw new InvalidParameterException(captureformat);
    }

    private native CpmImage readWatermark(byte abyte0[], int i, int j, int k);

    protected native boolean getAutofocusOn();

    protected CaptureFormat getCaptureFormat()
    {
        return mCaptureFormat;
    }

    protected boolean getChromaWatermarksSupported()
    {
        return mChromaMarks;
    }

    protected boolean getClassicWatermarksSupported()
    {
        return mClassicMarks;
    }

    protected native int getDownSampleFactor();

    protected native String getVersion();

    protected CpmImage readImageSynchronous(byte abyte0[], int i, int j)
    {
        CpmImage cpmimage1;
label0:
        {
            CpmImage cpmimage = null;
            if (mChromaMarks)
            {
                cpmimage = readWatermark(abyte0, j, i, PixelFormatToImageType(mCaptureFormat, false));
            }
            cpmimage1 = cpmimage;
            if (!mClassicMarks)
            {
                break label0;
            }
            if (cpmimage != null)
            {
                cpmimage1 = cpmimage;
                if (cpmimage == null)
                {
                    break label0;
                }
                cpmimage1 = cpmimage;
                if (cpmimage.getWatermarkFound())
                {
                    break label0;
                }
            }
            cpmimage1 = readWatermark(abyte0, j, i, PixelFormatToImageType(mCaptureFormat, true));
        }
        cpmimage1.parseCpmPath();
        return cpmimage1;
    }

    protected native void setAutofocusOn(boolean flag);

    protected void setCaptureFormat(CaptureFormat captureformat)
    {
        mCaptureFormat = captureformat;
    }

    protected void setChromaWatermarksSupported(boolean flag)
    {
        mChromaMarks = flag;
    }

    protected void setClassicWatermarksSupported(boolean flag)
    {
        mClassicMarks = flag;
    }

    protected native void setDownSampleFactor(int i);
}
