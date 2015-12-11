// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.params;


// Referenced classes of package com.comcast.cim.httpcomponentsandroid.params:
//            BasicHttpParams, HttpParams

public class SyncBasicHttpParams extends BasicHttpParams
{

    public SyncBasicHttpParams()
    {
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = super.clone();
        this;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        throw exception;
    }

    public Object getParameter(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = ((String) (super.getParameter(s)));
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public HttpParams setParameter(String s, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        s = super.setParameter(s, obj);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }
}
