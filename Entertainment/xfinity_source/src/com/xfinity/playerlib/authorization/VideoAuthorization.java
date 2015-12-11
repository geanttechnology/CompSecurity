// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;


public class VideoAuthorization
{

    private final String deviceAuthorizationToken;
    private final String deviceId;
    private final String devicePlaybackToken;
    private final String sessionToken;

    public VideoAuthorization(String s, String s1, String s2, String s3)
    {
        deviceAuthorizationToken = s;
        deviceId = s1;
        sessionToken = s2;
        devicePlaybackToken = s3;
    }

    public String getDeviceAuthorizationToken()
    {
        return deviceAuthorizationToken;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public String getDevicePlaybackToken()
    {
        return devicePlaybackToken;
    }

    public String getSessionToken()
    {
        return sessionToken;
    }
}
