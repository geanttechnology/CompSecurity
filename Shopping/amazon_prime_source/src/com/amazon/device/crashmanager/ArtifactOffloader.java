// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import android.os.Environment;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.device.crashmanager.source.ArtifactSource;
import com.amazon.device.utils.MediaScannerHelper;
import com.amazon.device.utils.StatusNotifier;
import com.amazon.dp.logger.DPLogger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// Referenced classes of package com.amazon.device.crashmanager:
//            Artifact

class ArtifactOffloader
{

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd.hhmmss.SSS");
    private static final File LOGS_DIR = new File(Environment.getExternalStorageDirectory(), "KindleLogs");
    private static final File TEMP_LOGS_DIR = new File(Environment.getExternalStorageDirectory(), "tmp/crashes");
    private static final DPLogger log = new DPLogger("CrashManager.ArtifactOffloader");
    private final List mArtifactSources;
    private final String mDeviceSerialNumber;
    private final MediaScannerHelper mMediaScannerHelper;
    private final StatusNotifier mStatusNotifier;

    public ArtifactOffloader(List list, StatusNotifier statusnotifier, MediaScannerHelper mediascannerhelper, String s)
    {
label0:
        {
            super();
            if (list == null)
            {
                throw new IllegalArgumentException("Artifact sources must not be null.");
            }
            if (statusnotifier == null)
            {
                throw new IllegalArgumentException("StatusNotifier must not be null.");
            }
            if (mediascannerhelper == null)
            {
                throw new IllegalArgumentException("MediaScannerHelper must not be null.");
            }
            mArtifactSources = list;
            mStatusNotifier = statusnotifier;
            mMediaScannerHelper = mediascannerhelper;
            if (s != null)
            {
                list = s;
                if (!s.trim().isEmpty())
                {
                    break label0;
                }
            }
            list = "UNKNOWN_DSN";
        }
        mDeviceSerialNumber = list;
    }

    private File createTempFile()
    {
        File file = new File(TEMP_LOGS_DIR, (new StringBuilder()).append("crashes_").append(mDeviceSerialNumber).append("_").append(DATE_FORMAT.format(new Date())).append(".zip").toString());
        log.debug("createTempFile", "Creating temp file", new Object[] {
            file.getAbsolutePath()
        });
        file.getParentFile().mkdirs();
        return file;
    }

    private ZipOutputStream getZipStream(File file)
        throws IOException
    {
        log.debug("getNextZipStream", "Creating stream for", new Object[] {
            file.getAbsolutePath()
        });
        file = new ZipOutputStream(new FileOutputStream(file));
        file.setLevel(9);
        file.setMethod(8);
        return file;
    }

    private boolean renameFile(File file)
    {
        File file1 = new File(LOGS_DIR, (new StringBuilder()).append("crashes_").append(mDeviceSerialNumber).append("_").append(DATE_FORMAT.format(new Date())).append(".zip").toString());
        file1.getParentFile().mkdirs();
        boolean flag = file.renameTo(file1);
        if (!flag)
        {
            log.info("RenameLogFile", "Unable to rename logfile", new Object[] {
                "OldFile", file.getAbsolutePath(), "NewFile", file1.getAbsolutePath()
            });
        }
        return flag;
    }

    public String generateOffloadFileName(String s, long l)
    {
        Date date = new Date(l);
        return (new StringBuilder()).append(s).append("_").append(DATE_FORMAT.format(date)).toString();
    }

    public int offloadArtifacts(MetricEvent metricevent, int i)
        throws IOException
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj8;
        Object obj9;
        byte abyte0[];
        int j;
        int k;
        abyte0 = new byte[10000];
        j = 0;
        k = 0;
        obj2 = null;
        obj3 = null;
        obj8 = null;
        obj = null;
        obj1 = null;
        obj9 = null;
        log.info("offloadArtifacts", "Offloading artifacts.", new Object[0]);
        mStatusNotifier.fireNotification("Offloading Crashes", i);
        Iterator iterator = mArtifactSources.iterator();
_L2:
        j = k;
        obj = obj9;
        obj2 = obj8;
        obj1 = obj9;
        obj3 = obj8;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_911;
        }
        j = k;
        obj = obj9;
        obj2 = obj8;
        obj1 = obj9;
        obj3 = obj8;
        ArtifactSource artifactsource = (ArtifactSource)iterator.next();
        Object obj4;
        Object obj6;
        int i1;
        i1 = k;
        obj4 = obj9;
        obj6 = obj8;
        j = k;
        obj = obj9;
        obj2 = obj8;
        obj1 = obj9;
        obj3 = obj8;
        log.debug("offloadArtifacts", (new StringBuilder()).append("Offloading Artifacts for source: ").append(artifactsource.getClass().getSimpleName()).toString(), new Object[0]);
        Object obj5;
        Object obj7;
        int l;
        obj7 = obj8;
        obj5 = obj9;
        l = k;
