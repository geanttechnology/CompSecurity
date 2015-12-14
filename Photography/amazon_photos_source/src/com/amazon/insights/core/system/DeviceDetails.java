// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.system;

import java.util.Locale;

public interface DeviceDetails
{

    public abstract Locale locale();

    public abstract String manufacturer();

    public abstract String model();

    public abstract String platform();

    public abstract String platformVersion();
}
