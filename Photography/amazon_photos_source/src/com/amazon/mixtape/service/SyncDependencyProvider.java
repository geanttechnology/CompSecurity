// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import com.amazon.clouddrive.extended.AmazonCloudDriveExtended;
import com.amazon.mixtape.metrics.MixtapeMetricRecorder;
import java.util.List;

interface SyncDependencyProvider
{

    public abstract AmazonCloudDriveExtended getAmazonCloudDriveExtendedClient(String s);

    public abstract MixtapeMetricRecorder getMixtapeMetricsRecorder();

    public abstract List getPartialSyncListNodeRequests();

    public abstract boolean isSyncProgressEnabled();
}
