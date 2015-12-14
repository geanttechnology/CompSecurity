// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;


public interface NetworkListener
{

    public abstract boolean onEthernetAvailable();

    public abstract boolean onWanAvailable();

    public abstract boolean onWifiAvailable();
}
