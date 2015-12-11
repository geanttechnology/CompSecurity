// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;


public final class ThreadName
{

    public static final String COMMUNICATION_SERVICE = "CommunicationServiceThread";
    public static final String DEAD_MESSAGE_REMOVE = "DeadMessageRemoveThread";
    public static final String HANDLER = "SocketWorkerThread";
    public static final String HEARTBEAT = "HeartbeatThread";
    public static final String MESSAGE_FRAGMENT_ROUTER = "FragmentRouterThread";
    public static final String NETWORK_STABILITY_MONITOR = "NetworkStabilityMonitor";
    public static final String SELECTOR = "SelectorThread";
    public static final String STREAMING_DEAD_MESSAGE_REMOVE = "StreamingDeadMessageRemoveThread";
    public static final String WATCHDOG = "WatchdogThread";

    private ThreadName()
    {
    }
}
