// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fsr.tracker;


// Referenced classes of package com.fsr.tracker:
//            LogEvent

public interface ITrackerLogger
{

    public abstract void transmitLogEvent(LogEvent logevent);
}
