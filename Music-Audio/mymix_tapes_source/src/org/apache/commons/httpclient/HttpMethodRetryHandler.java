// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.IOException;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpMethod

public interface HttpMethodRetryHandler
{

    public abstract boolean retryMethod(HttpMethod httpmethod, IOException ioexception, int i);
}
