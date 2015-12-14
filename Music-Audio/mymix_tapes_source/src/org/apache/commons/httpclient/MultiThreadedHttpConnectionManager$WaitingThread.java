// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;


// Referenced classes of package org.apache.commons.httpclient:
//            MultiThreadedHttpConnectionManager

private static class <init>
{

    public Pool hostConnectionPool;
    public boolean interruptedByConnectionPool;
    public Thread thread;

    private Pool()
    {
        interruptedByConnectionPool = false;
    }

    interruptedByConnectionPool(interruptedByConnectionPool interruptedbyconnectionpool)
    {
        this();
    }
}
