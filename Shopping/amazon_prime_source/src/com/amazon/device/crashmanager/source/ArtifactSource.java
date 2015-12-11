// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.source;

import com.amazon.client.metrics.MetricEvent;
import com.amazon.device.crashmanager.Artifact;

public interface ArtifactSource
{

    public abstract Artifact getNextArtifact(MetricEvent metricevent, String s);

    public abstract void saveCurrentIndex();
}
