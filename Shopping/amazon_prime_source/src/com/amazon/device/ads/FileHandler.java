// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLoggerFactory, MobileAdsLogger

abstract class FileHandler
    implements Closeable
{

    private static final String LOGTAG = com/amazon/device/ads/FileHandler.getSimpleName();
    File file;
    private final MobileAdsLogger logger;

    FileHandler()
    {
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);
    }

    private void closeStream()
    {
        Closeable closeable;
        closeable = getCloseableStream();
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        closeable.close();
        return;
        IOException ioexception;
        ioexception;
        logger.e("Could not close the stream. %s", new Object[] {
            ioexception.getMessage()
        });
        return;
    }

    public abstract void close();

    protected void closeCloseables()
    {
        Closeable closeable = getCloseableReaderWriter();
        if (closeable != null)
        {
            try
            {
                closeable.close();
                return;
            }
            catch (IOException ioexception)
            {
                logger.e("Could not close the %s. %s", new Object[] {
                    closeable.getClass().getSimpleName(), ioexception.getMessage()
                });
            }
            closeStream();
            return;
        } else
        {
            closeStream();
            return;
        }
    }

    public boolean doesFileExist()
    {
        if (!isFileSet())
        {
            throw new IllegalStateException("A file has not been set, yet.");
        } else
        {
            return file.exists();
        }
    }

    protected abstract Closeable getCloseableReaderWriter();

    protected abstract Closeable getCloseableStream();

    public long getFileLength()
    {
        if (!isFileSet())
        {
            throw new IllegalStateException("A file has not been set, yet.");
        } else
        {
            return file.length();
        }
    }

    public boolean isFileSet()
    {
        return file != null;
    }

    public abstract boolean isOpen();

    public boolean setFile(File file1)
    {
        if (isFileSet())
        {
            if (file1.getAbsolutePath().equals(file.getAbsolutePath()))
            {
                return true;
            } else
            {
                logger.e("Another file is already set in this FileOutputHandler. Close the other file before opening a new one.");
                return false;
            }
        } else
        {
            file = file1;
            return true;
        }
    }

    public boolean setFile(File file1, String s)
    {
        return setFile(new File(file1, s));
    }

    public boolean setFile(String s)
    {
        return setFile(new File(s));
    }

}
