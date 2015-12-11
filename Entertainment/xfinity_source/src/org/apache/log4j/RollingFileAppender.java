// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.Writer;
import org.apache.log4j.helpers.CountingQuietWriter;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

// Referenced classes of package org.apache.log4j:
//            FileAppender, WriterAppender, AppenderSkeleton, Layout

public class RollingFileAppender extends FileAppender
{

    protected int maxBackupIndex;
    protected long maxFileSize;
    private long nextRollover;

    public RollingFileAppender()
    {
        maxFileSize = 0xa00000L;
        maxBackupIndex = 1;
        nextRollover = 0L;
    }

    public RollingFileAppender(Layout layout, String s)
        throws IOException
    {
        super(layout, s);
        maxFileSize = 0xa00000L;
        maxBackupIndex = 1;
        nextRollover = 0L;
    }

    public void rollOver()
    {
        boolean flag;
        boolean flag1;
        if (super.qw != null)
        {
            long l = ((CountingQuietWriter)super.qw).getCount();
            LogLog.debug("rolling over count=" + l);
            nextRollover = maxFileSize + l;
        }
        LogLog.debug("maxBackupIndex=" + maxBackupIndex);
        flag = true;
        flag1 = true;
        if (maxBackupIndex <= 0)
        {
            break MISSING_BLOCK_LABEL_407;
        }
        File file = new File(super.fileName + '.' + maxBackupIndex);
        if (file.exists())
        {
            flag1 = file.delete();
        }
        for (int i = maxBackupIndex - 1; i >= 1 && flag1; i--)
        {
            file = new File(super.fileName + "." + i);
            if (file.exists())
            {
                File file1 = new File(super.fileName + '.' + (i + 1));
                LogLog.debug("Renaming file " + file + " to " + file1);
                flag1 = file.renameTo(file1);
            }
        }

        flag = flag1;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_407;
        }
        file = new File(super.fileName + "." + 1);
        closeFile();
        File file2 = new File(super.fileName);
        LogLog.debug("Renaming file " + file2 + " to " + file);
        flag1 = file2.renameTo(file);
        flag = flag1;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_407;
        }
        setFile(super.fileName, true, super.bufferedIO, super.bufferSize);
        flag = flag1;
_L2:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_434;
        }
        setFile(super.fileName, false, super.bufferedIO, super.bufferSize);
        nextRollover = 0L;
        return;
        IOException ioexception;
        ioexception;
        if (ioexception instanceof InterruptedIOException)
        {
            Thread.currentThread().interrupt();
        }
        LogLog.error("setFile(" + super.fileName + ", true) call failed.", ioexception);
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
        ioexception;
        if (ioexception instanceof InterruptedIOException)
        {
            Thread.currentThread().interrupt();
        }
        LogLog.error("setFile(" + super.fileName + ", false) call failed.", ioexception);
        return;
    }

    public void setFile(String s, boolean flag, boolean flag1, int i)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        super.setFile(s, flag, super.bufferedIO, super.bufferSize);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        s = new File(s);
        ((CountingQuietWriter)super.qw).setCount(s.length());
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setMaxBackupIndex(int i)
    {
        maxBackupIndex = i;
    }

    public void setMaximumFileSize(long l)
    {
        maxFileSize = l;
    }

    protected void setQWForFiles(Writer writer)
    {
        super.qw = new CountingQuietWriter(writer, super.errorHandler);
    }

    protected void subAppend(LoggingEvent loggingevent)
    {
        super.subAppend(loggingevent);
        if (super.fileName != null && super.qw != null)
        {
            long l = ((CountingQuietWriter)super.qw).getCount();
            if (l >= maxFileSize && l >= nextRollover)
            {
                rollOver();
            }
        }
    }
}
