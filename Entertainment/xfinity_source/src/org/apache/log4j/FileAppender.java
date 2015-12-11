// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.Writer;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.QuietWriter;
import org.apache.log4j.spi.ErrorHandler;

// Referenced classes of package org.apache.log4j:
//            WriterAppender, AppenderSkeleton, Layout

public class FileAppender extends WriterAppender
{

    protected int bufferSize;
    protected boolean bufferedIO;
    protected boolean fileAppend;
    protected String fileName;

    public FileAppender()
    {
        fileAppend = true;
        fileName = null;
        bufferedIO = false;
        bufferSize = 8192;
    }

    public FileAppender(Layout layout, String s)
        throws IOException
    {
        this(layout, s, true);
    }

    public FileAppender(Layout layout, String s, boolean flag)
        throws IOException
    {
        fileAppend = true;
        fileName = null;
        bufferedIO = false;
        bufferSize = 8192;
        super.layout = layout;
        setFile(s, flag, false, bufferSize);
    }

    public void activateOptions()
    {
        if (fileName != null)
        {
            try
            {
                setFile(fileName, fileAppend, bufferedIO, bufferSize);
                return;
            }
            catch (IOException ioexception)
            {
                super.errorHandler.error("setFile(" + fileName + "," + fileAppend + ") call failed.", ioexception, 4);
            }
            return;
        } else
        {
            LogLog.warn("File option not set for appender [" + super.name + "].");
            LogLog.warn("Are you using FileAppender instead of ConsoleAppender?");
            return;
        }
    }

    protected void closeFile()
    {
        if (super.qw == null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        super.qw.close();
        return;
        IOException ioexception;
        ioexception;
        if (ioexception instanceof InterruptedIOException)
        {
            Thread.currentThread().interrupt();
        }
        LogLog.error("Could not close " + super.qw, ioexception);
        return;
    }

    protected void reset()
    {
        closeFile();
        fileName = null;
        super.reset();
    }

    public void setFile(String s, boolean flag, boolean flag1, int i)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        LogLog.debug("setFile called: " + s + ", " + flag);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        setImmediateFlush(false);
        reset();
        Object obj = new FileOutputStream(s, flag);
_L1:
        Object obj1 = createWriter(((java.io.OutputStream) (obj)));
        obj = obj1;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        obj = new BufferedWriter(((Writer) (obj1)), i);
        setQWForFiles(((Writer) (obj)));
        fileName = s;
        fileAppend = flag;
        bufferedIO = flag1;
        bufferSize = i;
        writeHeader();
        LogLog.debug("setFile ended");
        this;
        JVM INSTR monitorexit ;
        return;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        obj1 = (new File(s)).getParent();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_194;
        }
label0:
        {
            obj1 = new File(((String) (obj1)));
            if (((File) (obj1)).exists() || !((File) (obj1)).mkdirs())
            {
                break label0;
            }
            filenotfoundexception = new FileOutputStream(s, flag);
        }
          goto _L1
        throw filenotfoundexception;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        throw filenotfoundexception;
    }

    protected void setQWForFiles(Writer writer)
    {
        super.qw = new QuietWriter(writer, super.errorHandler);
    }
}
