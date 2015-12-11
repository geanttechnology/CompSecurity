// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            MrzEngineInternalSettings, mrzjniInterfaceJNI, MrzRect, StreamReporterInterface, 
//            MrzEngineSessionHelpers, MrzEngineSessionSettings

public class MrzEngine
{

    private long a;
    protected boolean swigCMemOwn;

    protected MrzEngine(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public MrzEngine(MrzEngineInternalSettings mrzengineinternalsettings)
    {
        this(mrzjniInterfaceJNI.new_MrzEngine(MrzEngineInternalSettings.getCPtr(mrzengineinternalsettings), mrzengineinternalsettings), true);
    }

    protected static long getCPtr(MrzEngine mrzengine)
    {
        if (mrzengine == null)
        {
            return 0L;
        } else
        {
            return mrzengine.a;
        }
    }

    public void FeedImageFile(String s)
    {
        mrzjniInterfaceJNI.MrzEngine_FeedImageFile__SWIG_1(a, this, s);
    }

    public void FeedImageFile(String s, ImageOrientation imageorientation)
    {
        mrzjniInterfaceJNI.MrzEngine_FeedImageFile__SWIG_0(a, this, s, imageorientation.swigValue());
    }

    public void FeedUncompressedImageData(byte abyte0[], int i, int j, int k, int l, MrzRect mrzrect)
    {
        mrzjniInterfaceJNI.MrzEngine_FeedUncompressedImageData__SWIG_1(a, this, abyte0, i, j, k, l, MrzRect.getCPtr(mrzrect), mrzrect);
    }

    public void FeedUncompressedImageData(byte abyte0[], int i, int j, int k, int l, MrzRect mrzrect, ImageOrientation imageorientation)
    {
        mrzjniInterfaceJNI.MrzEngine_FeedUncompressedImageData__SWIG_0(a, this, abyte0, i, j, k, l, MrzRect.getCPtr(mrzrect), mrzrect, imageorientation.swigValue());
    }

    public void FeedUncompressedYUVImageData(byte abyte0[], int i, int j, int k, MrzRect mrzrect)
    {
        mrzjniInterfaceJNI.MrzEngine_FeedUncompressedYUVImageData__SWIG_1(a, this, abyte0, i, j, k, MrzRect.getCPtr(mrzrect), mrzrect);
    }

    public void FeedUncompressedYUVImageData(byte abyte0[], int i, int j, int k, MrzRect mrzrect, ImageOrientation imageorientation)
    {
        mrzjniInterfaceJNI.MrzEngine_FeedUncompressedYUVImageData__SWIG_0(a, this, abyte0, i, j, k, MrzRect.getCPtr(mrzrect), mrzrect, imageorientation.swigValue());
    }

    public void InitializeSession(StreamReporterInterface streamreporterinterface)
    {
        mrzjniInterfaceJNI.MrzEngine_InitializeSession__SWIG_2(a, this, StreamReporterInterface.getCPtr(streamreporterinterface), streamreporterinterface);
    }

    public void InitializeSession(StreamReporterInterface streamreporterinterface, MrzEngineSessionHelpers mrzenginesessionhelpers)
    {
        mrzjniInterfaceJNI.MrzEngine_InitializeSession__SWIG_1(a, this, StreamReporterInterface.getCPtr(streamreporterinterface), streamreporterinterface, MrzEngineSessionHelpers.getCPtr(mrzenginesessionhelpers), mrzenginesessionhelpers);
    }

    public void InitializeSession(StreamReporterInterface streamreporterinterface, MrzEngineSessionHelpers mrzenginesessionhelpers, MrzEngineSessionSettings mrzenginesessionsettings)
    {
        mrzjniInterfaceJNI.MrzEngine_InitializeSession__SWIG_0(a, this, StreamReporterInterface.getCPtr(streamreporterinterface), streamreporterinterface, MrzEngineSessionHelpers.getCPtr(mrzenginesessionhelpers), mrzenginesessionhelpers, MrzEngineSessionSettings.getCPtr(mrzenginesessionsettings), mrzenginesessionsettings);
    }

    public void TerminateSession()
    {
        mrzjniInterfaceJNI.MrzEngine_TerminateSession(a, this);
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzEngine(a);
            }
            a = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize()
    {
        delete();
    }

    private class ImageOrientation
    {

        public static final ImageOrientation InvertedLandscape;
        public static final ImageOrientation InvertedPortrait;
        public static final ImageOrientation Landscape;
        public static final ImageOrientation Portrait;
        private static ImageOrientation a[];
        private static int b = 0;
        private final int c;
        private final String d;

        public static ImageOrientation swigToEnum(int i)
        {
            if (i < a.length && i >= 0 && a[i].c == i)
            {
                return a[i];
            }
            for (int j = 0; j < a.length; j++)
            {
                if (a[j].c == i)
                {
                    return a[j];
                }
            }

            throw new IllegalArgumentException((new StringBuilder("No enum ")).append(com/jumio/mrz/impl/smartEngines/swig/MrzEngine$ImageOrientation).append(" with value ").append(i).toString());
        }

        public final int swigValue()
        {
            return c;
        }

        public final String toString()
        {
            return d;
        }

        static 
        {
            Landscape = new ImageOrientation("Landscape");
            Portrait = new ImageOrientation("Portrait");
            InvertedLandscape = new ImageOrientation("InvertedLandscape");
            InvertedPortrait = new ImageOrientation("InvertedPortrait");
            a = (new ImageOrientation[] {
                Landscape, Portrait, InvertedLandscape, InvertedPortrait
            });
        }

        private ImageOrientation(String s)
        {
            d = s;
            int i = b;
            b = i + 1;
            c = i;
        }
    }

}
