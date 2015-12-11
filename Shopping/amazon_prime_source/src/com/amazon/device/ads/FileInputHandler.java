// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// Referenced classes of package com.amazon.device.ads:
//            FileHandler, MobileAdsLoggerFactory, MobileAdsLogger

class FileInputHandler extends FileHandler
{

    private static final String LOGTAG = com/amazon/device/ads/FileInputHandler.getSimpleName();
    private BufferedReader bufferedReader;
    private InputStream inputStream;
    private final MobileAdsLogger logger;

    FileInputHandler()
    {
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);
    }

    private void checkReadable()
    {
        if (bufferedReader == null)
        {
            throw new IllegalStateException("Could not read from the file because no file has been opened yet. Please set the file, then call open() before attempting to read.");
        } else
        {
            return;
        }
    }

    public void close()
    {
        closeCloseables();
        bufferedReader = null;
        inputStream = null;
    }

    protected Closeable getCloseableReaderWriter()
    {
        return bufferedReader;
    }

    protected Closeable getCloseableStream()
    {
        return inputStream;
    }

    public boolean isOpen()
    {
        return inputStream != null;
    }

    public boolean open()
    {
        if (file == null)
        {
            logger.e("A file must be set before it can be opened.");
            return false;
        }
        if (inputStream != null)
        {
            logger.e("The file is already open.");
            return false;
        }
        FileInputStream fileinputstream;
        try
        {
            fileinputstream = new FileInputStream(file);
        }
        catch (Exception exception)
        {
            return false;
        }
        inputStream = new BufferedInputStream(fileinputstream);
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return true;
    }

    public byte[] readAllBytesFromFileAndClose()
    {
        if (!isOpen() && !open())
        {
            logger.e("Could not open the file for reading");
            return null;
        } else
        {
            byte abyte0[] = readBytes();
            close();
            return abyte0;
        }
    }

    public byte[] readBytes()
    {
        int i;
        checkReadable();
        i = 0;
        byte abyte0[] = new byte[(int)file.length()];
_L2:
        Object obj = abyte0;
        int j;
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        j = abyte0.length;
        j = inputStream.read(abyte0, i, j - i);
        if (j > 0)
        {
            i += j;
        }
        if (true) goto _L2; else goto _L1
        obj;
        logger.e("Error reading bytes from input file: %s", new Object[] {
            ((IOException) (obj)).getMessage()
        });
        obj = null;
_L1:
        return ((byte []) (obj));
    }

    public String readLine()
    {
        checkReadable();
        String s;
        try
        {
            s = bufferedReader.readLine();
        }
        catch (IOException ioexception)
        {
            logger.e("Error reading line from file.");
            return null;
        }
        return s;
    }

}
