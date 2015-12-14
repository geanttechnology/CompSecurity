// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import android.util.Log;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import java.io.File;
import java.util.Iterator;
import java.util.SortedSet;

// Referenced classes of package com.amazon.gallery.framework.data.store:
//            CloudDriveAssetDiskEvictor, Asset

class this._cls0
    implements ictionPolicy
{

    final CloudDriveAssetDiskEvictor this$0;

    private long evictAndUpdateUtilization(urceUtilizationMap urceutilizationmap, File file, int i, ComponentProfiler componentprofiler, boolean flag)
    {
        long l3 = CloudDriveAssetDiskEvictor.access$100(CloudDriveAssetDiskEvictor.this, flag);
        if (urceutilizationmap.initialized(flag) && urceutilizationmap.get(flag) < l3)
        {
            return 0L;
        }
        file = file.listFiles();
        if (file == null || file.length == 0)
        {
            urceutilizationmap.set(flag, 0L);
            return 0L;
        }
        destFileFilter destfilefilter = new destFileFilter(i, getTag(flag));
        int k = file.length;
        i = 0;
        while (i < k) 
        {
            File file2 = file[i];
            File afile[] = file2.listFiles();
            if (afile == null)
            {
                file2.delete();
            } else
            {
                int l = afile.length;
                int j = 0;
                while (j < l) 
                {
                    File file3 = afile[j];
                    if (!flag || !String.valueOf(getTag.getTag()).equals(file3.getName()))
                    {
                        file3.listFiles(destfilefilter);
                    }
                    j++;
                }
            }
            i++;
        }
        long l4 = destfilefilter.getFilesTotalSize();
        urceutilizationmap.set(flag, l4);
        long l1 = 0L;
        file = destfilefilter.getOldestFiles().iterator();
        do
        {
            File file1;
label0:
            {
                if (file.hasNext())
                {
                    file1 = (File)file.next();
                    if (l1 < l4 - l3)
                    {
                        break label0;
                    }
                }
                urceutilizationmap.decrement(flag, l1);
                return l1;
            }
            Log.v("EvictionPolicy", (new StringBuilder()).append("Deleting assets of ").append(file1.getAbsoluteFile()).toString());
            if (file1.delete())
            {
                long l2 = l1 + file1.length();
                l1 = l2;
                if (flag)
                {
                    l1 = l2;
                    if (componentprofiler != null)
                    {
                        componentprofiler.trackEvent(vict);
                        l1 = l2;
                    }
                }
            }
        } while (true);
    }

    private String getTag(boolean flag)
    {
        return Asset.getTag(flag);
    }

    public void evict(urceUtilizationMap urceutilizationmap, File file, ComponentProfiler componentprofiler, int i)
    {
        evictAndUpdateUtilization(urceutilizationmap, file, i, componentprofiler, false);
        evictAndUpdateUtilization(urceutilizationmap, file, i, componentprofiler, true);
    }

    urceUtilizationMap()
    {
        this$0 = CloudDriveAssetDiskEvictor.this;
        super();
    }
}
