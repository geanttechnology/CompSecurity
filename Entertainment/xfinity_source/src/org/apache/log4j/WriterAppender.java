// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.QuietWriter;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.LoggingEvent;

// Referenced classes of package org.apache.log4j:
//            AppenderSkeleton, Layout

public class WriterAppender extends AppenderSkeleton
{

    protected String encoding;
    protected boolean immediateFlush;
    protected QuietWriter qw;

    public WriterAppender()
    {
        immediateFlush = true;
    }

    public void activateOptions()
    {
    }

    public void append(LoggingEvent loggingevent)
    {
        if (!checkEntryConditions())
        {
            return;
        } else
        {
            subAppend(loggingevent);
            return;
        }
    }

    protected boolean checkEntryConditions()
    {
        if (super.closed)
        {
            LogLog.warn("Not allowed to write to a closed appender.");
            return false;
        }
        if (qw == null)
        {
            super.errorHandler.error("No output stream or file set for the appender named [" + super.name + "].");
            return false;
        }
        if (super.layout == null)
        {
            super.errorHandler.error("No layout set for the appender named [" + super.name + "].");
            return false;
        } else
        {
            return true;
        }
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = super.closed;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        super.closed = true;
        writeFooter();
        reset();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected void closeWriter()
    {
        if (qw == null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        qw.close();
        return;
        IOException ioexception;
        ioexception;
        if (ioexception instanceof InterruptedIOException)
        {
            Thread.currentThread().interrupt();
        }
        LogLog.error("Could not close " + qw, ioexception);
        return;
    }

    protected OutputStreamWriter createWriter(OutputStream outputstream)
    {
        OutputStreamWriter outputstreamwriter1 = null;
        String s = getEncoding();
        OutputStreamWriter outputstreamwriter = outputstreamwriter1;
        if (s != null)
        {
            try
            {
                outputstreamwriter = new OutputStreamWriter(outputstream, s);
            }
            catch (IOException ioexception)
            {
                if (ioexception instanceof InterruptedIOException)
                {
                    Thread.currentThread().interrupt();
                }
                LogLog.warn("Error initializing output writer.");
                LogLog.warn("Unsupported encoding?");
                ioexception = outputstreamwriter1;
            }
        }
        outputstreamwriter1 = outputstreamwriter;
        if (outputstreamwriter == null)
        {
            outputstreamwriter1 = new OutputStreamWriter(outputstream);
        }
        return outputstreamwriter1;
    }

    public String getEncoding()
    {
        return encoding;
    }

    public boolean requiresLayout()
    {
        return true;
    }

    protected void reset()
    {
        closeWriter();
        qw = null;
    }

    public void setErrorHandler(ErrorHandler errorhandler)
    {
        this;
        JVM INSTR monitorenter ;
        if (errorhandler != null) goto _L2; else goto _L1
_L1:
        LogLog.warn("You have tried to set a null error-handler.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        super.errorHandler = errorhandler;
        if (qw != null)
        {
            qw.setErrorHandler(errorhandler);
        }
        if (true) goto _L4; else goto _L3
_L3:
        errorhandler;
        throw errorhandler;
    }

    public void setImmediateFlush(boolean flag)
    {
        immediateFlush = flag;
    }

    public void setWriter(Writer writer)
    {
        this;
        JVM INSTR monitorenter ;
        reset();
        qw = new QuietWriter(writer, super.errorHandler);
        writeHeader();
        this;
        JVM INSTR monitorexit ;
        return;
        writer;
        throw writer;
    }

    protected boolean shouldFlush(LoggingEvent loggingevent)
    {
        return immediateFlush;
    }

    protected void subAppend(LoggingEvent loggingevent)
    {
        qw.write(super.layout.format(loggingevent));
        if (super.layout.ignoresThrowable())
        {
            String as[] = loggingevent.getThrowableStrRep();
            if (as != null)
            {
                int j = as.length;
                for (int i = 0; i < j; i++)
                {
                    qw.write(as[i]);
                    qw.write(Layout.LINE_SEP);
                }

            }
        }
        if (shouldFlush(loggingevent))
        {
            qw.flush();
        }
    }

    protected void writeFooter()
    {
        if (super.layout != null)
        {
            String s = super.layout.getFooter();
            if (s != null && qw != null)
            {
                qw.write(s);
                qw.flush();
            }
        }
    }

    protected void writeHeader()
    {
        if (super.layout != null)
        {
            String s = super.layout.getHeader();
            if (s != null && qw != null)
            {
                qw.write(s);
            }
        }
    }
}
