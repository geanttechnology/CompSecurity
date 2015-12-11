// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI, FrameQueue, TemplateInfo

public class FrameProcessingCallbackTemplateMatcher
{

    private long a;
    protected boolean swigCMemOwn;

    public FrameProcessingCallbackTemplateMatcher()
    {
        this(jniLivenessAndTMJNI.new_FrameProcessingCallbackTemplateMatcher(), true);
        jniLivenessAndTMJNI.FrameProcessingCallbackTemplateMatcher_director_connect(this, a, swigCMemOwn, true);
    }

    protected FrameProcessingCallbackTemplateMatcher(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(FrameProcessingCallbackTemplateMatcher frameprocessingcallbacktemplatematcher)
    {
        if (frameprocessingcallbacktemplatematcher == null)
        {
            return 0L;
        } else
        {
            return frameprocessingcallbacktemplatematcher.a;
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (a == 0L)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        if (swigCMemOwn)
        {
            swigCMemOwn = false;
            throw new UnsupportedOperationException("C++ destructor does not have public access");
        }
        break MISSING_BLOCK_LABEL_38;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        a = 0L;
        this;
        JVM INSTR monitorexit ;
    }

    public void finalResult(FrameQueue framequeue, TemplateInfo templateinfo)
    {
        jniLivenessAndTMJNI.FrameProcessingCallbackTemplateMatcher_finalResult(a, this, FrameQueue.getCPtr(framequeue), framequeue, TemplateInfo.getCPtr(templateinfo), templateinfo);
    }

    public void intermediateResult(FrameQueue framequeue, TemplateInfo templateinfo)
    {
        jniLivenessAndTMJNI.FrameProcessingCallbackTemplateMatcher_intermediateResult(a, this, FrameQueue.getCPtr(framequeue), framequeue, TemplateInfo.getCPtr(templateinfo), templateinfo);
    }

    public void noResult(FrameQueue framequeue)
    {
        if (getClass() == com/jumio/clientlib/impl/livenessAndTM/FrameProcessingCallbackTemplateMatcher)
        {
            jniLivenessAndTMJNI.FrameProcessingCallbackTemplateMatcher_noResult(a, this, FrameQueue.getCPtr(framequeue), framequeue);
            return;
        } else
        {
            jniLivenessAndTMJNI.FrameProcessingCallbackTemplateMatcher_noResultSwigExplicitFrameProcessingCallbackTemplateMatcher(a, this, FrameQueue.getCPtr(framequeue), framequeue);
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
        jniLivenessAndTMJNI.FrameProcessingCallbackTemplateMatcher_change_ownership(this, a, false);
    }

    public void swigTakeOwnership()
    {
        swigCMemOwn = true;
        jniLivenessAndTMJNI.FrameProcessingCallbackTemplateMatcher_change_ownership(this, a, true);
    }
}
