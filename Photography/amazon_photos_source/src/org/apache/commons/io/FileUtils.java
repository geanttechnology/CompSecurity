// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

// Referenced classes of package org.apache.commons.io:
//            FilenameUtils, IOUtils

public class FileUtils
{

    public static final File EMPTY_FILE_ARRAY[] = new File[0];
    public static final BigInteger ONE_EB_BI;
    public static final BigInteger ONE_GB_BI;
    public static final BigInteger ONE_KB_BI;
    public static final BigInteger ONE_MB_BI;
    public static final BigInteger ONE_PB_BI;
    public static final BigInteger ONE_TB_BI;
    public static final BigInteger ONE_YB;
    public static final BigInteger ONE_ZB;
    private static final Charset UTF8 = Charset.forName("UTF-8");

    public static String byteCountToDisplaySize(long l)
    {
        return byteCountToDisplaySize(BigInteger.valueOf(l));
    }

    public static String byteCountToDisplaySize(BigInteger biginteger)
    {
        if (biginteger.divide(ONE_EB_BI).compareTo(BigInteger.ZERO) > 0)
        {
            return (new StringBuilder()).append(String.valueOf(biginteger.divide(ONE_EB_BI))).append(" EB").toString();
        }
        if (biginteger.divide(ONE_PB_BI).compareTo(BigInteger.ZERO) > 0)
        {
            return (new StringBuilder()).append(String.valueOf(biginteger.divide(ONE_PB_BI))).append(" PB").toString();
        }
        if (biginteger.divide(ONE_TB_BI).compareTo(BigInteger.ZERO) > 0)
        {
            return (new StringBuilder()).append(String.valueOf(biginteger.divide(ONE_TB_BI))).append(" TB").toString();
        }
        if (biginteger.divide(ONE_GB_BI).compareTo(BigInteger.ZERO) > 0)
        {
            return (new StringBuilder()).append(String.valueOf(biginteger.divide(ONE_GB_BI))).append(" GB").toString();
        }
        if (biginteger.divide(ONE_MB_BI).compareTo(BigInteger.ZERO) > 0)
        {
            return (new StringBuilder()).append(String.valueOf(biginteger.divide(ONE_MB_BI))).append(" MB").toString();
        }
        if (biginteger.divide(ONE_KB_BI).compareTo(BigInteger.ZERO) > 0)
        {
            return (new StringBuilder()).append(String.valueOf(biginteger.divide(ONE_KB_BI))).append(" KB").toString();
        } else
        {
            return (new StringBuilder()).append(String.valueOf(biginteger)).append(" bytes").toString();
        }
    }

    private static void checkDirectory(File file)
    {
        if (!file.exists())
        {
            throw new IllegalArgumentException((new StringBuilder()).append(file).append(" does not exist").toString());
        }
        if (!file.isDirectory())
        {
            throw new IllegalArgumentException((new StringBuilder()).append(file).append(" is not a directory").toString());
        } else
        {
            return;
        }
    }

    public static void cleanDirectory(File file)
        throws IOException
    {
        if (!file.exists())
        {
            throw new IllegalArgumentException((new StringBuilder()).append(file).append(" does not exist").toString());
        }
        if (!file.isDirectory())
        {
            throw new IllegalArgumentException((new StringBuilder()).append(file).append(" is not a directory").toString());
        }
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IOException((new StringBuilder()).append("Failed to list contents of ").append(file).toString());
        }
        file = null;
        int j = afile.length;
        int i = 0;
        while (i < j) 
        {
            File file1 = afile[i];
            try
            {
                forceDelete(file1);
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
            i++;
        }
        if (file != null)
        {
            throw file;
        } else
        {
            return;
        }
    }

    public static void copyFile(File file, File file1)
        throws IOException
    {
        copyFile(file, file1, true);
    }

