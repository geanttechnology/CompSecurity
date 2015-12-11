// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import java.io.FilterWriter;
import java.io.Writer;
import org.apache.log4j.spi.ErrorHandler;

public class QuietWriter extends FilterWriter
{

    protected ErrorHandler errorHandler;

    public QuietWriter(Writer writer, ErrorHandler errorhandler)
    {
        super(writer);
        setErrorHandler(errorhandler);
    }

    public void flush()
    {
        try
        {
            super.out.flush();
            return;
        }
        catch (Exception exception)
        {
            errorHandler.error("Failed to flush writer,", exception, 2);
        }
    }

    public void setErrorHandler(ErrorHandler errorhandler)
    {
        if (errorhandler == null)
        {
            throw new IllegalArgumentException("Attempted to set null ErrorHandler.");
        } else
        {
            errorHandler = errorhandler;
            return;
        }
    }

    public void write(String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        super.out.write(s);
        return;
        Exception exception;
        exception;
        errorHandler.error("Failed to write [" + s + "].", exception, 1);
        return;
    }
}
