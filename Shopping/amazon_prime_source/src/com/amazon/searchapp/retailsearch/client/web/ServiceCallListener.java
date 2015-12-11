// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;


public interface ServiceCallListener
{

    public abstract void endRequest();

    public abstract void error(Exception exception);

    public abstract void result(Object obj);

    public abstract void startRequest();
}
