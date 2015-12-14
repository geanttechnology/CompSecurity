// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;


// Referenced classes of package com.facebook.imagepipeline.producers:
//            JobScheduler

static class bState
{

    static final int $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[];

    static 
    {
        $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState = new int[bState.values().length];
        try
        {
            $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[bState.IDLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[bState.QUEUED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[bState.RUNNING.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[bState.RUNNING_AND_PENDING.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
