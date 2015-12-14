// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics.customer;


public interface CustomerMetricsInfo
{

    public static final String TAG = com/amazon/gallery/foundation/metrics/customer/CustomerMetricsInfo.getName();

    public abstract boolean getAppFirstStartRecorded();

    public abstract String getAppVersionName();

    public abstract String getClientId();

    public abstract String getClientTag();

    public abstract String getCustomerId();

    public abstract String getDSN();

    public abstract String getDeviceName();

    public abstract String getModel();

    public abstract String getPlatform();

    public abstract String getPlatformVersionName();

    public abstract void reset();

    public abstract void setAppFirstStartRecorded();

}
