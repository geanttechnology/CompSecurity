// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library;


// Referenced classes of package com.aviary.android.feather.library:
//            MonitoredActivity

public static interface 
{

    public abstract void onActivityCreated(MonitoredActivity monitoredactivity);

    public abstract void onActivityDestroyed(MonitoredActivity monitoredactivity);

    public abstract void onActivityPaused(MonitoredActivity monitoredactivity);

    public abstract void onActivityResumed(MonitoredActivity monitoredactivity);

    public abstract void onActivityStarted(MonitoredActivity monitoredactivity);

    public abstract void onActivityStopped(MonitoredActivity monitoredactivity);
}
