// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI, FramesVector, LibImage

public class FrameQueue
{

    private long a;
    protected boolean swigCMemOwn;

    public FrameQueue(long l)
    {
        this(jniLivenessAndTMJNI.new_FrameQueue(l), true);
    }

    protected FrameQueue(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(FrameQueue framequeue)
    {
        if (framequeue == null)
        {
            return 0L;
        } else
        {
            return framequeue.a;
        }
    }

    public void clear()
    {
        jniLivenessAndTMJNI.FrameQueue_clear(a, this);
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
                jniLivenessAndTMJNI.delete_FrameQueue(a);
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

    public void getAllFrames(FramesVector framesvector)
    {
        jniLivenessAndTMJNI.FrameQueue_getAllFrames(a, this, FramesVector.getCPtr(framesvector), framesvector);
    }

    public LibImage getFrameByID(int i)
    {
        long l = jniLivenessAndTMJNI.FrameQueue_getFrameByID(a, this, i);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new LibImage(l, true);
        }
    }

    public void getFramesInRange(int i, int j, FramesVector framesvector)
    {
        jniLivenessAndTMJNI.FrameQueue_getFramesInRange(a, this, i, j, FramesVector.getCPtr(framesvector), framesvector);
    }

    public LibImage lastFrame()
    {
        long l = jniLivenessAndTMJNI.FrameQueue_lastFrame(a, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new LibImage(l, true);
        }
    }

    public void pushFrame(LibImage libimage)
    {
        jniLivenessAndTMJNI.FrameQueue_pushFrame(a, this, LibImage.getCPtr(libimage), libimage);
    }

    public boolean removeFrameByID(int i)
    {
        return jniLivenessAndTMJNI.FrameQueue_removeFrameByID(a, this, i);
    }

    public long size()
    {
        return jniLivenessAndTMJNI.FrameQueue_size(a, this);
    }
}
