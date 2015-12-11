// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI, LibImage

public class FrameProcessor
{

    private long a;
    private boolean b;

    protected FrameProcessor(long l, boolean flag)
    {
        b = flag;
        a = l;
    }

    protected static long getCPtr(FrameProcessor frameprocessor)
    {
        if (frameprocessor == null)
        {
            return 0L;
        } else
        {
            return frameprocessor.a;
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
                jniLivenessAndTMJNI.delete_FrameProcessor(a);
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

    public void pushFrame(LibImage libimage)
    {
        jniLivenessAndTMJNI.FrameProcessor_pushFrame(a, this, LibImage.getCPtr(libimage), libimage);
    }

    public void reset()
    {
        jniLivenessAndTMJNI.FrameProcessor_reset(a, this);
    }
}
