// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.amazon.device.ads.identity:
//            Log

abstract class FileHandler
    implements Closeable
{

    private static final String LOGTAG = com/amazon/device/ads/identity/FileHandler.getSimpleName();
    File file;

    FileHandler()
    {
    }

    protected void closeCloseables()
    {
        Closeable closeable;
        closeable = getCloseableReaderWriter();
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        closeable.close();
_L1:
        return;
        IOException ioexception1;
        ioexception1;
        Log.e(LOGTAG, "Could not close the %s. %s", new Object[] {
            closeable.getClass().getSimpleName(), ioexception1.getMessage()
        });
        Closeable closeable1 = getCloseableStream();
        if (closeable1 != null)
        {
            try
            {
                closeable1.close();
                return;
            }
            catch (IOException ioexception)
            {
                Log.e(LOGTAG, "Could not close the stream. %s", new Object[] {
                    ioexception.getMessage()
                });
            }
            return;
        }
          goto _L1
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

    public boolean setFile(File file1)
    {
        if (isFileSet())
        {
            if (file1.getAbsolutePath().equals(file.getAbsolutePath()))
            {
                return true;
            } else
            {
                Log.e(LOGTAG, "Another file is already set in this FileOutputHandler. Close the other file before opening a new one.", new Object[0]);
                return false;
            }
        } else
        {
            file = file1;
            return true;
        }
    }

    public boolean setFile(String s)
    {
        return setFile(new File(s));
    }

}
