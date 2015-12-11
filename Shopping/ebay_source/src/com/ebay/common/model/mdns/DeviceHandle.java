// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.mdns;


public class DeviceHandle
{

    public final String clientId;
    public final String deviceToken;
    public final String deviceType;

    public DeviceHandle(String s, String s1, String s2)
    {
        deviceToken = s;
        deviceType = s1;
        clientId = s2;
    }
}
