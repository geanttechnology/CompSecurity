// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.output.NullOutputStream;

// Referenced classes of package org.apache.commons.io:
//            IOUtils, LineIterator

public class FileUtils
{

    public static final File EMPTY_FILE_ARRAY[] = new File[0];
    public static final long ONE_GB = 0x40000000L;
    public static final long ONE_KB = 1024L;
    public static final long ONE_MB = 0x100000L;

    public FileUtils()
    {
    }

    public static String byteCountToDisplaySize(long l)
    {
        if (l / 0x40000000L > 0L)
        {
            return String.valueOf(l / 0x40000000L) + " GB";
        }
        if (l / 0x100000L > 0L)
        {
            return String.valueOf(l / 0x100000L) + " MB";
        }
        if (l / 1024L > 0L)
        {
            return String.valueOf(l / 1024L) + " KB";
        } else
        {
            return String.valueOf(l) + " bytes";
        }
    }

    public static Checksum checksum(File file, Checksum checksum1)
    {
        if (file.isDirectory())
        {
            throw new IllegalArgumentException("Checksums can't be computed on directories");
        }
        CheckedInputStream checkedinputstream = new CheckedInputStream(new FileInputStream(file), checksum1);
        IOUtils.copy(checkedinputstream, new NullOutputStream());
        IOUtils.closeQuietly(checkedinputstream);
        return checksum1;
        file;
        checksum1 = null;
_L2:
        IOUtils.closeQuietly(checksum1);
        throw file;
        file;
        checksum1 = checkedinputstream;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static long checksumCRC32(File file)
    {
        CRC32 crc32 = new CRC32();
        checksum(file, crc32);
        return crc32.getValue();
    }

    public static void cleanDirectory(File file)
    {
        if (!file.exists())
        {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory())
        {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IOException("Failed to list contents of " + file);
        }
        file = null;
        int i = 0;
        while (i < afile.length) 
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

    private static void cleanDirectoryOnExit(File file)
    {
        if (!file.exists())
        {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory())
        {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IOException("Failed to list contents of " + file);
        }
        file = null;
        int i = 0;
        while (i < afile.length) 
        {
            File file1 = afile[i];
            try
            {
                forceDeleteOnExit(file1);
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

    public static boolean contentEquals(File file, File file1)
    {
        Object obj;
        boolean flag;
        obj = null;
        flag = file.exists();
        if (flag == file1.exists()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (!flag)
        {
            return true;
        }
        if (file.isDirectory() || file1.isDirectory())
        {
            throw new IOException("Can't compare directories, only files");
        }
        if (file.length() != file1.length()) goto _L1; else goto _L3
_L3:
        if (file.getCanonicalFile().equals(file1.getCanonicalFile()))
        {
            return true;
        }
        file = new FileInputStream(file);
        file1 = new FileInputStream(file1);
        flag = IOUtils.contentEquals(file, file1);
        IOUtils.closeQuietly(file);
        IOUtils.closeQuietly(file1);
        return flag;
        file;
        file1 = null;
_L5:
        IOUtils.closeQuietly(((java.io.InputStream) (obj)));
        IOUtils.closeQuietly(file1);
        throw file;
        Exception exception;
        exception;
        file1 = null;
        obj = file;
        file = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj = file;
        file = exception;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static File[] convertFileCollectionToFileArray(Collection collection)
    {
        return (File[])(File[])collection.toArray(new File[collection.size()]);
    }

    public static void copyDirectory(File file, File file1)
    {
        copyDirectory(file, file1, true);
    }

    public static void copyDirectory(File file, File file1, boolean flag)
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
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (!file.isDirectory())
        {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        if (file.getCanonicalPath().equals(file1.getCanonicalPath()))
        {
            throw new IOException("Source '" + file + "' and destination '" + file1 + "' are the same");
        } else
        {
            doCopyDirectory(file, file1, flag);
            return;
        }
    }

    public static void copyDirectoryToDirectory(File file, File file1)
    {
        if (file == null)
        {
            throw new NullPointerException("Source must not be null");
        }
        if (file.exists() && !file.isDirectory())
        {
            throw new IllegalArgumentException("Source '" + file1 + "' is not a directory");
        }
        if (file1 == null)
        {
            throw new NullPointerException("Destination must not be null");
        }
        if (file1.exists() && !file1.isDirectory())
        {
            throw new IllegalArgumentException("Destination '" + file1 + "' is not a directory");
        } else
        {
            copyDirectory(file, new File(file1, file.getName()), true);
            return;
        }
    }

    public static void copyFile(File file, File file1)
    {
        copyFile(file, file1, true);
    }

    public static void copyFile(File file, File file1, boolean flag)
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
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory())
        {
            throw new IOException("Source '" + file + "' exists but is a directory");
        }
        if (file.getCanonicalPath().equals(file1.getCanonicalPath()))
        {
            throw new IOException("Source '" + file + "' and destination '" + file1 + "' are the same");
        }
        if (file1.getParentFile() != null && !file1.getParentFile().exists() && !file1.getParentFile().mkdirs())
        {
            throw new IOException("Destination '" + file1 + "' directory cannot be created");
        }
        if (file1.exists() && !file1.canWrite())
        {
            throw new IOException("Destination '" + file1 + "' exists but is read-only");
        } else
        {
            doCopyFile(file, file1, flag);
            return;
        }
    }

    public static void copyFileToDirectory(File file, File file1)
    {
        copyFileToDirectory(file, file1, true);
    }

    public static void copyFileToDirectory(File file, File file1, boolean flag)
    {
        if (file1 == null)
        {
            throw new NullPointerException("Destination must not be null");
        }
        if (file1.exists() && !file1.isDirectory())
        {
            throw new IllegalArgumentException("Destination '" + file1 + "' is not a directory");
        } else
        {
            copyFile(file, new File(file1, file.getName()), flag);
            return;
        }
    }

    public static void copyURLToFile(URL url, File file)
    {
        url = url.openStream();
        file = openOutputStream(file);
        IOUtils.copy(url, file);
        IOUtils.closeQuietly(file);
        IOUtils.closeQuietly(url);
        return;
        Exception exception;
        exception;
        IOUtils.closeQuietly(file);
        throw exception;
        file;
        IOUtils.closeQuietly(url);
        throw file;
    }

    public static void deleteDirectory(File file)
    {
        if (file.exists())
        {
            cleanDirectory(file);
            if (!file.delete())
            {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    private static void deleteDirectoryOnExit(File file)
    {
        if (!file.exists())
        {
            return;
        } else
        {
            cleanDirectoryOnExit(file);
            file.deleteOnExit();
            return;
        }
    }

    private static void doCopyDirectory(File file, File file1, boolean flag)
    {
        if (file1.exists())
        {
            if (!file1.isDirectory())
            {
                throw new IOException("Destination '" + file1 + "' exists but is not a directory");
            }
        } else
        {
            if (!file1.mkdirs())
            {
                throw new IOException("Destination '" + file1 + "' directory cannot be created");
            }
            if (flag)
            {
                file1.setLastModified(file.lastModified());
            }
        }
        if (!file1.canWrite())
        {
            throw new IOException("Destination '" + file1 + "' cannot be written to");
        }
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IOException("Failed to list contents of " + file);
        }
        int i = 0;
        while (i < afile.length) 
        {
            file = new File(file1, afile[i].getName());
            if (afile[i].isDirectory())
            {
                doCopyDirectory(afile[i], file, flag);
            } else
            {
                doCopyFile(afile[i], file, flag);
            }
            i++;
        }
    }

    private static void doCopyFile(File file, File file1, boolean flag)
    {
        FileInputStream fileinputstream;
        if (file1.exists() && file1.isDirectory())
        {
            throw new IOException("Destination '" + file1 + "' exists but is a directory");
        }
        fileinputstream = new FileInputStream(file);
        FileOutputStream fileoutputstream = new FileOutputStream(file1);
        IOUtils.copy(fileinputstream, fileoutputstream);
        IOUtils.closeQuietly(fileoutputstream);
        IOUtils.closeQuietly(fileinputstream);
        if (file.length() != file1.length())
        {
            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file1 + "'");
        }
        break MISSING_BLOCK_LABEL_152;
        file;
        IOUtils.closeQuietly(fileoutputstream);
        throw file;
        file;
        IOUtils.closeQuietly(fileinputstream);
        throw file;
        if (flag)
        {
            file1.setLastModified(file.lastModified());
        }
        return;
    }

    public static void forceDelete(File file)
    {
        if (file.isDirectory())
        {
            deleteDirectory(file);
        } else
        {
            if (!file.exists())
            {
                throw new FileNotFoundException("File does not exist: " + file);
            }
            if (!file.delete())
            {
                throw new IOException("Unable to delete file: " + file);
            }
        }
    }

    public static void forceDeleteOnExit(File file)
    {
        if (file.isDirectory())
        {
            deleteDirectoryOnExit(file);
            return;
        } else
        {
            file.deleteOnExit();
            return;
        }
    }

    public static void forceMkdir(File file)
    {
        if (file.exists())
        {
            if (file.isFile())
            {
                throw new IOException("File " + file + " exists and is " + "not a directory. Unable to create directory.");
            }
        } else
        if (!file.mkdirs())
        {
            throw new IOException("Unable to create directory " + file);
        }
    }

    private static void innerListFiles(Collection collection, File file, IOFileFilter iofilefilter)
    {
        file = file.listFiles(iofilefilter);
        if (file != null)
        {
            int i = 0;
            while (i < file.length) 
            {
                if (file[i].isDirectory())
                {
                    innerListFiles(collection, file[i], iofilefilter);
                } else
                {
                    collection.add(file[i]);
                }
                i++;
            }
        }
    }

    public static boolean isFileNewer(File file, long l)
    {
        if (file == null)
        {
            throw new IllegalArgumentException("No specified file");
        }
        while (!file.exists() || file.lastModified() <= l) 
        {
            return false;
        }
        return true;
    }

    public static boolean isFileNewer(File file, File file1)
    {
        if (file1 == null)
        {
            throw new IllegalArgumentException("No specified reference file");
        }
        if (!file1.exists())
        {
            throw new IllegalArgumentException("The reference file '" + file + "' doesn't exist");
        } else
        {
            return isFileNewer(file, file1.lastModified());
        }
    }

    public static boolean isFileNewer(File file, Date date)
    {
        if (date == null)
        {
            throw new IllegalArgumentException("No specified date");
        } else
        {
            return isFileNewer(file, date.getTime());
        }
    }

    public static boolean isFileOlder(File file, long l)
    {
        if (file == null)
        {
            throw new IllegalArgumentException("No specified file");
        }
        while (!file.exists() || file.lastModified() >= l) 
        {
            return false;
        }
        return true;
    }

    public static boolean isFileOlder(File file, File file1)
    {
        if (file1 == null)
        {
            throw new IllegalArgumentException("No specified reference file");
        }
        if (!file1.exists())
        {
            throw new IllegalArgumentException("The reference file '" + file + "' doesn't exist");
        } else
        {
            return isFileOlder(file, file1.lastModified());
        }
    }

    public static boolean isFileOlder(File file, Date date)
    {
        if (date == null)
        {
            throw new IllegalArgumentException("No specified date");
        } else
        {
            return isFileOlder(file, date.getTime());
        }
    }

    public static Iterator iterateFiles(File file, IOFileFilter iofilefilter, IOFileFilter iofilefilter1)
    {
        return listFiles(file, iofilefilter, iofilefilter1).iterator();
    }

    public static Iterator iterateFiles(File file, String as[], boolean flag)
    {
        return listFiles(file, as, flag).iterator();
    }

    public static LineIterator lineIterator(File file)
    {
        return lineIterator(file, null);
    }

    public static LineIterator lineIterator(File file, String s)
    {
        File file2 = null;
        File file1 = null;
        try
        {
            file = openInputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            IOUtils.closeQuietly(file1);
            throw file;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            IOUtils.closeQuietly(file2);
            throw file;
        }
        file1 = file;
        file2 = file;
        file = IOUtils.lineIterator(file, s);
        return file;
    }

    public static Collection listFiles(File file, IOFileFilter iofilefilter, IOFileFilter iofilefilter1)
    {
        if (!file.isDirectory())
        {
            throw new IllegalArgumentException("Parameter 'directory' is not a directory");
        }
        if (iofilefilter == null)
        {
            throw new NullPointerException("Parameter 'fileFilter' is null");
        }
        IOFileFilter iofilefilter2 = FileFilterUtils.andFileFilter(iofilefilter, FileFilterUtils.notFileFilter(DirectoryFileFilter.INSTANCE));
        if (iofilefilter1 == null)
        {
            iofilefilter = FalseFileFilter.INSTANCE;
        } else
        {
            iofilefilter = FileFilterUtils.andFileFilter(iofilefilter1, DirectoryFileFilter.INSTANCE);
        }
        iofilefilter1 = new LinkedList();
        innerListFiles(iofilefilter1, file, FileFilterUtils.orFileFilter(iofilefilter2, iofilefilter));
        return iofilefilter1;
    }

    public static Collection listFiles(File file, String as[], boolean flag)
    {
        IOFileFilter iofilefilter;
        if (as == null)
        {
            as = TrueFileFilter.INSTANCE;
        } else
        {
            as = new SuffixFileFilter(toSuffixes(as));
        }
        if (flag)
        {
            iofilefilter = TrueFileFilter.INSTANCE;
        } else
        {
            iofilefilter = FalseFileFilter.INSTANCE;
        }
        return listFiles(file, ((IOFileFilter) (as)), iofilefilter);
    }

    public static FileInputStream openInputStream(File file)
    {
        if (file.exists())
        {
            if (file.isDirectory())
            {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canRead())
            {
                throw new IOException("File '" + file + "' cannot be read");
            } else
            {
                return new FileInputStream(file);
            }
        } else
        {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
    }

    public static FileOutputStream openOutputStream(File file)
    {
        if (file.exists())
        {
            if (file.isDirectory())
            {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite())
            {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        } else
        {
            File file1 = file.getParentFile();
            if (file1 != null && !file1.exists() && !file1.mkdirs())
            {
                throw new IOException("File '" + file + "' could not be created");
            }
        }
        return new FileOutputStream(file);
    }

    public static byte[] readFileToByteArray(File file)
    {
        File file1 = null;
        file = openInputStream(file);
        file1 = file;
        byte abyte0[] = IOUtils.toByteArray(file);
        IOUtils.closeQuietly(file);
        return abyte0;
        file;
        IOUtils.closeQuietly(file1);
        throw file;
    }

    public static String readFileToString(File file)
    {
        return readFileToString(file, null);
    }

    public static String readFileToString(File file, String s)
    {
        File file1 = null;
        file = openInputStream(file);
        file1 = file;
        s = IOUtils.toString(file, s);
        IOUtils.closeQuietly(file);
        return s;
        file;
        IOUtils.closeQuietly(file1);
        throw file;
    }

    public static List readLines(File file)
    {
        return readLines(file, null);
    }

    public static List readLines(File file, String s)
    {
        File file1 = null;
        file = openInputStream(file);
        file1 = file;
        s = IOUtils.readLines(file, s);
        IOUtils.closeQuietly(file);
        return s;
        file;
        IOUtils.closeQuietly(file1);
        throw file;
    }

    public static long sizeOfDirectory(File file)
    {
        long l;
        l = 0L;
        if (!file.exists())
        {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory())
        {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        file = file.listFiles();
        if (file != null) goto _L2; else goto _L1
_L1:
        long l1 = l;
_L4:
        return l1;
_L2:
        int i = 0;
        do
        {
            l1 = l;
            if (i >= file.length)
            {
                continue;
            }
            File file1 = file[i];
            if (file1.isDirectory())
            {
                l += sizeOfDirectory(file1);
            } else
            {
                l += file1.length();
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static File toFile(URL url)
    {
        if (url == null || !url.getProtocol().equals("file"))
        {
            return null;
        }
        url = url.getFile().replace('/', File.separatorChar);
        int i = 0;
        do
        {
            int j = url.indexOf('%', i);
            if (j < 0)
            {
                break;
            }
            i = j;
            if (j + 2 < url.length())
            {
                char c = (char)Integer.parseInt(url.substring(j + 1, j + 3), 16);
                url = url.substring(0, j) + c + url.substring(j + 3);
                i = j;
            }
        } while (true);
        return new File(url);
    }

    public static File[] toFiles(URL aurl[])
    {
        if (aurl == null || aurl.length == 0)
        {
            return EMPTY_FILE_ARRAY;
        }
        File afile[] = new File[aurl.length];
        for (int i = 0; i < aurl.length; i++)
        {
            URL url = aurl[i];
            if (url == null)
            {
                continue;
            }
            if (!url.getProtocol().equals("file"))
            {
                throw new IllegalArgumentException("URL could not be converted to a File: " + url);
            }
            afile[i] = toFile(url);
        }

        return afile;
    }

    private static String[] toSuffixes(String as[])
    {
        String as1[] = new String[as.length];
        for (int i = 0; i < as.length; i++)
        {
            as1[i] = "." + as[i];
        }

        return as1;
    }

    public static URL[] toURLs(File afile[])
    {
        URL aurl[] = new URL[afile.length];
        for (int i = 0; i < aurl.length; i++)
        {
            aurl[i] = afile[i].toURL();
        }

        return aurl;
    }

    public static void touch(File file)
    {
        if (!file.exists())
        {
            IOUtils.closeQuietly(openOutputStream(file));
        }
        if (!file.setLastModified(System.currentTimeMillis()))
        {
            throw new IOException("Unable to set the last modification time for " + file);
        } else
        {
            return;
        }
    }

    public static boolean waitFor(File file, int i)
    {
        int j = 0;
        int k = 0;
        do
        {
            if (file.exists())
            {
                break;
            }
            if (j >= 10)
            {
                if (k > i)
                {
                    return false;
                }
                k++;
                j = 0;
            } else
            {
                j++;
            }
            try
            {
                Thread.sleep(100L);
                continue;
            }
            catch (InterruptedException interruptedexception)
            {
                continue;
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
            break;
        } while (true);
        return true;
    }

    public static void writeByteArrayToFile(File file, byte abyte0[])
    {
        File file1 = null;
        file = openOutputStream(file);
        file1 = file;
        file.write(abyte0);
        IOUtils.closeQuietly(file);
        return;
        file;
        IOUtils.closeQuietly(file1);
        throw file;
    }

    public static void writeLines(File file, String s, Collection collection)
    {
        writeLines(file, s, collection, null);
    }

    public static void writeLines(File file, String s, Collection collection, String s1)
    {
        File file1 = null;
        file = openOutputStream(file);
        file1 = file;
        IOUtils.writeLines(collection, s1, file, s);
        IOUtils.closeQuietly(file);
        return;
        file;
        IOUtils.closeQuietly(file1);
        throw file;
    }

    public static void writeLines(File file, Collection collection)
    {
        writeLines(file, null, collection, null);
    }

    public static void writeLines(File file, Collection collection, String s)
    {
        writeLines(file, null, collection, s);
    }

    public static void writeStringToFile(File file, String s)
    {
        writeStringToFile(file, s, null);
    }

    public static void writeStringToFile(File file, String s, String s1)
    {
        File file1 = null;
        file = openOutputStream(file);
        file1 = file;
        IOUtils.write(s, file, s1);
        IOUtils.closeQuietly(file);
        return;
        file;
        IOUtils.closeQuietly(file1);
        throw file;
    }

}
