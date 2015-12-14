// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.util.LinkedList;

// Referenced classes of package org.apache.commons.httpclient:
//            MultiThreadedHttpConnectionManager, HostConfiguration

private static class <init>
{

    public LinkedList freeConnections;
    public HostConfiguration hostConfiguration;
    public int numConnections;
    public LinkedList waitingThreads;

    private Y()
    {
        freeConnections = new LinkedList();
        waitingThreads = new LinkedList();
        numConnections = 0;
    }

    numConnections(numConnections numconnections)
    {
        this();
    }
}
