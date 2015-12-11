// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI, SWIGTYPE_p_FrameProcessorPtr

public class jniLivenessAndTM
{

    public jniLivenessAndTM()
    {
    }

    public static String GetCollectedPerformanceStatistics()
    {
        return jniLivenessAndTMJNI.GetCollectedPerformanceStatistics();
    }

    public static SWIGTYPE_p_FrameProcessorPtr make_async(SWIGTYPE_p_FrameProcessorPtr swigtype_p_frameprocessorptr)
    {
        return new SWIGTYPE_p_FrameProcessorPtr(jniLivenessAndTMJNI.make_async(SWIGTYPE_p_FrameProcessorPtr.getCPtr(swigtype_p_frameprocessorptr)), true);
    }
}
