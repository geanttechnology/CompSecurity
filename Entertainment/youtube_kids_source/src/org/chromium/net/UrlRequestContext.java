// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import java.util.concurrent.Executor;

// Referenced classes of package org.chromium.net:
//            UrlRequestListener, UrlRequest

public abstract class UrlRequestContext
{

    public UrlRequestContext()
    {
    }

    public abstract UrlRequest a(String s, UrlRequestListener urlrequestlistener, Executor executor);
}
