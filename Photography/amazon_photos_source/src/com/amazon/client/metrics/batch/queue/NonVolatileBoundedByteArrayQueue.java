// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.queue;

import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.PeriodicMetricReporter;
import com.amazon.client.metrics.configuration.BatchPipelineConfiguration;
import com.amazon.dp.logger.DPLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

// Referenced classes of package com.amazon.client.metrics.batch.queue:
//            BoundedByteArrayQueue

public class NonVolatileBoundedByteArrayQueue extends BoundedByteArrayQueue
{

    private static final DPLogger log = new DPLogger("Metrics:NonVolatileBoundedByteArrayQueue");
    private final File mDirOfBatchFiles;
    private final Queue mFileNameQueue = new LinkedList();

    public NonVolatileBoundedByteArrayQueue(BatchPipelineConfiguration batchpipelineconfiguration, PeriodicMetricReporter periodicmetricreporter, File file)
        throws IllegalArgumentException, IOException
    {
        super(batchpipelineconfiguration, periodicmetricreporter);
        if (batchpipelineconfiguration.getMaxBatchQueueEntries() <= 0L)
        {
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("queue.capacityError", 1.0D);
            throw new IllegalArgumentException("Capacity of queue must be greater than 0 entry");
        }
        if (file == null || !file.isDirectory())
        {
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("queue.dirError", 1.0D);
            throw new IllegalArgumentException("dirOfBatchFiles must not be null and should be a valid directory.");
        } else
        {
            mDirOfBatchFiles = file;
            readPersistedData();
            trimQueueToFit();
            return;
        }
    }

