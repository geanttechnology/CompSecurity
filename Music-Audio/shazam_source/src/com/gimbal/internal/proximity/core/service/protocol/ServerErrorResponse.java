// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.service.protocol;


// Referenced classes of package com.gimbal.internal.proximity.core.service.protocol:
//            ServerError

public class ServerErrorResponse
{

    private ServerError a;

    public ServerErrorResponse()
    {
    }

    public ServerError getError()
    {
        return a;
    }

    public void setError(ServerError servererror)
    {
        a = servererror;
    }

    public String toString()
    {
        return (new StringBuilder("ServerErrorResponse [error=")).append(a).append("]").toString();
    }
}
