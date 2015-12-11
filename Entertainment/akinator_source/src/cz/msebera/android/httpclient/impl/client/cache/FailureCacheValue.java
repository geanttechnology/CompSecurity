// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;


public class FailureCacheValue
{

    private final long creationTimeInNanos = System.nanoTime();
    private final int errorCount;
    private final String key;

    public FailureCacheValue(String s, int i)
    {
        key = s;
        errorCount = i;
    }

    public long getCreationTimeInNanos()
    {
        return creationTimeInNanos;
    }

    public int getErrorCount()
    {
        return errorCount;
    }

    public String getKey()
    {
        return key;
    }

    public String toString()
    {
        return (new StringBuilder()).append("[entry creationTimeInNanos=").append(creationTimeInNanos).append("; ").append("key=").append(key).append("; errorCount=").append(errorCount).append(']').toString();
    }
}
