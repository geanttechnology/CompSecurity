// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;


public class DeviceDataInfo
{

    public final boolean isPersistent;
    public final String value;

    public DeviceDataInfo(String s, boolean flag)
    {
        value = s;
        isPersistent = flag;
    }
}
