// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.content.Context;
import android.util.Log;
import com.amazon.mixtape.account.MetadataStore;
import com.amazon.mixtape.metrics.MixtapeMetricRecorder;
import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.amazon.mixtape.service:
//            MetadataSyncException

class DatabaseSizeMetrics
{
    private static class MixtapeNamedFileFilter
        implements FilenameFilter
    {

        public boolean accept(File file, String s)
        {
            return s.contains("mixtape");
        }

        private MixtapeNamedFileFilter()
        {
        }

    }


    private static final String TAG = com/amazon/mixtape/service/DatabaseSizeMetrics.getSimpleName();
    private final Context mContext;
    private final MetadataStore mMetadataStore;
    private final MixtapeMetricRecorder mMetricRecorder;

    DatabaseSizeMetrics(Context context, MetadataStore metadatastore, MixtapeMetricRecorder mixtapemetricrecorder)
    {
        mContext = context;
        mMetadataStore = metadatastore;
        mMetricRecorder = mixtapemetricrecorder;
    }

    private long measureBytesPerNode()
    {
        long l;
        try
        {
            l = mMetadataStore.getCurrentNodesCount();
        }
        catch (MetadataSyncException metadatasyncexception)
        {
            Log.w(TAG, "Failed to collect bytes per node metric.", metadatasyncexception);
            return -1L;
        }
        if (l == 0L)
        {
            return -1L;
        }
        l = Math.round((double)mMetadataStore.getCurrentStoreSize() / (double)l);
        return l;
    }

    private long measureTotalDatabaseSize()
    {
        long l = 0L;
        MixtapeNamedFileFilter mixtapenamedfilefilter = new MixtapeNamedFileFilter();
        File file = mContext.getDatabasePath("mythicalDatabase").getParentFile();
        if (!file.exists())
        {
            return 0L;
        }
        File afile[] = file.listFiles(mixtapenamedfilefilter);
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            l += afile[i].length();
        }

        return l;
    }

    public void collect(String s)
    {
        s = new com.amazon.mixtape.metrics.MixtapeMetric.Counter(s);
        s.increment(measureTotalDatabaseSize());
        mMetricRecorder.addMetric(s);
        long l = measureBytesPerNode();
        if (l != -1L)
        {
            s = new com.amazon.mixtape.metrics.MixtapeMetric.Counter("BytesPerNode");
            s.increment(l);
            mMetricRecorder.addMetric(s);
        }
    }

}
