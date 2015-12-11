// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI, LivenessDetectorResult

public class LivenessDetectorCallback
{

    private long a;
    protected boolean swigCMemOwn;

    public LivenessDetectorCallback()
    {
        this(jniLivenessAndTMJNI.new_LivenessDetectorCallback(), true);
        jniLivenessAndTMJNI.LivenessDetectorCallback_director_connect(this, a, swigCMemOwn, true);
    }

    protected LivenessDetectorCallback(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(LivenessDetectorCallback livenessdetectorcallback)
    {
        if (livenessdetectorcallback == null)
        {
            return 0L;
        } else
        {
            return livenessdetectorcallback.a;
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
                jniLivenessAndTMJNI.delete_LivenessDetectorCallback(a);
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

    public void onResult(LivenessDetectorResult livenessdetectorresult, int i)
    {
        if (getClass() == com/jumio/clientlib/impl/livenessAndTM/LivenessDetectorCallback)
        {
            jniLivenessAndTMJNI.LivenessDetectorCallback_onResult(a, this, LivenessDetectorResult.getCPtr(livenessdetectorresult), livenessdetectorresult, i);
            return;
        } else
        {
            jniLivenessAndTMJNI.LivenessDetectorCallback_onResultSwigExplicitLivenessDetectorCallback(a, this, LivenessDetectorResult.getCPtr(livenessdetectorresult), livenessdetectorresult, i);
            return;
        }
    }

    protected void swigDirectorDisconnect()
    {
        swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership()
    {
        swigCMemOwn = false;
        jniLivenessAndTMJNI.LivenessDetectorCallback_change_ownership(this, a, false);
    }

    public void swigTakeOwnership()
    {
        swigCMemOwn = true;
        jniLivenessAndTMJNI.LivenessDetectorCallback_change_ownership(this, a, true);
    }
}
