// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

// Referenced classes of package com.parse:
//            ParseIOUtils

class ParseFileUtils
{

    private static final long FILE_COPY_BUFFER_SIZE = 0x1e00000L;
    public static final long ONE_KB = 1024L;
    public static final long ONE_MB = 0x100000L;

    ParseFileUtils()
    {
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

    public static boolean deleteQuietly(File file)
    {
        if (file == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            if (file.isDirectory())
            {
                cleanDirectory(file);
            }
        }
        catch (Exception exception) { }
        try
        {
            flag = file.delete();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return false;
        }
        return flag;
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
_L7:
        filechannel = filechannel3;
        filechannel1 = filechannel2;
        long l1;
        l1 = filechannel3.transferFrom(filechannel2, l, l1);
        if (l1 != 0L) goto _L3; else goto _L2
_L3:
        l += l1;
        continue; /* Loop/switch isn't completed */
        file1;
        obj = filechannel2;
        file = fileoutputstream;
_L4:
        ParseIOUtils.closeQuietly(filechannel);
        ParseIOUtils.closeQuietly(((OutputStream) (obj)));
        ParseIOUtils.closeQuietly(filechannel1);
        ParseIOUtils.closeQuietly(file);
        throw file1;
_L2:
        ParseIOUtils.closeQuietly(filechannel3);
        ParseIOUtils.closeQuietly(fileoutputstream);
        ParseIOUtils.closeQuietly(filechannel2);
        ParseIOUtils.closeQuietly(((java.io.InputStream) (obj)));
        l = file.length();
        l1 = file1.length();
        if (l != l1)
        {
            throw new IOException((new StringBuilder()).append("Failed to copy full contents from '").append(file).append("' to '").append(file1).append("' Expected length: ").append(l).append(" Actual: ").append(l1).toString());
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
        if (true) goto _L4; else goto _L1
_L1:
        if (l >= l2) goto _L2; else goto _L5
_L5:
        l1 = l2 - l;
        if (l1 > 0x1e00000L)
        {
            l1 = 0x1e00000L;
        }
        if (true) goto _L7; else goto _L6
_L6:
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
        if (file.getParent() != null)
        {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static void moveFile(File file, File file1)
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
            throw new IOException((new StringBuilder()).append("Source '").append(file).append("' is a directory").toString());
        }
        if (file1.exists())
        {
            throw new IOException((new StringBuilder()).append("Destination '").append(file1).append("' already exists").toString());
        }
        if (file1.isDirectory())
        {
            throw new IOException((new StringBuilder()).append("Destination '").append(file1).append("' is a directory").toString());
        }
        if (!file.renameTo(file1))
        {
            copyFile(file, file1);
            if (!file.delete())
            {
                deleteQuietly(file1);
                throw new IOException((new StringBuilder()).append("Failed to delete original file '").append(file).append("' after copy to '").append(file1).append("'").toString());
            }
        }
    }

    public static FileInputStream openInputStream(File file)
        throws IOException
    {
        if (file.exists())
        {
            if (file.isDirectory())
            {
                throw new IOException((new StringBuilder()).append("File '").append(file).append("' exists but is a directory").toString());
            }
            if (!file.canRead())
            {
                throw new IOException((new StringBuilder()).append("File '").append(file).append("' cannot be read").toString());
            } else
            {
                return new FileInputStream(file);
            }
        } else
        {
            throw new FileNotFoundException((new StringBuilder()).append("File '").append(file).append("' does not exist").toString());
        }
    }

    public static FileOutputStream openOutputStream(File file)
        throws IOException
    {
        if (file.exists())
        {
            if (file.isDirectory())
            {
                throw new IOException((new StringBuilder()).append("File '").append(file).append("' exists but is a directory").toString());
            }
            if (!file.canWrite())
            {
                throw new IOException((new StringBuilder()).append("File '").append(file).append("' cannot be written to").toString());
            }
        } else
        {
            File file1 = file.getParentFile();
            if (file1 != null && !file1.exists() && !file1.mkdirs())
            {
                throw new IOException((new StringBuilder()).append("File '").append(file).append("' could not be created").toString());
            }
        }
        return new FileOutputStream(file);
    }

    public static byte[] readFileToByteArray(File file)
        throws IOException
    {
        File file1 = null;
        file = openInputStream(file);
        file1 = file;
        byte abyte0[] = ParseIOUtils.toByteArray(file);
        ParseIOUtils.closeQuietly(file);
        return abyte0;
        file;
        ParseIOUtils.closeQuietly(file1);
        throw file;
    }

    public static void writeByteArrayToFile(File file, byte abyte0[])
        throws IOException
    {
        File file1 = null;
        file = openOutputStream(file);
        file1 = file;
        file.write(abyte0);
        ParseIOUtils.closeQuietly(file);
        return;
        file;
        ParseIOUtils.closeQuietly(file1);
        throw file;
    }
}
