// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils

static class ecutionThread
{

    static final int $SwitchMap$com$amazon$device$ads$ThreadUtils$ExecutionThread[];

    static 
    {
        $SwitchMap$com$amazon$device$ads$ThreadUtils$ExecutionThread = new int[ecutionThread.values().length];
        try
        {
            $SwitchMap$com$amazon$device$ads$ThreadUtils$ExecutionThread[ecutionThread.MAIN_THREAD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$device$ads$ThreadUtils$ExecutionThread[ecutionThread.BACKGROUND_THREAD.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
