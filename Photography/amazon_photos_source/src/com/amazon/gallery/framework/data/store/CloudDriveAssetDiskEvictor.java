// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import android.util.Log;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.gallery.framework.data.store:
//            DiskEvictor, Asset, DiskStore

public class CloudDriveAssetDiskEvictor
    implements DiskEvictor
{
    public static interface EvictionPolicy
    {

        public abstract void evict(SourceUtilizationMap sourceutilizationmap, File file, ComponentProfiler componentprofiler, int i);
    }

    public static class LastModifiedTimeComparator
        implements Comparator
    {

        public int compare(File file, File file1)
        {
            long l = file.lastModified() - file1.lastModified();
            if (l > 0L)
            {
                return 1;
            }
            if (l < 0L)
            {
                return -1;
            } else
            {
                return file.compareTo(file1);
            }
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((File)obj, (File)obj1);
        }

        public LastModifiedTimeComparator()
        {
        }
    }

    private static class OldestFileFilter
        implements FileFilter
    {

        private long filesTotalSize;
        private final String filterNameSnippet;
        private final int limit;
        private SortedSet oldestFilesSet;

        public boolean accept(File file)
        {
            if (file.getName().contains(filterNameSnippet))
            {
                filesTotalSize = filesTotalSize + file.length();
                oldestFilesSet.add(file);
                if (oldestFilesSet.size() > limit)
                {
                    oldestFilesSet.remove(oldestFilesSet.last());
                    return false;
                }
            }
            return false;
        }

        public long getFilesTotalSize()
        {
            return filesTotalSize;
        }

        public SortedSet getOldestFiles()
        {
            return oldestFilesSet;
        }

        public OldestFileFilter(int i, String s)
        {
            limit = i;
            oldestFilesSet = new TreeSet(CloudDriveAssetDiskEvictor.LAST_MODIFIED_TIME_COMPARATOR);
            filesTotalSize = 0L;
            filterNameSnippet = s;
        }
    }

    static class SourceUtilizationMap
    {

        private final int CLOUD_INDEX = 1;
        private final int DEVICE_INDEX = 0;
        private final int totalIndex = 2;
        private final long utilization[];

        public void decrement(boolean flag, long l)
        {
            this;
            JVM INSTR monitorenter ;
            if (!initialized(flag))
            {
                break MISSING_BLOCK_LABEL_85;
            }
            long al[];
            int i;
            long l1;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            l1 = l;
            if (utilization[i] < l)
            {
                l1 = utilization[i];
            }
            al = utilization;
            al[i] = al[i] - l1;
            al = utilization;
            i = totalIndex;
            al[i] = al[i] - l1;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public long get(boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            long al[] = utilization;
            int i;
            long l;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            l = al[i];
            this;
            JVM INSTR monitorexit ;
            return l;
            Exception exception;
            exception;
            throw exception;
        }

        public void increment(boolean flag, long l)
        {
            this;
            JVM INSTR monitorenter ;
            long al[];
            if (!initialized(flag))
            {
                break MISSING_BLOCK_LABEL_59;
            }
            al = utilization;
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            al[i] = al[i] + l;
            al = utilization;
            i = totalIndex;
            al[i] = al[i] + l;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public boolean initialized(boolean flag)
        {
            boolean flag1 = true;
            this;
            JVM INSTR monitorenter ;
            long al[] = utilization;
            int i;
            long l;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            l = al[i];
            if (l >= 0L)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            this;
            JVM INSTR monitorexit ;
            return flag;
            Exception exception;
            exception;
            throw exception;
        }

        public void set(boolean flag, long l)
        {
            this;
            JVM INSTR monitorenter ;
            long al[];
            int i;
            long l1;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            l1 = utilization[i];
            utilization[i] = l;
            al = utilization;
            i = totalIndex;
            al[i] = al[i] + (l - l1);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public SourceUtilizationMap()
        {
            utilization = new long[totalIndex + 1];
            for (int i = 0; i < utilization.length; i++)
            {
                utilization[i] = -1L;
            }

        }
    }


    static final Comparator LAST_MODIFIED_TIME_COMPARATOR = new LastModifiedTimeComparator();
    final File cacheLocation;
    private long cloudSourceCapacity;
    private long deviceSourceCapacity;
    private final EvictionPolicy evictionPolicy = new EvictionPolicy() {

        final CloudDriveAssetDiskEvictor this$0;

        private long evictAndUpdateUtilization(SourceUtilizationMap sourceutilizationmap, File file1, int j, ComponentProfiler componentprofiler, boolean flag)
        {
            long l4 = getSourceCapacity(flag);
            if (sourceutilizationmap.initialized(flag) && sourceutilizationmap.get(flag) < l4)
            {
                return 0L;
            }
            file1 = file1.listFiles();
            if (file1 == null || file1.length == 0)
            {
                sourceutilizationmap.set(flag, 0L);
                return 0L;
            }
            OldestFileFilter oldestfilefilter = new OldestFileFilter(j, getTag(flag));
            int i1 = file1.length;
            j = 0;
            while (j < i1) 
            {
                File file3 = file1[j];
                File afile[] = file3.listFiles();
                if (afile == null)
                {
                    file3.delete();
                } else
                {
                    int j1 = afile.length;
                    int k = 0;
                    while (k < j1) 
                    {
                        File file4 = afile[k];
                        if (!flag || !String.valueOf(Asset.BoundingSize.BOUND_256.getSize()).equals(file4.getName()))
                        {
                            file4.listFiles(oldestfilefilter);
                        }
                        k++;
                    }
                }
                j++;
            }
            long l5 = oldestfilefilter.getFilesTotalSize();
            sourceutilizationmap.set(flag, l5);
            long l2 = 0L;
            file1 = oldestfilefilter.getOldestFiles().iterator();
            do
            {
                File file2;
label0:
                {
                    if (file1.hasNext())
                    {
                        file2 = (File)file1.next();
                        if (l2 < l5 - l4)
                        {
                            break label0;
                        }
                    }
                    sourceutilizationmap.decrement(flag, l2);
                    return l2;
                }
                Log.v("EvictionPolicy", (new StringBuilder()).append("Deleting assets of ").append(file2.getAbsoluteFile()).toString());
                if (file2.delete())
                {
                    long l3 = l2 + file2.length();
                    l2 = l3;
                    if (flag)
                    {
                        l2 = l3;
                        if (componentprofiler != null)
                        {
                            componentprofiler.trackEvent(DiskStore.MetricsEvent.CacheEvict);
                            l2 = l3;
                        }
                    }
                }
            } while (true);
        }

        private String getTag(boolean flag)
        {
            return Asset.getTag(flag);
        }

        public void evict(SourceUtilizationMap sourceutilizationmap, File file1, ComponentProfiler componentprofiler, int j)
        {
            evictAndUpdateUtilization(sourceutilizationmap, file1, j, componentprofiler, false);
            evictAndUpdateUtilization(sourceutilizationmap, file1, j, componentprofiler, true);
        }

            
            {
                this$0 = CloudDriveAssetDiskEvictor.this;
                super();
            }
    };
    private final Executor executor = Executors.newFixedThreadPool(1);
    private int forceCleanupModCount;
    private AtomicInteger modCount;
    private ComponentProfiler profiler;
    private final SourceUtilizationMap utilizationMap = new SourceUtilizationMap();

    public CloudDriveAssetDiskEvictor(File file, long l, long l1, int i)
    {
        cacheLocation = file;
        modCount = new AtomicInteger(0);
        deviceSourceCapacity = l1;
        cloudSourceCapacity = l;
        forceCleanupModCount = i;
    }

    private long getSourceCapacity(boolean flag)
    {
        if (flag)
        {
            return cloudSourceCapacity;
        } else
        {
            return deviceSourceCapacity;
        }
    }

    public void cleanUp()
    {
        executor.execute(new Runnable() {

            final CloudDriveAssetDiskEvictor this$0;

            public void run()
            {
                cleanUpSynchronous(forceCleanupModCount);
            }

            
            {
                this$0 = CloudDriveAssetDiskEvictor.this;
                super();
            }
        });
    }

    public void cleanUpSynchronous(int i)
    {
        evictionPolicy.evict(utilizationMap, cacheLocation, profiler, i);
    }

    public void onStoreAsset(Asset asset, boolean flag)
    {
        if (flag || asset.getP2Size() != 256)
        {
            SourceUtilizationMap sourceutilizationmap = utilizationMap;
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            sourceutilizationmap.increment(flag, asset.getAsset().length());
        }
    }

    public void setProfiler(Profiler profiler1)
    {
        profiler = new ComponentProfiler(profiler1, com/amazon/gallery/framework/data/store/DiskStore);
    }

    public boolean shouldPerformCleanup()
    {
        boolean flag = false;
        if (modCount.incrementAndGet() == forceCleanupModCount)
        {
            modCount.set(0);
            flag = true;
        }
        return flag;
    }



}
