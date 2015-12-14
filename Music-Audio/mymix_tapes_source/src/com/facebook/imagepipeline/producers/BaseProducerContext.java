// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            ProducerContext, ProducerContextCallbacks, ProducerListener

public class BaseProducerContext
    implements ProducerContext
{

    private final List mCallbacks = new ArrayList();
    private final Object mCallerContext;
    private final String mId;
    private final ImageRequest mImageRequest;
    private boolean mIsCancelled;
    private boolean mIsIntermediateResultExpected;
    private boolean mIsPrefetch;
    private final com.facebook.imagepipeline.request.ImageRequest.RequestLevel mLowestPermittedRequestLevel;
    private Priority mPriority;
    private final ProducerListener mProducerListener;

    public BaseProducerContext(ImageRequest imagerequest, String s, ProducerListener producerlistener, Object obj, com.facebook.imagepipeline.request.ImageRequest.RequestLevel requestlevel, boolean flag, boolean flag1, 
            Priority priority)
    {
        mImageRequest = imagerequest;
        mId = s;
        mProducerListener = producerlistener;
        mCallerContext = obj;
        mLowestPermittedRequestLevel = requestlevel;
        mIsPrefetch = flag;
        mPriority = priority;
        mIsIntermediateResultExpected = flag1;
        mIsCancelled = false;
    }

    public static void callOnCancellationRequested(List list)
    {
        if (list != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                ((ProducerContextCallbacks)list.next()).onCancellationRequested();
            }
        }
    }

    public static void callOnIsIntermediateResultExpectedChanged(List list)
    {
        if (list != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                ((ProducerContextCallbacks)list.next()).onIsIntermediateResultExpectedChanged();
            }
        }
    }

    public static void callOnIsPrefetchChanged(List list)
    {
        if (list != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                ((ProducerContextCallbacks)list.next()).onIsPrefetchChanged();
            }
        }
    }

    public static void callOnPriorityChanged(List list)
    {
        if (list != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                ((ProducerContextCallbacks)list.next()).onPriorityChanged();
            }
        }
    }

    public void addCallbacks(ProducerContextCallbacks producercontextcallbacks)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        mCallbacks.add(producercontextcallbacks);
        if (mIsCancelled)
        {
            flag = true;
        }
        this;
        JVM INSTR monitorexit ;
        if (flag)
        {
            producercontextcallbacks.onCancellationRequested();
        }
        return;
        producercontextcallbacks;
        this;
        JVM INSTR monitorexit ;
        throw producercontextcallbacks;
    }

    public void cancel()
    {
        callOnCancellationRequested(cancelNoCallbacks());
    }

    public List cancelNoCallbacks()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsCancelled;
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
_L2:
        mIsCancelled = true;
        obj = new ArrayList(mCallbacks);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public Object getCallerContext()
    {
        return mCallerContext;
    }

    public String getId()
    {
        return mId;
    }

    public ImageRequest getImageRequest()
    {
        return mImageRequest;
    }

    public ProducerListener getListener()
    {
        return mProducerListener;
    }

    public com.facebook.imagepipeline.request.ImageRequest.RequestLevel getLowestPermittedRequestLevel()
    {
        return mLowestPermittedRequestLevel;
    }

    public Priority getPriority()
    {
        this;
        JVM INSTR monitorenter ;
        Priority priority = mPriority;
        this;
        JVM INSTR monitorexit ;
        return priority;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isCancelled()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsCancelled;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isIntermediateResultExpected()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsIntermediateResultExpected;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isPrefetch()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsPrefetch;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public List setIsIntermediateResultExpectedNoCallbacks(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = mIsIntermediateResultExpected;
        if (flag != flag1) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
_L2:
        mIsIntermediateResultExpected = flag;
        obj = new ArrayList(mCallbacks);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public List setIsPrefetchNoCallbacks(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = mIsPrefetch;
        if (flag != flag1) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
_L2:
        mIsPrefetch = flag;
        obj = new ArrayList(mCallbacks);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public List setPriorityNoCallbacks(Priority priority)
    {
        this;
        JVM INSTR monitorenter ;
        Priority priority1 = mPriority;
        if (priority != priority1) goto _L2; else goto _L1
_L1:
        priority = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return priority;
_L2:
        mPriority = priority;
        priority = new ArrayList(mCallbacks);
        if (true) goto _L4; else goto _L3
_L3:
        priority;
        throw priority;
    }
}
