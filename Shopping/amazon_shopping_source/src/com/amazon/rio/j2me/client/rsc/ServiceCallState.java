// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.rsc;


public class ServiceCallState
{

    public static final ServiceCallState CANCELLED = new ServiceCallState("CANCELLED", true);
    public static final ServiceCallState COMPLETED = new ServiceCallState("COMPLETED", true);
    public static final ServiceCallState ERROR = new ServiceCallState("ERROR", true);
    public static final ServiceCallState EXECUTING = new ServiceCallState("EXECUTING", false);
    public static final ServiceCallState NOT_STARTED = new ServiceCallState("NOT_STARTED", false);
    private final String name;
    private final boolean terminalState;

    private ServiceCallState(String s, boolean flag)
    {
        name = s;
        terminalState = flag;
    }

    public boolean isTerminalState()
    {
        return terminalState;
    }

    public String toString()
    {
        return name;
    }

}