    public static void copyFile(File file, File file1, boolean flag)
        throws IOException
    {
        if (file == null)
        {
            throw new NullPointerException("Source must not be null");
        }
        if (file1 == null)
        {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists())
        {
            throw new FileNotFoundException((new StringBuilder()).append("Source '").append(file).append("' does not exist").toString());
        }
        if (file.isDirectory())
        {
            throw new IOException((new StringBuilder()).append("Source '").append(file).append("' exists but is a directory").toString());
        }
        if (file.getCanonicalPath().equals(file1.getCanonicalPath()))
        {
            throw new IOException((new StringBuilder()).append("Source '").append(file).append("' and destination '").append(file1).append("' are the same").toString());
        }
        File file2 = file1.getParentFile();
        if (file2 != null && !file2.mkdirs() && !file2.isDirectory())
        {
            throw new IOException((new StringBuilder()).append("Destination '").append(file2).append("' directory cannot be created").toString());
        }
        if (file1.exists() && !file1.canWrite())
        {
            throw new IOException((new StringBuilder()).append("Destination '").append(file1).append("' exists but is read-only").toString());
        } else
        {
            doCopyFile(file, file1, flag);
            return;
        }
    }

    public static void deleteDirectory(File file)
        throws IOException
    {
        if (file.exists())
        {
            if (!isSymlink(file))
            {
                cleanDirectory(file);
            }
            if (!file.delete())
            {
                throw new IOException((new StringBuilder()).append("Unable to delete directory ").append(file).append(".").toString());
            }
        }
    }

