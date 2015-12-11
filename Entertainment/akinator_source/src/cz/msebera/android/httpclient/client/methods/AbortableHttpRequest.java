// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import java.io.IOException;

public interface AbortableHttpRequest
{

    public abstract void abort();

    public abstract void setConnectionRequest(ClientConnectionRequest clientconnectionrequest)
        throws IOException;

    public abstract void setReleaseTrigger(ConnectionReleaseTrigger connectionreleasetrigger)
        throws IOException;
}
