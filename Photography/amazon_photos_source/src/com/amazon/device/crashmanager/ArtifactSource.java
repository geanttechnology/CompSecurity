// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import com.amazon.client.metrics.MetricEvent;

// Referenced classes of package com.amazon.device.crashmanager:
//            Artifact

interface ArtifactSource
{

    public abstract Artifact getNextArtifact(MetricEvent metricevent);

    public abstract void saveCurrentIndex();
}
