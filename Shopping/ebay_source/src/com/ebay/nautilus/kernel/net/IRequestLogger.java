// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;


// Referenced classes of package com.ebay.nautilus.kernel.net:
//            Response

public interface IRequestLogger
{

    public abstract void logHostError(int i);

    public abstract void setCompleteResponse(Response response);

    public abstract void setRequestTime(long l);

    public abstract void setResponseTime(long l);
}
