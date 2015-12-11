// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

// Referenced classes of package com.amazon.device.ads:
//            FileHandler, MobileAdsLoggerFactory, MobileAdsLogger

class FileOutputHandler extends FileHandler
{
    public static final class WriteMethod extends Enum
    {

        private static final WriteMethod $VALUES[];
        public static final WriteMethod APPEND;
        public static final WriteMethod OVERWRITE;

        public static WriteMethod valueOf(String s)
        {
            return (WriteMethod)Enum.valueOf(com/amazon/device/ads/FileOutputHandler$WriteMethod, s);
        }

        public static WriteMethod[] values()
        {
            return (WriteMethod[])$VALUES.clone();
        }

        static 
        {
            APPEND = new WriteMethod("APPEND", 0);
            OVERWRITE = new WriteMethod("OVERWRITE", 1);
            $VALUES = (new WriteMethod[] {
                APPEND, OVERWRITE
            });
        }

        private WriteMethod(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String LOGTAG = com/amazon/device/ads/FileOutputHandler.getSimpleName();
    private BufferedWriter bufferedWriter;
    private final MobileAdsLogger logger;
    private OutputStream outputStream;
    private WriteMethod writeMethod;

    FileOutputHandler()
    {
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);
    }

    private void checkWritable()
    {
        if (bufferedWriter == null)
        {
            throw new IllegalStateException("Could not write to the file because no file has been opened yet. Please set the file, then call open() before attempting to write.");
        } else
        {
            return;
        }
    }

    private boolean writeToFile(String s, WriteMethod writemethod)
    {
        if (isOpen())
        {
            if (!writemethod.equals(writeMethod))
            {
                close();
                if (!open(writemethod))
                {
                    logger.e("Could not reopen the file for %s.", new Object[] {
                        writemethod.toString()
                    });
                    return false;
                }
            }
        } else
        if (!open(writemethod))
        {
            logger.e("Could not open the file for writing.");
            return false;
        }
        try
        {
            write(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logger.e("Failed to write data to the file.");
            return false;
        }
        close();
        return true;
    }

    public boolean appendToFile(String s)
    {
        return writeToFile(s, WriteMethod.APPEND);
    }

    public void close()
    {
        flush();
        closeCloseables();
        bufferedWriter = null;
        outputStream = null;
    }

    public void flush()
    {
        if (outputStream != null)
        {
            try
            {
                outputStream.flush();
            }
            catch (IOException ioexception)
            {
                logger.e("Could not flush the OutputStream. %s", new Object[] {
                    ioexception.getMessage()
                });
            }
        }
        if (bufferedWriter == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        bufferedWriter.flush();
        return;
        IOException ioexception1;
        ioexception1;
        logger.e("Could not flush the BufferedWriter. %s", new Object[] {
            ioexception1.getMessage()
        });
        return;
    }

    protected Closeable getCloseableReaderWriter()
    {
        return bufferedWriter;
    }

    protected Closeable getCloseableStream()
    {
        return outputStream;
    }

    public boolean isOpen()
    {
        return outputStream != null;
    }

    public boolean open(WriteMethod writemethod)
    {
        if (file == null)
        {
            logger.e("A file must be set before it can be opened.");
            return false;
        }
        if (outputStream != null)
        {
            logger.e("The file is already open.");
            return false;
        }
        FileOutputStream fileoutputstream;
        try
        {
            fileoutputstream = new FileOutputStream(file, WriteMethod.APPEND.equals(writemethod));
        }
        // Misplaced declaration of an exception variable
        catch (WriteMethod writemethod)
        {
            return false;
        }
        writeMethod = writemethod;
        outputStream = new BufferedOutputStream(fileoutputstream);
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        return true;
    }

    public boolean overwriteFile(String s)
    {
        return writeToFile(s, WriteMethod.OVERWRITE);
    }

    public void write(String s)
        throws IOException
    {
        checkWritable();
        bufferedWriter.write(s);
    }

    public void write(byte abyte0[])
        throws IOException
    {
        checkWritable();
        outputStream.write(abyte0);
    }

}
