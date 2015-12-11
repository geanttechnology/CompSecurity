// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.source;

import android.os.DropBoxManager;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.device.crashmanager.Artifact;
import com.amazon.dp.logger.DPLogger;
import java.io.IOException;
import java.util.Set;

// Referenced classes of package com.amazon.device.crashmanager.source:
//            ArtifactSource, SettingsStore

public class DropBoxArtifactSource
    implements ArtifactSource
{

    private static final DPLogger log = new DPLogger("CrashManager.DropBoxArtifactSource");
    protected final DropBoxManager mDropBoxManager;
    private long mLastTimeIndexMillis;
    private long mLastTimeMapBuiltIndexMillis;
    protected final SettingsStore mSettingsStore;
    private final Set mTags;

    public DropBoxArtifactSource(DropBoxManager dropboxmanager, SettingsStore settingsstore, Set set)
    {
        if (dropboxmanager == null)
        {
            throw new IllegalArgumentException("DropBoxManager cannot be null");
        }
        if (settingsstore == null)
        {
            throw new IllegalArgumentException("SettingsStore cannot be null");
        }
        if (set == null)
        {
            throw new IllegalArgumentException("Tags cannot be null");
        } else
        {
            mDropBoxManager = dropboxmanager;
            mSettingsStore = settingsstore;
            mTags = set;
            mLastTimeIndexMillis = mSettingsStore.getLong(SettingsStore.SettingsKey.DROPBOX_TIME_INDEX_KEY, 0L);
            mLastTimeMapBuiltIndexMillis = mSettingsStore.getLong(SettingsStore.SettingsKey.MAP_BUILD_INDEX_KEY, mLastTimeIndexMillis);
            return;
        }
    }

    private android.os.DropBoxManager.Entry getNextCrashEntry(long l)
    {
        return mDropBoxManager.getNextEntry(null, l);
    }

    public Artifact getNextArtifact(MetricEvent metricevent, String s)
    {
_L5:
        android.os.DropBoxManager.Entry entry;
        long l;
        if ("BUILD_MAP".equals(s))
        {
            l = mLastTimeMapBuiltIndexMillis;
        } else
        {
            l = mLastTimeIndexMillis;
        }
        entry = getNextCrashEntry(l);
        if (entry == null) goto _L2; else goto _L1
_L1:
        l = entry.getTimeMillis();
        if ("ARTIFACT_UPLOAD".equals(s) && l > mLastTimeMapBuiltIndexMillis)
        {
            log.info("getNextArtifact", "The crash file was added to dropbox after the first iteration to build the map. No further crashes will be processed now", new Object[0]);
            return null;
        }
        Artifact artifact;
        IllegalArgumentException illegalargumentexception;
        if ("BUILD_MAP".equals(s))
        {
            mLastTimeMapBuiltIndexMillis = l;
        } else
        {
            mLastTimeIndexMillis = l;
        }
        if (!mTags.contains(entry.getTag()) || (entry.getFlags() & 1) != 0)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        log.debug("getNextArtifact", "Return the artifact", new Object[0]);
        artifact = new Artifact(entry.getTag(), entry.getInputStream(), entry.getTimeMillis());
        return artifact;
        illegalargumentexception;
        log.error("getNextArtifact", "IllegalArgumentException thrown when fetching entry from DropBox", new Object[] {
            illegalargumentexception
        });
_L3:
        entry.close();
        continue; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        log.error("getNextArtifact", "IOException thrown when fetching entry from DropBox", new Object[] {
            ioexception
        });
        metricevent.addCounter("dropBoxIOException", 1.0D);
        metricevent.addString("dropBoxIOExceptionMessage", "IOException while fetching DropBox entry InputStream");
        if (true) goto _L3; else goto _L2
_L2:
        return null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void saveBuildMapIndex()
    {
        mSettingsStore.saveLong(SettingsStore.SettingsKey.MAP_BUILD_INDEX_KEY, mLastTimeMapBuiltIndexMillis);
    }

    public void saveCurrentIndex()
    {
        mSettingsStore.saveLong(SettingsStore.SettingsKey.DROPBOX_TIME_INDEX_KEY, mLastTimeIndexMillis);
    }

}
