// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;

import amazon.communication.connection.ConnectionClosedDetails;

public interface GatewayConnectivity
{
    public static interface GatewayConnectivityMonitor
    {

        public abstract void onGatewayConnectionClosed(ConnectionClosedDetails connectioncloseddetails);

        public abstract void onGatewayConnectionEstablished();
    }

}
