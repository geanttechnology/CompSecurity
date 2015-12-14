// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.system;


public interface Connectivity
{

    public abstract boolean hasWAN();

    public abstract boolean hasWifi();

    public abstract boolean hasWired();

    public abstract boolean isConnected();
}
