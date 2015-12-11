// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client.methods;

import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionRequest;
import com.comcast.cim.httpcomponentsandroid.conn.ConnectionReleaseTrigger;
import java.io.IOException;

public interface AbortableHttpRequest
{

    public abstract void setConnectionRequest(ClientConnectionRequest clientconnectionrequest)
        throws IOException;

    public abstract void setReleaseTrigger(ConnectionReleaseTrigger connectionreleasetrigger)
        throws IOException;
}
