// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.params;


public interface HttpParams
{

    public abstract boolean getBooleanParameter(String s, boolean flag);

    public abstract int getIntParameter(String s, int i);

    public abstract Object getParameter(String s);

    public abstract boolean isParameterFalse(String s);

    public abstract boolean isParameterTrue(String s);

    public abstract HttpParams setBooleanParameter(String s, boolean flag);

    public abstract HttpParams setIntParameter(String s, int i);

    public abstract HttpParams setLongParameter(String s, long l);

    public abstract HttpParams setParameter(String s, Object obj);
}
