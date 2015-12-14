// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.request;


// Referenced classes of package com.facebook.imagepipeline.request:
//            BasePostprocessor, RepeatedPostprocessor, RepeatedPostprocessorRunner

public abstract class BaseRepeatedPostProcessor extends BasePostprocessor
    implements RepeatedPostprocessor
{

    private RepeatedPostprocessorRunner mCallback;

    public BaseRepeatedPostProcessor()
    {
    }

    private RepeatedPostprocessorRunner getCallback()
    {
        this;
        JVM INSTR monitorenter ;
        RepeatedPostprocessorRunner repeatedpostprocessorrunner = mCallback;
        this;
        JVM INSTR monitorexit ;
        return repeatedpostprocessorrunner;
        Exception exception;
        exception;
        throw exception;
    }

    public void setCallback(RepeatedPostprocessorRunner repeatedpostprocessorrunner)
    {
        this;
        JVM INSTR monitorenter ;
        mCallback = repeatedpostprocessorrunner;
        this;
        JVM INSTR monitorexit ;
        return;
        repeatedpostprocessorrunner;
        throw repeatedpostprocessorrunner;
    }

    public void update()
    {
        RepeatedPostprocessorRunner repeatedpostprocessorrunner = getCallback();
        if (repeatedpostprocessorrunner != null)
        {
            repeatedpostprocessorrunner.update();
        }
    }
}
