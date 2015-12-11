// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;


// Referenced classes of package org.apache.thrift.server:
//            TNonblockingServer

public static class maxReadBufferBytes
{

    public long maxReadBufferBytes;

    public void validate()
    {
        if (maxReadBufferBytes <= 1024L)
        {
            throw new IllegalArgumentException("You must allocate at least 1KB to the read buffer.");
        } else
        {
            return;
        }
    }

    public _cls9()
    {
        maxReadBufferBytes = 0x7fffffffffffffffL;
    }
}
