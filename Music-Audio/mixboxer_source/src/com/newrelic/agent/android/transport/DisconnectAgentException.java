// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.transport;


// Referenced classes of package com.newrelic.agent.android.transport:
//            TransportException

public class DisconnectAgentException extends TransportException
{

    private static final long serialVersionUID = 1L;

    public DisconnectAgentException()
    {
        super("The collector has asked the agent to disconnect");
    }
}
