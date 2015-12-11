// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


abstract class ServiceManager
{

    ServiceManager()
    {
    }

    abstract void dispatch();

    abstract void onRadioPowered();

    abstract void setDispatchPeriod(int i);

    abstract void updateConnectivityStatus(boolean flag);
}
