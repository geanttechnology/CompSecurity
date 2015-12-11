// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils

public static abstract class executionThread
{

    private final executionThread executionStyle;
    private final executionThread executionThread;

    public abstract void execute(Runnable runnable);

    public executionThread getExecutionStyle()
    {
        return executionStyle;
    }

    public executionStyle getExecutionThread()
    {
        return executionThread;
    }


    public ( ,  1)
    {
        executionStyle = ;
        executionThread = 1;
    }
}