_L6:
        i1 = l;
        obj4 = obj5;
        obj6 = obj7;
        j = l;
        obj = obj5;
        obj2 = obj7;
        obj1 = obj5;
        obj3 = obj7;
        Artifact artifact = artifactsource.getNextArtifact(metricevent, "ARTIFACT_OFFLOAD");
        k = l;
        obj9 = obj5;
        obj8 = obj7;
        if (artifact == null) goto _L2; else goto _L1
_L1:
        obj9 = obj5;
        obj8 = obj7;
        if (obj7 != null)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        j = l;
        obj = obj5;
        obj2 = obj7;
        obj8 = obj5;
        obj1 = obj5;
        obj3 = obj7;
        obj9 = createTempFile();
        j = l;
        obj = obj9;
        obj2 = obj7;
        obj8 = obj9;
        obj1 = obj9;
        obj3 = obj7;
        obj4 = getZipStream(((File) (obj9)));
        obj8 = obj4;
        i1 = l;
        obj4 = obj9;
        obj6 = obj8;
        j = l;
        obj = obj9;
        obj2 = obj8;
        obj1 = obj9;
        obj3 = obj8;
        ((ZipOutputStream) (obj8)).putNextEntry(new ZipEntry(generateOffloadFileName(artifact.getTag(), artifact.getCreationTimeUTCMillis())));
        i1 = l;
        obj4 = obj9;
        obj6 = obj8;
        j = l;
        obj = obj9;
        obj2 = obj8;
        obj1 = obj9;
        obj3 = obj8;
        obj5 = artifact.getInputStream();
_L7:
        if (((InputStream) (obj5)).available() <= 0) goto _L4; else goto _L3
_L3:
        j = ((InputStream) (obj5)).read(abyte0);
        if (j != -1) goto _L5; else goto _L4
_L4:
        i1 = l;
        obj4 = obj9;
        obj6 = obj8;
        j = l;
        obj = obj9;
        obj2 = obj8;
        obj1 = obj9;
        obj3 = obj8;
        ((InputStream) (obj5)).close();
        i1 = l;
        obj4 = obj9;
        obj6 = obj8;
        j = l;
        obj = obj9;
        obj2 = obj8;
        obj1 = obj9;
        obj3 = obj8;
        ((ZipOutputStream) (obj8)).closeEntry();
        l++;
        i1 = l;
        obj4 = obj9;
        obj6 = obj8;
        j = l;
        obj = obj9;
        obj2 = obj8;
        obj1 = obj9;
        obj3 = obj8;
        mStatusNotifier.updateFilesCount(l);
        obj5 = obj9;
        obj7 = obj8;
          goto _L6
        obj5;
        j = i1;
        obj = obj4;
        obj2 = obj6;
        obj1 = obj4;
        obj3 = obj6;
        log.error("offloadCrashEntries", "IOException while offloading crashes.", new Object[] {
            obj5
        });
        k = i1;
        obj9 = obj4;
        obj8 = obj6;
          goto _L2
        metricevent;
        obj1 = obj;
        obj3 = obj2;
        log.error("createOffloaderAndOffload", "Exception thrown while offloading crashes.", new Object[] {
            metricevent
        });
        mMediaScannerHelper.scanDirectory(LOGS_DIR);
        if (obj2 != null)
        {
            ((ZipOutputStream) (obj2)).close();
            renameFile(((File) (obj)));
        }
        mStatusNotifier.fireNotification("Finished offloading Crashes", i);
_L8:
        log.debug("offloadCrashEntries", "Done offloading crashes", new Object[0]);
        return j;
        obj5;
        i1 = l;
        obj4 = obj8;
        obj6 = obj7;
        j = l;
        obj = obj8;
        obj2 = obj7;
        obj1 = obj8;
        obj3 = obj7;
        throw new IllegalStateException("Failed to create zip output stream.", ((Throwable) (obj5)));
        metricevent;
        mMediaScannerHelper.scanDirectory(LOGS_DIR);
        if (obj3 != null)
        {
            ((ZipOutputStream) (obj3)).close();
            renameFile(((File) (obj1)));
        }
        mStatusNotifier.fireNotification("Finished offloading Crashes", i);
        throw metricevent;
_L5:
        ((ZipOutputStream) (obj8)).write(abyte0, 0, j);
          goto _L7
        Exception exception;
        exception;
        i1 = l;
        obj4 = obj9;
        obj6 = obj8;
        j = l;
        obj = obj9;
        obj2 = obj8;
        obj1 = obj9;
        obj3 = obj8;
        ((InputStream) (obj5)).close();
        i1 = l;
        obj4 = obj9;
        obj6 = obj8;
        j = l;
        obj = obj9;
        obj2 = obj8;
        obj1 = obj9;
        obj3 = obj8;
        throw exception;
        mMediaScannerHelper.scanDirectory(LOGS_DIR);
        if (obj8 != null)
        {
            ((ZipOutputStream) (obj8)).close();
            renameFile(((File) (obj9)));
        }
        mStatusNotifier.fireNotification("Finished offloading Crashes", i);
        j = k;
          goto _L8
    }

}
