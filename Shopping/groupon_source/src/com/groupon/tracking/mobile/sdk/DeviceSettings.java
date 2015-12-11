// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.sdk;


public interface DeviceSettings
{

    public abstract String getAdvertisingId();

    public abstract String getBcookie();

    public abstract String getClientID();

    public abstract String getConsumerId();

    public abstract String getCountryCode();

    public abstract String getDeviceID();

    public abstract String getLocale();

    public abstract String getPlatform();

    public abstract String getUserAgent();

    public abstract String getUserPermalink();

    public abstract String getVersion();
}
