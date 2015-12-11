// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            SWIGTYPE_p_FrameProcessorPtr, jniLivenessAndTMJNI, PixelFormatType

public class FrameProcessorManager
{

    private long a;
    private boolean b;

    protected FrameProcessorManager(long l, boolean flag)
    {
        b = flag;
        a = l;
    }

    public FrameProcessorManager(SWIGTYPE_p_FrameProcessorPtr swigtype_p_frameprocessorptr)
    {
        this(jniLivenessAndTMJNI.new_FrameProcessorManager__SWIG_0(SWIGTYPE_p_FrameProcessorPtr.getCPtr(swigtype_p_frameprocessorptr)), true);
    }

    public FrameProcessorManager(SWIGTYPE_p_FrameProcessorPtr swigtype_p_frameprocessorptr, SWIGTYPE_p_FrameProcessorPtr swigtype_p_frameprocessorptr1)
    {
        this(jniLivenessAndTMJNI.new_FrameProcessorManager__SWIG_1(SWIGTYPE_p_FrameProcessorPtr.getCPtr(swigtype_p_frameprocessorptr), SWIGTYPE_p_FrameProcessorPtr.getCPtr(swigtype_p_frameprocessorptr1)), true);
    }

    public FrameProcessorManager(SWIGTYPE_p_FrameProcessorPtr swigtype_p_frameprocessorptr, SWIGTYPE_p_FrameProcessorPtr swigtype_p_frameprocessorptr1, SWIGTYPE_p_FrameProcessorPtr swigtype_p_frameprocessorptr2)
    {
        this(jniLivenessAndTMJNI.new_FrameProcessorManager__SWIG_2(SWIGTYPE_p_FrameProcessorPtr.getCPtr(swigtype_p_frameprocessorptr), SWIGTYPE_p_FrameProcessorPtr.getCPtr(swigtype_p_frameprocessorptr1), SWIGTYPE_p_FrameProcessorPtr.getCPtr(swigtype_p_frameprocessorptr2)), true);
    }

    protected static long getCPtr(FrameProcessorManager frameprocessormanager)
    {
        if (frameprocessormanager == null)
        {
            return 0L;
        } else
        {
            return frameprocessormanager.a;
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
                jniLivenessAndTMJNI.delete_FrameProcessorManager(a);
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

    public void pushFrame(byte abyte0[], long l, int i, int j, int k, int i1, 
            int j1, PixelFormatType pixelformattype, int k1)
    {
        jniLivenessAndTMJNI.FrameProcessorManager_pushFrame(a, this, abyte0, l, i, j, k, i1, j1, pixelformattype.swigValue(), k1);
    }

    public void reset()
    {
        jniLivenessAndTMJNI.FrameProcessorManager_reset(a, this);
    }
}
