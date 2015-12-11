// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;


public interface LogTrackConfiguration
{

    public abstract long aplsTrafficInterval();

    public abstract String getConfigVersion();

    public abstract int getRolloutThreshold();

    public abstract boolean isAplsImageLoadingTraffic();

    public abstract boolean isAplsLogErrorMessage();

    public abstract boolean isAplsLogErrorMessageV1();

    public abstract boolean isAplsSendRlogId();

    public abstract boolean isAplsTraffic();

    public abstract boolean isRequestErrorReportingEnabled();
}
