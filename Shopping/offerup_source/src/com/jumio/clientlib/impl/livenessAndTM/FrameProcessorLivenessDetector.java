// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            FrameProcessor, jniLivenessAndTMJNI, LivenessDetectorCallback, LibImage, 
//            ImageOrientation

public class FrameProcessorLivenessDetector extends FrameProcessor
{

    private long a;
    private boolean b;

    protected FrameProcessorLivenessDetector(long l, boolean flag)
    {
        super(jniLivenessAndTMJNI.FrameProcessorLivenessDetector_SWIGSmartPtrUpcast(l), true);
        b = flag;
        a = l;
    }

    public FrameProcessorLivenessDetector(LivenessDetectorCallback livenessdetectorcallback, String s)
    {
        this(jniLivenessAndTMJNI.new_FrameProcessorLivenessDetector(LivenessDetectorCallback.getCPtr(livenessdetectorcallback), livenessdetectorcallback, s), true);
    }

    protected static long getCPtr(FrameProcessorLivenessDetector frameprocessorlivenessdetector)
    {
        if (frameprocessorlivenessdetector == null)
        {
            return 0L;
        } else
        {
            return frameprocessorlivenessdetector.a;
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != 0L)
        {
            if (b)
            {
                b = false;
                jniLivenessAndTMJNI.delete_FrameProcessorLivenessDetector(a);
            }
            a = 0L;
        }
        super.delete();
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

    public void pushFrame(LibImage libimage, ImageOrientation imageorientation)
    {
        jniLivenessAndTMJNI.FrameProcessorLivenessDetector_pushFrame(a, this, LibImage.getCPtr(libimage), libimage, imageorientation.swigValue());
    }
}
