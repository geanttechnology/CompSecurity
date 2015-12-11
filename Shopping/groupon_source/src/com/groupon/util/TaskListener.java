// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            PausableThreadPoolExecutor

public interface TaskListener
{

    public abstract void onTaskComplete(PausableThreadPoolExecutor pausablethreadpoolexecutor);
}
