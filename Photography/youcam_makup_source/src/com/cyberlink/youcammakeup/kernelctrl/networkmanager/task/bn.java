// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;


public class bn
{

    private final com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus a;
    private final Exception b;

    public bn(com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus, Exception exception)
    {
        a = responsestatus;
        b = exception;
    }

    public Exception a()
    {
        return b;
    }

    public String toString()
    {
        if (a != null && a != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            return (new StringBuilder()).append("mStatus is not OK: ").append(a.toString()).toString();
        }
        if (b != null)
        {
            return b.toString();
        } else
        {
            return "Both mStatus and mException are null";
        }
    }
}
