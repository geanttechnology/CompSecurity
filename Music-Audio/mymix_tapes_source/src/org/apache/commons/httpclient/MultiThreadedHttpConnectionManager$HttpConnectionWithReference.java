// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.lang.ref.WeakReference;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpConnection, MultiThreadedHttpConnectionManager, HostConfiguration

private static class reference extends HttpConnection
{

    public WeakReference reference;

    public (HostConfiguration hostconfiguration)
    {
        super(hostconfiguration);
        reference = new WeakReference(this, MultiThreadedHttpConnectionManager.access$1500());
    }
}
