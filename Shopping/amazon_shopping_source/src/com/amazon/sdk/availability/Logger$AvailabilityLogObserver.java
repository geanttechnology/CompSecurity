// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;


// Referenced classes of package com.amazon.sdk.availability:
//            Logger

public static interface 
{

    public abstract void e(String s);

    public abstract void e(String s, Throwable throwable);

    public abstract void i(String s);

    public abstract void measurementRecorded(String s, String s1);

    public abstract void measurementsSubmitted(boolean flag, long l, String s, String s1);

    public abstract void syncConfigurationScheduled(long l, boolean flag);

    public abstract void v(String s);

    public abstract void v(String s, Throwable throwable);

    public abstract void w(String s);

    public abstract void w(String s, Throwable throwable);
}
