// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.mixtape.metrics.MixtapeMetric;
import com.amazon.mixtape.metrics.MixtapeMetricRecorder;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            GalleryMetadataSyncService

public class ThorMixtapeMetricRecorder
    implements MixtapeMetricRecorder
{

    private final Profiler profiler;

    public ThorMixtapeMetricRecorder(Profiler profiler1)
    {
        profiler = profiler1;
    }

    public void addMetric(MixtapeMetric mixtapemetric)
    {
        if (mixtapemetric instanceof com.amazon.mixtape.metrics.MixtapeMetric.Event)
        {
            mixtapemetric = (com.amazon.mixtape.metrics.MixtapeMetric.Event)mixtapemetric;
            int i = 0;
            while (i < mixtapemetric.getCount()) 
            {
                Profiler profiler1 = profiler;
                String s = com/amazon/gallery/thor/cds/GalleryMetadataSyncService.getSimpleName();
                String s2 = mixtapemetric.getEventName();
                boolean flag;
                if (!mixtapemetric.isError())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                profiler1.trackEvent(s, s2, flag);
                i++;
            }
        } else
        if (mixtapemetric instanceof com.amazon.mixtape.metrics.MixtapeMetric.Timer)
        {
            mixtapemetric = (com.amazon.mixtape.metrics.MixtapeMetric.Timer)mixtapemetric;
            int j = 0;
            while (j < mixtapemetric.getCount()) 
            {
                Profiler profiler2 = profiler;
                String s1 = com/amazon/gallery/thor/cds/GalleryMetadataSyncService.getSimpleName();
                String s3 = mixtapemetric.getEventName();
                long l = (long)mixtapemetric.getDuration();
                boolean flag1;
                if (!mixtapemetric.isError())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                profiler2.trackTimer(s1, s3, l, flag1);
                j++;
            }
        }
    }
}
