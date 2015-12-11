// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.config;


public interface CALConfiguration
{

    public abstract long getDataRevalidationIntervalInMillis();

    public abstract long getMinVersionCheckRevalidationIntervalInMillis();

    public abstract String getSplunkAppName();

    public abstract String getUserAgentPrefix();

    public abstract String getXipUri();
}
