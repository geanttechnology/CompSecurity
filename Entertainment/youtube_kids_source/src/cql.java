// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.apache.http.client.HttpResponseException;

public class cql
{

    public final qs a;

    public cql(qs qs1)
    {
        a = (qs)b.a(qs1);
    }

    public boolean a(Exception exception)
    {
        if ((exception instanceof bzv) && ((bzv)exception).a())
        {
            bmo.c("operation needs a full YouTube account");
            return false;
        }
        if (!a.a())
        {
            return false;
        }
        return (exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 401;
    }

    public volatile boolean a(Object obj, Exception exception)
    {
        return a(exception);
    }
}
