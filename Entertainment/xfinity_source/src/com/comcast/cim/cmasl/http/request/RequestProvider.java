// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.request;


public interface RequestProvider
{

    public abstract void addHeader(String s, String s1);

    public abstract void addHttpEntityParameter(String s, String s1);

    public abstract void addQueryParameter(String s, String s1);

    public abstract Object createRequest();

    public abstract void setSocketTimeout(long l);
}
