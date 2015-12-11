// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.source;

import com.amazon.client.metrics.MetricEvent;
import com.amazon.device.crashmanager.Artifact;
import com.amazon.dp.logger.DPLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.amazon.device.crashmanager.source:
//            ArtifactSource, SettingsStore

public class RamDumpArtifactSource
    implements ArtifactSource
{
    private static final class LastModifiedFileComparator
        implements Comparator
    {

        public int compare(File file, File file1)
        {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file1.lastModified()));
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((File)obj, (File)obj1);
        }

        private LastModifiedFileComparator()
        {
        }

    }

    private class RamDumpDirectoryFilter
        implements FilenameFilter
    {

        final RamDumpArtifactSource this$0;

        public boolean accept(File file, String s)
        {
            file = new File(file, s);
            return RamDumpArtifactSource.RAMDUMP_FOLDER_NAMES.contains(s) && file.isDirectory();
        }

        private RamDumpDirectoryFilter()
        {
            this$0 = RamDumpArtifactSource.this;
            super();
        }

    }


    static final String KMSG_LOG_FILE = "kmsg.log";
    public static final String KMSG_LOG_TAG = "RAMDUMP_KMSG_LOG";
    static final Set RAMDUMP_FOLDER_NAMES;
    private static final DPLogger log = new DPLogger("RamDumpArtifactSource");
    private final File mAvailableRamDumpDirectories[];
    private long mLastRamDumpTimeIndex;
    private final File mRamDumpPartition;
    private final SettingsStore mSettingsStore;

    public RamDumpArtifactSource(SettingsStore settingsstore)
    {
        this("/ramdump", settingsstore);
    }

    public RamDumpArtifactSource(String s, SettingsStore settingsstore)
    {
        if (settingsstore == null)
        {
            throw new IllegalArgumentException("SettingsStore cannot be null");
        }
        if (s == null)
        {
            throw new IllegalArgumentException("ramdumpPartition cannot be null");
        }
        mSettingsStore = settingsstore;
        mLastRamDumpTimeIndex = mSettingsStore.getLong(SettingsStore.SettingsKey.RAMDUMP_TIME_INDEX_KEY, 0L);
        mRamDumpPartition = new File(s);
        if (!mRamDumpPartition.isDirectory())
        {
            log.info("RamDumpArtifactSource", "RamDump partition is missing", new Object[0]);
        }
        mAvailableRamDumpDirectories = mRamDumpPartition.listFiles(new RamDumpDirectoryFilter());
        if (mAvailableRamDumpDirectories != null)
        {
            Arrays.sort(mAvailableRamDumpDirectories, new LastModifiedFileComparator());
        }
    }

    public Artifact getNextArtifact(MetricEvent metricevent, String s)
    {
        if (mAvailableRamDumpDirectories != null) goto _L2; else goto _L1
_L1:
        log.info("getNextArtifact", "no ramdumps exist", new Object[0]);
_L6:
        return null;
_L2:
        int i = 0;
_L4:
        if (i >= mAvailableRamDumpDirectories.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mAvailableRamDumpDirectories[i].lastModified() <= mLastRamDumpTimeIndex)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        mLastRamDumpTimeIndex = mAvailableRamDumpDirectories[i].lastModified();
        s = new Artifact("RAMDUMP_KMSG_LOG", new FileInputStream(new File(mAvailableRamDumpDirectories[i], "kmsg.log")), mAvailableRamDumpDirectories[i].lastModified());
        return s;
        s;
        log.warn("getNextArtifact", (new StringBuilder()).append("No kernel message log file exists in ramdump directory").append(mAvailableRamDumpDirectories[i]).toString(), new Object[0]);
        metricevent.addCounter("ramdumpIOException", 1.0D);
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void saveCurrentIndex()
    {
        mSettingsStore.saveLong(SettingsStore.SettingsKey.RAMDUMP_TIME_INDEX_KEY, mLastRamDumpTimeIndex);
    }

    static 
    {
        HashSet hashset = new HashSet(3);
        hashset.add("rd1");
        hashset.add("rd2");
        hashset.add("rd3");
        RAMDUMP_FOLDER_NAMES = Collections.unmodifiableSet(hashset);
    }
}
