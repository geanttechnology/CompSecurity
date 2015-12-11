// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import java.io.IOException;
import java.net.HttpURLConnection;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            Tracer

public abstract class RetryLogic
{

    public RetryLogic()
    {
    }

    public abstract boolean shouldRetry(HttpURLConnection httpurlconnection, int i, Tracer tracer)
        throws IOException;
}
