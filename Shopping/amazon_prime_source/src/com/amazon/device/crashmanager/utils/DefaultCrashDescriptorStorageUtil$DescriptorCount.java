// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.utils;


// Referenced classes of package com.amazon.device.crashmanager.utils:
//            DefaultCrashDescriptorStorageUtil

private class mCreatedMs
{

    private int mCount;
    private long mCreatedMs;
    final DefaultCrashDescriptorStorageUtil this$0;

    public int getCount()
    {
        return mCount;
    }

    public long getCreated()
    {
        return mCreatedMs;
    }

    public void increment()
    {
        mCount = mCount + 1;
    }

    public String toString()
    {
        return (new StringBuilder()).append(Integer.toString(mCount)).append("|").append(Long.toString(mCreatedMs)).toString();
    }

    public ()
    {
        this(1, System.currentTimeMillis());
    }

    public <init>(int i, long l)
    {
        this$0 = DefaultCrashDescriptorStorageUtil.this;
        super();
        mCount = i;
        mCreatedMs = l;
    }
}