    private String getAbsolutePath(String s)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(mDirOfBatchFiles.getAbsolutePath());
        File file = mDirOfBatchFiles;
        return (new StringBuilder(stringbuilder.append(File.separator).append(s).toString())).toString();
    }

    private void readPersistedData()
    {
        File afile[] = mDirOfBatchFiles.listFiles();
        Arrays.sort(afile, new Comparator() {

            final NonVolatileBoundedByteArrayQueue this$0;

            public int compare(File file, File file1)
            {
                Long long1 = new Long(0L);
                Long long2 = Long.valueOf(file.getName());
                file = long2;
_L1:
                long1 = new Long(0L);
                long2 = Long.valueOf(file1.getName());
                file1 = long2;
_L2:
                return file.compareTo(file1);
                NumberFormatException numberformatexception;
                numberformatexception;
                mPeriodicMetricReporter.getMetricEvent().incrementCounter("queueRead.NumberFormatException", 1.0D);
                NonVolatileBoundedByteArrayQueue.log.error("readPersistedData", (new StringBuilder()).append("Unsupported file name format: ").append(file.getName()).toString(), new Object[0]);
                file = long1;
                  goto _L1
                numberformatexception;
                mPeriodicMetricReporter.getMetricEvent().incrementCounter("queueRead.NumberFormatException", 1.0D);
                NonVolatileBoundedByteArrayQueue.log.error("readPersistedData", (new StringBuilder()).append("Unsupported file name format: ").append(file1.getName()).toString(), new Object[0]);
                file1 = long1;
                  goto _L2
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((File)obj, (File)obj1);
            }

            
            {
                this$0 = NonVolatileBoundedByteArrayQueue.this;
                super();
            }
        });
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            mBytesUsed = mBytesUsed + afile[i].length();
            mFileNameQueue.add(afile[i].getName());
            mNumEntries = mNumEntries + 1L;
        }

    }

    private void trimQueueToFit()
        throws IOException
    {
        for (; mBytesUsed > mBatchPipelineConfiguration.getMaxBatchQueueCapacityBytes() || mNumEntries > mBatchPipelineConfiguration.getMaxBatchQueueEntries(); mNumEntries = mNumEntries - 1L)
        {
            log.debug("trimQueueToFit", "Queue is full. Dropping an element", new Object[0]);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("droppedBatches", 1.0D);
            Object obj = (String)mFileNameQueue.poll();
            if (obj == null)
            {
                mPeriodicMetricReporter.getMetricEvent().incrementCounter("queueSizeError", 1.0D);
                throw new IllegalArgumentException("All items removed and the queue is still full.");
            }
            obj = new File(getAbsolutePath(((String) (obj))));
            mBytesUsed = mBytesUsed - ((File) (obj)).length();
            ((File) (obj)).delete();
        }

    }

    public void add(byte abyte0[], boolean flag)
        throws IllegalArgumentException, IOException
    {
        this;
        JVM INSTR monitorenter ;
        add(abyte0, flag, System.currentTimeMillis());
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }

    public void add(byte abyte0[], boolean flag, long l)
        throws IllegalArgumentException, IOException
    {
        this;
        JVM INSTR monitorenter ;
        validateInput(abyte0);
        mBytesUsed = mBytesUsed + (long)abyte0.length;
        mNumEntries = mNumEntries + 1L;
        trimQueueToFit();
        FileOutputStream fileoutputstream;
        FileOutputStream fileoutputstream1;
        Object obj;
        fileoutputstream1 = null;
        obj = null;
        fileoutputstream = fileoutputstream1;
        String s = String.valueOf(l);
        fileoutputstream = fileoutputstream1;
        fileoutputstream1 = new FileOutputStream(getAbsolutePath(s));
        fileoutputstream1.write(abyte0);
        if (fileoutputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        fileoutputstream1.close();
        mFileNameQueue.add(s);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        notifyListeners();
        this;
        JVM INSTR monitorexit ;
        return;
        IOException ioexception;
        ioexception;
        fileoutputstream1 = obj;
_L4:
        fileoutputstream = fileoutputstream1;
        mBytesUsed = mBytesUsed - (long)abyte0.length;
        fileoutputstream = fileoutputstream1;
        mNumEntries = mNumEntries - 1L;
        fileoutputstream = fileoutputstream1;
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("addBatchesIOFailure", 1.0D);
        fileoutputstream = fileoutputstream1;
        log.error("add", (new StringBuilder()).append("Unable to persist the serializedObject to internal Storage.").append(ioexception.getMessage()).toString(), new Object[0]);
        fileoutputstream = fileoutputstream1;
        throw ioexception;
        abyte0;
_L2:
        if (fileoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        fileoutputstream.close();
        throw abyte0;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        abyte0;
        fileoutputstream = fileoutputstream1;
        if (true) goto _L2; else goto _L1
_L1:
        ioexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void purgeExpiredBatches()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        long l1;
        long l2;
        l = System.currentTimeMillis();
        l1 = mBatchPipelineConfiguration.getExpiryTimeMillis();
        l2 = mNumEntries;
_L1:
        long l3;
        if (mFileNameQueue.peek() == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        l3 = Long.parseLong((String)mFileNameQueue.peek());
        if (l3 >= l - l1)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        remove();
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("expiredBatches", 1.0D);
          goto _L1
        Object obj;
        obj;
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("removeBatchesIOFailure", 1.0D);
        log.error("purgeExpiredBatches", (new StringBuilder()).append("Unabled to purge batch.").append(((IOException) (obj)).getMessage()).toString(), new Object[0]);
          goto _L1
        obj;
        throw obj;
        log.debug("purgeExpiredBatches", "Number of batches purged: ", new Object[] {
            Long.valueOf(l2 - mNumEntries)
        });
        this;
        JVM INSTR monitorexit ;
    }

    public byte[] remove()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        String s = (String)mFileNameQueue.poll();
        Object obj = null;
        if (s == null) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj3;
        obj1 = null;
        obj3 = null;
        obj = obj1;
        File file = new File(getAbsolutePath(s));
        obj = obj1;
        long l = file.length();
        if (l <= 0x7fffffffL) goto _L4; else goto _L3
_L3:
        obj = obj1;
        log.error("remove", "size of metrics batch file should not be greater than Integer.MAX_VALUE", new Object[] {
            "file size", Long.valueOf(l)
        });
        obj = obj1;
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("removeBatchMAXLengthError", 1.0D);
        obj = obj1;
        throw new IOException("Size of metrics batch file greater than Integer.MAX_VALUE");
        Object obj2;
        obj2;
        obj1 = obj3;
_L9:
        obj = obj1;
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("removeBatchesIOFailure", 1.0D);
        obj = obj1;
        log.error("remove", (new StringBuilder()).append("Unable to delete the file.").append(((IOException) (obj2)).getMessage()).toString(), new Object[0]);
        obj = obj1;
        throw obj2;
        obj1;
_L7:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        ((FileInputStream) (obj)).close();
        throw obj1;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L4:
        int i;
        i = (int)l;
        obj = obj1;
        byte abyte0[] = new byte[i];
        obj = obj1;
        obj1 = new FileInputStream(file);
        ((FileInputStream) (obj1)).read(abyte0);
        mBytesUsed = mBytesUsed - file.length();
        file.delete();
        mNumEntries = mNumEntries - 1L;
        obj = abyte0;
        if (obj1 == null) goto _L2; else goto _L5
_L5:
        ((FileInputStream) (obj1)).close();
        obj = abyte0;
_L2:
        this;
        JVM INSTR monitorexit ;
        return ((byte []) (obj));
        abyte0;
        obj = obj1;
        obj1 = abyte0;
        if (true) goto _L7; else goto _L6
_L6:
        abyte0;
        if (true) goto _L9; else goto _L8
_L8:
    }


}
