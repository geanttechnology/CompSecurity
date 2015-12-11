// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import org.apache.log4j.spi.ErrorHandler;

// Referenced classes of package org.apache.log4j.helpers:
//            QuietWriter

public class CountingQuietWriter extends QuietWriter
{

    protected long count;

    public CountingQuietWriter(Writer writer, ErrorHandler errorhandler)
    {
        super(writer, errorhandler);
    }

    public long getCount()
    {
        return count;
    }

    public void setCount(long l)
    {
        count = l;
    }

    public void write(String s)
    {
        try
        {
            super.out.write(s);
            count = count + (long)s.length();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            super.errorHandler.error("Write failure.", s, 1);
        }
    }
}
