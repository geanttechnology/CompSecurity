// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;


// Referenced classes of package com.facebook.imagepipeline.producers:
//            JobScheduler

static final class  extends Enum
{

    private static final RUNNING_AND_PENDING $VALUES[];
    public static final RUNNING_AND_PENDING IDLE;
    public static final RUNNING_AND_PENDING QUEUED;
    public static final RUNNING_AND_PENDING RUNNING;
    public static final RUNNING_AND_PENDING RUNNING_AND_PENDING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/facebook/imagepipeline/producers/JobScheduler$JobState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IDLE = new <init>("IDLE", 0);
        QUEUED = new <init>("QUEUED", 1);
        RUNNING = new <init>("RUNNING", 2);
        RUNNING_AND_PENDING = new <init>("RUNNING_AND_PENDING", 3);
        $VALUES = (new .VALUES[] {
            IDLE, QUEUED, RUNNING, RUNNING_AND_PENDING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
