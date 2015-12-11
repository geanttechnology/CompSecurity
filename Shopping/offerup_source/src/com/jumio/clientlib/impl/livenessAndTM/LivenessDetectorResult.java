// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI, LandmarkVector, FaceRect

public class LivenessDetectorResult
{

    private long a;
    protected boolean swigCMemOwn;

    public LivenessDetectorResult()
    {
        this(jniLivenessAndTMJNI.new_LivenessDetectorResult__SWIG_7(), true);
    }

    protected LivenessDetectorResult(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public LivenessDetectorResult(boolean flag)
    {
        this(jniLivenessAndTMJNI.new_LivenessDetectorResult__SWIG_6(flag), true);
    }

    public LivenessDetectorResult(boolean flag, boolean flag1)
    {
        this(jniLivenessAndTMJNI.new_LivenessDetectorResult__SWIG_5(flag, flag1), true);
    }

    public LivenessDetectorResult(boolean flag, boolean flag1, boolean flag2)
    {
        this(jniLivenessAndTMJNI.new_LivenessDetectorResult__SWIG_4(flag, flag1, flag2), true);
    }

    public LivenessDetectorResult(boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        this(jniLivenessAndTMJNI.new_LivenessDetectorResult__SWIG_3(flag, flag1, flag2, flag3), true);
    }

    public LivenessDetectorResult(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        this(jniLivenessAndTMJNI.new_LivenessDetectorResult__SWIG_2(flag, flag1, flag2, flag3, flag4), true);
    }

    public LivenessDetectorResult(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, LandmarkVector landmarkvector)
    {
        this(jniLivenessAndTMJNI.new_LivenessDetectorResult__SWIG_1(flag, flag1, flag2, flag3, flag4, LandmarkVector.getCPtr(landmarkvector), landmarkvector), true);
    }

    public LivenessDetectorResult(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, LandmarkVector landmarkvector, FaceRect facerect)
    {
        this(jniLivenessAndTMJNI.new_LivenessDetectorResult__SWIG_0(flag, flag1, flag2, flag3, flag4, LandmarkVector.getCPtr(landmarkvector), landmarkvector, FaceRect.getCPtr(facerect), facerect), true);
    }

    protected static long getCPtr(LivenessDetectorResult livenessdetectorresult)
    {
        if (livenessdetectorresult == null)
        {
            return 0L;
        } else
        {
            return livenessdetectorresult.a;
        }
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
                jniLivenessAndTMJNI.delete_LivenessDetectorResult(a);
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

    public FaceRect getFaceRect()
    {
        return new FaceRect(jniLivenessAndTMJNI.LivenessDetectorResult_getFaceRect(a, this), false);
    }

    public LandmarkVector getLandmarkPoints()
    {
        return new LandmarkVector(jniLivenessAndTMJNI.LivenessDetectorResult_getLandmarkPoints(a, this), false);
    }

    public boolean isLeftEyeBlinking()
    {
        return jniLivenessAndTMJNI.LivenessDetectorResult_isLeftEyeBlinking(a, this);
    }

    public boolean isRightEyeBlinking()
    {
        return jniLivenessAndTMJNI.LivenessDetectorResult_isRightEyeBlinking(a, this);
    }

    public boolean isSmiling()
    {
        return jniLivenessAndTMJNI.LivenessDetectorResult_isSmiling(a, this);
    }

    public boolean isTooLargeMovement()
    {
        return jniLivenessAndTMJNI.LivenessDetectorResult_isTooLargeMovement(a, this);
    }

    public boolean isTracking()
    {
        return jniLivenessAndTMJNI.LivenessDetectorResult_isTracking(a, this);
    }
}
