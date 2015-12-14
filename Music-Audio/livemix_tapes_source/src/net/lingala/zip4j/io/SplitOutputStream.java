// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;

public class SplitOutputStream extends OutputStream
{

    private long bytesWrittenForThisPart;
    private int currSplitFileCounter;
    private File outFile;
    private RandomAccessFile raf;
    private long splitLength;
    private File zipFile;

    public SplitOutputStream(File file)
        throws FileNotFoundException, ZipException
    {
        this(file, -1L);
    }

    public SplitOutputStream(File file, long l)
        throws FileNotFoundException, ZipException
    {
        if (l >= 0L && l < 0x10000L)
        {
            throw new ZipException("split length less than minimum allowed split length of 65536 Bytes");
        } else
        {
            raf = new RandomAccessFile(file, "rw");
            splitLength = l;
            outFile = file;
            zipFile = file;
            currSplitFileCounter = 0;
            bytesWrittenForThisPart = 0L;
            return;
        }
    }

    public SplitOutputStream(String s)
        throws FileNotFoundException, ZipException
    {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            s = new File(s);
        } else
        {
            s = null;
        }
        this(((File) (s)));
    }

    public SplitOutputStream(String s, long l)
        throws FileNotFoundException, ZipException
    {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            s = new File(s);
        } else
        {
            s = null;
        }
        this(((File) (s)), l);
    }

    private boolean isHeaderData(byte abyte0[])
    {
        if (abyte0 != null && abyte0.length >= 4) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = Raw.readIntLittleEndian(abyte0, 0);
        abyte0 = Zip4jUtil.getAllHeaderSignatures();
        if (abyte0 != null && abyte0.length > 0)
        {
            int i = 0;
            while (i < abyte0.length) 
            {
                if (abyte0[i] != 0x8074b50L && abyte0[i] == (long)j)
                {
                    return true;
                }
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void startNextSplitFile()
        throws IOException
    {
        String s;
        String s1;
        s1 = Zip4jUtil.getZipFileNameWithoutExt(outFile.getName());
        s = zipFile.getAbsolutePath();
        Object obj;
        if (outFile.getParent() == null)
        {
            obj = "";
        } else
        {
            try
            {
                obj = outFile.getParent() + System.getProperty("file.separator");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IOException(((ZipException) (obj)).getMessage());
            }
        }
        if (currSplitFileCounter >= 9)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        obj = new File(obj + s1 + ".z0" + (currSplitFileCounter + 1));
_L1:
        raf.close();
        if (((File) (obj)).exists())
        {
            throw new IOException("split file: " + ((File) (obj)).getName() + " already exists in the current directory, cannot rename this file");
        }
        break MISSING_BLOCK_LABEL_215;
        obj = new File(obj + s1 + ".z" + (currSplitFileCounter + 1));
          goto _L1
        if (!zipFile.renameTo(((File) (obj))))
        {
            throw new IOException("cannot rename newly created split file");
        } else
        {
            zipFile = new File(s);
            raf = new RandomAccessFile(zipFile, "rw");
            currSplitFileCounter = currSplitFileCounter + 1;
            return;
        }
    }

    public boolean checkBuffSizeAndStartNextSplitFile(int i)
        throws ZipException
    {
        if (i < 0)
        {
            throw new ZipException("negative buffersize for checkBuffSizeAndStartNextSplitFile");
        }
        if (!isBuffSizeFitForCurrSplitFile(i))
        {
            try
            {
                startNextSplitFile();
                bytesWrittenForThisPart = 0L;
            }
            catch (IOException ioexception)
            {
                throw new ZipException(ioexception);
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void close()
        throws IOException
    {
        if (raf != null)
        {
            raf.close();
        }
    }

    public void flush()
        throws IOException
    {
    }

    public int getCurrSplitFileCounter()
    {
        return currSplitFileCounter;
    }

    public long getFilePointer()
        throws IOException
    {
        return raf.getFilePointer();
    }

    public long getSplitLength()
    {
        return splitLength;
    }

    public boolean isBuffSizeFitForCurrSplitFile(int i)
        throws ZipException
    {
        if (i < 0)
        {
            throw new ZipException("negative buffersize for isBuffSizeFitForCurrSplitFile");
        }
        return splitLength < 0x10000L || bytesWrittenForThisPart + (long)i <= splitLength;
    }

    public boolean isSplitZipFile()
    {
        return splitLength != -1L;
    }

    public void seek(long l)
        throws IOException
    {
        raf.seek(l);
    }

    public void write(int i)
        throws IOException
    {
        write(new byte[] {
            (byte)i
        }, 0, 1);
    }

    public void write(byte abyte0[])
        throws IOException
    {
        write(abyte0, 0, abyte0.length);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if (j <= 0)
        {
            return;
        }
        if (splitLength != -1L)
        {
            if (splitLength < 0x10000L)
            {
                throw new IOException("split length less than minimum allowed split length of 65536 Bytes");
            }
            if (bytesWrittenForThisPart >= splitLength)
            {
                startNextSplitFile();
                raf.write(abyte0, i, j);
                bytesWrittenForThisPart = j;
                return;
            }
            if (bytesWrittenForThisPart + (long)j > splitLength)
            {
                if (isHeaderData(abyte0))
                {
                    startNextSplitFile();
                    raf.write(abyte0, i, j);
                    bytesWrittenForThisPart = j;
                    return;
                } else
                {
                    raf.write(abyte0, i, (int)(splitLength - bytesWrittenForThisPart));
                    startNextSplitFile();
                    raf.write(abyte0, (int)(splitLength - bytesWrittenForThisPart) + i, (int)((long)j - (splitLength - bytesWrittenForThisPart)));
                    bytesWrittenForThisPart = (long)j - (splitLength - bytesWrittenForThisPart);
                    return;
                }
            } else
            {
                raf.write(abyte0, i, j);
                bytesWrittenForThisPart = bytesWrittenForThisPart + (long)j;
                return;
            }
        } else
        {
            raf.write(abyte0, i, j);
            bytesWrittenForThisPart = bytesWrittenForThisPart + (long)j;
            return;
        }
    }
}