    public static boolean directoryContains(File file, File file1)
        throws IOException
    {
        if (file == null)
        {
            throw new IllegalArgumentException("Directory must not be null");
        }
        if (!file.isDirectory())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Not a directory: ").append(file).toString());
        }
        while (file1 == null || !file.exists() || !file1.exists()) 
        {
            return false;
        }
        return FilenameUtils.directoryContains(file.getCanonicalPath(), file1.getCanonicalPath());
    }

    private static void doCopyFile(File file, File file1, boolean flag)
        throws IOException
    {
        FileChannel filechannel;
        FileChannel filechannel1;
        FileChannel filechannel2;
        FileOutputStream fileoutputstream;
        FileChannel filechannel3;
        Object obj1;
        if (file1.exists() && file1.isDirectory())
        {
            throw new IOException((new StringBuilder()).append("Destination '").append(file1).append("' exists but is a directory").toString());
        }
        fileoutputstream = null;
        filechannel2 = null;
        obj1 = null;
        filechannel1 = null;
        filechannel3 = null;
        filechannel = null;
        Object obj = new FileInputStream(file);
        fileoutputstream = new FileOutputStream(file1);
        filechannel = filechannel3;
        filechannel1 = obj1;
        filechannel2 = ((FileInputStream) (obj)).getChannel();
        filechannel = filechannel3;
        filechannel1 = filechannel2;
        filechannel3 = fileoutputstream.getChannel();
        filechannel = filechannel3;
        filechannel1 = filechannel2;
        long l2 = filechannel2.size();
        long l = 0L;
          goto _L1
_L8:
        filechannel = filechannel3;
        filechannel1 = filechannel2;
        long l1;
        l1 = filechannel3.transferFrom(filechannel2, l, l1);
        l += l1;
          goto _L1
_L6:
        l1 = l2 - l;
        continue; /* Loop/switch isn't completed */
        file1;
        obj = filechannel2;
        file = fileoutputstream;
_L2:
        IOUtils.closeQuietly(filechannel);
        IOUtils.closeQuietly(((java.io.OutputStream) (obj)));
        IOUtils.closeQuietly(filechannel1);
        IOUtils.closeQuietly(file);
        throw file1;
_L4:
        IOUtils.closeQuietly(filechannel3);
        IOUtils.closeQuietly(fileoutputstream);
        IOUtils.closeQuietly(filechannel2);
        IOUtils.closeQuietly(((java.io.InputStream) (obj)));
        if (file.length() != file1.length())
        {
            throw new IOException((new StringBuilder()).append("Failed to copy full contents from '").append(file).append("' to '").append(file1).append("'").toString());
        }
        if (flag)
        {
            file1.setLastModified(file.lastModified());
        }
        return;
        file1;
        file = ((File) (obj));
        obj = filechannel2;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        file1 = fileoutputstream;
        file = ((File) (obj));
        obj = file1;
        file1 = exception;
        if (true) goto _L2; else goto _L1
_L1:
        if (l >= l2) goto _L4; else goto _L3
_L3:
        if (l2 - l <= 0x1e00000L) goto _L6; else goto _L5
_L5:
        l1 = 0x1e00000L;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static void forceDelete(File file)
        throws IOException
    {
        if (file.isDirectory())
        {
            deleteDirectory(file);
        } else
        {
            boolean flag = file.exists();
            if (!file.delete())
            {
                if (!flag)
                {
                    throw new FileNotFoundException((new StringBuilder()).append("File does not exist: ").append(file).toString());
                } else
                {
                    throw new IOException((new StringBuilder()).append("Unable to delete file: ").append(file).toString());
                }
            }
        }
    }

    public static boolean isSymlink(File file)
        throws IOException
    {
        if (file == null)
        {
            throw new NullPointerException("File must not be null");
        }
        if (!FilenameUtils.isSystemWindows())
        {
            if (file.getParent() != null)
            {
                file = new File(file.getParentFile().getCanonicalFile(), file.getName());
            }
            if (!file.getCanonicalFile().equals(file.getAbsoluteFile()))
            {
                return true;
            }
        }
        return false;
    }

    public static long sizeOf(File file)
    {
        if (!file.exists())
        {
            throw new IllegalArgumentException((new StringBuilder()).append(file).append(" does not exist").toString());
        }
        if (file.isDirectory())
        {
            return sizeOfDirectory(file);
        } else
        {
            return file.length();
        }
    }

    public static BigInteger sizeOfAsBigInteger(File file)
    {
        if (!file.exists())
        {
            throw new IllegalArgumentException((new StringBuilder()).append(file).append(" does not exist").toString());
        }
        if (file.isDirectory())
        {
            return sizeOfDirectoryAsBigInteger(file);
        } else
        {
            return BigInteger.valueOf(file.length());
        }
    }

    public static long sizeOfDirectory(File file)
    {
        checkDirectory(file);
        file = file.listFiles();
        if (file != null) goto _L2; else goto _L1
_L1:
        long l1 = 0L;
_L4:
        return l1;
_L2:
        int i;
        int j;
        long l;
        l = 0L;
        j = file.length;
        i = 0;
_L6:
        l1 = l;
        if (i >= j) goto _L4; else goto _L3
_L3:
        File file1;
        file1 = file[i];
        l1 = l;
        if (isSymlink(file1))
        {
            break MISSING_BLOCK_LABEL_79;
        }
        l1 = sizeOf(file1);
        l += l1;
        l1 = l;
        if (l < 0L) goto _L4; else goto _L5
_L5:
        l1 = l;
_L7:
        i++;
        l = l1;
          goto _L6
        IOException ioexception;
        ioexception;
        l1 = l;
          goto _L7
    }

    public static BigInteger sizeOfDirectoryAsBigInteger(File file)
    {
        File afile[];
        checkDirectory(file);
        afile = file.listFiles();
        if (afile != null) goto _L2; else goto _L1
_L1:
        Object obj = BigInteger.ZERO;
_L4:
        return ((BigInteger) (obj));
_L2:
        file = BigInteger.ZERO;
        int j = afile.length;
        int i = 0;
        do
        {
            obj = file;
            if (i >= j)
            {
                continue;
            }
            File file1 = afile[i];
            obj = file;
            try
            {
                if (!isSymlink(file1))
                {
                    obj = file.add(BigInteger.valueOf(sizeOf(file1)));
                }
            }
            catch (IOException ioexception)
            {
                ioexception = file;
            }
            i++;
            file = ((File) (obj));
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        ONE_KB_BI = BigInteger.valueOf(1024L);
        ONE_MB_BI = ONE_KB_BI.multiply(ONE_KB_BI);
        ONE_GB_BI = ONE_KB_BI.multiply(ONE_MB_BI);
        ONE_TB_BI = ONE_KB_BI.multiply(ONE_GB_BI);
        ONE_PB_BI = ONE_KB_BI.multiply(ONE_TB_BI);
        ONE_EB_BI = ONE_KB_BI.multiply(ONE_PB_BI);
        ONE_ZB = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(0x1000000000000000L));
        ONE_YB = ONE_KB_BI.multiply(ONE_ZB);
    }
}
